package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.lf;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae.a;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import java.io.IOException;
import java.util.HashSet;

public class ChatroomContactUI
  extends MMActivity
  implements com.tencent.mm.am.h, MStorage.IOnStorageChange
{
  private View DGv;
  private ListView JVY;
  private com.tencent.mm.pluginsdk.ui.e adKd;
  private com.tencent.mm.ui.voicesearch.b afbb;
  private String afbd;
  private ContactCountView afbn;
  private VoiceSearchLayout afcx;
  private com.tencent.mm.modelvoiceaddr.ui.b afcy;
  private d afcz;
  private TextView njO;
  private com.tencent.mm.ui.widget.b.a vEV;
  private int x_down;
  private u.i yBn;
  private int y_down;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.x_down = 0;
    this.y_down = 0;
    this.yBn = new u.i()
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
        ChatroomContactUI.bBI(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.adKd = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void fTt()
  {
    AppMethodBeat.i(37715);
    if (this.afcz != null) {
      this.afcz.onNotifyChange(null, null);
    }
    if (this.afbb != null) {
      this.afbb.onNotifyChange(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public int getLayoutId()
  {
    return R.i.geN;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37711);
    ((TextView)findViewById(R.h.fGG)).setVisibility(8);
    this.JVY = ((ListView)findViewById(R.h.address_contactlist));
    this.JVY.setAdapter(null);
    this.njO = ((TextView)findViewById(R.h.fGG));
    this.njO.setText(R.l.gqw);
    this.DGv = findViewById(R.h.top_mask);
    this.DGv.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.afcz = new d(this, "@all.chatroom.contact");
    this.afcz.Lh(true);
    this.afbb = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.afbb.afau = "@all.chatroom.contact";
    this.afcy = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.afcy.a(new b.a()
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(37702);
          return;
        }
        Object localObject = new Intent(ChatroomContactUI.this.getContext(), VoiceSearchResultUI.class);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_Error", ChatroomContactUI.this.getContext().getString(R.l.fmt_iap_err));
        ((Intent)localObject).putExtra("VoiceSearchResultUI_VoiceId", paramAnonymousLong);
        ((Intent)localObject).putExtra("VoiceSearchResultUI_ShowType", paramAnonymousInt);
        paramAnonymousArrayOfString = ChatroomContactUI.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final void bPQ()
      {
        AppMethodBeat.i(37701);
        Log.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void bWw()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).Ng(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void bWx()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void bWy() {}
      
      public final void bWz() {}
    });
    addSearchMenu(true, this.afcy);
    this.afcz.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int eB(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.afcz.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void performItemClick(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.afcz.a(new MMSlideDelView.f()
    {
      public final void es(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.bBI(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.JVY.setOnScrollListener(this.adKd);
    this.afcz.Ycw = this.adKd;
    this.vEV = new com.tencent.mm.ui.widget.b.a(getContext());
    this.JVY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).afRG))
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
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).afRG))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).XL(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).aEl(paramAnonymousInt);
          Log.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null)
            {
              paramAnonymousAdapterView = "";
              paramAnonymousView.bDp(paramAnonymousAdapterView);
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
              paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).aEk(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.ZqL.abwM;
              bh.bCz();
              localObject = com.tencent.mm.model.c.bzA().JE(paramAnonymousAdapterView);
              if (com.tencent.mm.contact.d.rs(((az)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((au)localObject).iZC()) {
                    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.br.c.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.ZqL.abwM);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.pSk);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.aaIz.abwM);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.pSi);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bI(paramAnonymousView.pSo, paramAnonymousView.pSg, paramAnonymousView.pSh));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.pSf);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.aaMn);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.aaMm);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.aaMq);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.aaMo);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.aaMp);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.aaMs.pSq);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.aaMs.pSs);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.aaMs.pSr);
                if (paramAnonymousView.aaMt != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.aaMt.toByteArray());
                  if ((paramAnonymousView.aaMm & 0x8) > 0) {
                    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10298, paramAnonymousAdapterView + ",3");
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
              paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).TF(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
                return;
              }
              aj.y(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (au.bwF(paramAnonymousAdapterView))
              {
                paramAnonymousView = new lf();
                paramAnonymousView.uc(paramAnonymousAdapterView);
                paramAnonymousView.iuA = 2L;
                paramAnonymousView.bMH();
              }
              paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
              paramAnonymousView.addFlags(67108864);
              paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Chat_Mode", 1);
              paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sb(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
          }
        }
        paramAnonymousAdapterView = (au)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.ChatroomContactUI", "position=%s cont is null", new Object[] { Integer.valueOf(paramAnonymousInt) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(37706);
          return;
        }
        if (au.bwF(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new lf();
          paramAnonymousView.uc(paramAnonymousAdapterView.field_username);
          paramAnonymousView.iuA = 2L;
          paramAnonymousView.bMH();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37706);
      }
    });
    this.JVY.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).afRG))
        {
          AppMethodBeat.o(37707);
          return true;
        }
        paramAnonymousAdapterView = (au)ChatroomContactUI.c(ChatroomContactUI.this).getItem(paramAnonymousInt - ChatroomContactUI.d(ChatroomContactUI.this).getHeaderViewsCount());
        if (paramAnonymousAdapterView == null)
        {
          Log.w("MicroMsg.ChatroomContactUI", "null == ct position=%s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppMethodBeat.o(37707);
          return false;
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        if ((au.bwp(paramAnonymousAdapterView)) || (au.bwq(paramAnonymousAdapterView)))
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
    this.JVY.setOnTouchListener(new View.OnTouchListener()
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
            if (paramAnonymousView.pSE != null) {
              paramAnonymousView.pSE.B(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.pSE != null) {
              paramAnonymousView.pSE.B(paramAnonymousMotionEvent);
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
    Object localObject = this.JVY;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.afbn = localContactCountView;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.JVY.setAdapter(this.afcz);
    this.afbb.Ng(false);
    this.JVY.setVisibility(0);
    this.afcx = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.afcx.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.afcx.setTopMargin(BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F));
    this.afcx.setVisibility(8);
    ((ViewGroup)findViewById(R.h.gdj)).addView(this.afcx);
    if (this.afcx != null) {
      this.afcx.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void hx(boolean paramAnonymousBoolean)
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
    if (this.afcz.getCount() == 0)
    {
      this.njO.setSingleLine(false);
      this.njO.setPadding(40, 0, 40, 0);
      this.njO.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(R.l.address_chatroom_contact_nick);
    initView();
    bh.aZW().a(138, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().add(this.afcz);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bh.bCz();
    if (com.tencent.mm.model.c.bzA().JE(this.afbd) == null)
    {
      Log.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.afbd);
      AppMethodBeat.o(37710);
      return;
    }
    if (ab.IQ(this.afbd))
    {
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.span.p.b(paramView.getContext(), aa.getDisplayName(this.afbd)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.gqu);
      AppMethodBeat.o(37710);
      return;
    }
    AppMethodBeat.o(37710);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37714);
    super.onDestroy();
    bh.aZW().b(138, this);
    bh.bCz();
    com.tencent.mm.model.c.bzA().remove(this.afcz);
    d locald = this.afcz;
    if (locald.pSE != null)
    {
      locald.pSE.detach();
      locald.pSE = null;
    }
    this.afcz.fSd();
    this.afcz.jhO();
    this.afbb.detach();
    this.afbb.fSd();
    AppMethodBeat.o(37714);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(37717);
    if (this.afbn != null)
    {
      this.afbn.setContactType(2);
      this.afbn.jyf();
    }
    AppMethodBeat.o(37717);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    bh.bCz();
    com.tencent.mm.model.c.bzK().remove(this);
    if (this.afcy != null) {
      this.afcy.onPause();
    }
    if (this.afbb != null) {
      this.afbb.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.afbn != null)
    {
      this.afbn.setContactType(2);
      this.afbn.jyf();
    }
    bh.bCz();
    com.tencent.mm.model.c.bzK().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.afcy != null) && (this.afcx != null))
    {
      if ((com.tencent.mm.br.c.iPe()) || (com.tencent.mm.au.b.isOverseasUser()) || (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))) {
        break label151;
      }
      this.afcy.pgU = false;
      localb = this.afcy;
      localb.pgY = this.afcx;
      localb.pgW = 1;
      if (1 != localb.pgW) {
        break label143;
      }
      localb.pgV = 2;
    }
    for (;;)
    {
      if (this.afbb != null) {
        this.afbb.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label143:
      localb.pgV = 1;
      continue;
      label151:
      this.afcy.pgU = false;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(37716);
    if (!Util.isTopActivity(this))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if (ae.a.a(this, paramInt1, paramInt2, paramString, 4))
    {
      AppMethodBeat.o(37716);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(37716);
      return;
    }
    switch (paramp.getType())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(37716);
      return;
      fTt();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(253075);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.ui.a.c.class);
    AppMethodBeat.o(253075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */