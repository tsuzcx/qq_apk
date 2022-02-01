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
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends s<com.tencent.mm.modelvideo.j>
{
  a Dom;
  private b Don;
  private c Doo;
  private Set<e> Dop;
  private b.d Doq;
  a Dor;
  int Dos;
  int Dot;
  private int Dou;
  private int Dov;
  private c Dow;
  e Dox;
  private int kn;
  private int qmd;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.Dom = new a((byte)0);
    this.Don = new b((byte)0);
    this.Doo = new c((byte)0);
    this.Dop = new HashSet();
    this.Doq = b.d.Doz;
    this.Dos = 2131765889;
    this.Dot = 0;
    this.Dow = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.DoE != null) && (Util.nullAs(paramAnonymousString, "").equals(locale.DoE.field_fileName))) {
            locale.DoD.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.Dor = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131166926) * 2;
    this.Dou = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.qmd = (this.Dou - i);
    this.kn = (this.qmd * 3 / 4);
    this.Dov = (i + this.kn);
    AppMethodBeat.o(28675);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.Dop.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).Bnt.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.Dop.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.Bnt;
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
    if (paramd == this.Doq)
    {
      if ((paramBoolean) && (this.Dor != null)) {
        this.Dor.eVU();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.Doq = paramd;
    this.Dom.eVV();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.Dor != null)) {
      this.Dor.eVU();
    }
    AppMethodBeat.o(28678);
    return true;
  }
  
  public final void anp()
  {
    AppMethodBeat.i(28680);
    anq();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void anq()
  {
    AppMethodBeat.i(28681);
    setCursor(o.bhn().bhe());
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
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131496323, paramView, false);
        localObject3 = new e((byte)0);
        ((e)localObject3).jxm = ((View)localObject2);
        ((e)localObject3).jxm.setTag(localObject3);
        ((e)localObject3).DoC = ((View)localObject2).findViewById(2131307898);
        ((e)localObject3).DoD = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131307902));
        ((e)localObject3).tlu = ((ImageView)((View)localObject2).findViewById(2131307903));
        ((e)localObject3).Bnt = ((View)localObject2).findViewById(2131307728);
        ((e)localObject3).nnM = ((TextView)((View)localObject2).findViewById(2131307901));
        ((e)localObject3).nnM.setText(this.Dos);
        ((e)localObject3).DeA = ((ImageView)((View)localObject2).findViewById(2131307887));
        ((b.f)localObject1).DoF.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.Dov;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.Dom);
        ((e)localObject3).DeA.setTag(localObject3);
        ((e)localObject3).DeA.setOnClickListener(this.Doo);
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
        if (i >= paramViewGroup.DoF.size()) {
          break label666;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.DoF.get(i);
        this.Dop.add(localObject1);
        ((e)localObject1).Bnt.setVisibility(8);
        ((e)localObject1).nnM.setVisibility(8);
        ((e)localObject1).tlu.setBackgroundResource(2131234879);
        ((e)localObject1).DoD.e(null, false, 0);
        ((e)localObject1).DoD.setCanPlay(false);
        ((e)localObject1).DoD.setForceRecordState(false);
        ((ImageView)((e)localObject1).DoD).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).DoE = null;
        ((e)localObject1).jxm.setVisibility(4);
        com.tencent.mm.ui.tools.j.D(((e)localObject1).DoC, 1.0F);
        i += 1;
      }
    }
    this.Dot -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).DoE = null;
      ((e)localObject1).DoD.eVw();
      if (b.d.DoA != this.Doq) {
        break label644;
      }
      ((e)localObject1).DeA.setVisibility(0);
      com.tencent.mm.ui.tools.j.D(((e)localObject1).DoC, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).jxm.setVisibility(0);
      break;
      ((e)localObject1).DoE = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.Dow;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.Qi(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.Dot <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).z((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).DoD).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).DoD.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label644:
      ((e)localObject1).DeA.setVisibility(8);
      com.tencent.mm.ui.tools.j.D(((e)localObject1).DoC, 1.0F);
    }
    label666:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(28679);
    this.Dop.clear();
    super.onNotifyChange(paramString, paramMStorageEventData);
    AppMethodBeat.o(28679);
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean eVV()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).nnM.setVisibility(8);
        b.c(b.this).DoD.setCanPlay(false);
        b.c(b.this).DoD.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).z(b.c(b.this).DoE.field_fileName, k.Qi(b.c(b.this).DoE.field_fileName), true);
        b.c(b.this).DoD.setThumbBmp(localBitmap);
        b.c(b.this).tlu.setBackgroundResource(2131234879);
        com.tencent.mm.ui.tools.j.D(b.c(b.this).DoC, 1.0F);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.DoE == null)
      {
        Log.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        eVV();
        b.a(b.this, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      if (b.c(b.this) != paramView)
      {
        eVV();
        localObject1 = k.Qh(paramView.DoE.field_fileName);
        paramView.DoD.setCanPlay(true);
        paramView.DoD.e((String)localObject1, false, 0);
        paramView.tlu.setBackgroundResource(2131234880);
        localObject1 = paramView.DoC;
        if ((localObject1 != null) && (!d.oE(11))) {
          break label266;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).eVT();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
        label266:
        Object localObject2 = (Animator)((View)localObject1).getTag(2131306306);
        if (localObject2 != null) {
          ((Animator)localObject2).cancel();
        }
        localObject2 = (AnimatorSet)AnimatorInflater.loadAnimator(((View)localObject1).getContext(), 2130837511);
        ((AnimatorSet)localObject2).setTarget(localObject1);
        ((AnimatorSet)localObject2).start();
        ((View)localObject1).setTag(2131306306, localObject2);
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
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.DoE == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.DoE.field_fileStatus)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.DoA, true);
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
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).eVV();
      paramView = (b.e)paramView.getTag();
      if (paramView.DoE == null)
      {
        Log.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.DoE.field_fileStatus = 6;
      o.bhn().update(paramView.DoE, new String[] { "localId" });
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
    View Bnt;
    ImageView DeA;
    View DoC;
    com.tencent.mm.plugin.sight.decode.a.a DoD;
    com.tencent.mm.modelvideo.j DoE;
    View jxm;
    TextView nnM;
    ImageView tlu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */