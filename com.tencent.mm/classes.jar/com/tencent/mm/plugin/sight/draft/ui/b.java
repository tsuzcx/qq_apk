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
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends r<com.tencent.mm.modelvideo.j>
{
  private int kl;
  private int oQH;
  a yTl;
  private b yTm;
  private c yTn;
  private Set<e> yTo;
  private b.d yTp;
  a yTq;
  int yTr;
  int yTs;
  private int yTt;
  private int yTu;
  private c yTv;
  e yTw;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.yTl = new a((byte)0);
    this.yTm = new b((byte)0);
    this.yTn = new c((byte)0);
    this.yTo = new HashSet();
    this.yTp = b.d.yTy;
    this.yTr = 2131763698;
    this.yTs = 0;
    this.yTv = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.yTE != null) && (bt.bI(paramAnonymousString, "").equals(locale.yTE.field_fileName))) {
            locale.yTC.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.yTq = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131166802) * 2;
    this.yTt = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.oQH = (this.yTt - i);
    this.kl = (this.oQH * 3 / 4);
    this.yTu = (i + this.kl);
    AppMethodBeat.o(28675);
  }
  
  public final void Zu()
  {
    AppMethodBeat.i(28680);
    Zv();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void Zv()
  {
    AppMethodBeat.i(28681);
    setCursor(o.aMN().aME());
    AppMethodBeat.o(28681);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.yTo.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).yTD.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.yTo.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.yTD;
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
    this.yTo.clear();
    super.a(paramString, paramm);
    AppMethodBeat.o(28679);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28678);
    if (paramd == this.yTp)
    {
      if ((paramBoolean) && (this.yTq != null)) {
        this.yTq.dQx();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.yTp = paramd;
    this.yTl.dQy();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.yTq != null)) {
      this.yTq.dQx();
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
        ((e)localObject3).ize = ((View)localObject2);
        ((e)localObject3).ize.setTag(localObject3);
        ((e)localObject3).yTB = ((View)localObject2).findViewById(2131304815);
        ((e)localObject3).yTC = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131304819));
        ((e)localObject3).rDx = ((ImageView)((View)localObject2).findViewById(2131304820));
        ((e)localObject3).yTD = ((View)localObject2).findViewById(2131304673);
        ((e)localObject3).lZb = ((TextView)((View)localObject2).findViewById(2131304818));
        ((e)localObject3).lZb.setText(this.yTr);
        ((e)localObject3).yJy = ((ImageView)((View)localObject2).findViewById(2131304804));
        ((b.f)localObject1).yTF.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.yTu;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.yTl);
        ((e)localObject3).yJy.setTag(localObject3);
        ((e)localObject3).yJy.setOnClickListener(this.yTn);
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
        if (i >= paramViewGroup.yTF.size()) {
          break label667;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.yTF.get(i);
        this.yTo.add(localObject1);
        ((e)localObject1).yTD.setVisibility(8);
        ((e)localObject1).lZb.setVisibility(8);
        ((e)localObject1).rDx.setBackgroundResource(2131234037);
        ((e)localObject1).yTC.e(null, false, 0);
        ((e)localObject1).yTC.setCanPlay(false);
        ((e)localObject1).yTC.setForceRecordState(false);
        ((ImageView)((e)localObject1).yTC).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).yTE = null;
        ((e)localObject1).ize.setVisibility(4);
        com.tencent.mm.ui.tools.j.x(((e)localObject1).yTB, 1.0F);
        i += 1;
      }
    }
    this.yTs -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).yTE = null;
      ((e)localObject1).yTC.dQa();
      if (b.d.yTz != this.yTp) {
        break label645;
      }
      ((e)localObject1).yJy.setVisibility(0);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).yTB, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).ize.setVisibility(0);
      break;
      ((e)localObject1).yTE = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.yTv;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.GT(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.yTs <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).x((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).yTC).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).yTC.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label645:
      ((e)localObject1).yJy.setVisibility(8);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).yTB, 1.0F);
    }
    label667:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean dQy()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).lZb.setVisibility(8);
        b.c(b.this).yTC.setCanPlay(false);
        b.c(b.this).yTC.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).x(b.c(b.this).yTE.field_fileName, k.GT(b.c(b.this).yTE.field_fileName), true);
        b.c(b.this).yTC.setThumbBmp(localBitmap);
        b.c(b.this).rDx.setBackgroundResource(2131234037);
        com.tencent.mm.ui.tools.j.x(b.c(b.this).yTB, 1.0F);
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.yTE == null)
      {
        ad.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        dQy();
        b.a(b.this, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28667);
        return;
      }
      if (b.c(b.this) != paramView)
      {
        dQy();
        localObject1 = k.GS(paramView.yTE.field_fileName);
        paramView.yTC.setCanPlay(true);
        paramView.yTC.e((String)localObject1, false, 0);
        paramView.rDx.setBackgroundResource(2131234038);
        localObject1 = paramView.yTB;
        if ((localObject1 != null) && (!d.lz(11))) {
          break label266;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).dQw();
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.yTE == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.yTE.field_fileStatus)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$ContainerLongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.yTz, true);
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      if (!(paramView.getTag() instanceof b.e))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).dQy();
      paramView = (b.e)paramView.getTag();
      if (paramView.yTE == null)
      {
        ad.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sight/draft/ui/SightDraftContainerAdapter$DelBtnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.yTE.field_fileStatus = 6;
      o.aMN().update(paramView.yTE, new String[] { "localId" });
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
    View ize;
    TextView lZb;
    ImageView rDx;
    ImageView yJy;
    View yTB;
    com.tencent.mm.plugin.sight.decode.a.a yTC;
    View yTD;
    com.tencent.mm.modelvideo.j yTE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */