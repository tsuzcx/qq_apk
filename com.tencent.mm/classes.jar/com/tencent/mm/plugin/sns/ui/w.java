package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.ef.b;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.websearch.api.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.e.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

public final class w
  implements i
{
  SnsInfo DqO;
  cnb DzV;
  e Epy;
  SnsCmdList EqW;
  private final a EqX;
  boolean EqY;
  int EqZ;
  String Eqk;
  String Eqn;
  String Eqo;
  String Eqp;
  String Eqq;
  String Eqr;
  long Eqs;
  boolean Equ;
  FlipView.b Eqw;
  IListener Eqy;
  boolean Era;
  boolean Erb;
  private final String Erc;
  String Mc;
  final Context context;
  int dFL;
  int dFM;
  int fromScene;
  ScanCodeSheetItemLogic mHu;
  public int oUs;
  IListener teF;
  public com.tencent.mm.ui.base.q tipDialog;
  
  public w(Context paramContext, a parama, int paramInt)
  {
    AppMethodBeat.i(203256);
    this.EqW = new SnsCmdList();
    this.tipDialog = null;
    this.oUs = 0;
    this.Epy = null;
    this.EqZ = 0;
    this.Era = false;
    this.Erb = false;
    this.Equ = false;
    this.teF = new IListener() {};
    this.Eqy = new IListener() {};
    this.context = paramContext;
    this.fromScene = paramInt;
    this.EqX = parama;
    this.Erc = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.mHu = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(97895);
        if ((w.this.Epy != null) && (w.this.Epy.isShowing()))
        {
          w.this.Equ = true;
          w.this.a(w.this.EqY, w.this.DqO, w.this.DzV);
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(203256);
  }
  
  private void a(List<String> paramList, List<Integer> paramList1, final SnsInfo paramSnsInfo, final cnb paramcnb, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if (this.Epy != null) {
      if (this.Equ) {
        this.Equ = false;
      }
    }
    for (;;)
    {
      this.Epy.HLX = new w.6(this, paramList, paramList1, paramSnsInfo);
      this.Epy.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          if (w.this.Eqw != null) {
            w.this.Eqw.ffI();
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
              w.a(w.this, paramSnsInfo, paramcnb);
              AppMethodBeat.o(97902);
              return;
              w.b(w.this, paramSnsInfo, paramcnb);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = w.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.s(paramSnsInfo.field_snsId, 3);
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755998);
              paramAnonymousMenuItem.tipDialog = h.a(localContext, paramAnonymousMenuItem.context.getString(2131766198), true, new w.3(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.s)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = w.this;
              localObject = paramSnsInfo;
              if ((((SnsInfo)localObject).isWaitPost()) || (((SnsInfo)localObject).isDieItem()))
              {
                aj.faO().Zs(((SnsInfo)localObject).localid);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.s(((SnsInfo)localObject).field_snsId, 2);
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a((com.tencent.mm.ak.q)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755998);
              paramAnonymousMenuItem.tipDialog = h.a(localContext, paramAnonymousMenuItem.context.getString(2131766198), true, new w.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.s)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
              {
                if (paramSnsInfo.field_type != 15)
                {
                  paramAnonymousMenuItem = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb);
                  if (r.aBO(paramAnonymousMenuItem) == 4)
                  {
                    localObject = com.tencent.mm.vfs.s.k(paramAnonymousMenuItem, false) + "_tmp";
                    com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ((String)localObject));
                    ((com.tencent.mm.plugin.emoji.b.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(com.tencent.mm.vfs.s.k(paramAnonymousMenuItem, false), (String)localObject);
                    com.tencent.mm.pluginsdk.ui.tools.s.l((String)localObject, w.this.context);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  com.tencent.mm.pluginsdk.ui.tools.s.l(paramAnonymousMenuItem, w.this.context);
                  AppMethodBeat.o(97902);
                  return;
                }
                w.aQS(paramSnsInfo.getLocalid());
                AppMethodBeat.o(97902);
                return;
                if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
                {
                  if (paramSnsInfo.getTimeLine().ContentObj.LoU == 1)
                  {
                    paramAnonymousMenuItem = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb);
                    w.this.aQR(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  w.aQT(paramSnsInfo.getLocalid());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramSnsInfo.getTimeLine().ContentObj.LoV.size() > 1)
                  {
                    h.a(w.this.context, w.this.context.getString(2131766167), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        w.this.U(w.7.this.EpB);
                        AppMethodBeat.o(97900);
                      }
                    }, null);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  h.a(w.this.context, w.this.context.getString(2131766165), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(97901);
                      w.this.U(w.7.this.EpB);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context))
                  {
                    paramAnonymousMenuItem = new wj();
                    paramAnonymousMenuItem.ecv.mediaId = w.this.Mc;
                    EventCenter.instance.publish(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                    if (paramSnsInfo.getTimeLine().ContentObj.LoU == 1)
                    {
                      paramAnonymousMenuItem = new o();
                      paramAnonymousMenuItem.context = w.this.context;
                      paramAnonymousMenuItem.dHq = (com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb));
                      paramAnonymousMenuItem.IDs = w.this.DqO.field_userName;
                      paramAnonymousMenuItem.dRS = r.Jb(w.this.DqO.field_snsId);
                      paramAnonymousMenuItem.DIq = paramcnb;
                      paramAnonymousMenuItem.dGf = r.Yo(w.this.fromScene);
                      ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramAnonymousMenuItem);
                      AppMethodBeat.o(97902);
                      return;
                      if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context))
                      {
                        paramAnonymousMenuItem = new vw();
                        paramAnonymousMenuItem.ebW.mediaId = w.this.Mc;
                        paramAnonymousMenuItem.ebW.dkU = paramSnsInfo.getUserName();
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
      this.Epy.PGl = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          if (w.this.Eqw != null) {
            w.this.Eqw.ffI();
          }
          Object localObject = new ax();
          ((ax)localObject).dDY.dDZ = w.this.Eqs;
          ((ax)localObject).dDY.filePath = w.this.Eqk;
          EventCenter.instance.publish((IEvent)localObject);
          w.this.Epy = null;
          w.this.Eqk = null;
          w.this.DqO = null;
          w.this.Mc = null;
          w.this.Eqn = null;
          w.this.Eqo = null;
          w.this.Eqp = null;
          w.this.Eqr = null;
          w.this.Eqq = null;
          localObject = w.this;
          w.this.dFM = 0;
          ((w)localObject).dFL = 0;
          w.this.EqZ = 0;
          AppMethodBeat.o(97903);
        }
      };
      this.Epy.dGm();
      if (this.Eqw != null) {
        this.Eqw.ha(paramList1);
      }
      AppMethodBeat.o(97914);
      return;
      this.Epy = new e(this.context, 1, false);
    }
  }
  
  private void b(List<String> paramList, List<Integer> paramList1, final SnsInfo paramSnsInfo, final cnb paramcnb, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if (this.Epy != null) {
      if (this.Equ) {
        this.Equ = false;
      }
    }
    for (;;)
    {
      this.Epy.HLX = new w.9(this, paramList, paramList1, paramSnsInfo);
      this.Epy.HLY = new o.g()
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
              w.a(w.this, paramSnsInfo, paramcnb);
              AppMethodBeat.o(97905);
              return;
              w.b(w.this, paramSnsInfo, paramcnb);
              AppMethodBeat.o(97905);
              return;
              if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
              {
                if (paramSnsInfo.getTimeLine().ContentObj.LoU == 1)
                {
                  paramAnonymousMenuItem = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb);
                  w.this.aQR(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                w.aQT(paramSnsInfo.getLocalid());
                AppMethodBeat.o(97905);
                return;
                if ((paramSnsInfo != null) && (paramSnsInfo.getTimeLine().ContentObj != null))
                {
                  if (paramSnsInfo.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.s.l(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb), w.this.context);
                    AppMethodBeat.o(97905);
                    return;
                  }
                  w.aQS(paramSnsInfo.getLocalid());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = w.this;
                  long l = paramSnsInfo.field_snsId;
                  SnsInfo localSnsInfo = aj.faO().JJ(l);
                  if ((l == 0L) || (localSnsInfo == null))
                  {
                    AppMethodBeat.o(97905);
                    return;
                  }
                  Intent localIntent = new Intent();
                  localIntent.putExtra("k_username", localSnsInfo.getUserName());
                  localIntent.putExtra("k_expose_msg_id", l);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("rawUrl", String.format(e.e.OyU, new Object[] { Integer.valueOf(33) }));
                  com.tencent.mm.br.c.b(paramAnonymousMenuItem.context, "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(97905);
                  return;
                  if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context))
                  {
                    paramAnonymousMenuItem = new wj();
                    paramAnonymousMenuItem.ecv.mediaId = w.this.Mc;
                    EventCenter.instance.publish(paramAnonymousMenuItem);
                    AppMethodBeat.o(97905);
                    return;
                    if (paramSnsInfo.getTimeLine().ContentObj.LoU == 1)
                    {
                      paramAnonymousMenuItem = new o();
                      paramAnonymousMenuItem.context = w.this.context;
                      paramAnonymousMenuItem.dHq = (com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb));
                      paramAnonymousMenuItem.IDs = w.this.DqO.field_userName;
                      paramAnonymousMenuItem.dRS = r.Jb(w.this.DqO.field_snsId);
                      paramAnonymousMenuItem.DIq = paramcnb;
                      paramAnonymousMenuItem.dGf = r.Yo(w.this.fromScene);
                      ((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(paramAnonymousMenuItem);
                      AppMethodBeat.o(97905);
                      return;
                      if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context))
                      {
                        paramAnonymousMenuItem = new vw();
                        paramAnonymousMenuItem.ebW.mediaId = w.this.Mc;
                        paramAnonymousMenuItem.ebW.dkU = paramSnsInfo.getUserName();
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
      this.Epy.PGl = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(203254);
          Object localObject = new ax();
          ((ax)localObject).dDY.dDZ = w.this.Eqs;
          ((ax)localObject).dDY.filePath = w.this.Eqk;
          EventCenter.instance.publish((IEvent)localObject);
          w.this.Epy = null;
          w.this.Eqk = null;
          w.this.DqO = null;
          w.this.Mc = null;
          w.this.Eqn = null;
          w.this.Eqo = null;
          w.this.Eqp = null;
          w.this.Eqr = null;
          w.this.Eqq = null;
          localObject = w.this;
          w.this.dFM = 0;
          ((w)localObject).dFL = 0;
          w.this.EqZ = 0;
          AppMethodBeat.o(203254);
        }
      };
      this.Epy.dGm();
      AppMethodBeat.o(97915);
      return;
      this.Epy = new e(this.context, 1, false);
    }
  }
  
  protected final void U(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(97916);
    if ((paramSnsInfo.isWaitPost()) || (paramSnsInfo.isDieItem()))
    {
      aj.faO().Zs(paramSnsInfo.localid);
      this.EqW.Yj(paramSnsInfo.localid);
      AppMethodBeat.o(97916);
      return;
    }
    aj.faN().Jr(paramSnsInfo.field_snsId);
    paramSnsInfo = new com.tencent.mm.plugin.sns.model.s(paramSnsInfo.field_snsId, 1);
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramSnsInfo, 0);
    Context localContext = this.context;
    this.context.getString(2131755998);
    this.tipDialog = h.a(localContext, this.context.getString(2131766022), true, new w.13(this, paramSnsInfo));
    AppMethodBeat.o(97916);
  }
  
  public final void Zu(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.EqW.Yj(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void a(boolean paramBoolean, SnsInfo paramSnsInfo, cnb paramcnb)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramSnsInfo, paramcnb, this.Era, this.Erb, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, SnsInfo paramSnsInfo, cnb paramcnb, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, int paramInt)
  {
    AppMethodBeat.i(203257);
    this.EqY = paramBoolean1;
    this.DqO = paramSnsInfo;
    this.DzV = paramcnb;
    this.Mc = paramcnb.Id;
    this.Era = paramBoolean2;
    this.Erb = paramBoolean3;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject;
    ab localab;
    if (paramBoolean1)
    {
      if (paramSnsInfo == null)
      {
        AppMethodBeat.o(203257);
        return;
      }
      if (paramSnsInfo.getLocalPrivate() > 0)
      {
        if ((!Util.isNullOrNil(aj.fau())) && (aj.fau().equals(paramSnsInfo.getUserName())))
        {
          localArrayList1.add(this.context.getString(2131766201));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131766179));
        localArrayList2.add(Integer.valueOf(3));
        if (com.tencent.mm.br.c.aZU("favorite"))
        {
          localArrayList1.add(this.context.getString(2131763947));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramSnsInfo.field_type != 15) && (paramSnsInfo.field_type != 5)) {
          break label741;
        }
        localArrayList1.add(this.context.getString(2131764871));
        localArrayList2.add(Integer.valueOf(2));
      }
      for (;;)
      {
        localObject = new ef();
        ((ef)localObject).dHy.dHp = paramSnsInfo.getLocalid();
        EventCenter.instance.publish((IEvent)localObject);
        if (((ef)localObject).dHz.dGX)
        {
          localArrayList1.add(this.context.getString(2131755922));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.Eqn != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (paramSnsInfo.field_type == 1) && (r.Yn(this.fromScene)))
        {
          localArrayList1.add(this.context.getString(2131759440));
          localArrayList2.add(Integer.valueOf(10));
          if (!this.Equ)
          {
            localObject = new ab();
            localab = ((ab)localObject).ie("").jdMethod_if(r.Jb(this.DqO.field_snsId));
            localab.enp = r.Yo(this.fromScene);
            localab.eki = 1;
            localab.enq = 81;
            ((ab)localObject).ig("");
            ((ab)localObject).ih("");
            ((ab)localObject).ii(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb)));
            ((ab)localObject).enx = System.currentTimeMillis();
            ((ab)localObject).bfK();
            com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject);
          }
        }
        a(localArrayList1, localArrayList2, paramSnsInfo, paramcnb, paramInt);
        if (true == paramBoolean4)
        {
          com.tencent.mm.kernel.g.aAi();
          if (com.tencent.mm.kernel.g.aAg().hqi.aYS() != 0)
          {
            paramSnsInfo = new qx();
            paramcnb = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), this.Mc) + r.l(paramcnb);
            paramSnsInfo.dXu.filePath = paramcnb;
            this.Eqs = System.currentTimeMillis();
            paramSnsInfo.dXu.dDZ = this.Eqs;
            this.Eqk = paramcnb;
            EventCenter.instance.publish(paramSnsInfo);
          }
        }
        AppMethodBeat.o(203257);
        return;
        localArrayList1.add(this.context.getString(2131766202));
        localArrayList2.add(Integer.valueOf(1));
        localArrayList1.add(this.context.getString(2131766179));
        localArrayList2.add(Integer.valueOf(3));
        break;
        label741:
        if (paramSnsInfo.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131764866));
          localArrayList2.add(Integer.valueOf(2));
          if (paramBoolean2)
          {
            localArrayList1.add(this.context.getString(2131757389));
            localArrayList2.add(Integer.valueOf(9));
          }
          if (paramBoolean3)
          {
            localArrayList1.add(this.context.getString(2131757387));
            localArrayList2.add(Integer.valueOf(11));
          }
        }
        else
        {
          localArrayList1.add(this.context.getString(2131766187));
          localArrayList2.add(Integer.valueOf(2));
        }
      }
    }
    paramSnsInfo.getTimeLine();
    localArrayList1.add(this.context.getString(2131766179));
    localArrayList2.add(Integer.valueOf(3));
    if (com.tencent.mm.br.c.aZU("favorite"))
    {
      localArrayList1.add(this.context.getString(2131763947));
      localArrayList2.add(Integer.valueOf(6));
    }
    if ((paramSnsInfo.field_type == 15) || (paramSnsInfo.field_type == 5))
    {
      localArrayList1.add(this.context.getString(2131764871));
      localArrayList2.add(Integer.valueOf(2));
    }
    for (;;)
    {
      localObject = new ef();
      ((ef)localObject).dHy.dHp = paramSnsInfo.getLocalid();
      EventCenter.instance.publish((IEvent)localObject);
      if (((ef)localObject).dHz.dGX)
      {
        localArrayList1.add(this.context.getString(2131755922));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.Eqn != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      if ((((com.tencent.mm.plugin.websearch.api.c)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch()) && (paramSnsInfo.field_type == 1) && (r.Yn(this.fromScene)))
      {
        localArrayList1.add(this.context.getString(2131759440));
        localArrayList2.add(Integer.valueOf(10));
        localObject = new ab();
        localab = ((ab)localObject).ie("").jdMethod_if(r.Jb(this.DqO.field_snsId));
        localab.enp = r.Yo(this.fromScene);
        localab.eki = 1;
        localab.enq = 81;
        ((ab)localObject).ig("");
        ((ab)localObject).ih("");
        ((ab)localObject).ii(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), paramcnb.Id) + r.l(paramcnb)));
        ((ab)localObject).enx = System.currentTimeMillis();
        ((ab)localObject).bfK();
        com.tencent.mm.plugin.websearch.api.ar.a((com.tencent.mm.plugin.report.a)localObject);
      }
      b(localArrayList1, localArrayList2, paramSnsInfo, paramcnb, paramInt);
      break;
      if (paramSnsInfo.field_type == 1)
      {
        localArrayList1.add(this.context.getString(2131764866));
        localArrayList2.add(Integer.valueOf(2));
        if (paramBoolean2)
        {
          localArrayList1.add(this.context.getString(2131757389));
          localArrayList2.add(Integer.valueOf(9));
        }
        if (paramBoolean3)
        {
          localArrayList1.add(this.context.getString(2131757387));
          localArrayList2.add(Integer.valueOf(11));
        }
      }
      else
      {
        localArrayList1.add(this.context.getString(2131766187));
        localArrayList2.add(Integer.valueOf(2));
      }
    }
  }
  
  protected final void aQR(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.jRt.k(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void ffJ()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.EqW);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
    AppMethodBeat.o(97911);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
      this.EqW.Yj(paramString.ecf);
      this.EqX.fH(y.bq("sns_table_", paramString.ecf), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.EqW.Yk(paramString.ecf);
      this.EqX.fH("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.EqX.fH("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.EqW.Yk(paramString.ecf);
      this.EqX.fH(y.bq("sns_table_", paramString.ecf), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void fH(String paramString, int paramInt);
    
    public abstract void fI(String paramString, int paramInt);
    
    public abstract void ffK();
    
    public abstract void kQ(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.w
 * JD-Core Version:    0.7.0.1
 */