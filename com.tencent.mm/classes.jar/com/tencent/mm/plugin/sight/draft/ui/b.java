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
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends r<com.tencent.mm.modelvideo.j>
{
  private int kl;
  private int oXj;
  a zjA;
  int zjB;
  int zjC;
  private int zjD;
  private int zjE;
  private c zjF;
  e zjG;
  a zjv;
  private b zjw;
  private c zjx;
  private Set<e> zjy;
  private b.d zjz;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.zjv = new a((byte)0);
    this.zjw = new b((byte)0);
    this.zjx = new c((byte)0);
    this.zjy = new HashSet();
    this.zjz = b.d.zjI;
    this.zjB = 2131763698;
    this.zjC = 0;
    this.zjF = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.zjO != null) && (bu.bI(paramAnonymousString, "").equals(locale.zjO.field_fileName))) {
            locale.zjM.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.zjA = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131166802) * 2;
    this.zjD = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.oXj = (this.zjD - i);
    this.kl = (this.oXj * 3 / 4);
    this.zjE = (i + this.kl);
    AppMethodBeat.o(28675);
  }
  
  public final void ZD()
  {
    AppMethodBeat.i(28680);
    ZE();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void ZE()
  {
    AppMethodBeat.i(28681);
    setCursor(o.aNl().aNc());
    AppMethodBeat.o(28681);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.zjy.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).zjN.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.zjy.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.zjN;
      if (parame == locale) {}
      for (int i = 8;; i = 0)
      {
        localView.setVisibility(i);
        break;
      }
    }
    AppMethodBeat.o(28677);
  }
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(28679);
    this.zjy.clear();
    super.a(paramString, paramm);
    AppMethodBeat.o(28679);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28678);
    if (paramd == this.zjz)
    {
      if ((paramBoolean) && (this.zjA != null)) {
        this.zjA.dTU();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.zjz = paramd;
    this.zjv.dTV();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.zjA != null)) {
      this.zjA.dTU();
    }
    AppMethodBeat.o(28678);
    return true;
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
        localObject2 = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495450, paramView, false);
        localObject3 = new e((byte)0);
        ((e)localObject3).iBX = ((View)localObject2);
        ((e)localObject3).iBX.setTag(localObject3);
        ((e)localObject3).zjL = ((View)localObject2).findViewById(2131304815);
        ((e)localObject3).zjM = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131304819));
        ((e)localObject3).rLI = ((ImageView)((View)localObject2).findViewById(2131304820));
        ((e)localObject3).zjN = ((View)localObject2).findViewById(2131304673);
        ((e)localObject3).mdu = ((TextView)((View)localObject2).findViewById(2131304818));
        ((e)localObject3).mdu.setText(this.zjB);
        ((e)localObject3).yZI = ((ImageView)((View)localObject2).findViewById(2131304804));
        ((b.f)localObject1).zjP.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.zjE;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.zjv);
        ((e)localObject3).yZI.setTag(localObject3);
        ((e)localObject3).yZI.setOnClickListener(this.zjx);
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
        if (i >= paramViewGroup.zjP.size()) {
          break label667;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.zjP.get(i);
        this.zjy.add(localObject1);
        ((e)localObject1).zjN.setVisibility(8);
        ((e)localObject1).mdu.setVisibility(8);
        ((e)localObject1).rLI.setBackgroundResource(2131234037);
        ((e)localObject1).zjM.e(null, false, 0);
        ((e)localObject1).zjM.setCanPlay(false);
        ((e)localObject1).zjM.setForceRecordState(false);
        ((ImageView)((e)localObject1).zjM).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).zjO = null;
        ((e)localObject1).iBX.setVisibility(4);
        com.tencent.mm.ui.tools.j.x(((e)localObject1).zjL, 1.0F);
        i += 1;
      }
    }
    this.zjC -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).zjO = null;
      ((e)localObject1).zjM.dTx();
      if (b.d.zjJ != this.zjz) {
        break label645;
      }
      ((e)localObject1).yZI.setVisibility(0);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).zjL, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).iBX.setVisibility(0);
      break;
      ((e)localObject1).zjO = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.zjF;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.Hv(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.zjC <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).x((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).zjM).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).zjM.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label645:
      ((e)localObject1).yZI.setVisibility(8);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).zjL, 1.0F);
    }
    label667:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean dTV()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).mdu.setVisibility(8);
        b.c(b.this).zjM.setCanPlay(false);
        b.c(b.this).zjM.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).x(b.c(b.this).zjO.field_fileName, k.Hv(b.c(b.this).zjO.field_fileName), true);
        b.c(b.this).zjM.setThumbBmp(localBitmap);
        b.c(b.this).rLI.setBackgroundResource(2131234037);
        com.tencent.mm.ui.tools.j.x(b.c(b.this).zjL, 1.0F);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.zjO == null)
      {
        ae.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        dTV();
        b.a(b.this, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      if (b.c(b.this) != paramView)
      {
        dTV();
        localObject1 = k.Hu(paramView.zjO.field_fileName);
        paramView.zjM.setCanPlay(true);
        paramView.zjM.e((String)localObject1, false, 0);
        paramView.rLI.setBackgroundResource(2131234038);
        localObject1 = paramView.zjL;
        if ((localObject1 != null) && (!d.lB(11))) {
          break label266;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).dTT();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
        label266:
        Object localObject2 = (Animator)((View)localObject1).getTag(2131303537);
        if (localObject2 != null) {
          ((Animator)localObject2).cancel();
        }
        localObject2 = (AnimatorSet)AnimatorInflater.loadAnimator(((View)localObject1).getContext(), 2130837511);
        ((AnimatorSet)localObject2).setTarget(localObject1);
        ((AnimatorSet)localObject2).start();
        ((View)localObject1).setTag(2131303537, localObject2);
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
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.zjO == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.zjO.field_fileStatus)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.zjJ, true);
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
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).dTV();
      paramView = (b.e)paramView.getTag();
      if (paramView.zjO == null)
      {
        ae.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.zjO.field_fileStatus = 6;
      o.aNl().update(paramView.zjO, new String[] { "localId" });
      b.this.a(null, null);
      if (b.d(b.this) != null) {
        b.d(b.this);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(28670);
    }
  }
  
  static final class e
  {
    View iBX;
    TextView mdu;
    ImageView rLI;
    ImageView yZI;
    View zjL;
    com.tencent.mm.plugin.sight.decode.a.a zjM;
    View zjN;
    com.tencent.mm.modelvideo.j zjO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */