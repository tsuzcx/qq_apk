package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.h.a.qe;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

final class SnsInfoFlip$b
  extends BaseAdapter
{
  private Context context;
  private String dXz = "";
  private boolean iPN = true;
  private int oMu = 0;
  private boolean oZo = false;
  Map<String, WeakReference<View>> oZp = new HashMap();
  private String oZq;
  
  public SnsInfoFlip$b(SnsInfoFlip paramSnsInfoFlip, Context paramContext)
  {
    this.context = paramContext;
    this.oZo = f.cAr();
    this.oMu = SnsInfoFlip.j(paramSnsInfoFlip).size();
    c.Ni();
    this.iPN = c.Nk();
  }
  
  private void yI(int paramInt)
  {
    awd localawd = ((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).bZK;
    az localaz = az.a(SnsInfoFlip.k(this.oZi), ((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).enw);
    if (localawd.hQR != 2) {}
    boolean bool;
    do
    {
      return;
      bool = v.OT(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP);
      af.bDC();
      bool = g.a(localawd, localaz, bool);
    } while ((!SnsInfoFlip.l(this.oZi)) || (bool));
    SnsInfoFlip.a(this.oZi, localawd.lsK);
  }
  
  public final void bIW()
  {
    y.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[] { bk.csb() });
    this.oZq = null;
    qe localqe = new qe();
    localqe.bZC.bNb = 2;
    a.udP.m(localqe);
  }
  
  public final void clear()
  {
    y.i("MicroMsg.SnsInfoFlip", "adapter clear.");
    this.oZp.clear();
  }
  
  public final int getCount()
  {
    if (SnsInfoFlip.j(this.oZi) == null) {
      return 0;
    }
    return SnsInfoFlip.j(this.oZi).size();
  }
  
  public final Object getItem(int paramInt)
  {
    if ((paramInt < SnsInfoFlip.j(this.oZi).size()) && (paramInt >= 0)) {
      return SnsInfoFlip.j(this.oZi).get(paramInt);
    }
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).bZK.hQR == 6) {
      return 0;
    }
    return 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool;
    if (((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).bZK.hQR == 6)
    {
      if (paramView == null) {}
      for (bool = true;; bool = false)
      {
        y.d("MicroMsg.SnsInfoFlip", "fill view online sight %d convert view is null %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool) });
        paramViewGroup = (com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt);
        if (paramViewGroup != null) {
          break;
        }
        y.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
        paramViewGroup = paramView;
        return paramViewGroup;
      }
      localObject1 = paramViewGroup.owP;
      if (bk.bl((String)localObject1))
      {
        y.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
        return paramView;
      }
      paramView = (WeakReference)this.oZp.get(localObject1);
      if ((paramView != null) && (paramView.get() != null)) {
        paramView = (OnlineVideoView)paramView.get();
      }
      for (;;)
      {
        if (bk.isEqual((String)localObject1, this.oZq)) {
          yJ(paramInt);
        }
        y.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[] { Integer.valueOf(paramView.hashCode()), paramViewGroup.owP });
        return paramView;
        paramView = new OnlineVideoView(this.context);
        this.oZp.put(localObject1, new WeakReference(paramView));
      }
    }
    Object localObject2 = ((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).bZK;
    y.d("MicroMsg.SnsInfoFlip", "gallery position " + paramInt + " " + this.oMu + " " + ((awd)localObject2).lsK);
    if ((paramInt != SnsInfoFlip.m(this.oZi)) && ((SnsInfoFlip.g(this.oZi) instanceof MMGestureGallery))) {
      ((MMGestureGallery)SnsInfoFlip.g(this.oZi)).setLoadQuit(false);
    }
    label440:
    az localaz;
    int i;
    label549:
    Object localObject3;
    if (paramView == null)
    {
      paramViewGroup = new SnsInfoFlip.d();
      paramView = View.inflate(this.context, i.g.sns_gallery_item, null);
      paramViewGroup.oZr = paramView.findViewById(i.f.click_keeper);
      paramViewGroup.oZs = ((ProgressBar)paramView.findViewById(i.f.progressbar));
      paramViewGroup.lAx = ((TextView)paramView.findViewById(i.f.sns_info));
      paramViewGroup.oZt = ((FrameLayout)paramView.findViewById(i.f.big_img_fl));
      paramViewGroup.bQf = ((ImageView)paramView.findViewById(i.f.image));
      paramView.setTag(paramViewGroup);
      paramViewGroup.position = paramInt;
      localaz = az.a(SnsInfoFlip.k(this.oZi), ((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).enw);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.oZs.setVisibility(8);
      paramViewGroup.lAx.setVisibility(8);
      paramViewGroup.oZt.setVisibility(0);
      if ((bk.bl(SnsInfoFlip.n(this.oZi))) || (!SnsInfoFlip.n(this.oZi).equals(((awd)localObject2).lsK))) {
        break label1220;
      }
      i = 1;
      if ((!((awd)localObject2).lsK.startsWith("Locall_path")) || (bk.bl(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP))) {
        break label1504;
      }
      localObject3 = (com.tencent.mm.plugin.sns.storage.n)SnsInfoFlip.o(this.oZi).get(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP);
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = af.bDF().OB(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP);
        SnsInfoFlip.o(this.oZi).put(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP, localObject1);
      }
      localObject1 = ((com.tencent.mm.plugin.sns.storage.n)localObject1).bGe();
      if (((bxk)localObject1).tNr.sPJ.size() <= ((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owQ) {
        break label1504;
      }
    }
    label793:
    label1220:
    label1232:
    label1238:
    label1504:
    for (Object localObject1 = (awd)((bxk)localObject1).tNr.sPJ.get(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owQ);; localObject1 = localObject2)
    {
      localObject2 = af.bDC();
      localObject3 = paramViewGroup.bQf;
      int j = this.context.hashCode();
      if (i == 0)
      {
        bool = true;
        localObject2 = ((g)localObject2).a((awd)localObject1, (View)localObject3, j, bool, localaz, v.OT(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP));
        if ((localObject2 == null) && (SnsInfoFlip.l(this.oZi))) {
          SnsInfoFlip.a(this.oZi, ((awd)localObject1).lsK);
        }
        localObject3 = paramViewGroup.bQf.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = -1;
        ((ViewGroup.LayoutParams)localObject3).height = -1;
        paramViewGroup.bQf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if ((localObject2 != null) || (((awd)localObject1).lsK == null) || (((awd)localObject1).lsK.startsWith("pre_temp_extend_pic"))) {
          break label1238;
        }
        ViewGroup.LayoutParams localLayoutParams = paramViewGroup.bQf.getLayoutParams();
        BackwardSupportUtil.b.b(this.context, 160.0F);
        j = BackwardSupportUtil.b.b(this.context, 200.0F);
        BackwardSupportUtil.b.b(this.context, 44.0F);
        localObject2 = af.bDC();
        String str1 = i.aG(1, ((awd)localObject1).lsK);
        String str2 = ((awd)localObject1).lsK;
        localObject2 = ((g)localObject2).Nr(str1);
        if (!i.b((com.tencent.mm.memory.n)localObject2)) {
          break label1232;
        }
        label999:
        if (localObject2 != null)
        {
          double d1 = ((com.tencent.mm.memory.n)localObject2).bitmap.getWidth();
          double d2 = ((com.tencent.mm.memory.n)localObject2).bitmap.getHeight();
          if ((d1 > 0.0D) && (d2 > 0.0D)) {
            Math.min(j / d1, j / d2);
          }
        }
        paramViewGroup.bQf.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        paramViewGroup.oZs.setVisibility(0);
        paramViewGroup.bQf.setVisibility(0);
        af.bDC().cM(paramViewGroup.bQf);
        af.bDC().b((awd)localObject1, paramViewGroup.bQf, i.e.black, this.context.hashCode(), localaz);
        SnsInfoFlip.yG(localLayoutParams.width);
        SnsInfoFlip.yH(localLayoutParams.height);
        if (i != 0) {
          paramViewGroup.oZs.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup = paramView;
        if (!this.iPN) {
          break;
        }
        paramViewGroup = paramView;
        if (!ab.bG(this.context)) {
          break;
        }
        if (paramInt - 1 >= 0) {
          yI(paramInt - 1);
        }
        paramViewGroup = paramView;
        if (paramInt + 1 >= SnsInfoFlip.d(this.oZi).getCount()) {
          break;
        }
        yI(paramInt + 1);
        return paramView;
        paramViewGroup = (SnsInfoFlip.d)paramView.getTag();
        break label440;
        i = 0;
        break label549;
        bool = false;
        break label793;
        localObject2 = null;
        break label999;
        if (this.oZo)
        {
          paramViewGroup.oZs.setVisibility(8);
          if (localObject2 == null) {
            continue;
          }
          paramViewGroup = paramView;
          if (SnsInfoFlip.p(this.oZi)) {
            break;
          }
          y.i("MicroMsg.SnsInfoFlip", "update view ");
          paramView = new MultiTouchImageView(this.context, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), SnsInfoFlip.q(this.oZi));
          paramView.setEnableHorLongBmpMode(SnsInfoFlip.r(this.oZi));
          paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
          af.bDC().a((awd)localObject1, paramView, this.context.hashCode(), localaz, v.OT(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP));
          paramView.setImageBitmap((Bitmap)localObject2);
          y.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[] { ((awd)localObject1).lsK, SnsInfoFlip.s(this.oZi).get(((awd)localObject1).lsK), Integer.valueOf(paramView.getId()) });
          return paramView;
        }
        paramViewGroup.oZs.setVisibility(8);
        af.bDC().a((awd)localObject1, paramViewGroup.bQf, this.context.hashCode(), localaz, v.OT(((com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt)).owP));
        paramViewGroup.bQf.setImageBitmap((Bitmap)localObject2);
        paramViewGroup.bQf.setVisibility(0);
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 2;
  }
  
  public final void notifyDataSetChanged()
  {
    this.oMu = SnsInfoFlip.j(this.oZi).size();
    y.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.j(this.oZi).size());
    this.oZi.invalidate();
    this.oZi.requestLayout();
    super.notifyDataSetChanged();
    if ((SnsInfoFlip.j(this.oZi).size() <= 0) && (SnsInfoFlip.t(this.oZi) != null)) {
      SnsInfoFlip.t(this.oZi).run();
    }
  }
  
  public final void yJ(int paramInt)
  {
    Object localObject1 = (com.tencent.mm.plugin.sns.g.b)SnsInfoFlip.j(this.oZi).get(paramInt);
    if (localObject1 == null)
    {
      y.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
      return;
    }
    String str = ((com.tencent.mm.plugin.sns.g.b)localObject1).owP;
    if (bk.bl(str))
    {
      y.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
      return;
    }
    y.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[] { Integer.valueOf(paramInt), str });
    Object localObject2 = (WeakReference)this.oZp.get(str);
    if (localObject2 == null)
    {
      y.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
      this.oZq = str;
      return;
    }
    localObject2 = (OnlineVideoView)((WeakReference)localObject2).get();
    if (localObject2 == null)
    {
      y.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[] { str });
      this.oZq = str;
      return;
    }
    y.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[] { Integer.valueOf(localObject2.hashCode()), str });
    this.oZq = null;
    y.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[] { Integer.valueOf(localObject2.hashCode()) });
    a.udP.c(((OnlineVideoView)localObject2).oRH);
    ((OnlineVideoView)localObject2).a(((com.tencent.mm.plugin.sns.g.b)localObject1).bZK, ((com.tencent.mm.plugin.sns.g.b)localObject1).owP, ((com.tencent.mm.plugin.sns.g.b)localObject1).enw);
    localObject1 = new qe();
    ((qe)localObject1).bZC.bNb = 1;
    ((qe)localObject1).bZC.bMB = str;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsInfoFlip.b
 * JD-Core Version:    0.7.0.1
 */