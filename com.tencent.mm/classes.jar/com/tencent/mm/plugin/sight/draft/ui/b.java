package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.a.b;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends x<q>
{
  e PHA;
  a PHq;
  private b PHr;
  private c PHs;
  private Set<e> PHt;
  private b.d PHu;
  a PHv;
  int PHw;
  int PHx;
  private int PHy;
  private c PHz;
  private int dpX;
  private int nZd;
  private int wLI;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.PHq = new a((byte)0);
    this.PHr = new b((byte)0);
    this.PHs = new c((byte)0);
    this.PHt = new HashSet();
    this.PHu = b.d.PHC;
    this.PHw = R.l.sight_draft_send;
    this.PHx = 0;
    this.PHz = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.PHH != null) && (Util.nullAs(paramAnonymousString, "").equals(locale.PHH.field_fileName))) {
            locale.PHG.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.PHv = parama;
    int i = paramContext.getResources().getDimensionPixelSize(R.f.fmd) * 2;
    this.nZd = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.wLI = (this.nZd - i);
    this.dpX = (this.wLI * 3 / 4);
    this.PHy = (i + this.dpX);
    AppMethodBeat.o(28675);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.PHt.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).NfI.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.PHt.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.NfI;
      if (parame == locale) {}
      for (int i = 8;; i = 0)
      {
        localView.setVisibility(i);
        break;
      }
    }
    AppMethodBeat.o(28677);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28678);
    if (paramd == this.PHu)
    {
      if ((paramBoolean) && (this.PHv != null)) {
        this.PHv.gYQ();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.PHu = paramd;
    this.PHq.gYR();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.PHv != null)) {
      this.PHv.gYQ();
    }
    AppMethodBeat.o(28678);
    return true;
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(28680);
    aNz();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(28681);
    w(v.bOl().bOc());
    AppMethodBeat.o(28681);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(28682);
    int i = super.getCount() / 3;
    AppMethodBeat.o(28682);
    return i + 1;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(28676);
    Object localObject1;
    int i;
    Object localObject2;
    Object localObject3;
    if (paramView == null)
    {
      localObject1 = new b.f((byte)0);
      paramView = new LinearLayout(paramViewGroup.getContext());
      paramView.setOrientation(0);
      i = 0;
      while (i < 3)
      {
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.gos, paramView, false);
        localObject3 = new e((byte)0);
        ((e)localObject3).hDw = ((View)localObject2);
        ((e)localObject3).hDw.setTag(localObject3);
        ((e)localObject3).PHF = ((View)localObject2).findViewById(R.h.fXE);
        ((e)localObject3).PHG = ((com.tencent.mm.plugin.sight.decode.model.a)((View)localObject2).findViewById(R.h.fXH));
        ((e)localObject3).Aov = ((ImageView)((View)localObject2).findViewById(R.h.fXI));
        ((e)localObject3).NfI = ((View)localObject2).findViewById(R.h.fWa);
        ((e)localObject3).ttU = ((TextView)((View)localObject2).findViewById(R.h.fXG));
        ((e)localObject3).ttU.setText(this.PHw);
        ((e)localObject3).PwH = ((ImageView)((View)localObject2).findViewById(R.h.fXD));
        ((b.f)localObject1).PHI.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.PHy;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.PHq);
        ((e)localObject3).PwH.setTag(localObject3);
        ((e)localObject3).PwH.setOnClickListener(this.PHs);
        i += 1;
      }
      paramView.setTag(localObject1);
    }
    int j;
    for (paramViewGroup = (ViewGroup)localObject1;; paramViewGroup = (b.f)paramView.getTag())
    {
      i = 0;
      for (;;)
      {
        if (i >= paramViewGroup.PHI.size()) {
          break label668;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.PHI.get(i);
        this.PHt.add(localObject1);
        ((e)localObject1).NfI.setVisibility(8);
        ((e)localObject1).ttU.setVisibility(8);
        ((e)localObject1).Aov.setBackgroundResource(R.g.fpi);
        ((e)localObject1).PHG.e(null, false, 0);
        ((e)localObject1).PHG.setCanPlay(false);
        ((e)localObject1).PHG.setForceRecordState(false);
        ((ImageView)((e)localObject1).PHG).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).PHH = null;
        ((e)localObject1).hDw.setVisibility(4);
        k.E(((e)localObject1).PHF, 1.0F);
        i += 1;
      }
    }
    this.PHx -= 1;
    Object localObject4 = (q)getItem(j);
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).PHH = null;
      ((e)localObject1).PHG.gYs();
      if (b.d.PHD != this.PHu) {
        break label646;
      }
      ((e)localObject1).PwH.setVisibility(0);
      k.E(((e)localObject1).PHF, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).hDw.setVisibility(0);
      break;
      ((e)localObject1).PHH = ((q)localObject4);
      localObject2 = this.PHz;
      localObject3 = ((q)localObject4).field_fileName;
      localObject4 = r.PH(((q)localObject4).field_fileName);
      if (this.PHx <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).H((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).PHG).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).PHG.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label646:
      ((e)localObject1).PwH.setVisibility(8);
      k.E(((e)localObject1).PHF, 1.0F);
    }
    label668:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(28679);
    this.PHt.clear();
    super.onNotifyChange(paramString, paramMStorageEventData);
    AppMethodBeat.o(28679);
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean gYR()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).ttU.setVisibility(8);
        b.c(b.this).PHG.setCanPlay(false);
        b.c(b.this).PHG.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).H(b.c(b.this).PHH.field_fileName, r.PH(b.c(b.this).PHH.field_fileName), true);
        b.c(b.this).PHG.setThumbBmp(localBitmap);
        b.c(b.this).Aov.setBackgroundResource(R.g.fpi);
        k.E(b.c(b.this).PHF, 1.0F);
        b.a(b.this, null);
        AppMethodBeat.o(28668);
        return true;
      }
      AppMethodBeat.o(28668);
      return false;
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(28667);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.PHH == null)
      {
        Log.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        gYR();
        b.a(b.this, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      if (b.c(b.this) != paramView)
      {
        gYR();
        localObject1 = r.PG(paramView.PHH.field_fileName);
        paramView.PHG.setCanPlay(true);
        paramView.PHG.e((String)localObject1, false, 0);
        paramView.Aov.setBackgroundResource(R.g.fpj);
        localObject1 = paramView.PHF;
        if ((localObject1 != null) && (!d.rc(11))) {
          break label267;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).gYP();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
        label267:
        Object localObject2 = (Animator)((View)localObject1).getTag(a.g.property_anim);
        if (localObject2 != null) {
          ((Animator)localObject2).cancel();
        }
        localObject2 = (AnimatorSet)AnimatorInflater.loadAnimator(((View)localObject1).getContext(), a.b.fast_zoom_in_property_anim);
        ((AnimatorSet)localObject2).setTarget(localObject1);
        ((AnimatorSet)localObject2).start();
        ((View)localObject1).setTag(a.g.property_anim, localObject2);
      }
    }
  }
  
  final class b
    implements View.OnLongClickListener
  {
    private b() {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(28669);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.PHH == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.PHH.field_fileStatus)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.PHD, true);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(28669);
      return true;
    }
  }
  
  final class c
    implements View.OnClickListener
  {
    private c() {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(28670);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).gYR();
      paramView = (b.e)paramView.getTag();
      if (paramView.PHH == null)
      {
        Log.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.PHH.field_fileStatus = 6;
      v.bOl().update(paramView.PHH, new String[] { "localId" });
      b.this.onNotifyChange(null, null);
      if (b.d(b.this) != null) {
        b.d(b.this);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(28670);
    }
  }
  
  static final class e
  {
    ImageView Aov;
    View NfI;
    View PHF;
    com.tencent.mm.plugin.sight.decode.model.a PHG;
    q PHH;
    ImageView PwH;
    View hDw;
    TextView ttU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */