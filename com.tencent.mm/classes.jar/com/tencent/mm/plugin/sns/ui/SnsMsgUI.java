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
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.g.b.a.ip;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cbd;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.protocal.protobuf.dzu;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.jo;
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
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.s.a;
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
  implements com.tencent.mm.ak.i, c.b
{
  long DRU;
  private bv EBg;
  private a EFR;
  private boolean EFS;
  private String EFT;
  private boolean EFU;
  private boolean EFV;
  private com.tencent.mm.ui.base.q EFW;
  private com.tencent.mm.ui.base.q EFX;
  private int EFY;
  private View.OnClickListener EFZ;
  private MStorage.IOnStorageChange EGa;
  Runnable EGb;
  private long EGc;
  private int EGd;
  private int EGe;
  private HashMap<Integer, com.tencent.mm.plugin.sns.storage.h> EGf;
  private HashMap<Integer, Integer> EGg;
  int Emk;
  private bb EoL;
  private SnsCmdList EqW;
  private int fromScene;
  private int gsi;
  private MMHandler handler;
  private long hlB;
  private long iTC;
  private ListView list;
  private o.g plk;
  private View poS;
  private View qdl;
  private View qdm;
  private boolean qdn;
  private long sGB;
  private int[] tef;
  
  public SnsMsgUI()
  {
    AppMethodBeat.i(98888);
    this.qdm = null;
    this.handler = com.tencent.mm.plugin.sns.model.aj.dRd();
    this.EFS = false;
    this.EFU = false;
    this.EqW = new SnsCmdList();
    this.qdn = false;
    this.EFV = false;
    this.tef = new int[2];
    this.EFY = 86400;
    this.EFZ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(98853);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((paramAnonymousView.getTag() instanceof bc)) {
          SnsMsgUI.a(SnsMsgUI.this).v(paramAnonymousView, -1, 1);
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
    this.hlB = 0L;
    this.iTC = 0L;
    this.plk = new o.g()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(203600);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(203600);
          return;
          SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.Emk);
          AppMethodBeat.o(203600);
          return;
          SnsMsgUI.m(SnsMsgUI.this);
          AppMethodBeat.o(203600);
          return;
          SnsMsgUI.a(SnsMsgUI.this, false);
        }
      }
    };
    this.EGa = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(98861);
        com.tencent.mm.plugin.sns.model.aj.dRd().post(new Runnable()
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
    this.EGb = new Runnable()
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
    this.EGd = 0;
    this.EGe = 0;
    this.EGf = new HashMap();
    this.EGg = new HashMap();
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
        this.EGd += 1;
        if (!this.EGg.containsKey(Integer.valueOf(paramh.Emk))) {
          break label153;
        }
        this.EGg.put(Integer.valueOf(paramh.Emk), Integer.valueOf(((Integer)this.EGg.get(Integer.valueOf(paramh.Emk))).intValue() + 1));
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
      com.tencent.mm.ui.base.h.n(this, 2131766143, 2131755998);
      AppMethodBeat.o(179213);
      return;
      if (paramh.field_type != 2) {
        break;
      }
      this.EGe += 1;
      break;
      this.EGg.put(Integer.valueOf(paramh.Emk), Integer.valueOf(1));
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
        localIntent.putExtra("INTENT_SOURCE", ((dzi)new dzi().parseFrom(paramh.field_curActionBuf)).xub);
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
    localIntent.putExtra("INTENT_SNSID", y.bp("ad_table_", l));
    SnsInfo localSnsInfo = com.tencent.mm.plugin.sns.model.aj.faO().aQl(y.bp("ad_table_", l));
    if (localSnsInfo == null)
    {
      Log.i("MicroMsg.SnsMsgUI", "sns id " + l + "was not exist!");
      if (paramh.field_type == 16) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(955, 2);
      }
      AppMethodBeat.o(179213);
      return;
    }
    i = com.tencent.mm.kernel.g.aAh().azQ().getInt(14, 0);
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
        paramh.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
        com.tencent.mm.plugin.sns.c.a.jRt.i(paramh, this);
        AppMethodBeat.o(179213);
        return;
      }
      Log.w("MicroMsg.SnsMsgUI", "compatible jump url is null!");
      AppMethodBeat.o(179213);
      return;
      label646:
      localIntent.putExtra("INTENT_SNSID", y.bp("sns_table_", l));
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
      paramh = com.tencent.mm.plugin.sns.data.r.Jb(paramh.field_snsID);
      AppMethodBeat.o(98900);
      return paramh;
    }
    paramh = com.tencent.mm.plugin.sns.data.r.Jb(paramh.field_parentID);
    AppMethodBeat.o(98900);
    return paramh;
  }
  
  public final void aOG(String paramString)
  {
    AppMethodBeat.i(98896);
    this.EFR.notifyDataSetChanged();
    AppMethodBeat.o(98896);
  }
  
  public final void ci(String paramString, boolean paramBoolean) {}
  
  public final void cj(String paramString, boolean paramBoolean) {}
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(98897);
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0))
    {
      Log.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
      paramKeyEvent = new Intent();
      paramKeyEvent.putExtra("sns_cmd_list", this.EqW);
      setResult(-1, paramKeyEvent);
      finish();
      AppMethodBeat.o(98897);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(98897);
    return bool;
  }
  
  public final void eZJ() {}
  
  public int getLayoutId()
  {
    return 2131496466;
  }
  
  public void initView()
  {
    AppMethodBeat.i(98893);
    setMMTitle(2131766146);
    addTextOptionMenu(0, getString(2131755764), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(203603);
        com.tencent.mm.ui.base.h.a(SnsMsgUI.this.getContext(), SnsMsgUI.this.getString(2131766139), "", new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(203602);
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            com.tencent.mm.plugin.sns.model.aj.faT().iFy.execSQL("SnsComment", "delete from SnsComment");
            SnsMsgUI.this.enableOptionMenu(false);
            AppMethodBeat.o(203602);
          }
        }, null);
        AppMethodBeat.o(203603);
        return true;
      }
    });
    this.EoL = new bb(this);
    this.poS = findViewById(2131308162);
    this.list = ((ListView)findViewById(2131308164));
    this.qdl = aa.jQ(this).inflate(2131496464, null);
    this.qdm = aa.jQ(this).inflate(2131495522, null);
    Log.d("MicroMsg.SnsMsgUI", "autoLoad " + this.qdn);
    if (this.qdn)
    {
      this.list.addFooterView(this.qdm);
      this.EFR = new a(this, new com.tencent.mm.plugin.sns.storage.h());
      this.EFR.setGetViewPositionCallback(new MMSlideDelView.c()
      {
        public final int dr(View paramAnonymousView)
        {
          AppMethodBeat.i(203604);
          int i = SnsMsgUI.b(SnsMsgUI.this).getPositionForView(paramAnonymousView);
          AppMethodBeat.o(203604);
          return i;
        }
      });
      this.EFR.setPerformItemClickListener(new MMSlideDelView.g()
      {
        public final void r(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(203605);
          SnsMsgUI.b(SnsMsgUI.this).performItemClick(paramAnonymousView, paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(203605);
        }
      });
      this.EFR.b(new MMSlideDelView.f()
      {
        public final void cZ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(203606);
          if (paramAnonymousObject == null)
          {
            Log.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            AppMethodBeat.o(203606);
            return;
          }
          try
          {
            int i = Util.safeParseInt(paramAnonymousObject.toString());
            SnsMsgUI.a(SnsMsgUI.this, i);
            AppMethodBeat.o(203606);
            return;
          }
          catch (Exception paramAnonymousObject)
          {
            Log.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramAnonymousObject, "", new Object[0]);
            AppMethodBeat.o(203606);
          }
        }
      });
      this.EFR.a(new s.a()
      {
        public final void bnE()
        {
          AppMethodBeat.i(203607);
          Log.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.d(SnsMsgUI.this).gAZ + " unread:" + com.tencent.mm.plugin.sns.model.aj.faT().ctM() + "  showcount:" + SnsMsgUI.d(SnsMsgUI.this).qdp);
          if (SnsMsgUI.d(SnsMsgUI.this).getCount() == 0)
          {
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.this.enableOptionMenu(false);
          }
          for (;;)
          {
            if (((SnsMsgUI.d(SnsMsgUI.this).cwg()) && (com.tencent.mm.plugin.sns.model.aj.faT().ctM() == 0)) || (com.tencent.mm.plugin.sns.model.aj.faT().ctM() == com.tencent.mm.plugin.sns.model.aj.faT().feH())) {
              SnsMsgUI.e(SnsMsgUI.this).setVisibility(8);
            }
            AppMethodBeat.o(203607);
            return;
            SnsMsgUI.b(SnsMsgUI.this).setVisibility(0);
            SnsMsgUI.c(SnsMsgUI.this).setVisibility(8);
            SnsMsgUI.this.enableOptionMenu(true);
          }
        }
      });
      this.list.setAdapter(this.EFR);
      this.list.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(203608);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
          if (paramAnonymousInt == SnsMsgUI.d(SnsMsgUI.this).getCount())
          {
            if (com.tencent.mm.plugin.sns.model.aj.faT().ctM() > 0)
            {
              com.tencent.mm.plugin.sns.model.aj.faT().ctN();
              if (SnsMsgUI.d(SnsMsgUI.this).cwg()) {
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
              AppMethodBeat.o(203608);
              return;
              paramAnonymousInt = 1;
              continue;
              paramAnonymousInt = SnsMsgUI.d(SnsMsgUI.this).cwh();
            }
          }
          paramAnonymousAdapterView = (com.tencent.mm.plugin.sns.storage.h)SnsMsgUI.d(SnsMsgUI.this).getItem(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (!SnsMsgUI.X(com.tencent.mm.plugin.sns.model.aj.faO().JJ(paramAnonymousAdapterView.field_snsID)))) {
            SnsMsgUI.a(SnsMsgUI.this, paramAnonymousAdapterView);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$7", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(203608);
        }
      });
      new com.tencent.mm.ui.tools.l(this);
      this.list.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(203609);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(203609);
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
          AppMethodBeat.i(203610);
          if (paramAnonymousInt < SnsMsgUI.b(SnsMsgUI.this).getHeaderViewsCount())
          {
            Log.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
            AppMethodBeat.o(203610);
            return true;
          }
          new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(paramAnonymousView, paramAnonymousInt, paramAnonymousLong, SnsMsgUI.this, SnsMsgUI.j(SnsMsgUI.this), SnsMsgUI.i(SnsMsgUI.this)[0], SnsMsgUI.i(SnsMsgUI.this)[1]);
          AppMethodBeat.o(203610);
          return true;
        }
      });
      this.list.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
        {
          AppMethodBeat.i(203598);
          if (!SnsMsgUI.f(SnsMsgUI.this))
          {
            AppMethodBeat.o(203598);
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
            if (com.tencent.mm.plugin.sns.model.aj.faT().ctM() <= 0) {
              break label197;
            }
            com.tencent.mm.plugin.sns.model.aj.faT().ctN();
          }
          for (;;)
          {
            SnsMsgUI.d(SnsMsgUI.this).onNotifyChange(null, null);
            AppMethodBeat.o(203598);
            return;
            paramAnonymousInt = 0;
            break;
            label197:
            SnsMsgUI.d(SnsMsgUI.this).cwh();
          }
          label211:
          AppMethodBeat.o(203598);
        }
      });
      if (this.EFR.getCount() != 0) {
        break label470;
      }
      this.list.setVisibility(8);
      this.poS.setVisibility(0);
      enableOptionMenu(false);
    }
    for (;;)
    {
      if (((this.EFR.cwg()) && (com.tencent.mm.plugin.sns.model.aj.faT().ctM() == 0)) || (com.tencent.mm.plugin.sns.model.aj.faT().ctM() == com.tencent.mm.plugin.sns.model.aj.faT().feH())) {
        this.qdl.setVisibility(8);
      }
      if ((this.EFR.cwg()) && (this.qdn)) {
        this.list.removeFooterView(this.qdm);
      }
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(203599);
          paramAnonymousMenuItem = new Intent();
          paramAnonymousMenuItem.putExtra("sns_cmd_list", SnsMsgUI.l(SnsMsgUI.this));
          SnsMsgUI.this.setResult(-1, paramAnonymousMenuItem);
          SnsMsgUI.this.finish();
          AppMethodBeat.o(203599);
          return true;
        }
      });
      if ((this.EFR.cwg()) && (this.qdn)) {
        this.list.removeFooterView(this.qdm);
      }
      AppMethodBeat.o(98893);
      return;
      this.list.addFooterView(this.qdl);
      break;
      label470:
      this.list.setVisibility(0);
      this.poS.setVisibility(8);
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
      this.EqW.Yj(paramInt1);
    }
    AppMethodBeat.o(98895);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98889);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(210, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(683, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(218, this);
    this.EFT = com.tencent.mm.model.z.aTY();
    this.EBg = com.tencent.mm.plugin.sns.model.aj.faC();
    this.EFU = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
    if (this.EFU) {
      this.qdn = true;
    }
    com.tencent.mm.plugin.sns.model.aj.faT().add(this.EGa);
    setActionbarColor(getActionbarColor());
    initView();
    this.EGc = Util.nowMilliSecond();
    this.fromScene = getIntent().getIntExtra("sns_msg_comment_list_scene", 0);
    AppMethodBeat.o(98889);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(98894);
    paramContextMenuInfo = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    com.tencent.mm.plugin.sns.storage.h localh = (com.tencent.mm.plugin.sns.storage.h)this.EFR.getItem(paramContextMenuInfo.position);
    if (localh == null)
    {
      AppMethodBeat.o(98894);
      return;
    }
    this.Emk = localh.Emk;
    this.DRU = localh.field_snsID;
    for (;;)
    {
      try
      {
        paramView = (dzi)new dzi().parseFrom(localh.field_curActionBuf);
        if (paramView != null)
        {
          as localas = this.EBg.Kn(paramView.MKC);
          if (localas == null) {
            continue;
          }
          paramView = localas.arJ();
          paramContextMenu.setHeaderTitle(Util.nullAsNil(paramView));
          if (localh.field_isSilence != 0) {
            continue;
          }
          paramContextMenu.add(paramContextMenuInfo.position, 1, 1, getString(2131763690));
        }
      }
      catch (Exception paramView)
      {
        Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
        continue;
      }
      paramContextMenu.add(paramContextMenuInfo.position, 0, 0, getString(2131755778));
      AppMethodBeat.o(98894);
      return;
      if (!Util.isNullOrNil(paramView.MYQ))
      {
        paramView = paramView.MYQ;
      }
      else
      {
        paramView = paramView.MKC;
        continue;
        paramContextMenu.add(paramContextMenuInfo.position, 2, 1, getString(2131763689));
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(98890);
    Log.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
    this.sGB = super.getActivityBrowseTimeMs();
    if (com.tencent.mm.plugin.sns.model.aj.faT().ctM() > 0) {
      com.tencent.mm.plugin.sns.model.aj.faT().ctN();
    }
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(210, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(683, this);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.b(218, this);
    com.tencent.mm.plugin.sns.model.aj.faT().remove(this.EGa);
    this.EFR.ebf();
    com.tencent.mm.plugin.sns.model.aj.faL().aI(this);
    if (this.EFW != null)
    {
      this.EFW.dismiss();
      this.EFW = null;
    }
    long l = Util.currentTicks();
    int k = 0;
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject2 = this.EGf.values().iterator();
    int i = 0;
    Object localObject1;
    int m;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (com.tencent.mm.plugin.sns.storage.h)((Iterator)localObject2).next();
      if (localObject1 == null) {
        break label682;
      }
      if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isRead == 1)
      {
        m = 1;
        label206:
        if (m != 0) {
          break label679;
        }
        if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type != 1) {
          break label313;
        }
        i += 1;
        label224:
        m = 0;
        if (this.EGg.containsKey(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Emk))) {
          m = ((Integer)this.EGg.get(Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Emk))).intValue();
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
      if (((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type == 2)
      {
        j += 1;
        break label224;
        label329:
        if (m == 0)
        {
          localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d}", new Object[] { b((com.tencent.mm.plugin.sns.storage.h)localObject1), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Emk), ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker, Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence) });
          break label278;
        }
        localObject1 = String.format("{\"fid\":%s;\"cid\":%d;\"usr\":\"%s\";\"type\":%d;\"ig\":%d;\"click\":%d}", new Object[] { b((com.tencent.mm.plugin.sns.storage.h)localObject1), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).Emk), ((com.tencent.mm.plugin.sns.storage.h)localObject1).field_talker, Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_type), Integer.valueOf(((com.tencent.mm.plugin.sns.storage.h)localObject1).field_isSilence), Integer.valueOf(m) });
        break label278;
        label471:
        localStringBuffer.append((String)localObject1);
        continue;
        localObject1 = new ip();
        localObject2 = ((ip)localObject1).rr(this.EGc);
        ((ip)localObject2).eDV = this.fromScene;
        ((ip)localObject2).eqw = this.sGB;
        ((ip)localObject1).eww = this.EGd;
        ((ip)localObject1).ePm = this.EGe;
        ((ip)localObject1).ePl = j;
        ((ip)localObject1).ePk = i;
        ((ip)localObject1).ePo = ((ip)localObject1).x("BrowseJson", "[" + localStringBuffer.toString() + "]", true);
        ((ip)localObject1).bfK();
        this.EGf.clear();
        this.EGg.clear();
        Log.i("MicroMsg.SnsMsgUI", "reportBrowseMsgListInfo debugLog [%d] cost[%d]", new Object[] { Integer.valueOf(k), Long.valueOf(Util.ticksToNow(l)) });
        Log.d("MicroMsg.SnsMsgUI", "rpt %s", new Object[] { ((ip)localObject1).abW() });
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
    WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.gsi);
    this.gsi = 0;
    com.tencent.mm.plugin.sns.model.aj.faJ().b(this);
    super.onPause();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = Math.max(0L, localc.dcx - this.hlB);
      }
    }
    if (Util.nowSecond() > this.iTC) {}
    for (long l = Util.nowSecond() - this.iTC;; l = 1L)
    {
      this.iTC = l;
      WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.hlB, this.iTC);
      this.hlB = 0L;
      this.iTC = 0L;
      AppMethodBeat.o(98892);
      return;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(98891);
    this.iTC = Util.nowSecond();
    if ((com.tencent.matrix.b.isInstalled()) && (com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class) != null))
    {
      com.tencent.matrix.trace.f.c localc = ((com.tencent.matrix.trace.a)com.tencent.matrix.b.RG().Y(com.tencent.matrix.trace.a.class)).daF;
      if (localc != null) {
        this.hlB = localc.dcx;
      }
    }
    com.tencent.mm.plugin.sns.model.aj.faJ().a(this);
    super.onResume();
    AppMethodBeat.o(98891);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(98898);
    Log.d("MicroMsg.SnsMsgUI", "onSceneEnd:%s errtype:%s errcode:%s", new Object[] { paramq, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramq instanceof com.tencent.mm.plugin.sns.model.r))
    {
      if (this.EFX != null)
      {
        this.EFX.dismiss();
        this.EFX = null;
      }
      if (paramq != null)
      {
        paramString = (com.tencent.mm.plugin.sns.model.r)paramq;
        if (!paramString.DIr) {
          break label181;
        }
        paramString = ((ead)paramString.rr.iLL.iLR).MZy;
        if ((paramString != null) && (paramString.Id != 0L)) {
          break label155;
        }
        com.tencent.mm.ui.base.h.n(this, 2131766143, 2131755998);
      }
    }
    while (paramq.getType() == 218) {
      if (((com.tencent.mm.plugin.sns.model.s)paramq).type != 12)
      {
        AppMethodBeat.o(98898);
        return;
        label155:
        if (((com.tencent.mm.plugin.sns.model.r)paramq).DIs != null)
        {
          a(((com.tencent.mm.plugin.sns.model.r)paramq).DIs);
          continue;
          label181:
          if (!this.EFS)
          {
            this.EFS = true;
            this.handler.postDelayed(this.EGb, 500L);
          }
        }
      }
      else
      {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label269;
        }
        this.EFR.onNotifyChange(null, null);
        Toast.makeText(this, getString(2131763693), 0).show();
      }
    }
    for (;;)
    {
      if (this.EFW != null)
      {
        this.EFW.dismiss();
        this.EFW = null;
      }
      AppMethodBeat.o(98898);
      return;
      label269:
      Toast.makeText(this, getString(2131763692), 0).show();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends com.tencent.mm.ui.s<com.tencent.mm.plugin.sns.storage.h>
  {
    protected MMSlideDelView.f EGm;
    private int Eov;
    int gAZ;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb;
    int qdp;
    private Set<MMSlideDelView> ywx;
    
    public a(Context paramContext, com.tencent.mm.plugin.sns.storage.h paramh)
    {
      super(paramh);
      AppMethodBeat.i(98880);
      this.ywx = new HashSet();
      this.plb = new MMSlideDelView.d()
      {
        public final void a(MMSlideDelView paramAnonymousMMSlideDelView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(98874);
          if (paramAnonymousBoolean)
          {
            ywx.add(paramAnonymousMMSlideDelView);
            AppMethodBeat.o(98874);
            return;
          }
          ywx.remove(paramAnonymousMMSlideDelView);
          AppMethodBeat.o(98874);
        }
        
        public final boolean ebn()
        {
          AppMethodBeat.i(98875);
          if (ywx.size() > 0)
          {
            AppMethodBeat.o(98875);
            return true;
          }
          AppMethodBeat.o(98875);
          return false;
        }
        
        public final void ebo()
        {
          AppMethodBeat.i(98876);
          Iterator localIterator = ywx.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.gLa();
            }
          }
          ywx.clear();
          AppMethodBeat.o(98876);
        }
        
        public final void ebp()
        {
          AppMethodBeat.i(98877);
          Iterator localIterator = ywx.iterator();
          while (localIterator.hasNext())
          {
            MMSlideDelView localMMSlideDelView = (MMSlideDelView)localIterator.next();
            if (localMMSlideDelView != null) {
              localMMSlideDelView.gKZ();
            }
          }
          ywx.clear();
          AppMethodBeat.o(98877);
        }
      };
      this.Eov = at.fromDPToPix(paramContext, 14);
      this.qdp = 10;
      this.gAZ = this.qdp;
      AppMethodBeat.o(98880);
    }
    
    private static int a(int paramInt, MMImageView paramMMImageView)
    {
      int j = 2131689587;
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
        i = 2131689567;
        continue;
        i = 2131689584;
        continue;
        i = 2131689565;
        continue;
        i = 2131230967;
        continue;
        i = 2131230967;
        continue;
        paramMMImageView.setImageDrawable(null);
        i = -1;
        continue;
        paramMMImageView.setImageDrawable(null);
        i = -1;
      }
    }
    
    public final void anp()
    {
      AppMethodBeat.i(98884);
      if ((com.tencent.mm.plugin.sns.model.aj.faT().ctM() > 0) && (!SnsMsgUI.o(SnsMsgUI.this))) {
        setCursor(com.tencent.mm.plugin.sns.model.aj.faT().feG());
      }
      for (;;)
      {
        notifyDataSetChanged();
        AppMethodBeat.o(98884);
        return;
        this.gAZ = com.tencent.mm.plugin.sns.model.aj.faT().feH();
        setCursor(com.tencent.mm.plugin.sns.model.aj.faT().Zq(this.qdp));
      }
    }
    
    public final void anq()
    {
      AppMethodBeat.i(98882);
      ebf();
      anp();
      AppMethodBeat.o(98882);
    }
    
    public final void b(MMSlideDelView.f paramf)
    {
      this.EGm = paramf;
    }
    
    public final boolean cwg()
    {
      return this.qdp >= this.gAZ;
    }
    
    public final int cwh()
    {
      AppMethodBeat.i(98885);
      if (cwg())
      {
        if (SnsMsgUI.g(SnsMsgUI.this).getParent() != null) {
          SnsMsgUI.b(SnsMsgUI.this).removeFooterView(SnsMsgUI.g(SnsMsgUI.this));
        }
        AppMethodBeat.o(98885);
        return 0;
      }
      this.qdp += 10;
      if (this.qdp <= this.gAZ)
      {
        AppMethodBeat.o(98885);
        return 10;
      }
      this.qdp = this.gAZ;
      int i = this.gAZ;
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
        if (!SnsMsgUI.p(SnsMsgUI.this).containsKey(Integer.valueOf(localh.Emk))) {
          SnsMsgUI.p(SnsMsgUI.this).put(Integer.valueOf(localh.Emk), localh.feE());
        }
      }
      else
      {
        if ((paramView != null) && ((paramView.getTag() instanceof a))) {
          break label1613;
        }
        localObject2 = (MMSlideDelView)aa.jQ(this.context).inflate(2131493215, null);
        paramView = aa.jQ(this.context).inflate(2131496465, null);
        locala = new a();
        locala.EGo = ((SnsAvatarImageView)paramView.findViewById(2131308159));
        locala.EGo.setWeakContext(this.context);
        locala.kib = ((TextView)paramView.findViewById(2131308167));
        locala.EGr = ((TextView)paramView.findViewById(2131308161));
        locala.EGq = ((ImageView)paramView.findViewById(2131308165));
        locala.timeTv = ((TextView)paramView.findViewById(2131308168));
        locala.EGs = ((MMImageView)paramView.findViewById(2131308163));
        locala.EGp = ((TextView)paramView.findViewById(2131308169));
        locala.EGs.setOnClickListener(SnsMsgUI.q(SnsMsgUI.this));
        locala.plg = ((MMSlideDelView)localObject2).findViewById(2131307923);
        locala.plh = ((TextView)((MMSlideDelView)localObject2).findViewById(2131307925));
        locala.EGt = ((ImageView)paramView.findViewById(2131308204));
        locala.EGu = ((EmojiStatusView)paramView.findViewById(2131308160));
        ((MMSlideDelView)localObject2).setView(paramView);
        ((MMSlideDelView)localObject2).setPerformItemClickListener(this.pkY);
        ((MMSlideDelView)localObject2).setGetViewPositionCallback(this.pkZ);
        ((MMSlideDelView)localObject2).setItemStatusCallBack(this.plb);
        ((MMSlideDelView)localObject2).setEnable(false);
        ((View)localObject2).setTag(locala);
        label357:
        locala.EGs.setTag(null);
        locala.ece = localh.field_snsID;
        locala.plg.setTag(Integer.valueOf(localh.Emk));
        locala.plg.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(98878);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            Log.v("MicroMsg.SnsMsgUI", "on delView clicked");
            SnsMsgUI.a.this.plb.ebp();
            if (SnsMsgUI.a.this.EGm != null) {
              SnsMsgUI.a.this.EGm.cZ(paramAnonymousView.getTag());
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
          localdzi = (dzi)new dzi().parseFrom(localh.field_curActionBuf);
        }
        catch (Exception paramView)
        {
          dzi localdzi;
          final SnsInfo localSnsInfo;
          Object localObject3;
          label1613:
          Log.printErrStackTrace("MicroMsg.SnsMsgUI", paramView, "", new Object[0]);
          continue;
          Log.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
          continue;
          paramViewGroup = localdzi.MKC;
          continue;
          if (i == 0) {
            continue;
          }
          Object localObject1 = com.tencent.mm.cb.a.m(this.context, 2131101131);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.kib.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, j, 33);
          paramViewGroup.setSpan(((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).f(this.context, ((ax)localObject3).field_openImAppid, this.Eov), j, paramViewGroup.length(), 33);
          continue;
          localObject1 = com.tencent.mm.cb.a.m(this.context, 2131101131);
          paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.kib.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
          continue;
          paramViewGroup = com.tencent.mm.cb.a.l(this.context, 2131234408);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, paramViewGroup, null);
          continue;
          paramViewGroup = com.tencent.mm.cb.a.l(this.context, 2131234409);
          continue;
          paramViewGroup = com.tencent.mm.cb.a.l(this.context, 2131234407);
          continue;
          paramViewGroup = com.tencent.mm.cb.a.l(this.context, 2131234405);
          continue;
          paramViewGroup = com.tencent.mm.cb.a.l(this.context, 2131234406);
          continue;
          ((TextView)localObject1).setTag(null);
          continue;
          ((TextView)localObject1).setTextColor(SnsMsgUI.this.getResources().getColor(2131100904));
          ((TextView)localObject1).setBackgroundDrawable(null);
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          ((TextView)localObject1).setText("");
          ((TextView)localObject1).setCompoundDrawablePadding(0);
          switch (localdzi.oUv)
          {
          case 1: 
          case 5: 
            paramViewGroup = com.tencent.mm.plugin.sns.model.aj.faO().JJ(localh.field_snsID);
            if ((paramViewGroup == null) || (paramViewGroup.field_type != 7)) {
              continue;
            }
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131766110));
            continue;
            paramView = ar.m(this.context, 2131690343, this.context.getResources().getColor(2131099783));
            if ((paramViewGroup == null) || (paramViewGroup.getTypeFlag() != 21)) {
              continue;
            }
            paramView.setColorFilter(SnsMsgUI.this.getResources().getColor(2131101143), PorterDuff.Mode.SRC_ATOP);
            paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
            paramViewGroup = new SpannableString(" ");
            paramViewGroup.setSpan(new ImageSpan(paramView), 0, 1, 18);
            ((TextView)localObject1).setText(paramViewGroup);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131766053));
            continue;
            paramView.clearColorFilter();
            break;
          case 2: 
          case 3: 
            localObject4 = Util.nullAsNil(localdzi.iAc);
            localObject5 = new SpannableStringBuilder();
            localAdSnsInfo = com.tencent.mm.plugin.sns.model.aj.faR().JE(localh.field_snsID);
            localObject6 = com.tencent.mm.cb.a.m(this.context, 2131101131);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(localdzi.MYX, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.g.aAi();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131766144)).append(paramView.arJ()).append(": ");
            paramViewGroup[0] = this.context.getString(2131766144).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.arJ().length() + i);
            ((SpannableStringBuilder)localObject5).append((CharSequence)localObject4).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localdzi, (SpannableStringBuilder)localObject5, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, (CharSequence)localObject5, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject5).append(this.context.getString(2131766145)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(2131766145).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 7: 
            ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(ar.m(this.context, 2131690343, this.context.getResources().getColor(2131099783)), null, null, null);
            ((TextView)localObject1).setContentDescription(SnsMsgUI.this.getContext().getString(2131766053));
            break;
          case 8: 
            localObject4 = new SpannableStringBuilder();
            localObject5 = Util.nullAsNil(localdzi.iAc);
            localAdSnsInfo = com.tencent.mm.plugin.sns.model.aj.faR().JE(localh.field_snsID);
            localObject6 = com.tencent.mm.cb.a.m(this.context, 2131101131);
            localObject6 = new TextAppearanceSpan(null, 1, (int)((TextView)localObject1).getTextSize(), (ColorStateList)localObject6, (ColorStateList)localObject6);
            if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(localdzi.MYX, 1)) {
              continue;
            }
            if (localAdSnsInfo == null) {
              continue;
            }
            com.tencent.mm.kernel.g.aAi();
            paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjJ(localAdSnsInfo.field_userName);
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131766144)).append(paramView.arJ()).append(": ");
            paramViewGroup[0] = this.context.getString(2131766144).length();
            i = paramViewGroup[0];
            paramViewGroup[1] = (paramView.arJ().length() + i);
            ((SpannableStringBuilder)localObject4).append((CharSequence)localObject5).append(" ");
            SnsMsgUI.a((EmojiStatusView)localObject3, localdzi, (SpannableStringBuilder)localObject4, (TextView)localObject1);
            paramView = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, (CharSequence)localObject4, ((TextView)localObject1).getTextSize());
            if ((paramViewGroup[0] < 0) || (paramViewGroup[1] <= paramViewGroup[0])) {
              continue;
            }
            paramView.setSpan(localObject6, paramViewGroup[0], paramViewGroup[1], 33);
            ((TextView)localObject1).setText(paramView);
            continue;
            if (Util.isNullOrNil(paramView)) {
              continue;
            }
            ((SpannableStringBuilder)localObject4).append(this.context.getString(2131766145)).append(paramView).append(": ");
            paramViewGroup[0] = this.context.getString(2131766145).length();
            paramViewGroup[1] = (paramViewGroup[0] + paramView.length());
            break;
          case 4: 
            ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131766278));
            break;
          case 16: 
            paramView = "" + "[" + SnsMsgUI.this.getString(2131765939) + "]";
            paramView = paramView + " " + Util.nullAsNil(localdzi.iAc);
            ((TextView)localObject1).setText(com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, paramView, ((TextView)localObject1).getTextSize()));
            break;
          case 14: 
            paramView = new cbd();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localdzi.MYW);
            try
            {
              paramView.parseFrom(com.tencent.mm.platformtools.z.a(localdzi.MYW));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramView.eht);
              paramViewGroup = SnsMsgUI.r(SnsMsgUI.this).Kn(localdzi.MKC);
              ((TextView)localObject1).setText(SnsMsgUI.this.getString(2131762565, new Object[] { paramViewGroup.arJ(), Util.formatMoney2f(paramView.eht / 100.0D) }));
            }
            catch (Exception paramViewGroup)
            {
              Log.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + paramViewGroup.getMessage());
              continue;
            }
          case 13: 
            paramViewGroup = new cbd();
            Log.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + localdzi.MYW);
            try
            {
              paramViewGroup.parseFrom(com.tencent.mm.platformtools.z.a(localdzi.MYW));
              Log.i("MicroMsg.SnsMsgUI", "hbbuffer  " + paramViewGroup.eht);
              SnsMsgUI.r(SnsMsgUI.this).Kn(localdzi.MKC);
              paramView = null;
              if (paramViewGroup.eht == 0L)
              {
                SnsMsgUI.b(SnsMsgUI.this, true);
                paramViewGroup = new SpannableString(SnsMsgUI.this.getString(2131762568));
                if (paramView != null)
                {
                  paramView.setBounds(0, 0, paramView.getIntrinsicWidth(), paramView.getIntrinsicHeight());
                  localObject3 = new com.tencent.mm.ui.widget.a(paramView);
                  ((com.tencent.mm.ui.widget.a)localObject3).QBM = ((int)((paramView.getIntrinsicHeight() - ((TextView)localObject1).getTextSize() + com.tencent.mm.cb.a.fromDPToPix(SnsMsgUI.this, 2)) / 2.0F));
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
              paramViewGroup = new SpannableString(" " + SnsMsgUI.this.getString(2131762567, new Object[] { Util.formatMoney2f(paramViewGroup.eht / 100.0D) }));
              paramView = SnsMsgUI.this.getResources().getDrawable(2131230932);
              continue;
            }
            paramView = com.tencent.mm.plugin.sns.model.aj.faO().JJ(localh.field_snsID);
            continue;
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
            locala.EGs.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((bch)paramView.mediaList.get(0)).thumbUrl, locala.EGs);
            locala.EGs.setVisibility(0);
            if (paramView.vXJ != 4) {
              continue;
            }
            locala.EGt.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.LoU != 36) {
              continue;
            }
            paramView = paramView.getTimeLine().ContentObj.Lpd;
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
            locala.EGs.setTag(paramViewGroup);
            if (Util.isNullOrNil(paramView.mediaList)) {
              continue;
            }
            if (Util.isNullOrNil(((cok)paramView.mediaList.get(0)).coverUrl)) {
              continue;
            }
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)paramView.mediaList.get(0)).coverUrl, locala.EGs);
            locala.EGs.setVisibility(0);
            locala.EGt.setVisibility(0);
            continue;
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(((cok)paramView.mediaList.get(0)).thumbUrl, locala.EGs);
            continue;
            if ((paramView.getTimeLine().ContentObj.LoU != 29) && (paramView.getTimeLine().ContentObj.LoU != 37)) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.EGs);
            if (paramView.getTimeLine().ContentObj.LoZ == null) {
              continue;
            }
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
            locala.EGs.setTag(paramViewGroup);
            paramViewGroup = new cnb();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.LoZ.iconUrl;
            paramViewGroup.Msz = paramView.getTimeLine().ContentObj.LoZ.iconUrl;
            paramViewGroup.oUv = 2;
            paramViewGroup.MsA = 1;
            paramViewGroup.MsB = new cnd();
            paramViewGroup.Mcw = 1;
            paramViewGroup.MsB.Mto = 0.0F;
            paramViewGroup.MsB.Mtp = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            com.tencent.mm.plugin.sns.model.aj.faL().a(paramViewGroup, locala.EGs, paramInt, SnsMsgUI.this.hashCode(), bp.Oqr);
            locala.EGs.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.LoU != 38) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.EGs);
            if (paramView.getTimeLine().ContentObj.Lpb == null) {
              continue;
            }
            paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
            com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
            locala.EGs.setTag(paramViewGroup);
            paramViewGroup = new cnb();
            localObject1 = (String)paramView.getTimeLine().ContentObj.Lpb.LLt.get(0);
            paramView = (String)paramView.getTimeLine().ContentObj.Lpb.LLu.get(0);
            paramViewGroup.Url = ((String)localObject1 + paramView);
            paramViewGroup.Msz = paramViewGroup.Url;
            paramViewGroup.oUv = 2;
            paramViewGroup.MsA = 1;
            paramViewGroup.MsB = new cnd();
            paramViewGroup.Mcw = 1;
            paramViewGroup.MsB.Mto = 0.0F;
            paramViewGroup.MsB.Mtp = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            com.tencent.mm.plugin.sns.model.aj.faL().a(paramViewGroup, locala.EGs, paramInt, SnsMsgUI.this.hashCode(), bp.Oqr);
            locala.EGs.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.LoU != 33) {
              continue;
            }
            paramInt = a(paramView.field_type, locala.EGs);
            if (paramView.getTimeLine().ContentObj.Lpa == null) {
              continue;
            }
            paramViewGroup = new cnb();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Lpa.iAo;
            paramViewGroup.Msz = paramView.getTimeLine().ContentObj.Lpa.iAo;
            paramViewGroup.oUv = 2;
            paramViewGroup.MsA = 1;
            paramViewGroup.MsB = new cnd();
            paramViewGroup.Mcw = 1;
            paramViewGroup.MsB.Mto = 0.0F;
            paramViewGroup.MsB.Mtp = 0.0F;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            com.tencent.mm.plugin.sns.model.aj.faL().a(paramViewGroup, locala.EGs, paramInt, SnsMsgUI.this.hashCode(), bp.Oqr);
            locala.EGs.setVisibility(0);
            continue;
            if (paramView.getTimeLine().ContentObj.LoU != 34) {
              continue;
            }
            a(paramView.field_type, locala.EGs);
            if (paramView.getTimeLine().ContentObj.Lpc == null) {
              continue;
            }
            paramViewGroup = new cnb();
            paramViewGroup.Url = paramView.getTimeLine().ContentObj.Lpc.coverUrl;
            paramViewGroup.Msz = paramView.getTimeLine().ContentObj.Lpc.coverUrl;
            paramViewGroup.oUv = 2;
            paramViewGroup.MsA = 1;
            paramViewGroup.MsB = new cnd();
            paramViewGroup.Mcw = 1;
            paramViewGroup.MsB.Mto = paramView.getTimeLine().ContentObj.Lpc.width;
            paramViewGroup.MsB.Mtp = paramView.getTimeLine().ContentObj.Lpc.height;
            paramViewGroup.Id = localSnsInfo.getSnsId();
            ((com.tencent.mm.plugin.i.a.aj)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).loadImage(paramView.getTimeLine().ContentObj.Lpc.coverUrl, locala.EGs);
            paramView = locala.EGs;
            paramInt = 0;
            continue;
            if (paramView.getTimeLine().ContentObj.LoU != 39) {
              continue;
            }
            switch (paramView.getTimeLine().ContentObj.izD)
            {
            case 1: 
              paramInt = a(paramView.field_type, locala.EGs);
              if (paramView.getTimeLine().ContentObj.Lpe == null) {
                continue;
              }
              paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
              com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
              locala.EGs.setTag(paramViewGroup);
              paramViewGroup = new cnb();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.Lpe.iconUrl;
              paramViewGroup.Msz = paramView.getTimeLine().ContentObj.Lpe.iconUrl;
              paramViewGroup.oUv = 2;
              paramViewGroup.MsA = 1;
              paramViewGroup.MsB = new cnd();
              paramViewGroup.Mcw = 1;
              paramViewGroup.MsB.Mto = 0.0F;
              paramViewGroup.MsB.Mtp = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              com.tencent.mm.plugin.sns.model.aj.faL().a(paramViewGroup, locala.EGs, paramInt, SnsMsgUI.this.hashCode(), bp.Oqr);
              locala.EGs.setVisibility(0);
              break;
            case 100000000: 
              paramInt = a(paramView.field_type, locala.EGs);
              if (paramView.getTimeLine().ContentObj.LoZ == null) {
                continue;
              }
              paramViewGroup = new com.tencent.mm.plugin.sns.storage.h();
              com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramViewGroup);
              locala.EGs.setTag(paramViewGroup);
              paramViewGroup = new cnb();
              paramViewGroup.Url = paramView.getTimeLine().ContentObj.LoZ.iconUrl;
              paramViewGroup.Msz = paramView.getTimeLine().ContentObj.LoZ.iconUrl;
              paramViewGroup.oUv = 2;
              paramViewGroup.MsA = 1;
              paramViewGroup.MsB = new cnd();
              paramViewGroup.Mcw = 1;
              paramViewGroup.MsB.Mto = 0.0F;
              paramViewGroup.MsB.Mtp = 0.0F;
              paramViewGroup.Id = localSnsInfo.getSnsId();
              com.tencent.mm.plugin.sns.model.aj.faL().a(paramViewGroup, locala.EGs, paramInt, SnsMsgUI.this.hashCode(), bp.Oqr);
              locala.EGs.setVisibility(0);
              continue;
              if (paramView.getTypeFlag() != 2) {
                continue;
              }
              locala.EGs.setTag(null);
              locala.EGp.setVisibility(0);
              paramView = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, paramView.getTimeLine().ContentDesc, locala.EGp.getTextSize());
              locala.EGp.setText(paramView);
              continue;
              if (paramViewGroup.size() <= 0) {
                break label5586;
              }
              i = a(paramView.field_type, locala.EGs);
              com.tencent.mm.plugin.sns.model.aj.faL().a((cnb)paramViewGroup.get(0), locala.EGs, i, SnsMsgUI.this.hashCode(), bp.Oqr);
              if ((paramView.field_type != 15) && ((paramView.field_type != 27) || (paramViewGroup.size() <= 0) || (((cnb)paramViewGroup.get(0)).oUv != 6))) {
                continue;
              }
              locala.EGt.setVisibility(0);
              paramView = new com.tencent.mm.plugin.sns.storage.h();
              com.tencent.mm.plugin.sns.model.aj.faT().get(localh.systemRowid, paramView);
              locala.EGs.setTag(paramView);
              paramInt = 1;
              paramViewGroup = locala.EGs;
              paramView = paramViewGroup;
              if (paramInt == 0) {
                break label5609;
              }
              paramInt = 0;
              paramView = paramViewGroup;
              continue;
              paramViewGroup = new bc();
              paramViewGroup.dJX = paramView.getLocalid();
              paramViewGroup.index = 0;
              paramView = new ArrayList();
              paramView.add(locala.EGs);
              paramViewGroup.EDW = paramView;
              paramViewGroup.position = paramInt;
              locala.EGs.setTag(paramViewGroup);
              paramInt = 1;
              continue;
              if ((localdzi.oUv == 7) || (localdzi.oUv == 8)) {
                continue;
              }
              if (localdzi.oUv != 16) {
                continue;
              }
              if (!com.tencent.mm.plugin.sns.model.m.Jh(localh.field_snsID)) {
                continue;
              }
              if (localdzi.KHJ == null) {
                continue;
              }
              Log.i("MicroMsg.SnsMsgUI", "atFriend detail, aid64 %d, aid %d", new Object[] { Long.valueOf(localdzi.KHJ.MQh), Integer.valueOf(localdzi.KHJ.MQc) });
              paramView = new com.tencent.mm.plugin.sns.model.m(localh.field_snsID, localdzi.KHJ);
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(paramView, 0);
              continue;
              if (!com.tencent.mm.plugin.sns.model.r.Jk(localh.field_snsID)) {
                continue;
              }
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.r(localh.field_snsID), 0);
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
          paramViewGroup = ((dzi)new dzi().parseFrom(localh.field_refActionBuf)).MKC;
        }
        catch (Exception paramView)
        {
          paramView = "";
          continue;
          locala.EGo.setShowStoryHint(false);
          continue;
        }
        try
        {
          if (!Util.isNullOrNil(paramViewGroup)) {
            continue;
          }
          paramView = "";
          localSnsInfo = com.tencent.mm.plugin.sns.model.aj.faO().JJ(localh.field_snsID);
          if (localSnsInfo != null) {
            break label5597;
          }
          paramViewGroup = com.tencent.mm.plugin.sns.model.aj.faR().JE(localh.field_snsID);
          if (paramViewGroup == null) {
            break label5597;
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
        if (Util.isNullOrNil(localdzi.MKC)) {
          continue;
        }
        if (!com.tencent.mm.plugin.sns.ui.widget.e.a(locala.EGo, localSnsInfo, localdzi.MKC)) {
          com.tencent.mm.pluginsdk.ui.a.b.c(locala.EGo, localdzi.MKC);
        }
        paramViewGroup = localdzi.MKC;
        locala.EGo.fL(paramViewGroup, 6);
        if (Util.isEqual(SnsMsgUI.s(SnsMsgUI.this), paramViewGroup)) {
          continue;
        }
        localObject1 = locala.EGo;
        com.tencent.mm.kernel.g.aAi();
        ((SnsAvatarImageView)localObject1).setShowStoryHint(((com.tencent.mm.plugin.story.api.e)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(paramViewGroup));
        locala.EGo.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            int j = 0;
            AppMethodBeat.i(98879);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
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
                    paramAnonymousView = com.tencent.mm.plugin.sns.data.r.kb((String)localObject, localADInfo.uxInfo);
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
                  com.tencent.mm.plugin.sns.c.a.jRt.i((Intent)localObject, localSnsMsgUI);
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
                com.tencent.mm.plugin.sns.c.a.jRt.c(paramAnonymousView, SnsMsgUI.this);
                ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(paramViewGroup, 9L);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsMsgUI$SnsMsgAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(98879);
              return;
              label354:
              bool = false;
              break;
              label360:
              localObject = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, SnsMsgUI.this);
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
        localObject3 = SnsMsgUI.r(SnsMsgUI.this).Kn(localdzi.MKC);
        i = 0;
        if (Util.isNullOrNil(localdzi.MYQ)) {
          continue;
        }
        paramViewGroup = localdzi.MYQ;
        localObject1 = paramViewGroup;
        if (localObject3 == null) {
          break label5591;
        }
        if (!Util.isNullOrNil(((com.tencent.mm.contact.c)localObject3).arJ())) {
          paramViewGroup = ((com.tencent.mm.contact.c)localObject3).arJ();
        }
        localObject1 = paramViewGroup;
        if (!as.bjp(((ax)localObject3).field_username)) {
          break label5591;
        }
        localObject1 = paramViewGroup;
        if (!"3552365301".equals(((ax)localObject3).field_openImAppid)) {
          break label5591;
        }
        j = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, paramViewGroup, locala.kib.getTextSize()).length();
        localObject1 = paramViewGroup + " @" + ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(((ax)localObject3).field_openImAppid, ((ax)localObject3).field_descWordingId);
        i = 1;
        paramViewGroup = (ViewGroup)localObject1;
        if (com.tencent.mm.plugin.sns.ui.widget.e.b(localSnsInfo, localdzi.MKC)) {
          paramViewGroup = com.tencent.mm.plugin.sns.ui.widget.e.c(localSnsInfo.getAdXml(), (String)localObject1);
        }
        paramViewGroup = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, paramViewGroup, locala.kib.getTextSize());
        if ((localSnsInfo == null) || (localSnsInfo.getTypeFlag() != 21)) {
          continue;
        }
        localObject1 = com.tencent.mm.cb.a.m(this.context, 2131101139);
        paramViewGroup.setSpan(new TextAppearanceSpan(null, 0, (int)locala.kib.getTextSize(), (ColorStateList)localObject1, (ColorStateList)localObject1), 0, paramViewGroup.length(), 33);
        paramViewGroup = ((com.tencent.mm.plugin.textstatus.a.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).attachTextStatusSpanSync(localdzi.MKC, paramViewGroup, com.tencent.mm.plugin.textstatus.a.a.b.FXl, locala.kib.getTextSize());
        locala.kib.setText(paramViewGroup);
        paramViewGroup = localdzi.MKC;
        localObject1 = locala.kib;
        j = localdzi.xub;
        switch (localh.field_type)
        {
        case 6: 
          if ((i != 0) && (!SnsMsgUI.s(SnsMsgUI.this).equals(paramViewGroup))) {
            break label5639;
          }
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          localObject3 = locala.EGu;
          localObject1 = locala.EGr;
          ((EmojiStatusView)localObject3).setVisibility(8);
          ((TextView)localObject1).setVisibility(0);
          if ((Util.isNullOrNil(localdzi.MYY)) || (localdzi.MYY.get(0) == null)) {
            continue;
          }
          ((TextView)localObject1).setTag(((dzu)localdzi.MYY.get(0)).Md5);
          paramViewGroup = new int[2];
          if ((localh.field_commentflag & 0x1) <= 0) {
            break label5711;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          ((TextView)localObject1).setText(2131766140);
          ((TextView)localObject1).setBackgroundColor(SnsMsgUI.this.getResources().getColor(2131100212));
          ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          locala.timeTv.setText(bm.q(SnsMsgUI.this, localdzi.CreateTime * 1000L));
          paramView = null;
          if ((localdzi.oUv != 7) && (localdzi.oUv != 8) && (localdzi.oUv != 16)) {
            continue;
          }
          paramViewGroup = com.tencent.mm.plugin.sns.model.aj.faR().JE(localh.field_snsID);
          if (paramViewGroup == null) {
            break label5606;
          }
          paramView = paramViewGroup.convertToSnsInfo();
          break label5606;
          locala.EGs.setVisibility(8);
          locala.EGp.setVisibility(8);
          locala.EGt.setVisibility(8);
          locala.EGs.setImageBitmap(null);
          com.tencent.mm.plugin.sns.model.aj.faL().fi(locala.EGs);
          if ((paramView == null) || (paramView.getTimeLine() == null) || (paramView.getTimeLine().ContentObj == null)) {
            continue;
          }
          paramViewGroup = paramView.getTimeLine().ContentObj.LoV;
          if (paramView.getTimeLine().ContentObj.LoU != 28) {
            continue;
          }
          paramView = paramView.getTimeLine().ContentObj.dME;
          if (paramView.vXJ != 1) {
            continue;
          }
          locala.EGs.setTag(null);
          locala.EGp.setVisibility(0);
          paramView = com.tencent.mm.pluginsdk.ui.span.l.b(SnsMsgUI.this, paramView.desc, locala.EGp.getTextSize());
          locala.EGp.setText(paramView);
          paramView = locala.EGs;
          break label5609;
          paramView.setVisibility(paramInt);
          if ((locala.EGs.getVisibility() != 0) && (locala.EGt.getVisibility() != 0)) {
            continue;
          }
          paramInt = 1;
          paramView = ((View)localObject2).findViewById(2131308166);
          if (paramInt == 0) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          paramView = ((View)localObject2).findViewById(2131308209);
          if (localh.field_isSilence != 1) {
            continue;
          }
          paramInt = 0;
          paramView.setVisibility(paramInt);
          ((ImageView)((View)localObject2).findViewById(2131308209)).setImageDrawable(ar.m(this.context, 2131691512, this.context.getResources().getColor(2131100006)));
          AppMethodBeat.o(98886);
          return localObject2;
          ((com.tencent.mm.plugin.sns.storage.h)SnsMsgUI.p(SnsMsgUI.this).get(Integer.valueOf(localh.Emk))).field_isSilence = localh.field_isSilence;
          break label65;
          locala = (a)paramView.getTag();
          localObject2 = paramView;
          break label357;
          localObject1 = SnsMsgUI.r(SnsMsgUI.this).Kn(paramViewGroup);
          paramView = paramViewGroup;
          if (localObject1 != null) {
            if (Util.isEqual(((ax)localObject1).field_username, com.tencent.mm.plugin.sns.model.aj.fau())) {
              paramView = ((ax)localObject1).field_nickname;
            } else if (!Util.isNullOrNil(((com.tencent.mm.contact.c)localObject1).arJ())) {
              paramView = ((com.tencent.mm.contact.c)localObject1).arJ();
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
      this.pkZ = paramc;
    }
    
    public final void setPerformItemClickListener(MMSlideDelView.g paramg)
    {
      this.pkY = paramg;
    }
    
    final class a
    {
      SnsAvatarImageView EGo;
      TextView EGp;
      ImageView EGq;
      TextView EGr;
      MMImageView EGs;
      ImageView EGt;
      EmojiStatusView EGu;
      long ece;
      TextView kib;
      View plg;
      TextView plh;
      TextView timeTv;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI
 * JD-Core Version:    0.7.0.1
 */