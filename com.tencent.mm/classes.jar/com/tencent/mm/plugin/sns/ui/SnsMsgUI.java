package com.tencent.mm.plugin.sns.ui;

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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.nx;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.fdp;
import com.tencent.mm.protocal.protobuf.feb;
import com.tencent.mm.protocal.protobuf.fel;
import com.tencent.mm.protocal.protobuf.jz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
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
  implements com.tencent.mm.am.h, c.b
{
  private int[] AgN;
  private String JXG;
  long QCF;
  int QYE;
  private be RbC;
  private SnsCmdList RdQ;
  private bx RoL;
  private b RtJ;
  private boolean RtK;
  private boolean RtL;
  private boolean RtM;
  private com.tencent.mm.ui.base.w RtN;
  private com.tencent.mm.ui.base.w RtO;
  private int RtP;
  private View.OnClickListener RtQ;
  private MStorage.IOnStorageChange RtR;
  Runnable RtS;
  private long RtT;
  private int RtU;
  private int RtV;
  private HashMap<Integer, o> RtW;
  private HashMap<Integer, Integer> RtX;
  private int fromScene;
  private MMHandler handler;
  private ListView list;
  private int lyw;
  private long mxe;
  private long oCx;
  private View uiF;
  private View vDA;
  private u.i vzr;
  private View wDF;
  private boolean wDG;
  private long zIy;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.wDF = null;
    this.handler = al.fAG();
    this.RtK = false;
    this.RtL = false;
    this.RdQ = new SnsCmdList();
    this.wDG = false;
    this.RtM = false;
    this.AgN = new int[2];
    this.RtP = 86400;
    this.RtQ = new SnsMsgUI.1(this);
    this.mxe = 0L;
    this.oCx = 0L;
    this.vzr = new SnsMsgUI.4(this);
    this.RtR = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(98861);
        al.fAG().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(98860);
            synchronized (SnsMsgUI.d(SnsMsgUI.this))
            {
              Log.v("MicroMsg.SnsMsgUI", "comment notify");
              SnsMsgUI.n(SnsMsgUI.this);
              SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
              AppMethodBeat.o(98860);
              return;
            }
          }
        });
        AppMethodBeat.o(98861);
      }
    };
    this.RtS = new Runnable()
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
          SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
          SnsMsgUI.t(SnsMsgUI.this);
          AppMethodBeat.o(98862);
          return;
        }
      }
    };
    this.RtU = 0;
    this.RtV = 0;
    this.RtW = new HashMap();
    this.RtX = new HashMap();
    AppMethodBeat.o(98888);
  }
  
  private void a(o paramo)
  {
    AppMethodBeat.i(179213);
    long l = paramo.field_snsID;
    if (paramo != null)
    {
      if (paramo.field_type == 1)
      {
        this.RtU += 1;
        if (!this.RtX.containsKey(Integer.valueOf(paramo.QYE))) {
          break label151;
        }
        this.RtX.put(Integer.valueOf(paramo.QYE), Integer.valueOf(((Integer)this.RtX.get(Integer.valueOf(paramo.QYE))).intValue() + 1));
      }
    }
    else {
      label89:
      if ((paramo.field_commentflag & 0x2) <= 0) {
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
      Log.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
      k.s(this, b.j.sns_msg_sns_has_del_tip, b.j.app_tip);
      AppMethodBeat.o(179213);
      return;
      if (paramo.field_type != 2) {
        break;
      }
      this.RtV += 1;
      break;
      this.RtX.put(Integer.valueOf(paramo.QYE), Integer.valueOf(1));
      break label89;
    }
    label178:
    Intent localIntent = new Intent();
    localIntent.putExtra("INTENT_COMMENT_TYPE", paramo.field_type);
    if ((paramo.field_type == 3) || (paramo.field_type == 5))
    {
      localIntent.setClass(this, SnsStrangerCommentDetailUI.class);
      localIntent.putExtra("INTENT_TALKER", paramo.field_talker);
    }
    for (;;)
    {
      try
      {
        localIntent.putExtra("INTENT_SOURCE", ((fdp)new fdp().parseFrom(paramo.field_curActionBuf)).IcB);
        if ((paramo.field_type != 7) && (paramo.field_type != 8) && (paramo.field_type != 16)) {
          break label640;
        }
        if (WeChatBrands.Business.Entries.MomentAds.checkAvailable(getContext())) {
          break;
        }
        AppMethodBeat.o(179213);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.SnsMsgUI", localException, "", new Object[0]);
        continue;
      }
      localIntent.setClass(this, SnsCommentDetailUI.class);
    }
    localIntent.putExtra("INTENT_SNSID", ai.bE("ad_table_", l));
    SnsInfo localSnsInfo = al.hgB().aZK(ai.bE("ad_table_", l));
    if (localSnsInfo == null)
    {
      Log.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
      if (paramo.field_type == 16) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(955, 2);
      }
      AppMethodBeat.o(179213);
      return;
    }
    i = com.tencent.mm.kernel.h.baE().ban().getInt(14, 0);
    Log.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localSnsInfo.getAdXml().clientMinVersion), Integer.valueOf(localSnsInfo.getAdXml().clientMaxVersion) });
    if ((i < localSnsInfo.getAdXml().clientMinVersion) || ((localSnsInfo.getAdXml().clientMaxVersion > 0) && (i > localSnsInfo.getAdXml().clientMaxVersion)))
    {
      if (!Util.isNullOrNil(localSnsInfo.getAdXml().compatibleUrl))
      {
        paramo = new Intent();
        paramo.putExtra("rawUrl", localSnsInfo.getAdXml().compatibleUrl);
        paramo.putExtra("showShare", false);
        paramo.putExtra("show_bottom", false);
        paramo.putExtra("needRedirect", false);
        paramo.putExtra("hardcode_jspermission", JsapiPermissionWrapper.YxF);
        com.tencent.mm.plugin.sns.d.a.pFn.h(paramo, this);
        AppMethodBeat.o(179213);
        return;
      }
      Log.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label640:
      localIntent.putExtra("INTENT_SNSID", ai.bE("sns_table_", l));
    }
    if (paramo.field_type == 2)
    {
      localIntent.putExtra("INTENT_FROMSUI", true);
      localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramo.field_commentSvrID);
    }
    for (;;)
    {
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(179213);
      return;
      if ((paramo.field_type == 8) || (paramo.field_type == 16))
      {
        localIntent.putExtra("INTENT_FROMSUI", true);
        localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramo.field_commentSvrID);
      }
    }
  }
  
  private static SnsInfo b(o paramo)
  {
    AppMethodBeat.i(307978);
    if (paramo == null)
    {
      AppMethodBeat.o(307978);
      return null;
    }
    try
    {
      SnsInfo localSnsInfo2 = al.hgB().vj(paramo.field_snsID);
      SnsInfo localSnsInfo1 = localSnsInfo2;
      if (localSnsInfo2 == null)
      {
        paramo = al.hgE().vd(paramo.field_snsID);
        localSnsInfo1 = localSnsInfo2;
        if (paramo != null) {
          localSnsInfo1 = paramo.convertToSnsInfo();
        }
      }
      return localSnsInfo1;
    }
    finally
    {
      AppMethodBeat.o(307978);
    }
    return null;
  }
  
  private static String c(o paramo)
  {
    AppMethodBeat.i(98900);
    if (paramo.field_parentID == 0L)
    {
      paramo = t.uA(paramo.field_snsID);
      AppMethodBeat.o(98900);
      return paramo;
    }
    paramo = t.uA(paramo.field_parentID);
    AppMethodBeat.o(98900);
    return paramo;
  }
  
  public final void EE(String paramString)
  {
    AppMethodBeat.i(98896);
    this.RtJ.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void aXr() {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.RdQ);
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
    return b.g.sns_msg_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98893);
    setMMTitle(b.j.sns_msgui_title);
    addTextOptionMenu(0, getString(b.j.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(308517);
        k.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(b.j.sns_msg_clear_mgslist), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(308502);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            al.hgH().omV.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(308502);
          }
        }, null);
        AppMethodBeat.o(308517);
        return true;
      }
    });
    this.RbC = new be(this);
    this.vDA = findViewById(b.f.sns_msg_empty_view);
    this.list = ((ListView)findViewById(b.f.sns_msg_list));
    this.uiF = af.mU(this).inflate(b.g.sns_msg_footer, null);
    this.wDF = af.mU(this).inflate(b.g.mm_footerview, null);
    Log.d("MicroMsg.SnsMsgUI", "autoLoad " + this.wDG);
    if (this.wDG)
    {
      this.list.addFooterView(this.wDF);
      this.RtJ = new b(this, new o());
      this.RtJ.setGetViewPositionCallback(new SnsMsgUI.11(this));
      this.RtJ.setPerformItemClickListener(new SnsMsgUI.12(this));
      this.RtJ.b(new SnsMsgUI.13(this));
      this.RtJ.a(new x.a()
      {
        public final void bWC()
        {
          AppMethodBeat.i(308511);
          Log.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).lNX + " unread:" + al.hgH().dkF() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).wDI);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).dmY()) && (al.hgH().dkF() == 0)) || (al.hgH().dkF() == al.hgH().hkM())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(308511);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.RtJ);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(308560);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (al.hgH().dkF() > 0)
            {
              al.hgH().dkG();
              if (SnsMsgUI.d(SnsMsgUI.this).dmY()) {
                paramAnonymousInt = 0;
              }
            }
            for (;;)
            {
              SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
              if (!SnsMsgUI.f(SnsMsgUI.this))
              {
                if (SnsMsgUI.e(SnsMsgUI.this).getParent() != null)
                {
                  Log.d("MicroMsg.SnsMsgUI", "remove footer");
                  SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.e(SnsMsgUI.this));
                }
                if ((SnsMsgUI.g(SnsMsgUI.this).getParent() == null) && (paramAnonymousInt > 0))
                {
                  SnsMsgUI.b(SnsMsgUI.this).addFooterView(SnsMsgUI.g(SnsMsgUI.this));
                  Log.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                }
              }
              SnsMsgUI.h(SnsMsgUI.this);
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(308560);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).dmZ();
            }
          }
          paramAnonymousAdapterView = (o)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.ab(al.hgB().vj(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(308560);
        }
      });
      new l(this);
      this.list.setOnTouchListener(new SnsMsgUI.16(this));
      this.list.setOnItemLongClickListener(new SnsMsgUI.17(this));
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(308554);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(308554);
            return;
          }
          Log.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
              Log.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", new Object[] { Integer.valueOf(SnsMsgUI.k(SnsMsgUI.this)) });
            }
          }
          else
          {
            if (paramAnonymousAbsListView.getLastVisiblePosition() != paramAnonymousAbsListView.getCount() - 1) {
              break label211;
            }
            if (al.hgH().dkF() <= 0) {
              break label197;
            }
            al.hgH().dkG();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(308554);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).dmZ();
          }
          label211:
          AppMethodBeat.o(308554);
        }
      });
      if (this.RtJ.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.vDA.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.RtJ.dmY()) && (al.hgH().dkF() == 0)) || (al.hgH().dkF() == al.hgH().hkM())) {
        this.uiF.setVisibility(8);
      }
      if ((this.RtJ.dmY()) && (this.wDG)) {
        this.list.removeFooterView(this.wDF);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(308556);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(308556);
          return true;
        }
      });
      if ((this.RtJ.dmY()) && (this.wDG)) {
        this.list.removeFooterView(this.wDF);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.uiF);
      break;
      label470:
      this.list.setVisibility(0);
      this.vDA.setVisibility(8);
      enableOptionMenu(true);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(98895);
    Log.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
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
      this.RdQ.akp(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(210, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(683, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(218, this);
    this.JXG = z.bAM();
    this.RoL = al.hgp();
    this.RtL = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.RtL) {
      this.wDG = true;
    }
    al.hgH().add(this.RtR);
    setActionbarColor(getActionbarColor());
    initView();
    this.RtT = Util.nowMilliSecond();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    if (aw.jkS())
    {
      al.hgH().QYF = true;
      v.jZ();
    }
    ac.a(z.bAM(), 7, "MomentsUnreadMsgStatus", String.format("%s", new Object[] { Long.valueOf(com.tencent.mm.model.cn.bDu() / 1000L) }));
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    o localo = (o)this.RtJ.getItem(paramContextMenuInfo.position);
    if (localo == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.QYE = localo.QYE;
    this.QCF = localo.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (fdp)new fdp().parseFrom(localo.field_curActionBuf);
        if (paramView != null)
        {
          au localau = this.RoL.JE(paramView.abnl);
          if (localau == null) {
            continue;
          }
          paramView = localau.aSV();
          paramContextMenu.setHeaderTitle(Util.nullAsNil(paramView));
          if (localo.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(b.j.notification_sns_msg_not_remind));
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(b.j.app_delete));
      AppMethodBeat.o(98894);
      return;
      if (!Util.isNullOrNil(paramView.abDe))
      {
        paramView = paramView.abDe;
      }
      else
      {
        paramView = paramView.abnl;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(b.j.notification_sns_msg_do_remind));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    Log.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.zIy = super.getActivityBrowseTimeMs();
    if (al.hgH().dkF() > 0) {
      al.hgH().dkG();
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(210, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(683, this);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(218, this);
    al.hgH().remove(this.RtR);
    this.RtJ.fSd();
    al.hgy().bq(this);
    if (this.RtN != null)
    {
      this.RtN.dismiss();
      this.RtN = null;
    }
    long l = Util.currentTicks();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.RtW.values().iterator();
    int i = 0;
    Object localObject1;
    int m;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (o)((Iterator)localObject2).next();
      if (localObject1 == null) {
        break label689;
      }
      if (((o)localObject1).field_isRead == 1)
      {
        m = 1;
        label206:
        if (m != 0) {
          break label686;
        }
        if (((o)localObject1).field_type != 1) {
          break label313;
        }
        i += 1;
        label224:
        m = 0;
        if (this.RtX.containsKey(Integer.valueOf(((o)localObject1).QYE))) {
          m = ((Integer)this.RtX.get(Integer.valueOf(((o)localObject1).QYE))).intValue();
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
    label686:
    label689:
    for (;;)
    {
      k += 1;
      break;
      m = 0;
      break label206;
      label313:
      if (((o)localObject1).field_type == 2)
      {
        j += 1;
        break label224;
        label329:
        if (m == 0)
        {
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { c((o)localObject1), Integer.valueOf(((o)localObject1).QYE), ((o)localObject1).field_talker, Integer.valueOf(((o)localObject1).field_type), Integer.valueOf(((o)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { c((o)localObject1), Integer.valueOf(((o)localObject1).QYE), ((o)localObject1).field_talker, Integer.valueOf(((o)localObject1).field_type), Integer.valueOf(((o)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new nx();
        localObject2 = ((nx)localObject1).fo(this.RtT);
        ((nx)localObject2).iOd = this.fromScene;
        ((nx)localObject2).iuR = this.zIy;
        ((nx)localObject1).iCY = this.RtU;
        ((nx)localObject1).jgG = this.RtV;
        ((nx)localObject1).jgF = j;
        ((nx)localObject1).jgE = i;
        ((nx)localObject1).jgI = ((nx)localObject1).F("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((nx)localObject1).bMH();
        this.RtW.clear();
        this.RtX.clear();
        Log.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
        Log.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((nx)localObject1).aIF() });
        al.hgH().QYF = false;
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
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.lyw);
    this.lyw = 0;
    al.hgw().b(this);
    super.onPause();
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = Math.max(0L, localb.ffH - this.mxe);
      }
    }
    if (Util.nowSecond() > this.oCx) {}
    for (long l = Util.nowSecond() - this.oCx;; l = 1L)
    {
      this.oCx = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.mxe, this.oCx);
      this.mxe = 0L;
      this.oCx = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.oCx = Util.nowSecond();
    if ((com.tencent.matrix.c.isInstalled()) && (com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.tracer.b localb = ((com.tencent.matrix.trace.b)com.tencent.matrix.c.avW().ai(com.tencent.matrix.trace.b.class)).fdr;
      if (localb != null) {
        this.mxe = localb.ffH;
      }
    }
    al.hgw().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(98898);
    Log.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramp, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramp instanceof r))
    {
      if (this.RtO != null)
      {
        this.RtO.dismiss();
        this.RtO = null;
      }
      if (paramp != null)
      {
        paramString = (r)paramp;
        if (!paramString.Qss) {
          break label181;
        }
        paramString = ((fel)c.c.b(paramString.rr.otC)).abDT;
        if ((paramString != null) && (paramString.Id != 0L)) {
          break label155;
        }
        k.s(this, b.j.sns_msg_sns_has_del_tip, b.j.app_tip);
      }
    }
    while (paramp.getType() == 218) {
      if (((com.tencent.mm.plugin.sns.model.s)paramp).type != 12)
      {
        AppMethodBeat.o(98898);
        return;
        label155:
        if (((r)paramp).Qst != null)
        {
          a(((r)paramp).Qst);
          continue;
          label181:
          if (!this.RtK)
          {
            this.RtK = true;
            this.handler.postDelayed(this.RtS, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.RtJ.onNotifyChange(null, null);
        Toast.makeText(this, getString(b.j.notification_sns_msg_set_suc), 0).show();
      }
    }
    for (;;)
    {
      if (this.RtN != null)
      {
        this.RtN.dismiss();
        this.RtN = null;
      }
      AppMethodBeat.o(98898);
      return;
      label269:
      Toast.makeText(this, getString(b.j.notification_sns_msg_set_failed), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(String paramString, boolean paramBoolean) {}
  
  public final void x(String paramString, boolean paramBoolean) {}
  
  final class b
    extends x<o>
  {
    private Set<MMSlideDelView> JNK;
    private int Rbl;
    protected MMSlideDelView.f Rue;
    int lNX;
    protected MMSlideDelView.g vzf;
    protected MMSlideDelView.c vzg;
    protected MMSlideDelView.d vzi;
    int wDI;
    
    public b(Context paramContext, o paramo)
    {
      super(paramo);
      AppMethodBeat.i(98880);
      this.JNK = new HashSet();
      this.vzi = new SnsMsgUI.b.1(this);
      this.Rbl = bd.fromDPToPix(paramContext, 14);
      this.wDI = 10;
      this.lNX = this.wDI;
      AppMethodBeat.o(98880);
    }
    
    private static int a(int paramInt, MMImageView paramMMImageView)
    {
      AppMethodBeat.i(163120);
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = b.i.app_attach_file_icon_webpage;
      }
      for (;;)
      {
        AppMethodBeat.o(163120);
        return paramInt;
        paramInt = b.i.app_attach_file_icon_music;
        continue;
        paramInt = b.i.app_attach_file_icon_video;
        continue;
        paramInt = b.i.app_attach_file_icon_webpage;
        continue;
        paramInt = b.i.app_attach_file_icon_location;
        continue;
        paramInt = b.e.app_attach_file_icon_pic;
        continue;
        paramInt = b.e.app_attach_file_icon_pic;
        continue;
        paramMMImageView.setImageDrawable(null);
        paramInt = i;
        continue;
        paramMMImageView.setImageDrawable(null);
        paramInt = i;
      }
    }
    
    public final void aNy()
    {
      AppMethodBeat.i(98884);
      if ((al.hgH().dkF() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        w(al.hgH().hkL());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.lNX = al.hgH().hkM();
        w(al.hgH().alA(this.wDI));
      }
    }
    
    public final void aNz()
    {
      AppMethodBeat.i(98882);
      fSd();
      aNy();
      AppMethodBeat.o(98882);
    }
    
    public final void b(MMSlideDelView.f paramf)
    {
      this.Rue = paramf;
    }
    
    public final boolean dmY()
    {
      return this.wDI >= this.lNX;
    }
    
    public final int dmZ()
    {
      AppMethodBeat.i(98885);
      if (dmY())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.wDI += 10;
      if (this.wDI <= this.lNX)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.wDI = this.lNX;
      int i = this.lNX;
      AppMethodBeat.o(98885);
      return i % 10;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(98881);
      long l = ((o)getItem(paramInt)).field_snsID;
      AppMethodBeat.o(98881);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98886);
      localo = (o)getItem(paramInt);
      label65:
      Object localObject2;
      if (localo != null)
      {
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localo.QYE))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localo.QYE), localo.hkJ());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1633;
        }
        localObject2 = (MMSlideDelView)af.mU(this.context).inflate(b.g.base_slide_del_view, null);
        paramView = af.mU(this.context).inflate(b.g.sns_msg_item, null);
        locala = new a();
        locala.Rug = ((SnsAvatarImageView)paramView.findViewById(b.f.sns_msg_avatar_iv));
        locala.Rug.setWeakContext(this.context);
        locala.pWj = ((TextView)paramView.findViewById(b.f.sns_msg_nick_tv));
        locala.Ruj = ((TextView)paramView.findViewById(b.f.sns_msg_content_tv));
        locala.Rui = ((ImageView)paramView.findViewById(b.f.sns_msg_lucky_icon));
        locala.timeTv = ((TextView)paramView.findViewById(b.f.sns_msg_time_tv));
        locala.Ruk = ((MMImageView)paramView.findViewById(b.f.sns_msg_iv));
        locala.Ruh = ((TextView)paramView.findViewById(b.f.sns_msg_tv));
        locala.Ruk.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.vzn = ((MMSlideDelView)localObject2).findViewById(b.f.slide_del_del_view);
        locala.vzo = ((TextView)((MMSlideDelView)localObject2).findViewById(b.f.slide_del_view_del_word));
        locala.Rul = ((ImageView)paramView.findViewById(b.f.sns_sight_icon));
        locala.Rum = ((EmojiStatusView)paramView.findViewById(b.f.sns_msg_content_emoji_view));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.vzf);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.vzg);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.vzi);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label360:
        locala.Ruk.setTag(null);
        locala.ibq = localo.field_snsID;
        locala.vzn.setTag(Integer.valueOf(localo.QYE));
        locala.vzn.setOnClickListener(new SnsMsgUI.b.2(this));
      }
      for (;;)
      {
        try
        {
          localfdp = (fdp)new fdp().parseFrom(localo.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          fdp localfdp;
          final SnsInfo localSnsInfo;
          Object localObject3;
          label1633:
          Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          Log.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localfdp.abnl;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.cd.a.l(this.context, b.c.sns_link_color);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.pWj.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).a(this.context, ((az)localObject3).field_openImAppid, this.Rbl, b.c.BW_0_Alpha_0_5), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.cd.a.l(this.context, b.c.sns_link_color);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.pWj.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.m(this.context, b.e.personactivity_notice_stranger_searchicon);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewGroup, null);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.m(this.context, b.e.personactivity_notice_stranger_shakeicon);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.m(this.context, b.e.personactivity_notice_stranger_nearicon);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.m(this.context, b.e.personactivity_notice_stranger_bottleicon);
          continue;
          paramViewGroup = com.tencent.mm.cd.a.m(this.context, b.e.personactivity_notice_stranger_codeicon);
          continue;
          ((TextView)localObject1).setTag(null);
          continue;
          ((TextView)localObject1).setTag(b.f.sns_ad_social_img_url, "");
          ((TextView)localObject1).setTextColor(SnsMsgUI.this.getResources().getColor(b.c.normal_text_color));
          ((TextView)localObject1).setBackgroundDrawable(null);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ((TextView)localObject1).setText("");
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          switch (localfdp.vhJ)
          {
          case 1: 
          case 5: 
            paramViewGroup = al.hgB().vj(localo.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(b.j.sns_like_background));
            continue;
            paramView = bb.m(this.context, b.i.friendactivity_likeicon, this.context.getResources().getColor(b.c.Link));
            if ((paramViewGroup == null) || (paramViewGroup.getTypeFlag() != 21)) {
              continue;
            }
            paramView.setColorFilter(SnsMsgUI.this.getResources().getColor(b.c.sns_lucky_msg_color), PorterDuff.Mode.SRC_ATOP);
            paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
            paramViewGroup = new SpannableString(" ");
            paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
            ((TextView)localObject1).setText(paramViewGroup);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(b.j.sns_friend_like));
            continue;
            paramView.clearColorFilter();
            break;
          case 2: 
          case 3: 
            localObject4 = Util.nullAsNil(localfdp.nUB);
            localObject5 = new SpannableStringBuilder();
            localAdSnsInfo = al.hgE().vd(localo.field_snsID);
            localObject6 = com.tencent.mm.cd.a.l(this.context, b.c.sns_link_color);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.g.lU(localfdp.abDl, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.h.baF();
            paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(b.j.sns_msgui_at)).append(paramView.aSV()).append(": ");
            paramViewGroup[0] = this.context.getString(b.j.sns_msgui_at).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.aSV().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localfdp, (SpannableStringBuilder)localObject5, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, (CharSequence)localObject5, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject5).append(this.context.getString(b.j.sns_msgui_reply)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(b.j.sns_msgui_reply).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 7: 
            paramView = bb.m(this.context, b.i.friendactivity_likeicon, this.context.getResources().getColor(b.c.Link));
            paramViewGroup = SnsMsgUI.d(localo);
            if ((paramViewGroup == null) || (!paramViewGroup.isSocialAttitudeAd())) {
              continue;
            }
            paramView = paramViewGroup.getAdXml().adSocialInfo.QYg;
            ((TextView)localObject1).setTag(b.f.sns_ad_social_img_url, paramView);
            com.tencent.mm.plugin.sns.ad.j.a.a(paramView, new SnsMsgUI.a((TextView)localObject1, paramView));
            continue;
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(paramView, null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(b.j.sns_friend_like));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = Util.nullAsNil(localfdp.nUB);
            localAdSnsInfo = al.hgE().vd(localo.field_snsID);
            localObject6 = com.tencent.mm.cd.a.l(this.context, b.c.sns_link_color);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.g.lU(localfdp.abDl, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.h.baF();
            paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxu(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(b.j.sns_msgui_at)).append(paramView.aSV()).append(": ");
            paramViewGroup[0] = this.context.getString(b.j.sns_msgui_at).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.aSV().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localfdp, (SpannableStringBuilder)localObject4, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, (CharSequence)localObject4, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject4).append(this.context.getString(b.j.sns_msgui_reply)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(b.j.sns_msgui_reply).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 4: 
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(b.j.sns_timeline_ui_with_you));
            break;
          case 19: 
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(b.j.sns_timeline_ui_together_with_you));
            if (!aj.hgd()) {
              continue;
            }
            MultiProcessMMKV.getDefault().encode("sns_with_together_red", 1);
            break;
          case 16: 
            paramView = "" + "[" + SnsMsgUI.this.getString(b.j.sns_ad_comment_at_tip) + "]";
            paramView = paramView + " " + Util.nullAsNil(localfdp.nUB);
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new czh();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localfdp.abDk);
            try
            {
              paramView.parseFrom(com.tencent.mm.platformtools.w.a(localfdp.abDk));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.ihV);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).JE(localfdp.abnl);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(b.j.luck_grab_sns_action_msg, new Object[] { paramViewGroup.aSV(), Util.formatMoney2f(paramView.ihV / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              Log.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new czh();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localfdp.abDk);
            try
            {
              paramViewGroup.parseFrom(com.tencent.mm.platformtools.w.a(localfdp.abDk));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.ihV);
              SnsMsgUI.r(SnsMsgUI.this).JE(localfdp.abnl);
              paramView = null;
              if (paramViewGroup.ihV == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(b.j.luck_sns_action_prize_msg));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView, 1);
                  ((com.tencent.mm.ui.widget.a)localObject3).afSg = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.cd.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
                  paramViewGroup.setSpan(localObject3, 0, 1, 33);
                }
                ((TextView)localObject1).setText(paramViewGroup);
              }
            }
            catch (Exception paramView)
            {
              Log.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramView.getMessage());
              continue;
              SnsMsgUI.b(SnsMsgUI.this, false);
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(b.j.luck_sns_action_msg, new Object[] { Util.formatMoney2f(paramViewGroup.ihV / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(b.e.album_push_lucky_money_icon_drawable);
              continue;
            }
            paramView = al.hgB().vj(localo.field_snsID);
            continue;
            paramViewGroup = new o();
            al.hgH().get(localo.systemRowid, paramViewGroup);
            locala.Ruk.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((bvj)paramView.mediaList.get(0)).thumbUrl, locala.Ruk);
            locala.Ruk.setVisibility(0);
            if (paramView.GfT != 4) {
              continue;
            }
            locala.Rul.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Zpq != 36) {
              continue;
            }
            paramView = paramView.getTimeLine().ContentObj.Zpy;
            paramViewGroup = new o();
            al.hgH().get(localo.systemRowid, paramViewGroup);
            locala.Ruk.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            if (Util.isNullOrNil(((dob)paramView.mediaList.get(0)).coverUrl)) {
              continue;
            }
            ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((dob)paramView.mediaList.get(0)).coverUrl, locala.Ruk);
            locala.Ruk.setVisibility(0);
            locala.Rul.setVisibility(0);
            continue;
            ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(((dob)paramView.mediaList.get(0)).thumbUrl, locala.Ruk);
            continue;
            if ((paramView.getTimeLine().ContentObj.Zpq != 29) && (paramView.getTimeLine().ContentObj.Zpq != 37)) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.Ruk);
            if (paramView.getTimeLine().ContentObj.Zpv == null) {
              continue;
            }
            paramViewGroup = new o();
            al.hgH().get(localo.systemRowid, paramViewGroup);
            locala.Ruk.setTag(paramViewGroup);
            paramViewGroup = new dmz();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Zpv.iconUrl;
            paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.Zpv.iconUrl;
            paramViewGroup.vhJ = 2;
            paramViewGroup.aaTm = 1;
            paramViewGroup.aaTn = new dnb();
            paramViewGroup.aazR = 1;
            paramViewGroup.aaTn.aaUb = 0.0F;
            paramViewGroup.aaTn.aaUc = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
            locala.Ruk.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Zpq != 38) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.Ruk);
            if (paramView.getTimeLine().ContentObj.Zpx == null) {
              continue;
            }
            paramViewGroup = new o();
            al.hgH().get(localo.systemRowid, paramViewGroup);
            locala.Ruk.setTag(paramViewGroup);
            paramViewGroup = new dmz();
            localObject1 = (String)paramView.getTimeLine().ContentObj.Zpx.aacP.get(0);
            paramView = (String)paramView.getTimeLine().ContentObj.Zpx.aacQ.get(0);
            paramViewGroup.Url = ((String)localObject1 + paramView);
            paramViewGroup.aaTl = paramViewGroup.Url;
            paramViewGroup.vhJ = 2;
            paramViewGroup.aaTm = 1;
            paramViewGroup.aaTn = new dnb();
            paramViewGroup.aazR = 1;
            paramViewGroup.aaTn.aaUb = 0.0F;
            paramViewGroup.aaTn.aaUc = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
            locala.Ruk.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Zpq != 33) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.Ruk);
            if (paramView.getTimeLine().ContentObj.Zpw == null) {
              continue;
            }
            paramViewGroup = new dmz();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Zpw.nUM;
            paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.Zpw.nUM;
            paramViewGroup.vhJ = 2;
            paramViewGroup.aaTm = 1;
            paramViewGroup.aaTn = new dnb();
            paramViewGroup.aazR = 1;
            paramViewGroup.aaTn.aaUb = 0.0F;
            paramViewGroup.aaTn.aaUc = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
            locala.Ruk.setVisibility(0);
            continue;
            if ((paramView.getTimeLine().ContentObj.Zpq != 34) && (paramView.getTimeLine().ContentObj.Zpq != 45) && (paramView.getTimeLine().ContentObj.Zpq != 43)) {
              continue;
            }
            a(paramView.field_type, locala.Ruk);
            if (paramView.getTimeLine().ContentObj.DHa == null) {
              continue;
            }
            paramViewGroup = new dmz();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.DHa.coverUrl;
            paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.DHa.coverUrl;
            paramViewGroup.vhJ = 2;
            paramViewGroup.aaTm = 1;
            paramViewGroup.aaTn = new dnb();
            paramViewGroup.aazR = 1;
            paramViewGroup.aaTn.aaUb = paramView.getTimeLine().ContentObj.DHa.width;
            paramViewGroup.aaTn.aaUc = paramView.getTimeLine().ContentObj.DHa.height;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            ((com.tencent.mm.plugin.findersdk.a.cn)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).loadImage(paramView.getTimeLine().ContentObj.DHa.coverUrl, locala.Ruk);
            paramView = locala.Ruk;
            paramInt = 0;
            continue;
            if (paramView.getTimeLine().ContentObj.Zpq != 39) {
              continue;
            }
            switch (paramView.getTimeLine().ContentObj.nUa)
            {
            case 3: 
              paramInt = a(paramView.field_type, locala.Ruk);
              if (paramView.getTimeLine().ContentObj.Zpz == null) {
                continue;
              }
              paramViewGroup = new o();
              al.hgH().get(localo.systemRowid, paramViewGroup);
              locala.Ruk.setTag(paramViewGroup);
              if (Util.isNullOrNil(paramView.getTimeLine().ContentObj.Zpz.iconUrl)) {
                continue;
              }
              paramViewGroup = new dmz();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.Zpz.iconUrl;
              paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.Zpz.iconUrl;
              paramViewGroup.vhJ = 2;
              paramViewGroup.aaTm = 1;
              paramViewGroup.aaTn = new dnb();
              paramViewGroup.aazR = 1;
              paramViewGroup.aaTn.aaUb = 0.0F;
              paramViewGroup.aaTn.aaUc = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
              locala.Ruk.setVisibility(0);
              break;
            case 100000000: 
              paramInt = a(paramView.field_type, locala.Ruk);
              if (paramView.getTimeLine().ContentObj.Zpv == null) {
                continue;
              }
              paramViewGroup = new o();
              al.hgH().get(localo.systemRowid, paramViewGroup);
              locala.Ruk.setTag(paramViewGroup);
              paramViewGroup = new dmz();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.Zpv.iconUrl;
              paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.Zpv.iconUrl;
              paramViewGroup.vhJ = 2;
              paramViewGroup.aaTm = 1;
              paramViewGroup.aaTn = new dnb();
              paramViewGroup.aazR = 1;
              paramViewGroup.aaTn.aaUb = 0.0F;
              paramViewGroup.aaTn.aaUc = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
              locala.Ruk.setVisibility(0);
              continue;
              al.hgy().c(locala.Ruk, -1, b.i.icon_filled_activity, SnsMsgUI.this.hashCode());
              continue;
              if (paramView.getTimeLine().ContentObj.Zpq != 44) {
                continue;
              }
              paramInt = a(paramView.field_type, locala.Ruk);
              if (paramView.getTimeLine().ContentObj.ZpA == null) {
                continue;
              }
              paramViewGroup = new o();
              al.hgH().get(localo.systemRowid, paramViewGroup);
              locala.Ruk.setTag(paramViewGroup);
              if (Util.isNullOrNil(paramView.getTimeLine().ContentObj.ZpA.XOv)) {
                continue;
              }
              paramViewGroup = new dmz();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.ZpA.XOv;
              paramViewGroup.aaTl = paramView.getTimeLine().ContentObj.ZpA.XOv;
              paramViewGroup.vhJ = 2;
              paramViewGroup.aaTm = 1;
              paramViewGroup.aaTn = new dnb();
              paramViewGroup.aazR = 1;
              paramViewGroup.aaTn.aaUb = 0.0F;
              paramViewGroup.aaTn.aaUc = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              al.hgy().a(paramViewGroup, locala.Ruk, paramInt, SnsMsgUI.this.hashCode(), br.adkb);
              locala.Ruk.setVisibility(0);
              continue;
              al.hgy().c(locala.Ruk, -1, b.i.icons_outlined_location, SnsMsgUI.this.hashCode());
              continue;
              if (paramView.getTypeFlag() != 2) {
                continue;
              }
              locala.Ruk.setTag(null);
              locala.Ruh.setVisibility(0);
              paramView = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, paramView.getTimeLine().ContentDesc, locala.Ruh.getTextSize());
              locala.Ruh.setText(paramView);
              continue;
              if (paramViewGroup.size() <= 0) {
                break label6041;
              }
              i = a(paramView.field_type, locala.Ruk);
              al.hgy().a((dmz)paramViewGroup.get(0), locala.Ruk, i, SnsMsgUI.this.hashCode(), br.adkb);
              if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((dmz)paramViewGroup.get(0)).vhJ != 6))) {
                continue;
              }
              locala.Rul.setVisibility(0);
              paramView = new o();
              al.hgH().get(localo.systemRowid, paramView);
              locala.Ruk.setTag(paramView);
              paramInt = 1;
              paramViewGroup = locala.Ruk;
              paramView = paramViewGroup;
              if (paramInt == 0) {
                break label6064;
              }
              paramInt = 0;
              paramView = paramViewGroup;
              continue;
              paramViewGroup = new bf();
              paramViewGroup.hHB = paramView.getLocalid();
              paramViewGroup.index = 0;
              paramView = new ArrayList();
              paramView.add(locala.Ruk);
              paramViewGroup.RrK = paramView;
              paramViewGroup.position = paramInt;
              locala.Ruk.setTag(paramViewGroup);
              paramInt = 1;
              continue;
              if ((localfdp.vhJ == 7) || (localfdp.vhJ == 8)) {
                continue;
              }
              if (localfdp.vhJ != 16) {
                continue;
              }
              if (!com.tencent.mm.plugin.sns.model.m.uG(localo.field_snsID)) {
                continue;
              }
              if (localfdp.YGq == null) {
                continue;
              }
              Log.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localfdp.YGq.abtD), Integer.valueOf(localfdp.YGq.abty) });
              paramView = new com.tencent.mm.plugin.sns.model.m(localo.field_snsID, localfdp.YGq);
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(paramView, 0);
              continue;
              if (!r.uJ(localo.field_snsID)) {
                continue;
              }
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(new r(localo.field_snsID), 0);
              continue;
              paramInt = 0;
              continue;
              paramInt = 8;
              continue;
              paramInt = 8;
              continue;
            }
            break;
          }
        }
        try
        {
          paramViewGroup = ((fdp)new fdp().parseFrom(localo.field_refActionBuf)).abnl;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.Rug.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!Util.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localSnsInfo = al.hgB().vj(localo.field_snsID);
          if (localSnsInfo != null) {
            break label6052;
          }
          paramViewGroup = al.hgE().vd(localo.field_snsID);
          if (paramViewGroup == null) {
            break label6052;
          }
          localSnsInfo = paramViewGroup.convertToSnsInfo();
        }
        catch (Exception paramView)
        {
          Object localObject4;
          Object localObject5;
          AdSnsInfo localAdSnsInfo;
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
          continue;
        }
        if (Util.isNullOrNil(localfdp.abnl)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.g.a(locala.Rug, localSnsInfo, localfdp.abnl)) {
          com.tencent.mm.pluginsdk.ui.a.b.g(locala.Rug, localfdp.abnl);
        }
        paramViewGroup = localfdp.abnl;
        locala.Rug.hj(paramViewGroup, 6);
        if (Util.isEqual(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.Rug;
        com.tencent.mm.kernel.h.baF();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.Rug.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 0;
            AppMethodBeat.i(98879);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            int i = j;
            boolean bool;
            if (localSnsInfo != null)
            {
              i = j;
              if (com.tencent.mm.plugin.sns.ui.widget.g.b(localSnsInfo, paramViewGroup))
              {
                ADXml localADXml = localSnsInfo.getAdXml();
                i = j;
                if (localADXml != null)
                {
                  if ((localADXml.headClickType != 1) || (Util.isNullOrNil(localADXml.headClickParam))) {
                    break label360;
                  }
                  SnsMsgUI localSnsMsgUI = SnsMsgUI.this;
                  ADInfo localADInfo = localSnsInfo.getAdInfo();
                  localObject = localADXml.headClickParam;
                  paramAnonymousView = (View)localObject;
                  if (localADInfo != null) {
                    paramAnonymousView = t.lY((String)localObject, localADInfo.uxInfo);
                  }
                  Log.i("MicroMsg.SnsMsgUI", "comment msg headClickParam url " + paramAnonymousView + " " + localADXml.headClickRightBarShow);
                  localObject = new Intent();
                  if (localADXml.headClickRightBarShow != 0) {
                    break label354;
                  }
                  bool = true;
                  ((Intent)localObject).putExtra("KsnsViewId", localADInfo.viewId);
                  ((Intent)localObject).putExtra("KRightBtn", bool);
                  ((Intent)localObject).putExtra("jsapiargs", new Bundle());
                  ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
                  ((Intent)localObject).putExtra("useJs", true);
                  com.tencent.mm.plugin.sns.d.a.pFn.h((Intent)localObject, localSnsMsgUI);
                  i = 1;
                }
              }
            }
            for (;;)
            {
              if (i == 0)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("Contact_User", paramViewGroup);
                paramAnonymousView.putExtra("CONTACT_INFO_UI_SOURCE", 11);
                com.tencent.mm.plugin.sns.d.a.pFn.c(paramAnonymousView, SnsMsgUI.this);
                ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).report22210(paramViewGroup, 9L);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98879);
              return;
              label354:
              bool = false;
              break;
              label360:
              localObject = com.tencent.mm.plugin.sns.ad.timeline.a.a.f(1, SnsMsgUI.this);
              i = j;
              if (localObject != null)
              {
                i = j;
                if (((com.tencent.mm.plugin.sns.ad.timeline.a.c)localObject).a(paramAnonymousView, 1, localSnsInfo, new com.tencent.mm.plugin.sns.ad.timeline.a.d())) {
                  i = 1;
                }
              }
            }
          }
        });
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).JE(localfdp.abnl);
        i = 0;
        if (Util.isNullOrNil(localfdp.abDe)) {
          continue;
        }
        paramViewGroup = localfdp.abDe;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label6046;
        }
        if (!Util.isNullOrNil(((com.tencent.mm.contact.d)localObject3).aSV())) {
          paramViewGroup = ((com.tencent.mm.contact.d)localObject3).aSV();
        }
        localObject1 = paramViewGroup;
        if (!au.bwO(((az)localObject3).field_username)) {
          break label6046;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((az)localObject3).field_openImAppid)) {
          break label6046;
        }
        j = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, paramViewGroup, locala.pWj.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.api.e)com.tencent.mm.kernel.h.ax(com.tencent.mm.openim.api.e.class)).cc(((az)localObject3).field_openImAppid, ((az)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.g.b(localSnsInfo, localfdp.abnl)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.g.e(localSnsInfo.getAdXml(), (String)localObject1);
        }
        paramViewGroup = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, paramViewGroup, locala.pWj.getTextSize());
        if ((localSnsInfo == null) || (localSnsInfo.getTypeFlag() != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.cd.a.l(this.context, b.c.sns_lucky_item_gold);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.pWj.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        paramViewGroup = ((com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class)).attachTextStatusSpanSync(locala.pWj, localfdp.abnl, paramViewGroup, com.tencent.mm.plugin.textstatus.a.a.b.ThI, locala.pWj.getTextSize());
        locala.pWj.setText(paramViewGroup);
        paramViewGroup = localfdp.abnl;
        localObject1 = locala.pWj;
        j = localfdp.IcB;
        switch (localo.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label6094;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.Rum;
          localObject1 = locala.Ruj;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((Util.isNullOrNil(localfdp.abDm)) || (localfdp.abDm.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((feb)localfdp.abDm.get(0)).Md5);
          paramViewGroup = new int[2];
          if ((localo.field_commentflag & 0x1) <= 0) {
            break label6167;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((TextView)localObject1).setText(b.j.sns_msg_has_del);
          ((TextView)localObject1).setBackgroundColor(SnsMsgUI.this.getResources().getColor(b.c.comment_msg_del));
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          locala.timeTv.setText(bp.v(SnsMsgUI.this, localfdp.CreateTime * 1000L));
          paramView = null;
          if ((localfdp.vhJ != 7) && (localfdp.vhJ != 8) && (localfdp.vhJ != 16)) {
            continue;
          }
          paramViewGroup = al.hgE().vd(localo.field_snsID);
          if (paramViewGroup == null) {
            break label6061;
          }
          paramView = paramViewGroup.convertToSnsInfo();
          break label6061;
          locala.Ruk.setVisibility(8);
          locala.Ruh.setVisibility(8);
          locala.Rul.setVisibility(8);
          locala.Ruk.setImageBitmap(null);
          al.hgy().jt(locala.Ruk);
          if ((paramView == null) || (paramView.getTimeLine() == null) || (paramView.getTimeLine().ContentObj == null)) {
            continue;
          }
          paramViewGroup = paramView.getTimeLine().ContentObj.Zpr;
          if (paramView.getTimeLine().ContentObj.Zpq != 28) {
            continue;
          }
          paramView = paramView.getTimeLine().ContentObj.hKU;
          if (paramView.GfT != 1) {
            continue;
          }
          locala.Ruk.setTag(null);
          locala.Ruh.setVisibility(0);
          paramView = com.tencent.mm.pluginsdk.ui.span.p.b(SnsMsgUI.this, paramView.desc, locala.Ruh.getTextSize());
          locala.Ruh.setText(paramView);
          paramView = locala.Ruk;
          break label6064;
          paramView.setVisibility(paramInt);
          if ((locala.Ruk.getVisibility() != 0) && (locala.Rul.getVisibility() != 0)) {
            continue;
          }
          paramInt = 1;
          paramView = ((View)localObject2).findViewById(b.f.sns_msg_media_parent);
          if (paramInt == 0) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          paramView = ((View)localObject2).findViewById(b.f.sns_silence_icon);
          if (localo.field_isSilence != 1) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          ((ImageView)((View)localObject2).findViewById(b.f.sns_silence_icon)).setImageDrawable(bb.m(this.context, b.i.sns_comment_silence, this.context.getResources().getColor(b.c.arrow_color)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((o)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localo.QYE))).field_isSilence = localo.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label360;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).JE(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (Util.isEqual(((az)localObject1).field_username, al.hgg())) {
              paramView = ((az)localObject1).field_nickname;
            } else if (!Util.isNullOrNil(((com.tencent.mm.contact.d)localObject1).aSV())) {
              paramView = ((com.tencent.mm.contact.d)localObject1).aSV();
            } else {
              paramView = ((az)localObject1).field_nickname;
            }
          }
          break;
        }
      }
    }
    
    public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
    {
      try
      {
        AppMethodBeat.i(98883);
        super.onNotifyChange(paramString, paramMStorageEventData);
        AppMethodBeat.o(98883);
        return;
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
    }
    
    public final void setGetViewPositionCallback(MMSlideDelView.c paramc)
    {
      this.vzg = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.vzf = paramg;
    }
    
    final class a
    {
      SnsAvatarImageView Rug;
      TextView Ruh;
      ImageView Rui;
      TextView Ruj;
      MMImageView Ruk;
      ImageView Rul;
      EmojiStatusView Rum;
      long ibq;
      TextView pWj;
      TextView timeTv;
      View vzn;
      TextView vzo;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */