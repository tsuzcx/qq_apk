package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.b.a.dm;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.y.a;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements f, k.a
{
  private ContactCountView KjK;
  private com.tencent.mm.ui.voicesearch.b Kjw;
  private String Kjy;
  private VoiceSearchLayout KkS;
  private View KkT;
  private com.tencent.mm.modelvoiceaddr.ui.b KkU;
  private d KkV;
  private com.tencent.mm.pluginsdk.ui.e fMX;
  private TextView gWP;
  private int nYw;
  private int nYx;
  private com.tencent.mm.ui.widget.b.a nZK;
  private n.e qlC;
  private ListView uXc;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.nYw = 0;
    this.nYx = 0;
    this.qlC = new n.e()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(37691);
        switch (paramAnonymousMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(37691);
          return;
        }
        ChatroomContactUI.aWN(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.fMX = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void dfw()
  {
    AppMethodBeat.i(37715);
    if (this.KkV != null) {
      this.KkV.a(null, null);
    }
    if (this.Kjw != null) {
      this.Kjw.a(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(37717);
    if (this.KjK != null)
    {
      this.KjK.setContactType(2);
      this.KjK.fHK();
    }
    AppMethodBeat.o(37717);
  }
  
  public int getLayoutId()
  {
    return 2131493370;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37711);
    ((TextView)findViewById(2131299481)).setVisibility(8);
    this.uXc = ((ListView)findViewById(2131296471));
    this.uXc.setAdapter(null);
    this.gWP = ((TextView)findViewById(2131299481));
    this.gWP.setText(2131755194);
    this.KkT = findViewById(2131306014);
    this.KkT.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/contact/ChatroomContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.KkV = new d(this, "@all.chatroom.contact");
    this.KkV.xk(true);
    this.Kjw = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Kjw.KiP = "@all.chatroom.contact";
    this.KkU = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.KkU.a(new b.a()
    {
      public final boolean Jp(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Jq(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        ad.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = bt.aQN(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(37698);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(37702);
        ad.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37702);
          return;
        }
        Object localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.getContext().getString(2131759511));
        ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
        paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void aOh()
      {
        AppMethodBeat.i(37701);
        ad.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void aSm()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).yH(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void aSn()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void aSo() {}
      
      public final void aSp() {}
    });
    addSearchMenu(true, this.KkU);
    this.KkV.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.KkV.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.KkV.a(new MMSlideDelView.f()
    {
      public final void cP(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.aWN(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.uXc.setOnScrollListener(this.fMX);
    this.KkV.EWt = this.fMX;
    this.nZK = new com.tencent.mm.ui.widget.b.a(getContext());
    this.uXc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).KPF))
        {
          ad.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).KPF))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).HY(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).aeX(paramAnonymousInt);
          ad.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null)
            {
              paramAnonymousAdapterView = "";
              paramAnonymousView.aXz(paramAnonymousAdapterView);
            }
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(37706);
            return;
            paramAnonymousAdapterView = ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent();
            break;
            if (bool1)
            {
              paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).aeW(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.GbY.HoB;
              ba.aBQ();
              localObject = c.azp().Bf(paramAnonymousAdapterView);
              if (com.tencent.mm.o.b.lM(((aw)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((am)localObject).fqg()) {
                    g.yhR.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.bs.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.GbY.HoB);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.jdh);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.GKC.HoB);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.jdf);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bf(paramAnonymousView.jdl, paramAnonymousView.jdd, paramAnonymousView.jde));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.jdc);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.GNV);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.GNU);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.GNY);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.GNW);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.GNX);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.GOa.jdn);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.GOa.jdp);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.GOa.jdo);
                if (paramAnonymousView.GOb != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.GOb.toByteArray());
                  if ((paramAnonymousView.GNU & 0x8) > 0) {
                    g.yhR.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.bs.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ad.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).FC(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ad.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
                return;
              }
              ac.u(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (w.zl(paramAnonymousAdapterView))
              {
                paramAnonymousView = new dm();
                paramAnonymousView.mS(paramAnonymousAdapterView);
                paramAnonymousView.dUW = 2L;
                paramAnonymousView.aLk();
              }
              paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
              paramAnonymousView.addFlags(67108864);
              paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Chat_Mode", 1);
              paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mq(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        paramAnonymousAdapterView = (am)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        if (w.zl(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new dm();
          paramAnonymousView.mS(paramAnonymousAdapterView.field_username);
          paramAnonymousView.dUW = 2L;
          paramAnonymousView.aLk();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37706);
      }
    });
    this.uXc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37707);
        ad.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount())
        {
          ad.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
          AppMethodBeat.o(37707);
          return true;
        }
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).KPF))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = (am)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          ad.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37707);
          return false;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((w.Ad(paramAnonymousAdapterView)) || (w.Ae(paramAnonymousAdapterView)))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        ChatroomContactUI.c(ChatroomContactUI.this, paramAnonymousAdapterView);
        ChatroomContactUI.k(ChatroomContactUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, ChatroomContactUI.this, ChatroomContactUI.h(ChatroomContactUI.this), ChatroomContactUI.i(ChatroomContactUI.this), ChatroomContactUI.j(ChatroomContactUI.this));
        AppMethodBeat.o(37707);
        return true;
      }
    });
    this.uXc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37692);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          if (ChatroomContactUI.c(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.c(ChatroomContactUI.this);
            if (paramAnonymousView.jdB != null) {
              paramAnonymousView.jdB.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.jdB != null) {
              paramAnonymousView.jdB.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/contact/ChatroomContactUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(37692);
          return false;
          ChatroomContactUI.this.hideVKB();
          ChatroomContactUI.a(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawX());
          ChatroomContactUI.b(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    Object localObject = this.uXc;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.KjK = localContactCountView;
    ((ListView)localObject).addFooterView(localContactCountView, null, false);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(37693);
        ChatroomContactUI.this.finish();
        AppMethodBeat.o(37693);
        return false;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37694);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.uXc.setAdapter(this.KkV);
    this.Kjw.yH(false);
    this.uXc.setVisibility(0);
    this.KkS = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.KkS.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.KkS.setTopMargin(BackwardSupportUtil.b.g(this, 100.0F));
    this.KkS.setVisibility(8);
    ((ViewGroup)findViewById(2131306550)).addView(this.KkS);
    if (this.KkS != null) {
      this.KkS.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void fe(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37696);
          ad.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(paramAnonymousBoolean)));
          if (paramAnonymousBoolean)
          {
            int i = ChatroomContactUI.d(ChatroomContactUI.this).getFirstVisiblePosition();
            ad.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(i)));
            if (i > 0) {
              ChatroomContactUI.d(ChatroomContactUI.this).post(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(37695);
                  ChatroomContactUI.d(ChatroomContactUI.this).setSelection(0);
                  AppMethodBeat.o(37695);
                }
              });
            }
          }
          AppMethodBeat.o(37696);
        }
      });
    }
    if (this.KkV.getCount() == 0)
    {
      this.gWP.setSingleLine(false);
      this.gWP.setPadding(40, 0, 40, 0);
      this.gWP.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(2131755178);
    initView();
    ba.aiU().a(138, this);
    ba.aBQ();
    c.azp().a(this.KkV);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    ba.aBQ();
    if (c.azp().Bf(this.Kjy) == null)
    {
      ad.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.Kjy);
      AppMethodBeat.o(37710);
      return;
    }
    if (w.zB(this.Kjy))
    {
      paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), v.zf(this.Kjy)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131755190);
      AppMethodBeat.o(37710);
      return;
    }
    AppMethodBeat.o(37710);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37714);
    super.onDestroy();
    ba.aiU().b(138, this);
    ba.aBQ();
    c.azp().b(this.KkV);
    d locald = this.KkV;
    if (locald.jdB != null)
    {
      locald.jdB.detach();
      locald.jdB = null;
    }
    this.KkV.det();
    this.KkV.fvg();
    this.Kjw.detach();
    this.Kjw.det();
    AppMethodBeat.o(37714);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    ba.aBQ();
    c.azz().remove(this);
    if (this.KkU != null) {
      this.KkU.onPause();
    }
    if (this.Kjw != null) {
      this.Kjw.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.KjK != null)
    {
      this.KjK.setContactType(2);
      this.KjK.fHK();
    }
    ba.aBQ();
    c.azz().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.KkU != null) && (this.KkS != null))
    {
      com.tencent.mm.bs.d.ffH();
      if ((com.tencent.mm.ax.b.aJo()) || (!com.tencent.mm.sdk.platformtools.ac.fks().equals("zh_CN"))) {
        break label149;
      }
      this.KkU.izx = false;
      localb = this.KkU;
      localb.izB = this.KkS;
      localb.izz = 1;
      if (1 != localb.izz) {
        break label141;
      }
      localb.izy = 2;
    }
    for (;;)
    {
      if (this.Kjw != null) {
        this.Kjw.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.izy = 1;
      continue;
      label149:
      this.KkU.izx = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37716);
    if (!bt.jh(this))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if (y.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(37716);
      return;
    }
    switch (paramn.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37716);
      return;
      dfw();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */