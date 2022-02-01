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
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.ed;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.bjl;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.cob;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.dag;
import com.tencent.mm.protocal.protobuf.dao;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.am;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;
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
  implements com.tencent.mm.ak.g, b.b
{
  private int fromScene;
  private int fsu;
  private long gcx;
  private long hDh;
  private com.tencent.mm.sdk.platformtools.ao handler;
  private String huP;
  private ListView list;
  private n.d ntM;
  private View nwN;
  private View ofC;
  private View ofD;
  private boolean ofE;
  private int[] qMm;
  private long qoj;
  private bj yJv;
  private a yNU;
  private boolean yNV;
  private boolean yNW;
  private boolean yNX;
  private com.tencent.mm.ui.base.p yNY;
  private com.tencent.mm.ui.base.p yNZ;
  private int yOa;
  private View.OnClickListener yOb;
  private k.a yOc;
  Runnable yOd;
  private long yOe;
  private int yOf;
  private int yOg;
  private HashMap<Integer, j> yOh;
  private HashMap<Integer, Integer> yOi;
  long yaI;
  int yvt;
  private av yxW;
  private SnsCmdList yzV;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.ofD = null;
    this.handler = af.cMM();
    this.yNV = false;
    this.yNW = false;
    this.yzV = new SnsCmdList();
    this.ofE = false;
    this.yNX = false;
    this.qMm = new int[2];
    this.yOa = 86400;
    this.yOb = new View.OnClickListener()
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
        ac.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramAnonymousView.getTag());
        AppMethodBeat.o(98853);
      }
    };
    this.gcx = 0L;
    this.hDh = 0L;
    this.ntM = new n.d()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(200520);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(200520);
          return;
          SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.yvt);
          AppMethodBeat.o(200520);
          return;
          SnsMsgUI.m(SnsMsgUI.this);
          AppMethodBeat.o(200520);
          return;
          SnsMsgUI.a(SnsMsgUI.this, false);
        }
      }
    };
    this.yOc = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(98861);
        af.cMM().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98860);
            synchronized (SnsMsgUI.d(SnsMsgUI.this))
            {
              ac.v("MicroMsg.SnsMsgUI", "comment notify");
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
    this.yOd = new Runnable()
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
    this.yOf = 0;
    this.yOg = 0;
    this.yOh = new HashMap();
    this.yOi = new HashMap();
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
        this.yOf += 1;
        if (!this.yOi.containsKey(Integer.valueOf(paramj.yvt))) {
          break label153;
        }
        this.yOi.put(Integer.valueOf(paramj.yvt), Integer.valueOf(((Integer)this.yOi.get(Integer.valueOf(paramj.yvt))).intValue() + 1));
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
      ac.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
      com.tencent.mm.ui.base.h.l(this, 2131763916, 2131755906);
      AppMethodBeat.o(179213);
      return;
      if (paramj.field_type != 2) {
        break;
      }
      this.yOg += 1;
      break;
      this.yOi.put(Integer.valueOf(paramj.yvt), Integer.valueOf(1));
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
        localIntent.putExtra("INTENT_SOURCE", ((czu)new czu().parseFrom(paramj.field_curActionBuf)).sVo);
        if ((paramj.field_type != 7) && (paramj.field_type != 8) && (paramj.field_type != 16)) {
          break label626;
        }
        localIntent.putExtra("INTENT_SNSID", x.bj("ad_table_", l));
        com.tencent.mm.plugin.sns.storage.p localp = af.dHR().auS(x.bj("ad_table_", l));
        if (localp != null) {
          break;
        }
        ac.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
        if (paramj.field_type == 16) {
          com.tencent.mm.plugin.report.service.h.wUl.dB(955, 2);
        }
        AppMethodBeat.o(179213);
        return;
      }
      catch (Exception localException)
      {
        ac.printErrStackTrace("MicroMsg.SnsMsgUI", localException, "", new Object[0]);
        continue;
      }
      localIntent.setClass(this, SnsCommentDetailUI.class);
    }
    i = com.tencent.mm.kernel.g.agR().agA().getInt(14, 0);
    ac.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localException.dFR().ygt), Integer.valueOf(localException.dFR().ygu) });
    if ((i < localException.dFR().ygt) || ((localException.dFR().ygu > 0) && (i > localException.dFR().ygu)))
    {
      if (!bs.isNullOrNil(localException.dFR().ygv))
      {
        paramj = new Intent();
        paramj.putExtra("rawUrl", localException.dFR().ygv);
        paramj.putExtra("showShare", false);
        paramj.putExtra("show_bottom", false);
        paramj.putExtra("needRedirect", false);
        paramj.putExtra("hardcode_jspermission", JsapiPermissionWrapper.DIw);
        com.tencent.mm.plugin.sns.c.a.iyx.i(paramj, this);
        AppMethodBeat.o(179213);
        return;
      }
      ac.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label626:
      localIntent.putExtra("INTENT_SNSID", x.bj("sns_table_", l));
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
      paramj = com.tencent.mm.plugin.sns.data.q.wW(paramj.field_snsID);
      AppMethodBeat.o(98900);
      return paramj;
    }
    paramj = com.tencent.mm.plugin.sns.data.q.wW(paramj.field_parentID);
    AppMethodBeat.o(98900);
    return paramj;
  }
  
  public final void atn(String paramString)
  {
    AppMethodBeat.i(98896);
    this.yNU.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void bF(String paramString, boolean paramBoolean) {}
  
  public final void bG(String paramString, boolean paramBoolean) {}
  
  public final void dGO() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ac.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.yzV);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98897);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98897);
    return bool;
  }
  
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
        AppMethodBeat.i(200523);
        com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(2131763912), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(200522);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            af.dHW().hpA.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(200522);
          }
        }, null);
        AppMethodBeat.o(200523);
        return true;
      }
    });
    this.yxW = new av(this);
    this.nwN = findViewById(2131305011);
    this.list = ((ListView)findViewById(2131305013));
    this.ofC = com.tencent.mm.ui.z.jD(this).inflate(2131495569, null);
    this.ofD = com.tencent.mm.ui.z.jD(this).inflate(2131494788, null);
    ac.d("MicroMsg.SnsMsgUI", "autoLoad " + this.ofE);
    if (this.ofE)
    {
      this.list.addFooterView(this.ofD);
      this.yNU = new a(this, new j());
      this.yNU.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dy(View paramAnonymousView)
        {
          AppMethodBeat.i(200524);
          int i = SnsMsgUI.b(SnsMsgUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(200524);
          return i;
        }
      });
      this.yNU.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(200525);
          SnsMsgUI.b(SnsMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(200525);
        }
      });
      this.yNU.b(new MMSlideDelView.f()
      {
        public final void cN(Object paramAnonymousObject)
        {
          AppMethodBeat.i(200526);
          if (paramAnonymousObject == null)
          {
            ac.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            AppMethodBeat.o(200526);
            return;
          }
          try
          {
            int i = bs.aLy(paramAnonymousObject.toString());
            SnsMsgUI.a(SnsMsgUI.this, i);
            AppMethodBeat.o(200526);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            ac.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            ac.printErrStackTrace("MicroMsg.SnsMsgUI", paramAnonymousObject, "", new Object[0]);
            AppMethodBeat.o(200526);
          }
        }
      });
      this.yNU.a(new r.a()
      {
        public final void aPg()
        {
          AppMethodBeat.i(200527);
          ac.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).fAw + " unread:" + af.dHW().bQe() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).ofG);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).bSw()) && (af.dHW().bQe() == 0)) || (af.dHW().bQe() == af.dHW().dMh())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(200527);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.yNU);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(200528);
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (af.dHW().bQe() > 0)
            {
              af.dHW().bQf();
              if (SnsMsgUI.d(SnsMsgUI.this).bSw()) {
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
                  ac.d("MicroMsg.SnsMsgUI", "remove footer");
                  SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.e(SnsMsgUI.this));
                }
                if ((SnsMsgUI.g(SnsMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
                {
                  SnsMsgUI.b(SnsMsgUI.this).addFooterView(SnsMsgUI.g(SnsMsgUI.this));
                  ac.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
              }
              SnsMsgUI.h(SnsMsgUI.this);
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
              AppMethodBeat.o(200528);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).bSx();
            }
          }
          paramAnonymousAdapterView = (j)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.O(af.dHR().xK(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          AppMethodBeat.o(200528);
        }
      });
      new com.tencent.mm.ui.tools.l(this);
      this.list.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(200529);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(200529);
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
          AppMethodBeat.i(200530);
          if (paramAnonymousInt < SnsMsgUI.b(SnsMsgUI.this).getHeaderViewsCount())
          {
            ac.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
            AppMethodBeat.o(200530);
            return true;
          }
          new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SnsMsgUI.this, SnsMsgUI.j(SnsMsgUI.this), SnsMsgUI.i(SnsMsgUI.this)[0], SnsMsgUI.i(SnsMsgUI.this)[1]);
          AppMethodBeat.o(200530);
          return true;
        }
      });
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(200518);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(200518);
            return;
          }
          ac.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              ac.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsMsgUI.k(SnsMsgUI.this)) });
            }
          }
          else
          {
            if (paramAnonymousAbsListView.getLastVisiblePosition() != paramAnonymousAbsListView.getCount() - 1) {
              break label211;
            }
            if (af.dHW().bQe() <= 0) {
              break label197;
            }
            af.dHW().bQf();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).a(null, null);
            AppMethodBeat.o(200518);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).bSx();
          }
          label211:
          AppMethodBeat.o(200518);
        }
      });
      if (this.yNU.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.nwN.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.yNU.bSw()) && (af.dHW().bQe() == 0)) || (af.dHW().bQe() == af.dHW().dMh())) {
        this.ofC.setVisibility(8);
      }
      if ((this.yNU.bSw()) && (this.ofE)) {
        this.list.removeFooterView(this.ofD);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(200519);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(200519);
          return true;
        }
      });
      if ((this.yNU.bSw()) && (this.ofE)) {
        this.list.removeFooterView(this.ofD);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.ofC);
      break;
      label470:
      this.list.setVisibility(0);
      this.nwN.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98895);
    ac.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      this.yzV.Oa(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(210, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(683, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(218, this);
    this.huP = u.axw();
    this.yJv = af.dHF();
    this.yNW = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.yNW) {
      this.ofE = true;
    }
    af.dHW().add(this.yOc);
    setActionbarColor(getActionbarColor());
    initView();
    this.yOe = bs.eWj();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    j localj = (j)this.yNU.getItem(paramContextMenuInfo.position);
    if (localj == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.yvt = localj.yvt;
    this.yaI = localj.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (czu)new czu().parseFrom(localj.field_curActionBuf);
        if (paramView != null)
        {
          ai localai = this.yJv.aNt(paramView.Fwn);
          if (localai == null) {
            continue;
          }
          paramView = localai.aaS();
          paramContextMenu.setHeaderTitle(bs.nullAsNil(paramView));
          if (localj.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(2131761722));
        }
      }
      catch (Exception paramView)
      {
        ac.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(2131755707));
      AppMethodBeat.o(98894);
      return;
      if (!bs.isNullOrNil(paramView.FIW))
      {
        paramView = paramView.FIW;
      }
      else
      {
        paramView = paramView.Fwn;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(2131761721));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    ac.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.qoj = super.getActivityBrowseTimeMs();
    if (af.dHW().bQe() > 0) {
      af.dHW().bQf();
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(210, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(683, this);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(218, this);
    af.dHW().remove(this.yOc);
    this.yNU.cVi();
    af.dHO().aD(this);
    if (this.yNY != null)
    {
      this.yNY.dismiss();
      this.yNY = null;
    }
    long l = bs.Gn();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.yOh.values().iterator();
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
        if (this.yOi.containsKey(Integer.valueOf(((j)localObject1).yvt))) {
          m = ((Integer)this.yOi.get(Integer.valueOf(((j)localObject1).yvt))).intValue();
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
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).yvt), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).yvt), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new ed();
        localObject2 = ((ed)localObject1).is(this.yOe);
        ((ed)localObject2).dNc = this.fromScene;
        ((ed)localObject2).dTN = this.qoj;
        ((ed)localObject1).dTO = this.yOf;
        ((ed)localObject1).dTP = this.yOg;
        ((ed)localObject1).dTM = j;
        ((ed)localObject1).dTL = i;
        ((ed)localObject1).dTR = ((ed)localObject1).t("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((ed)localObject1).aHZ();
        this.yOh.clear();
        this.yOi.clear();
        ac.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(bs.aO(l)) });
        ac.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((ed)localObject1).PS() });
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
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.fsu);
    this.fsu = 0;
    af.dHM().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = Math.max(0L, localc.cAr - this.gcx);
      }
    }
    if (bs.aNx() > this.hDh) {}
    for (long l = bs.aNx() - this.hDh;; l = 1L)
    {
      this.hDh = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.gcx, this.hDh);
      this.gcx = 0L;
      this.hDh = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.hDh = bs.aNx();
    if ((com.tencent.matrix.b.Gp()) && (com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.Gq().V(com.tencent.matrix.trace.a.class)).cyD;
      if (localc != null) {
        this.gcx = localc.cAr;
      }
    }
    af.dHM().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98898);
    ac.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.sns.model.p))
    {
      if (this.yNZ != null)
      {
        this.yNZ.dismiss();
        this.yNZ = null;
      }
      if (paramn != null)
      {
        paramString = (com.tencent.mm.plugin.sns.model.p)paramn;
        if (!paramString.xRz) {
          break label181;
        }
        paramString = ((dao)paramString.rr.hvs.hvw).FJG;
        if ((paramString != null) && (paramString.Id != 0L)) {
          break label155;
        }
        com.tencent.mm.ui.base.h.l(this, 2131763916, 2131755906);
      }
    }
    while (paramn.getType() == 218) {
      if (((com.tencent.mm.plugin.sns.model.q)paramn).type != 12)
      {
        AppMethodBeat.o(98898);
        return;
        label155:
        if (((com.tencent.mm.plugin.sns.model.p)paramn).xRA != null)
        {
          a(((com.tencent.mm.plugin.sns.model.p)paramn).xRA);
          continue;
          label181:
          if (!this.yNV)
          {
            this.yNV = true;
            this.handler.postDelayed(this.yOd, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.yNU.a(null, null);
        Toast.makeText(this, getString(2131761725), 0).show();
      }
    }
    for (;;)
    {
      if (this.yNY != null)
      {
        this.yNY.dismiss();
        this.yNY = null;
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
    extends r<j>
  {
    int fAw;
    protected MMSlideDelView.g ntA;
    protected MMSlideDelView.c ntB;
    protected MMSlideDelView.d ntD;
    int ofG;
    private Set<MMSlideDelView> tPy;
    protected MMSlideDelView.f yOo;
    private int yxF;
    
    public a(Context paramContext, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(98880);
      this.tPy = new HashSet();
      this.ntD = new SnsMsgUI.a.1(this);
      this.yxF = com.tencent.mm.ui.ao.fromDPToPix(paramContext, 14);
      this.ofG = 10;
      this.fAw = this.ofG;
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
    
    public final void Xb()
    {
      AppMethodBeat.i(98884);
      if ((af.dHW().bQe() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        setCursor(af.dHW().dMg());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.fAw = af.dHW().dMh();
        setCursor(af.dHW().Pd(this.ofG));
      }
    }
    
    public final void Xc()
    {
      AppMethodBeat.i(98882);
      cVi();
      Xb();
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
      this.yOo = paramf;
    }
    
    public final boolean bSw()
    {
      return this.ofG >= this.fAw;
    }
    
    public final int bSx()
    {
      AppMethodBeat.i(98885);
      if (bSw())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.ofG += 10;
      if (this.ofG <= this.fAw)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.ofG = this.fAw;
      int i = this.fAw;
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
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localj.yvt))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localj.yvt), localj.dMe());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1571;
        }
        localObject2 = (MMSlideDelView)com.tencent.mm.ui.z.jD(this.context).inflate(2131493169, null);
        paramView = com.tencent.mm.ui.z.jD(this.context).inflate(2131495570, null);
        locala = new a();
        locala.yOq = ((SnsAvatarImageView)paramView.findViewById(2131305008));
        locala.yOq.setWeakContext(this.context);
        locala.iNX = ((TextView)paramView.findViewById(2131305016));
        locala.yOt = ((TextView)paramView.findViewById(2131305010));
        locala.yOs = ((ImageView)paramView.findViewById(2131305014));
        locala.timeTv = ((TextView)paramView.findViewById(2131305017));
        locala.yOu = ((MMImageView)paramView.findViewById(2131305012));
        locala.yOr = ((TextView)paramView.findViewById(2131305018));
        locala.yOu.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.ntI = ((MMSlideDelView)localObject2).findViewById(2131304837);
        locala.ntJ = ((TextView)((MMSlideDelView)localObject2).findViewById(2131304839));
        locala.yOv = ((ImageView)paramView.findViewById(2131305049));
        locala.yOw = ((EmojiStatusView)paramView.findViewById(2131305009));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.ntA);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.ntB);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.ntD);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label357:
        locala.yOu.setTag(null);
        locala.dwQ = localj.field_snsID;
        locala.ntI.setTag(Integer.valueOf(localj.yvt));
        locala.ntI.setOnClickListener(new SnsMsgUI.a.2(this));
      }
      for (;;)
      {
        try
        {
          localczu = (czu)new czu().parseFrom(localj.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          czu localczu;
          final com.tencent.mm.plugin.sns.storage.p localp;
          Object localObject3;
          label1571:
          ac.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          ac.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localczu.Fwn;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.iNX.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this.context, ((com.tencent.mm.g.c.av)localObject3).field_openImAppid, this.yxF), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.iNX.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
          continue;
          paramViewGroup = com.tencent.mm.cc.a.l(this.context, 2131233600);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewGroup, null);
          continue;
          paramViewGroup = com.tencent.mm.cc.a.l(this.context, 2131233601);
          continue;
          paramViewGroup = com.tencent.mm.cc.a.l(this.context, 2131233599);
          continue;
          paramViewGroup = com.tencent.mm.cc.a.l(this.context, 2131233597);
          continue;
          paramViewGroup = com.tencent.mm.cc.a.l(this.context, 2131233598);
          continue;
          ((TextView)localObject1).setTag(null);
          continue;
          ((TextView)localObject1).setTextColor(SnsMsgUI.this.getResources().getColor(2131100711));
          ((TextView)localObject1).setBackgroundDrawable(null);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ((TextView)localObject1).setText("");
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          switch (localczu.ndI)
          {
          case 1: 
          case 5: 
            paramViewGroup = af.dHR().xK(localj.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131763883));
            continue;
            paramView = am.k(this.context, 2131690247, this.context.getResources().getColor(2131099769));
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
            localObject4 = bs.nullAsNil(localczu.hkR);
            localObject5 = new SpannableStringBuilder();
            locale = af.dHU().xB(localj.field_snsID);
            localObject6 = com.tencent.mm.cc.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hJ(localczu.FJd, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.agS();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(locale.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131763917)).append(paramView.aaS()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.aaS().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localczu, (SpannableStringBuilder)localObject5, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, (CharSequence)localObject5, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (bs.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131763918)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(2131763918).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 7: 
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(am.k(this.context, 2131690247, this.context.getResources().getColor(2131099769)), null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131763827));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = bs.nullAsNil(localczu.hkR);
            locale = af.dHU().xB(localj.field_snsID);
            localObject6 = com.tencent.mm.cc.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.hJ(localczu.FJd, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.agS();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNr(locale.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131763917)).append(paramView.aaS()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.aaS().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localczu, (SpannableStringBuilder)localObject4, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, (CharSequence)localObject4, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (bs.isNullOrNil(paramView)) {
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
            paramView = paramView + " " + bs.nullAsNil(localczu.hkR);
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new bjl();
            ac.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localczu.FJc);
            try
            {
              paramView.parseFrom(com.tencent.mm.platformtools.z.a(localczu.FJc));
              ac.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.dBN);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).aNt(localczu.Fwn);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131760811, new Object[] { paramViewGroup.aaS(), bs.C(paramView.dBN / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              ac.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new bjl();
            ac.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localczu.FJc);
            try
            {
              paramViewGroup.parseFrom(com.tencent.mm.platformtools.z.a(localczu.FJc));
              ac.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.dBN);
              SnsMsgUI.r(SnsMsgUI.this).aNt(localczu.Fwn);
              paramView = null;
              if (paramViewGroup.dBN == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(2131760814));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView);
                  ((com.tencent.mm.ui.widget.a)localObject3).IZa = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.cc.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
                  paramViewGroup.setSpan(localObject3, 0, 1, 33);
                }
                ((TextView)localObject1).setText(paramViewGroup);
              }
            }
            catch (Exception paramView)
            {
              ac.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramView.getMessage());
              continue;
              SnsMsgUI.b(SnsMsgUI.this, false);
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(2131760813, new Object[] { bs.C(paramViewGroup.dBN / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(2131230912);
              continue;
            }
            paramView = af.dHR().xK(localj.field_snsID);
            continue;
            paramInt = a(paramView.field_type, locala.yOu);
            if (paramView.dLV().FQo.EtD.mediaList.isEmpty()) {
              continue;
            }
            paramViewGroup = new btz();
            paramViewGroup.Url = ((anw)paramView.dLV().FQo.EtD.mediaList.get(0)).thumbUrl;
            paramViewGroup.Fjh = ((anw)paramView.dLV().FQo.EtD.mediaList.get(0)).thumbUrl;
            paramViewGroup.ndI = 2;
            paramViewGroup.Fji = 1;
            paramViewGroup.Fjk = new bub();
            paramViewGroup.EUH = 1;
            paramViewGroup.Fjk.FjY = ((anw)paramView.dLV().FQo.EtD.mediaList.get(0)).width;
            paramViewGroup.Fjk.FjZ = ((anw)paramView.dLV().FQo.EtD.mediaList.get(0)).height;
            paramViewGroup.Id = localp.getSnsId();
            af.dHO().a(paramViewGroup, locala.yOu, paramInt, SnsMsgUI.this.hashCode(), bf.GYF);
            locala.yOu.setVisibility(0);
            continue;
            if (paramView.dLV().FQo.Ety != 29) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.yOu);
            if (paramView.dLV().FQo.EtE == null) {
              continue;
            }
            paramViewGroup = new btz();
            paramViewGroup.Url = paramView.dLV().FQo.EtE.iconUrl;
            paramViewGroup.Fjh = paramView.dLV().FQo.EtE.iconUrl;
            paramViewGroup.ndI = 2;
            paramViewGroup.Fji = 1;
            paramViewGroup.Fjk = new bub();
            paramViewGroup.EUH = 1;
            paramViewGroup.Fjk.FjY = 0.0F;
            paramViewGroup.Fjk.FjZ = 0.0F;
            paramViewGroup.Id = localp.getSnsId();
            af.dHO().a(paramViewGroup, locala.yOu, paramInt, SnsMsgUI.this.hashCode(), bf.GYF);
            locala.yOu.setVisibility(0);
            continue;
            if (paramView.field_type != 2) {
              continue;
            }
            locala.yOu.setTag(null);
            locala.yOr.setVisibility(0);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.dLV().FQl, locala.yOr.getTextSize());
            locala.yOr.setText(paramView);
            continue;
            if (paramViewGroup.size() <= 0) {
              break label4415;
            }
            i = a(paramView.field_type, locala.yOu);
            af.dHO().a((btz)paramViewGroup.get(0), locala.yOu, i, SnsMsgUI.this.hashCode(), bf.GYF);
            if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((btz)paramViewGroup.get(0)).ndI != 6))) {
              continue;
            }
            locala.yOv.setVisibility(0);
            paramView = new j();
            af.dHW().get(localj.systemRowid, paramView);
            locala.yOu.setTag(paramView);
            paramInt = 1;
            paramViewGroup = locala.yOu;
            paramView = paramViewGroup;
            if (paramInt == 0) {
              break label4438;
            }
            paramInt = 0;
            paramView = paramViewGroup;
            continue;
            paramViewGroup = new aw();
            paramViewGroup.dgl = paramView.dMu();
            paramViewGroup.index = 0;
            paramView = new ArrayList();
            paramView.add(locala.yOu);
            paramViewGroup.yMc = paramView;
            paramViewGroup.position = paramInt;
            locala.yOu.setTag(paramViewGroup);
            paramInt = 1;
            continue;
            if ((localczu.ndI == 7) || (localczu.ndI == 8)) {
              continue;
            }
            if (localczu.ndI != 16) {
              continue;
            }
            if (!com.tencent.mm.plugin.sns.model.l.xe(localj.field_snsID)) {
              continue;
            }
            if (localczu.DQr == null) {
              continue;
            }
            ac.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localczu.DQr.FBm), Integer.valueOf(localczu.DQr.FBh) });
            paramView = new com.tencent.mm.plugin.sns.model.l(localj.field_snsID, localczu.DQr);
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(paramView, 0);
            continue;
            if (!com.tencent.mm.plugin.sns.model.p.xh(localj.field_snsID)) {
              continue;
            }
            com.tencent.mm.kernel.g.agS();
            com.tencent.mm.kernel.g.agQ().ghe.a(new com.tencent.mm.plugin.sns.model.p(localj.field_snsID), 0);
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
          paramViewGroup = ((czu)new czu().parseFrom(localj.field_refActionBuf)).Fwn;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.yOq.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!bs.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localp = af.dHR().xK(localj.field_snsID);
          if (localp != null) {
            break label4426;
          }
          paramViewGroup = af.dHU().xB(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4426;
          }
          localp = paramViewGroup.dMb();
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
        if (bs.isNullOrNil(localczu.Fwn)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.e.a(locala.yOq, localp, localczu.Fwn)) {
          a.b.c(locala.yOq, localczu.Fwn);
        }
        paramViewGroup = localczu.Fwn;
        locala.yOq.eM(paramViewGroup, 6);
        if (bs.lr(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.yOq;
        com.tencent.mm.kernel.g.agS();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.yOq.setOnClickListener(new View.OnClickListener()
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
                com.tencent.mm.plugin.sns.storage.b localb = localp.dFR();
                i = j;
                if (localb != null)
                {
                  i = j;
                  if (localb.yfF == 1)
                  {
                    i = j;
                    if (!bs.isNullOrNil(localb.yfG))
                    {
                      SnsMsgUI localSnsMsgUI = SnsMsgUI.this;
                      com.tencent.mm.plugin.sns.storage.a locala = localp.dFQ();
                      Object localObject = localb.yfG;
                      paramAnonymousView = (View)localObject;
                      if (locala != null) {
                        paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV((String)localObject, locala.dtx);
                      }
                      ac.i("MicroMsg.SnsMsgUI", "comment msg headClickParam url " + paramAnonymousView + " " + localb.yfH);
                      localObject = new Intent();
                      if (localb.yfH == 0) {
                        bool = true;
                      }
                      ((Intent)localObject).putExtra("KsnsViewId", locala.dyy);
                      ((Intent)localObject).putExtra("KRightBtn", bool);
                      ((Intent)localObject).putExtra("jsapiargs", new Bundle());
                      ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                      ((Intent)localObject).putExtra("useJs", true);
                      com.tencent.mm.plugin.sns.c.a.iyx.i((Intent)localObject, localSnsMsgUI);
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
              com.tencent.mm.plugin.sns.c.a.iyx.c(paramAnonymousView, SnsMsgUI.this);
            }
            AppMethodBeat.o(98879);
          }
        });
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).aNt(localczu.Fwn);
        i = 0;
        if (bs.isNullOrNil(localczu.FIW)) {
          continue;
        }
        paramViewGroup = localczu.FIW;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label4420;
        }
        if (!bs.isNullOrNil(((com.tencent.mm.n.b)localObject3).aaS())) {
          paramViewGroup = ((com.tencent.mm.n.b)localObject3).aaS();
        }
        localObject1 = paramViewGroup;
        if (!ai.aNc(((com.tencent.mm.g.c.av)localObject3).field_username)) {
          break label4420;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((com.tencent.mm.g.c.av)localObject3).field_openImAppid)) {
          break label4420;
        }
        j = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.iNX.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bB(((com.tencent.mm.g.c.av)localObject3).field_openImAppid, ((com.tencent.mm.g.c.av)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localczu.Fwn)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dFR(), (String)localObject1);
        }
        paramViewGroup = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.iNX.getTextSize());
        if ((localp == null) || (localp.field_type != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100922);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.iNX.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        locala.iNX.setText(paramViewGroup);
        paramViewGroup = localczu.Fwn;
        localObject1 = locala.iNX;
        j = localczu.sVo;
        switch (localj.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label4468;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.yOw;
          localObject1 = locala.yOt;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((bs.gY(localczu.FJe)) || (localczu.FJe.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((dag)localczu.FJe.get(0)).Md5);
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
          locala.timeTv.setText(bg.p(SnsMsgUI.this, localczu.CreateTime * 1000L));
          paramView = null;
          if ((localczu.ndI != 7) && (localczu.ndI != 8) && (localczu.ndI != 16)) {
            continue;
          }
          paramViewGroup = af.dHU().xB(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4435;
          }
          paramView = paramViewGroup.dMb();
          break label4435;
          locala.yOu.setVisibility(8);
          locala.yOr.setVisibility(8);
          locala.yOv.setVisibility(8);
          locala.yOu.setImageBitmap(null);
          af.dHO().eE(locala.yOu);
          if (paramView == null) {
            continue;
          }
          paramViewGroup = paramView.dLV().FQo.Etz;
          if (paramView.dLV().FQo.Ety != 28) {
            continue;
          }
          if (paramView.dLV().FQo.EtD.EGJ != 1) {
            continue;
          }
          locala.yOu.setTag(null);
          locala.yOr.setVisibility(0);
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.dLV().FQo.EtD.desc, locala.yOr.getTextSize());
          locala.yOr.setText(paramView);
          paramView = locala.yOu;
          break label4438;
          paramView.setVisibility(paramInt);
          if ((locala.yOu.getVisibility() != 0) && (locala.yOv.getVisibility() != 0)) {
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
          ((ImageView)((View)localObject2).findViewById(2131305054)).setImageDrawable(am.k(this.context, 2131691190, this.context.getResources().getColor(2131099982)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((j)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localj.yvt))).field_isSilence = localj.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label357;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).aNt(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (bs.lr(((com.tencent.mm.g.c.av)localObject1).field_username, af.dHx())) {
              paramView = ((com.tencent.mm.g.c.av)localObject1).field_nickname;
            } else if (!bs.isNullOrNil(((com.tencent.mm.n.b)localObject1).aaS())) {
              paramView = ((com.tencent.mm.n.b)localObject1).aaS();
            } else {
              paramView = ((com.tencent.mm.g.c.av)localObject1).field_nickname;
            }
          }
          break;
        }
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.ntB = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.ntA = paramg;
    }
    
    final class a
    {
      long dwQ;
      TextView iNX;
      View ntI;
      TextView ntJ;
      TextView timeTv;
      SnsAvatarImageView yOq;
      TextView yOr;
      ImageView yOs;
      TextView yOt;
      MMImageView yOu;
      ImageView yOv;
      EmojiStatusView yOw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */