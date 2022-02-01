package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.f.b.a.ky;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.cje;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.protocal.protobuf.eji;
import com.tencent.mm.protocal.protobuf.eju;
import com.tencent.mm.protocal.protobuf.ekd;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.v.a;
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
  implements com.tencent.mm.an.i, c.b
{
  private bd KBU;
  private SnsCmdList KEo;
  private bv KOY;
  private a KTL;
  private boolean KTM;
  private String KTN;
  private boolean KTO;
  private boolean KTP;
  private com.tencent.mm.ui.base.s KTQ;
  private com.tencent.mm.ui.base.s KTR;
  private int KTS;
  private View.OnClickListener KTT;
  private MStorage.IOnStorageChange KTU;
  Runnable KTV;
  private long KTW;
  private int KTX;
  private int KTY;
  private HashMap<Integer, com.tencent.mm.plugin.sns.storage.h> KTZ;
  private HashMap<Integer, Integer> KUa;
  long Kfb;
  int Kzs;
  private int fromScene;
  private MMHandler handler;
  private int iWt;
  private long jXk;
  private long lJV;
  private ListView list;
  private q.g snt;
  private View sxR;
  private View tzi;
  private View tzj;
  private boolean tzk;
  private int[] wKq;
  private long wmw;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.tzj = null;
    this.handler = aj.etE();
    this.KTM = false;
    this.KTO = false;
    this.KEo = new SnsCmdList();
    this.tzk = false;
    this.KTP = false;
    this.wKq = new int[2];
    this.KTS = 86400;
    this.KTT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98853);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((paramAnonymousView.getTag() instanceof be)) {
          SnsMsgUI.a(SnsMsgUI.this).x(paramAnonymousView, -1, 1);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(98853);
          return;
          if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.sns.storage.h)) {
            SnsMsgUI.a(SnsMsgUI.this, (com.tencent.mm.plugin.sns.storage.h)paramAnonymousView.getTag());
          } else {
            Log.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramAnonymousView.getTag());
          }
        }
      }
    };
    this.jXk = 0L;
    this.lJV = 0L;
    this.snt = new q.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(222681);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(222681);
          return;
          SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.Kzs);
          AppMethodBeat.o(222681);
          return;
          SnsMsgUI.m(SnsMsgUI.this);
          AppMethodBeat.o(222681);
          return;
          SnsMsgUI.a(SnsMsgUI.this, false);
        }
      }
    };
    this.KTU = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(98861);
        aj.etE().post(new Runnable()
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
    this.KTV = new Runnable()
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
    this.KTX = 0;
    this.KTY = 0;
    this.KTZ = new HashMap();
    this.KUa = new HashMap();
    AppMethodBeat.o(98888);
  }
  
  private void a(com.tencent.mm.plugin.sns.storage.h paramh)
  {
    AppMethodBeat.i(179213);
    long l = paramh.field_snsID;
    if (paramh != null)
    {
      if (paramh.field_type == 1)
      {
        this.KTX += 1;
        if (!this.KUa.containsKey(Integer.valueOf(paramh.Kzs))) {
          break label153;
        }
        this.KUa.put(Integer.valueOf(paramh.Kzs), Integer.valueOf(((Integer)this.KUa.get(Integer.valueOf(paramh.Kzs))).intValue() + 1));
      }
    }
    else {
      label90:
      if ((paramh.field_commentflag & 0x2) <= 0) {
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
      Log.i("MicroMsg.SnsMsgUI", "skip goToCommentDetail, comment.isSnsDelFlag");
      com.tencent.mm.ui.base.h.p(this, i.j.sns_msg_sns_has_del_tip, i.j.app_tip);
      AppMethodBeat.o(179213);
      return;
      if (paramh.field_type != 2) {
        break;
      }
      this.KTY += 1;
      break;
      this.KUa.put(Integer.valueOf(paramh.Kzs), Integer.valueOf(1));
      break label90;
    }
    label180:
    Intent localIntent = new Intent();
    localIntent.putExtra("INTENT_COMMENT_TYPE", paramh.field_type);
    if ((paramh.field_type == 3) || (paramh.field_type == 5))
    {
      localIntent.setClass(this, SnsStrangerCommentDetailUI.class);
      localIntent.putExtra("INTENT_TALKER", paramh.field_talker);
    }
    for (;;)
    {
      try
      {
        localIntent.putExtra("INTENT_SOURCE", ((eji)new eji().parseFrom(paramh.field_curActionBuf)).Cqs);
        if ((paramh.field_type != 7) && (paramh.field_type != 8) && (paramh.field_type != 16)) {
          break label646;
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
    localIntent.putExtra("INTENT_SNSID", y.bs("ad_table_", l));
    SnsInfo localSnsInfo = aj.fOI().bbk(y.bs("ad_table_", l));
    if (localSnsInfo == null)
    {
      Log.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
      if (paramh.field_type == 16) {
        com.tencent.mm.plugin.report.service.h.IzE.el(955, 2);
      }
      AppMethodBeat.o(179213);
      return;
    }
    i = com.tencent.mm.kernel.h.aHG().aHp().getInt(14, 0);
    Log.i("MicroMsg.SnsMsgUI", "current client version %s, [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(localSnsInfo.getAdXml().clientMinVersion), Integer.valueOf(localSnsInfo.getAdXml().clientMaxVersion) });
    if ((i < localSnsInfo.getAdXml().clientMinVersion) || ((localSnsInfo.getAdXml().clientMaxVersion > 0) && (i > localSnsInfo.getAdXml().clientMaxVersion)))
    {
      if (!Util.isNullOrNil(localSnsInfo.getAdXml().compatibleUrl))
      {
        paramh = new Intent();
        paramh.putExtra("rawUrl", localSnsInfo.getAdXml().compatibleUrl);
        paramh.putExtra("showShare", false);
        paramh.putExtra("show_bottom", false);
        paramh.putExtra("needRedirect", false);
        paramh.putExtra("hardcode_jspermission", JsapiPermissionWrapper.RBc);
        com.tencent.mm.plugin.sns.c.a.mIG.h(paramh, this);
        AppMethodBeat.o(179213);
        return;
      }
      Log.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label646:
      localIntent.putExtra("INTENT_SNSID", y.bs("sns_table_", l));
    }
    if (paramh.field_type == 2)
    {
      localIntent.putExtra("INTENT_FROMSUI", true);
      localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramh.field_commentSvrID);
    }
    for (;;)
    {
      startActivityForResult(localIntent, 1);
      AppMethodBeat.o(179213);
      return;
      if ((paramh.field_type == 8) || (paramh.field_type == 16))
      {
        localIntent.putExtra("INTENT_FROMSUI", true);
        localIntent.putExtra("INTENT_FROMSUI_COMMENTID", paramh.field_commentSvrID);
      }
    }
  }
  
  private static String b(com.tencent.mm.plugin.sns.storage.h paramh)
  {
    AppMethodBeat.i(98900);
    if (paramh.field_parentID == 0L)
    {
      paramh = com.tencent.mm.plugin.sns.data.t.Qu(paramh.field_snsID);
      AppMethodBeat.o(98900);
      return paramh;
    }
    paramh = com.tencent.mm.plugin.sns.data.t.Qu(paramh.field_parentID);
    AppMethodBeat.o(98900);
    return paramh;
  }
  
  public final void aYK(String paramString)
  {
    AppMethodBeat.i(98896);
    this.KTL.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void cq(String paramString, boolean paramBoolean) {}
  
  public final void cr(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.KEo);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98897);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98897);
    return bool;
  }
  
  public final void fLL() {}
  
  public int getLayoutId()
  {
    return i.g.sns_msg_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98893);
    setMMTitle(i.j.sns_msgui_title);
    addTextOptionMenu(0, getString(i.j.app_clear), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(195109);
        com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(i.j.sns_msg_clear_mgslist), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(204233);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            aj.fON().lvy.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(204233);
          }
        }, null);
        AppMethodBeat.o(195109);
        return true;
      }
    });
    this.KBU = new bd(this);
    this.sxR = findViewById(i.f.sns_msg_empty_view);
    this.list = ((ListView)findViewById(i.f.sns_msg_list));
    this.tzi = ad.kS(this).inflate(i.g.sns_msg_footer, null);
    this.tzj = ad.kS(this).inflate(i.g.mm_footerview, null);
    Log.d("MicroMsg.SnsMsgUI", "autoLoad " + this.tzk);
    if (this.tzk)
    {
      this.list.addFooterView(this.tzj);
      this.KTL = new a(this, new com.tencent.mm.plugin.sns.storage.h());
      this.KTL.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dO(View paramAnonymousView)
        {
          AppMethodBeat.i(267711);
          int i = SnsMsgUI.b(SnsMsgUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(267711);
          return i;
        }
      });
      this.KTL.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void s(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(245731);
          SnsMsgUI.b(SnsMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(245731);
        }
      });
      this.KTL.b(new MMSlideDelView.f()
      {
        public final void cW(Object paramAnonymousObject)
        {
          AppMethodBeat.i(264083);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            AppMethodBeat.o(264083);
            return;
          }
          try
          {
            int i = Util.safeParseInt(paramAnonymousObject.toString());
            SnsMsgUI.a(SnsMsgUI.this, i);
            AppMethodBeat.o(264083);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            Log.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramAnonymousObject, "", new Object[0]);
            AppMethodBeat.o(264083);
          }
        }
      });
      this.KTL.a(new v.a()
      {
        public final void bxN()
        {
          AppMethodBeat.i(200117);
          Log.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).jlf + " unread:" + aj.fON().cHo() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).tzm);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).cJI()) && (aj.fON().cHo() == 0)) || (aj.fON().cHo() == aj.fON().fSB())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(200117);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.KTL);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(194569);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (aj.fON().cHo() > 0)
            {
              aj.fON().cHp();
              if (SnsMsgUI.d(SnsMsgUI.this).cJI()) {
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
              AppMethodBeat.o(194569);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).cJJ();
            }
          }
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.storage.h)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.Y(aj.fOI().Rd(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(194569);
        }
      });
      new com.tencent.mm.ui.tools.m(this);
      this.list.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(207358);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(207358);
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
          AppMethodBeat.i(246670);
          if (paramAnonymousInt < SnsMsgUI.b(SnsMsgUI.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
            AppMethodBeat.o(246670);
            return true;
          }
          new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SnsMsgUI.this, SnsMsgUI.j(SnsMsgUI.this), SnsMsgUI.i(SnsMsgUI.this)[0], SnsMsgUI.i(SnsMsgUI.this)[1]);
          AppMethodBeat.o(246670);
          return true;
        }
      });
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(231101);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(231101);
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
            if (aj.fON().cHo() <= 0) {
              break label197;
            }
            aj.fON().cHp();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(231101);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).cJJ();
          }
          label211:
          AppMethodBeat.o(231101);
        }
      });
      if (this.KTL.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.sxR.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.KTL.cJI()) && (aj.fON().cHo() == 0)) || (aj.fON().cHo() == aj.fON().fSB())) {
        this.tzi.setVisibility(8);
      }
      if ((this.KTL.cJI()) && (this.tzk)) {
        this.list.removeFooterView(this.tzj);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(270582);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(270582);
          return true;
        }
      });
      if ((this.KTL.cJI()) && (this.tzk)) {
        this.list.removeFooterView(this.tzj);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.tzi);
      break;
      label470:
      this.list.setVisibility(0);
      this.sxR.setVisibility(8);
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
      this.KEo.afA(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(210, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(683, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(218, this);
    this.KTN = com.tencent.mm.model.z.bcZ();
    this.KOY = aj.fOw();
    this.KTO = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.KTO) {
      this.tzk = true;
    }
    aj.fON().add(this.KTU);
    setActionbarColor(getActionbarColor());
    initView();
    this.KTW = Util.nowMilliSecond();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    if (ar.hIH())
    {
      aj.fON().Kzt = true;
      com.tencent.mm.plugin.sns.model.v.fOb();
    }
    ab.b(com.tencent.mm.model.z.bcZ(), 7, "MomentsUnreadMsgStatus", String.format("%s", new Object[] { Long.valueOf(cm.bfC() / 1000L) }));
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    com.tencent.mm.plugin.sns.storage.h localh = (com.tencent.mm.plugin.sns.storage.h)this.KTL.getItem(paramContextMenuInfo.position);
    if (localh == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.Kzs = localh.Kzs;
    this.Kfb = localh.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (eji)new eji().parseFrom(localh.field_curActionBuf);
        if (paramView != null)
        {
          as localas = this.KOY.RG(paramView.TWw);
          if (localas == null) {
            continue;
          }
          paramView = localas.ays();
          paramContextMenu.setHeaderTitle(Util.nullAsNil(paramView));
          if (localh.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(i.j.notification_sns_msg_not_remind));
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(i.j.app_delete));
      AppMethodBeat.o(98894);
      return;
      if (!Util.isNullOrNil(paramView.Ulk))
      {
        paramView = paramView.Ulk;
      }
      else
      {
        paramView = paramView.TWw;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(i.j.notification_sns_msg_do_remind));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    Log.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.wmw = super.getActivityBrowseTimeMs();
    if (aj.fON().cHo() > 0) {
      aj.fON().cHp();
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(210, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(683, this);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(218, this);
    aj.fON().remove(this.KTU);
    this.KTL.eKd();
    aj.fOF().aO(this);
    if (this.KTQ != null)
    {
      this.KTQ.dismiss();
      this.KTQ = null;
    }
    long l = Util.currentTicks();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.KTZ.values().iterator();
    int i = 0;
    Object localObject1;
    int m;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.sns.storage.h)((Iterator)localObject2).next();
      if (localObject1 == null) {
        break label689;
      }
      if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isRead == 1)
      {
        m = 1;
        label206:
        if (m != 0) {
          break label686;
        }
        if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type != 1) {
          break label313;
        }
        i += 1;
        label224:
        m = 0;
        if (this.KUa.containsKey(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Kzs))) {
          m = ((Integer)this.KUa.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Kzs))).intValue();
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
      if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type == 2)
      {
        j += 1;
        break label224;
        label329:
        if (m == 0)
        {
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { b((com.tencent.mm.plugin.sns.storage.h)localObject1), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Kzs), ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker, Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { b((com.tencent.mm.plugin.sns.storage.h)localObject1), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Kzs), ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker, Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new ky();
        localObject2 = ((ky)localObject1).vl(this.KTW);
        ((ky)localObject2).gBe = this.fromScene;
        ((ky)localObject2).glN = this.wmw;
        ((ky)localObject1).gsD = this.KTX;
        ((ky)localObject1).gPJ = this.KTY;
        ((ky)localObject1).gPI = j;
        ((ky)localObject1).gPH = i;
        ((ky)localObject1).gPL = ((ky)localObject1).z("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((ky)localObject1).bpa();
        this.KTZ.clear();
        this.KUa.clear();
        Log.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
        Log.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((ky)localObject1).agI() });
        aj.fON().Kzt = false;
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
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.iWt);
    this.iWt = 0;
    aj.fOD().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = Math.max(0L, localc.dgA - this.jXk);
      }
    }
    if (Util.nowSecond() > this.lJV) {}
    for (long l = Util.nowSecond() - this.lJV;; l = 1L)
    {
      this.lJV = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.jXk, this.lJV);
      this.jXk = 0L;
      this.lJV = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.lJV = Util.nowSecond();
    if ((com.tencent.matrix.b.Vt()) && (com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.b)com.tencent.matrix.b.Vu().Y(com.tencent.matrix.trace.b.class)).deH;
      if (localc != null) {
        this.jXk = localc.dgA;
      }
    }
    aj.fOD().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(98898);
    Log.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof r))
    {
      if (this.KTR != null)
      {
        this.KTR.dismiss();
        this.KTR = null;
      }
      if (paramq != null)
      {
        paramString = (r)paramq;
        if (!paramString.JVr) {
          break label181;
        }
        paramString = ((ekd)d.c.b(paramString.rr.lBS)).UlS;
        if ((paramString != null) && (paramString.Id != 0L)) {
          break label155;
        }
        com.tencent.mm.ui.base.h.p(this, i.j.sns_msg_sns_has_del_tip, i.j.app_tip);
      }
    }
    while (paramq.getType() == 218) {
      if (((com.tencent.mm.plugin.sns.model.s)paramq).type != 12)
      {
        AppMethodBeat.o(98898);
        return;
        label155:
        if (((r)paramq).JVs != null)
        {
          a(((r)paramq).JVs);
          continue;
          label181:
          if (!this.KTM)
          {
            this.KTM = true;
            this.handler.postDelayed(this.KTV, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.KTL.onNotifyChange(null, null);
        Toast.makeText(this, getString(i.j.notification_sns_msg_set_suc), 0).show();
      }
    }
    for (;;)
    {
      if (this.KTQ != null)
      {
        this.KTQ.dismiss();
        this.KTQ = null;
      }
      AppMethodBeat.o(98898);
      return;
      label269:
      Toast.makeText(this, getString(i.j.notification_sns_msg_set_failed), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.v<com.tencent.mm.plugin.sns.storage.h>
  {
    private Set<MMSlideDelView> DWB;
    private int KBE;
    protected MMSlideDelView.f KUg;
    int jlf;
    protected MMSlideDelView.g snh;
    protected MMSlideDelView.c sni;
    protected MMSlideDelView.d snk;
    int tzm;
    
    public a(Context paramContext, com.tencent.mm.plugin.sns.storage.h paramh)
    {
      super(paramh);
      AppMethodBeat.i(98880);
      this.DWB = new HashSet();
      this.snk = new MMSlideDelView.d()
      {
        public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(98874);
          if (paramAnonymousBoolean)
          {
            DWB.add(paramAnonymousMMSlideDelView);
            AppMethodBeat.o(98874);
            return;
          }
          DWB.remove(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(98874);
        }
        
        public final boolean eKl()
        {
          AppMethodBeat.i(98875);
          if (DWB.size() > 0)
          {
            AppMethodBeat.o(98875);
            return true;
          }
          AppMethodBeat.o(98875);
          return false;
        }
        
        public final void eKm()
        {
          AppMethodBeat.i(98876);
          Iterator localIterator = DWB.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.hJY();
            }
          }
          DWB.clear();
          AppMethodBeat.o(98876);
        }
        
        public final void eKn()
        {
          AppMethodBeat.i(98877);
          Iterator localIterator = DWB.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.hJX();
            }
          }
          DWB.clear();
          AppMethodBeat.o(98877);
        }
      };
      this.KBE = aw.fromDPToPix(paramContext, 14);
      this.tzm = 10;
      this.jlf = this.tzm;
      AppMethodBeat.o(98880);
    }
    
    private static int a(int paramInt, MMImageView paramMMImageView)
    {
      AppMethodBeat.i(163120);
      int i = -1;
      switch (paramInt)
      {
      default: 
        paramInt = i.i.app_attach_file_icon_webpage;
      }
      for (;;)
      {
        AppMethodBeat.o(163120);
        return paramInt;
        paramInt = i.i.app_attach_file_icon_music;
        continue;
        paramInt = i.i.app_attach_file_icon_video;
        continue;
        paramInt = i.i.app_attach_file_icon_webpage;
        continue;
        paramInt = i.i.app_attach_file_icon_location;
        continue;
        paramInt = i.e.app_attach_file_icon_pic;
        continue;
        paramInt = i.e.app_attach_file_icon_pic;
        continue;
        paramMMImageView.setImageDrawable(null);
        paramInt = i;
        continue;
        paramMMImageView.setImageDrawable(null);
        paramInt = i;
      }
    }
    
    public final void atr()
    {
      AppMethodBeat.i(98884);
      if ((aj.fON().cHo() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        v(aj.fON().fSA());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.jlf = aj.fON().fSB();
        v(aj.fON().agH(this.tzm));
      }
    }
    
    public final void ats()
    {
      AppMethodBeat.i(98882);
      eKd();
      atr();
      AppMethodBeat.o(98882);
    }
    
    public final void b(MMSlideDelView.f paramf)
    {
      this.KUg = paramf;
    }
    
    public final boolean cJI()
    {
      return this.tzm >= this.jlf;
    }
    
    public final int cJJ()
    {
      AppMethodBeat.i(98885);
      if (cJI())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.tzm += 10;
      if (this.tzm <= this.jlf)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.tzm = this.jlf;
      int i = this.jlf;
      AppMethodBeat.o(98885);
      return i % 10;
    }
    
    public final long getItemId(int paramInt)
    {
      AppMethodBeat.i(98881);
      long l = ((com.tencent.mm.plugin.sns.storage.h)getItem(paramInt)).field_snsID;
      AppMethodBeat.o(98881);
      return l;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(98886);
      localh = (com.tencent.mm.plugin.sns.storage.h)getItem(paramInt);
      label65:
      Object localObject2;
      if (localh != null)
      {
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localh.Kzs))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localh.Kzs), localh.fSy());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1621;
        }
        localObject2 = (MMSlideDelView)ad.kS(this.context).inflate(i.g.base_slide_del_view, null);
        paramView = ad.kS(this.context).inflate(i.g.sns_msg_item, null);
        locala = new a();
        locala.KUi = ((SnsAvatarImageView)paramView.findViewById(i.f.sns_msg_avatar_iv));
        locala.KUi.setWeakContext(this.context);
        locala.mZA = ((TextView)paramView.findViewById(i.f.sns_msg_nick_tv));
        locala.KUl = ((TextView)paramView.findViewById(i.f.sns_msg_content_tv));
        locala.KUk = ((ImageView)paramView.findViewById(i.f.sns_msg_lucky_icon));
        locala.timeTv = ((TextView)paramView.findViewById(i.f.sns_msg_time_tv));
        locala.KUm = ((MMImageView)paramView.findViewById(i.f.sns_msg_iv));
        locala.KUj = ((TextView)paramView.findViewById(i.f.sns_msg_tv));
        locala.KUm.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.snp = ((MMSlideDelView)localObject2).findViewById(i.f.slide_del_del_view);
        locala.snq = ((TextView)((MMSlideDelView)localObject2).findViewById(i.f.slide_del_view_del_word));
        locala.KUn = ((ImageView)paramView.findViewById(i.f.sns_sight_icon));
        locala.KUo = ((EmojiStatusView)paramView.findViewById(i.f.sns_msg_content_emoji_view));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.snh);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.sni);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.snk);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label360:
        locala.KUm.setTag(null);
        locala.fWg = localh.field_snsID;
        locala.snp.setTag(Integer.valueOf(localh.Kzs));
        locala.snp.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98878);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.v("MicroMsg.SnsMsgUI", "on delView clicked");
            SnsMsgUI.a.this.snk.eKn();
            if (SnsMsgUI.a.this.KUg != null) {
              SnsMsgUI.a.this.KUg.cW(paramAnonymousView.getTag());
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(98878);
          }
        });
      }
      for (;;)
      {
        try
        {
          localeji = (eji)new eji().parseFrom(localh.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          eji localeji;
          final SnsInfo localSnsInfo;
          Object localObject3;
          label1621:
          Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          Log.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localeji.TWw;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.ci.a.l(this.context, i.c.sns_link_color);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.mZA.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(this.context, ((ax)localObject3).field_openImAppid, this.KBE, i.c.BW_0_Alpha_0_5), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.ci.a.l(this.context, i.c.sns_link_color);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.mZA.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
          continue;
          paramViewGroup = com.tencent.mm.ci.a.m(this.context, i.e.personactivity_notice_stranger_searchicon);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewGroup, null);
          continue;
          paramViewGroup = com.tencent.mm.ci.a.m(this.context, i.e.personactivity_notice_stranger_shakeicon);
          continue;
          paramViewGroup = com.tencent.mm.ci.a.m(this.context, i.e.personactivity_notice_stranger_nearicon);
          continue;
          paramViewGroup = com.tencent.mm.ci.a.m(this.context, i.e.personactivity_notice_stranger_bottleicon);
          continue;
          paramViewGroup = com.tencent.mm.ci.a.m(this.context, i.e.personactivity_notice_stranger_codeicon);
          continue;
          ((TextView)localObject1).setTag(null);
          continue;
          ((TextView)localObject1).setTextColor(SnsMsgUI.this.getResources().getColor(i.c.normal_text_color));
          ((TextView)localObject1).setBackgroundDrawable(null);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ((TextView)localObject1).setText("");
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          switch (localeji.rWu)
          {
          case 1: 
          case 5: 
            paramViewGroup = aj.fOI().Rd(localh.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(i.j.sns_like_background));
            continue;
            paramView = au.o(this.context, i.i.friendactivity_likeicon, this.context.getResources().getColor(i.c.Link));
            if ((paramViewGroup == null) || (paramViewGroup.getTypeFlag() != 21)) {
              continue;
            }
            paramView.setColorFilter(SnsMsgUI.this.getResources().getColor(i.c.sns_lucky_msg_color), PorterDuff.Mode.SRC_ATOP);
            paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
            paramViewGroup = new SpannableString(" ");
            paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
            ((TextView)localObject1).setText(paramViewGroup);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(i.j.sns_friend_like));
            continue;
            paramView.clearColorFilter();
            break;
          case 2: 
          case 3: 
            localObject4 = Util.nullAsNil(localeji.lpy);
            localObject5 = new SpannableStringBuilder();
            localAdSnsInfo = aj.fOL().QX(localh.field_snsID);
            localObject6 = com.tencent.mm.ci.a.l(this.context, i.c.sns_link_color);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ki(localeji.Ulr, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.h.aHH();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(i.j.sns_msgui_at)).append(paramView.ays()).append(": ");
            paramViewGroup[0] = this.context.getString(i.j.sns_msgui_at).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.ays().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localeji, (SpannableStringBuilder)localObject5, (TextView)localObject1);
            paramView = l.b(SnsMsgUI.this, (CharSequence)localObject5, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject5).append(this.context.getString(i.j.sns_msgui_reply)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(i.j.sns_msgui_reply).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 7: 
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(au.o(this.context, i.i.friendactivity_likeicon, this.context.getResources().getColor(i.c.Link)), null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(i.j.sns_friend_like));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = Util.nullAsNil(localeji.lpy);
            localAdSnsInfo = aj.fOL().QX(localh.field_snsID);
            localObject6 = com.tencent.mm.ci.a.l(this.context, i.c.sns_link_color);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.ki(localeji.Ulr, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.h.aHH();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().bwg(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(i.j.sns_msgui_at)).append(paramView.ays()).append(": ");
            paramViewGroup[0] = this.context.getString(i.j.sns_msgui_at).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.ays().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localeji, (SpannableStringBuilder)localObject4, (TextView)localObject1);
            paramView = l.b(SnsMsgUI.this, (CharSequence)localObject4, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject4).append(this.context.getString(i.j.sns_msgui_reply)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(i.j.sns_msgui_reply).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 4: 
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(i.j.sns_timeline_ui_with_you));
            break;
          case 16: 
            paramView = "" + "[" + SnsMsgUI.this.getString(i.j.sns_ad_comment_at_tip) + "]";
            paramView = paramView + " " + Util.nullAsNil(localeji.lpy);
            ((TextView)localObject1).setText(l.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new cje();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localeji.Ulq);
            try
            {
              paramView.parseFrom(com.tencent.mm.platformtools.z.a(localeji.Ulq));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.gbJ);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).RG(localeji.TWw);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(i.j.luck_grab_sns_action_msg, new Object[] { paramViewGroup.ays(), Util.formatMoney2f(paramView.gbJ / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              Log.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new cje();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localeji.Ulq);
            try
            {
              paramViewGroup.parseFrom(com.tencent.mm.platformtools.z.a(localeji.Ulq));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.gbJ);
              SnsMsgUI.r(SnsMsgUI.this).RG(localeji.TWw);
              paramView = null;
              if (paramViewGroup.gbJ == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(i.j.luck_sns_action_prize_msg));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView, 1);
                  ((com.tencent.mm.ui.widget.a)localObject3).Yal = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.ci.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
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
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(i.j.luck_sns_action_msg, new Object[] { Util.formatMoney2f(paramViewGroup.gbJ / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(i.e.album_push_lucky_money_icon_drawable);
              continue;
            }
            paramView = aj.fOI().Rd(localh.field_snsID);
            continue;
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            aj.fON().get(localh.systemRowid, paramViewGroup);
            locala.KUm.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((bjc)paramView.mediaList.get(0)).thumbUrl, locala.KUm);
            locala.KUm.setVisibility(0);
            if (paramView.ACQ != 4) {
              continue;
            }
            locala.KUn.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Sqq != 36) {
              continue;
            }
            paramView = paramView.getTimeLine().ContentObj.Sqy;
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            aj.fON().get(localh.systemRowid, paramViewGroup);
            locala.KUm.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            if (Util.isNullOrNil(((cww)paramView.mediaList.get(0)).coverUrl)) {
              continue;
            }
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)paramView.mediaList.get(0)).coverUrl, locala.KUm);
            locala.KUm.setVisibility(0);
            locala.KUn.setVisibility(0);
            continue;
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(((cww)paramView.mediaList.get(0)).thumbUrl, locala.KUm);
            continue;
            if ((paramView.getTimeLine().ContentObj.Sqq != 29) && (paramView.getTimeLine().ContentObj.Sqq != 37)) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.KUm);
            if (paramView.getTimeLine().ContentObj.Sqv == null) {
              continue;
            }
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            aj.fON().get(localh.systemRowid, paramViewGroup);
            locala.KUm.setTag(paramViewGroup);
            paramViewGroup = new cvt();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Sqv.iconUrl;
            paramViewGroup.TDF = paramView.getTimeLine().ContentObj.Sqv.iconUrl;
            paramViewGroup.rWu = 2;
            paramViewGroup.TDG = 1;
            paramViewGroup.TDH = new cvv();
            paramViewGroup.TlV = 1;
            paramViewGroup.TDH.TEu = 0.0F;
            paramViewGroup.TDH.TEv = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
            locala.KUm.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Sqq != 38) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.KUm);
            if (paramView.getTimeLine().ContentObj.Sqx == null) {
              continue;
            }
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            aj.fON().get(localh.systemRowid, paramViewGroup);
            locala.KUm.setTag(paramViewGroup);
            paramViewGroup = new cvt();
            localObject1 = (String)paramView.getTimeLine().ContentObj.Sqx.STk.get(0);
            paramView = (String)paramView.getTimeLine().ContentObj.Sqx.STl.get(0);
            paramViewGroup.Url = ((String)localObject1 + paramView);
            paramViewGroup.TDF = paramViewGroup.Url;
            paramViewGroup.rWu = 2;
            paramViewGroup.TDG = 1;
            paramViewGroup.TDH = new cvv();
            paramViewGroup.TlV = 1;
            paramViewGroup.TDH.TEu = 0.0F;
            paramViewGroup.TDH.TEv = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
            locala.KUm.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.Sqq != 33) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.KUm);
            if (paramView.getTimeLine().ContentObj.Sqw == null) {
              continue;
            }
            paramViewGroup = new cvt();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Sqw.lpK;
            paramViewGroup.TDF = paramView.getTimeLine().ContentObj.Sqw.lpK;
            paramViewGroup.rWu = 2;
            paramViewGroup.TDG = 1;
            paramViewGroup.TDH = new cvv();
            paramViewGroup.TlV = 1;
            paramViewGroup.TDH.TEu = 0.0F;
            paramViewGroup.TDH.TEv = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
            locala.KUm.setVisibility(0);
            continue;
            if ((paramView.getTimeLine().ContentObj.Sqq != 34) && (paramView.getTimeLine().ContentObj.Sqq != 43)) {
              continue;
            }
            a(paramView.field_type, locala.KUm);
            if (paramView.getTimeLine().ContentObj.yNL == null) {
              continue;
            }
            paramViewGroup = new cvt();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.yNL.coverUrl;
            paramViewGroup.TDF = paramView.getTimeLine().ContentObj.yNL.coverUrl;
            paramViewGroup.rWu = 2;
            paramViewGroup.TDG = 1;
            paramViewGroup.TDH = new cvv();
            paramViewGroup.TlV = 1;
            paramViewGroup.TDH.TEu = paramView.getTimeLine().ContentObj.yNL.width;
            paramViewGroup.TDH.TEv = paramView.getTimeLine().ContentObj.yNL.height;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            ((ak)com.tencent.mm.kernel.h.ag(ak.class)).loadImage(paramView.getTimeLine().ContentObj.yNL.coverUrl, locala.KUm);
            paramView = locala.KUm;
            paramInt = 0;
            continue;
            if (paramView.getTimeLine().ContentObj.Sqq != 39) {
              continue;
            }
            switch (paramView.getTimeLine().ContentObj.loX)
            {
            case 3: 
              paramInt = a(paramView.field_type, locala.KUm);
              if (paramView.getTimeLine().ContentObj.Sqz == null) {
                continue;
              }
              paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
              aj.fON().get(localh.systemRowid, paramViewGroup);
              locala.KUm.setTag(paramViewGroup);
              if (Util.isNullOrNil(paramView.getTimeLine().ContentObj.Sqz.iconUrl)) {
                continue;
              }
              paramViewGroup = new cvt();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.Sqz.iconUrl;
              paramViewGroup.TDF = paramView.getTimeLine().ContentObj.Sqz.iconUrl;
              paramViewGroup.rWu = 2;
              paramViewGroup.TDG = 1;
              paramViewGroup.TDH = new cvv();
              paramViewGroup.TlV = 1;
              paramViewGroup.TDH.TEu = 0.0F;
              paramViewGroup.TDH.TEv = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
              locala.KUm.setVisibility(0);
              break;
            case 100000000: 
              paramInt = a(paramView.field_type, locala.KUm);
              if (paramView.getTimeLine().ContentObj.Sqv == null) {
                continue;
              }
              paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
              aj.fON().get(localh.systemRowid, paramViewGroup);
              locala.KUm.setTag(paramViewGroup);
              paramViewGroup = new cvt();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.Sqv.iconUrl;
              paramViewGroup.TDF = paramView.getTimeLine().ContentObj.Sqv.iconUrl;
              paramViewGroup.rWu = 2;
              paramViewGroup.TDG = 1;
              paramViewGroup.TDH = new cvv();
              paramViewGroup.TlV = 1;
              paramViewGroup.TDH.TEu = 0.0F;
              paramViewGroup.TDH.TEv = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
              locala.KUm.setVisibility(0);
              continue;
              aj.fOF().d(locala.KUm, -1, i.i.icon_filled_activity, SnsMsgUI.this.hashCode());
              continue;
              if (paramView.getTimeLine().ContentObj.Sqq != 44) {
                continue;
              }
              paramInt = a(paramView.field_type, locala.KUm);
              if (paramView.getTimeLine().ContentObj.SqA == null) {
                continue;
              }
              paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
              aj.fON().get(localh.systemRowid, paramViewGroup);
              locala.KUm.setTag(paramViewGroup);
              if (Util.isNullOrNil(paramView.getTimeLine().ContentObj.SqA.QSw)) {
                continue;
              }
              paramViewGroup = new cvt();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.SqA.QSw;
              paramViewGroup.TDF = paramView.getTimeLine().ContentObj.SqA.QSw;
              paramViewGroup.rWu = 2;
              paramViewGroup.TDG = 1;
              paramViewGroup.TDH = new cvv();
              paramViewGroup.TlV = 1;
              paramViewGroup.TDH.TEu = 0.0F;
              paramViewGroup.TDH.TEv = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              aj.fOF().a(paramViewGroup, locala.KUm, paramInt, SnsMsgUI.this.hashCode(), bp.VGn);
              locala.KUm.setVisibility(0);
              continue;
              aj.fOF().d(locala.KUm, -1, i.i.icons_outlined_location, SnsMsgUI.this.hashCode());
              continue;
              if (paramView.getTypeFlag() != 2) {
                continue;
              }
              locala.KUm.setTag(null);
              locala.KUj.setVisibility(0);
              paramView = l.b(SnsMsgUI.this, paramView.getTimeLine().ContentDesc, locala.KUj.getTextSize());
              locala.KUj.setText(paramView);
              continue;
              if (paramViewGroup.size() <= 0) {
                break label5901;
              }
              i = a(paramView.field_type, locala.KUm);
              aj.fOF().a((cvt)paramViewGroup.get(0), locala.KUm, i, SnsMsgUI.this.hashCode(), bp.VGn);
              if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((cvt)paramViewGroup.get(0)).rWu != 6))) {
                continue;
              }
              locala.KUn.setVisibility(0);
              paramView = new com.tencent.mm.plugin.sns.storage.h();
              aj.fON().get(localh.systemRowid, paramView);
              locala.KUm.setTag(paramView);
              paramInt = 1;
              paramViewGroup = locala.KUm;
              paramView = paramViewGroup;
              if (paramInt == 0) {
                break label5924;
              }
              paramInt = 0;
              paramView = paramViewGroup;
              continue;
              paramViewGroup = new be();
              paramViewGroup.fCM = paramView.getLocalid();
              paramViewGroup.index = 0;
              paramView = new ArrayList();
              paramView.add(locala.KUm);
              paramViewGroup.KRL = paramView;
              paramViewGroup.position = paramInt;
              locala.KUm.setTag(paramViewGroup);
              paramInt = 1;
              continue;
              if ((localeji.rWu == 7) || (localeji.rWu == 8)) {
                continue;
              }
              if (localeji.rWu != 16) {
                continue;
              }
              if (!com.tencent.mm.plugin.sns.model.m.QA(localh.field_snsID)) {
                continue;
              }
              if (localeji.RJc == null) {
                continue;
              }
              Log.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localeji.RJc.Ucl), Integer.valueOf(localeji.RJc.Ucg) });
              paramView = new com.tencent.mm.plugin.sns.model.m(localh.field_snsID, localeji.RJc);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(paramView, 0);
              continue;
              if (!r.QD(localh.field_snsID)) {
                continue;
              }
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(new r(localh.field_snsID), 0);
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
          paramViewGroup = ((eji)new eji().parseFrom(localh.field_refActionBuf)).TWw;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.KUi.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!Util.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localSnsInfo = aj.fOI().Rd(localh.field_snsID);
          if (localSnsInfo != null) {
            break label5912;
          }
          paramViewGroup = aj.fOL().QX(localh.field_snsID);
          if (paramViewGroup == null) {
            break label5912;
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
        if (Util.isNullOrNil(localeji.TWw)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.e.a(locala.KUi, localSnsInfo, localeji.TWw)) {
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.KUi, localeji.TWw);
        }
        paramViewGroup = localeji.TWw;
        locala.KUi.gp(paramViewGroup, 6);
        if (Util.isEqual(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.KUi;
        com.tencent.mm.kernel.h.aHH();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.KUi.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 0;
            AppMethodBeat.i(98879);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            int i = j;
            boolean bool;
            if (localSnsInfo != null)
            {
              i = j;
              if (com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, paramViewGroup))
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
                    paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject, localADInfo.uxInfo);
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
                  com.tencent.mm.plugin.sns.c.a.mIG.h((Intent)localObject, localSnsMsgUI);
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
                com.tencent.mm.plugin.sns.c.a.mIG.c(paramAnonymousView, SnsMsgUI.this);
                ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).report22210(paramViewGroup, 9L);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98879);
              return;
              label354:
              bool = false;
              break;
              label360:
              localObject = com.tencent.mm.plugin.sns.ad.timeline.a.a.e(1, SnsMsgUI.this);
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
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).RG(localeji.TWw);
        i = 0;
        if (Util.isNullOrNil(localeji.Ulk)) {
          continue;
        }
        paramViewGroup = localeji.Ulk;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label5906;
        }
        if (!Util.isNullOrNil(((com.tencent.mm.contact.d)localObject3).ays())) {
          paramViewGroup = ((com.tencent.mm.contact.d)localObject3).ays();
        }
        localObject1 = paramViewGroup;
        if (!as.bvK(((ax)localObject3).field_username)) {
          break label5906;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((ax)localObject3).field_openImAppid)) {
          break label5906;
        }
        j = l.b(SnsMsgUI.this, paramViewGroup, locala.mZA.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).bR(((ax)localObject3).field_openImAppid, ((ax)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, localeji.TWw)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.e.d(localSnsInfo.getAdXml(), (String)localObject1);
        }
        paramViewGroup = l.b(SnsMsgUI.this, paramViewGroup, locala.mZA.getTextSize());
        if ((localSnsInfo == null) || (localSnsInfo.getTypeFlag() != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.ci.a.l(this.context, i.c.sns_lucky_item_gold);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.mZA.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        paramViewGroup = ((com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class)).attachTextStatusSpanSync(locala.mZA, localeji.TWw, paramViewGroup, com.tencent.mm.plugin.textstatus.a.a.b.MzE, locala.mZA.getTextSize());
        locala.mZA.setText(paramViewGroup);
        paramViewGroup = localeji.TWw;
        localObject1 = locala.mZA;
        j = localeji.Cqs;
        switch (localh.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label5954;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.KUo;
          localObject1 = locala.KUl;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((Util.isNullOrNil(localeji.Uls)) || (localeji.Uls.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((eju)localeji.Uls.get(0)).Md5);
          paramViewGroup = new int[2];
          if ((localh.field_commentflag & 0x1) <= 0) {
            break label6027;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((TextView)localObject1).setText(i.j.sns_msg_has_del);
          ((TextView)localObject1).setBackgroundColor(SnsMsgUI.this.getResources().getColor(i.c.comment_msg_del));
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          locala.timeTv.setText(bo.s(SnsMsgUI.this, localeji.CreateTime * 1000L));
          paramView = null;
          if ((localeji.rWu != 7) && (localeji.rWu != 8) && (localeji.rWu != 16)) {
            continue;
          }
          paramViewGroup = aj.fOL().QX(localh.field_snsID);
          if (paramViewGroup == null) {
            break label5921;
          }
          paramView = paramViewGroup.convertToSnsInfo();
          break label5921;
          locala.KUm.setVisibility(8);
          locala.KUj.setVisibility(8);
          locala.KUn.setVisibility(8);
          locala.KUm.setImageBitmap(null);
          aj.fOF().gp(locala.KUm);
          if ((paramView == null) || (paramView.getTimeLine() == null) || (paramView.getTimeLine().ContentObj == null)) {
            continue;
          }
          paramViewGroup = paramView.getTimeLine().ContentObj.Sqr;
          if (paramView.getTimeLine().ContentObj.Sqq != 28) {
            continue;
          }
          paramView = paramView.getTimeLine().ContentObj.fFJ;
          if (paramView.ACQ != 1) {
            continue;
          }
          locala.KUm.setTag(null);
          locala.KUj.setVisibility(0);
          paramView = l.b(SnsMsgUI.this, paramView.desc, locala.KUj.getTextSize());
          locala.KUj.setText(paramView);
          paramView = locala.KUm;
          break label5924;
          paramView.setVisibility(paramInt);
          if ((locala.KUm.getVisibility() != 0) && (locala.KUn.getVisibility() != 0)) {
            continue;
          }
          paramInt = 1;
          paramView = ((View)localObject2).findViewById(i.f.sns_msg_media_parent);
          if (paramInt == 0) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          paramView = ((View)localObject2).findViewById(i.f.sns_silence_icon);
          if (localh.field_isSilence != 1) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          ((ImageView)((View)localObject2).findViewById(i.f.sns_silence_icon)).setImageDrawable(au.o(this.context, i.i.sns_comment_silence, this.context.getResources().getColor(i.c.arrow_color)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((com.tencent.mm.plugin.sns.storage.h)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localh.Kzs))).field_isSilence = localh.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label360;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).RG(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (Util.isEqual(((ax)localObject1).field_username, aj.fOo())) {
              paramView = ((ax)localObject1).field_nickname;
            } else if (!Util.isNullOrNil(((com.tencent.mm.contact.d)localObject1).ays())) {
              paramView = ((com.tencent.mm.contact.d)localObject1).ays();
            } else {
              paramView = ((ax)localObject1).field_nickname;
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
      this.sni = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.snh = paramg;
    }
    
    final class a
    {
      SnsAvatarImageView KUi;
      TextView KUj;
      ImageView KUk;
      TextView KUl;
      MMImageView KUm;
      ImageView KUn;
      EmojiStatusView KUo;
      long fWg;
      TextView mZA;
      View snp;
      TextView snq;
      TextView timeTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */