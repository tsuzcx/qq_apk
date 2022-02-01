package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.b.g;
import com.tencent.mm.f.a.az;
import com.tencent.mm.f.a.em;
import com.tencent.mm.f.a.em.b;
import com.tencent.mm.f.a.ol;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.xb;
import com.tencent.mm.f.a.xp;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.scanner.ImageQBarDataBean;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.f.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

public final class y
  implements i
{
  private cvt JLl;
  private SnsInfo Jws;
  e KCH;
  private String KDA;
  private String KDD;
  private String KDE;
  private String KDF;
  private String KDG;
  private long KDH;
  ImageQBarDataBean KDJ;
  private boolean KDK;
  FlipView.b KDM;
  IListener KDP;
  SnsCmdList KEo;
  private final a KEp;
  private boolean KEq;
  private int KEr;
  boolean KEs;
  boolean KEt;
  private final String KEu;
  private List<ImageQBarDataBean> KEv;
  private String cY;
  final Context context;
  private int fromScene;
  private ScanCodeSheetItemLogic oxq;
  public int rWq;
  public com.tencent.mm.ui.base.s tipDialog;
  IListener wKS;
  
  public y(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(268137);
    this.KEo = new SnsCmdList();
    this.tipDialog = null;
    this.rWq = 0;
    this.KCH = null;
    this.KEr = 0;
    this.KEs = false;
    this.KEt = false;
    this.KDK = false;
    this.KEv = new ArrayList();
    this.KDJ = null;
    this.wKS = new IListener() {};
    this.KDP = new IListener() {};
    this.context = paramContext;
    this.fromScene = paramInt;
    this.KEp = parama;
    this.KEu = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.oxq = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(97895);
        if ((y.a(y.this) != null) && (y.a(y.this).isShowing()))
        {
          y.b(y.this);
          y.this.a(y.c(y.this), y.d(y.this), y.e(y.this));
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(268137);
  }
  
  private void a(final List<String> paramList, final List<Integer> paramList1, final SnsInfo paramSnsInfo, final cvt paramcvt, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if (this.KCH != null) {
      if (this.KDK) {
        this.KDK = false;
      }
    }
    for (;;)
    {
      this.KCH.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(97899);
          y.a(y.this).setFooterView(null);
          paramAnonymouso.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              y.a(y.this).setFooterView(y.a(y.this, paramSnsInfo));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymouso.d(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          paramAnonymouso.d(-1, y.f(y.this).getString(i.j.sns_del_sns));
          AppMethodBeat.o(97899);
        }
      };
      this.KCH.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          if (y.g(y.this) != null) {
            y.g(y.this).fTF();
          }
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          Log.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97902);
            return;
            if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
            {
              y.a(y.this, paramSnsInfo, paramcvt);
              AppMethodBeat.o(97902);
              return;
              y.b(y.this, paramSnsInfo, paramcvt);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = y.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.s(paramSnsInfo.field_snsId, 3);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(i.j.app_tip);
              paramAnonymousMenuItem.tipDialog = com.tencent.mm.ui.base.h.a(localContext, paramAnonymousMenuItem.context.getString(i.j.sns_setPrivateing_sns), true, new y.3(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.s)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = y.this;
              localObject = paramSnsInfo;
              if ((((SnsInfo)localObject).isWaitPost()) || (((SnsInfo)localObject).isDieItem()))
              {
                aj.fOI().agJ(((SnsInfo)localObject).localid);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.s(((SnsInfo)localObject).field_snsId, 2);
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(i.j.app_tip);
              paramAnonymousMenuItem.tipDialog = com.tencent.mm.ui.base.h.a(localContext, paramAnonymousMenuItem.context.getString(i.j.sns_setPrivateing_sns), true, new y.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.s)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
              {
                if (paramSnsInfo.field_type != 15)
                {
                  paramAnonymousMenuItem = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt);
                  if (com.tencent.mm.plugin.sns.data.t.aLV(paramAnonymousMenuItem) == 4)
                  {
                    localObject = com.tencent.mm.vfs.u.n(paramAnonymousMenuItem, false) + "_tmp";
                    com.tencent.mm.vfs.u.bBD(com.tencent.mm.vfs.u.bBT((String)localObject));
                    ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(com.tencent.mm.vfs.u.n(paramAnonymousMenuItem, false), (String)localObject);
                    com.tencent.mm.pluginsdk.ui.tools.u.n((String)localObject, y.f(y.this));
                    AppMethodBeat.o(97902);
                    return;
                  }
                  com.tencent.mm.pluginsdk.ui.tools.u.n(paramAnonymousMenuItem, y.f(y.this));
                  AppMethodBeat.o(97902);
                  return;
                }
                y.bbS(paramSnsInfo.getLocalid());
                AppMethodBeat.o(97902);
                return;
                if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
                {
                  if (paramSnsInfo.getTimeLine().ContentObj.Sqq == 1)
                  {
                    paramAnonymousMenuItem = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt);
                    y.this.bbR(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  y.bbT(paramSnsInfo.getLocalid());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramSnsInfo.getTimeLine().ContentObj.Sqr.size() > 1)
                  {
                    com.tencent.mm.ui.base.h.a(y.f(y.this), y.f(y.this).getString(i.j.sns_photos_del), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        y.this.V(y.7.this.KCK);
                        AppMethodBeat.o(97900);
                      }
                    }, null);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  com.tencent.mm.ui.base.h.a(y.f(y.this), y.f(y.this).getString(i.j.sns_photo_del), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(97901);
                      y.this.V(y.7.this.KCK);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(y.f(y.this)))
                  {
                    paramAnonymousMenuItem = new xp();
                    paramAnonymousMenuItem.fWz.mediaId = y.h(y.this);
                    EventCenter.instance.publish(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                    if (paramSnsInfo.getTimeLine().ContentObj.Sqq == 1)
                    {
                      paramAnonymousMenuItem = new com.tencent.mm.plugin.websearch.api.o();
                      paramAnonymousMenuItem.context = y.f(y.this);
                      paramAnonymousMenuItem.fAh = (aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt));
                      paramAnonymousMenuItem.PxI = y.d(y.this).field_userName;
                      paramAnonymousMenuItem.fLp = com.tencent.mm.plugin.sns.data.t.Qu(y.d(y.this).field_snsId);
                      paramAnonymousMenuItem.JVq = paramcvt;
                      paramAnonymousMenuItem.fyP = com.tencent.mm.plugin.sns.data.t.afF(y.i(y.this));
                      ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramAnonymousMenuItem);
                      AppMethodBeat.o(97902);
                      return;
                      if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(y.f(y.this)))
                      {
                        paramAnonymousMenuItem = new xb();
                        paramAnonymousMenuItem.fVY.requestType = com.tencent.mm.plugin.sns.data.t.afG(y.i(y.this));
                        paramAnonymousMenuItem.fVY.mediaId = y.h(y.this);
                        paramAnonymousMenuItem.fVY.fcC = paramSnsInfo.getUserName();
                        EventCenter.instance.publish(paramAnonymousMenuItem);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      };
      this.KCH.XbB = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          if (y.g(y.this) != null) {
            y.g(y.this).fTF();
          }
          az localaz = new az();
          localaz.fwJ.fwK = y.j(y.this);
          localaz.fwJ.filePath = y.k(y.this);
          EventCenter.instance.publish(localaz);
          y.l(y.this);
          y.m(y.this);
          y.n(y.this);
          y.o(y.this);
          y.a(y.this, null);
          y.p(y.this);
          y.q(y.this);
          y.r(y.this);
          y.s(y.this);
          y.t(y.this);
          AppMethodBeat.o(97903);
        }
      };
      this.KCH.eik();
      if (this.KDM != null) {
        this.KDM.hI(paramList1);
      }
      AppMethodBeat.o(97914);
      return;
      this.KCH = new e(this.context, 1, false);
    }
  }
  
  private void b(final List<String> paramList, final List<Integer> paramList1, final SnsInfo paramSnsInfo, final cvt paramcvt, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if (this.KCH != null) {
      if (this.KDK) {
        this.KDK = false;
      }
    }
    for (;;)
    {
      this.KCH.ODT = new q.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymouso)
        {
          AppMethodBeat.i(97904);
          y.a(y.this).setFooterView(null);
          paramAnonymouso.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              y.a(y.this).setFooterView(y.a(y.this, paramSnsInfo));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymouso.d(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          AppMethodBeat.o(97904);
        }
      };
      this.KCH.ODU = new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97905);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          Log.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97905);
            return;
            if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
            {
              y.a(y.this, paramSnsInfo, paramcvt);
              AppMethodBeat.o(97905);
              return;
              y.b(y.this, paramSnsInfo, paramcvt);
              AppMethodBeat.o(97905);
              return;
              if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
              {
                if (paramSnsInfo.getTimeLine().ContentObj.Sqq == 1)
                {
                  paramAnonymousMenuItem = aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt);
                  y.this.bbR(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                y.bbT(paramSnsInfo.getLocalid());
                AppMethodBeat.o(97905);
                return;
                if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
                {
                  if (paramSnsInfo.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.u.n(aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt), y.f(y.this));
                    AppMethodBeat.o(97905);
                    return;
                  }
                  y.bbS(paramSnsInfo.getLocalid());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = y.this;
                  long l = paramSnsInfo.field_snsId;
                  SnsInfo localSnsInfo = aj.fOI().Rd(l);
                  if ((l == 0L) || (localSnsInfo == null))
                  {
                    AppMethodBeat.o(97905);
                    return;
                  }
                  Intent localIntent = new Intent();
                  localIntent.putExtra("k_username", localSnsInfo.getUserName());
                  localIntent.putExtra("k_expose_msg_id", l);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("rawUrl", String.format(f.e.VRX, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.by.c.b(paramAnonymousMenuItem.context, "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(97905);
                  return;
                  if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(y.f(y.this)))
                  {
                    paramAnonymousMenuItem = new xp();
                    paramAnonymousMenuItem.fWz.mediaId = y.h(y.this);
                    EventCenter.instance.publish(paramAnonymousMenuItem);
                    AppMethodBeat.o(97905);
                    return;
                    if (paramSnsInfo.getTimeLine().ContentObj.Sqq == 1)
                    {
                      paramAnonymousMenuItem = new com.tencent.mm.plugin.websearch.api.o();
                      paramAnonymousMenuItem.context = y.f(y.this);
                      paramAnonymousMenuItem.fAh = (aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt));
                      paramAnonymousMenuItem.PxI = y.d(y.this).field_userName;
                      paramAnonymousMenuItem.fLp = com.tencent.mm.plugin.sns.data.t.Qu(y.d(y.this).field_snsId);
                      paramAnonymousMenuItem.JVq = paramcvt;
                      paramAnonymousMenuItem.fyP = com.tencent.mm.plugin.sns.data.t.afF(y.i(y.this));
                      ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramAnonymousMenuItem);
                      AppMethodBeat.o(97905);
                      return;
                      if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(y.f(y.this)))
                      {
                        paramAnonymousMenuItem = new xb();
                        paramAnonymousMenuItem.fVY.requestType = com.tencent.mm.plugin.sns.data.t.afG(y.i(y.this));
                        paramAnonymousMenuItem.fVY.mediaId = y.h(y.this);
                        paramAnonymousMenuItem.fVY.fcC = paramSnsInfo.getUserName();
                        EventCenter.instance.publish(paramAnonymousMenuItem);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      };
      this.KCH.XbB = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(240916);
          if (y.g(y.this) != null) {
            y.g(y.this).fTF();
          }
          az localaz = new az();
          localaz.fwJ.fwK = y.j(y.this);
          localaz.fwJ.filePath = y.k(y.this);
          EventCenter.instance.publish(localaz);
          y.l(y.this);
          y.m(y.this);
          y.n(y.this);
          y.o(y.this);
          y.a(y.this, null);
          y.p(y.this);
          y.q(y.this);
          y.r(y.this);
          y.s(y.this);
          y.t(y.this);
          AppMethodBeat.o(240916);
        }
      };
      this.KCH.eik();
      if (this.KDM != null) {
        this.KDM.hI(paramList1);
      }
      AppMethodBeat.o(97915);
      return;
      this.KCH = new e(this.context, 1, false);
    }
  }
  
  protected final void V(final SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97916);
    if ((paramSnsInfo.isWaitPost()) || (paramSnsInfo.isDieItem()))
    {
      aj.fOI().agJ(paramSnsInfo.localid);
      this.KEo.afA(paramSnsInfo.localid);
      AppMethodBeat.o(97916);
      return;
    }
    aj.fOH().QK(paramSnsInfo.field_snsId);
    paramSnsInfo = new com.tencent.mm.plugin.sns.model.s(paramSnsInfo.field_snsId, 1);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(paramSnsInfo, 0);
    Context localContext = this.context;
    this.context.getString(i.j.app_tip);
    this.tipDialog = com.tencent.mm.ui.base.h.a(localContext, this.context.getString(i.j.sns_deling_sns), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(97908);
        if (y.this.rWq != 0)
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.a(paramSnsInfo);
          y.this.rWq = 0;
        }
        AppMethodBeat.o(97908);
      }
    });
    AppMethodBeat.o(97916);
  }
  
  public final void a(boolean paramBoolean, SnsInfo paramSnsInfo, cvt paramcvt)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramSnsInfo, paramcvt, this.KEs, this.KEt, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, SnsInfo paramSnsInfo, cvt paramcvt, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(268141);
    this.KEq = paramBoolean1;
    this.Jws = paramSnsInfo;
    this.JLl = paramcvt;
    this.cY = paramcvt.Id;
    this.KEs = paramBoolean2;
    this.KEt = paramBoolean3;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject;
    ah localah;
    if (paramBoolean1)
    {
      if (paramSnsInfo == null)
      {
        AppMethodBeat.o(268141);
        return;
      }
      if (paramSnsInfo.getLocalPrivate() > 0)
      {
        if ((!Util.isNullOrNil(aj.fOo())) && (aj.fOo().equals(paramSnsInfo.getUserName())))
        {
          localArrayList1.add(this.context.getString(i.j.sns_set_open));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(i.j.sns_post_to));
        localArrayList2.add(Integer.valueOf(3));
        if (com.tencent.mm.by.c.blP("favorite"))
        {
          localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramSnsInfo.field_type != 15) && (paramSnsInfo.field_type != 5)) {
          break label741;
        }
        localArrayList1.add(this.context.getString(i.j.save_video_to_local));
        localArrayList2.add(Integer.valueOf(2));
      }
      for (;;)
      {
        localObject = new em();
        ((em)localObject).fAp.fAg = paramSnsInfo.getLocalid();
        EventCenter.instance.publish((IEvent)localObject);
        if (((em)localObject).fAq.fzO)
        {
          localArrayList1.add(this.context.getString(i.j.app_open));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.KDJ != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (paramSnsInfo.field_type == 1) && (com.tencent.mm.plugin.sns.data.t.afE(this.fromScene)))
        {
          localArrayList1.add(this.context.getString(i.j.find_friends_search));
          localArrayList2.add(Integer.valueOf(10));
          if (!this.KDK)
          {
            localObject = new ah();
            localah = ((ah)localObject).iX("").iY(com.tencent.mm.plugin.sns.data.t.Qu(this.Jws.field_snsId));
            localah.giu = com.tencent.mm.plugin.sns.data.t.afF(this.fromScene);
            localah.geN = 1;
            localah.ggl = 81;
            ((ah)localObject).iZ("");
            ((ah)localObject).ja("");
            ((ah)localObject).jb(g.getMD5(aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt)));
            ((ah)localObject).giA = System.currentTimeMillis();
            ((ah)localObject).bpa();
            ar.a((com.tencent.mm.plugin.report.a)localObject);
          }
        }
        a(localArrayList1, localArrayList2, paramSnsInfo, paramcvt, paramInt);
        if (true == paramBoolean4)
        {
          com.tencent.mm.kernel.h.aHH();
          if (com.tencent.mm.kernel.h.aHF().kcd.bih() != 0)
          {
            paramSnsInfo = new rx();
            paramcvt = aq.kD(aj.getAccSnsPath(), this.cY) + com.tencent.mm.plugin.sns.data.t.k(paramcvt);
            paramSnsInfo.fRg.filePath = paramcvt;
            this.KDH = System.currentTimeMillis();
            paramSnsInfo.fRg.fwK = this.KDH;
            this.KDA = paramcvt;
            EventCenter.instance.publish(paramSnsInfo);
          }
        }
        AppMethodBeat.o(268141);
        return;
        localArrayList1.add(this.context.getString(i.j.sns_set_private));
        localArrayList2.add(Integer.valueOf(1));
        localArrayList1.add(this.context.getString(i.j.sns_post_to));
        localArrayList2.add(Integer.valueOf(3));
        break;
        label741:
        if (paramSnsInfo.field_type == 1)
        {
          localArrayList1.add(this.context.getString(i.j.save_img_to_local));
          localArrayList2.add(Integer.valueOf(2));
          if (paramBoolean2)
          {
            localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_photo_trans));
            localArrayList2.add(Integer.valueOf(9));
          }
          if (paramBoolean3)
          {
            localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_image_ocr));
            localArrayList2.add(Integer.valueOf(11));
          }
        }
        else
        {
          localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
          localArrayList2.add(Integer.valueOf(2));
        }
      }
    }
    paramSnsInfo.getTimeLine();
    localArrayList1.add(this.context.getString(i.j.sns_post_to));
    localArrayList2.add(Integer.valueOf(3));
    if (com.tencent.mm.by.c.blP("favorite"))
    {
      localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
      localArrayList2.add(Integer.valueOf(6));
    }
    if ((paramSnsInfo.field_type == 15) || (paramSnsInfo.field_type == 5))
    {
      localArrayList1.add(this.context.getString(i.j.save_video_to_local));
      localArrayList2.add(Integer.valueOf(2));
    }
    for (;;)
    {
      localObject = new em();
      ((em)localObject).fAp.fAg = paramSnsInfo.getLocalid();
      EventCenter.instance.publish((IEvent)localObject);
      if (((em)localObject).fAq.fzO)
      {
        localArrayList1.add(this.context.getString(i.j.app_open));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.KDJ != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (paramSnsInfo.field_type == 1) && (com.tencent.mm.plugin.sns.data.t.afE(this.fromScene)))
      {
        localArrayList1.add(this.context.getString(i.j.find_friends_search));
        localArrayList2.add(Integer.valueOf(10));
        localObject = new ah();
        localah = ((ah)localObject).iX("").iY(com.tencent.mm.plugin.sns.data.t.Qu(this.Jws.field_snsId));
        localah.giu = com.tencent.mm.plugin.sns.data.t.afF(this.fromScene);
        localah.geN = 1;
        localah.ggl = 81;
        ((ah)localObject).iZ("");
        ((ah)localObject).ja("");
        ((ah)localObject).jb(g.getMD5(aq.kD(aj.getAccSnsPath(), paramcvt.Id) + com.tencent.mm.plugin.sns.data.t.k(paramcvt)));
        ((ah)localObject).giA = System.currentTimeMillis();
        ((ah)localObject).bpa();
        ar.a((com.tencent.mm.plugin.report.a)localObject);
      }
      b(localArrayList1, localArrayList2, paramSnsInfo, paramcvt, paramInt);
      break;
      if (paramSnsInfo.field_type == 1)
      {
        localArrayList1.add(this.context.getString(i.j.save_img_to_local));
        localArrayList2.add(Integer.valueOf(2));
        if (paramBoolean2)
        {
          localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_photo_trans));
          localArrayList2.add(Integer.valueOf(9));
        }
        if (paramBoolean3)
        {
          localArrayList1.add(this.context.getString(i.j.chatting_image_long_click_image_ocr));
          localArrayList2.add(Integer.valueOf(11));
        }
      }
      else
      {
        localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
        localArrayList2.add(Integer.valueOf(2));
      }
    }
  }
  
  public final void agL(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.KEo.afA(paramInt);
    AppMethodBeat.o(97909);
  }
  
  protected final void bbR(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.mIG.j(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void fTG()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.KEo);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
    AppMethodBeat.o(97911);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(97918);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramq == null))
    {
      AppMethodBeat.o(97918);
      return;
    }
    Log.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (com.tencent.mm.plugin.sns.model.s)paramq;
    switch (paramString.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97918);
      return;
      this.KEo.afA(paramString.fWh);
      this.KEp.gl(com.tencent.mm.plugin.sns.storage.y.bt("sns_table_", paramString.fWh), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.KEo.afB(paramString.fWh);
      this.KEp.gl("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.KEp.gl("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.KEo.afB(paramString.fWh);
      this.KEp.gl(com.tencent.mm.plugin.sns.storage.y.bt("sns_table_", paramString.fWh), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fTH();
    
    public abstract void gl(String paramString, int paramInt);
    
    public abstract void gm(String paramString, int paramInt);
    
    public abstract void lm(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.y
 * JD-Core Version:    0.7.0.1
 */