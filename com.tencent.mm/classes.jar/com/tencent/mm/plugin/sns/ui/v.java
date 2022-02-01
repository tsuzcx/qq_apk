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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.av;
import com.tencent.mm.g.a.co;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.g.a.ec.b;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class v
  implements f
{
  String AhJ;
  String AhM;
  String AhN;
  String AhO;
  String AhP;
  String AhQ;
  long AhR;
  boolean AhT;
  com.tencent.mm.sdk.b.c AhV;
  e Ahc;
  SnsCmdList Ait;
  private final a Aiu;
  boolean Aiv;
  int Aiw;
  private final String Aix;
  String LS;
  final Context context;
  int dov;
  int dow;
  ScanCodeSheetItemLogic lAg;
  public int nJx;
  com.tencent.mm.sdk.b.c rFa;
  public com.tencent.mm.ui.base.p tipDialog;
  com.tencent.mm.plugin.sns.storage.p zlW;
  bzh zrY;
  
  public v(Context paramContext, a parama)
  {
    AppMethodBeat.i(97910);
    this.Ait = new SnsCmdList();
    this.tipDialog = null;
    this.nJx = 0;
    this.Ahc = null;
    this.Aiw = 0;
    this.AhT = false;
    this.rFa = new com.tencent.mm.sdk.b.c() {};
    this.AhV = new com.tencent.mm.sdk.b.c() {};
    this.context = paramContext;
    this.Aiu = parama;
    this.Aix = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    this.lAg = new ScanCodeSheetItemLogic(paramContext, new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
      {
        AppMethodBeat.i(97895);
        if ((v.this.Ahc != null) && (v.this.Ahc.isShowing()))
        {
          v.this.AhT = true;
          v.this.a(v.this.Aiv, v.this.zlW, v.this.zrY);
        }
        AppMethodBeat.o(97895);
      }
    });
    AppMethodBeat.o(97910);
  }
  
  private void a(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final bzh parambzh, final int paramInt)
  {
    AppMethodBeat.i(97914);
    if ((this.Ahc != null) && (this.AhT)) {
      this.AhT = false;
    }
    for (;;)
    {
      this.Ahc.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(97899);
          v.this.Ahc.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              v.this.Ahc.setFooterView(v.a(v.this, paramp));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.d(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          paramAnonymousl.d(-1, v.this.context.getString(2131763797));
          AppMethodBeat.o(97899);
        }
      };
      this.Ahc.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97902);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ae.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97902);
            return;
            if ((paramp != null) && (paramp.ebP().HUG != null))
            {
              v.a(v.this, paramp, parambzh);
              AppMethodBeat.o(97902);
              return;
              v.b(v.this, paramp, parambzh);
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = v.this;
              Object localObject = new com.tencent.mm.plugin.sns.model.r(paramp.field_snsId, 3);
              g.ajS();
              g.ajQ().gDv.a((n)localObject, 0);
              Context localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new v.2(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.r)localObject));
              AppMethodBeat.o(97902);
              return;
              paramAnonymousMenuItem = v.this;
              localObject = paramp;
              if ((((com.tencent.mm.plugin.sns.storage.p)localObject).ecp()) || (((com.tencent.mm.plugin.sns.storage.p)localObject).ecq()))
              {
                ah.dXE().Rx(((com.tencent.mm.plugin.sns.storage.p)localObject).AdJ);
                AppMethodBeat.o(97902);
                return;
              }
              localObject = new com.tencent.mm.plugin.sns.model.r(((com.tencent.mm.plugin.sns.storage.p)localObject).field_snsId, 2);
              g.ajS();
              g.ajQ().gDv.a((n)localObject, 0);
              localContext = paramAnonymousMenuItem.context;
              paramAnonymousMenuItem.context.getString(2131755906);
              paramAnonymousMenuItem.tipDialog = h.b(localContext, paramAnonymousMenuItem.context.getString(2131763964), true, new v.12(paramAnonymousMenuItem, (com.tencent.mm.plugin.sns.model.r)localObject));
              AppMethodBeat.o(97902);
              return;
              if ((paramp != null) && (paramp.ebP().HUG != null))
              {
                if (paramp.field_type != 15)
                {
                  paramAnonymousMenuItem = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.k(parambzh);
                  if (com.tencent.mm.plugin.sns.data.r.aou(paramAnonymousMenuItem) == 4)
                  {
                    localObject = o.k(paramAnonymousMenuItem, false) + "_tmp";
                    o.aZI(o.aZU((String)localObject));
                    ((com.tencent.mm.plugin.emoji.b.c)g.ab(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(o.k(paramAnonymousMenuItem, false), (String)localObject);
                    com.tencent.mm.pluginsdk.ui.tools.q.j((String)localObject, v.this.context);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  com.tencent.mm.pluginsdk.ui.tools.q.j(paramAnonymousMenuItem, v.this.context);
                  AppMethodBeat.o(97902);
                  return;
                }
                v.aBX(paramp.eco());
                AppMethodBeat.o(97902);
                return;
                if ((paramp != null) && (paramp.ebP().HUG != null))
                {
                  if (paramp.ebP().HUG.Gtw == 1)
                  {
                    paramAnonymousMenuItem = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.k(parambzh);
                    v.this.aBW(paramAnonymousMenuItem);
                    AppMethodBeat.o(97902);
                    return;
                  }
                  v.aBY(paramp.eco());
                  AppMethodBeat.o(97902);
                  return;
                  if (paramp.ebP().HUG.Gtx.size() > 1)
                  {
                    h.a(v.this.context, v.this.context.getString(2131763940), "", new DialogInterface.OnClickListener()
                    {
                      public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        AppMethodBeat.i(97900);
                        v.this.O(v.6.this.Ahf);
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
                      v.this.O(v.6.this.Ahf);
                      AppMethodBeat.o(97901);
                    }
                  }, null);
                  AppMethodBeat.o(97902);
                  return;
                  paramAnonymousMenuItem = new vj();
                  paramAnonymousMenuItem.dKG.mediaId = v.this.LS;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.Ahc.KtV = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(97903);
          Object localObject = new av();
          ((av)localObject).dmJ.dmK = v.this.AhR;
          ((av)localObject).dmJ.filePath = v.this.AhJ;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          v.this.Ahc = null;
          v.this.AhJ = null;
          v.this.zlW = null;
          v.this.LS = null;
          v.this.AhM = null;
          v.this.AhN = null;
          v.this.AhO = null;
          v.this.AhQ = null;
          v.this.AhP = null;
          localObject = v.this;
          v.this.dow = 0;
          ((v)localObject).dov = 0;
          v.this.Aiw = 0;
          AppMethodBeat.o(97903);
        }
      };
      this.Ahc.cPF();
      AppMethodBeat.o(97914);
      return;
      this.Ahc = new e(this.context, 1, false);
    }
  }
  
  private void b(final List<String> paramList, final List<Integer> paramList1, final com.tencent.mm.plugin.sns.storage.p paramp, final bzh parambzh, final int paramInt)
  {
    AppMethodBeat.i(97915);
    if (paramList.size() == 0)
    {
      AppMethodBeat.o(97915);
      return;
    }
    if ((this.Ahc != null) && (this.AhT)) {
      this.AhT = false;
    }
    for (;;)
    {
      this.Ahc.LfS = new n.d()
      {
        public final void onCreateMMMenu(l paramAnonymousl)
        {
          AppMethodBeat.i(97904);
          v.this.Ahc.setFooterView(null);
          paramAnonymousl.clear();
          int i = 0;
          if (i < paramList.size())
          {
            if (((Integer)paramList1.get(i)).intValue() == 7) {
              v.this.Ahc.setFooterView(v.a(v.this, paramp));
            }
            for (;;)
            {
              i += 1;
              break;
              paramAnonymousl.d(((Integer)paramList1.get(i)).intValue(), (CharSequence)paramList.get(i));
            }
          }
          AppMethodBeat.o(97904);
        }
      };
      this.Ahc.LfT = new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(97905);
          paramAnonymousInt = paramAnonymousMenuItem.getItemId();
          ae.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(paramAnonymousInt)));
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(97905);
            return;
            if ((paramp != null) && (paramp.ebP().HUG != null))
            {
              v.a(v.this, paramp, parambzh);
              AppMethodBeat.o(97905);
              return;
              v.b(v.this, paramp, parambzh);
              AppMethodBeat.o(97905);
              return;
              if ((paramp != null) && (paramp.ebP().HUG != null))
              {
                if (paramp.ebP().HUG.Gtw == 1)
                {
                  paramAnonymousMenuItem = ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.k(parambzh);
                  v.this.aBW(paramAnonymousMenuItem);
                  AppMethodBeat.o(97905);
                  return;
                }
                v.aBY(paramp.eco());
                AppMethodBeat.o(97905);
                return;
                if ((paramp != null) && (paramp.ebP().HUG != null))
                {
                  if (paramp.field_type != 15)
                  {
                    com.tencent.mm.pluginsdk.ui.tools.q.j(ap.jv(ah.getAccSnsPath(), parambzh.Id) + com.tencent.mm.plugin.sns.data.r.k(parambzh), v.this.context);
                    AppMethodBeat.o(97905);
                    return;
                  }
                  v.aBX(paramp.eco());
                  AppMethodBeat.o(97905);
                  return;
                  paramAnonymousMenuItem = v.this;
                  long l = paramp.field_snsId;
                  com.tencent.mm.plugin.sns.storage.p localp = ah.dXE().AG(l);
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
                  paramAnonymousMenuItem = new vj();
                  paramAnonymousMenuItem.dKG.mediaId = v.this.LS;
                  com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousMenuItem);
                }
              }
            }
          }
        }
      };
      this.Ahc.cPF();
      AppMethodBeat.o(97915);
      return;
      this.Ahc = new e(this.context, 1, false);
    }
  }
  
  protected final void O(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(97916);
    if ((paramp.ecp()) || (paramp.ecq()))
    {
      ah.dXE().Rx(paramp.AdJ);
      this.Ait.Qo(paramp.AdJ);
      AppMethodBeat.o(97916);
      return;
    }
    ah.dXD().Al(paramp.field_snsId);
    paramp = new com.tencent.mm.plugin.sns.model.r(paramp.field_snsId, 1);
    g.ajS();
    g.ajQ().gDv.a(paramp, 0);
    Context localContext = this.context;
    this.context.getString(2131755906);
    this.tipDialog = h.b(localContext, this.context.getString(2131763798), true, new v.11(this, paramp));
    AppMethodBeat.o(97916);
  }
  
  public final void Rz(int paramInt)
  {
    AppMethodBeat.i(97909);
    if (paramInt == 0)
    {
      AppMethodBeat.o(97909);
      return;
    }
    this.Ait.Qo(paramInt);
    AppMethodBeat.o(97909);
  }
  
  public final void a(boolean paramBoolean, com.tencent.mm.plugin.sns.storage.p paramp, bzh parambzh)
  {
    AppMethodBeat.i(97912);
    a(paramBoolean, paramp, parambzh, false, false, 0);
    AppMethodBeat.o(97912);
  }
  
  public final void a(boolean paramBoolean1, com.tencent.mm.plugin.sns.storage.p paramp, bzh parambzh, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    AppMethodBeat.i(97913);
    this.Aiv = paramBoolean1;
    this.zlW = paramp;
    this.zrY = parambzh;
    this.LS = parambzh.Id;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ec localec;
    if (paramBoolean1)
    {
      if (paramp == null)
      {
        AppMethodBeat.o(97913);
        return;
      }
      if (paramp.field_localPrivate > 0)
      {
        if ((!bu.isNullOrNil(ah.dXj())) && (ah.dXj().equals(paramp.field_userName)))
        {
          localArrayList1.add(this.context.getString(2131763967));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131763948));
        localArrayList2.add(Integer.valueOf(3));
        if (d.aJN("favorite"))
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
        localec = new ec();
        localec.dql.dqc = paramp.eco();
        com.tencent.mm.sdk.b.a.IvT.l(localec);
        if (localec.dqm.dpK)
        {
          localArrayList1.add(this.context.getString(2131755836));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.AhM != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        a(localArrayList1, localArrayList2, paramp, parambzh, paramInt);
        if (true == paramBoolean3)
        {
          g.ajS();
          if (g.ajQ().gDv.aFd() != 0)
          {
            paramp = new qd();
            parambzh = ap.jv(ah.getAccSnsPath(), this.LS) + com.tencent.mm.plugin.sns.data.r.k(parambzh);
            paramp.dFH.filePath = parambzh;
            this.AhR = System.currentTimeMillis();
            paramp.dFH.dmK = this.AhR;
            this.AhJ = parambzh;
            com.tencent.mm.sdk.b.a.IvT.l(paramp);
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
    paramp.ebP();
    localArrayList1.add(this.context.getString(2131763948));
    localArrayList2.add(Integer.valueOf(3));
    if (d.aJN("favorite"))
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
      localec = new ec();
      localec.dql.dqc = paramp.eco();
      com.tencent.mm.sdk.b.a.IvT.l(localec);
      if (localec.dqm.dpK)
      {
        localArrayList1.add(this.context.getString(2131755836));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.AhM != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
      b(localArrayList1, localArrayList2, paramp, parambzh, paramInt);
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
  
  protected final void aBW(String paramString)
  {
    AppMethodBeat.i(97917);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.iUz.k(localIntent, this.context);
    AppMethodBeat.o(97917);
  }
  
  public final void edr()
  {
    AppMethodBeat.i(97911);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.Ait);
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
    ae.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (com.tencent.mm.plugin.sns.model.r)paramn;
    switch (paramString.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(97918);
      return;
      this.Ait.Qo(paramString.dKr);
      this.Aiu.fj(x.bo("sns_table_", paramString.dKr), paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.Ait.Qp(paramString.dKr);
      this.Aiu.fj("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.Aiu.fj("", paramString.type);
      AppMethodBeat.o(97918);
      return;
      this.Ait.Qp(paramString.dKr);
      this.Aiu.fj(x.bo("sns_table_", paramString.dKr), paramString.type);
    }
  }
  
  public static abstract interface a
  {
    public abstract void eds();
    
    public abstract void fj(String paramString, int paramInt);
    
    public abstract void fk(String paramString, int paramInt);
    
    public abstract void kc(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.v
 * JD-Core Version:    0.7.0.1
 */