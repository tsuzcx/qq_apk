package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.v.a;
import java.util.HashMap;
import java.util.LinkedList;

public class BizConversationUI$BizConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
{
  private ListView XzG;
  private a XzH;
  private String XzI;
  private az conversation;
  private TextView emptyTipTv;
  private boolean isDeleteCancel;
  private String lEm;
  private q.g sBv;
  private long sBz;
  private IListener sCF;
  private int source;
  private int syc;
  private int syd;
  private com.tencent.mm.ui.widget.b.a szq;
  private String talker;
  private s tipDialog;
  
  public BizConversationUI$BizConversationFmUI()
  {
    AppMethodBeat.i(38258);
    this.source = 1;
    this.talker = "";
    this.sBz = 0L;
    this.syc = 0;
    this.syd = 0;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.sBv = new BizConversationUI.BizConversationFmUI.9(this);
    this.sCF = new BizConversationUI.BizConversationFmUI.10(this);
    AppMethodBeat.o(38258);
  }
  
  public int getLayoutId()
  {
    return R.i.tmessage;
  }
  
  public String getUserName()
  {
    return this.lEm;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(38259);
    super.onActivityCreated(paramBundle);
    this.lEm = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    if (Util.isNullOrNil(this.lEm)) {
      this.lEm = "officialaccounts";
    }
    this.source = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
    if (Util.nullAsNil(this.lEm).equals("officialaccounts")) {
      com.tencent.mm.plugin.report.service.h.IzE.a(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.source), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    this.XzI = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    if (Util.isNullOrNil(this.XzI)) {
      this.XzI = getString(R.l.esM);
    }
    setMMTitle(this.XzI);
    this.XzG = ((ListView)findViewById(R.h.tmessage_lv));
    this.emptyTipTv = ((TextView)findViewById(R.h.empty_msg_tip_tv));
    this.emptyTipTv.setText(R.l.eCf);
    setBackBtn(new BizConversationUI.BizConversationFmUI.13(this));
    setToTop(new BizConversationUI.BizConversationFmUI.14(this));
    this.XzH = new a(thisActivity(), this.lEm, new v.a()
    {
      public final void bxN()
      {
        AppMethodBeat.i(38250);
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount());
        AppMethodBeat.o(38250);
      }
    });
    this.XzH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38251);
        int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38251);
        return i;
      }
    });
    this.XzH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38252);
        BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38252);
      }
    });
    this.XzG.setAdapter(this.XzH);
    this.szq = new com.tencent.mm.ui.widget.b.a(thisActivity());
    this.XzG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38253);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (az)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
        paramAnonymousAdapterView = BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this);
        if (paramAnonymousAdapterView == null)
        {
          Log.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getCount()) });
          BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).notifyDataSetChanged();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38253);
          return;
        }
        paramAnonymousView = new Bundle();
        paramAnonymousView.putInt("biz_click_item_unread_count", BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_unReadCount);
        paramAnonymousView.putInt("biz_click_item_position", paramAnonymousInt + 1);
        paramAnonymousView.putInt("KOpenArticleSceneFromScene", 131);
        paramAnonymousView.putInt("specific_chat_from_scene", 1);
        BizConversationUI.BizConversationFmUI.this.ui.startChatting(paramAnonymousAdapterView.field_username, paramAnonymousView, true);
        BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousAdapterView, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BizConversationUI$BizConversationFmUI$9", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(38253);
      }
    });
    this.XzG.setOnTouchListener(new BizConversationUI.BizConversationFmUI.2(this));
    this.XzG.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38237);
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, (az)BizConversationUI.BizConversationFmUI.e(BizConversationUI.BizConversationFmUI.this).getItem(paramAnonymousInt));
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.f(BizConversationUI.BizConversationFmUI.this).field_username);
        BizConversationUI.BizConversationFmUI.j(BizConversationUI.BizConversationFmUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, BizConversationUI.BizConversationFmUI.this, BizConversationUI.BizConversationFmUI.g(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.h(BizConversationUI.BizConversationFmUI.this), BizConversationUI.BizConversationFmUI.i(BizConversationUI.BizConversationFmUI.this));
        AppMethodBeat.o(38237);
        return true;
      }
    });
    this.XzH.setGetViewPositionCallback(new MMSlideDelView.c()
    {
      public final int dO(View paramAnonymousView)
      {
        AppMethodBeat.i(38238);
        int i = BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).getPositionForView(paramAnonymousView);
        AppMethodBeat.o(38238);
        return i;
      }
    });
    this.XzH.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(38239);
        BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(38239);
      }
    });
    this.XzH.a(new BizConversationUI.BizConversationFmUI.6(this));
    if ("officialaccounts".equals(this.lEm))
    {
      paramBundle = com.tencent.mm.plugin.bizui.a.a.shG;
      boolean bool = com.tencent.mm.plugin.bizui.a.a.cxR();
      Log.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(1, R.l.top_item_desc_search, R.k.actionbar_icon_dark_search, new BizConversationUI.BizConversationFmUI.1(this));
      }
    }
    bh.beI();
    c.bbR().add(this.XzH);
    this.sBz = System.currentTimeMillis();
    EventCenter.instance.addListener(this.sCF);
    Looper.myQueue().addIdleHandler(new BizConversationUI.BizConversationFmUI.11(this));
    AppMethodBeat.o(38259);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38263);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38263);
      return;
    }
    AppMethodBeat.o(38263);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(38264);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    bh.beI();
    as localas = c.bbL().RG(this.talker);
    if (localas == null)
    {
      Log.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(38264);
      return;
    }
    String str = localas.ays();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (Util.isNullOrNil(localas.field_nickname)) {
        paramView = getString(R.l.ewS);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(l.c(thisActivity(), paramView));
    if (d.rk(localas.field_type))
    {
      if (!localas.ayn()) {
        break label208;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.eLm);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, R.l.eLi);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, R.l.main_delete);
      AppMethodBeat.o(38264);
      return;
      label208:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, R.l.contact_info_stick_biz);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38260);
    bh.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38247);
        BizConversationUI.BizConversationFmUI.a(BizConversationUI.BizConversationFmUI.this);
        BizConversationUI.BizConversationFmUI.b(BizConversationUI.BizConversationFmUI.this);
        BizConversationUI.BizConversationFmUI.c(BizConversationUI.BizConversationFmUI.this);
        AppMethodBeat.o(38247);
      }
    });
    EventCenter.instance.removeListener(this.sCF);
    if (bh.aHB())
    {
      bh.beI();
      c.bbR().remove(this.XzH);
    }
    if (this.XzH != null) {
      this.XzH.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(38260);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38262);
    Log.i("MicroMsg.BizConversationUI", "on pause");
    bh.beI();
    c.bbR().bwz(this.lEm);
    if (this.XzH != null) {
      this.XzH.onPause();
    }
    super.onPause();
    AppMethodBeat.o(38262);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38261);
    Log.v("MicroMsg.BizConversationUI", "on resume");
    if (this.XzH != null) {
      this.XzH.onResume();
    }
    super.onResume();
    AppMethodBeat.o(38261);
  }
  
  static final class a
    extends f
  {
    private String fOX;
    HashMap<String, BizConversationUI.BizConversationFmUI.b> sIz;
    
    public a(Context paramContext, String paramString, v.a parama)
    {
      super(parama);
      AppMethodBeat.i(38254);
      this.fOX = paramString;
      this.sIz = new HashMap();
      AppMethodBeat.o(38254);
    }
    
    public final void a(az paramaz, int paramInt)
    {
      AppMethodBeat.i(38257);
      bh.beI();
      a(paramaz, c.bbR().h(paramaz), paramInt, true);
      AppMethodBeat.o(38257);
    }
    
    protected final void a(az paramaz, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(38256);
      if (paramaz == null)
      {
        AppMethodBeat.o(38256);
        return;
      }
      BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.sIz.get(paramaz.field_username);
      if (localb == null)
      {
        localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
        this.sIz.put(paramaz.field_username, localb);
      }
      for (;;)
      {
        if (localb.maV > 0)
        {
          AppMethodBeat.o(38256);
          return;
        }
        localb.UcA = paramBoolean1;
        if ((localb.UcD) || (paramaz.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.UcD = paramBoolean1;
          localb.CRl = (paramInt + 1);
          if (paramBoolean2) {
            localb.maV = localb.CRl;
          }
          localb.UcC = ((int)(System.currentTimeMillis() / 1000L));
          if (paramaz.field_lastSeq != localb.seq) {
            break;
          }
          AppMethodBeat.o(38256);
          return;
        }
        localb.seq = paramaz.field_lastSeq;
        paramaz = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOH(paramaz.field_username);
        if ((paramaz != null) && (paramaz.hwA()))
        {
          paramaz = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramaz.field_msgId, paramaz.field_content);
          if ((paramaz != null) && (!Util.isNullOrNil(paramaz.lpz)) && (!Util.isNullOrNil(((v)paramaz.lpz.get(0)).url))) {
            try
            {
              paramaz = Uri.parse(((v)paramaz.lpz.get(0)).url);
              localb.Ucy = Util.getLong(paramaz.getQueryParameter("mid"), 0L);
              localb.Ucz = Util.getInt(paramaz.getQueryParameter("idx"), 0);
              AppMethodBeat.o(38256);
              return;
            }
            catch (UnsupportedOperationException paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
              AppMethodBeat.o(38256);
              return;
            }
            catch (Exception paramaz)
            {
              Log.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramaz.getMessage() });
            }
          }
        }
        AppMethodBeat.o(38256);
        return;
      }
    }
    
    public final void atr()
    {
      AppMethodBeat.i(38255);
      bh.beI();
      v(c.bbR().a(1, this.jkb, this.fOX));
      if (this.VZc != null) {
        this.VZc.bxN();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(38255);
    }
  }
  
  static final class b
    extends dws
  {
    public int maV = -1;
    public long seq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI
 * JD-Core Version:    0.7.0.1
 */