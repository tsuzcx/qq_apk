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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.fc;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bnt;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.cte;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.n.e;
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
  implements com.tencent.mm.al.f, b.b
{
  private bp AaP;
  private long AfA;
  private int AfB;
  private int AfC;
  private HashMap<Integer, j> AfD;
  private HashMap<Integer, Integer> AfE;
  private a Afq;
  private boolean Afr;
  private boolean Afs;
  private boolean Aft;
  private com.tencent.mm.ui.base.p Afu;
  private com.tencent.mm.ui.base.p Afv;
  private int Afw;
  private View.OnClickListener Afx;
  private k.a Afy;
  Runnable Afz;
  private int fKU;
  private int fromScene;
  private long gwh;
  private String hNh;
  private long hVM;
  private ap handler;
  private ListView list;
  private n.e nUI;
  private View nYl;
  private View oIV;
  private View oIW;
  private boolean oIX;
  private long qXg;
  private int[] rwo;
  int zMG;
  private ay zPi;
  private SnsCmdList zRm;
  long zqE;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.oIW = null;
    this.handler = ag.cVf();
    this.Afr = false;
    this.Afs = false;
    this.zRm = new SnsCmdList();
    this.oIX = false;
    this.Aft = false;
    this.rwo = new int[2];
    this.Afw = 86400;
    this.Afx = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98853);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((paramAnonymousView.getTag() instanceof az)) {
          SnsMsgUI.a(SnsMsgUI.this).w(paramAnonymousView, -1, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98853);
          return;
          if ((paramAnonymousView.getTag() instanceof j)) {
            SnsMsgUI.a(SnsMsgUI.this, (j)paramAnonymousView.getTag());
          } else {
            ad.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramAnonymousView.getTag());
          }
        }
      }
    };
    this.gwh = 0L;
    this.hVM = 0L;
    this.nUI = new SnsMsgUI.4(this);
    this.Afy = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(98861);
        ag.cVf().post(new Runnable()
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
    this.Afz = new Runnable()
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
    this.AfB = 0;
    this.AfC = 0;
    this.AfD = new HashMap();
    this.AfE = new HashMap();
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
        this.AfB += 1;
        if (!this.AfE.containsKey(Integer.valueOf(paramj.zMG))) {
          break label151;
        }
        this.AfE.put(Integer.valueOf(paramj.zMG), Integer.valueOf(((Integer)this.AfE.get(Integer.valueOf(paramj.zMG))).intValue() + 1));
      }
    }
    else {
      label89:
      if ((paramj.field_commentflag & 0x2) <= 0) {
        break label173;
      }
    }
    label151:
    label173:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label178;
      }
      ad.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
      com.tencent.mm.ui.base.h.l(this, 2131763916, 2131755906);
      AppMethodBeat.o(179213);
      return;
      if (paramj.field_type != 2) {
        break;
      }
      this.AfC += 1;
      break;
      this.AfE.put(Integer.valueOf(paramj.zMG), Integer.valueOf(1));
      break label89;
    }
    label178:
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
        localIntent.putExtra("INTENT_SOURCE", ((dfh)new dfh().parseFrom(paramj.field_curActionBuf)).tRT);
        if ((paramj.field_type != 7) && (paramj.field_type != 8) && (paramj.field_type != 16)) {
          break label621;
        }
        localIntent.putExtra("INTENT_SNSID", x.bm("ad_table_", l));
        com.tencent.mm.plugin.sns.storage.p localp = ag.dUe().azZ(x.bm("ad_table_", l));
        if (localp != null) {
          break;
        }
        ad.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
        if (paramj.field_type == 16) {
          com.tencent.mm.plugin.report.service.g.yhR.dD(955, 2);
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
    i = com.tencent.mm.kernel.g.ajC().ajl().getInt(14, 0);
    ad.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localException.dRL().zwv), Integer.valueOf(localException.dRL().zww) });
    if ((i < localException.dRL().zwv) || ((localException.dRL().zww > 0) && (i > localException.dRL().zww)))
    {
      if (!bt.isNullOrNil(localException.dRL().zwx))
      {
        paramj = new Intent();
        paramj.putExtra("rawUrl", localException.dRL().zwx);
        paramj.putExtra("showShare", false);
        paramj.putExtra("show_bottom", false);
        paramj.putExtra("needRedirect", false);
        paramj.putExtra("hardcode_jspermission", JsapiPermissionWrapper.FnD);
        com.tencent.mm.plugin.sns.c.a.iRG.i(paramj, this);
        AppMethodBeat.o(179213);
        return;
      }
      ad.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label621:
      localIntent.putExtra("INTENT_SNSID", x.bm("sns_table_", l));
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
      paramj = com.tencent.mm.plugin.sns.data.q.zw(paramj.field_snsID);
      AppMethodBeat.o(98900);
      return paramj;
    }
    paramj = com.tencent.mm.plugin.sns.data.q.zw(paramj.field_parentID);
    AppMethodBeat.o(98900);
    return paramj;
  }
  
  public final void ays(String paramString)
  {
    AppMethodBeat.i(98896);
    this.Afq.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      ad.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.zRm);
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
        AppMethodBeat.i(198366);
        com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(2131763912), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(198365);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            ag.dUj().hHS.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(198365);
          }
        }, null);
        AppMethodBeat.o(198366);
        return true;
      }
    });
    this.zPi = new ay(this);
    this.nYl = findViewById(2131305011);
    this.list = ((ListView)findViewById(2131305013));
    this.oIV = com.tencent.mm.ui.z.jO(this).inflate(2131495569, null);
    this.oIW = com.tencent.mm.ui.z.jO(this).inflate(2131494788, null);
    ad.d("MicroMsg.SnsMsgUI", "autoLoad " + this.oIX);
    if (this.oIX)
    {
      this.list.addFooterView(this.oIW);
      this.Afq = new a(this, new j());
      this.Afq.setGetViewPositionCallback(new SnsMsgUI.11(this));
      this.Afq.setPerformItemClickListener(new SnsMsgUI.12(this));
      this.Afq.b(new SnsMsgUI.13(this));
      this.Afq.a(new r.a()
      {
        public final void aSs()
        {
          AppMethodBeat.i(198370);
          ad.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).fTM + " unread:" + ag.dUj().bUJ() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).oIZ);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).bXb()) && (ag.dUj().bUJ() == 0)) || (ag.dUj().bUJ() == ag.dUj().dYx())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(198370);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.Afq);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198371);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mr(paramAnonymousInt);
          localb.qY(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (ag.dUj().bUJ() > 0)
            {
              ag.dUj().bUK();
              if (SnsMsgUI.d(SnsMsgUI.this).bXb()) {
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198371);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).bXc();
            }
          }
          paramAnonymousAdapterView = (j)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.Q(ag.dUe().Ai(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(198371);
        }
      });
      new com.tencent.mm.ui.tools.l(this);
      this.list.setOnTouchListener(new SnsMsgUI.16(this));
      this.list.setOnItemLongClickListener(new SnsMsgUI.17(this));
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(198361);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(198361);
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
            if (ag.dUj().bUJ() <= 0) {
              break label197;
            }
            ag.dUj().bUK();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).a(null, null);
            AppMethodBeat.o(198361);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).bXc();
          }
          label211:
          AppMethodBeat.o(198361);
        }
      });
      if (this.Afq.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.nYl.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.Afq.bXb()) && (ag.dUj().bUJ() == 0)) || (ag.dUj().bUJ() == ag.dUj().dYx())) {
        this.oIV.setVisibility(8);
      }
      if ((this.Afq.bXb()) && (this.oIX)) {
        this.list.removeFooterView(this.oIW);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(198362);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(198362);
          return true;
        }
      });
      if ((this.Afq.bXb()) && (this.oIX)) {
        this.list.removeFooterView(this.oIW);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.oIV);
      break;
      label470:
      this.list.setVisibility(0);
      this.nYl.setVisibility(8);
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
      this.zRm.PH(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(210, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(683, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.a(218, this);
    this.hNh = u.aAm();
    this.AaP = ag.dTS();
    this.Afs = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.Afs) {
      this.oIX = true;
    }
    ag.dUj().add(this.Afy);
    setActionbarColor(getActionbarColor());
    initView();
    this.AfA = bt.flT();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    j localj = (j)this.Afq.getItem(paramContextMenuInfo.position);
    if (localj == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.zMG = localj.zMG;
    this.zqE = localj.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (dfh)new dfh().parseFrom(localj.field_curActionBuf);
        if (paramView != null)
        {
          am localam = this.AaP.Bf(paramView.Hgt);
          if (localam == null) {
            continue;
          }
          paramView = localam.adv();
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
      if (!bt.isNullOrNil(paramView.HtE))
      {
        paramView = paramView.HtE;
      }
      else
      {
        paramView = paramView.Hgt;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(2131761721));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    ad.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.qXg = super.getActivityBrowseTimeMs();
    if (ag.dUj().bUJ() > 0) {
      ag.dUj().bUK();
    }
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(210, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(683, this);
    com.tencent.mm.kernel.g.ajD();
    com.tencent.mm.kernel.g.ajB().gAO.b(218, this);
    ag.dUj().remove(this.Afy);
    this.Afq.det();
    ag.dUb().aD(this);
    if (this.Afu != null)
    {
      this.Afu.dismiss();
      this.Afu = null;
    }
    long l = bt.HI();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.AfD.values().iterator();
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
        if (this.AfE.containsKey(Integer.valueOf(((j)localObject1).zMG))) {
          m = ((Integer)this.AfE.get(Integer.valueOf(((j)localObject1).zMG))).intValue();
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
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).zMG), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { b((j)localObject1), Integer.valueOf(((j)localObject1).zMG), ((j)localObject1).field_talker, Integer.valueOf(((j)localObject1).field_type), Integer.valueOf(((j)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new fc();
        localObject2 = ((fc)localObject1).ke(this.AfA);
        ((fc)localObject2).eca = this.fromScene;
        ((fc)localObject2).ekf = this.qXg;
        ((fc)localObject1).ekg = this.AfB;
        ((fc)localObject1).ekh = this.AfC;
        ((fc)localObject1).eke = j;
        ((fc)localObject1).ekd = i;
        ((fc)localObject1).ekj = ((fc)localObject1).t("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((fc)localObject1).aLk();
        this.AfD.clear();
        this.AfE.clear();
        ad.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(bt.aO(l)) });
        ad.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((fc)localObject1).RE() });
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
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.fKU);
    this.fKU = 0;
    ag.dTZ().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = Math.max(0L, localc.cLq - this.gwh);
      }
    }
    if (bt.aQJ() > this.hVM) {}
    for (long l = bt.aQJ() - this.hVM;; l = 1L)
    {
      this.hVM = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.gwh, this.hVM);
      this.gwh = 0L;
      this.hVM = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.hVM = bt.aQJ();
    if ((com.tencent.matrix.b.HK()) && (com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class) != null))
    {
      c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.HL().V(com.tencent.matrix.trace.a.class)).cJy;
      if (localc != null) {
        this.gwh = localc.cLq;
      }
    }
    ag.dTZ().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(98898);
    ad.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramn, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramn instanceof com.tencent.mm.plugin.sns.model.p))
    {
      if (this.Afv != null)
      {
        this.Afv.dismiss();
        this.Afv = null;
      }
      if (paramn != null)
      {
        paramString = (com.tencent.mm.plugin.sns.model.p)paramn;
        if (!paramString.zht) {
          break label181;
        }
        paramString = ((dgb)paramString.rr.hNL.hNQ).Huo;
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
        if (((com.tencent.mm.plugin.sns.model.p)paramn).zhu != null)
        {
          a(((com.tencent.mm.plugin.sns.model.p)paramn).zhu);
          continue;
          label181:
          if (!this.Afr)
          {
            this.Afr = true;
            this.handler.postDelayed(this.Afz, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.Afq.a(null, null);
        Toast.makeText(this, getString(2131761725), 0).show();
      }
    }
    for (;;)
    {
      if (this.Afu != null)
      {
        this.Afu.dismiss();
        this.Afu = null;
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
    protected MMSlideDelView.f AfK;
    int fTM;
    protected MMSlideDelView.g nUw;
    protected MMSlideDelView.c nUx;
    protected MMSlideDelView.d nUz;
    int oIZ;
    private Set<MMSlideDelView> uSl;
    private int zOR;
    
    public a(Context paramContext, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(98880);
      this.uSl = new HashSet();
      this.nUz = new SnsMsgUI.a.1(this);
      this.zOR = aq.fromDPToPix(paramContext, 14);
      this.oIZ = 10;
      this.fTM = this.oIZ;
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
    
    public final void Zu()
    {
      AppMethodBeat.i(98884);
      if ((ag.dUj().bUJ() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        setCursor(ag.dUj().dYw());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.fTM = ag.dUj().dYx();
        setCursor(ag.dUj().QL(this.oIZ));
      }
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(98882);
      det();
      Zu();
      AppMethodBeat.o(98882);
    }
    
    public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
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
      this.AfK = paramf;
    }
    
    public final boolean bXb()
    {
      return this.oIZ >= this.fTM;
    }
    
    public final int bXc()
    {
      AppMethodBeat.i(98885);
      if (bXb())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.oIZ += 10;
      if (this.oIZ <= this.fTM)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.oIZ = this.fTM;
      int i = this.fTM;
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
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localj.zMG))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localj.zMG), localj.dYu());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1581;
        }
        localObject2 = (MMSlideDelView)com.tencent.mm.ui.z.jO(this.context).inflate(2131493169, null);
        paramView = com.tencent.mm.ui.z.jO(this.context).inflate(2131495570, null);
        locala = new a();
        locala.AfM = ((SnsAvatarImageView)paramView.findViewById(2131305008));
        locala.AfM.setWeakContext(this.context);
        locala.jhg = ((TextView)paramView.findViewById(2131305016));
        locala.AfP = ((TextView)paramView.findViewById(2131305010));
        locala.AfO = ((ImageView)paramView.findViewById(2131305014));
        locala.timeTv = ((TextView)paramView.findViewById(2131305017));
        locala.AfQ = ((MMImageView)paramView.findViewById(2131305012));
        locala.AfN = ((TextView)paramView.findViewById(2131305018));
        locala.AfQ.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.nUE = ((MMSlideDelView)localObject2).findViewById(2131304837);
        locala.nUF = ((TextView)((MMSlideDelView)localObject2).findViewById(2131304839));
        locala.AfR = ((ImageView)paramView.findViewById(2131305049));
        locala.AfS = ((EmojiStatusView)paramView.findViewById(2131305009));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.nUw);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.nUx);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.nUz);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label357:
        locala.AfQ.setTag(null);
        locala.dJc = localj.field_snsID;
        locala.nUE.setTag(Integer.valueOf(localj.zMG));
        locala.nUE.setOnClickListener(new SnsMsgUI.a.2(this));
      }
      for (;;)
      {
        try
        {
          localdfh = (dfh)new dfh().parseFrom(localj.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          dfh localdfh;
          final com.tencent.mm.plugin.sns.storage.p localp;
          Object localObject3;
          label1581:
          ad.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          ad.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localdfh.Hgt;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.jhg.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).f(this.context, ((aw)localObject3).field_openImAppid, this.zOR), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100914);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.jhg.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
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
          switch (localdfh.nEf)
          {
          case 1: 
          case 5: 
            paramViewGroup = ag.dUe().Ai(localj.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131763883));
            continue;
            paramView = ao.k(this.context, 2131690247, this.context.getResources().getColor(2131099769));
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
            localObject4 = bt.nullAsNil(localdfh.hDa);
            localObject5 = new SpannableStringBuilder();
            locale = ag.dUh().zZ(localj.field_snsID);
            localObject6 = com.tencent.mm.cc.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ia(localdfh.HtL, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.ajD();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(locale.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131763917)).append(paramView.adv()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.adv().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localdfh, (SpannableStringBuilder)localObject5, (TextView)localObject1);
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
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(ao.k(this.context, 2131690247, this.context.getResources().getColor(2131099769)), null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131763827));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = bt.nullAsNil(localdfh.hDa);
            locale = ag.dUh().zZ(localj.field_snsID);
            localObject6 = com.tencent.mm.cc.a.m(this.context, 2131100914);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ia(localdfh.HtL, 1)) {
              continue;
            }
            if (locale == null) {
              continue;
            }
            com.tencent.mm.kernel.g.ajD();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().aTj(locale.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131763917)).append(paramView.adv()).append(": ");
            paramViewGroup[0] = this.context.getString(2131763917).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.adv().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localdfh, (SpannableStringBuilder)localObject4, (TextView)localObject1);
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
            paramView = paramView + " " + bt.nullAsNil(localdfh.hDa);
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new bnt();
            ad.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localdfh.HtK);
            try
            {
              paramView.parseFrom(com.tencent.mm.platformtools.z.a(localdfh.HtK));
              ad.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.dOa);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).Bf(localdfh.Hgt);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131760811, new Object[] { paramViewGroup.adv(), bt.C(paramView.dOa / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              ad.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new bnt();
            ad.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localdfh.HtK);
            try
            {
              paramViewGroup.parseFrom(com.tencent.mm.platformtools.z.a(localdfh.HtK));
              ad.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.dOa);
              SnsMsgUI.r(SnsMsgUI.this).Bf(localdfh.Hgt);
              paramView = null;
              if (paramViewGroup.dOa == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(2131760814));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView);
                  ((com.tencent.mm.ui.widget.a)localObject3).KQg = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.cc.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
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
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(2131760813, new Object[] { bt.C(paramViewGroup.dOa / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(2131230912);
              continue;
            }
            paramView = ag.dUe().Ai(localj.field_snsID);
            continue;
            paramViewGroup = new j();
            ag.dUj().get(localj.systemRowid, paramViewGroup);
            locala.AfQ.setTag(paramViewGroup);
            if (bt.hj(paramView.mediaList)) {
              continue;
            }
            ((t)com.tencent.mm.kernel.g.ad(t.class)).loadImage(((ari)paramView.mediaList.get(0)).thumbUrl, locala.AfQ);
            locala.AfQ.setVisibility(0);
            if (paramView.Gpi != 4) {
              continue;
            }
            locala.AfR.setVisibility(0);
            continue;
            if (paramView.dYl().HAT.GaP != 29) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.AfQ);
            if (paramView.dYl().HAT.GaV == null) {
              continue;
            }
            paramViewGroup = new j();
            ag.dUj().get(localj.systemRowid, paramViewGroup);
            locala.AfQ.setTag(paramViewGroup);
            paramViewGroup = new byn();
            paramViewGroup.Url = paramView.dYl().HAT.GaV.iconUrl;
            paramViewGroup.GSI = paramView.dYl().HAT.GaV.iconUrl;
            paramViewGroup.nEf = 2;
            paramViewGroup.GSJ = 1;
            paramViewGroup.GSL = new byp();
            paramViewGroup.GEe = 1;
            paramViewGroup.GSL.GTz = 0.0F;
            paramViewGroup.GSL.GTA = 0.0F;
            paramViewGroup.Id = localp.getSnsId();
            ag.dUb().a(paramViewGroup, locala.AfQ, paramInt, SnsMsgUI.this.hashCode(), com.tencent.mm.storage.bj.ILT);
            locala.AfQ.setVisibility(0);
            continue;
            if (paramView.dYl().HAT.GaP != 33) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.AfQ);
            if (paramView.dYl().HAT.GaW == null) {
              continue;
            }
            paramViewGroup = new byn();
            paramViewGroup.Url = paramView.dYl().HAT.GaW.hDm;
            paramViewGroup.GSI = paramView.dYl().HAT.GaW.hDm;
            paramViewGroup.nEf = 2;
            paramViewGroup.GSJ = 1;
            paramViewGroup.GSL = new byp();
            paramViewGroup.GEe = 1;
            paramViewGroup.GSL.GTz = 0.0F;
            paramViewGroup.GSL.GTA = 0.0F;
            paramViewGroup.Id = localp.getSnsId();
            ag.dUb().a(paramViewGroup, locala.AfQ, paramInt, SnsMsgUI.this.hashCode(), com.tencent.mm.storage.bj.ILT);
            locala.AfQ.setVisibility(0);
            continue;
            if (paramView.field_type != 2) {
              continue;
            }
            locala.AfQ.setTag(null);
            locala.AfN.setVisibility(0);
            paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.dYl().HAQ, locala.AfN.getTextSize());
            locala.AfN.setText(paramView);
            continue;
            if (paramViewGroup.size() <= 0) {
              break label4504;
            }
            i = a(paramView.field_type, locala.AfQ);
            ag.dUb().a((byn)paramViewGroup.get(0), locala.AfQ, i, SnsMsgUI.this.hashCode(), com.tencent.mm.storage.bj.ILT);
            if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((byn)paramViewGroup.get(0)).nEf != 6))) {
              continue;
            }
            locala.AfR.setVisibility(0);
            paramView = new j();
            ag.dUj().get(localj.systemRowid, paramView);
            locala.AfQ.setTag(paramView);
            paramInt = 1;
            paramViewGroup = locala.AfQ;
            paramView = paramViewGroup;
            if (paramInt == 0) {
              break label4527;
            }
            paramInt = 0;
            paramView = paramViewGroup;
            continue;
            paramViewGroup = new az();
            paramViewGroup.drH = paramView.dYK();
            paramViewGroup.index = 0;
            paramView = new ArrayList();
            paramView.add(locala.AfQ);
            paramViewGroup.Ady = paramView;
            paramViewGroup.position = paramInt;
            locala.AfQ.setTag(paramViewGroup);
            paramInt = 1;
            continue;
            if ((localdfh.nEf == 7) || (localdfh.nEf == 8)) {
              continue;
            }
            if (localdfh.nEf != 16) {
              continue;
            }
            if (!com.tencent.mm.plugin.sns.model.l.zD(localj.field_snsID)) {
              continue;
            }
            if (localdfh.FvG == null) {
              continue;
            }
            ad.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localdfh.FvG.Hlz), Integer.valueOf(localdfh.FvG.Hlu) });
            paramView = new com.tencent.mm.plugin.sns.model.l(localj.field_snsID, localdfh.FvG);
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(paramView, 0);
            continue;
            if (!com.tencent.mm.plugin.sns.model.p.zG(localj.field_snsID)) {
              continue;
            }
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a(new com.tencent.mm.plugin.sns.model.p(localj.field_snsID), 0);
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
          paramViewGroup = ((dfh)new dfh().parseFrom(localj.field_refActionBuf)).Hgt;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.AfM.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!bt.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localp = ag.dUe().Ai(localj.field_snsID);
          if (localp != null) {
            break label4515;
          }
          paramViewGroup = ag.dUh().zZ(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4515;
          }
          localp = paramViewGroup.dYr();
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
        if (bt.isNullOrNil(localdfh.Hgt)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.e.a(locala.AfM, localp, localdfh.Hgt)) {
          a.b.c(locala.AfM, localdfh.Hgt);
        }
        paramViewGroup = localdfh.Hgt;
        locala.AfM.fe(paramViewGroup, 6);
        if (bt.lQ(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.AfM;
        com.tencent.mm.kernel.g.ajD();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.AfM.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 0;
            AppMethodBeat.i(98879);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            int i = j;
            SnsMsgUI localSnsMsgUI;
            com.tencent.mm.plugin.sns.storage.a locala;
            if (localp != null)
            {
              i = j;
              if (com.tencent.mm.plugin.sns.ui.widget.e.b(localp, paramViewGroup))
              {
                com.tencent.mm.plugin.sns.storage.b localb = localp.dRL();
                i = j;
                if (localb != null)
                {
                  i = j;
                  if (localb.zvH == 1)
                  {
                    i = j;
                    if (!bt.isNullOrNil(localb.zvI))
                    {
                      localSnsMsgUI = SnsMsgUI.this;
                      locala = localp.dRK();
                      localObject = localb.zvI;
                      paramAnonymousView = (View)localObject;
                      if (locala != null) {
                        paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject, locala.dFy);
                      }
                      ad.i("MicroMsg.SnsMsgUI", "comment msg headClickParam url " + paramAnonymousView + " " + localb.zvJ);
                      localObject = new Intent();
                      if (localb.zvJ != 0) {
                        break label338;
                      }
                    }
                  }
                }
              }
            }
            label338:
            for (boolean bool = true;; bool = false)
            {
              ((Intent)localObject).putExtra("KsnsViewId", locala.aQj);
              ((Intent)localObject).putExtra("KRightBtn", bool);
              ((Intent)localObject).putExtra("jsapiargs", new Bundle());
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              ((Intent)localObject).putExtra("useJs", true);
              com.tencent.mm.plugin.sns.c.a.iRG.i((Intent)localObject, localSnsMsgUI);
              i = 1;
              if (i == 0)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramViewGroup);
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 11);
                com.tencent.mm.plugin.sns.c.a.iRG.c(paramAnonymousView, SnsMsgUI.this);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98879);
              return;
            }
          }
        });
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).Bf(localdfh.Hgt);
        i = 0;
        if (bt.isNullOrNil(localdfh.HtE)) {
          continue;
        }
        paramViewGroup = localdfh.HtE;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label4509;
        }
        if (!bt.isNullOrNil(((com.tencent.mm.o.b)localObject3).adv())) {
          paramViewGroup = ((com.tencent.mm.o.b)localObject3).adv();
        }
        localObject1 = paramViewGroup;
        if (!am.aSQ(((aw)localObject3).field_username)) {
          break label4509;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((aw)localObject3).field_openImAppid)) {
          break label4509;
        }
        j = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.jhg.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).bC(((aw)localObject3).field_openImAppid, ((aw)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.e.b(localp, localdfh.Hgt)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.e.b(localp.dRL(), (String)localObject1);
        }
        paramViewGroup = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramViewGroup, locala.jhg.getTextSize());
        if ((localp == null) || (localp.field_type != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.cc.a.m(this.context, 2131100922);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.jhg.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        locala.jhg.setText(paramViewGroup);
        paramViewGroup = localdfh.Hgt;
        localObject1 = locala.jhg;
        j = localdfh.tRT;
        switch (localj.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label4557;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.AfS;
          localObject1 = locala.AfP;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((bt.hj(localdfh.HtM)) || (localdfh.HtM.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((dft)localdfh.HtM.get(0)).Md5);
          paramViewGroup = new int[2];
          if ((localj.field_commentflag & 0x1) <= 0) {
            break label4627;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((TextView)localObject1).setText(2131763913);
          ((TextView)localObject1).setBackgroundColor(SnsMsgUI.this.getResources().getColor(2131100179));
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          locala.timeTv.setText(bj.p(SnsMsgUI.this, localdfh.CreateTime * 1000L));
          paramView = null;
          if ((localdfh.nEf != 7) && (localdfh.nEf != 8) && (localdfh.nEf != 16)) {
            continue;
          }
          paramViewGroup = ag.dUh().zZ(localj.field_snsID);
          if (paramViewGroup == null) {
            break label4524;
          }
          paramView = paramViewGroup.dYr();
          break label4524;
          locala.AfQ.setVisibility(8);
          locala.AfN.setVisibility(8);
          locala.AfR.setVisibility(8);
          locala.AfQ.setImageBitmap(null);
          ag.dUb().eU(locala.AfQ);
          if ((paramView == null) || (paramView.dYl() == null) || (paramView.dYl().HAT == null)) {
            continue;
          }
          paramViewGroup = paramView.dYl().HAT.GaQ;
          if (paramView.dYl().HAT.GaP != 28) {
            continue;
          }
          paramView = paramView.dYl().HAT.GaU;
          if (paramView.Gpi != 1) {
            continue;
          }
          locala.AfQ.setTag(null);
          locala.AfN.setVisibility(0);
          paramView = com.tencent.mm.pluginsdk.ui.span.k.b(SnsMsgUI.this, paramView.desc, locala.AfN.getTextSize());
          locala.AfN.setText(paramView);
          paramView = locala.AfQ;
          break label4527;
          paramView.setVisibility(paramInt);
          if ((locala.AfQ.getVisibility() != 0) && (locala.AfR.getVisibility() != 0)) {
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
          ((ImageView)((View)localObject2).findViewById(2131305054)).setImageDrawable(ao.k(this.context, 2131691190, this.context.getResources().getColor(2131099982)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((j)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localj.zMG))).field_isSilence = localj.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label357;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).Bf(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (bt.lQ(((aw)localObject1).field_username, ag.dTJ())) {
              paramView = ((aw)localObject1).field_nickname;
            } else if (!bt.isNullOrNil(((com.tencent.mm.o.b)localObject1).adv())) {
              paramView = ((com.tencent.mm.o.b)localObject1).adv();
            } else {
              paramView = ((aw)localObject1).field_nickname;
            }
          }
          break;
        }
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.nUx = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.nUw = paramg;
    }
    
    final class a
    {
      SnsAvatarImageView AfM;
      TextView AfN;
      ImageView AfO;
      TextView AfP;
      MMImageView AfQ;
      ImageView AfR;
      EmojiStatusView AfS;
      long dJc;
      TextView jhg;
      View nUE;
      TextView nUF;
      TextView timeTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */