package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.cc.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean HGv = false;
  private a HKs;
  private x ftP;
  private String fzn;
  private String fzo;
  private com.tencent.mm.ui.tools.r fzp;
  private ListView iWK;
  private String mTitle;
  private String talker;
  
  protected static String a(x paramx, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramx == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramx = paramx.wk(paramString);
    AppMethodBeat.o(34253);
    return paramx;
  }
  
  public int getLayoutId()
  {
    return 2131493116;
  }
  
  public void initView()
  {
    boolean bool = true;
    AppMethodBeat.i(34250);
    setMMTitle(this.mTitle);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34237);
        AtSomeoneUI.this.setResult(0);
        AtSomeoneUI.this.finish();
        AppMethodBeat.o(34237);
        return true;
      }
    });
    this.fzp = new com.tencent.mm.ui.tools.r((byte)0);
    this.fzp.ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).sm(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void aPa()
      {
        AppMethodBeat.i(34240);
        ac.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34238);
            if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
              AtSomeoneUI.a(AtSomeoneUI.this).sm("");
            }
            AppMethodBeat.o(34238);
          }
        });
        AppMethodBeat.o(34240);
      }
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, this.fzp);
    this.iWK = ((ListView)findViewById(2131297967));
    ai localai = new ai();
    x localx = this.ftP;
    Object localObject1 = null;
    if (!bs.isNullOrNil(this.fzo))
    {
      localObject1 = this.fzo.split(",");
      ac.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.ftP != null)
      {
        ac.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = bs.n(this.ftP.aDl(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.ftP != null) {
        break label314;
      }
    }
    for (;;)
    {
      ac.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!bs.isNullOrNil(this.fzn)) {
        localObject1 = bs.S(this.fzn.split(","));
      }
      az.ayM();
      bu localbu = c.awJ().alJ("@t.qq.com");
      if (localbu != null) {
        ((List)localObject1).add(localbu.name);
      }
      this.HKs = new a(this, localai, localx, (String[])localObject2, (List)localObject1);
      this.iWK.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(34241);
          Intent localIntent = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.HGv))
          {
            localIntent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(2131756080, new Object[] { "" }));
            localIntent.putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, localIntent);
            AtSomeoneUI.this.finish();
            AppMethodBeat.o(34241);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.HGv) {}
          for (;;)
          {
            ai localai = (ai)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localai.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (bs.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localai.aaR();
            }
            localIntent.putExtra("select_raw_user_name", localai.field_username);
            localIntent.putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
            i = 0;
          }
        }
      });
      this.iWK.setAdapter(this.HKs);
      AppMethodBeat.o(34250);
      return;
      label314:
      bool = false;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34249);
    super.onCreate(paramBundle);
    this.fzn = getIntent().getStringExtra("Block_list");
    this.fzo = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    az.ayM();
    this.ftP = c.awK().xN(this.talker);
    if ((this.ftP != null) && (this.ftP.field_roomowner.equals(u.axw()))) {
      HGv = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.HKs.cVi();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.fzp != null) {
      this.fzp.ftR();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.r<ai>
  {
    private String[] HGx;
    private Bitmap HGy;
    private x ftP;
    private List<String> fzw;
    private String fzx;
    
    public a(Context paramContext, ai paramai, x paramx, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramai);
      AppMethodBeat.i(34242);
      this.ftP = paramx;
      this.HGx = paramArrayOfString;
      this.fzw = paramList;
      this.HGy = f.A(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(34242);
    }
    
    public final boolean GF(int paramInt)
    {
      return false;
    }
    
    public final void Xb()
    {
      AppMethodBeat.i(34245);
      az.ayM();
      bj localbj = c.awB();
      String[] arrayOfString1 = this.HGx;
      String str1 = this.fzx;
      String str2 = this.fzx;
      Object localObject;
      if ((this.ftP == null) || (str2 == null) || (this.HGx == null))
      {
        localObject = null;
        setCursor(localbj.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.fzw));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.HGx;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.ftP.wk((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(34246);
      cVi();
      Xb();
      AppMethodBeat.o(34246);
    }
    
    public final int cRx()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.HGv)
      {
        AppMethodBeat.o(34243);
        return 1;
      }
      AppMethodBeat.o(34243);
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(34244);
      View localView;
      if (paramView == null)
      {
        localView = View.inflate(this.context, 2131493115, null);
        paramViewGroup = new AtSomeoneUI.b((byte)0);
        paramViewGroup.fAk = ((MaskLayout)localView.findViewById(2131296957));
        paramViewGroup.fwp = ((TextView)localView.findViewById(2131296958));
        paramViewGroup.HGz = ((ImageView)localView.findViewById(2131298739));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.HGv))
      {
        paramViewGroup.HGz.setImageBitmap(this.HGy);
        paramViewGroup.fwp.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      ai localai;
      if (AtSomeoneUI.HGv)
      {
        i = 1;
        localai = (ai)getItem(paramInt - i);
        paramView = paramViewGroup.fwp;
        Context localContext = this.context;
        if (w.xr(localai.field_username)) {
          break label371;
        }
        paramInt = 2131100638;
        label196:
        paramView.setTextColor(a.m(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.fAk.getContentView(), localai.field_username);
        if (localai.field_verifyFlag == 0) {
          break label400;
        }
        if (ar.a.hny == null) {
          break label389;
        }
        paramView = ar.a.hny.nS(localai.field_verifyFlag);
        if (paramView == null) {
          break label378;
        }
        paramView = n.Bh(paramView);
        paramViewGroup.fAk.a(paramView, MaskLayout.a.HBk);
        label272:
        if (bs.isNullOrNil(localai.field_conRemark)) {
          break label411;
        }
        paramView = localai.field_conRemark;
        label289:
        if (!bs.isNullOrNil(paramView)) {
          break label452;
        }
        paramView = localai.aaR();
      }
      label389:
      label400:
      label411:
      label452:
      for (;;)
      {
        if (ai.aNc(localai.field_username)) {
          ((b)g.ab(b.class)).a(paramViewGroup.fwp.getContext(), paramViewGroup.fwp, paramView, localai.field_openImAppid, localai.field_descWordingId, (int)paramViewGroup.fwp.getTextSize());
        }
        for (;;)
        {
          AppMethodBeat.o(34244);
          return localView;
          i = 0;
          break;
          label371:
          paramInt = 2131100639;
          break label196;
          label378:
          paramViewGroup.fAk.setMaskDrawable(null);
          break label272;
          paramViewGroup.fAk.setMaskDrawable(null);
          break label272;
          paramViewGroup.fAk.setMaskDrawable(null);
          break label272;
          paramView = AtSomeoneUI.a(this.ftP, localai.field_username);
          break label289;
          paramViewGroup.fwp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, paramViewGroup.fwp.getTextSize()));
        }
      }
    }
    
    public final void sm(String paramString)
    {
      AppMethodBeat.i(34247);
      this.fzx = paramString;
      a(null, null);
      AppMethodBeat.o(34247);
    }
  }
  
  static final class b
  {
    public ImageView HGz;
    public MaskLayout fAk;
    public TextView fwp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */