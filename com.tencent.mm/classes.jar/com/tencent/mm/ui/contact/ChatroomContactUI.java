package com.tencent.mm.ui.contact;

import android.app.Activity;
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
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.f.b.a.iv;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout;
import com.tencent.mm.modelvoiceaddr.ui.VoiceSearchLayout.b;
import com.tencent.mm.modelvoiceaddr.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ac.a;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import java.io.IOException;

public class ChatroomContactUI
  extends MMActivity
  implements i, MStorage.IOnStorageChange
{
  private ListView Een;
  private String XpB;
  private ContactCountView XpL;
  private com.tencent.mm.ui.voicesearch.b Xpz;
  private VoiceSearchLayout XqW;
  private View XqX;
  private com.tencent.mm.modelvoiceaddr.ui.b XqY;
  private d XqZ;
  private com.tencent.mm.pluginsdk.ui.e iYA;
  private TextView kGU;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private q.g voR;
  
  public ChatroomContactUI()
  {
    AppMethodBeat.i(37708);
    this.syc = 0;
    this.syd = 0;
    this.voR = new q.g()
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
        ChatroomContactUI.bzS(ChatroomContactUI.a(ChatroomContactUI.this));
        AppMethodBeat.o(37691);
      }
    };
    this.iYA = new com.tencent.mm.pluginsdk.ui.e(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(37708);
  }
  
  private void eLm()
  {
    AppMethodBeat.i(37715);
    if (this.XqZ != null) {
      this.XqZ.onNotifyChange(null, null);
    }
    if (this.Xpz != null) {
      this.Xpz.onNotifyChange(null, null);
    }
    AppMethodBeat.o(37715);
  }
  
  public int getLayoutId()
  {
    return R.i.ecf;
  }
  
  public void initView()
  {
    AppMethodBeat.i(37711);
    ((TextView)findViewById(R.h.dFA)).setVisibility(8);
    this.Een = ((ListView)findViewById(R.h.address_contactlist));
    this.Een.setAdapter(null);
    this.kGU = ((TextView)findViewById(R.h.dFA));
    this.kGU.setText(R.l.enw);
    this.XqX = findViewById(R.h.top_mask);
    this.XqX.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(37697);
        ChatroomContactUI.b(ChatroomContactUI.this).onPause();
        AppMethodBeat.o(37697);
        return true;
      }
    });
    this.XqZ = new d(this, "@all.chatroom.contact");
    this.XqZ.Fx(true);
    this.Xpz = new com.tencent.mm.ui.voicesearch.b(getContext(), 1);
    this.Xpz.XoS = "@all.chatroom.contact";
    this.XqY = new com.tencent.mm.modelvoiceaddr.ui.b((byte)0);
    this.XqY.a(new b.a()
    {
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
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousArrayOfString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousArrayOfString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousArrayOfString, "com/tencent/mm/ui/contact/ChatroomContactUI$4", "onVoiceReturn", "(Z[Ljava/lang/String;JI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(37702);
      }
      
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(37698);
        Log.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", new Object[] { paramAnonymousString });
        paramAnonymousString = Util.escapeSqlValue(paramAnonymousString);
        ChatroomContactUI.a(ChatroomContactUI.this, paramAnonymousString);
        AppMethodBeat.o(37698);
      }
      
      public final void bsk()
      {
        AppMethodBeat.i(37701);
        Log.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
        ChatroomContactUI.this.hideVKB();
        AppMethodBeat.o(37701);
      }
      
      public final void bxH()
      {
        AppMethodBeat.i(37699);
        ChatroomContactUI.d(ChatroomContactUI.this).setAdapter(ChatroomContactUI.c(ChatroomContactUI.this));
        ChatroomContactUI.c(ChatroomContactUI.this).notifyDataSetChanged();
        ChatroomContactUI.e(ChatroomContactUI.this).Hk(false);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(8);
        AppMethodBeat.o(37699);
      }
      
      public final void bxI()
      {
        AppMethodBeat.i(37700);
        ChatroomContactUI.f(ChatroomContactUI.this).setVisibility(0);
        AppMethodBeat.o(37700);
      }
      
      public final void bxJ() {}
      
      public final void bxK() {}
    });
    addSearchMenu(true, this.XqY);
    this.XqZ.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(37703);
        int i = ChatroomContactUI.d(ChatroomContactUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(37703);
        return i;
      }
    });
    this.XqZ.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(37704);
        ChatroomContactUI.d(ChatroomContactUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(37704);
      }
    });
    this.XqZ.a(new MMSlideDelView.f()
    {
      public final void cW(Object paramAnonymousObject)
      {
        AppMethodBeat.i(37705);
        if (paramAnonymousObject == null)
        {
          Log.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
          AppMethodBeat.o(37705);
          return;
        }
        ChatroomContactUI.bzS(paramAnonymousObject.toString());
        ChatroomContactUI.g(ChatroomContactUI.this);
        AppMethodBeat.o(37705);
      }
    });
    this.Een.setOnScrollListener(this.iYA);
    this.XqZ.Rgt = this.iYA;
    this.szq = new com.tencent.mm.ui.widget.b.a(getContext());
    this.Een.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(37706);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousAdapterView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramAnonymousInt);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new StringBuilder("onItemClick ").append(paramAnonymousInt);
        if (ChatroomContactUI.e(ChatroomContactUI.this) == null) {}
        for (paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this);; paramAnonymousAdapterView = Boolean.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).XZK))
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
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).XZK))
        {
          boolean bool1 = ChatroomContactUI.e(ChatroomContactUI.this).TR(paramAnonymousInt);
          boolean bool2 = ChatroomContactUI.e(ChatroomContactUI.this).axB(paramAnonymousInt);
          Log.d("MicroMsg.ChatroomContactUI", "onItemClick ".concat(String.valueOf(bool2)));
          if (bool2)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (ChatroomContactUI.b(ChatroomContactUI.this) == null)
            {
              paramAnonymousAdapterView = "";
              paramAnonymousView.bAW(paramAnonymousAdapterView);
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
              paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this).axA(paramAnonymousInt);
              paramAnonymousAdapterView = paramAnonymousView.SrH.Ufy;
              bh.beI();
              localObject = com.tencent.mm.model.c.bbL().RG(paramAnonymousAdapterView);
              if (com.tencent.mm.contact.d.rk(((ax)localObject).field_type))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramAnonymousAdapterView);
                paramAnonymousView.putExtra("Contact_Scene", 3);
                if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.length() > 0))
                {
                  if (((as)localObject).hxX()) {
                    h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  e.a(paramAnonymousView, paramAnonymousAdapterView);
                  com.tencent.mm.by.c.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", paramAnonymousView);
                }
              }
              else
              {
                localObject = new Intent();
                ((Intent)localObject).putExtra("Contact_User", paramAnonymousView.SrH.Ufy);
                ((Intent)localObject).putExtra("Contact_Alias", paramAnonymousView.mVD);
                ((Intent)localObject).putExtra("Contact_Nick", paramAnonymousView.TtX.Ufy);
                ((Intent)localObject).putExtra("Contact_Signature", paramAnonymousView.mVB);
                ((Intent)localObject).putExtra("Contact_RegionCode", RegionCodeDecoder.bl(paramAnonymousView.mVH, paramAnonymousView.mVz, paramAnonymousView.mVA));
                ((Intent)localObject).putExtra("Contact_Sex", paramAnonymousView.mVy);
                ((Intent)localObject).putExtra("Contact_VUser_Info", paramAnonymousView.TxG);
                ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramAnonymousView.TxF);
                ((Intent)localObject).putExtra("Contact_KWeibo_flag", paramAnonymousView.TxJ);
                ((Intent)localObject).putExtra("Contact_KWeibo", paramAnonymousView.TxH);
                ((Intent)localObject).putExtra("Contact_KWeiboNick", paramAnonymousView.TxI);
                ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramAnonymousView.TxL.mVJ);
                ((Intent)localObject).putExtra("Contact_KSnsBgId", paramAnonymousView.TxL.mVL);
                ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramAnonymousView.TxL.mVK);
                if (paramAnonymousView.TxM != null) {}
                try
                {
                  ((Intent)localObject).putExtra("Contact_customInfo", paramAnonymousView.TxM.toByteArray());
                  if ((paramAnonymousView.TxF & 0x8) > 0) {
                    h.IzE.kvStat(10298, paramAnonymousAdapterView + ",3");
                  }
                  com.tencent.mm.by.c.b(ChatroomContactUI.this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
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
              paramAnonymousAdapterView = ChatroomContactUI.e(ChatroomContactUI.this).Qx(paramAnonymousInt);
              if (paramAnonymousAdapterView == null)
              {
                Log.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", new Object[] { Integer.valueOf(ChatroomContactUI.e(ChatroomContactUI.this).getCount()), Integer.valueOf(paramAnonymousInt) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(37706);
                return;
              }
              ae.y(ChatroomContactUI.b(ChatroomContactUI.this).getSearchContent(), 9, 3, paramAnonymousInt + 1);
              paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
              if (ab.PQ(paramAnonymousAdapterView))
              {
                paramAnonymousView = new iv();
                paramAnonymousView.zR(paramAnonymousAdapterView);
                paramAnonymousView.gmT = 2L;
                paramAnonymousView.bpa();
              }
              paramAnonymousView = new Intent(ChatroomContactUI.this.getContext(), ChattingUI.class);
              paramAnonymousView.addFlags(67108864);
              paramAnonymousView.putExtra("Chat_User", paramAnonymousAdapterView);
              paramAnonymousView.putExtra("Chat_Mode", 1);
              paramAnonymousAdapterView = ChatroomContactUI.this.getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousAdapterView, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              paramAnonymousAdapterView.startActivity((Intent)paramAnonymousView.sf(0));
              com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousAdapterView, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
        if (ab.PQ(paramAnonymousAdapterView.field_username))
        {
          paramAnonymousView = new iv();
          paramAnonymousView.zR(paramAnonymousAdapterView.field_username);
          paramAnonymousView.gmT = 2L;
          paramAnonymousView.bpa();
        }
        paramAnonymousAdapterView = paramAnonymousAdapterView.field_username;
        ChatroomContactUI.b(ChatroomContactUI.this, paramAnonymousAdapterView);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$8", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(37706);
      }
    });
    this.Een.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
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
        if ((ChatroomContactUI.e(ChatroomContactUI.this) != null) && (ChatroomContactUI.e(ChatroomContactUI.this).XZK))
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
        if ((ab.QL(paramAnonymousAdapterView)) || (ab.QM(paramAnonymousAdapterView)))
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
    this.Een.setOnTouchListener(new View.OnTouchListener()
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
            if (paramAnonymousView.mVX != null) {
              paramAnonymousView.mVX.B(paramAnonymousMotionEvent);
            }
          }
          if (ChatroomContactUI.e(ChatroomContactUI.this) != null)
          {
            paramAnonymousView = ChatroomContactUI.e(ChatroomContactUI.this);
            if (paramAnonymousView.mVX != null) {
              paramAnonymousView.mVX.B(paramAnonymousMotionEvent);
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
    Object localObject = this.Een;
    ContactCountView localContactCountView = new ContactCountView(this);
    this.XpL = localContactCountView;
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
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = ChatroomContactUI.d(ChatroomContactUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(37694);
      }
    });
    this.Een.setAdapter(this.XqZ);
    this.Xpz.Hk(false);
    this.Een.setVisibility(0);
    this.XqW = new VoiceSearchLayout(this);
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    this.XqW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.XqW.setTopMargin(BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 100.0F));
    this.XqW.setVisibility(8);
    ((ViewGroup)findViewById(R.h.eat)).addView(this.XqW);
    if (this.XqW != null) {
      this.XqW.setOnVisibleChangeListener(new VoiceSearchLayout.b()
      {
        public final void gJ(boolean paramAnonymousBoolean)
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
    if (this.XqZ.getCount() == 0)
    {
      this.kGU.setSingleLine(false);
      this.kGU.setPadding(40, 0, 40, 0);
      this.kGU.setVisibility(0);
    }
    AppMethodBeat.o(37711);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(37709);
    super.onCreate(paramBundle);
    setMMTitle(R.l.address_chatroom_contact_nick);
    initView();
    bh.aGY().a(138, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().add(this.XqZ);
    AppMethodBeat.o(37709);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(37710);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    bh.beI();
    if (com.tencent.mm.model.c.bbL().RG(this.XpB) == null)
    {
      Log.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.XpB);
      AppMethodBeat.o(37710);
      return;
    }
    if (ab.Qj(this.XpB))
    {
      paramContextMenu.setHeaderTitle(l.c(paramView.getContext(), aa.PJ(this.XpB)));
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.ent);
      AppMethodBeat.o(37710);
      return;
    }
    AppMethodBeat.o(37710);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(37714);
    super.onDestroy();
    bh.aGY().b(138, this);
    bh.beI();
    com.tencent.mm.model.c.bbL().remove(this.XqZ);
    d locald = this.XqZ;
    if (locald.mVX != null)
    {
      locald.mVX.detach();
      locald.mVX = null;
    }
    this.XqZ.eKd();
    this.XqZ.hFC();
    this.Xpz.detach();
    this.Xpz.eKd();
    AppMethodBeat.o(37714);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(37717);
    if (this.XpL != null)
    {
      this.XpL.setContactType(2);
      this.XpL.hUp();
    }
    AppMethodBeat.o(37717);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(37713);
    super.onPause();
    bh.beI();
    com.tencent.mm.model.c.bbV().remove(this);
    if (this.XqY != null) {
      this.XqY.onPause();
    }
    if (this.Xpz != null) {
      this.Xpz.onPause();
    }
    AppMethodBeat.o(37713);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(37712);
    super.onResume();
    if (this.XpL != null)
    {
      this.XpL.setContactType(2);
      this.XpL.hUp();
    }
    bh.beI();
    com.tencent.mm.model.c.bbV().add(this);
    com.tencent.mm.modelvoiceaddr.ui.b localb;
    if ((this.XqY != null) && (this.XqW != null))
    {
      com.tencent.mm.by.c.hok();
      if ((com.tencent.mm.az.b.isOverseasUser()) || (!LocaleUtil.getApplicationLanguage().equals("zh_CN"))) {
        break label149;
      }
      this.XqY.mni = false;
      localb = this.XqY;
      localb.mnm = this.XqW;
      localb.mnk = 1;
      if (1 != localb.mnk) {
        break label141;
      }
      localb.mnj = 2;
    }
    for (;;)
    {
      if (this.Xpz != null) {
        this.Xpz.onResume();
      }
      AppMethodBeat.o(37712);
      return;
      label141:
      localb.mnj = 1;
      continue;
      label149:
      this.XqY.mni = false;
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
    if (ac.a.a(this, paramInt1, paramInt2, paramString, 4))
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
      eLm();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI
 * JD-Core Version:    0.7.0.1
 */