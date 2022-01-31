package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ah.i;
import com.tencent.mm.at.q;
import com.tencent.mm.g.a.oa;
import com.tencent.mm.g.a.oa.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.j.a;
import com.tencent.mm.pluginsdk.model.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

final class d$c
  extends c.a
{
  public static int[] mEF = { 2131822717, 2131822718, 2131822719, 2131822720, 2131822721 };
  protected TextView gpL;
  protected TextView gpM;
  protected TextView mCZ;
  private ArrayList<MMImageView> rJU;
  protected MMImageView zRM;
  protected ImageView zRN;
  protected ImageView zRO;
  protected TextView zRP;
  protected LinearLayout zRQ;
  protected TextView zRR;
  protected ImageView zRS;
  protected MMPinProgressBtn zRT;
  protected ImageView zRU;
  protected ImageView zRV;
  protected ImageView zRW;
  protected ImageView zRX;
  protected TextView zRY;
  protected ChattingItemFooter zRZ;
  TextView zSA;
  ImageView zSB;
  ImageView zSC;
  ImageView zSD;
  TextView zSE;
  ImageView zSF;
  LinearLayout zSG;
  MMNeat7extView zSH;
  ImageView zSI;
  ImageView zSJ;
  ImageView zSK;
  TextView zSL;
  TextView zSM;
  public int zSN;
  private int zSO;
  protected ImageView zSa;
  protected LinearLayout zSb;
  protected ViewGroup zSc;
  protected TextView zSd;
  protected LinearLayout zSe;
  protected RelativeLayout zSf;
  protected FrameLayout zSg;
  protected LinearLayout zSh;
  protected LinearLayout zSi;
  protected ViewStub zSj;
  protected ImageView zSk;
  protected ImageView zSl;
  ImageView zSm;
  protected LinearLayout zSn;
  protected ImageView zSo;
  protected TextView zSp;
  protected ImageView zSq;
  protected TextView zSr;
  protected TextView zSs;
  protected LinearLayout zSt;
  protected ImageView zSu;
  protected ImageView zSv;
  protected TextView zSw;
  protected LinearLayout zSx;
  LinearLayout zSy;
  TextView zSz;
  
  d$c()
  {
    AppMethodBeat.i(32813);
    this.zSN = 0;
    this.zSO = 2147483647;
    this.rJU = new ArrayList();
    AppMethodBeat.o(32813);
  }
  
  private static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, int paramInt, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int[] paramArrayOfInt1, String[] paramArrayOfString4, String[] paramArrayOfString5, int[] paramArrayOfInt2, String paramString)
  {
    AppMethodBeat.i(32821);
    int i = 0;
    while (i <= 4)
    {
      localObject1 = (MMImageView)paramc.zSi.findViewById(mEF[i]);
      if (localObject1 != null)
      {
        ((MMImageView)localObject1).setImageDrawable(null);
        ((MMImageView)localObject1).setVisibility(8);
      }
      i += 1;
    }
    Object localObject1 = (ImageView)paramc.zSi.findViewById(2131822722);
    Object localObject2 = (TextView)paramc.zSi.findViewById(2131822723);
    if (localObject1 != null) {
      ((ImageView)localObject1).setVisibility(8);
    }
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(8);
    }
    i = 0;
    if (i < paramInt)
    {
      label150:
      Object localObject3;
      if (paramInt == 1)
      {
        localObject1 = (MMImageView)paramc.zSi.findViewById(mEF[i]);
        ((MMImageView)localObject1).setImageResource(2131231127);
        ((MMImageView)localObject1).setVisibility(0);
        al.dlK().a((j.a)parama.ay(com.tencent.mm.ui.chatting.c.b.h.class), paramArrayOfString1[i], bo.aoy(), paramArrayOfString2[i], paramArrayOfString3[i], paramArrayOfInt1[i], paramString);
        localObject2 = com.tencent.mm.at.o.ahC().q("Note_" + paramArrayOfString1[i], "", "");
        localObject3 = new com.tencent.mm.at.a.a.c.a();
        ((com.tencent.mm.at.a.a.c.a)localObject3).fHt = 1;
        ((com.tencent.mm.at.a.a.c.a)localObject3).eOf = true;
        ((com.tencent.mm.at.a.a.c.a)localObject3).eOa = 2131231126;
        ((com.tencent.mm.at.a.a.c.a)localObject3).eNS = ((int)parama.zJz.getMMResources().getDimension(2131427523));
        ((com.tencent.mm.at.a.a.c.a)localObject3).eNT = ((int)parama.zJz.getMMResources().getDimension(2131427523));
        localObject3 = ((com.tencent.mm.at.a.a.c.a)localObject3).ahY();
        if (!com.tencent.mm.vfs.e.cN((String)localObject2)) {
          break label357;
        }
        com.tencent.mm.at.o.ahG().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.at.a.a.c)localObject3);
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = (MMImageView)paramc.zSi.findViewById(mEF[(i + 1)]);
        ((MMImageView)localObject1).setImageResource(2131231126);
        break label150;
        label357:
        al.dlK().a((j.a)parama.ay(com.tencent.mm.ui.chatting.c.b.h.class), paramArrayOfString1[i], bo.aoy(), paramArrayOfString4[i], paramArrayOfString5[i], paramArrayOfInt2[i], paramString);
        com.tencent.mm.at.o.ahC().q("Note_" + paramArrayOfString1[i], "", "");
        com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 45);
        if (com.tencent.mm.vfs.e.cN((String)localObject2)) {
          com.tencent.mm.at.o.ahG().a((String)localObject2, (ImageView)localObject1, (com.tencent.mm.at.a.a.c)localObject3);
        } else {
          ab.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
        }
      }
    }
    AppMethodBeat.o(32821);
  }
  
  static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, j.b paramb, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(32819);
    paramc.zSh.setVisibility(8);
    paramc.zSG.setVisibility(0);
    Object localObject1;
    int i;
    label91:
    Object localObject2;
    if ((paramb.title != null) && (paramb.title.length() > 0))
    {
      paramc.zSH.setMaxLines(2);
      paramc.zSH.setVisibility(0);
      paramc.zSH.af(paramb.getTitle());
      localObject1 = (com.tencent.mm.af.e)paramb.R(com.tencent.mm.af.e.class);
      if (localObject1 == null) {
        break label450;
      }
      i = ((com.tencent.mm.af.e)localObject1).duration;
      localObject2 = com.tencent.mm.af.l.kq(i);
      if (bo.isNullOrNil((String)localObject2)) {
        break label456;
      }
      paramc.zSM.setVisibility(0);
      paramc.zSM.setText((CharSequence)localObject2);
      label123:
      paramc.zSK.setVisibility(0);
      if ((localObject1 != null) && (com.tencent.mm.af.s.kr(((com.tencent.mm.af.e)localObject1).fgk)))
      {
        paramc.zSM.setVisibility(8);
        paramc.zSK.setVisibility(8);
      }
      a.b.s(paramc.zSJ, paramb.cGN);
      localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramb.cGN);
      if ((localObject1 != null) && ((int)((com.tencent.mm.n.a)localObject1).euF > 0)) {
        break label468;
      }
      localObject1 = paramb.cGO;
      paramc.zSJ.setTag(paramb.cGN);
      localObject2 = new WeakReference(paramc.zSJ);
      ao.a.flI.a(paramb.cGN, "", new d.c.3((WeakReference)localObject2));
    }
    for (;;)
    {
      paramc.zSL.setText(com.tencent.mm.pluginsdk.ui.d.j.b(parama.zJz.getContext(), (CharSequence)localObject1, paramc.zSL.getTextSize()));
      paramc.zRS.setVisibility(4);
      i = com.tencent.mm.cb.a.ao(parama.zJz.getContext(), 2131428227) - com.tencent.mm.cb.a.fromDPToPix(parama.zJz.getContext(), 24);
      int j = i * 9 / 16;
      if ((!paramBoolean) && (bo.isNullOrNil(paramb.thumburl))) {
        break label582;
      }
      parama = q.ts(paramb.thumburl);
      paramb = new com.tencent.mm.at.a.a.c.a();
      paramb.eNY = 2131689878;
      paramb.eNL = true;
      paramb.eNO = p.aln(parama);
      parambi = paramb.cx(i, j);
      parambi.fHk = new f();
      parambi.eNK = true;
      com.tencent.mm.at.o.ahG().a(parama, paramc.zSI, paramb.ahY());
      AppMethodBeat.o(32819);
      return;
      paramc.zSH.setVisibility(8);
      break;
      label450:
      i = 0;
      break label91;
      label456:
      paramc.zSM.setVisibility(8);
      break label123;
      label468:
      if ((!com.tencent.mm.n.a.je(((aq)localObject1).field_type)) && (com.tencent.mm.ah.b.b(paramb.cGN, false, -1) == null))
      {
        localObject2 = com.tencent.mm.ah.o.adg().rj(paramb.cGN);
        if ((localObject2 != null) && (!bo.isNullOrNil(((com.tencent.mm.ah.h)localObject2).acY()))) {
          com.tencent.mm.plugin.brandservice.b.a.a(paramc.zSJ, (ad)localObject1, ((com.tencent.mm.ah.h)localObject2).acY(), true);
        }
      }
      localObject2 = com.tencent.mm.model.s.nE(paramb.cGN);
      localObject1 = localObject2;
      if (bo.isEqual((String)localObject2, paramb.cGN))
      {
        localObject1 = localObject2;
        if (!bo.isNullOrNil(paramb.cGO)) {
          localObject1 = paramb.cGO;
        }
      }
    }
    label582:
    paramb = null;
    if (!d.b.aum(parambi.field_imgPath)) {
      paramb = com.tencent.mm.at.o.ahC().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(parama.zJz.getContext()), false);
    }
    if ((paramb != null) && (!paramb.isRecycled()))
    {
      paramc.zSI.setImageBitmap(paramb);
      AppMethodBeat.o(32819);
      return;
    }
    paramc.zSI.setImageResource(2131689878);
    AppMethodBeat.o(32819);
  }
  
  static void a(com.tencent.mm.ui.chatting.d.a parama, c paramc, j.b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(32818);
    paramc.gpL.setVisibility(8);
    String str;
    Object localObject1;
    Object localObject3;
    label221:
    Object localObject2;
    int i;
    if ((paramb.title != null) && (paramb.title.trim().length() > 0))
    {
      str = paramb.title;
      paramc.zRR.setVisibility(0);
      paramc.zRR.setMaxLines(2);
      paramc.gpM.setMaxLines(4);
      paramc.zRX.setVisibility(8);
      paramc.zRS.setVisibility(4);
      if (paramBoolean) {
        paramc.zRM.setVisibility(8);
      }
      localObject1 = new oa();
      ((oa)localObject1).cEz.type = 0;
      ((oa)localObject1).cEz.cEB = paramb.fhc;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject3 = ((oa)localObject1).cEA.cEK;
      if (localObject3 == null) {
        break label1006;
      }
      localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramc.zRR.getContext(), bo.bf(((com.tencent.mm.protocal.b.a.c)localObject3).title, paramb.title), paramc.zRR.getTextSize());
      paramc.zRR.setText((CharSequence)localObject1);
      localObject1 = ((com.tencent.mm.protocal.b.a.c)localObject3).desc;
      if (localObject1 != null) {
        break label510;
      }
      ab.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[] { paramb.fhc });
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 100) {
          localObject2 = ((String)localObject1).substring(0, 100);
        }
      }
      paramc.gpM.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramc.gpM.getContext(), bo.bf((String)localObject2, paramb.description), paramc.gpM.getTextSize()));
      paramb = ((com.tencent.mm.protocal.b.a.c)localObject3).fjy.iterator();
      i = 0;
      localObject2 = null;
      localObject1 = null;
      label305:
      do
      {
        if (!paramb.hasNext()) {
          break;
        }
        localObject3 = (aca)paramb.next();
      } while ((!bo.isNullOrNil(((aca)localObject3).wSR)) && (((aca)localObject3).wSR.equals(".htm")) && (!bo.isNullOrNil(((aca)localObject3).wTE)) && (((aca)localObject3).wTE.equals("WeNoteHtmlFile")));
      if (((aca)localObject3).wTw.wUb.wUA == null) {
        break label535;
      }
      str = parama.zJz.getContext().getString(2131302353);
      i = 1;
      label407:
      switch (((aca)localObject3).dataType)
      {
      }
    }
    for (;;)
    {
      break label305;
      paramc.zRR.setVisibility(8);
      str = null;
      break;
      label510:
      localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
      break label221;
      label535:
      if (((aca)localObject3).wTw.wUb.czp == null) {
        break label1003;
      }
      if (localObject1 == null)
      {
        localObject1 = ((aca)localObject3).wTy;
        break label407;
      }
      if (localObject1 == ((aca)localObject3).wTy) {
        break label1003;
      }
      localObject2 = ((aca)localObject3).wTy;
      break label407;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2131230828);
      }
      break label305;
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2130837708);
      }
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2131230829);
      }
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2131230826);
      }
      paramc.zRX.setVisibility(0);
      paramc.zRX.setImageResource(2130840655);
      break label305;
      paramc.zRM.setVisibility(0);
      paramc.zRM.setImageResource(2131230807);
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2131230809);
      }
      paramc.zRX.setVisibility(0);
      paramc.zRX.setImageResource(2130839753);
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(d.akU(((aca)localObject3).wSR));
      }
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2131230822);
      }
      break label305;
      if (paramBoolean)
      {
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2130838493);
      }
    }
    if ((localObject1 != null) && (localObject2 == null) && (i == 0)) {
      paramb = parama.zJz.getContext().getString(2131299790, new Object[] { localObject1 });
    }
    for (;;)
    {
      if (!bo.isNullOrNil(paramb))
      {
        paramc.zRR.setText(paramb);
        paramc.zRR.setVisibility(0);
      }
      paramc.zRM.setVisibility(8);
      paramc.zSf.setVisibility(8);
      AppMethodBeat.o(32818);
      return;
      paramb = str;
      if (localObject1 != null)
      {
        paramb = str;
        if (localObject2 != null)
        {
          paramb = str;
          if (!((String)localObject1).equals(localObject2))
          {
            paramb = str;
            if (i == 0)
            {
              paramb = parama.zJz.getContext().getString(2131299789, new Object[] { localObject1, localObject2 });
              continue;
              label1003:
              break;
              label1006:
              paramb = str;
            }
          }
        }
      }
    }
  }
  
  public static void a(c paramc, Boolean paramBoolean, bi parambi, String paramString1, String paramString2)
  {
    AppMethodBeat.i(32817);
    long l = parambi.field_msgId;
    com.tencent.mm.pluginsdk.model.app.b localb = al.aUJ().nw(l);
    if (localb == null)
    {
      ab.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[] { Long.valueOf(l), paramString2 });
      AppMethodBeat.o(32817);
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (localb.field_status == 101L)
      {
        paramc.zRW.setVisibility(0);
        paramc.zRT.setVisibility(0);
        paramc.zRU.setVisibility(0);
      }
    }
    for (;;)
    {
      if (parambi.field_status == 5)
      {
        paramc.zRW.setVisibility(8);
        paramc.zRV.setVisibility(8);
      }
      paramc.zRW.setOnClickListener(new d.c.1(paramBoolean, l, paramString1, paramString2, parambi));
      paramc.zRV.setOnClickListener(new d.c.2(paramBoolean, l, paramString2, parambi));
      AppMethodBeat.o(32817);
      return;
      if (localb.field_status == 102L)
      {
        paramc.zRW.setVisibility(8);
        paramc.zRT.setVisibility(8);
        paramc.zRU.setVisibility(8);
      }
      else
      {
        paramc.zRW.setVisibility(8);
        paramc.zRT.setVisibility(8);
        paramc.zRU.setVisibility(8);
        continue;
        if (localb.field_status == 101L)
        {
          paramc.zRW.setVisibility(0);
          paramc.zRV.setVisibility(8);
        }
        else if (localb.field_status == 105L)
        {
          paramc.zRW.setVisibility(8);
          paramc.zRV.setVisibility(0);
        }
        else
        {
          paramc.zRW.setVisibility(8);
          paramc.zRV.setVisibility(8);
        }
      }
    }
  }
  
  public static void a(c paramc, String paramString, int paramInt)
  {
    AppMethodBeat.i(32816);
    int i = com.tencent.mm.pluginsdk.model.app.l.alu(paramString);
    if ((i == -1) || (i >= 100) || (paramInt <= 0))
    {
      paramc.zRT.setVisibility(8);
      paramc.zRU.setVisibility(8);
      AppMethodBeat.o(32816);
      return;
    }
    paramc.zRT.setVisibility(0);
    paramc.zRU.setVisibility(0);
    paramc.zRT.setProgress(i);
    AppMethodBeat.o(32816);
  }
  
  static void b(com.tencent.mm.ui.chatting.d.a parama, c paramc, j.b paramb, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(32820);
    Object localObject1 = new oa();
    ((oa)localObject1).cEz.type = 0;
    ((oa)localObject1).cEz.cEB = paramb.fhc;
    com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
    Object localObject2 = ((oa)localObject1).cEA.cEK;
    paramc.zSf.setVisibility(8);
    String[] arrayOfString1 = new String[4];
    String[] arrayOfString2 = new String[4];
    int[] arrayOfInt1 = new int[4];
    String[] arrayOfString3 = new String[4];
    String[] arrayOfString4 = new String[4];
    int[] arrayOfInt2 = new int[4];
    String[] arrayOfString5 = new String[4];
    int k;
    Object localObject3;
    int i;
    Object localObject4;
    label264:
    String str;
    if (localObject2 != null)
    {
      localObject1 = null;
      paramb = bo.bf(((com.tencent.mm.protocal.b.a.c)localObject2).desc, paramb.description);
      k = 0;
      localObject3 = ((com.tencent.mm.protocal.b.a.c)localObject2).fjy.iterator();
      i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aca)((Iterator)localObject3).next();
        if ((bo.isNullOrNil(((aca)localObject4).wSR)) || (!((aca)localObject4).wSR.equals(".htm")) || (bo.isNullOrNil(((aca)localObject4).wTE)) || (!((aca)localObject4).wTE.equals("WeNoteHtmlFile"))) {
          switch (((aca)localObject4).dataType)
          {
          case 3: 
          case 6: 
          case 4: 
          case 5: 
          case 7: 
          default: 
          case 1: 
            do
            {
              do
              {
                break;
              } while (k != 0);
              str = ((aca)localObject4).desc;
            } while (bo.isNullOrNil(str));
            if (bo.isNullOrNil(str.replaceAll("\n", "").trim())) {
              break label1227;
            }
            localObject1 = ((aca)localObject4).desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
        }
      }
    }
    label807:
    label1218:
    label1221:
    label1227:
    for (;;)
    {
      k = 1;
      break;
      if (paramBoolean)
      {
        paramc.zSf.setVisibility(0);
        paramc.zRM.setVisibility(0);
        paramc.zRM.setImageResource(2130837708);
      }
      if (i < 4)
      {
        arrayOfString1[i] = ((aca)localObject4).fgM;
        arrayOfString2[i] = ((aca)localObject4).wSy;
        arrayOfInt1[i] = ((int)((aca)localObject4).wTi);
        arrayOfString3[i] = ((aca)localObject4).wSC;
        arrayOfString4[i] = ((aca)localObject4).wSE;
        arrayOfInt2[i] = ((int)((aca)localObject4).wSX);
        arrayOfString5[i] = ((aca)localObject4).mBq;
      }
      i += 1;
      break;
      if (!bo.isNullOrNil(paramb)) {
        break label264;
      }
      paramb = ah.getContext().getString(2131296962) + ((aca)localObject4).title;
      break label264;
      if (localObject1 != null)
      {
        localObject4 = ((String)localObject1).split("\n", 2);
        localObject3 = new ArrayList();
        if (localObject4.length > 0)
        {
          int m = localObject4.length;
          j = 0;
          while (j < m)
          {
            str = localObject4[j];
            if (str.length() > 0) {
              ((ArrayList)localObject3).add(str);
            }
            j += 1;
          }
        }
        if (((ArrayList)localObject3).size() != 1) {
          break label1221;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((((ArrayList)localObject3).size() == 1) && (((com.tencent.mm.protocal.b.a.c)localObject2).fjy.size() == 2))
        {
          localObject2 = ah.getContext().getString(2131299857);
          paramb = (j.b)localObject1;
          localObject1 = localObject2;
          localObject1 = ((String)localObject1).trim();
          label632:
          if (localObject1 == null) {
            break label1218;
          }
          localObject1 = ((String)localObject1).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
        }
        for (;;)
        {
          localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramc.zRR.getContext(), (CharSequence)localObject1, (int)paramc.zRR.getTextSize());
          paramc.zRR.setText((CharSequence)localObject1);
          if ((paramb != null) && (paramb.length() > 100)) {
            paramb = paramb.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
          }
          for (;;)
          {
            for (;;)
            {
              localObject1 = com.tencent.mm.pluginsdk.ui.d.j.b(paramc.gpM.getContext(), paramb, (int)paramc.gpM.getTextSize());
              paramc.gpM.setText((CharSequence)localObject1);
              if (i > 0)
              {
                paramc.zSf.setVisibility(8);
                if ((j != 0) || (k == 0) || (bo.isNullOrNil(paramb)))
                {
                  paramc.gpM.setVisibility(8);
                  paramc.zRR.setMaxLines(2);
                  paramc.zSk.setVisibility(8);
                  paramc.zSj.setLayoutResource(2130969096);
                }
                try
                {
                  if (paramc.zSi == null) {
                    paramc.zSi = ((LinearLayout)paramc.zSj.inflate());
                  }
                  for (;;)
                  {
                    if (i <= 4) {
                      break label1184;
                    }
                    j = 4;
                    a(parama, paramc, j, arrayOfString5, arrayOfString2, arrayOfString1, arrayOfInt1, arrayOfString4, arrayOfString3, arrayOfInt2, parambi.field_talker);
                    parama = (ImageView)paramc.zSi.findViewById(2131822722);
                    paramc = (TextView)paramc.zSi.findViewById(2131822723);
                    if (paramc != null) {
                      paramc.setTextSize(0, ah.getContext().getResources().getDimensionPixelSize(2131427854));
                    }
                    if (i > 4)
                    {
                      if (parama != null) {
                        parama.setVisibility(0);
                      }
                      if (paramc != null)
                      {
                        paramc.setText("(" + i + ")");
                        paramc.setVisibility(0);
                      }
                    }
                    AppMethodBeat.o(32820);
                    return;
                    if (i > 0)
                    {
                      localObject1 = (String)((ArrayList)localObject3).get(0);
                      if (((ArrayList)localObject3).size() > 1)
                      {
                        paramb = (String)((ArrayList)localObject3).get(1);
                        break;
                      }
                      paramb = null;
                      break;
                    }
                    localObject2 = (String)((ArrayList)localObject3).get(0);
                    localObject3 = paramb.split(Pattern.quote((String)localObject2), 2);
                    paramb = localObject3[0].trim();
                    localObject1 = localObject2;
                    if (localObject3.length <= 1) {
                      break;
                    }
                    paramb = (localObject3[0].trim() + "\n" + localObject3[1].trim()).trim();
                    localObject1 = localObject2;
                    break;
                    localObject1 = ah.getContext().getString(2131299857);
                    j = 0;
                    break label632;
                    paramc.gpM.setMaxLines(1);
                    paramc.gpM.setVisibility(0);
                    paramc.zRR.setMaxLines(1);
                    break label807;
                    paramc.zSi.setVisibility(0);
                  }
                }
                catch (Exception paramb)
                {
                  for (;;)
                  {
                    paramc.zSj.setVisibility(0);
                    continue;
                    j = i;
                  }
                }
              }
            }
            paramc.zSj.setVisibility(8);
            paramc.zSk.setVisibility(0);
            AppMethodBeat.o(32820);
            return;
          }
        }
      }
    }
  }
  
  public final void reset()
  {
    AppMethodBeat.i(32815);
    if (this.zRR != null) {
      this.zRR.setMaxLines(this.zSO);
    }
    AppMethodBeat.o(32815);
  }
  
  public final c z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(32814);
    super.eV(paramView);
    this.zSx = ((LinearLayout)paramView.findViewById(2131822587));
    this.zRM = ((MMImageView)paramView.findViewById(2131822600));
    this.gpL = ((TextView)paramView.findViewById(2131822597));
    this.zRR = ((TextView)paramView.findViewById(2131822595));
    this.gpM = ((TextView)paramView.findViewById(2131822598));
    this.mCZ = ((TextView)paramView.findViewById(2131822607));
    this.zRN = ((ImageView)paramView.findViewById(2131822606));
    this.zRP = ((TextView)paramView.findViewById(2131822609));
    this.zRO = ((ImageView)paramView.findViewById(2131822608));
    this.zRQ = ((LinearLayout)paramView.findViewById(2131822605));
    this.zRS = ((ImageView)paramView.findViewById(2131822621));
    this.zRT = ((MMPinProgressBtn)paramView.findViewById(2131822601));
    this.zRU = ((ImageView)this.ngZ.findViewById(2131822602));
    this.zRV = ((ImageView)this.ngZ.findViewById(2131822620));
    this.zRW = ((ImageView)this.ngZ.findViewById(2131822619));
    this.zRX = ((ImageView)paramView.findViewById(2131822603));
    this.zRY = ((TextView)paramView.findViewById(2131822518));
    this.zSa = ((ImageView)paramView.findViewById(2131822622));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zRZ = ((ChattingItemFooter)paramView.findViewById(2131822618));
    this.zSb = ((LinearLayout)paramView.findViewById(2131822579));
    this.zSc = ((ViewGroup)paramView.findViewById(2131822576));
    this.zSd = ((TextView)paramView.findViewById(2131822578));
    this.zSe = ((LinearLayout)paramView.findViewById(2131821948));
    this.zSg = ((FrameLayout)paramView.findViewById(2131822580));
    this.zSh = ((LinearLayout)paramView.findViewById(2131822594));
    this.zSl = ((ImageView)paramView.findViewById(2131822646));
    this.zSf = ((RelativeLayout)paramView.findViewById(2131822599));
    this.zSj = ((ViewStub)paramView.findViewById(2131822604));
    this.zSk = ((ImageView)paramView.findViewById(2131822596));
    if (!paramBoolean)
    {
      this.zSm = ((ImageView)this.ngZ.findViewById(2131822729));
      this.pNd = ((ProgressBar)this.ngZ.findViewById(2131822728));
    }
    this.zSt = ((LinearLayout)paramView.findViewById(2131822581));
    this.zSq = ((ImageView)paramView.findViewById(2131822582));
    this.zSr = ((TextView)paramView.findViewById(2131822583));
    this.zSw = ((TextView)paramView.findViewById(2131822584));
    this.zSv = ((ImageView)paramView.findViewById(2131822585));
    this.zSu = ((ImageView)paramView.findViewById(2131822586));
    this.zSn = ((LinearLayout)paramView.findViewById(2131822589));
    this.zSo = ((ImageView)paramView.findViewById(2131822590));
    this.zSp = ((TextView)paramView.findViewById(2131822591));
    this.zSs = ((TextView)paramView.findViewById(2131822588));
    this.zSy = ((LinearLayout)paramView.findViewById(2131822610));
    this.zSz = ((TextView)paramView.findViewById(2131822611));
    this.zSA = ((TextView)paramView.findViewById(2131822612));
    this.zSB = ((ImageView)paramView.findViewById(2131822613));
    this.zSC = ((ImageView)paramView.findViewById(2131822614));
    this.zSD = ((ImageView)paramView.findViewById(2131822616));
    this.zSE = ((TextView)paramView.findViewById(2131822617));
    this.zSF = ((ImageView)paramView.findViewById(2131822615));
    this.zSG = ((LinearLayout)paramView.findViewById(2131822505));
    this.zSK = ((ImageView)paramView.findViewById(2131822509));
    this.zSH = ((MMNeat7extView)paramView.findViewById(2131822506));
    this.zSI = ((ImageView)paramView.findViewById(2131822508));
    this.zSJ = ((ImageView)paramView.findViewById(2131822511));
    this.zSL = ((TextView)paramView.findViewById(2131822512));
    this.zSM = ((TextView)paramView.findViewById(2131822510));
    if ((this.zRR != null) && (Build.VERSION.SDK_INT >= 16)) {
      this.zSO = this.zRR.getMaxLines();
    }
    this.zSN = c.in(ah.getContext());
    AppMethodBeat.o(32814);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.d.c
 * JD-Core Version:    0.7.0.1
 */