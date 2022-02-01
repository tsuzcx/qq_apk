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
import com.tencent.mm.modelvideo.n;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.p;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.v;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends v<n>
{
  a JtR;
  private b JtS;
  private c JtT;
  private Set<e> JtU;
  private b.d JtV;
  a JtW;
  int JtX;
  int JtY;
  private int JtZ;
  private int Jua;
  private c Jub;
  e Juc;
  private int bwU;
  private int tHY;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.JtR = new a((byte)0);
    this.JtS = new b((byte)0);
    this.JtT = new c((byte)0);
    this.JtU = new HashSet();
    this.JtV = b.d.Jue;
    this.JtX = R.l.sight_draft_send;
    this.JtY = 0;
    this.Jub = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.Juj != null) && (Util.nullAs(paramAnonymousString, "").equals(locale.Juj.field_fileName))) {
            locale.Jui.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.JtW = parama;
    int i = paramContext.getResources().getDimensionPixelSize(R.f.dlL) * 2;
    this.JtZ = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.tHY = (this.JtZ - i);
    this.bwU = (this.tHY * 3 / 4);
    this.Jua = (i + this.bwU);
    AppMethodBeat.o(28675);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.JtU.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).HhP.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.JtU.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.HhP;
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
    if (paramd == this.JtV)
    {
      if ((paramBoolean) && (this.JtW != null)) {
        this.JtW.fIX();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.JtV = paramd;
    this.JtR.fIY();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.JtW != null)) {
      this.JtW.fIX();
    }
    AppMethodBeat.o(28678);
    return true;
  }
  
  public final void atr()
  {
    AppMethodBeat.i(28680);
    ats();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void ats()
  {
    AppMethodBeat.i(28681);
    v(s.bqF().bqw());
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
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(R.i.eln, paramView, false);
        localObject3 = new e((byte)0);
        ((e)localObject3).fyN = ((View)localObject2);
        ((e)localObject3).fyN.setTag(localObject3);
        ((e)localObject3).Juh = ((View)localObject2).findViewById(R.h.dVi);
        ((e)localObject3).Jui = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(R.h.dVl));
        ((e)localObject3).wRS = ((ImageView)((View)localObject2).findViewById(R.h.dVm));
        ((e)localObject3).HhP = ((View)localObject2).findViewById(R.h.dTS);
        ((e)localObject3).qpt = ((TextView)((View)localObject2).findViewById(R.h.dVk));
        ((e)localObject3).qpt.setText(this.JtX);
        ((e)localObject3).Jkg = ((ImageView)((View)localObject2).findViewById(R.h.dVh));
        ((b.f)localObject1).Juk.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.Jua;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.JtR);
        ((e)localObject3).Jkg.setTag(localObject3);
        ((e)localObject3).Jkg.setOnClickListener(this.JtT);
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
        if (i >= paramViewGroup.Juk.size()) {
          break label668;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.Juk.get(i);
        this.JtU.add(localObject1);
        ((e)localObject1).HhP.setVisibility(8);
        ((e)localObject1).qpt.setVisibility(8);
        ((e)localObject1).wRS.setBackgroundResource(R.g.doU);
        ((e)localObject1).Jui.f(null, false, 0);
        ((e)localObject1).Jui.setCanPlay(false);
        ((e)localObject1).Jui.setForceRecordState(false);
        ((ImageView)((e)localObject1).Jui).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).Juj = null;
        ((e)localObject1).fyN.setVisibility(4);
        k.D(((e)localObject1).Juh, 1.0F);
        i += 1;
      }
    }
    this.JtY -= 1;
    Object localObject4 = (n)getItem(j);
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).Juj = null;
      ((e)localObject1).Jui.fIz();
      if (b.d.Juf != this.JtV) {
        break label646;
      }
      ((e)localObject1).Jkg.setVisibility(0);
      k.D(((e)localObject1).Juh, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).fyN.setVisibility(0);
      break;
      ((e)localObject1).Juj = ((n)localObject4);
      localObject2 = this.Jub;
      localObject3 = ((n)localObject4).field_fileName;
      localObject4 = o.XF(((n)localObject4).field_fileName);
      if (this.JtY <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).B((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).Jui).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).Jui.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label646:
      ((e)localObject1).Jkg.setVisibility(8);
      k.D(((e)localObject1).Juh, 1.0F);
    }
    label668:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(28679);
    this.JtU.clear();
    super.onNotifyChange(paramString, paramMStorageEventData);
    AppMethodBeat.o(28679);
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean fIY()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).qpt.setVisibility(8);
        b.c(b.this).Jui.setCanPlay(false);
        b.c(b.this).Jui.f(null, false, 0);
        Bitmap localBitmap = b.e(b.this).B(b.c(b.this).Juj.field_fileName, o.XF(b.c(b.this).Juj.field_fileName), true);
        b.c(b.this).Jui.setThumbBmp(localBitmap);
        b.c(b.this).wRS.setBackgroundResource(R.g.doU);
        k.D(b.c(b.this).Juh, 1.0F);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.Juj == null)
      {
        Log.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        fIY();
        b.a(b.this, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      if (b.c(b.this) != paramView)
      {
        fIY();
        localObject1 = o.XE(paramView.Juj.field_fileName);
        paramView.Jui.setCanPlay(true);
        paramView.Jui.f((String)localObject1, false, 0);
        paramView.wRS.setBackgroundResource(R.g.doV);
        localObject1 = paramView.Juh;
        if ((localObject1 != null) && (!d.qW(11))) {
          break label267;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).fIW();
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
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.Juj == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.Juj.field_fileStatus)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.Juf, true);
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
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).fIY();
      paramView = (b.e)paramView.getTag();
      if (paramView.Juj == null)
      {
        Log.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.Juj.field_fileStatus = 6;
      s.bqF().update(paramView.Juj, new String[] { "localId" });
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
    View HhP;
    ImageView Jkg;
    View Juh;
    com.tencent.mm.plugin.sight.decode.a.a Jui;
    n Juj;
    View fyN;
    TextView qpt;
    ImageView wRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */