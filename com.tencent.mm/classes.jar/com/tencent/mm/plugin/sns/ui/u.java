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
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.at;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.dy.b;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.um;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

public final class u
  implements com.tencent.mm.ak.g
{
  String Kc;
  final Context context;
  int dbX;
  int dbY;
  ScanCodeSheetItemLogic kYG;
  public int ndF;
  c qMM;
  public com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.sns.storage.p xHc;
  private final String yAa;
  e yyJ;
  SnsCmdList yzV;
  private final a yzW;
  boolean yzX;
  btz yzY;
  int yzZ;
  String yzl;
  String yzo;
  String yzp;
  String yzq;
  String yzr;
  String yzs;
  long yzt;
  boolean yzv;
  c yzx;
  
  public u(Context paramContext, a parama)
  {
    AppMethodBeat.i(97910);
    this.yzV = new SnsCmdList();
    this.tipDialog = null;
    this.ndF = 0;
    this.yyJ = null;
    this.yzZ = 0;
    this.yzv = false;
    this.qMM = new c() {};
    this.yzx = new c() {};
    this.context = paramContext;
    this.yzW = parama;
    this.yAa = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.kYG = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bly()
      {
        AppMethodBeat.i(97895);
        if ((u.this.yyJ != null) && (u.this.yyJ.isShowing()))
        {
          u.this.yzv = true;
          u.this.a(u.this.yzX, u.this.xHc, u.this.yzY);
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(97910);
  }
  
  private void a(List<String> paramList, List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final btz parambtz, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if ((this.yyJ != null) && (this.yzv)) {
      this.yzv = false;
    }
    for (;;)
    {
      this.yyJ.ISu = new u.5(this, paramList, paramList1, paramp);
      this.yyJ.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ac.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97902);
            return;
            if ((paramp != null) && (paramp.dLV().FQo != null))
            {
              u.a(u.this, paramp, parambtz);
              AppMethodBeat.o(97902);
              return;
              u.b(u.this, paramp, parambtz);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = u.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 3);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new u.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = u.this;
              localObject = paramp;
              if ((((com.tencent.mm.plugin.sns.storage.p)localObject).dMv()) || (((com.tencent.mm.plugin.sns.storage.p)localObject).dMw()))
              {
                af.dHR().Pi(((com.tencent.mm.plugin.sns.storage.p)localObject).yvp);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.q(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId, 2);
              com.tencent.mm.kernel.g.agS();
              com.tencent.mm.kernel.g.agQ().ghe.a((n)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new u.12(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramp != null) && (paramp.dLV().FQo != null))
              {
                if (paramp.field_type != 15)
                {
                  com.tencent.mm.pluginsdk.ui.tools.q.j(an.jc(af.getAccSnsPath(), parambtz.Id) + com.tencent.mm.plugin.sns.data.q.k(parambtz), u.this.context);
                  AppMethodBeat.o(97902);
                  return;
                }
                u.avz(paramp.dMu());
                AppMethodBeat.o(97902);
                return;
                if ((paramp != null) && (paramp.dLV().FQo != null))
                {
                  if (paramp.dLV().FQo.Ety == 1)
                  {
                    paramAnonymousMenuItem = an.jc(af.getAccSnsPath(), parambtz.Id) + com.tencent.mm.plugin.sns.data.q.k(parambtz);
                    u.this.avy(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  u.avA(paramp.dMu());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramp.dLV().FQo.Etz.size() > 1)
                  {
                    h.a(u.this.context, u.this.context.getString(2131763940), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        u.this.M(u.6.this.yyM);
                        AppMethodBeat.o(97900);
                      }
                    }, null);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  h.a(u.this.context, u.this.context.getString(2131763938), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(97901);
                      u.this.M(u.6.this.yyM);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  paramAnonymousMenuItem = new um();
                  paramAnonymousMenuItem.dxg.mediaId = u.this.Kc;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.yyJ.Ihj = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          Object localObject = new at();
          ((at)localObject).dan.dao = u.this.yzt;
          ((at)localObject).dan.filePath = u.this.yzl;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
          u.this.yyJ = null;
          u.this.yzl = null;
          u.this.xHc = null;
          u.this.Kc = null;
          u.this.yzo = null;
          u.this.yzp = null;
          u.this.yzq = null;
          u.this.yzs = null;
          u.this.yzr = null;
          localObject = u.this;
          u.this.dbY = 0;
          ((u)localObject).dbX = 0;
          u.this.yzZ = 0;
          AppMethodBeat.o(97903);
        }
      };
      this.yyJ.cED();
      AppMethodBeat.o(97914);
      return;
      this.yyJ = new e(this.context, 1, false);
    }
  }
  
  private void b(List<String> paramList, List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final btz parambtz, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if ((this.yyJ != null) && (this.yzv)) {
      this.yzv = false;
    }
    for (;;)
    {
      this.yyJ.ISu = new u.8(this, paramList, paramList1, paramp);
      this.yyJ.ISv = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97905);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ac.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97905);
            return;
            if ((paramp != null) && (paramp.dLV().FQo != null))
            {
              u.a(u.this, paramp, parambtz);
              AppMethodBeat.o(97905);
              return;
              u.b(u.this, paramp, parambtz);
              AppMethodBeat.o(97905);
              return;
              if ((paramp != null) && (paramp.dLV().FQo != null))
              {
                if (paramp.dLV().FQo.Ety == 1)
                {
                  paramAnonymousMenuItem = an.jc(af.getAccSnsPath(), parambtz.Id) + com.tencent.mm.plugin.sns.data.q.k(parambtz);
                  u.this.avy(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                u.avA(paramp.dMu());
                AppMethodBeat.o(97905);
                return;
                if ((paramp != null) && (paramp.dLV().FQo != null))
                {
                  if (paramp.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.q.j(an.jc(af.getAccSnsPath(), parambtz.Id) + com.tencent.mm.plugin.sns.data.q.k(parambtz), u.this.context);
                    AppMethodBeat.o(97905);
                    return;
                  }
                  u.avz(paramp.dMu());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = u.this;
                  long l = paramp.field_snsId;
                  com.tencent.mm.plugin.sns.storage.p localp = af.dHR().xK(l);
                  if ((l == 0L) || (localp == null))
                  {
                    AppMethodBeat.o(97905);
                    return;
                  }
                  Intent localIntent = new Intent();
                  localIntent.putExtra("k_username", localp.field_userName);
                  localIntent.putExtra("k_expose_msg_id", l);
                  localIntent.putExtra("showShare", false);
                  localIntent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[] { Integer.valueOf(33) }));
                  d.b(paramAnonymousMenuItem.context, "webview", ".ui.tools.WebViewUI", localIntent);
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = new um();
                  paramAnonymousMenuItem.dxg.mediaId = u.this.Kc;
                  com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.yyJ.cED();
      AppMethodBeat.o(97915);
      return;
      this.yyJ = new e(this.context, 1, false);
    }
  }
  
  protected final void M(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97916);
    if ((paramp.dMv()) || (paramp.dMw()))
    {
      af.dHR().Pi(paramp.yvp);
      this.yzV.Oa(paramp.yvp);
      AppMethodBeat.o(97916);
      return;
    }
    af.dHQ().xo(paramp.field_snsId);
    paramp = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 1);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(paramp, 0);
    Context localContext = this.context;
    this.context.getString(2131755906);
    this.tipDialog = h.b(localContext, this.context.getString(2131763798), true, new u.11(this, paramp));
    AppMethodBeat.o(97916);
  }
  
  public final void Pk(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.yzV.Oa(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.sns.storage.p paramp, btz parambtz)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramp, parambtz, false, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, com.tencent.mm.plugin.sns.storage.p paramp, btz parambtz, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(97913);
    this.yzX = paramBoolean1;
    this.xHc = paramp;
    this.yzY = parambtz;
    this.Kc = parambtz.Id;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    dy localdy;
    if (paramBoolean1)
    {
      if (paramp == null)
      {
        AppMethodBeat.o(97913);
        return;
      }
      if (paramp.field_localPrivate > 0)
      {
        if ((!bs.isNullOrNil(af.dHx())) && (af.dHx().equals(paramp.field_userName)))
        {
          localArrayList1.add(this.context.getString(2131763967));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131763948));
        localArrayList2.add(Integer.valueOf(3));
        if (d.aCT("favorite"))
        {
          localArrayList1.add(this.context.getString(2131761941));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramp.field_type != 15) && (paramp.field_type != 5)) {
          break label523;
        }
        localArrayList1.add(this.context.getString(2131762784));
        localArrayList2.add(Integer.valueOf(2));
      }
      for (;;)
      {
        localdy = new dy();
        localdy.ddK.ddB = paramp.dMu();
        com.tencent.mm.sdk.b.a.GpY.l(localdy);
        if (localdy.ddL.ddj)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.yzo != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        a(localArrayList1, localArrayList2, paramp, parambtz, paramInt);
        if (true == paramBoolean3)
        {
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.g.agQ().ghe.aBK() != 0)
          {
            paramp = new ps();
            parambtz = an.jc(af.getAccSnsPath(), this.Kc) + com.tencent.mm.plugin.sns.data.q.k(parambtz);
            paramp.dsJ.filePath = parambtz;
            this.yzt = System.currentTimeMillis();
            paramp.dsJ.dao = this.yzt;
            this.yzl = parambtz;
            com.tencent.mm.sdk.b.a.GpY.l(paramp);
          }
        }
        AppMethodBeat.o(97913);
        return;
        localArrayList1.add(this.context.getString(2131763968));
        localArrayList2.add(Integer.valueOf(1));
        localArrayList1.add(this.context.getString(2131763948));
        localArrayList2.add(Integer.valueOf(3));
        break;
        label523:
        if (paramp.field_type == 1)
        {
          localArrayList1.add(this.context.getString(2131762781));
          localArrayList2.add(Integer.valueOf(2));
          if (paramBoolean2)
          {
            localArrayList1.add(this.context.getString(2131757184));
            localArrayList2.add(Integer.valueOf(9));
          }
        }
        else
        {
          localArrayList1.add(this.context.getString(2131763953));
          localArrayList2.add(Integer.valueOf(2));
        }
      }
    }
    paramp.dLV();
    localArrayList1.add(this.context.getString(2131763948));
    localArrayList2.add(Integer.valueOf(3));
    if (d.aCT("favorite"))
    {
      localArrayList1.add(this.context.getString(2131761941));
      localArrayList2.add(Integer.valueOf(6));
    }
    if ((paramp.field_type == 15) || (paramp.field_type == 5))
    {
      localArrayList1.add(this.context.getString(2131762784));
      localArrayList2.add(Integer.valueOf(2));
    }
    for (;;)
    {
      localdy = new dy();
      localdy.ddK.ddB = paramp.dMu();
      com.tencent.mm.sdk.b.a.GpY.l(localdy);
      if (localdy.ddL.ddj)
      {
        localArrayList1.add(this.context.getString(2131755836));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.yzo != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      b(localArrayList1, localArrayList2, paramp, parambtz, paramInt);
      break;
      if (paramp.field_type == 1)
      {
        localArrayList1.add(this.context.getString(2131762781));
        localArrayList2.add(Integer.valueOf(2));
        if (paramBoolean2)
        {
          localArrayList1.add(this.context.getString(2131757184));
          localArrayList2.add(Integer.valueOf(9));
        }
      }
      else
      {
        localArrayList1.add(this.context.getString(2131763953));
        localArrayList2.add(Integer.valueOf(2));
      }
    }
  }
  
  protected final void avy(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.iyx.k(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void dNw()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.yzV);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
    AppMethodBeat.o(97911);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(97918);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramn == null))
    {
      AppMethodBeat.o(97918);
      return;
    }
    ac.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (com.tencent.mm.plugin.sns.model.q)paramn;
    switch (paramString.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97918);
      return;
      this.yzV.Oa(paramString.dwR);
      this.yzW.eI(x.bk("sns_table_", paramString.dwR), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.yzV.Ob(paramString.dwR);
      this.yzW.eI("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.yzW.eI("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.yzV.Ob(paramString.dwR);
      this.yzW.eI(x.bk("sns_table_", paramString.dwR), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dNx();
    
    public abstract void eI(String paramString, int paramInt);
    
    public abstract void eJ(String paramString, int paramInt);
    
    public abstract void jI(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */