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
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.x.a;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements g, k.a
{
  private com.tencent.mm.ui.voicesearch.b GSE;
  private String GSG;
  private ContactCountView GSS;
  private VoiceSearchLayout GUb;
  private View GUc;
  private com.tencent.mm.modelvoiceaddr.ui.b GUd;
  private d GUe;
  private com.tencent.mm.pluginsdk.ui.d fqs;
  private int mUE;
  private int mUF;
  private com.tencent.mm.ui.widget.b.a mVN;
  private n.d peM;
  private TextView qcD;
  private ListView sMV;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.mUE = 0;
    this.mUF = 0;
    this.peM = new n.d()
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
        ChatroomContactUI.aLo(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.fqs = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void cJa()
  {
    AppMethodBeat.i(37715);
    if (this.GUe != null) {
      this.GUe.a(null, null);
    }
    if (this.GSE != null) {
      this.GSE.a(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(37717);
    if (this.GSS != null)
    {
      this.GSS.setContactType(2);
      this.GSS.fbg();
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
    this.sMV = ((ListView)findViewById(2131296471));
    this.sMV.setAdapter(null);
    this.qcD = ((TextView)findViewById(2131299481));
    this.qcD.setText(2131755194);
    this.GUc = findViewById(2131306014);
    this.GUc.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.GUe = new d(this, "@all.chatroom.contact");
    this.GUe.vw(true);
    this.GSE = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.GSE.GRX = "@all.chatroom.contact";
    this.GUd = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.GUd.a(new b.a()
    {
      public final boolean BX(String paramAnonymousString)
      {
        return false;
      }
      
      public final void BY(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        ad.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = bt.aFQ(paramAnonymousString);
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void aEh()
      {
        AppMethodBeat.i(37701);
        ad.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void aIj()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).wM(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void aIk()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void aIl() {}
      
      public final void aIm() {}
    });
    addSearchMenu(true, this.GUd);
    this.GUe.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dw(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.GUe.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.GUe.a(new MMSlideDelView.f()
    {
      public final void cO(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          ad.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.aLo(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.sMV.setOnScrollListener(this.fqs);
    this.GUe.BYY = this.fqs;
    this.mVN = new com.tencent.mm.ui.widget.b.a(getContext());
    this.sMV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).Hyd))
        {
          ad.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).Hyd))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).EJ(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).aan(paramAnonymousInt);
          ad.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null) {}
            for (paramAnonymousAdapterView = "";; paramAnonymousAdapterView = ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent())
            {
              paramAnonymousView.aLZ(paramAnonymousAdapterView);
              AppMethodBeat.o(37706);
              return;
            }
          }
          if (bool1)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).aal(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.Dby.Ehn;
            az.arV();
            Object localObject = c.apM().aHY(paramAnonymousAdapterView);
            if (com.tencent.mm.n.b.ls(((au)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((af)localObject).eKB()) {
                  h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.bs.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(37706);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.Dby.Ehn);
            ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ijR);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.DFJ.Ehn);
            ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.ijP);
            ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aT(paramAnonymousView.ijV, paramAnonymousView.ijN, paramAnonymousView.ijO));
            ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.ijM);
            ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.DIW);
            ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.DIV);
            ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.DIZ);
            ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.DIX);
            ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.DIY);
            ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.DJb.ijX);
            ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.DJb.ijZ);
            ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.DJb.ijY);
            if (paramAnonymousView.DJc != null) {}
            try
            {
              ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.DJc.toByteArray());
              if ((paramAnonymousView.DIV & 0x8) > 0) {
                h.vKh.kvStat(10298, paramAnonymousAdapterView + ",3");
              }
              com.tencent.mm.bs.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
              AppMethodBeat.o(37706);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                ad.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
              }
            }
          }
          paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).aam(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            ad.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(37706);
            return;
          }
          ac.u(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (w.sn(paramAnonymousAdapterView))
          {
            paramAnonymousView = new com.tencent.mm.g.b.a.bg();
            paramAnonymousView.hZ(paramAnonymousAdapterView);
            paramAnonymousView.dKc = 2L;
            paramAnonymousView.aBj();
          }
          paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Chat_Mode", 1);
          paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousAdapterView = (af)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ad.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37706);
          return;
        }
        if (w.sn(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new com.tencent.mm.g.b.a.bg();
          paramAnonymousView.hZ(paramAnonymousAdapterView.field_username);
          paramAnonymousView.dKc = 2L;
          paramAnonymousView.aBj();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        AppMethodBeat.o(37706);
      }
    });
    this.sMV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).Hyd))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = ((af)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount())).field_username;
        if ((w.td(paramAnonymousAdapterView)) || (w.te(paramAnonymousAdapterView)))
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
    this.sMV.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37692);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          if (ChatroomContactUI.c(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.c(ChatroomContactUI.this);
            if (paramAnonymousView.ikl != null) {
              paramAnonymousView.ikl.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.ikl != null) {
              paramAnonymousView.ikl.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          AppMethodBeat.o(37692);
          return false;
          ChatroomContactUI.this.hideVKB();
          ChatroomContactUI.a(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawX());
          ChatroomContactUI.b(ChatroomContactUI.this, (int)paramAnonymousMotionEvent.getRawY());
        }
      }
    });
    Object localObject = this.sMV;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.GSS = localContactCountView;
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
        paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.sMV.setAdapter(this.GUe);
    this.GSE.wM(false);
    this.sMV.setVisibility(0);
    this.GUb = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.GUb.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.GUb.setTopMargin(BackwardSupportUtil.b.g(this, 100.0F));
    this.GUb.setVisibility(8);
    ((ViewGroup)findViewById(2131306550)).addView(this.GUb);
    if (this.GUb != null) {
      this.GUb.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void eI(boolean paramAnonymousBoolean)
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
    if (this.GUe.getCount() == 0)
    {
      this.qcD.setSingleLine(false);
      this.qcD.setPadding(40, 0, 40, 0);
      this.qcD.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(2131755178);
    initView();
    az.aeS().a(138, this);
    az.arV();
    c.apM().a(this.GUe);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    az.arV();
    if (c.apM().aHY(this.GSG) == null)
    {
      ad.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.GSG);
      AppMethodBeat.o(37710);
      return;
    }
    if (w.sB(this.GSG))
    {
      paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), v.sh(this.GSG)));
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
    az.aeS().b(138, this);
    az.arV();
    c.apM().b(this.GUe);
    d locald = this.GUe;
    if (locald.ikl != null)
    {
      locald.ikl.detach();
      locald.ikl = null;
    }
    this.GUe.cHX();
    this.GUe.ePu();
    this.GSE.detach();
    this.GSE.cHX();
    AppMethodBeat.o(37714);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    az.arV();
    c.apV().remove(this);
    if (this.GUd != null) {
      this.GUd.onPause();
    }
    if (this.GSE != null) {
      this.GSE.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.GSS != null)
    {
      this.GSS.setContactType(2);
      this.GSS.fbg();
    }
    az.arV();
    c.apV().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.GUd != null) && (this.GUb != null))
    {
      com.tencent.mm.bs.d.eBj();
      if ((com.tencent.mm.ax.b.azo()) || (!com.tencent.mm.sdk.platformtools.ac.eFu().equals("zh_CN"))) {
        break label149;
      }
      this.GUd.hFB = false;
      localb = this.GUd;
      localb.hFF = this.GUb;
      localb.hFD = 1;
      if (1 != localb.hFD) {
        break label141;
      }
      localb.hFC = 2;
    }
    for (;;)
    {
      if (this.GSE != null) {
        this.GSE.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.hFC = 1;
      continue;
      label149:
      this.GUd.hFB = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37716);
    if (!bt.iM(this))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if (x.a.a(this, paramInt1, paramInt2, paramString, 4))
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
      cJa();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */