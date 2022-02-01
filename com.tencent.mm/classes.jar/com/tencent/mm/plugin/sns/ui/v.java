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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.eb;
import com.tencent.mm.g.a.eb.b;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class v
  implements f
{
  String LS;
  final Context context;
  int dnt;
  int dnu;
  ScanCodeSheetItemLogic lvI;
  public int nEc;
  com.tencent.mm.sdk.b.c rwO;
  public com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.sns.storage.p yVM;
  e zPV;
  String zQC;
  String zQF;
  String zQG;
  String zQH;
  String zQI;
  String zQJ;
  long zQK;
  boolean zQM;
  com.tencent.mm.sdk.b.c zQO;
  SnsCmdList zRm;
  private final a zRn;
  boolean zRo;
  int zRp;
  private final String zRq;
  byn zbu;
  
  public v(Context paramContext, a parama)
  {
    AppMethodBeat.i(97910);
    this.zRm = new SnsCmdList();
    this.tipDialog = null;
    this.nEc = 0;
    this.zPV = null;
    this.zRp = 0;
    this.zQM = false;
    this.rwO = new com.tencent.mm.sdk.b.c() {};
    this.zQO = new com.tencent.mm.sdk.b.c() {};
    this.context = paramContext;
    this.zRn = parama;
    this.zRq = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.lvI = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(97895);
        if ((v.this.zPV != null) && (v.this.zPV.isShowing()))
        {
          v.this.zQM = true;
          v.this.a(v.this.zRo, v.this.yVM, v.this.zbu);
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(97910);
  }
  
  private void a(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final byn parambyn, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if ((this.zPV != null) && (this.zQM)) {
      this.zQM = false;
    }
    for (;;)
    {
      this.zPV.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(97899);
          v.this.zPV.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              v.this.zPV.setFooterView(v.a(v.this, paramp));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.c(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          paramAnonymousl.c(-1, v.this.context.getString(2131763797));
          AppMethodBeat.o(97899);
        }
      };
      this.zPV.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ad.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97902);
            return;
            if ((paramp != null) && (paramp.dYl().HAT != null))
            {
              v.a(v.this, paramp, parambyn);
              AppMethodBeat.o(97902);
              return;
              v.b(v.this, paramp, parambyn);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = v.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 3);
              g.ajD();
              g.ajB().gAO.a((n)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new v.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = v.this;
              localObject = paramp;
              if ((((com.tencent.mm.plugin.sns.storage.p)localObject).dYL()) || (((com.tencent.mm.plugin.sns.storage.p)localObject).dYM()))
              {
                ag.dUe().QQ(((com.tencent.mm.plugin.sns.storage.p)localObject).zMC);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.q(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId, 2);
              g.ajD();
              g.ajB().gAO.a((n)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new v.12(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.q)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramp != null) && (paramp.dYl().HAT != null))
              {
                if (paramp.field_type != 15)
                {
                  paramAnonymousMenuItem = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.k(parambyn);
                  if (com.tencent.mm.plugin.sns.data.q.ans(paramAnonymousMenuItem) == 4)
                  {
                    localObject = i.k(paramAnonymousMenuItem, false) + "_tmp";
                    i.aYg(i.aYr((String)localObject));
                    ((com.tencent.mm.plugin.emoji.b.c)g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(i.k(paramAnonymousMenuItem, false), (String)localObject);
                    com.tencent.mm.pluginsdk.ui.tools.q.j((String)localObject, v.this.context);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  com.tencent.mm.pluginsdk.ui.tools.q.j(paramAnonymousMenuItem, v.this.context);
                  AppMethodBeat.o(97902);
                  return;
                }
                v.aAG(paramp.dYK());
                AppMethodBeat.o(97902);
                return;
                if ((paramp != null) && (paramp.dYl().HAT != null))
                {
                  if (paramp.dYl().HAT.GaP == 1)
                  {
                    paramAnonymousMenuItem = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.k(parambyn);
                    v.this.aAF(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  v.aAH(paramp.dYK());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramp.dYl().HAT.GaQ.size() > 1)
                  {
                    h.a(v.this.context, v.this.context.getString(2131763940), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        v.this.O(v.6.this.zPY);
                        AppMethodBeat.o(97900);
                      }
                    }, null);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  h.a(v.this.context, v.this.context.getString(2131763938), "", new DialogInterface.OnClickListener()
                  {
                    public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      AppMethodBeat.i(97901);
                      v.this.O(v.6.this.zPY);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  paramAnonymousMenuItem = new vf();
                  paramAnonymousMenuItem.dJs.mediaId = v.this.LS;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.zPV.JXC = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          Object localObject = new av();
          ((av)localObject).dlH.dlI = v.this.zQK;
          ((av)localObject).dlH.filePath = v.this.zQC;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
          v.this.zPV = null;
          v.this.zQC = null;
          v.this.yVM = null;
          v.this.LS = null;
          v.this.zQF = null;
          v.this.zQG = null;
          v.this.zQH = null;
          v.this.zQJ = null;
          v.this.zQI = null;
          localObject = v.this;
          v.this.dnu = 0;
          ((v)localObject).dnt = 0;
          v.this.zRp = 0;
          AppMethodBeat.o(97903);
        }
      };
      this.zPV.cMW();
      AppMethodBeat.o(97914);
      return;
      this.zPV = new e(this.context, 1, false);
    }
  }
  
  private void b(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final byn parambyn, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if ((this.zPV != null) && (this.zQM)) {
      this.zQM = false;
    }
    for (;;)
    {
      this.zPV.KJy = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(97904);
          v.this.zPV.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              v.this.zPV.setFooterView(v.a(v.this, paramp));
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
      this.zPV.KJz = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97905);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ad.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97905);
            return;
            if ((paramp != null) && (paramp.dYl().HAT != null))
            {
              v.a(v.this, paramp, parambyn);
              AppMethodBeat.o(97905);
              return;
              v.b(v.this, paramp, parambyn);
              AppMethodBeat.o(97905);
              return;
              if ((paramp != null) && (paramp.dYl().HAT != null))
              {
                if (paramp.dYl().HAT.GaP == 1)
                {
                  paramAnonymousMenuItem = ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.k(parambyn);
                  v.this.aAF(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                v.aAH(paramp.dYK());
                AppMethodBeat.o(97905);
                return;
                if ((paramp != null) && (paramp.dYl().HAT != null))
                {
                  if (paramp.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.q.j(ao.jo(ag.getAccSnsPath(), parambyn.Id) + com.tencent.mm.plugin.sns.data.q.k(parambyn), v.this.context);
                    AppMethodBeat.o(97905);
                    return;
                  }
                  v.aAG(paramp.dYK());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = v.this;
                  long l = paramp.field_snsId;
                  com.tencent.mm.plugin.sns.storage.p localp = ag.dUe().Ai(l);
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
                  paramAnonymousMenuItem = new vf();
                  paramAnonymousMenuItem.dJs.mediaId = v.this.LS;
                  com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.zPV.cMW();
      AppMethodBeat.o(97915);
      return;
      this.zPV = new e(this.context, 1, false);
    }
  }
  
  protected final void O(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97916);
    if ((paramp.dYL()) || (paramp.dYM()))
    {
      ag.dUe().QQ(paramp.zMC);
      this.zRm.PH(paramp.zMC);
      AppMethodBeat.o(97916);
      return;
    }
    ag.dUd().zN(paramp.field_snsId);
    paramp = new com.tencent.mm.plugin.sns.model.q(paramp.field_snsId, 1);
    g.ajD();
    g.ajB().gAO.a(paramp, 0);
    Context localContext = this.context;
    this.context.getString(2131755906);
    this.tipDialog = h.b(localContext, this.context.getString(2131763798), true, new v.11(this, paramp));
    AppMethodBeat.o(97916);
  }
  
  public final void QS(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.zRm.PH(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.sns.storage.p paramp, byn parambyn)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramp, parambyn, false, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, com.tencent.mm.plugin.sns.storage.p paramp, byn parambyn, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(97913);
    this.zRo = paramBoolean1;
    this.yVM = paramp;
    this.zbu = parambyn;
    this.LS = parambyn.Id;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    eb localeb;
    if (paramBoolean1)
    {
      if (paramp == null)
      {
        AppMethodBeat.o(97913);
        return;
      }
      if (paramp.field_localPrivate > 0)
      {
        if ((!bt.isNullOrNil(ag.dTJ())) && (ag.dTJ().equals(paramp.field_userName)))
        {
          localArrayList1.add(this.context.getString(2131763967));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131763948));
        localArrayList2.add(Integer.valueOf(3));
        if (d.aIu("favorite"))
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
        localeb = new eb();
        localeb.dpg.doX = paramp.dYK();
        com.tencent.mm.sdk.b.a.IbL.l(localeb);
        if (localeb.dph.doF)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.zQF != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        a(localArrayList1, localArrayList2, paramp, parambyn, paramInt);
        if (true == paramBoolean3)
        {
          g.ajD();
          if (g.ajB().gAO.aEN() != 0)
          {
            paramp = new qc();
            parambyn = ao.jo(ag.getAccSnsPath(), this.LS) + com.tencent.mm.plugin.sns.data.q.k(parambyn);
            paramp.dEC.filePath = parambyn;
            this.zQK = System.currentTimeMillis();
            paramp.dEC.dlI = this.zQK;
            this.zQC = parambyn;
            com.tencent.mm.sdk.b.a.IbL.l(paramp);
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
    paramp.dYl();
    localArrayList1.add(this.context.getString(2131763948));
    localArrayList2.add(Integer.valueOf(3));
    if (d.aIu("favorite"))
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
      localeb = new eb();
      localeb.dpg.doX = paramp.dYK();
      com.tencent.mm.sdk.b.a.IbL.l(localeb);
      if (localeb.dph.doF)
      {
        localArrayList1.add(this.context.getString(2131755836));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.zQF != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      b(localArrayList1, localArrayList2, paramp, parambyn, paramInt);
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
  
  protected final void aAF(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.iRG.k(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void dZL()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.zRm);
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
    ad.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
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
      this.zRm.PH(paramString.dJd);
      this.zRn.fa(x.bn("sns_table_", paramString.dJd), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.zRm.PI(paramString.dJd);
      this.zRn.fa("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.zRn.fa("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.zRm.PI(paramString.dJd);
      this.zRn.fa(x.bn("sns_table_", paramString.dJd), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void dZM();
    
    public abstract void fa(String paramString, int paramInt);
    
    public abstract void fb(String paramString, int paramInt);
    
    public abstract void jV(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v
 * JD-Core Version:    0.7.0.1
 */