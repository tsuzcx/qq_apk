package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.h.a.km;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.List;

public final class s
  implements f
{
  String BL;
  int bIj;
  int bIk;
  final Context context;
  public int hQN = 0;
  c kbV = new s.10(this);
  String oOL;
  String oOO;
  boolean oOP = false;
  c oOV = new c() {};
  awd oPA;
  private final String oPB;
  SnsCmdList oPw = new SnsCmdList();
  private final s.a oPx;
  com.tencent.mm.ui.widget.a.d oPy = null;
  boolean oPz;
  n oje;
  public com.tencent.mm.ui.base.p tipDialog = null;
  
  public s(Context paramContext, s.a parama)
  {
    this.context = paramContext;
    this.oPx = parama;
    this.oPB = ((Activity)paramContext).getIntent().getStringExtra("sns_gallery_pre_title");
  }
  
  protected final void D(n paramn)
  {
    if ((paramn.bGF()) || (paramn.bGG()))
    {
      af.bDF().yu(paramn.oLk);
      this.oPw.xz(paramn.oLk);
      return;
    }
    af.bDE().gd(paramn.field_snsId);
    paramn = new r(paramn.field_snsId, 1);
    g.DQ();
    g.DO().dJT.a(paramn, 0);
    Context localContext = this.context;
    this.context.getString(i.j.app_tip);
    this.tipDialog = h.b(localContext, this.context.getString(i.j.sns_deling_sns), true, new s.7(this, paramn));
  }
  
  protected final void Pe(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", paramString);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    com.tencent.mm.plugin.sns.c.a.eUR.l(localIntent, this.context);
  }
  
  public final void a(boolean paramBoolean1, n paramn, awd paramawd, boolean paramBoolean2, int paramInt)
  {
    this.oPz = paramBoolean1;
    this.oje = paramn;
    this.oPA = paramawd;
    this.BL = paramawd.lsK;
    final ArrayList localArrayList1 = new ArrayList();
    final ArrayList localArrayList2 = new ArrayList();
    label139:
    label226:
    do localdo;
    if (paramBoolean1)
    {
      if (paramn == null) {
        return;
      }
      if (paramn.field_localPrivate > 0)
      {
        if ((!bk.bl(af.bDl())) && (af.bDl().equals(paramn.field_userName)))
        {
          localArrayList1.add(this.context.getString(i.j.sns_set_open));
          localArrayList2.add(Integer.valueOf(5));
        }
        localArrayList1.add(this.context.getString(i.j.sns_post_to));
        localArrayList2.add(Integer.valueOf(3));
        if (com.tencent.mm.br.d.SP("favorite"))
        {
          localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramn.field_type != 15) && (paramn.field_type != 5)) {
          break label571;
        }
        localArrayList1.add(this.context.getString(i.j.save_video_to_local));
        localArrayList2.add(Integer.valueOf(2));
        localdo = new do();
        localdo.bJZ.bJQ = paramn.bGE();
        com.tencent.mm.sdk.b.a.udP.m(localdo);
        if (localdo.bKa.bJy)
        {
          localArrayList1.add(this.context.getString(i.j.app_open));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.oOO != null)
        {
          if (!com.tencent.mm.plugin.scanner.a.wM(this.bIj)) {
            break label645;
          }
          localArrayList1.add(this.context.getString(i.j.recog_qbar_of_image_file));
          label333:
          localArrayList2.add(Integer.valueOf(7));
        }
        if ((this.oPy == null) || (!this.oOP)) {
          break label732;
        }
        this.oOP = false;
        label365:
        this.oPy.phH = new n.c()
        {
          public final void a(l paramAnonymousl)
          {
            paramAnonymousl.clear();
            int i = 0;
            while (i < localArrayList1.size())
            {
              paramAnonymousl.e(((Integer)localArrayList2.get(i)).intValue(), (CharSequence)localArrayList1.get(i));
              i += 1;
            }
            paramAnonymousl.e(-1, s.this.context.getString(i.j.sns_del_sns));
          }
        };
        this.oPy.phI = new s.3(this, paramn, paramawd, paramInt);
        this.oPy.wmU = new s.4(this);
        this.oPy.cfU();
      }
    }
    label645:
    for (;;)
    {
      label425:
      if (true == paramBoolean2)
      {
        g.DQ();
        if (g.DO().dJT.KG() == 0) {
          break;
        }
        paramn = new mz();
        paramawd = an.eJ(af.getAccSnsPath(), this.BL) + i.l(paramawd);
        paramn.bWF.filePath = paramawd;
        this.oOL = paramawd;
        com.tencent.mm.sdk.b.a.udP.m(paramn);
        return;
        localArrayList1.add(this.context.getString(i.j.sns_set_private));
        localArrayList2.add(Integer.valueOf(1));
        localArrayList1.add(this.context.getString(i.j.sns_post_to));
        localArrayList2.add(Integer.valueOf(3));
        break label139;
        label571:
        if (paramn.field_type == 1)
        {
          localArrayList1.add(this.context.getString(i.j.save_img_to_local));
          localArrayList2.add(Integer.valueOf(2));
          break label226;
        }
        localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
        localArrayList2.add(Integer.valueOf(2));
        break label226;
        if (com.tencent.mm.plugin.scanner.a.aD(this.bIj, this.oOO))
        {
          localArrayList1.add(this.context.getString(i.j.recog_wxcode_of_image_file));
          break label333;
        }
        if (com.tencent.mm.plugin.scanner.a.wL(this.bIj))
        {
          localArrayList1.add(this.context.getString(i.j.recog_barcode_of_image_file));
          break label333;
        }
        localArrayList1.add(this.context.getString(i.j.recog_qbar_of_image_file));
        break label333;
        label732:
        this.oPy = new com.tencent.mm.ui.widget.a.d(this.context, 1, false);
        break label365;
        paramn.bGe();
        localArrayList1.add(this.context.getString(i.j.sns_post_to));
        localArrayList2.add(Integer.valueOf(3));
        if (com.tencent.mm.br.d.SP("favorite"))
        {
          localArrayList1.add(this.context.getString(i.j.plugin_favorite_opt));
          localArrayList2.add(Integer.valueOf(6));
        }
        if ((paramn.field_type != 15) && (paramn.field_type != 5)) {
          break label1071;
        }
        localArrayList1.add(this.context.getString(i.j.save_video_to_local));
        localArrayList2.add(Integer.valueOf(2));
        label874:
        localdo = new do();
        localdo.bJZ.bJQ = paramn.bGE();
        com.tencent.mm.sdk.b.a.udP.m(localdo);
        if (localdo.bKa.bJy)
        {
          localArrayList1.add(this.context.getString(i.j.app_open));
          localArrayList2.add(Integer.valueOf(8));
        }
        if (this.oOO != null)
        {
          if (!com.tencent.mm.plugin.scanner.a.wM(this.bIj)) {
            break label1145;
          }
          localArrayList1.add(this.context.getString(i.j.recog_qbar_of_image_file));
          label981:
          localArrayList2.add(Integer.valueOf(7));
        }
        if (localArrayList1.size() != 0)
        {
          if ((this.oPy == null) || (!this.oOP)) {
            break label1211;
          }
          this.oOP = false;
        }
      }
    }
    for (;;)
    {
      this.oPy.phH = new s.5(this, localArrayList1, localArrayList2);
      this.oPy.phI = new s.6(this, paramn, paramawd, paramInt);
      this.oPy.cfU();
      break label425;
      break;
      label1071:
      if (paramn.field_type == 1)
      {
        localArrayList1.add(this.context.getString(i.j.save_img_to_local));
        localArrayList2.add(Integer.valueOf(2));
        break label874;
      }
      localArrayList1.add(this.context.getString(i.j.sns_save_to_sns));
      localArrayList2.add(Integer.valueOf(2));
      break label874;
      label1145:
      if (com.tencent.mm.plugin.scanner.a.aD(this.bIj, this.oOO))
      {
        localArrayList1.add(this.context.getString(i.j.recog_wxcode_of_image_file));
        break label981;
      }
      if (!com.tencent.mm.plugin.scanner.a.wL(this.bIj)) {
        break label981;
      }
      localArrayList1.add(this.context.getString(i.j.recog_barcode_of_image_file));
      break label981;
      label1211:
      this.oPy = new com.tencent.mm.ui.widget.a.d(this.context, 1, false);
    }
  }
  
  public final void bHu()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("sns_cmd_list", this.oPw);
    ((Activity)this.context).setResult(-1, localIntent);
    ((Activity)this.context).finish();
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramm == null)) {
      return;
    }
    y.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType() + " @" + hashCode());
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    paramString = (r)paramm;
    switch (paramString.type)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.oPx.cw("", paramString.type);
      return;
    case 1: 
      this.oPw.xz(paramString.onc);
      this.oPx.cw(v.al("sns_table_", paramString.onc), paramString.type);
      return;
    case 2: 
      this.oPw.xA(paramString.onc);
      this.oPx.cw("", paramString.type);
      return;
    }
    this.oPw.xA(paramString.onc);
    this.oPx.cw(v.al("sns_table_", paramString.onc), paramString.type);
  }
  
  public final void yw(int paramInt)
  {
    if (paramInt == 0) {
      return;
    }
    this.oPw.xz(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.s
 * JD-Core Version:    0.7.0.1
 */