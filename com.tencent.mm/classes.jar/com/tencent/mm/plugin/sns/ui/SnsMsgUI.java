package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.g.c.au;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.ciu;
import com.tencent.mm.protocal.protobuf.cui;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.q.a;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SnsMsgUI
  extends MMActivity
  implements com.tencent.mm.al.g, b.b
{
  private long fXQ;
  private int foV;
  private int fromScene;
  private String gUq;
  private ap handler;
  private long hcE;
  private ListView list;
  private n.d mRw;
  private View mUv;
  private View nCB;
  private View nCC;
  private boolean nCD;
  private int[] qdJ;
  long wOb;
  private a xBg;
  private boolean xBh;
  private boolean xBi;
  private boolean xBj;
  private com.tencent.mm.ui.base.p xBk;
  private com.tencent.mm.ui.base.p xBl;
  private int xBm;
  private View.OnClickListener xBn;
  private k.a xBo;
  Runnable xBp;
  private long xBq;
  private long xBr;
  private int xBs;
  private int xBt;
  private HashMap<Integer, j> xBu;
  private HashMap<Integer, Integer> xBv;
  int xiF;
  private av xle;
  private SnsCmdList xne;
  private com.tencent.mm.storage.bg xwF;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.nCC = null;
    this.handler = com.tencent.mm.plugin.sns.model.af.czA();
    this.xBh = false;
    this.xBi = false;
    this.xne = new SnsCmdList();
    this.nCD = false;
    this.xBj = false;
    this.qdJ = new int[2];
    this.xBm = 86400;
    this.xBn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98853);
        if ((paramAnonymousView.getTag() instanceof aw))
        {
          SnsMsgUI.a(SnsMsgUI.this).v(paramAnonymousView, -1, 1);
          AppMethodBeat.o(98853);
          return;
        }
        if ((paramAnonymousView.getTag() instanceof j))
        {
          SnsMsgUI.a(SnsMsgUI.this, (j)paramAnonymousView.getTag());
          AppMethodBeat.o(98853);
          return;
        }
        ad.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramAnonymousView.getTag());
        AppMethodBeat.o(98853);
      }
    };
    this.fXQ = 0L;
    this.hcE = 0L;
    this.mRw = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(187705);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(187705);
          return;
          SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.xiF);
          AppMethodBeat.o(187705);
          return;
          SnsMsgUI.m(SnsMsgUI.this);
          AppMethodBeat.o(187705);
          return;
          SnsMsgUI.a(SnsMsgUI.this, false);
        }
      }
    };
    this.xBo = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(98861);
        com.tencent.mm.plugin.sns.model.af.czA().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98860);
            synchronized (SnsMsgUI.d(SnsMsgUI.this))
            {
              ad.v("MicroMsg.SnsMsgUI", "comment notify");
              SnsMsgUI.n(SnsMsgUI.this);
              SnsMsgUI.d(SnsMsgUI.this).a(null, null);
              AppMethodBeat.o(98860);
              return;
            }
          }
        });
        AppMethodBeat.o(98861);
      }
    };
    this.xBp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(98862);
        if (SnsMsgUI.d(SnsMsgUI.this) == null)
        {
          AppMethodBeat.o(98862);
          return;
        }
        synchronized (SnsMsgUI.d(SnsMsgUI.this))
        {
          SnsMsgUI.d(SnsMsgUI.this).a(null, null);
          SnsMsgUI.t(SnsMsgUI.this);
          AppMethodBeat.o(98862);
          return;
        }
      }
    };
    this.xBs = 0;
    this.xBt = 0;
    this.xBu = new HashMap();
    this.xBv = new HashMap();
    AppMethodBeat.o(98888);
  }
  
  private void a(j paramj)
  {
    AppMethodBeat.i(179213);
    long l = paramj.field_snsID;
    if (paramj != null)
    {
      if (paramj.field_type == 1)
      {
        this.xBs += 1;
        if (!this.xBv.containsKey(Integer.valueOf(paramj.xiF))) {
          break label153;
        }
        this.xBv.put(Integer.valueOf(paramj.xiF), Integer.valueOf(((Integer)this.xBv.get(Integer.valueOf(paramj.xiF))).intValue() + 1));
      }
    }
    else {
      label90:
      if ((paramj.field_commentflag & 0x2) <= 0) {
        break label175;
      }
    }
    label153:
    label175:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label180;
      }
      ad.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
      com.tencent.mm.ui.base.h.j(this, 2131763916, 2131755906);
      AppMethodBeat.o(179213);
      return;
      if (paramj.field_type != 2) {
        break;
      }
      this.xBt += 1;
      break;
      this.xBv.put(Integer.valueOf(paramj.xiF), Integer.valueOf(1));
      break label90;
    }
    label180:
    Intent localIntent = new Intent();
    localIntent.putExtra("INTENT_COMMENT_TYPE", paramj.field_type);
    if ((paramj.field_type == 3) || (paramj.field_type == 5))
    {
      localIntent.setClass(this, SnsStrangerCommentDetailUI.class);
      localIntent.putExtra("INTENT_TALKER", paramj.field_talker);
    }
    for (;;)
    {
      try
      {
        localIntent.putExtra("INTENT_SOURCE", ((cui)new cui().parseFrom(paramj.field_curActionBuf)).rNz);
        if ((paramj.field_type != 7) && (paramj.field_type != 8) && (paramj.field_type != 16)) {
          break label626;
        }
        localIntent.putExtra("INTENT_SNSID", x.bh("ad_table_", l));
        com.tencent.mm.plugin.sns.storage.p localp = com.tencent.mm.plugin.sns.model.af.dtu().apJ(x.bh("ad_table_", l));
        if (localp != null) {
          break;
        }
        ad.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
        if (paramj.field_type == 16) {
          com.tencent.mm.plugin.report.service.h.vKh.dB(955, 2);
        }
        AppMethodBeat.o(179213);
        return;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("MicroMsg.SnsMsgUI", localException, "", new Object[0]);
        continue;
      }
      localIntent.setClass(this, SnsCommentDetailUI.class);
    }
    i = com.tencent.mm.kernel.g.afB().afk().getInt(14, 0);
    ad.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localException.dxs().wTJ), Integer.valueOf(localException.dxs().wTK) });
    if ((i < localException.dxs().wTJ) || ((localException.dxs().wTK > 0) && (i > localException.dxs().wTK)))
    {
      if (!bt.isNullOrNil(localException.dxs().wTL))
      {
        paramj = new Intent();
        paramj.putExtra("rawUrl", localException.dxs().wTL);
        paramj.putExtra("showShare", false);
        paramj.putExtra("show_bottom", false);
        paramj.putExtra("needRedirect", false);
        paramj.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Cqe);
        com.tencent.mm.plugin.sns.d.a.hYt.i(paramj, this);
        AppMethodBeat.o(179213);
        return;
      }
      ad.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label626:
      localIntent.putExtra("INTENT_SNSID", x.bh("sns_table_", l));
    }
    if (paramj.field_type == 2)
    {
      localIntent.putExtra("INTENT_FROMSUI", true);
      localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramj.field_commentSvrID);
    }
    for (;;)
    {
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(179213);
      return;
      if ((paramj.field_type == 8) || (paramj.field_type == 16))
      {
        localIntent.putExtra("INTENT_FROMSUI", true);
        localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramj.field_commentSvrID);
      }
    }
  }
  
  private static String b(j paramj)
  {
    AppMethodBeat.i(98900);
    if (paramj.field_parentID == 0L)
    {
      paramj = com.tencent.mm.plugin.sns.data.q.st(paramj.field_snsID);
      AppMethodBeat.o(98900);
      return paramj;
    }
    paramj = com.tencent.mm.plugin.sns.data.q.st(paramj.field_parentID);
    AppMethodBeat.o(98900);
    return paramj;
  }
  
  public final void aob(String paramString)
  {
    AppMethodBeat.i(98896);
    this.xBg.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void by(String paramString, boolean paramBoolean) {}
  
  public final void bz(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.xne);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98897);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98897);
    return bool;
  }
  
  public final void dsp() {}
  
  public int getLayoutId()
  {
    return 2131495571;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98893);
    setMMTitle(2131763919);
    addTextOptionMenu(0, getString(2131755694), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(187708);
        com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(2131763912), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(187707);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            com.tencent.mm.plugin.sns.model.af.dtz().gPa.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(187707);
          }
        }, null);
        AppMethodBeat.o(187708);
        return true;
      }
    });
    this.xle = new av(this);
    this.mUv = findViewById(2131305011);
    this.list = ((ListView)findViewById(2131305013));
    this.nCB = y.js(this).inflate(2131495569, null);
    this.nCC = y.js(this).inflate(2131494788, null);
    ad.d("MicroMsg.SnsMsgUI", "autoLoad " + this.nCD);
    if (this.nCD)
    {
      this.list.addFooterView(this.nCC);
      this.xBg = new a(this, new j());
      this.xBg.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dw(View paramAnonymousView)
        {
          AppMethodBeat.i(187709);
          int i = SnsMsgUI.b(SnsMsgUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(187709);
          return i;
        }
      });
      this.xBg.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(187710);
          SnsMsgUI.b(SnsMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(187710);
        }
      });
      this.xBg.b(new MMSlideDelView.f()
      {
        public final void cO(Object paramAnonymousObject)
        {
          AppMethodBeat.i(187711);
          if (paramAnonymousObject == null)
          {
            ad.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            AppMethodBeat.o(187711);
            return;
          }
          try
          {
            int i = bt.aGh(paramAnonymousObject.toString());
            SnsMsgUI.a(SnsMsgUI.this, i);
            AppMethodBeat.o(187711);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            ad.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            ad.printErrStackTrace("MicroMsg.SnsMsgUI", paramAnonymousObject, "", new Object[0]);
            AppMethodBeat.o(187711);
          }
        }
      });
      this.xBg.a(new q.a()
      {
        public final void aIp()
        {
          AppMethodBeat.i(187712);
          ad.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).fwP + " unread:" + com.tencent.mm.plugin.sns.model.af.dtz().bIR() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).nCF);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).bLj()) && (com.tencent.mm.plugin.sns.model.af.dtz().bIR() == 0)) || (com.tencent.mm.plugin.sns.model.af.dtz().bIR() == com.tencent.mm.plugin.sns.model.af.dtz().dxK())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(187712);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.xBg);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(187713);
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (com.tencent.mm.plugin.sns.model.af.dtz().bIR() > 0)
            {
              com.tencent.mm.plugin.sns.model.af.dtz().bIS();
              if (SnsMsgUI.d(SnsMsgUI.this).bLj()) {
                paramAnonymousInt = 0;
              }
            }
            for (;;)
            {
              SnsMsgUI.d(SnsMsgUI.this).a(null, null);
              if (!SnsMsgUI.f(SnsMsgUI.this))
              {
                if (SnsMsgUI.e(SnsMsgUI.this).getParent() != null)
                {
                  ad.d("MicroMsg.SnsMsgUI", "remove footer");
                  SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.e(SnsMsgUI.this));
                }
                if ((SnsMsgUI.g(SnsMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
                {
                  SnsMsgUI.b(SnsMsgUI.this).addFooterView(SnsMsgUI.g(SnsMsgUI.this));
                  ad.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
              }
              SnsMsgUI.h(SnsMsgUI.this);
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
              AppMethodBeat.o(187713);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).bLk();
            }
          }
          paramAnonymousAdapterView = (j)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.N(com.tencent.mm.plugin.sns.model.af.dtu().th(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          AppMethodBeat.o(187713);
        }
      });
      new com.tencent.mm.ui.tools.l(this);
      this.list.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(187714);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(187714);
            return false;
            SnsMsgUI.this.hideVKB();
            SnsMsgUI.i(SnsMsgUI.this)[0] = ((int)paramAnonymousMotionEvent.getRawX());
            SnsMsgUI.i(SnsMsgUI.this)[1] = ((int)paramAnonymousMotionEvent.getRawY());
          }
        }
      });
      this.list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(187715);
          if (paramAnonymousInt < SnsMsgUI.b(SnsMsgUI.this).getHeaderViewsCount())
          {
            ad.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
            AppMethodBeat.o(187715);
            return true;
          }
          new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SnsMsgUI.this, SnsMsgUI.j(SnsMsgUI.this), SnsMsgUI.i(SnsMsgUI.this)[0], SnsMsgUI.i(SnsMsgUI.this)[1]);
          AppMethodBeat.o(187715);
          return true;
        }
      });
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(187703);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(187703);
            return;
          }
          ad.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 2)
          {
            WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.k(SnsMsgUI.this));
            SnsMsgUI localSnsMsgUI = SnsMsgUI.this;
            boolean bool = WXHardCoderJNI.hcSNSMsgScrollEnable;
            int i = WXHardCoderJNI.hcSNSMsgScrollDelay;
            int j = WXHardCoderJNI.hcSNSMsgScrollCPU;
            int k = WXHardCoderJNI.hcSNSMsgScrollIO;
            if (WXHardCoderJNI.hcSNSMsgScrollThr)
            {
              paramAnonymousInt = Process.myTid();
              SnsMsgUI.b(localSnsMsgUI, WXHardCoderJNI.startPerformance(bool, i, j, k, paramAnonymousInt, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI"));
              ad.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsMsgUI.k(SnsMsgUI.this)) });
            }
          }
          else
          {
            if (paramAnonymousAbsListView.getLastVisiblePosition() != paramAnonymousAbsListView.getCount() - 1) {
              break label211;
            }
            if (com.tencent.mm.plugin.sns.model.af.dtz().bIR() <= 0) {
              break label197;
            }
            com.tencent.mm.plugin.sns.model.af.dtz().bIS();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).a(null, null);
            AppMethodBeat.o(187703);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).bLk();
          }
          label211:
          AppMethodBeat.o(187703);
        }
      });
      if (this.xBg.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.mUv.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.xBg.bLj()) && (com.tencent.mm.plugin.sns.model.af.dtz().bIR() == 0)) || (com.tencent.mm.plugin.sns.model.af.dtz().bIR() == com.tencent.mm.plugin.sns.model.af.dtz().dxK())) {
        this.nCB.setVisibility(8);
      }
      if ((this.xBg.bLj()) && (this.nCD)) {
        this.list.removeFooterView(this.nCC);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(187704);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(187704);
          return true;
        }
      });
      if ((this.xBg.bLj()) && (this.nCD)) {
        this.list.removeFooterView(this.nCC);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.nCB);
      break;
      label470:
      this.list.setVisibility(0);
      this.mUv.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98895);
    ad.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(98895);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("result_finish", false)))
    {
      finish();
      AppMethodBeat.o(98895);
      return;
    }
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("sns_gallery_op_id", 0);
      this.xne.LY(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(210, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(683, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(218, this);
    this.gUq = u.aqG();
    this.xwF = com.tencent.mm.plugin.sns.model.af.dti();
    this.xBi = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.xBi) {
      this.nCD = true;
    }
    com.tencent.mm.plugin.sns.model.af.dtz().add(this.xBo);
    setActionbarColor(getActionbarColor());
    initView();
    this.xBq = bt.eGO();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    j localj = (j)this.xBg.getItem(paramContextMenuInfo.position);
    if (localj == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.xiF = localj.xiF;
    this.wOb = localj.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (cui)new cui().parseFrom(localj.field_curActionBuf);
        if (paramView != null)
        {
          com.tencent.mm.storage.af localaf = this.xwF.aHY(paramView.DZr);
          if (localaf == null) {
            continue;
          }
          paramView = localaf.ZX();
          paramContextMenu.setHeaderTitle(bt.nullAsNil(paramView));
          if (localj.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(2131761722));
        }
      }
      catch (Exception paramView)
      {
        ad.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(2131755707));
      AppMethodBeat.o(98894);
      return;
      if (!bt.isNullOrNil(paramView.ElX))
      {
        paramView = paramView.ElX;
      }
      else
      {
        paramView = paramView.DZr;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(2131761721));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    ad.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.xBr = super.getActivityBrowseTimeMs();
    if (com.tencent.mm.plugin.sns.model.af.dtz().bIR() > 0) {
      com.tencent.mm.plugin.sns.model.af.dtz().bIS();
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(210, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(683, this);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(218, this);
    com.tencent.mm.plugin.sns.model.af.dtz().remove(this.xBo);
    this.xBg.cHX();
    com.tencent.mm.plugin.sns.model.af.dtr().az(this);
    if (this.xBk != null)
    {
      this.xBk.dismiss();
      this.xBk = null;
    }
    long l = bt.GC();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.xBu.values().iterator();
    int i = 0;
    Object localObject1;
    int m;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (j)((Iterator)localObject2).next();
      if (localObject1 == null) {
        break label682;
      }
      if (((j)localObject1).field_isRead == 1)
      {
        m = 1;
        label206:
        if (m != 0) {
          break label679;
        }
        if (((j)localObject1).field_type != 1) {
          break label313;
        }
        i += 1;
        label224:
        m = 0;
        if (this.xBv.containsKey(Integer.valueOf(((j)localObject1).xiF))) {
          m = ((Integer)this.xBv.get(Integer.valueOf(((j)localObject1).xiF))).intValue();
        }
        if (localObject1 != null) {
          break label329;
        }
        localObject1 = "";
        label278:
        if (localStringBuffer.length() <= 0) {
          break label471;
        }
        localStringBuffer.append(";").append((String)localObject1);
      }
    }
    label679:
    label682:
    for (;;)
    {
      k += 1;
      break;
      m = 0;
      break label206;
      label313:
      if (((j)localObject1).field_type == 2)
      {
        j += 1;
        break label224;
        label329:
        if (m == 0)
        {
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).xiF), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).xiF), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new cp();
        localObject2 = ((cp)localObject1).ff(this.xBq);
        ((cp)localObject2).dMB = this.fromScene;
        ((cp)localObject2).dRZ = this.xBr;
        ((cp)localObject1).dSa = this.xBs;
        ((cp)localObject1).dSb = this.xBt;
        ((cp)localObject1).dRY = j;
        ((cp)localObject1).dRX = i;
        ((cp)localObject1).dSd = ((cp)localObject1).t("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((cp)localObject1).aBj();
        this.xBu.clear();
        this.xBv.clear();
        ad.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(bt.aS(l)) });
        ad.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((cp)localObject1).PW() });
        super.onDestroy();
        AppMethodBeat.o(98890);
        return;
      }
      break label224;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(98892);
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.foV);
    this.foV = 0;
    com.tencent.mm.plugin.sns.model.af.dtp().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = Math.max(0L, localc.cDj - this.fXQ);
      }
    }
    if (bt.aGK() > this.hcE) {}
    for (long l = bt.aGK() - this.hcE;; l = 1L)
    {
      this.hcE = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.fXQ, this.hcE);
      this.fXQ = 0L;
      this.hcE = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.hcE = bt.aGK();
    if ((com.tencent.matrix.b.GE()) && (com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.GF().V(com.tencent.matrix.trace.a.class)).cBu;
      if (localc != null) {
        this.fXQ = localc.cDj;
      }
    }
    com.tencent.mm.plugin.sns.model.af.dtp().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98898);
    ad.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.sns.model.p))
    {
      if (this.xBl != null)
      {
        this.xBl.dismiss();
        this.xBl = null;
      }
      if (paramn != null)
      {
        paramString = (com.tencent.mm.plugin.sns.model.p)paramn;
        if (!paramString.wFe) {
          break label181;
        }
        paramString = ((cvc)paramString.rr.gUT.gUX).EmH;
        if ((paramString != null) && (paramString.Id != 0L)) {
          break label155;
        }
        com.tencent.mm.ui.base.h.j(this, 2131763916, 2131755906);
      }
    }
    while (paramn.getType() == 218) {
      if (((com.tencent.mm.plugin.sns.model.q)paramn).type != 12)
      {
        AppMethodBeat.o(98898);
        return;
        label155:
        if (((com.tencent.mm.plugin.sns.model.p)paramn).wFf != null)
        {
          a(((com.tencent.mm.plugin.sns.model.p)paramn).wFf);
          continue;
          label181:
          if (!this.xBh)
          {
            this.xBh = true;
            this.handler.postDelayed(this.xBp, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.xBg.a(null, null);
        Toast.makeText(this, getString(2131761725), 0).show();
      }
    }
    for (;;)
    {
      if (this.xBk != null)
      {
        this.xBk.dismiss();
        this.xBk = null;
      }
      AppMethodBeat.o(98898);
      return;
      label269:
      Toast.makeText(this, getString(2131761724), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.q<j>
  {
    int fwP;
    protected MMSlideDelView.g mRk;
    protected MMSlideDelView.c mRl;
    protected MMSlideDelView.d mRn;
    int nCF;
    private Set<MMSlideDelView> sHR;
    protected MMSlideDelView.f xBB;
    private int xkN;
    
    public a(Context paramContext, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(98880);
      this.sHR = new HashSet();
      this.mRn = new SnsMsgUI.a.1(this);
      this.xkN = ao.fromDPToPix(paramContext, 14);
      this.nCF = 10;
      this.fwP = this.nCF;
      AppMethodBeat.o(98880);
    }
    
    private static int a(int paramInt, MMImageView paramMMImageView)
    {
      int j = 2131689584;
      AppMethodBeat.i(163120);
      int i = j;
      switch (paramInt)
      {
      default: 
        i = j;
      }
      for (;;)
      {
        AppMethodBeat.o(163120);
        return i;
        i = 2131689564;
        continue;
        i = 2131689581;
        continue;
        i = 2131689562;
        continue;
        i = 2131230944;
        continue;
        i = 2131230944;
        continue;
        paramMMImageView.setImageDrawable(null);
        i = -1;
        continue;
        paramMMImageView.setImageDrawable(null);
        i = -1;
      }
    }
    
    public final void Wd()
    {
      AppMethodBeat.i(98884);
      if ((com.tencent.mm.plugin.sns.model.af.dtz().bIR() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        setCursor(com.tencent.mm.plugin.sns.model.af.dtz().dxJ());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.fwP = com.tencent.mm.plugin.sns.model.af.dtz().dxK();
        setCursor(com.tencent.mm.plugin.sns.model.af.dtz().Na(this.nCF));
      }
    }
    
    public final void We()
    {
      AppMethodBeat.i(98882);
      cHX();
      Wd();
      AppMethodBeat.o(98882);
    }
    
    public final void a(String paramString, m paramm)
    {
      try
      {
        AppMethodBeat.i(98883);
        super.a(paramString, paramm);
        AppMethodBeat.o(98883);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void b(MMSlideDelView.f paramf)
    {
      this.xBB = paramf;
    }
    
    public final boolean bLj()
    {
      return this.nCF >= this.fwP;
    }
    
    public final int bLk()
    {
      AppMethodBeat.i(98885);
      if (bLj())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.nCF += 10;
      if (this.nCF <= this.fwP)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.nCF = this.fwP;
      int i = this.fwP;
      AppMethodBeat.o(98885);
      return i % 10;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(98881);
      long l = ((j)getItem(paramInt)).field_snsID;
      AppMethodBeat.o(98881);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98886);
      localj = (j)getItem(paramInt);
      label65:
      Object localObject2;
      if (localj != null)
      {
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localj.xiF))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localj.xiF), localj.dxH());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1571;
        }
        localObject2 = (MMSlideDelView)y.js(this.context).inflate(2131493169, null);
        paramView = y.js(this.context).inflate(2131495570, null);
        locala = new a();
        locala.xBD = ((SnsAvatarImageView)paramView.findViewById(2131305008));
        locala.xBD.setWeakContext(this.context);
        locala.inR = ((TextView)paramView.findViewById(2131305016));
        locala.qAo = ((TextView)paramView.findViewById(2131305010));
        locala.xBF = ((ImageView)paramView.findViewById(2131305014));
        locala.timeTv = ((TextView)paramView.findViewById(2131305017));
        locala.xBG = ((MMImageView)paramView.findViewById(2131305012));
        locala.xBE = ((TextView)paramView.findViewById(2131305018));
        locala.xBG.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.mRs = ((MMSlideDelView)localObject2).findViewById(2131304837);
        locala.mRt = ((TextView)((MMSlideDelView)localObject2).findViewById(2131304839));
        locala.xBH = ((ImageView)paramView.findViewById(2131305049));
        locala.xBI = ((EmojiStatusView)paramView.findViewById(2131305009));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.mRk);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.mRl);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.mRn);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label357:
        locala.xBG.setTag(null);
        locala.dze = localj.field_snsID;
        locala.mRs.setTag(Integer.valueOf(localj.xiF));
        locala.mRs.setOnClickListener(new SnsMsgUI.a.2(this));
      }
      for (;;)
      {
        try
        {
          localcui = (cui)new cui().parseFrom(localj.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          cui localcui;
          final com.tencent.mm.plugin.sns.storage.p localp;
          Object localObject3;
          label1571:
          ad.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          ad.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localcui.DZr;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.cd.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.inR.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this.context, ((au)localObject3).field_openImAppid, this.xkN), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.cd.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.inR.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.l(this.context, 2131233600);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewGroup, null);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.l(this.context, 2131233601);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.l(this.context, 2131233599);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.l(this.context, 2131233597);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.l(this.context, 2131233598);
          continue;
          ((TextView)localObject1).setTag(null);
          continue;
          ((TextView)localObject1).setTextColor(SnsMsgUI.this.getResources().getColor(2131100711));
          ((TextView)localObject1).setBackgroundDrawable(null);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ((TextView)localObject1).setText("");
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          switch (localcui.mBH)
          {
          case 1: 
          case 5: 
            paramViewGroup = com.tencent.mm.plugin.sns.model.af.dtu().th(localj.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131763883));
            continue;
            paramView = am.i(this.context, 2131690247, this.context.getResources().getColor(2131099769));
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 21)) {
              continue;
            }
            paramView.setColorFilter(SnsMsgUI.this.getResources().getColor(2131100926), PorterDuff.Mode.SRC_ATOP);
            paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
            paramViewGroup = new SpannableString(" ");
            paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
            ((TextView)localObject1).setText(paramViewGroup);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131763827));
            continue;
            paramView.clearColorFilter();
            break;
          case 2: 
          case 3: 
            localObject4 = bt.nullAsNil(localcui.gKr);
            localObject5 = new SpannableStringBuilder();
            locale = com.tencent.mm.plugin.sns.model.af.dtx().sY(localj.field_snsID);
            localObject6 = com.tencent.mm.cd.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hA(localcui.Eme, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.afC();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(locale.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131763917)).append(paramView.ZX()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.ZX().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localcui, (SpannableStringBuilder)localObject5, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, (CharSequence)localObject5, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (bt.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131763918)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(2131763918).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 7: 
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(am.i(this.context, 2131690247, this.context.getResources().getColor(2131099769)), null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131763827));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = bt.nullAsNil(localcui.gKr);
            locale = com.tencent.mm.plugin.sns.model.af.dtx().sY(localj.field_snsID);
            localObject6 = com.tencent.mm.cd.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hA(localcui.Eme, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.afC();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHW(locale.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131763917)).append(paramView.ZX()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.ZX().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localcui, (SpannableStringBuilder)localObject4, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, (CharSequence)localObject4, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (bt.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131763918)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(2131763918).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 4: 
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131764040));
            break;
          case 16: 
            paramView = "" + "[" + SnsMsgUI.this.getString(2131763746) + "]";
            paramView = paramView + " " + bt.nullAsNil(localcui.gKr);
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new bft();
            ad.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localcui.Emd);
            try
            {
              paramView.parseFrom(z.a(localcui.Emd));
              ad.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.dEb);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).aHY(localcui.DZr);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131760811, new Object[] { paramViewGroup.ZX(), bt.D(paramView.dEb / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              ad.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new bft();
            ad.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localcui.Emd);
            try
            {
              paramViewGroup.parseFrom(z.a(localcui.Emd));
              ad.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.dEb);
              SnsMsgUI.r(SnsMsgUI.this).aHY(localcui.DZr);
              paramView = null;
              if (paramViewGroup.dEb == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(2131760814));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView);
                  ((com.tencent.mm.ui.widget.a)localObject3).HyD = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.cd.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
                  paramViewGroup.setSpan(localObject3, 0, 1, 33);
                }
                ((TextView)localObject1).setText(paramViewGroup);
              }
            }
            catch (Exception paramView)
            {
              ad.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramView.getMessage());
              continue;
              SnsMsgUI.b(SnsMsgUI.this, false);
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(2131760813, new Object[] { bt.D(paramViewGroup.dEb / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(2131230912);
              continue;
            }
            paramView = com.tencent.mm.plugin.sns.model.af.dtu().th(localj.field_snsID);
            continue;
            paramInt = a(paramView.field_type, locala.xBG);
            if (paramView.dxy().Etm.DaG.mediaList.isEmpty()) {
              continue;
            }
            paramViewGroup = new bpi();
            paramViewGroup.Url = ((alc)paramView.dxy().Etm.DaG.mediaList.get(0)).thumbUrl;
            paramViewGroup.DMQ = ((alc)paramView.dxy().Etm.DaG.mediaList.get(0)).thumbUrl;
            paramViewGroup.mBH = 2;
            paramViewGroup.DMR = 1;
            paramViewGroup.DMT = new bpk();
            paramViewGroup.Dzl = 1;
            paramViewGroup.DMT.DNH = ((alc)paramView.dxy().Etm.DaG.mediaList.get(0)).width;
            paramViewGroup.DMT.DNI = ((alc)paramView.dxy().Etm.DaG.mediaList.get(0)).height;
            paramViewGroup.Id = localp.getSnsId();
            com.tencent.mm.plugin.sns.model.af.dtr().a(paramViewGroup, locala.xBG, paramInt, SnsMsgUI.this.hashCode(), bc.FzD);
            locala.xBG.setVisibility(0);
            continue;
            if (paramView.dxy().Etm.DaB != 29) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.xBG);
            if (paramView.dxy().Etm.DaH == null) {
              continue;
            }
            paramViewGroup = new bpi();
            paramViewGroup.Url = paramView.dxy().Etm.DaH.iconUrl;
            paramViewGroup.DMQ = paramView.dxy().Etm.DaH.iconUrl;
            paramViewGroup.mBH = 2;
            paramViewGroup.DMR = 1;
            paramViewGroup.DMT = new bpk();
            paramViewGroup.Dzl = 1;
            paramViewGroup.DMT.DNH = 0.0F;
            paramViewGroup.DMT.DNI = 0.0F;
            paramViewGroup.Id = localp.getSnsId();
            com.tencent.mm.plugin.sns.model.af.dtr().a(paramViewGroup, locala.xBG, paramInt, SnsMsgUI.this.hashCode(), bc.FzD);
            locala.xBG.setVisibility(0);
            continue;
            if (paramView.field_type != 2) {
              continue;
            }
            locala.xBG.setTag(null);
            locala.xBE.setVisibility(0);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.dxy().Etj, locala.xBE.getTextSize());
            locala.xBE.setText(paramView);
            continue;
            if (paramViewGroup.size() <= 0) {
              break label4415;
            }
            i = a(paramView.field_type, locala.xBG);
            com.tencent.mm.plugin.sns.model.af.dtr().a((bpi)paramViewGroup.get(0), locala.xBG, i, SnsMsgUI.this.hashCode(), bc.FzD);
            if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((bpi)paramViewGroup.get(0)).mBH != 6))) {
              continue;
            }
            locala.xBH.setVisibility(0);
            paramView = new j();
            com.tencent.mm.plugin.sns.model.af.dtz().get(localj.systemRowid, paramView);
            locala.xBG.setTag(paramView);
            paramInt = 1;
            paramViewGroup = locala.xBG;
            paramView = paramViewGroup;
            if (paramInt == 0) {
              break label4438;
            }
            paramInt = 0;
            paramView = paramViewGroup;
            continue;
            paramViewGroup = new aw();
            paramViewGroup.diQ = paramView.dxX();
            paramViewGroup.index = 0;
            paramView = new ArrayList();
            paramView.add(locala.xBG);
            paramViewGroup.xzo = paramView;
            paramViewGroup.position = paramInt;
            locala.xBG.setTag(paramViewGroup);
            paramInt = 1;
            continue;
            if ((localcui.mBH == 7) || (localcui.mBH == 8)) {
              continue;
            }
            if (localcui.mBH != 16) {
              continue;
            }
            if (!com.tencent.mm.plugin.sns.model.l.sB(localj.field_snsID)) {
              continue;
            }
            if (localcui.CxV == null) {
              continue;
            }
            ad.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localcui.CxV.Eem), Integer.valueOf(localcui.CxV.Eeh) });
            paramView = new com.tencent.mm.plugin.sns.model.l(localj.field_snsID, localcui.CxV);
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(paramView, 0);
            continue;
            if (!com.tencent.mm.plugin.sns.model.p.sE(localj.field_snsID)) {
              continue;
            }
            com.tencent.mm.kernel.g.afC();
            com.tencent.mm.kernel.g.afA().gcy.a(new com.tencent.mm.plugin.sns.model.p(localj.field_snsID), 0);
            continue;
            paramInt = 0;
            continue;
            paramInt = 8;
            continue;
            paramInt = 8;
            continue;
          }
        }
        try
        {
          paramViewGroup = ((cui)new cui().parseFrom(localj.field_refActionBuf)).DZr;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.xBD.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!bt.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localp = com.tencent.mm.plugin.sns.model.af.dtu().th(localj.field_snsID);
          if (localp != null) {
            break label4426;
          }
          paramViewGroup = com.tencent.mm.plugin.sns.model.af.dtx().sY(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4426;
          }
          localp = paramViewGroup.dxE();
        }
        catch (Exception paramView)
        {
          Object localObject4;
          Object localObject5;
          com.tencent.mm.plugin.sns.storage.e locale;
          Object localObject6;
          paramView = paramViewGroup;
          continue;
          paramInt = 0;
          continue;
          j = 0;
          continue;
          continue;
          i = 1;
          continue;
          continue;
          paramInt = 8;
          continue;
          i = 1;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          switch (j)
          {
          }
          continue;
          i = 0;
          continue;
          continue;
        }
        if (bt.isNullOrNil(localcui.DZr)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.e.a(locala.xBD, localp, localcui.DZr)) {
          a.b.c(locala.xBD, localcui.DZr);
        }
        paramViewGroup = localcui.DZr;
        locala.xBD.eE(paramViewGroup, 6);
        if (bt.kU(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.xBD;
        com.tencent.mm.kernel.g.afC();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.xBD.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 0;
            boolean bool = false;
            AppMethodBeat.i(98879);
            int i = j;
            if (localp != null)
            {
              i = j;
              if (com.tencent.mm.plugin.sns.ui.widget.e.b(localp, paramViewGroup))
              {
                com.tencent.mm.plugin.sns.storage.b localb = localp.dxs();
                i = j;
                if (localb != null)
                {
                  i = j;
                  if (localb.wSV == 1)
                  {
                    i = j;
                    if (!bt.isNullOrNil(localb.wSW))
                    {
                      SnsMsgUI localSnsMsgUI = SnsMsgUI.this;
                      com.tencent.mm.plugin.sns.storage.a locala = localp.dxu();
                      Object localObject = localb.wSW;
                      paramAnonymousView = (View)localObject;
                      if (locala != null) {
                        paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy((String)localObject, locala.dvK);
                      }
                      ad.i("MicroMsg.SnsMsgUI", "comment msg headClickParam url " + paramAnonymousView + " " + localb.wSX);
                      localObject = new Intent();
                      if (localb.wSX == 0) {
                        bool = true;
                      }
                      ((Intent)localObject).putExtra("KsnsViewId", locala.dAM);
                      ((Intent)localObject).putExtra("KRightBtn", bool);
                      ((Intent)localObject).putExtra("jsapiargs", new Bundle());
                      ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                      ((Intent)localObject).putExtra("useJs", true);
                      com.tencent.mm.plugin.sns.d.a.hYt.i((Intent)localObject, localSnsMsgUI);
                      i = 1;
                    }
                  }
                }
              }
            }
            if (i == 0)
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", paramViewGroup);
              paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 11);
              com.tencent.mm.plugin.sns.d.a.hYt.c(paramAnonymousView, SnsMsgUI.this);
            }
            AppMethodBeat.o(98879);
          }
        });
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).aHY(localcui.DZr);
        i = 0;
        if (bt.isNullOrNil(localcui.ElX)) {
          continue;
        }
        paramViewGroup = localcui.ElX;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label4420;
        }
        if (!bt.isNullOrNil(((com.tencent.mm.n.b)localObject3).ZX())) {
          paramViewGroup = ((com.tencent.mm.n.b)localObject3).ZX();
        }
        localObject1 = paramViewGroup;
        if (!com.tencent.mm.storage.af.aHH(((au)localObject3).field_username)) {
          break label4420;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((au)localObject3).field_openImAppid)) {
          break label4420;
        }
        j = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.inR.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bt(((au)localObject3).field_openImAppid, ((au)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localcui.DZr)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.e.a(localp.dxs(), (String)localObject1);
        }
        paramViewGroup = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.inR.getTextSize());
        if ((localp == null) || (localp.field_type != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.cd.a.m(this.context, 2131100922);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.inR.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        locala.inR.setText(paramViewGroup);
        paramViewGroup = localcui.DZr;
        localObject1 = locala.inR;
        j = localcui.rNz;
        switch (localj.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label4468;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.xBI;
          localObject1 = locala.qAo;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((bt.gL(localcui.Emf)) || (localcui.Emf.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((cuu)localcui.Emf.get(0)).Md5);
          paramViewGroup = new int[2];
          if ((localj.field_commentflag & 0x1) <= 0) {
            break label4539;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((TextView)localObject1).setText(2131763913);
          ((TextView)localObject1).setBackgroundColor(SnsMsgUI.this.getResources().getColor(2131100179));
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          locala.timeTv.setText(bg.o(SnsMsgUI.this, localcui.CreateTime * 1000L));
          paramView = null;
          if ((localcui.mBH != 7) && (localcui.mBH != 8) && (localcui.mBH != 16)) {
            continue;
          }
          paramViewGroup = com.tencent.mm.plugin.sns.model.af.dtx().sY(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4435;
          }
          paramView = paramViewGroup.dxE();
          break label4435;
          locala.xBG.setVisibility(8);
          locala.xBE.setVisibility(8);
          locala.xBH.setVisibility(8);
          locala.xBG.setImageBitmap(null);
          com.tencent.mm.plugin.sns.model.af.dtr().er(locala.xBG);
          if (paramView == null) {
            continue;
          }
          paramViewGroup = paramView.dxy().Etm.DaC;
          if (paramView.dxy().Etm.DaB != 28) {
            continue;
          }
          if (paramView.dxy().Etm.DaG.Dmx != 1) {
            continue;
          }
          locala.xBG.setTag(null);
          locala.xBE.setVisibility(0);
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.dxy().Etm.DaG.desc, locala.xBE.getTextSize());
          locala.xBE.setText(paramView);
          paramView = locala.xBG;
          break label4438;
          paramView.setVisibility(paramInt);
          if ((locala.xBG.getVisibility() != 0) && (locala.xBH.getVisibility() != 0)) {
            continue;
          }
          paramInt = 1;
          paramView = ((View)localObject2).findViewById(2131305015);
          if (paramInt == 0) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          paramView = ((View)localObject2).findViewById(2131305054);
          if (localj.field_isSilence != 1) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          ((ImageView)((View)localObject2).findViewById(2131305054)).setImageDrawable(am.i(this.context, 2131691190, this.context.getResources().getColor(2131099982)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((j)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localj.xiF))).field_isSilence = localj.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label357;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).aHY(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (bt.kU(((au)localObject1).field_username, com.tencent.mm.plugin.sns.model.af.dta())) {
              paramView = ((au)localObject1).field_nickname;
            } else if (!bt.isNullOrNil(((com.tencent.mm.n.b)localObject1).ZX())) {
              paramView = ((com.tencent.mm.n.b)localObject1).ZX();
            } else {
              paramView = ((au)localObject1).field_nickname;
            }
          }
          break;
        }
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.mRl = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.mRk = paramg;
    }
    
    final class a
    {
      long dze;
      TextView inR;
      View mRs;
      TextView mRt;
      TextView qAo;
      TextView timeTv;
      SnsAvatarImageView xBD;
      TextView xBE;
      ImageView xBF;
      MMImageView xBG;
      ImageView xBH;
      EmojiStatusView xBI;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */