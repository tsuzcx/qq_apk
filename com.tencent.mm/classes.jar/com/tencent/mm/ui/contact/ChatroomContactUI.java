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
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.ct;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.y.a;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements g, k.a
{
  private com.tencent.mm.ui.voicesearch.b IsQ;
  private String IsS;
  private ContactCountView Ite;
  private VoiceSearchLayout Ium;
  private View Iun;
  private com.tencent.mm.modelvoiceaddr.ui.b Iuo;
  private d Iup;
  private com.tencent.mm.pluginsdk.ui.d ftW;
  private TextView gDf;
  private int nwY;
  private int nwZ;
  private com.tencent.mm.ui.widget.b.a nym;
  private n.d pHX;
  private ListView tUA;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.nwY = 0;
    this.nwZ = 0;
    this.pHX = new n.d()
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
        ChatroomContactUI.aQS(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.ftW = new com.tencent.mm.pluginsdk.ui.d(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void cWl()
  {
    AppMethodBeat.i(37715);
    if (this.Iup != null) {
      this.Iup.a(null, null);
    }
    if (this.IsQ != null) {
      this.IsQ.a(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(37717);
    if (this.Ite != null)
    {
      this.Ite.setContactType(2);
      this.Ite.fqX();
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
    this.tUA = ((ListView)findViewById(2131296471));
    this.tUA.setAdapter(null);
    this.gDf = ((TextView)findViewById(2131299481));
    this.gDf.setText(2131755194);
    this.Iun = findViewById(2131306014);
    this.Iun.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.Iup = new d(this, "@all.chatroom.contact");
    this.Iup.wy(true);
    this.IsQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.IsQ.Isk = "@all.chatroom.contact";
    this.Iuo = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.Iuo.a(new b.a()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = bs.aLh(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(37698);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(37702);
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void aKY()
      {
        AppMethodBeat.i(37701);
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void aPa()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).xT(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void aPb()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void aPc() {}
      
      public final void aPd() {}
    });
    addSearchMenu(true, this.Iuo);
    this.Iup.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dy(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.Iup.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.Iup.a(new MMSlideDelView.f()
    {
      public final void cN(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.aQS(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.tUA.setOnScrollListener(this.ftW);
    this.Iup.Drp = this.ftW;
    this.nym = new com.tencent.mm.ui.widget.b.a(getContext());
    this.tUA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).IYA))
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).IYA))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).GF(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).acA(paramAnonymousInt);
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null) {}
            for (paramAnonymousAdapterView = "";; paramAnonymousAdapterView = ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent())
            {
              paramAnonymousView.aRB(paramAnonymousAdapterView);
              AppMethodBeat.o(37706);
              return;
            }
          }
          if (bool1)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).acy(paramAnonymousInt);
            paramAnonymousAdapterView = paramAnonymousView.EuE.FEm;
            az.ayM();
            Object localObject = c.awB().aNt(paramAnonymousAdapterView);
            if (com.tencent.mm.n.b.ln(((av)localObject).field_type))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Contact_Scene", 3);
              if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
              {
                if (((ai)localObject).fad()) {
                  h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
                }
                e.a(paramAnonymousView, paramAnonymousAdapterView);
                com.tencent.mm.br.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
              }
              AppMethodBeat.o(37706);
              return;
            }
            localObject = new Intent();
            ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.EuE.FEm);
            ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.iJY);
            ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Fbd.FEm);
            ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.iJW);
            ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.aW(paramAnonymousView.iKc, paramAnonymousView.iJU, paramAnonymousView.iJV));
            ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.iJT);
            ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Fer);
            ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Feq);
            ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Feu);
            ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Fes);
            ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Fet);
            ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.Few.iKe);
            ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.Few.iKg);
            ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.Few.iKf);
            if (paramAnonymousView.Fex != null) {}
            try
            {
              ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.Fex.toByteArray());
              if ((paramAnonymousView.Feq & 0x8) > 0) {
                h.wUl.kvStat(10298, paramAnonymousAdapterView + ",3");
              }
              com.tencent.mm.br.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
              AppMethodBeat.o(37706);
              return;
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
              }
            }
          }
          paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).acz(paramAnonymousInt);
          if (paramAnonymousAdapterView == null)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
            AppMethodBeat.o(37706);
            return;
          }
          ac.u(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
          paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
          if (w.wq(paramAnonymousAdapterView))
          {
            paramAnonymousView = new ct();
            paramAnonymousView.kP(paramAnonymousAdapterView);
            paramAnonymousView.dHR = 2L;
            paramAnonymousView.aHZ();
          }
          paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
          paramAnonymousView.addFlags(67108864);
          paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
          paramAnonymousView.putExtra("Chat_Mode", 1);
          paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
          paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousAdapterView = (ai)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37706);
          return;
        }
        if (w.wq(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new ct();
          paramAnonymousView.kP(paramAnonymousAdapterView.field_username);
          paramAnonymousView.dHR = 2L;
          paramAnonymousView.aHZ();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        AppMethodBeat.o(37706);
      }
    });
    this.tUA.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37707);
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount())
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
          AppMethodBeat.o(37707);
          return true;
        }
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).IYA))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = (ai)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37707);
          return false;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((w.xg(paramAnonymousAdapterView)) || (w.xh(paramAnonymousAdapterView)))
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
    this.tUA.setOnTouchListener(new View.OnTouchListener()
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
            if (paramAnonymousView.iKs != null) {
              paramAnonymousView.iKs.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.iKs != null) {
              paramAnonymousView.iKs.onTouchEvent(paramAnonymousMotionEvent);
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
    Object localObject = this.tUA;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.Ite = localContactCountView;
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
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.tUA.setAdapter(this.Iup);
    this.IsQ.xT(false);
    this.tUA.setVisibility(0);
    this.Ium = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.Ium.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.Ium.setTopMargin(BackwardSupportUtil.b.g(this, 100.0F));
    this.Ium.setVisibility(8);
    ((ViewGroup)findViewById(2131306550)).addView(this.Ium);
    if (this.Ium != null) {
      this.Ium.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void fc(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37696);
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(paramAnonymousBoolean)));
          if (paramAnonymousBoolean)
          {
            int i = ChatroomContactUI.d(ChatroomContactUI.this).getFirstVisiblePosition();
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(i)));
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
    if (this.Iup.getCount() == 0)
    {
      this.gDf.setSingleLine(false);
      this.gDf.setPadding(40, 0, 40, 0);
      this.gDf.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(2131755178);
    initView();
    az.agi().a(138, this);
    az.ayM();
    c.awB().a(this.Iup);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    az.ayM();
    if (c.awB().aNt(this.IsS) == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.IsS);
      AppMethodBeat.o(37710);
      return;
    }
    if (w.wE(this.IsS))
    {
      paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), v.wk(this.IsS)));
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
    az.agi().b(138, this);
    az.ayM();
    c.awB().b(this.Iup);
    d locald = this.Iup;
    if (locald.iKs != null)
    {
      locald.iKs.detach();
      locald.iKs = null;
    }
    this.Iup.cVi();
    this.Iup.feY();
    this.IsQ.detach();
    this.IsQ.cVi();
    AppMethodBeat.o(37714);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    az.ayM();
    c.awK().remove(this);
    if (this.Iuo != null) {
      this.Iuo.onPause();
    }
    if (this.IsQ != null) {
      this.IsQ.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.Ite != null)
    {
      this.Ite.setContactType(2);
      this.Ite.fqX();
    }
    az.ayM();
    c.awK().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.Iuo != null) && (this.Ium != null))
    {
      com.tencent.mm.br.d.eQD();
      if ((com.tencent.mm.aw.b.aGf()) || (!ab.eUO().equals("zh_CN"))) {
        break label149;
      }
      this.Iuo.igd = false;
      localb = this.Iuo;
      localb.igh = this.Ium;
      localb.igf = 1;
      if (1 != localb.igf) {
        break label141;
      }
      localb.ige = 2;
    }
    for (;;)
    {
      if (this.IsQ != null) {
        this.IsQ.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.ige = 1;
      continue;
      label149:
      this.Iuo.igd = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37716);
    if (!bs.iX(this))
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
      cWl();
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