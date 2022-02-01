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
import com.tencent.mm.am.o;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.c;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.ca;
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
  private static boolean Jum = false;
  private a Jyj;
  private ab fLO;
  private String fSA;
  private String fSB;
  private com.tencent.mm.ui.tools.r fSC;
  private ListView jpT;
  private String mTitle;
  private String talker;
  
  protected static String a(ab paramab, String paramString)
  {
    AppMethodBeat.i(34253);
    if (paramab == null)
    {
      AppMethodBeat.o(34253);
      return null;
    }
    paramab = paramab.zf(paramString);
    AppMethodBeat.o(34253);
    return paramab;
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
    this.fSC = new com.tencent.mm.ui.tools.r((byte)0);
    this.fSC.KKQ = new r.b()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(34239);
        AtSomeoneUI.a(AtSomeoneUI.this).vb(paramAnonymousString);
        AppMethodBeat.o(34239);
      }
      
      public final void aSm()
      {
        AppMethodBeat.i(34240);
        ad.d("MicroMsg.AtSomeoneUI", "onQuitSearch()");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(34238);
            if (AtSomeoneUI.a(AtSomeoneUI.this) != null) {
              AtSomeoneUI.a(AtSomeoneUI.this).vb("");
            }
            AppMethodBeat.o(34238);
          }
        });
        AppMethodBeat.o(34240);
      }
      
      public final void aSn() {}
      
      public final void aSo() {}
      
      public final void aSp() {}
    };
    addSearchMenu(true, this.fSC);
    this.jpT = ((ListView)findViewById(2131297967));
    am localam = new am();
    ab localab = this.fLO;
    Object localObject1 = null;
    if (!bt.isNullOrNil(this.fSB))
    {
      localObject1 = this.fSB.split(",");
      ad.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", new Object[] { Arrays.toString((Object[])localObject1) });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (this.fLO != null)
      {
        ad.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
        localObject2 = bt.m(this.fLO.aGo(), ",").split(",");
      }
    }
    if (localObject2 == null) {
      if (this.fLO != null) {
        break label314;
      }
    }
    for (;;)
    {
      ad.e("MicroMsg.AtSomeoneUI", "WTF! member is null? %s", new Object[] { Boolean.valueOf(bool) });
      localObject1 = new LinkedList();
      if (!bt.isNullOrNil(this.fSA)) {
        localObject1 = bt.U(this.fSA.split(","));
      }
      ba.aBQ();
      ca localca = c.azy().aqy("@t.qq.com");
      if (localca != null) {
        ((List)localObject1).add(localca.name);
      }
      this.Jyj = new a(this, localam, localab, (String[])localObject2, (List)localObject1);
      this.jpT.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(34241);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
          ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/AtSomeoneUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
          localObject = new Intent();
          if ((paramAnonymousInt == 0) && (AtSomeoneUI.Jum))
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
          if (AtSomeoneUI.Jum) {}
          for (int i = 1;; i = 0)
          {
            am localam = (am)paramAnonymousAdapterView.getItem(paramAnonymousInt - i);
            paramAnonymousView = AtSomeoneUI.a(AtSomeoneUI.b(AtSomeoneUI.this), localam.field_username);
            paramAnonymousAdapterView = paramAnonymousView;
            if (bt.isNullOrNil(paramAnonymousView)) {
              paramAnonymousAdapterView = localam.adu();
            }
            ((Intent)localObject).putExtra("select_raw_user_name", localam.field_username);
            ((Intent)localObject).putExtra("Select_Conv_User", paramAnonymousAdapterView);
            break;
          }
        }
      });
      this.jpT.setAdapter(this.Jyj);
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
    this.fSA = getIntent().getStringExtra("Block_list");
    this.fSB = getIntent().getStringExtra("Chatroom_member_list");
    this.talker = getIntent().getStringExtra("Chat_User");
    this.mTitle = getIntent().getStringExtra("Add_address_titile");
    ba.aBQ();
    this.fLO = c.azz().AN(this.talker);
    if ((this.fLO != null) && (this.fLO.field_roomowner.equals(u.aAm()))) {
      Jum = false;
    }
    initView();
    AppMethodBeat.o(34249);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34252);
    this.Jyj.det();
    super.onDestroy();
    AppMethodBeat.o(34252);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34251);
    super.onPause();
    if (this.fSC != null) {
      this.fSC.fKE();
    }
    AppMethodBeat.o(34251);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
    extends com.tencent.mm.ui.r<am>
  {
    private String[] Juo;
    private Bitmap Jup;
    private ab fLO;
    private List<String> fSL;
    private String fSM;
    
    public a(Context paramContext, am paramam, ab paramab, String[] paramArrayOfString, List<String> paramList)
    {
      super(paramam);
      AppMethodBeat.i(34242);
      this.fLO = paramab;
      this.Juo = paramArrayOfString;
      this.fSL = paramList;
      this.Jup = com.tencent.mm.sdk.platformtools.g.A(paramContext.getResources().getDrawable(2131689712));
      AppMethodBeat.o(34242);
    }
    
    public final boolean HY(int paramInt)
    {
      return false;
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(34245);
      ba.aBQ();
      bp localbp = c.azp();
      String[] arrayOfString1 = this.Juo;
      String str1 = this.fSM;
      String str2 = this.fSM;
      Object localObject;
      if ((this.fLO == null) || (str2 == null) || (this.Juo == null))
      {
        localObject = null;
        setCursor(localbp.a(arrayOfString1, "@all.chatroom", str1, (List)localObject, this.fSL));
        super.notifyDataSetChanged();
        AppMethodBeat.o(34245);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString2 = this.Juo;
      int j = arrayOfString2.length;
      int i = 0;
      for (;;)
      {
        localObject = localArrayList;
        if (i >= j) {
          break;
        }
        localObject = arrayOfString2[i];
        String str3 = this.fLO.zf((String)localObject);
        if ((str3 != null) && (str3.contains(str2))) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(34246);
      det();
      Zu();
      AppMethodBeat.o(34246);
    }
    
    public final int dac()
    {
      AppMethodBeat.i(34243);
      if (AtSomeoneUI.Jum)
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
        paramViewGroup.fTA = ((MaskLayout)localView.findViewById(2131296957));
        paramViewGroup.fPC = ((TextView)localView.findViewById(2131296958));
        paramViewGroup.Juq = ((ImageView)localView.findViewById(2131298739));
        localView.setTag(paramViewGroup);
      }
      while ((paramInt == 0) && (AtSomeoneUI.Jum))
      {
        paramViewGroup.Juq.setImageBitmap(this.Jup);
        paramViewGroup.fPC.setText(this.context.getResources().getString(2131756080, new Object[] { "@" }));
        AppMethodBeat.o(34244);
        return localView;
        paramViewGroup = (AtSomeoneUI.b)paramView.getTag();
        localView = paramView;
      }
      int i;
      am localam;
      if (AtSomeoneUI.Jum)
      {
        i = 1;
        localam = (am)getItem(paramInt - i);
        paramView = paramViewGroup.fPC;
        Context localContext = this.context;
        if (w.Ap(localam.field_username)) {
          break label371;
        }
        paramInt = 2131100638;
        label196:
        paramView.setTextColor(com.tencent.mm.cc.a.m(localContext, paramInt));
        a.b.c((ImageView)paramViewGroup.fTA.getContentView(), localam.field_username);
        if (localam.field_verifyFlag == 0) {
          break label400;
        }
        if (as.a.hFQ == null) {
          break label389;
        }
        paramView = as.a.hFQ.os(localam.field_verifyFlag);
        if (paramView == null) {
          break label378;
        }
        paramView = o.Eg(paramView);
        paramViewGroup.fTA.a(paramView, MaskLayout.a.Jpb);
        label272:
        if (bt.isNullOrNil(localam.field_conRemark)) {
          break label411;
        }
        paramView = localam.field_conRemark;
        label289:
        if (!bt.isNullOrNil(paramView)) {
          break label452;
        }
        paramView = localam.adu();
      }
      label389:
      label400:
      label411:
      label452:
      for (;;)
      {
        if (am.aSQ(localam.field_username)) {
          ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(paramViewGroup.fPC.getContext(), paramViewGroup.fPC, paramView, localam.field_openImAppid, localam.field_descWordingId, (int)paramViewGroup.fPC.getTextSize());
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
          paramViewGroup.fTA.setMaskDrawable(null);
          break label272;
          paramViewGroup.fTA.setMaskDrawable(null);
          break label272;
          paramViewGroup.fTA.setMaskDrawable(null);
          break label272;
          paramView = AtSomeoneUI.a(this.fLO, localam.field_username);
          break label289;
          paramViewGroup.fPC.setText(k.b(this.context, paramView, paramViewGroup.fPC.getTextSize()));
        }
      }
    }
    
    public final void vb(String paramString)
    {
      AppMethodBeat.i(34247);
      this.fSM = paramString;
      a(null, null);
      AppMethodBeat.o(34247);
    }
  }
  
  static final class b
  {
    public ImageView Juq;
    public TextView fPC;
    public MaskLayout fTA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AtSomeoneUI
 * JD-Core Version:    0.7.0.1
 */