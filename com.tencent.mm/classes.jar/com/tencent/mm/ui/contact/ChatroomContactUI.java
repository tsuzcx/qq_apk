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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.b.a.do;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.al;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
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
  private com.tencent.mm.ui.voicesearch.b KFQ;
  private String KFS;
  private ContactCountView KGe;
  private VoiceSearchLayout KHm;
  private View KHn;
  private com.tencent.mm.modelvoiceaddr.ui.b KHo;
  private d KHp;
  private com.tencent.mm.pluginsdk.ui.e fPf;
  private TextView gZC;
  private int oef;
  private int oeg;
  private com.tencent.mm.ui.widget.b.a ofu;
  private n.e qsh;
  private ListView viQ;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.oef = 0;
    this.oeg = 0;
    this.qsh = new n.e()
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
        ChatroomContactUI.aYo(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.fPf = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void dio()
  {
    AppMethodBeat.i(37715);
    if (this.KHp != null) {
      this.KHp.a(null, null);
    }
    if (this.KFQ != null) {
      this.KFQ.a(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(37717);
    if (this.KGe != null)
    {
      this.KGe.setContactType(2);
      this.KGe.fMc();
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
    this.viQ = ((ListView)findViewById(2131296471));
    this.viQ.setAdapter(null);
    this.gZC = ((TextView)findViewById(2131299481));
    this.gZC.setText(2131755194);
    this.KHn = findViewById(2131306014);
    this.KHn.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/contact/ChatroomContactUI$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.KHp = new d(this, "@all.chatroom.contact");
    this.KHp.xs(true);
    this.KFQ = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.KFQ.KFj = "@all.chatroom.contact";
    this.KHo = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.KHo.a(new b.a()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        ae.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = bu.aSk(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(37698);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(37702);
        ae.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
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
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void aOF()
      {
        AppMethodBeat.i(37701);
        ae.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void aSL()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).yV(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void aSM()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void aSN() {}
      
      public final void aSO() {}
    });
    addSearchMenu(true, this.KHo);
    this.KHp.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dA(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.KHp.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.KHp.a(new MMSlideDelView.f()
    {
      public final void cQ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          ae.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.aYo(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.viQ.setOnScrollListener(this.fPf);
    this.KHp.FoO = this.fPf;
    this.ofu = new com.tencent.mm.ui.widget.b.a(getContext());
    this.viQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).Lmd))
        {
          ae.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).Lmd))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).Iw(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).afG(paramAnonymousInt);
          ae.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null)
            {
              paramAnonymousAdapterView = "";
              paramAnonymousView.aZb(paramAnonymousAdapterView);
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
              paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).afF(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.GuF.HId;
              bc.aCg();
              localObject = com.tencent.mm.model.c.azF().BH(paramAnonymousAdapterView);
              if (com.tencent.mm.contact.c.lO(((aw)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((an)localObject).fug()) {
                    g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.br.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.GuF.HId);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.jga);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Hed.HId);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.jfY);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bg(paramAnonymousView.jge, paramAnonymousView.jfW, paramAnonymousView.jfX));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.jfV);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.Hhv);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.Hhu);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.Hhy);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.Hhw);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.Hhx);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.HhA.jgg);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.HhA.jgi);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.HhA.jgh);
                if (paramAnonymousView.HhB != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.HhB.toByteArray());
                  if ((paramAnonymousView.Hhu & 0x8) > 0) {
                    g.yxI.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.br.d.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    ae.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).Ga(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                ae.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
                return;
              }
              ac.u(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (x.zV(paramAnonymousAdapterView))
              {
                paramAnonymousView = new do();
                paramAnonymousView.nl(paramAnonymousAdapterView);
                paramAnonymousView.dWm = 2L;
                paramAnonymousView.aLH();
              }
              paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
              paramAnonymousView.addFlags(67108864);
              paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Chat_Mode", 1);
              paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.mt(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        paramAnonymousAdapterView = (an)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          ae.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        if (x.zV(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new do();
          paramAnonymousView.nl(paramAnonymousAdapterView.field_username);
          paramAnonymousView.dWm = 2L;
          paramAnonymousView.aLH();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37706);
      }
    });
    this.viQ.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37707);
        ae.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount())
        {
          ae.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
          AppMethodBeat.o(37707);
          return true;
        }
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).Lmd))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = (an)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          ae.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37707);
          return false;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((x.AN(paramAnonymousAdapterView)) || (x.AO(paramAnonymousAdapterView)))
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
    this.viQ.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37692);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$10", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          if (ChatroomContactUI.c(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.c(ChatroomContactUI.this);
            if (paramAnonymousView.jgu != null) {
              paramAnonymousView.jgu.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.jgu != null) {
              paramAnonymousView.jgu.onTouchEvent(paramAnonymousMotionEvent);
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
    Object localObject = this.viQ;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.KGe = localContactCountView;
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.viQ.setAdapter(this.KHp);
    this.KFQ.yV(false);
    this.viQ.setVisibility(0);
    this.KHm = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.KHm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.KHm.setTopMargin(BackwardSupportUtil.b.h(this, 100.0F));
    this.KHm.setVisibility(8);
    ((ViewGroup)findViewById(2131306550)).addView(this.KHm);
    if (this.KHm != null) {
      this.KHm.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void fh(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37696);
          ae.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(paramAnonymousBoolean)));
          if (paramAnonymousBoolean)
          {
            int i = ChatroomContactUI.d(ChatroomContactUI.this).getFirstVisiblePosition();
            ae.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(i)));
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
    if (this.KHp.getCount() == 0)
    {
      this.gZC.setSingleLine(false);
      this.gZC.setPadding(40, 0, 40, 0);
      this.gZC.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(2131755178);
    initView();
    bc.ajj().a(138, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().a(this.KHp);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bc.aCg();
    if (com.tencent.mm.model.c.azF().BH(this.KFS) == null)
    {
      ae.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.KFS);
      AppMethodBeat.o(37710);
      return;
    }
    if (x.Al(this.KFS))
    {
      paramContextMenu.setHeaderTitle(k.c(paramView.getContext(), w.zP(this.KFS)));
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
    bc.ajj().b(138, this);
    bc.aCg();
    com.tencent.mm.model.c.azF().b(this.KHp);
    d locald = this.KHp;
    if (locald.jgu != null)
    {
      locald.jgu.detach();
      locald.jgu = null;
    }
    this.KHp.dhl();
    this.KHp.fzh();
    this.KFQ.detach();
    this.KFQ.dhl();
    AppMethodBeat.o(37714);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    bc.aCg();
    com.tencent.mm.model.c.azP().remove(this);
    if (this.KHo != null) {
      this.KHo.onPause();
    }
    if (this.KFQ != null) {
      this.KFQ.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.KGe != null)
    {
      this.KGe.setContactType(2);
      this.KGe.fMc();
    }
    bc.aCg();
    com.tencent.mm.model.c.azP().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.KHo != null) && (this.KHm != null))
    {
      com.tencent.mm.br.d.fjx();
      if ((com.tencent.mm.aw.b.aJG()) || (!ad.fom().equals("zh_CN"))) {
        break label149;
      }
      this.KHo.iCq = false;
      localb = this.KHo;
      localb.iCu = this.KHm;
      localb.iCs = 1;
      if (1 != localb.iCs) {
        break label141;
      }
      localb.iCr = 2;
    }
    for (;;)
    {
      if (this.KFQ != null) {
        this.KFQ.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.iCr = 1;
      continue;
      label149:
      this.KHo.iCq = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(37716);
    if (!bu.jn(this))
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
      dio();
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