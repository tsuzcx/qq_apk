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
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.as;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.dx;
import com.tencent.mm.g.a.dx.b;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.List;

public final class u
  implements com.tencent.mm.al.g
{
  String Jh;
  final Context context;
  int deB;
  int deC;
  ScanCodeSheetItemLogic kxs;
  public int mBE;
  c qej;
  public com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.sns.storage.p wvM;
  e xlR;
  String xmA;
  long xmB;
  boolean xmD;
  c xmF;
  String xmt;
  String xmw;
  String xmx;
  String xmy;
  String xmz;
  SnsCmdList xne;
  private final a xnf;
  boolean xng;
  bpi xnh;
  int xni;
  private final String xnj;
  
  public u(Context paramContext, a parama)
  {
    AppMethodBeat.i(97910);
    this.xne = new SnsCmdList();
    this.tipDialog = null;
    this.mBE = 0;
    this.xlR = null;
    this.xni = 0;
    this.xmD = false;
    this.qej = new c() {};
    this.xmF = new c() {};
    this.context = paramContext;
    this.xnf = parama;
    this.xnj = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.kxs = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
      {
        AppMethodBeat.i(97895);
        if ((u.this.xlR != null) && (u.this.xlR.isShowing()))
        {
          u.this.xmD = true;
          u.this.a(u.this.xng, u.this.wvM, u.this.xnh);
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(97910);
  }
  
  private void a(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final bpi parambpi, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if ((this.xlR != null) && (this.xmD)) {
      this.xmD = false;
    }
    for (;;)
    {
      this.xlR.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(97899);
          u.this.xlR.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              u.this.xlR.setFooterView(u.a(u.this, paramp));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.c(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          paramAnonymousl.c(-1, u.this.context.getString(2131763797));
          AppMethodBeat.o(97899);
        }
      };
      this.xlR.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97902);
            return;
            if ((paramp != null) && (paramp.dxy().Etm != null))
            {
              u.a(u.this, paramp, parambpi);
              AppMethodBeat.o(97902);
              return;
              u.b(u.this, paramp, parambpi);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = u.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 3);
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new u.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = u.this;
              localObject = paramp;
              if ((((com.tencent.mm.plugin.sns.storage.p)localObject).dxY()) || (((com.tencent.mm.plugin.sns.storage.p)localObject).dxZ()))
              {
                af.dtu().Nf(((com.tencent.mm.plugin.sns.storage.p)localObject).xiB);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.q(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId, 2);
              com.tencent.mm.kernel.g.afC();
              com.tencent.mm.kernel.g.afA().gcy.a((n)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new u.12(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramp != null) && (paramp.dxy().Etm != null))
              {
                if (paramp.field_type != 15)
                {
                  com.tencent.mm.pluginsdk.ui.tools.q.j(an.iF(af.getAccSnsPath(), parambpi.Id) + com.tencent.mm.plugin.sns.data.q.k(parambpi), u.this.context);
                  AppMethodBeat.o(97902);
                  return;
                }
                u.aqq(paramp.dxX());
                AppMethodBeat.o(97902);
                return;
                if ((paramp != null) && (paramp.dxy().Etm != null))
                {
                  if (paramp.dxy().Etm.DaB == 1)
                  {
                    paramAnonymousMenuItem = an.iF(af.getAccSnsPath(), parambpi.Id) + com.tencent.mm.plugin.sns.data.q.k(parambpi);
                    u.this.aqp(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  u.aqr(paramp.dxX());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramp.dxy().Etm.DaC.size() > 1)
                  {
                    h.a(u.this.context, u.this.context.getString(2131763940), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        u.this.L(u.6.this.xlU);
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
                      u.this.L(u.6.this.xlU);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  paramAnonymousMenuItem = new uc();
                  paramAnonymousMenuItem.dzu.mediaId = u.this.Jh;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.xlR.GHn = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          Object localObject = new as();
          ((as)localObject).dcP.dcQ = u.this.xmB;
          ((as)localObject).dcP.filePath = u.this.xmt;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
          u.this.xlR = null;
          u.this.xmt = null;
          u.this.wvM = null;
          u.this.Jh = null;
          u.this.xmw = null;
          u.this.xmx = null;
          u.this.xmy = null;
          u.this.xmA = null;
          u.this.xmz = null;
          localObject = u.this;
          u.this.deC = 0;
          ((u)localObject).deB = 0;
          u.this.xni = 0;
          AppMethodBeat.o(97903);
        }
      };
      this.xlR.csG();
      AppMethodBeat.o(97914);
      return;
      this.xlR = new e(this.context, 1, false);
    }
  }
  
  private void b(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final bpi parambpi, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if ((this.xlR != null) && (this.xmD)) {
      this.xmD = false;
    }
    for (;;)
    {
      this.xlR.HrX = new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(97904);
          u.this.xlR.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              u.this.xlR.setFooterView(u.a(u.this, paramp));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.c(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          AppMethodBeat.o(97904);
        }
      };
      this.xlR.HrY = new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97905);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97905);
            return;
            if ((paramp != null) && (paramp.dxy().Etm != null))
            {
              u.a(u.this, paramp, parambpi);
              AppMethodBeat.o(97905);
              return;
              u.b(u.this, paramp, parambpi);
              AppMethodBeat.o(97905);
              return;
              if ((paramp != null) && (paramp.dxy().Etm != null))
              {
                if (paramp.dxy().Etm.DaB == 1)
                {
                  paramAnonymousMenuItem = an.iF(af.getAccSnsPath(), parambpi.Id) + com.tencent.mm.plugin.sns.data.q.k(parambpi);
                  u.this.aqp(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                u.aqr(paramp.dxX());
                AppMethodBeat.o(97905);
                return;
                if ((paramp != null) && (paramp.dxy().Etm != null))
                {
                  if (paramp.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.q.j(an.iF(af.getAccSnsPath(), parambpi.Id) + com.tencent.mm.plugin.sns.data.q.k(parambpi), u.this.context);
                    AppMethodBeat.o(97905);
                    return;
                  }
                  u.aqq(paramp.dxX());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = u.this;
                  long l = paramp.field_snsId;
                  com.tencent.mm.plugin.sns.storage.p localp = af.dtu().th(l);
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
                  paramAnonymousMenuItem = new uc();
                  paramAnonymousMenuItem.dzu.mediaId = u.this.Jh;
                  com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.xlR.csG();
      AppMethodBeat.o(97915);
      return;
      this.xlR = new e(this.context, 1, false);
    }
  }
  
  protected final void L(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97916);
    if ((paramp.dxY()) || (paramp.dxZ()))
    {
      af.dtu().Nf(paramp.xiB);
      this.xne.LY(paramp.xiB);
      AppMethodBeat.o(97916);
      return;
    }
    af.dtt().sL(paramp.field_snsId);
    paramp = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 1);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramp, 0);
    Context localContext = this.context;
    this.context.getString(2131755906);
    this.tipDialog = h.b(localContext, this.context.getString(2131763798), true, new u.11(this, paramp));
    AppMethodBeat.o(97916);
  }
  
  public final void Nh(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.xne.LY(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.sns.storage.p paramp, bpi parambpi)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramp, parambpi, false, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, com.tencent.mm.plugin.sns.storage.p paramp, bpi parambpi, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(97913);
    this.xng = paramBoolean1;
    this.wvM = paramp;
    this.xnh = parambpi;
    this.Jh = parambpi.Id;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    dx localdx;
    if (paramBoolean1)
    {
      if (paramp == null)
      {
        AppMethodBeat.o(97913);
        return;
      }
      if (paramp.field_localPrivate > 0)
      {
        if ((!bt.isNullOrNil(af.dta())) && (af.dta().equals(paramp.field_userName)))
        {
          localArrayList1.add(this.context.getString(2131763967));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131763948));
        localArrayList2.add(Integer.valueOf(3));
        if (d.axB("favorite"))
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
        localdx = new dx();
        localdx.dgp.dgg = paramp.dxX();
        com.tencent.mm.sdk.b.a.ESL.l(localdx);
        if (localdx.dgq.dfO)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.xmw != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        a(localArrayList1, localArrayList2, paramp, parambpi, paramInt);
        if (true == paramBoolean3)
        {
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afA().gcy.auR() != 0)
          {
            paramp = new pj();
            parambpi = an.iF(af.getAccSnsPath(), this.Jh) + com.tencent.mm.plugin.sns.data.q.k(parambpi);
            paramp.duX.filePath = parambpi;
            this.xmB = System.currentTimeMillis();
            paramp.duX.dcQ = this.xmB;
            this.xmt = parambpi;
            com.tencent.mm.sdk.b.a.ESL.l(paramp);
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
    paramp.dxy();
    localArrayList1.add(this.context.getString(2131763948));
    localArrayList2.add(Integer.valueOf(3));
    if (d.axB("favorite"))
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
      localdx = new dx();
      localdx.dgp.dgg = paramp.dxX();
      com.tencent.mm.sdk.b.a.ESL.l(localdx);
      if (localdx.dgq.dfO)
      {
        localArrayList1.add(this.context.getString(2131755836));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.xmw != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      b(localArrayList1, localArrayList2, paramp, parambpi, paramInt);
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
  
  protected final void aqp(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.d.a.hYt.k(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void dyZ()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.xne);
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
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
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
      this.xne.LY(paramString.dzf);
      this.xnf.eA(x.bi("sns_table_", paramString.dzf), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.xne.LZ(paramString.dzf);
      this.xnf.eA("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.xnf.eA("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.xne.LZ(paramString.dzf);
      this.xnf.eA(x.bi("sns_table_", paramString.dzf), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dza();
    
    public abstract void eA(String paramString, int paramInt);
    
    public abstract void eB(String paramString, int paramInt);
    
    public abstract void jk(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.u
 * JD-Core Version:    0.7.0.1
 */