package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.an.q;
import com.tencent.mm.ao.a.b.a;
import com.tencent.mm.ao.a.b.a.b;
import com.tencent.mm.ao.a.d.a;
import com.tencent.mm.ao.a.d.a.b;
import com.tencent.mm.ao.a.k;
import com.tencent.mm.ao.a.l;
import com.tencent.mm.ao.a.o;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.e.a;
import com.tencent.mm.ao.e.a.a;
import com.tencent.mm.ao.f;
import com.tencent.mm.ao.g;
import com.tencent.mm.ao.p;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.nj;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.BaseConversationFmUI;
import com.tencent.mm.ui.i;
import com.tencent.mm.ui.v.a;
import java.util.LinkedList;

public class BizChatConversationUI$BizChatConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
  implements p, MStorageEx.IOnStorageChange
{
  private LinearLayout WtX;
  private b WtY;
  private k WtZ;
  private int Wua;
  private com.tencent.mm.ao.d Wub;
  private b.a Wuc;
  private d.a Wud;
  private e.a Wue;
  private String eZR;
  private TextView emptyTipTv;
  private boolean isCurrentActivity;
  private boolean isDeleteCancel;
  private ListView snr;
  private q.g snt;
  private String syN;
  private int syc;
  private int syd;
  private long syu;
  private s tipDialog;
  
  public BizChatConversationUI$BizChatConversationFmUI()
  {
    AppMethodBeat.i(33937);
    this.isDeleteCancel = false;
    this.Wua = 0;
    this.syc = 0;
    this.syd = 0;
    this.Wuc = new b.a()
    {
      public final void a(b.a.b paramAnonymousb)
      {
        AppMethodBeat.i(271628);
        if ((paramAnonymousb != null) && (paramAnonymousb.lFV != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.lFV.field_brandUserName)))
        {
          Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
          BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Vx(paramAnonymousb.lFU);
          if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).atr();
          }
        }
        AppMethodBeat.o(271628);
      }
    };
    this.Wud = new d.a()
    {
      public final void a(d.a.b paramAnonymousb)
      {
        AppMethodBeat.i(273760);
        if ((paramAnonymousb != null) && (paramAnonymousb.lGf != null) && (BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this).equals(paramAnonymousb.lGf.field_brandUserName)))
        {
          Log.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
          BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).Vx(paramAnonymousb.lFU);
          if (BizChatConversationUI.BizChatConversationFmUI.n(BizChatConversationUI.BizChatConversationFmUI.this)) {
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).atr();
          }
        }
        AppMethodBeat.o(273760);
      }
    };
    this.Wue = new e.a()
    {
      public final void a(e.a.a paramAnonymousa)
      {
        AppMethodBeat.i(279791);
        String str = BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this);
        if ((paramAnonymousa != null) && (!Util.isNullOrNil(paramAnonymousa.lEm)) && (paramAnonymousa.lEm.equals(str)))
        {
          int i = BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this);
          BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this, i.cI(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), str));
          if (BizChatConversationUI.BizChatConversationFmUI.o(BizChatConversationUI.BizChatConversationFmUI.this) != i) {
            BizChatConversationUI.BizChatConversationFmUI.p(BizChatConversationUI.BizChatConversationFmUI.this);
          }
        }
        AppMethodBeat.o(279791);
      }
    };
    AppMethodBeat.o(33937);
  }
  
  private void Vy(long paramLong)
  {
    AppMethodBeat.i(33949);
    Bundle localBundle = new Bundle();
    localBundle.putLong("key_biz_chat_id", paramLong);
    localBundle.putBoolean("finish_direct", false);
    localBundle.putBoolean("key_need_send_video", false);
    localBundle.putBoolean("key_is_biz_chat", true);
    this.ui.startChatting(this.syN, localBundle, true);
    AppMethodBeat.o(33949);
  }
  
  private void hLh()
  {
    AppMethodBeat.i(33946);
    String str1 = hLi();
    this.Wua = i.cI(getContext(), str1);
    Object localObject1;
    CdnImageView localCdnImageView;
    int i;
    Object localObject2;
    if ((this.Wua == 2) && (this.WtX == null))
    {
      this.WtX = ((LinearLayout)findViewById(R.h.bottom_bar));
      localObject1 = this.WtX.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = com.tencent.mm.ci.a.aY(getContext(), R.f.DefaultTabbarHeight);
      this.WtX.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = ad.kS(getContext()).inflate(R.i.egc, this.WtX, false);
      float f = com.tencent.mm.ci.a.ez(getContext());
      localCdnImageView = (CdnImageView)((View)localObject1).findViewById(R.h.icon_iv);
      i = localCdnImageView.getLayoutParams().height;
      localCdnImageView.getLayoutParams().height = ((int)(i * f));
      localCdnImageView.getLayoutParams().width = ((int)(f * i));
      localCdnImageView.requestLayout();
      localObject2 = (TextView)((View)localObject1).findViewById(R.h.title_tv);
      af.bjF();
      af.bjF();
      String str2 = com.tencent.mm.ao.e.vJ(0);
      if ((str2 == null) || (str2.length() <= 0)) {
        break label332;
      }
      ((TextView)localObject2).setText(str2);
    }
    for (;;)
    {
      af.bjF();
      i = com.tencent.mm.ao.e.biS();
      if (i != 0) {
        ((TextView)localObject2).setTextColor(i);
      }
      af.bjF();
      localObject2 = com.tencent.mm.ao.e.biR();
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        localCdnImageView.setUrl((String)localObject2);
      }
      this.WtX.addView((View)localObject1);
      ((View)localObject1).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33927);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          i.u(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatConversationUI.BizChatConversationFmUI.d(BizChatConversationUI.BizChatConversationFmUI.this), 4);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33927);
        }
      });
      i.t(getContext(), this.syN, 4);
      i.cJ(getContext(), str1);
      if (this.WtX == null) {
        break label352;
      }
      if (this.Wua != 2) {
        break;
      }
      this.WtX.setVisibility(0);
      AppMethodBeat.o(33946);
      return;
      label332:
      ((TextView)localObject2).setText(R.l.eCz);
    }
    this.WtX.setVisibility(8);
    label352:
    AppMethodBeat.o(33946);
  }
  
  private String hLi()
  {
    AppMethodBeat.i(33948);
    if (Util.isNullOrNil(this.eZR)) {
      this.eZR = af.bjv().Uo(this.syN).Zf();
    }
    String str = this.eZR;
    AppMethodBeat.o(33948);
    return str;
  }
  
  public final void a(int paramInt, q paramq)
  {
    AppMethodBeat.i(33945);
    if (this.tipDialog != null)
    {
      this.tipDialog.dismiss();
      this.tipDialog = null;
    }
    if (paramq.getType() == 1355)
    {
      paramq = ((o)paramq).bjS();
      paramq = af.bjx().Va(paramq.SqS.SXD.RUi);
      if (paramq == null)
      {
        Toast.makeText(MMApplicationContext.getContext(), getString(R.l.eQP), 0).show();
        AppMethodBeat.o(33945);
        return;
      }
      Vy(paramq.field_bizChatLocalId);
    }
    AppMethodBeat.o(33945);
  }
  
  public int getLayoutId()
  {
    return R.i.egb;
  }
  
  public String getUserName()
  {
    AppMethodBeat.i(33939);
    if (Util.isNullOrNil(this.eZR))
    {
      str = this.syN;
      AppMethodBeat.o(33939);
      return str;
    }
    String str = this.eZR;
    AppMethodBeat.o(33939);
    return str;
  }
  
  public void onActivityCreated(final Bundle paramBundle)
  {
    AppMethodBeat.i(33938);
    super.onActivityCreated(paramBundle);
    this.syN = thisActivity().getIntent().getStringExtra("Contact_User");
    Log.i("MicroMsg.BizChatConversationFmUI", "[registerListener]");
    af.bjy().a(this.Wuc, thisActivity().getMainLooper());
    af.bjx().a(this.Wud, thisActivity().getMainLooper());
    af.bjF().a(this.Wue, thisActivity().getMainLooper());
    bh.beI();
    com.tencent.mm.model.c.bbR().add(this);
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eLr);
    this.snr = ((ListView)findViewById(R.h.tmessage_lv));
    try
    {
      hLh();
      label142:
      this.WtY = new b(thisActivity(), new v.a()
      {
        public final void bxN()
        {
          AppMethodBeat.i(33934);
          BizChatConversationUI.BizChatConversationFmUI.this.setMMTitle(aa.PJ(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)));
          if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount() <= 0)
          {
            BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
            AppMethodBeat.o(33934);
            return;
          }
          BizChatConversationUI.BizChatConversationFmUI.i(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(8);
          if (BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
            BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).setVisibility(0);
          }
          AppMethodBeat.o(33934);
        }
      }, this.syN);
      this.WtY.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dO(View paramAnonymousView)
        {
          AppMethodBeat.i(33935);
          int i = BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(33935);
          return i;
        }
      });
      this.WtY.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(33936);
          BizChatConversationUI.BizChatConversationFmUI.j(BizChatConversationUI.BizChatConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(33936);
        }
      });
      this.WtY.a(new MMSlideDelView.f()
      {
        public final void cW(Object paramAnonymousObject)
        {
          AppMethodBeat.i(33914);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
            AppMethodBeat.o(33914);
            return;
          }
          AppMethodBeat.o(33914);
        }
      });
      this.snr.setAdapter(this.WtY);
      this.snt = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(33930);
          switch (paramAnonymousMenuItem.getItemId())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(33930);
            return;
            BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            AppMethodBeat.o(33930);
            return;
            com.tencent.mm.ui.h.c(BizChatConversationUI.BizChatConversationFmUI.this.thisActivity(), new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(219915);
                af.bjy().Gu(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
                if (af.bjy().UV(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this)) <= 0)
                {
                  bh.beI();
                  com.tencent.mm.model.c.bbR().bwv(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
                }
                AppMethodBeat.o(219915);
              }
            });
            AppMethodBeat.o(33930);
            return;
            paramAnonymousMenuItem = af.bjy().Gt(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            paramAnonymousMenuItem.field_unReadCount = 1;
            paramAnonymousMenuItem.field_atCount = 0;
            paramAnonymousMenuItem.field_atAll = 0;
            af.bjy().b(paramAnonymousMenuItem);
            com.tencent.mm.modelstat.b.mcf.X(paramAnonymousMenuItem.field_brandUserName, true);
            AppMethodBeat.o(33930);
            return;
            af.bjy().Gv(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            paramAnonymousMenuItem = af.bjy().Gt(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            com.tencent.mm.modelstat.b.mcf.X(paramAnonymousMenuItem.field_brandUserName, false);
            AppMethodBeat.o(33930);
            return;
            paramAnonymousMenuItem = af.bjy().Gt(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            if (af.bjy().Gw(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this)))
            {
              af.bjy().Gy(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
              com.tencent.mm.modelstat.b.mcf.c(true, paramAnonymousMenuItem.field_brandUserName, false);
              AppMethodBeat.o(33930);
              return;
            }
            af.bjy().Gx(BizChatConversationUI.BizChatConversationFmUI.e(BizChatConversationUI.BizChatConversationFmUI.this));
            com.tencent.mm.modelstat.b.mcf.c(true, paramAnonymousMenuItem.field_brandUserName, true);
          }
        }
      };
      paramBundle = new com.tencent.mm.ui.widget.b.a(thisActivity());
      this.snr.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(33931);
          if (paramAnonymousMotionEvent.getAction() == 0)
          {
            BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawX());
            BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, (int)paramAnonymousMotionEvent.getRawY());
          }
          AppMethodBeat.o(33931);
          return false;
        }
      });
      this.snr.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(33932);
          paramBundle.a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizChatConversationUI.BizChatConversationFmUI.this, BizChatConversationUI.BizChatConversationFmUI.f(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.g(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.h(BizChatConversationUI.BizChatConversationFmUI.this));
          AppMethodBeat.o(33932);
          return true;
        }
      });
      this.snr.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(33933);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          paramAnonymousAdapterView = (com.tencent.mm.ao.a.a)BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getItem(paramAnonymousInt);
          BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this, paramAnonymousAdapterView.field_bizChatId);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(33933);
        }
      });
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(33915);
          BizChatConversationUI.BizChatConversationFmUI.this.finish();
          AppMethodBeat.o(33915);
          return true;
        }
      });
      addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(33916);
          Log.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
          Object localObject = new Intent(BizChatConversationUI.BizChatConversationFmUI.this.getContext(), BizChatSearchUI.class);
          ((Intent)localObject).putExtra("enterprise_biz_name", BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
          ((Intent)localObject).putExtra("biz_chat_search_scene", 1);
          ((Intent)localObject).putExtra("biz_chat_search_text", "");
          ((Intent)localObject).addFlags(67108864);
          paramAnonymousMenuItem = BizChatConversationUI.BizChatConversationFmUI.this;
          localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramAnonymousMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousMenuItem, "com/tencent/mm/ui/bizchat/BizChatConversationUI$BizChatConversationFmUI$12", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(33916);
          return true;
        }
      });
      addIconOptionMenu(2, R.l.actionbar_title_new_group_chat, R.k.actionbar_icon_dark_add, new com.tencent.mm.ui.conversation.presenter.b(this.ui, hLi()));
      paramBundle = af.bjz().gn(this.syN);
      this.WtZ = af.bjz().gm(paramBundle);
      String str = this.syN;
      boolean bool;
      if (this.WtZ == null)
      {
        bool = true;
        Log.i("MicroMsg.BizChatConversationFmUI", "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s", new Object[] { str, paramBundle, Boolean.valueOf(bool) });
        if ((Util.isNullOrNil(paramBundle)) || (this.WtZ == null) || (this.WtZ.bjN()) || (Util.isNullOrNil(this.WtZ.field_addMemberUrl)))
        {
          af.bjE();
          com.tencent.mm.ao.a.h.a(this.syN, this);
          paramBundle = thisActivity();
          getString(R.l.app_tip);
          this.tipDialog = com.tencent.mm.ui.base.h.a(paramBundle, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(196812);
              BizChatConversationUI.BizChatConversationFmUI.this.finish();
              AppMethodBeat.o(196812);
            }
          });
        }
        bh.aHJ().postToWorkerDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(224186);
            Log.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
            LinkedList localLinkedList1 = new LinkedList();
            LinkedList localLinkedList2 = new LinkedList();
            Cursor localCursor = af.bjy().UX(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            if (localCursor.moveToFirst()) {
              while (!localCursor.isAfterLast())
              {
                Object localObject = new com.tencent.mm.ao.a.a();
                ((com.tencent.mm.ao.a.a)localObject).convertFrom(localCursor);
                localCursor.moveToNext();
                localObject = af.bjx().bF(((com.tencent.mm.ao.a.a)localObject).field_bizChatId);
                if (((com.tencent.mm.ao.a.c)localObject).bjN()) {
                  if (((com.tencent.mm.ao.a.c)localObject).bjM()) {
                    localLinkedList2.add(((com.tencent.mm.ao.a.c)localObject).field_bizChatServId);
                  } else {
                    localLinkedList1.add(((com.tencent.mm.ao.a.c)localObject).field_bizChatServId);
                  }
                }
              }
            }
            localCursor.close();
            if (localLinkedList2.size() > 0) {
              af.bjE().b(localLinkedList2, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            }
            BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, localLinkedList1);
            if (localLinkedList1.size() > 0) {
              af.bjE().c(localLinkedList1, BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            }
            AppMethodBeat.o(224186);
          }
        }, 300L);
        paramBundle = hLi();
        if (paramBundle == null) {
          break label639;
        }
        af.bjF();
        com.tencent.mm.ao.e.a(paramBundle, null);
        Log.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", new Object[] { paramBundle });
      }
      for (;;)
      {
        this.Wub = af.bjF().Uj(hLi());
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(33913);
            Object localObject = af.bjv().Uo(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
            BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this, ((com.tencent.mm.api.c)localObject).Zf());
            int m = BizChatConversationUI.BizChatConversationFmUI.this.thisActivity().getIntent().getIntExtra("biz_chat_from_scene", 7);
            int i = -1;
            if (BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this) != null) {
              i = BizChatConversationUI.BizChatConversationFmUI.b(BizChatConversationUI.BizChatConversationFmUI.this).getCount();
            }
            localObject = af.bjF().Uj(BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this));
            int j;
            int k;
            label112:
            int n;
            long l1;
            if (localObject != null)
            {
              j = ((com.tencent.mm.ao.d)localObject).field_qyUin;
              if (localObject == null) {
                break label341;
              }
              k = ((com.tencent.mm.ao.d)localObject).field_userUin;
              n = af.bjF().Ul(BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this));
              if (localObject == null) {
                break label346;
              }
              l1 = ((com.tencent.mm.ao.d)localObject).field_wwCorpId;
              label139:
              if (localObject == null) {
                break label352;
              }
            }
            label341:
            label346:
            label352:
            for (long l2 = ((com.tencent.mm.ao.d)localObject).field_wwUserVid;; l2 = 0L)
            {
              com.tencent.mm.plugin.report.service.h.IzE.a(12648, new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
              Log.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", new Object[] { BizChatConversationUI.BizChatConversationFmUI.c(BizChatConversationUI.BizChatConversationFmUI.this), BizChatConversationUI.BizChatConversationFmUI.a(BizChatConversationUI.BizChatConversationFmUI.this), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2) });
              AppMethodBeat.o(33913);
              return false;
              j = 0;
              break;
              k = 0;
              break label112;
              l1 = 0L;
              break label139;
            }
          }
        });
        paramBundle = thisActivity().getIntent();
        if (IntentUtil.getBooleanExtra(paramBundle, "biz_chat_need_to_jump_to_chatting_ui", false))
        {
          long l = paramBundle.getLongExtra("biz_chat_chat_id", -1L);
          if (l != -1L) {
            Vy(l);
          }
        }
        AppMethodBeat.o(33938);
        return;
        bool = false;
        break;
        label639:
        Log.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
      }
    }
    catch (NullPointerException paramBundle)
    {
      break label142;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, final Intent paramIntent)
  {
    AppMethodBeat.i(33944);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(33944);
      return;
    }
    switch (paramInt1)
    {
    default: 
      AppMethodBeat.o(33944);
      return;
    }
    paramIntent = paramIntent.getBundleExtra("result_data");
    Object localObject;
    bms localbms;
    if (paramIntent != null)
    {
      Log.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
      localObject = paramIntent.getString("enterprise_members");
      localbms = new bms();
      com.tencent.mm.ao.a.c localc = new com.tencent.mm.ao.a.c();
      if (this.WtZ != null)
      {
        paramIntent = this.WtZ.field_addMemberUrl;
        localc.field_addMemberUrl = paramIntent;
        localc.field_brandUserName = this.syN;
        if (!com.tencent.mm.ao.a.e.a(localc, (String)localObject, null, localbms)) {
          break label258;
        }
        if (localc.field_bizChatLocalId == -1L) {
          break label198;
        }
        Vy(localc.field_bizChatLocalId);
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        Toast.makeText(thisActivity(), getString(R.l.eQP), 0).show();
        AppMethodBeat.o(33944);
        return;
        paramIntent = null;
        break;
        label198:
        af.bjE();
        paramIntent = com.tencent.mm.ao.a.h.a(this.syN, localbms, this);
        localObject = thisActivity();
        getString(R.l.app_tip);
        this.tipDialog = com.tencent.mm.ui.base.h.a((Context)localObject, getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(288502);
            af.bjE();
            com.tencent.mm.ao.a.h.d(paramIntent);
            AppMethodBeat.o(288502);
          }
        });
        paramInt1 = 1;
        continue;
        label258:
        paramInt1 = 0;
        continue;
      }
      AppMethodBeat.o(33944);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(33943);
    paramView = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenuInfo = (com.tencent.mm.ao.a.a)this.WtY.getItem(paramView.position);
    this.syu = paramContextMenuInfo.field_bizChatId;
    if (paramContextMenuInfo.field_unReadCount <= 0)
    {
      paramContextMenu.add(paramView.position, 1, 1, R.l.eLl);
      af.bjy();
      if (!com.tencent.mm.ao.a.b.c(paramContextMenuInfo)) {
        break label126;
      }
      paramContextMenu.add(paramView.position, 3, 2, R.l.eLm);
    }
    for (;;)
    {
      paramContextMenu.add(paramView.position, 0, 3, R.l.main_delete);
      AppMethodBeat.o(33943);
      return;
      paramContextMenu.add(paramView.position, 2, 1, R.l.eLj);
      break;
      label126:
      paramContextMenu.add(paramView.position, 3, 2, R.l.eLk);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(33940);
    Log.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
    af.bjy().a(this.Wuc);
    af.bjx().a(this.Wud);
    af.bjF().a(this.Wue);
    if (bh.aHB())
    {
      bh.beI();
      com.tencent.mm.model.c.bbR().remove(this);
    }
    this.WtY.eKd();
    this.WtY.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(33940);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject) {}
  
  public void onPause()
  {
    AppMethodBeat.i(33942);
    Log.i("MicroMsg.BizChatConversationFmUI", "on pause");
    bh.beI();
    com.tencent.mm.model.c.bbR().bwz(this.syN);
    com.tencent.mm.ao.a.b localb = af.bjy();
    String str = this.syN;
    if (Util.isNullOrNil(str)) {
      Log.e("MicroMsg.BizConversationStorage", "brandUserName is null");
    }
    for (;;)
    {
      if (this.WtY != null) {
        this.WtY.onPause();
      }
      this.isCurrentActivity = false;
      bh.getNotification().JP("");
      super.onPause();
      AppMethodBeat.o(33942);
      return;
      str = "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'";
      Log.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", new Object[] { Boolean.valueOf(localb.db.execSQL("BizChatConversation", str)), str });
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(33941);
    super.onResume();
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.syN);
    if ((localas == null) || (!com.tencent.mm.contact.d.rk(localas.field_type)))
    {
      Log.w("MicroMsg.BizChatConversationFmUI", "onResume is not contact now");
      finish();
      AppMethodBeat.o(33941);
      return;
    }
    com.tencent.mm.api.c localc = g.gu(this.syN);
    if ((localc == null) || (localc.field_enterpriseFather == null) || (!ab.Ql(localc.field_enterpriseFather)))
    {
      Log.w("MicroMsg.BizChatConversationFmUI", "onResume enterpriseFather is invalid");
      finish();
      AppMethodBeat.o(33941);
      return;
    }
    if (localas.aeg()) {
      setTitleMuteIconVisibility(0);
    }
    for (;;)
    {
      this.isCurrentActivity = true;
      this.WtY.onNotifyChange(null, null);
      bh.getNotification().JP(this.syN);
      AppMethodBeat.o(33941);
      return;
      setTitleMuteIconVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI
 * JD-Core Version:    0.7.0.1
 */