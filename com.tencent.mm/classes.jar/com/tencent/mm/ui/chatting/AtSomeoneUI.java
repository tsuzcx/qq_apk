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
import com.tencent.mm.am.n;
import com.tencent.mm.cd.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.c;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.MaskLayout.a;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI
  extends MMActivity
{
  private static boolean GgF = false;
  private a GkD;
  private com.tencent.mm.storage.w fql;
  private String fvG;
  private String fvH;
  private r fvI;
  private ListView iwH;
  private String mTitle;
  private String talker;
  
  protected static String a(com.tencent.mm.storage.w paramw, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramw == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramw = paramw.sh(paramString);
    AppMethodBeat.o(34253);
    return paramw;
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
    this.fvI = new r((byte)0);
    this.fvI.Htp = new r.b()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).pa(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void aIj()
      {
        AppMethodBeat.i(34240);
        ad.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34238);
            if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
              AtSomeoneUI.a(AtSomeoneUI.this).pa("");
            }
            AppMethodBeat.o(34238);
          }
        });
        AppMethodBeat.o(34240);
      }
      
      public final void aIk() {}
      
      public final void aIl() {}
      
      public final void aIm() {}
    };
    addSearchMenu(true, this.fvI);
    this.iwH = ((ListView)findViewById(2131297967));
    af localaf = new af();
    com.tencent.mm.storage.w localw = this.fql;
    Object localObject1 = null;
    if (!bt.isNullOrNil(this.fvH))
    {
      localObject1 = this.fvH.split(",");
      ad.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.fql != null)
      {
        ad.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = bt.n(this.fql.awt(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.fql != null) {
        break label314;
      }
    }
    for (;;)
    {
      ad.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!bt.isNullOrNil(this.fvG)) {
        localObject1 = bt.S(this.fvG.split(","));
      }
      az.arV();
      br localbr = c.apU().agP("@t.qq.com");
      if (localbr != null) {
        ((List)localObject1).add(localbr.name);
      }
      this.GkD = new a(this, localaf, localw, (String[])localObject2, (List)localObject1);
      this.iwH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          int i = 1;
          AppMethodBeat.i(34241);
          Intent localIntent = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.GgF))
          {
            localIntent.putExtra("Select_Conv_User", AtSomeoneUI.this.getString(2131756080, new Object[] { "" }));
            localIntent.putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, localIntent);
            AtSomeoneUI.this.finish();
            AppMethodBeat.o(34241);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.GgF) {}
          for (;;)
          {
            af localaf = (af)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localaf.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (bt.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localaf.ZW();
            }
            localIntent.putExtra("select_raw_user_name", localaf.field_username);
            localIntent.putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
            i = 0;
          }
        }
      });
      this.iwH.setAdapter(this.GkD);
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
    this.fvG = getIntent().getStringExtra("Block_list");
    this.fvH = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    az.arV();
    this.fql = c.apV().tH(this.talker);
    if ((this.fql != null) && (this.fql.field_roomowner.equals(u.aqG()))) {
      GgF = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.GkD.cHX();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.fvI != null) {
      this.fvI.fdW();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends q<af>
  {
    private String[] GgH;
    private Bitmap GgI;
    private com.tencent.mm.storage.w fql;
    private List<String> fvP;
    private String fvQ;
    
    public a(Context paramContext, af paramaf, com.tencent.mm.storage.w paramw, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramaf);
      AppMethodBeat.i(34242);
      this.fql = paramw;
      this.GgH = paramArrayOfString;
      this.fvP = paramList;
      this.GgI = f.B(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(34242);
    }
    
    public final boolean EJ(int paramInt)
    {
      return false;
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(34245);
      az.arV();
      bg localbg = c.apM();
      String[] arrayOfString1 = this.GgH;
      String str1 = this.fvQ;
      String str2 = this.fvQ;
      Object localObject;
      if ((this.fql == null) || (str2 == null) || (this.GgH == null))
      {
        localObject = null;
        setCursor(localbg.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.fvP));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.GgH;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.fql.sh((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(34246);
      cHX();
      Wd();
      AppMethodBeat.o(34246);
    }
    
    public final int cEn()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.GgF)
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
        paramViewGroup.fwD = ((MaskLayout)localView.findViewById(2131296957));
        paramViewGroup.fsI = ((TextView)localView.findViewById(2131296958));
        paramViewGroup.GgJ = ((ImageView)localView.findViewById(2131298739));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.GgF))
      {
        paramViewGroup.GgJ.setImageBitmap(this.GgI);
        paramViewGroup.fsI.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      af localaf;
      if (AtSomeoneUI.GgF)
      {
        i = 1;
        localaf = (af)getItem(paramInt - i);
        paramView = paramViewGroup.fsI;
        Context localContext = this.context;
        if (com.tencent.mm.model.w.to(localaf.field_username)) {
          break label371;
        }
        paramInt = 2131100638;
        label196:
        paramView.setTextColor(a.m(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.fwD.getContentView(), localaf.field_username);
        if (localaf.field_verifyFlag == 0) {
          break label400;
        }
        if (ar.a.gMY == null) {
          break label389;
        }
        paramView = ar.a.gMY.ne(localaf.field_verifyFlag);
        if (paramView == null) {
          break label378;
        }
        paramView = n.xb(paramView);
        paramViewGroup.fwD.a(paramView, MaskLayout.a.Gbv);
        label272:
        if (bt.isNullOrNil(localaf.field_conRemark)) {
          break label411;
        }
        paramView = localaf.field_conRemark;
        label289:
        if (!bt.isNullOrNil(paramView)) {
          break label452;
        }
        paramView = localaf.ZW();
      }
      label389:
      label400:
      label411:
      label452:
      for (;;)
      {
        if (af.aHH(localaf.field_username)) {
          ((b)g.ab(b.class)).a(paramViewGroup.fsI.getContext(), paramViewGroup.fsI, paramView, localaf.field_openImAppid, localaf.field_descWordingId, (int)paramViewGroup.fsI.getTextSize());
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
          paramViewGroup.fwD.setMaskDrawable(null);
          break label272;
          paramViewGroup.fwD.setMaskDrawable(null);
          break label272;
          paramViewGroup.fwD.setMaskDrawable(null);
          break label272;
          paramView = AtSomeoneUI.a(this.fql, localaf.field_username);
          break label289;
          paramViewGroup.fsI.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.context, paramView, paramViewGroup.fsI.getTextSize()));
        }
      }
    }
    
    public final void pa(String paramString)
    {
      AppMethodBeat.i(34247);
      this.fvQ = paramString;
      a(null, null);
      AppMethodBeat.o(34247);
    }
  }
  
  static final class b
  {
    public ImageView GgJ;
    public TextView fsI;
    public MaskLayout fwD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */