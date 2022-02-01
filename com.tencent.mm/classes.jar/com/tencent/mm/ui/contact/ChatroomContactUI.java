package com.tencent.mm.ui.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.b.a.gq;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.z.a;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements i, MStorage.IOnStorageChange
{
  private com.tencent.mm.ui.voicesearch.b PSM;
  private String PSO;
  private ContactCountView PTa;
  private VoiceSearchLayout PUl;
  private View PUm;
  private com.tencent.mm.modelvoiceaddr.ui.b PUn;
  private d PUo;
  private com.tencent.mm.pluginsdk.ui.e gup;
  private TextView hSx;
  private int ppd;
  private int ppe;
  private com.tencent.mm.ui.widget.b.a pqr;
  private o.g rJj;
  private ListView yCT;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.ppd = 0;
    this.ppe = 0;
    this.rJj = new o.g()
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
        ChatroomContactUI.bns(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.gup = new com.tencent.mm.pluginsdk.ui.e(new ChatroomContactUI.6(this));
    AppMethodBeat.o(37708);
  }
  
  private void eco()
  {
    AppMethodBeat.i(37715);
    if (this.PUo != null) {
      this.PUo.onNotifyChange(null, null);
    }
    if (this.PSM != null) {
      this.PSM.onNotifyChange(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public int getLayoutId()
  {
    return 2131493461;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37711);
    ((TextView)findViewById(2131300114)).setVisibility(8);
    this.yCT = ((ListView)findViewById(2131296545));
    this.yCT.setAdapter(null);
    this.hSx = ((TextView)findViewById(2131300114));
    this.hSx.setText(2131755227);
    this.PUm = findViewById(2131309324);
    this.PUm.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.PUo = new d(this, "@all.chatroom.contact");
    this.PUo.Bh(true);
    this.PSM = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.PSM.PSf = "@all.chatroom.contact";
    this.PUn = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.PUn.a(new b.a()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        Log.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = Util.escapeSqlValue(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(37698);
      }
      
      public final void a(boolean paramAnonymousBoolean, String[] paramAnonymousArrayOfString, long paramAnonymousLong, int paramAnonymousInt)
      {
        AppMethodBeat.i(37702);
        Log.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
        if (paramAnonymousBoolean)
        {
          localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", paramAnonymousArrayOfString);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
          ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
          paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37702);
          return;
        }
        Object localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.getContext().getString(2131760826));
        ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
        paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void biM()
      {
        AppMethodBeat.i(37701);
        Log.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).CQ(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void bnz()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
    });
    addSearchMenu(true, this.PUn);
    this.PUo.setGetViewPositionCallback(new ChatroomContactUI.9(this));
    this.PUo.setPerformItemClickListener(new ChatroomContactUI.10(this));
    this.PUo.a(new MMSlideDelView.f()
    {
      public final void cZ(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.bns(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.yCT.setOnScrollListener(this.gup);
    this.PUo.KfF = this.gup;
    this.pqr = new com.tencent.mm.ui.widget.b.a(getContext());
    this.yCT.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).QBl))
        {
          Log.d("MicroMsg.ChatroomContactUI", paramAnonymousAdapterView);
          if (paramAnonymousInt >= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount()) {
            break;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        paramAnonymousInt -= ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount();
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).QBl))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).Ox(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).aot(paramAnonymousInt);
          Log.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null)
            {
              paramAnonymousAdapterView = "";
              paramAnonymousView.boh(paramAnonymousAdapterView);
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
              paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).aos(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.Lqk.MTo;
              bg.aVF();
              localObject = com.tencent.mm.model.c.aSN().Kn(paramAnonymousAdapterView);
              if (com.tencent.mm.contact.c.oR(((ax)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((as)localObject).gBM()) {
                    h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.br.c.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.Lqk.MTo);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.ked);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.Mjj.MTo);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.keb);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bq(paramAnonymousView.keh, paramAnonymousView.kdZ, paramAnonymousView.kea));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.kdY);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.MmL);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.MmK);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.MmO);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.MmM);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.MmN);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.MmQ.kej);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.MmQ.kel);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.MmQ.kek);
                if (paramAnonymousView.MmR != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.MmR.toByteArray());
                  if ((paramAnonymousView.MmK & 0x8) > 0) {
                    h.CyF.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.br.c.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
                }
                catch (IOException localIOException)
                {
                  for (;;)
                  {
                    Log.printErrStackTrace("MicroMsg.ChatroomContactUI", localIOException, "", new Object[0]);
                  }
                }
              }
            }
            else
            {
              paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).Ln(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
                return;
              }
              ac.u(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (ab.Iy(paramAnonymousAdapterView))
              {
                paramAnonymousView = new gq();
                paramAnonymousView.us(paramAnonymousAdapterView);
                paramAnonymousView.erw = 2L;
                paramAnonymousView.bfK();
              }
              paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
              paramAnonymousView.addFlags(67108864);
              paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Chat_Mode", 1);
              paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, paramAnonymousView.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.pG(0));
              com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        paramAnonymousAdapterView = (as)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        if (ab.Iy(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new gq();
          paramAnonymousView.us(paramAnonymousAdapterView.field_username);
          paramAnonymousView.erw = 2L;
          paramAnonymousView.bfK();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37706);
      }
    });
    this.yCT.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37707);
        Log.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt < ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount())
        {
          Log.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
          AppMethodBeat.o(37707);
          return true;
        }
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).QBl))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = (as)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          Log.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37707);
          return false;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((ab.Js(paramAnonymousAdapterView)) || (ab.Jt(paramAnonymousAdapterView)))
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
    this.yCT.setOnTouchListener(new View.OnTouchListener()
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
            if (paramAnonymousView.kex != null) {
              paramAnonymousView.kex.onTouchEvent(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.kex != null) {
              paramAnonymousView.kex.onTouchEvent(paramAnonymousMotionEvent);
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
    Object localObject = this.yCT;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.PTa = localContactCountView;
    ((ListView)localObject).addFooterView(localContactCountView, null, false);
    setBackBtn(new ChatroomContactUI.3(this));
    setToTop(new ChatroomContactUI.4(this));
    this.yCT.setAdapter(this.PUo);
    this.PSM.CQ(false);
    this.yCT.setVisibility(0);
    this.PUl = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.PUl.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.PUl.setTopMargin(BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F));
    this.PUl.setVisibility(8);
    ((ViewGroup)findViewById(2131310010)).addView(this.PUl);
    if (this.PUl != null) {
      this.PUl.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void fX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(37696);
          Log.d("MicroMsg.ChatroomContactUI", "visible ".concat(String.valueOf(paramAnonymousBoolean)));
          if (paramAnonymousBoolean)
          {
            int i = ChatroomContactUI.d(ChatroomContactUI.this).getFirstVisiblePosition();
            Log.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  ".concat(String.valueOf(i)));
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
    if (this.PUo.getCount() == 0)
    {
      this.hSx.setSingleLine(false);
      this.hSx.setPadding(40, 0, 40, 0);
      this.hSx.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(2131755196);
    initView();
    bg.azz().a(138, this);
    bg.aVF();
    com.tencent.mm.model.c.aSN().add(this.PUo);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bg.aVF();
    if (com.tencent.mm.model.c.aSN().Kn(this.PSO) == null)
    {
      Log.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.PSO);
      AppMethodBeat.o(37710);
      return;
    }
    if (ab.IQ(this.PSO))
    {
      paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), aa.getDisplayName(this.PSO)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131755223);
      AppMethodBeat.o(37710);
      return;
    }
    AppMethodBeat.o(37710);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37714);
    super.onDestroy();
    bg.azz().b(138, this);
    bg.aVF();
    com.tencent.mm.model.c.aSN().remove(this.PUo);
    d locald = this.PUo;
    if (locald.kex != null)
    {
      locald.kex.detach();
      locald.kex = null;
    }
    this.PUo.ebf();
    this.PUo.gGV();
    this.PSM.detach();
    this.PSM.ebf();
    AppMethodBeat.o(37714);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(37717);
    if (this.PTa != null)
    {
      this.PTa.setContactType(2);
      this.PTa.gUw();
    }
    AppMethodBeat.o(37717);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    bg.aVF();
    com.tencent.mm.model.c.aSX().remove(this);
    if (this.PUn != null) {
      this.PUn.onPause();
    }
    if (this.PSM != null) {
      this.PSM.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.PTa != null)
    {
      this.PTa.setContactType(2);
      this.PTa.gUw();
    }
    bg.aVF();
    com.tencent.mm.model.c.aSX().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.PUn != null) && (this.PUl != null))
    {
      com.tencent.mm.br.c.gsX();
      if ((com.tencent.mm.aw.b.isOverseasUser()) || (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))) {
        break label149;
      }
      this.PUn.jxF = false;
      localb = this.PUn;
      localb.jxJ = this.PUl;
      localb.jxH = 1;
      if (1 != localb.jxH) {
        break label141;
      }
      localb.jxG = 2;
    }
    for (;;)
    {
      if (this.PSM != null) {
        this.PSM.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.jxG = 1;
      continue;
      label149:
      this.PUn.jxF = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(37716);
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if (z.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(37716);
      return;
    }
    switch (paramq.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37716);
      return;
      eco();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */