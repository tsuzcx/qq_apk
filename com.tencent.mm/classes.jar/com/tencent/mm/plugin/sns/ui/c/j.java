package com.tencent.mm.plugin.sns.ui.c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.b.e;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.aj;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  private static int[] pmp = { i.f.turn_media_type_img_0, i.f.turn_media_type_img_1 };
  private static int[] pob = { i.f.turn_media_type_sight_0 };
  private static int[][] poc;
  public int mScreenHeight = 0;
  private int mScreenWidth = 0;
  private int poa = 0;
  
  static
  {
    int i = i.f.turn_media_type_title_1;
    int j = i.f.turn_media_type_subtitle_1;
    int k = i.f.turn_media_type_title_0;
    int m = i.f.turn_media_type_subtitle_0;
    int[] arrayOfInt = { i.f.turn_media_type_title_0, i.f.turn_media_type_subtitle_1 };
    poc = new int[][] { { i, j }, { k, m }, arrayOfInt };
  }
  
  private static void a(j.a parama)
  {
    parama.poi.pmd.setVisibility(8);
    parama.poi.pme.setVisibility(8);
    ((TextView)parama.poi.pok.findViewById(i.f.turn_media_type_title_0)).setText(null);
    ((TextView)parama.poi.pok.findViewById(i.f.turn_media_type_title_1)).setText(null);
    ((TextView)parama.poi.pok.findViewById(i.f.turn_media_type_subtitle_0)).setText(null);
    ((TextView)parama.poi.pok.findViewById(i.f.turn_media_type_subtitle_1)).setText(null);
    Object localObject = parama.oUH.bFZ();
    TextView localTextView;
    if ((((com.tencent.mm.plugin.sns.storage.b)localObject).oBx != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).oBx.oBQ != null) && (((com.tencent.mm.plugin.sns.storage.b)localObject).oBx.oBQ.size() >= 2))
    {
      localObject = (b.h)((com.tencent.mm.plugin.sns.storage.b)localObject).oBx.oBQ.get(parama.index);
      if ((((b.h)localObject).oBK >= 0) && (((b.h)localObject).oBK < poc.length))
      {
        int[] arrayOfInt = poc[localObject.oBK];
        localTextView = (TextView)parama.poi.pok.findViewById(arrayOfInt[0]);
        parama = (TextView)parama.poi.pok.findViewById(arrayOfInt[1]);
        if (!bk.bl(((b.h)localObject).title)) {
          break label281;
        }
        localTextView.setVisibility(8);
        if (!bk.bl(((b.h)localObject).desc)) {
          break label297;
        }
        parama.setVisibility(8);
      }
    }
    for (;;)
    {
      ((View)localTextView.getParent()).setVisibility(0);
      ((View)parama.getParent()).setVisibility(0);
      return;
      label281:
      localTextView.setVisibility(0);
      localTextView.setText(((b.h)localObject).title);
      break;
      label297:
      parama.setVisibility(0);
      parama.setText(((b.h)localObject).desc);
    }
  }
  
  public static View m(View paramView, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 6) {
      return paramView.findViewById(pob[0]);
    }
    return paramView.findViewById(pmp[paramInt1]);
  }
  
  @TargetApi(16)
  public final void a(a.c paramc, int paramInt1, ax paramax, bxk parambxk, int paramInt2, au paramau)
  {
    y.i("MiroMsg.TurnMediaTimeLineItem", "fill turn card ad item %d", new Object[] { Integer.valueOf(paramInt1) });
    if (paramc.dCs) {
      y.i("MiroMsg.TurnMediaTimeLineItem", "holder is busy");
    }
    b localb;
    Object localObject1;
    Object localObject2;
    int j;
    int i;
    Object localObject3;
    do
    {
      return;
      localb = (b)paramc;
      localb.pok.setTag(localb);
      localb.pok.setVisibility(0);
      localb.pok.setLayerType(2, null);
      localObject1 = (b)localb;
      localObject2 = pmp;
      j = localObject2.length;
      i = 0;
      int k;
      while (i < j)
      {
        k = localObject2[i];
        localObject3 = ((b)localObject1).pok.findViewById(k);
        if (localObject3 != null) {
          ((View)localObject3).setVisibility(8);
        }
        if ((localObject3 instanceof MaskImageView)) {
          ((MaskImageView)localObject3).setScaleType(QImageView.a.wkS);
        }
        i += 1;
      }
      localObject2 = pob;
      j = localObject2.length;
      i = 0;
      while (i < j)
      {
        k = localObject2[i];
        localObject3 = ((b)localObject1).pok.findViewById(k);
        if (localObject3 != null)
        {
          ((View)localObject3).setBackground(null);
          ((View)localObject3).setVisibility(8);
          if ((localObject3 instanceof ViewGroup)) {
            ((ViewGroup)localObject3).setClipChildren(false);
          }
        }
        i += 1;
      }
      localObject1 = new LinearLayout.LayoutParams(((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth() - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding), -2);
      paramc.pmH.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    } while ((!paramax.oNn) || (paramInt2 != 11));
    label398:
    awd localawd;
    View localView;
    Object localObject4;
    label533:
    boolean bool1;
    label569:
    long l;
    Object localObject5;
    label674:
    Object localObject6;
    boolean bool2;
    if ((parambxk.tNr != null) && (parambxk.tNr.sPJ != null) && (parambxk.tNr.sPJ.size() >= 2)) {
      if (localb.pmB == 1)
      {
        paramInt2 = 1;
        localObject2 = null;
        localObject1 = null;
        i = 0;
        if (i >= Math.min(parambxk.tNr.sPJ.size(), 2)) {
          break label1934;
        }
        localawd = (awd)parambxk.tNr.sPJ.get(i);
        localView = m(localb.pok, i, 2);
        localView.setVisibility(4);
        if (localView == null) {
          break label2036;
        }
        localView.setTag(paramc);
        localView.setOnClickListener(paramau.ovx.ppf);
        if (localawd.hQR != 2) {
          break label1285;
        }
        localObject3 = af.bDC();
        j = this.mActivity.hashCode();
        localObject4 = az.cuY();
        ((az)localObject4).time = parambxk.mPL;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localawd, localView, -1, j, (az)localObject4, 3);
        localObject4 = null;
        localObject3 = localObject4;
        if (localawd.hQR == 6)
        {
          localObject3 = localObject4;
          if (paramInt2 == i)
          {
            if (paramInt2 <= 0) {
              break label1330;
            }
            bool1 = true;
            l = paramax.pgP;
            localObject5 = localb.pon;
            localObject4 = paramax.oje;
            localObject3 = ((aj)localObject5).oTG;
            ((aj)localObject5).oTF = parambxk;
            ((aj)localObject5).ogP.setOnCompletionListener(new j.1(this, paramau, l, bool1));
            if (paramau.pec.oNB.fG(i + l)) {
              break label1336;
            }
            ((aj)localObject5).ogP.setOnDecodeDurationListener(new j.2(this, paramau, l, bool1, i, (aj)localObject5));
            ((aj)localObject5).a(parambxk, paramInt1, paramax.oOM, paramax.oNn);
            ((aj)localObject5).oGU.setVisibility(8);
            localObject6 = af.bDC();
            l = System.nanoTime();
            bool2 = com.tencent.mm.plugin.sns.model.g.t(localawd);
            y.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
            if (bool2) {
              break label1559;
            }
            if (!((com.tencent.mm.plugin.sns.model.g)localObject6).w(localawd)) {
              break label1381;
            }
            ((aj)localObject5).oGT.setVisibility(8);
            ((aj)localObject5).oTI.setVisibility(0);
            ((aj)localObject5).oTI.cJO();
            label791:
            Object localObject7 = ((aj)localObject5).oTJ.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject7).width = this.poa;
            ((ViewGroup.LayoutParams)localObject7).height = this.poa;
            ((aj)localObject5).oTJ.setLayoutParams((ViewGroup.LayoutParams)localObject7);
            ((aj)localObject5).ogP.setTagObject(localObject5);
            localObject7 = ((aj)localObject5).ogP;
            j = this.mActivity.hashCode();
            az localaz = az.cuY();
            localaz.time = parambxk.mPL;
            ((com.tencent.mm.plugin.sns.model.g)localObject6).a((n)localObject4, localawd, (com.tencent.mm.plugin.sight.decode.a.a)localObject7, j, paramInt1, localaz, paramax.oNn, true);
            ((View)localObject3).setVisibility(0);
            ((aj)localObject5).oTH.setTag(paramc);
            ((aj)localObject5).oTH.setOnClickListener(new j.3(this, paramInt2, paramau, localb));
            localObject5 = an.eJ(af.getAccSnsPath(), localawd.lsK);
            localObject6 = com.tencent.mm.plugin.sns.data.i.j(localawd);
            if (!e.bK((String)localObject5 + (String)localObject6)) {
              break label1899;
            }
            paramau.pec.oNB.a(paramax.pgP, 0, true, bool1);
            label996:
            if (af.bDC().b((n)localObject4, null) != 5) {
              break label1921;
            }
            bool2 = true;
            label1012:
            paramau.pec.oNB.a(paramax.pgP, bool2, bool1);
          }
        }
        localObject4 = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject4).width = this.poa;
        ((ViewGroup.LayoutParams)localObject4).height = this.poa;
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        if (localObject3 != null)
        {
          localObject4 = ((View)localObject3).getLayoutParams();
          ((ViewGroup.LayoutParams)localObject4).width = this.poa;
          ((ViewGroup.LayoutParams)localObject4).height = this.poa;
          ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        }
        if ((paramInt2 == i) && (localawd.hQR == 2))
        {
          localView.setVisibility(0);
          localView.setOnTouchListener(new j.4(this));
        }
        localObject4 = new j.a();
        ((j.a)localObject4).index = i;
        localObject5 = localObject3;
        if (localObject3 == null) {
          localObject5 = localView;
        }
        ((j.a)localObject4).view = ((View)localObject5);
        ((j.a)localObject4).poh = localView;
        ((j.a)localObject4).poi = localb;
        ((j.a)localObject4).oqa = localawd;
        ((j.a)localObject4).oUH = paramax.oje;
        if (localObject2 == null) {
          break label1927;
        }
        ((j.a)localObject2).poj = ((j.a)localObject4);
        label1213:
        if (i == parambxk.tNr.sPJ.size() - 1) {
          ((j.a)localObject4).poj = ((j.a)localObject1);
        }
        if (i == paramInt2)
        {
          localb.pom = ((j.a)localObject4);
          a((j.a)localObject4);
        }
        localObject2 = localObject4;
      }
    }
    label1285:
    label1330:
    label1336:
    label1381:
    label1897:
    label1899:
    label2036:
    for (;;)
    {
      i += 1;
      break label398;
      paramInt2 = 0;
      break;
      y.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
      return;
      localObject3 = af.bDC();
      j = this.mActivity.hashCode();
      localObject4 = az.cuY();
      ((az)localObject4).time = parambxk.mPL;
      ((com.tencent.mm.plugin.sns.model.g)localObject3).a(localawd, localView, j, (az)localObject4);
      break label533;
      bool1 = false;
      break label569;
      if ((paramau == null) || (paramau.pec == null) || (paramau.pec.oNB == null)) {
        break label674;
      }
      paramau.pec.oNB.b(l, bk.UZ(), bool1);
      break label674;
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) == 5)
      {
        ((com.tencent.mm.plugin.sns.model.g)localObject6).A(localawd);
        ((aj)localObject5).oGT.setVisibility(8);
        ((aj)localObject5).oTI.setVisibility(0);
        ((aj)localObject5).oTI.cJO();
        break label791;
      }
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).x(localawd))
      {
        ((aj)localObject5).oTI.setVisibility(8);
        ((aj)localObject5).oGT.setImageResource(i.e.sight_chat_error);
        ((aj)localObject5).oGT.setVisibility(0);
        break label791;
      }
      ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localawd);
      ((aj)localObject5).oGT.setVisibility(0);
      ((aj)localObject5).oTI.setVisibility(8);
      ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
      ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) != 4) {
        break label791;
      }
      ((aj)localObject5).oGU.setVisibility(0);
      break label791;
      if (((com.tencent.mm.plugin.sns.model.g)localObject6).u(localawd))
      {
        ((aj)localObject5).oGT.setVisibility(0);
        ((aj)localObject5).oTI.setVisibility(8);
        ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
        ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
      }
      for (;;)
      {
        if (!((aj)localObject5).ogP.bAY()) {
          break label1897;
        }
        y.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + localawd.lsK + " " + localawd.kSC + " " + localawd.trP + " " + paramInt1);
        ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localawd);
        ((aj)localObject5).oGT.setVisibility(0);
        ((aj)localObject5).oTI.setVisibility(8);
        ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
        ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        break;
        if (((com.tencent.mm.plugin.sns.model.g)localObject6).v(localawd))
        {
          ((aj)localObject5).oGT.setVisibility(8);
          ((aj)localObject5).oTI.setVisibility(8);
        }
        else if (((com.tencent.mm.plugin.sns.model.g)localObject6).b((n)localObject4, null) <= 5)
        {
          ((aj)localObject5).oGT.setVisibility(8);
          ((aj)localObject5).oTI.setVisibility(8);
        }
        else
        {
          ((com.tencent.mm.plugin.sns.model.g)localObject6).y(localawd);
          ((aj)localObject5).oGT.setVisibility(0);
          ((aj)localObject5).oTI.setVisibility(8);
          ((aj)localObject5).oGT.setImageDrawable(com.tencent.mm.cb.a.g(this.mActivity, i.i.shortvideo_play_btn));
          ((aj)localObject5).oGT.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        }
      }
      break label791;
      paramau.pec.oNB.a(paramax.pgP, 0, false, bool1);
      break label996;
      bool2 = false;
      break label1012;
      localObject1 = localObject4;
      break label1213;
      if ((localb.kKz != null) && ((localb.kKz instanceof FrameLayout))) {
        ((FrameLayout)localb.kKz).setClipChildren(false);
      }
      if (localb.pmH != null) {
        localb.pmH.setClipChildren(false);
      }
      if ((localb.pnz != null) && ((localb.pnz instanceof LinearLayout))) {
        ((LinearLayout)localb.pnz).setClipChildren(false);
      }
      localb.pok.setOnClickListener(new j.5(this, paramau, paramInt2, localb));
      return;
    }
  }
  
  public final void d(a.c paramc)
  {
    Object localObject;
    if (this.mActivity != null)
    {
      localObject = new DisplayMetrics();
      this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
      this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
      this.poa = (Math.min(this.mScreenWidth, this.mScreenHeight) - com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 50) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.NormalPadding) - this.mActivity.getResources().getDimensionPixelSize(i.d.SmallPadding));
    }
    paramc = (b)paramc;
    if ((paramc.pmI != null) && (!paramc.pol))
    {
      paramc.pmI.setLayoutResource(i.g.sns_timeline_turn_media);
      if (!paramc.pol)
      {
        paramc.pok = paramc.pmI.inflate();
        paramc.pol = true;
      }
    }
    for (;;)
    {
      localObject = paramc.pok.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = this.poa;
      ((ViewGroup.LayoutParams)localObject).height = this.poa;
      localObject = paramc.pon;
      ((aj)localObject).oTH = m(paramc.pok, 0, 6);
      ((aj)localObject).oTG = ((aj)localObject).oTH;
      ((aj)localObject).ogP = ((com.tencent.mm.plugin.sight.decode.a.a)((aj)localObject).oTH.findViewById(i.f.image));
      ((aj)localObject).oGT = ((ImageView)((aj)localObject).oTH.findViewById(i.f.status_btn));
      ((aj)localObject).oTI = ((MMPinProgressBtn)((aj)localObject).oTH.findViewById(i.f.progress));
      ((aj)localObject).oTJ = ((TextView)((aj)localObject).oTH.findViewById(i.f.endtv));
      ((aj)localObject).oGU = ((TextView)((aj)localObject).oTH.findViewById(i.f.errorTv));
      ((SightPlayImageView)((aj)localObject).ogP).ofL = true;
      ((SightPlayImageView)((aj)localObject).ogP).setScaleType(QImageView.a.wkS);
      ((aj)localObject).ogP.dL(this.poa, this.poa);
      paramc.pmd = paramc.pok.findViewById(i.f.text_area_top);
      paramc.pme = paramc.pok.findViewById(i.f.text_area_bottom);
      return;
      if (!paramc.pol)
      {
        paramc.pok = paramc.kKz.findViewById(i.f.turn_media_container);
        paramc.pol = true;
      }
    }
  }
  
  public static class b
    extends a.c
  {
    public View pmd;
    public View pme;
    public View pok;
    public boolean pol = false;
    public j.a pom;
    public aj pon = new aj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.j
 * JD-Core Version:    0.7.0.1
 */