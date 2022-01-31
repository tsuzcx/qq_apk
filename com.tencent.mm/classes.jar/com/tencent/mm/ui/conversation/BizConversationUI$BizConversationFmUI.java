package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.q;
import com.tencent.mm.aj.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.btr;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BizConversationUI$BizConversationFmUI
  extends BaseConversationUI.BaseConversationFmUI
{
  private ListView Ahc;
  private a Ahd;
  private String Ahe;
  private ak conversation;
  private int cpt;
  private TextView emptyTipTv;
  private String fuO;
  private boolean isDeleteCancel;
  private int jUm;
  private int jUn;
  private com.tencent.mm.ui.widget.c.a jVd;
  private long jWX;
  private n.d jWw;
  private com.tencent.mm.sdk.b.c jXg;
  private String talker;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public BizConversationUI$BizConversationFmUI()
  {
    AppMethodBeat.i(34140);
    this.cpt = 1;
    this.talker = "";
    this.jWX = 0L;
    this.jUm = 0;
    this.jUn = 0;
    this.tipDialog = null;
    this.isDeleteCancel = false;
    this.jWw = new BizConversationUI.BizConversationFmUI.9(this);
    this.jXg = new BizConversationUI.BizConversationFmUI.10(this);
    AppMethodBeat.o(34140);
  }
  
  public int getLayoutId()
  {
    return 2130971000;
  }
  
  public String getUserName()
  {
    return this.fuO;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(34141);
    super.onActivityCreated(paramBundle);
    this.fuO = thisActivity().getIntent().getStringExtra("enterprise_biz_name");
    if (bo.isNullOrNil(this.fuO)) {
      this.fuO = "officialaccounts";
    }
    this.cpt = thisActivity().getIntent().getIntExtra("biz_enter_source", 1);
    if (bo.nullAsNil(this.fuO).equals("officialaccounts")) {
      com.tencent.mm.plugin.report.service.h.qsU.e(11404, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf((int)(System.currentTimeMillis() / 1000L)), Integer.valueOf(this.cpt), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    }
    this.Ahe = thisActivity().getIntent().getStringExtra("enterprise_biz_display_name");
    if (bo.isNullOrNil(this.Ahe)) {
      this.Ahe = getString(2131297675);
    }
    setMMTitle(this.Ahe);
    this.Ahc = ((ListView)findViewById(2131823736));
    this.emptyTipTv = ((TextView)findViewById(2131821852));
    this.emptyTipTv.setText(2131299293);
    setBackBtn(new BizConversationUI.BizConversationFmUI.13(this));
    setToTop(new BizConversationUI.BizConversationFmUI.14(this));
    this.Ahd = new a(thisActivity(), this.fuO, new BizConversationUI.BizConversationFmUI.15(this));
    this.Ahd.setGetViewPositionCallback(new BizConversationUI.BizConversationFmUI.16(this));
    this.Ahd.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(34134);
        BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(34134);
      }
    });
    this.Ahc.setAdapter(this.Ahd);
    this.jVd = new com.tencent.mm.ui.widget.c.a(thisActivity());
    this.Ahc.setOnItemClickListener(new BizConversationUI.BizConversationFmUI.18(this));
    this.Ahc.setOnTouchListener(new BizConversationUI.BizConversationFmUI.2(this));
    this.Ahc.setOnItemLongClickListener(new BizConversationUI.BizConversationFmUI.3(this));
    this.Ahd.setGetViewPositionCallback(new BizConversationUI.BizConversationFmUI.4(this));
    this.Ahd.setPerformItemClickListener(new MMSlideDelView.g()
    {
      public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(34120);
        BizConversationUI.BizConversationFmUI.d(BizConversationUI.BizConversationFmUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
        AppMethodBeat.o(34120);
      }
    });
    this.Ahd.a(new BizConversationUI.BizConversationFmUI.6(this));
    if ("officialaccounts".equals(this.fuO))
    {
      paramBundle = com.tencent.mm.model.c.c.abU().me("100045");
      if ((!paramBundle.isValid()) || (!"1".equals(paramBundle.dvN().get("isOpenSearch")))) {
        break label619;
      }
    }
    label619:
    for (boolean bool = true;; bool = false)
    {
      ab.d("MicroMsg.BizConversationUI", "open search entrance:%b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        addIconOptionMenu(1, 2131304318, 2131230741, new BizConversationUI.BizConversationFmUI.1(this));
      }
      aw.aaz();
      com.tencent.mm.model.c.YF().a(this.Ahd);
      this.jWX = System.currentTimeMillis();
      com.tencent.mm.sdk.b.a.ymk.c(this.jXg);
      Looper.myQueue().addIdleHandler(new BizConversationUI.BizConversationFmUI.11(this));
      AppMethodBeat.o(34141);
      return;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34145);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.talker != null) && (!this.talker.isEmpty())) {
      this.talker = "";
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34145);
      return;
    }
    AppMethodBeat.o(34145);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(34146);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    aw.aaz();
    ad localad = com.tencent.mm.model.c.YA().arw(this.talker);
    if (localad == null)
    {
      ab.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.talker);
      AppMethodBeat.o(34146);
      return;
    }
    String str = localad.Of();
    paramView = str;
    if (str.toLowerCase().endsWith("@chatroom"))
    {
      paramView = str;
      if (bo.isNullOrNil(localad.field_nickname)) {
        paramView = getString(2131298302);
      }
    }
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(thisActivity(), paramView));
    if (com.tencent.mm.n.a.je(localad.field_type))
    {
      if (!localad.Oa()) {
        break label208;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131301406);
    }
    for (;;)
    {
      paramContextMenu.add(paramContextMenuInfo.position, 2, 0, 2131301402);
      paramContextMenu.add(paramContextMenuInfo.position, 3, 0, 2131301410);
      AppMethodBeat.o(34146);
      return;
      label208:
      paramContextMenu.add(paramContextMenuInfo.position, 1, 0, 2131298813);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34142);
    aw.RO().ac(new BizConversationUI.BizConversationFmUI.12(this));
    com.tencent.mm.sdk.b.a.ymk.d(this.jXg);
    if (aw.RG())
    {
      aw.aaz();
      com.tencent.mm.model.c.YF().b(this.Ahd);
    }
    if (this.Ahd != null) {
      this.Ahd.onDestroy();
    }
    super.onDestroy();
    AppMethodBeat.o(34142);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34144);
    ab.i("MicroMsg.BizConversationUI", "on pause");
    aw.aaz();
    com.tencent.mm.model.c.YF().arJ(this.fuO);
    if (this.Ahd != null) {
      this.Ahd.onPause();
    }
    super.onPause();
    AppMethodBeat.o(34144);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34143);
    ab.v("MicroMsg.BizConversationUI", "on resume");
    if (this.Ahd != null) {
      this.Ahd.onResume();
    }
    super.onResume();
    AppMethodBeat.o(34143);
  }
  
  static final class a
    extends e
  {
    private String cCC;
    HashMap<String, BizConversationUI.BizConversationFmUI.b> jWA;
    
    public a(Context paramContext, String paramString, p.a parama)
    {
      super(parama);
      AppMethodBeat.i(34136);
      this.cCC = paramString;
      this.jWA = new HashMap();
      AppMethodBeat.o(34136);
    }
    
    public final void Ku()
    {
      AppMethodBeat.i(34137);
      aw.aaz();
      setCursor(com.tencent.mm.model.c.YF().c(t.flc, this.ejc, this.cCC));
      if (this.zaq != null) {
        this.zaq.apT();
      }
      super.notifyDataSetChanged();
      AppMethodBeat.o(34137);
    }
    
    public final void a(ak paramak, int paramInt)
    {
      AppMethodBeat.i(34139);
      aw.aaz();
      a(paramak, com.tencent.mm.model.c.YF().g(paramak), paramInt, true);
      AppMethodBeat.o(34139);
    }
    
    protected final void a(ak paramak, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    {
      AppMethodBeat.i(34138);
      if (paramak == null)
      {
        AppMethodBeat.o(34138);
        return;
      }
      BizConversationUI.BizConversationFmUI.b localb = (BizConversationUI.BizConversationFmUI.b)this.jWA.get(paramak.field_username);
      if (localb == null)
      {
        localb = new BizConversationUI.BizConversationFmUI.b((byte)0);
        this.jWA.put(paramak.field_username, localb);
      }
      for (;;)
      {
        if (localb.fQt > 0)
        {
          AppMethodBeat.o(34138);
          return;
        }
        localb.xHg = paramBoolean1;
        if ((localb.xHj) || (paramak.field_unReadCount > 0)) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          localb.xHj = paramBoolean1;
          localb.ntX = (paramInt + 1);
          if (paramBoolean2) {
            localb.fQt = localb.ntX;
          }
          localb.xHi = ((int)(System.currentTimeMillis() / 1000L));
          if (paramak.field_lastSeq != localb.xyE) {
            break;
          }
          AppMethodBeat.o(34138);
          return;
        }
        localb.xyE = paramak.field_lastSeq;
        paramak = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tm(paramak.field_username);
        if ((paramak != null) && (paramak.dvV()))
        {
          paramak = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(paramak.field_msgId, paramak.field_content);
          if ((paramak != null) && (!bo.es(paramak.fjy)) && (!bo.isNullOrNil(((q)paramak.fjy.get(0)).url))) {
            try
            {
              paramak = Uri.parse(((q)paramak.fjy.get(0)).url);
              localb.xHe = bo.getLong(paramak.getQueryParameter("mid"), 0L);
              localb.xHf = bo.getInt(paramak.getQueryParameter("idx"), 0);
              AppMethodBeat.o(34138);
              return;
            }
            catch (UnsupportedOperationException paramak)
            {
              ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
              AppMethodBeat.o(34138);
              return;
            }
            catch (Exception paramak)
            {
              ab.w("MicroMsg.ConversationAdapter", "exposeLog exp %s", new Object[] { paramak.getMessage() });
            }
          }
        }
        AppMethodBeat.o(34138);
        return;
      }
    }
  }
  
  static final class b
    extends btr
  {
    public int fQt = -1;
    public long xyE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI
 * JD-Core Version:    0.7.0.1
 */