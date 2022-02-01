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
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.c;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.cb;
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
  private static boolean JPb = false;
  private a JSZ;
  private ac fNS;
  private String fUG;
  private String fUH;
  private com.tencent.mm.ui.tools.r fUI;
  private ListView jsM;
  private String mTitle;
  private String talker;
  
  protected static String a(ac paramac, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramac == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramac = paramac.zP(paramString);
    AppMethodBeat.o(34253);
    return paramac;
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
    this.fUI = new com.tencent.mm.ui.tools.r((byte)0);
    this.fUI.Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).vx(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void aSL()
      {
        AppMethodBeat.i(34240);
        ae.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34238);
            if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
              AtSomeoneUI.a(AtSomeoneUI.this).vx("");
            }
            AppMethodBeat.o(34238);
          }
        });
        AppMethodBeat.o(34240);
      }
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO() {}
    };
    addSearchMenu(true, this.fUI);
    this.jsM = ((ListView)findViewById(2131297967));
    an localan = new an();
    ac localac = this.fNS;
    Object localObject1 = null;
    if (!bu.isNullOrNil(this.fUH))
    {
      localObject1 = this.fUH.split(",");
      ae.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.fNS != null)
      {
        ae.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = bu.m(this.fNS.aGE(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.fNS != null) {
        break label314;
      }
    }
    for (;;)
    {
      ae.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!bu.isNullOrNil(this.fUG)) {
        localObject1 = bu.U(this.fUG.split(","));
      }
      bc.aCg();
      cb localcb = c.azO().arD("@t.qq.com");
      if (localcb != null) {
        ((List)localObject1).add(localcb.name);
      }
      this.JSZ = new a(this, localan, localac, (String[])localObject2, (List)localObject1);
      this.jsM.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34241);
          Object localObject = new b();
          ((b)localObject).bd(paramAnonymousAdapterView);
          ((b)localObject).bd(paramAnonymousView);
          ((b)localObject).mu(paramAnonymousInt);
          ((b)localObject).rl(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
          localObject = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.JPb))
          {
            ((Intent)localObject).putExtra("Select_Conv_User", AtSomeoneUI.this.getString(2131756080, new Object[] { "" }));
            ((Intent)localObject).putExtra("select_raw_user_name", "notify@all");
            AtSomeoneUI.this.setResult(-1, (Intent)localObject);
            AtSomeoneUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(34241);
            return;
          }
          paramAnonymousAdapterView = AtSomeoneUI.a(AtSomeoneUI.this);
          if (AtSomeoneUI.JPb) {}
          for (int i = 1;; i = 0)
          {
            an localan = (an)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localan.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (bu.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localan.adF();
            }
            ((Intent)localObject).putExtra("select_raw_user_name", localan.field_username);
            ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
          }
        }
      });
      this.jsM.setAdapter(this.JSZ);
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
    this.fUG = getIntent().getStringExtra("Block_list");
    this.fUH = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    bc.aCg();
    this.fNS = c.azP().Bx(this.talker);
    if ((this.fNS != null) && (this.fNS.field_roomowner.equals(v.aAC()))) {
      JPb = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.JSZ.dhl();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.fUI != null) {
      this.fUI.fOV();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.r<an>
  {
    private String[] JPd;
    private Bitmap JPe;
    private ac fNS;
    private List<String> fUR;
    private String fUS;
    
    public a(Context paramContext, an paraman, ac paramac, String[] paramArrayOfString, List<String> paramList)
    {
      super(paraman);
      AppMethodBeat.i(34242);
      this.fNS = paramac;
      this.JPd = paramArrayOfString;
      this.fUR = paramList;
      this.JPe = h.B(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(34242);
    }
    
    public final boolean Iw(int paramInt)
    {
      return false;
    }
    
    public final void ZD()
    {
      AppMethodBeat.i(34245);
      bc.aCg();
      bq localbq = c.azF();
      String[] arrayOfString1 = this.JPd;
      String str1 = this.fUS;
      String str2 = this.fUS;
      Object localObject;
      if ((this.fNS == null) || (str2 == null) || (this.JPd == null))
      {
        localObject = null;
        setCursor(localbq.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.fUR));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.JPd;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.fNS.zP((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void ZE()
    {
      AppMethodBeat.i(34246);
      dhl();
      ZD();
      AppMethodBeat.o(34246);
    }
    
    public final int dcN()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.JPb)
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
        paramViewGroup.fVG = ((MaskLayout)localView.findViewById(2131296957));
        paramViewGroup.fRI = ((TextView)localView.findViewById(2131296958));
        paramViewGroup.JPf = ((ImageView)localView.findViewById(2131298739));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.JPb))
      {
        paramViewGroup.JPf.setImageBitmap(this.JPe);
        paramViewGroup.fRI.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      an localan;
      if (AtSomeoneUI.JPb)
      {
        i = 1;
        localan = (an)getItem(paramInt - i);
        paramView = paramViewGroup.fRI;
        Context localContext = this.context;
        if (x.AZ(localan.field_username)) {
          break label371;
        }
        paramInt = 2131100638;
        label196:
        paramView.setTextColor(com.tencent.mm.cb.a.m(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.fVG.getContentView(), localan.field_username);
        if (localan.field_verifyFlag == 0) {
          break label400;
        }
        if (au.a.hII == null) {
          break label389;
        }
        paramView = au.a.hII.ov(localan.field_verifyFlag);
        if (paramView == null) {
          break label378;
        }
        paramView = o.EI(paramView);
        paramViewGroup.fVG.a(paramView, MaskLayout.a.JJQ);
        label272:
        if (bu.isNullOrNil(localan.field_conRemark)) {
          break label411;
        }
        paramView = localan.field_conRemark;
        label289:
        if (!bu.isNullOrNil(paramView)) {
          break label452;
        }
        paramView = localan.adF();
      }
      label389:
      label400:
      label411:
      label452:
      for (;;)
      {
        if (an.aUq(localan.field_username)) {
          ((com.tencent.mm.openim.a.a)g.ab(com.tencent.mm.openim.a.a.class)).a(paramViewGroup.fRI.getContext(), paramViewGroup.fRI, paramView, localan.field_openImAppid, localan.field_descWordingId, (int)paramViewGroup.fRI.getTextSize());
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
          paramViewGroup.fVG.setMaskDrawable(null);
          break label272;
          paramViewGroup.fVG.setMaskDrawable(null);
          break label272;
          paramViewGroup.fVG.setMaskDrawable(null);
          break label272;
          paramView = AtSomeoneUI.a(this.fNS, localan.field_username);
          break label289;
          paramViewGroup.fRI.setText(k.b(this.context, paramView, paramViewGroup.fRI.getTextSize()));
        }
      }
    }
    
    public final void vx(String paramString)
    {
      AppMethodBeat.i(34247);
      this.fUS = paramString;
      a(null, null);
      AppMethodBeat.o(34247);
    }
  }
  
  static final class b
  {
    public ImageView JPf;
    public TextView fRI;
    public MaskLayout fVG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */