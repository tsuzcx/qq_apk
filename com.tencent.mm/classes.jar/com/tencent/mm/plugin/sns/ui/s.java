package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.dr;
import com.tencent.mm.g.a.dr.b;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.a.ny;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.List;

public final class s
  implements f
{
  String Cu;
  final Context context;
  int cpE;
  int cpF;
  public int jKp;
  c mwt;
  com.tencent.mm.plugin.sns.storage.n qXp;
  String rGA;
  String rGB;
  boolean rGC;
  c rGI;
  String rGw;
  String rGz;
  SnsCmdList rHi;
  private final s.a rHj;
  com.tencent.mm.ui.widget.b.d rHk;
  boolean rHl;
  bcs rHm;
  private final String rHn;
  public com.tencent.mm.ui.base.p tipDialog;
  
  public s(Context paramContext, s.a parama)
  {
    AppMethodBeat.i(38263);
    this.rHi = new SnsCmdList();
    this.tipDialog = null;
    this.jKp = 0;
    this.rHk = null;
    this.rGC = false;
    this.mwt = new c() {};
    this.rGI = new s.3(this);
    this.context = paramContext;
    this.rHj = parama;
    this.rHn = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
    AppMethodBeat.o(38263);
  }
  
  protected final void C(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(38266);
    if ((paramn.csI()) || (paramn.csJ()))
    {
      ag.cpf().EA(paramn.rCV);
      this.rHi.Dz(paramn.rCV);
      AppMethodBeat.o(38266);
      return;
    }
    ag.cpe().lI(paramn.field_snsId);
    paramn = new r(paramn.field_snsId, 1);
    g.RM();
    g.RK().eHt.a(paramn, 0);
    Context localContext = this.context;
    this.context.getString(2131297087);
    this.tipDialog = h.b(localContext, this.context.getString(2131303795), true, new s.10(this, paramn));
    AppMethodBeat.o(38266);
  }
  
  public final void EC(int paramInt)
  {
    AppMethodBeat.i(38262);
    if (paramInt == 0)
    {
      AppMethodBeat.o(38262);
      return;
    }
    this.rHi.Dz(paramInt);
    AppMethodBeat.o(38262);
  }
  
  public final void a(boolean paramBoolean1, final com.tencent.mm.plugin.sns.storage.n paramn, bcs parambcs, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(38265);
    this.rHl = paramBoolean1;
    this.qXp = paramn;
    this.rHm = parambcs;
    this.Cu = parambcs.Id;
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    label238:
    dr localdr;
    if (paramBoolean1)
    {
      if (paramn == null)
      {
        AppMethodBeat.o(38265);
        return;
      }
      if (paramn.field_localPrivate > 0)
      {
        if ((!bo.isNullOrNil(ag.coK())) && (ag.coK().equals(paramn.field_userName)))
        {
          localArrayList1.add(this.context.getString(2131303953));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(2131303934));
        localArrayList2.add(Integer.valueOf(3));
        if (com.tencent.mm.bq.d.ahR("favorite"))
        {
          localArrayList1.add(this.context.getString(2131302102));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramn.field_type != 15) && (paramn.field_type != 5)) {
          break label573;
        }
        localArrayList1.add(this.context.getString(2131302872));
        localArrayList2.add(Integer.valueOf(2));
        localdr = new dr();
        localdr.crt.crk = paramn.csH();
        com.tencent.mm.sdk.b.a.ymk.l(localdr);
        if (localdr.cru.cqS)
        {
          localArrayList1.add(this.context.getString(2131297019));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.rGz != null)
        {
          localArrayList1.add("");
          localArrayList2.add(Integer.valueOf(7));
        }
        if ((this.rHk == null) || (!this.rGC)) {
          break label647;
        }
        this.rGC = false;
        label360:
        this.rHk.sao = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(38248);
            s.this.rHk.setFooterView(null);
            paramAnonymousl.clear();
            int i = 0;
            if (i < localArrayList1.size())
            {
              if (((Integer)localArrayList2.get(i)).intValue() == 7) {
                s.this.rHk.setFooterView(s.a(s.this, paramn));
              }
              for (;;)
              {
                i += 1;
                break;
                paramAnonymousl.e(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
              }
            }
            paramAnonymousl.e(-1, s.this.context.getString(2131303794));
            AppMethodBeat.o(38248);
          }
        };
        this.rHk.sap = new s.5(this, paramn, parambcs, paramInt);
        this.rHk.AGQ = new s.6(this);
        this.rHk.crd();
      }
    }
    label573:
    do
    {
      if (true == paramBoolean2)
      {
        g.RM();
        if (g.RK().eHt.adt() != 0)
        {
          paramn = new nw();
          parambcs = ao.gl(ag.getAccSnsPath(), this.Cu) + i.l(parambcs);
          paramn.cEv.filePath = parambcs;
          this.rGw = parambcs;
          com.tencent.mm.sdk.b.a.ymk.l(paramn);
        }
      }
      AppMethodBeat.o(38265);
      return;
      localArrayList1.add(this.context.getString(2131303954));
      localArrayList2.add(Integer.valueOf(1));
      localArrayList1.add(this.context.getString(2131303934));
      localArrayList2.add(Integer.valueOf(3));
      break;
      if (paramn.field_type == 1)
      {
        localArrayList1.add(this.context.getString(2131302869));
        localArrayList2.add(Integer.valueOf(2));
        break label238;
      }
      localArrayList1.add(this.context.getString(2131303939));
      localArrayList2.add(Integer.valueOf(2));
      break label238;
      this.rHk = new com.tencent.mm.ui.widget.b.d(this.context, 1, false);
      break label360;
      paramn.csh();
      localArrayList1.add(this.context.getString(2131303934));
      localArrayList2.add(Integer.valueOf(3));
      if (com.tencent.mm.bq.d.ahR("favorite"))
      {
        localArrayList1.add(this.context.getString(2131302102));
        localArrayList2.add(Integer.valueOf(6));
      }
      if ((paramn.field_type != 15) && (paramn.field_type != 5)) {
        break label970;
      }
      localArrayList1.add(this.context.getString(2131302872));
      localArrayList2.add(Integer.valueOf(2));
      localdr = new dr();
      localdr.crt.crk = paramn.csH();
      com.tencent.mm.sdk.b.a.ymk.l(localdr);
      if (localdr.cru.cqS)
      {
        localArrayList1.add(this.context.getString(2131297019));
        localArrayList2.add(Integer.valueOf(8));
      }
      if (this.rGz != null)
      {
        localArrayList1.add("");
        localArrayList2.add(Integer.valueOf(7));
      }
    } while (localArrayList1.size() == 0);
    label647:
    label789:
    if ((this.rHk != null) && (this.rGC)) {
      this.rGC = false;
    }
    for (;;)
    {
      this.rHk.sao = new s.7(this, localArrayList1, localArrayList2, paramn);
      this.rHk.sap = new s.8(this, paramn, parambcs, paramInt);
      this.rHk.crd();
      break;
      label970:
      if (paramn.field_type == 1)
      {
        localArrayList1.add(this.context.getString(2131302869));
        localArrayList2.add(Integer.valueOf(2));
        break label789;
      }
      localArrayList1.add(this.context.getString(2131303939));
      localArrayList2.add(Integer.valueOf(2));
      break label789;
      this.rHk = new com.tencent.mm.ui.widget.b.d(this.context, 1, false);
    }
  }
  
  protected final void abY(String paramString)
  {
    AppMethodBeat.i(38267);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.gmO.k(localIntent, this.context);
    AppMethodBeat.o(38267);
  }
  
  public final void ctz()
  {
    AppMethodBeat.i(38264);
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.rHi);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
    AppMethodBeat.o(38264);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(38268);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm == null))
    {
      AppMethodBeat.o(38268);
      return;
    }
    ab.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (r)paramm;
    switch (paramString.type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(38268);
      return;
      this.rHi.Dz(paramString.cIp);
      this.rHj.ds(v.aF("sns_table_", paramString.cIp), paramString.type);
      AppMethodBeat.o(38268);
      return;
      this.rHi.DA(paramString.cIp);
      this.rHj.ds("", paramString.type);
      AppMethodBeat.o(38268);
      return;
      this.rHj.ds("", paramString.type);
      AppMethodBeat.o(38268);
      return;
      this.rHi.DA(paramString.cIp);
      this.rHj.ds(v.aF("sns_table_", paramString.cIp), paramString.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s
 * JD-Core Version:    0.7.0.1
 */