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
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.modelvideo.l;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.q;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends q<com.tencent.mm.modelvideo.j>
{
  private int hr;
  private int nKm;
  a wtl;
  private b wtm;
  private c wtn;
  private Set<e> wto;
  private b.d wtp;
  a wtq;
  int wtr;
  int wts;
  private int wtt;
  private int wtu;
  private c wtv;
  e wtw;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.wtl = new a((byte)0);
    this.wtm = new b((byte)0);
    this.wtn = new c((byte)0);
    this.wto = new HashSet();
    this.wtp = b.d.wty;
    this.wtr = 2131763698;
    this.wts = 0;
    this.wtv = new c()
    {
      public final void t(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.wtE != null) && (bt.by(paramAnonymousString, "").equals(locale.wtE.field_fileName))) {
            locale.wtC.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.wtq = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131166802) * 2;
    this.wtt = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.nKm = (this.wtt - i);
    this.hr = (this.nKm * 3 / 4);
    this.wtu = (i + this.hr);
    AppMethodBeat.o(28675);
  }
  
  public final void Wd()
  {
    AppMethodBeat.i(28680);
    We();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void We()
  {
    AppMethodBeat.i(28681);
    setCursor(o.aCM().aCD());
    AppMethodBeat.o(28681);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.wto.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).wtD.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.wto.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.wtD;
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
    this.wto.clear();
    super.a(paramString, paramm);
    AppMethodBeat.o(28679);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28678);
    if (paramd == this.wtp)
    {
      if ((paramBoolean) && (this.wtq != null)) {
        this.wtq.dqM();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.wtp = paramd;
    this.wtl.dqN();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.wtq != null)) {
      this.wtq.dqM();
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
        ((e)localObject3).hFi = ((View)localObject2);
        ((e)localObject3).hFi.setTag(localObject3);
        ((e)localObject3).wtB = ((View)localObject2).findViewById(2131304815);
        ((e)localObject3).wtC = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131304819));
        ((e)localObject3).qkS = ((ImageView)((View)localObject2).findViewById(2131304820));
        ((e)localObject3).wtD = ((View)localObject2).findViewById(2131304673);
        ((e)localObject3).kXT = ((TextView)((View)localObject2).findViewById(2131304818));
        ((e)localObject3).kXT.setText(this.wtr);
        ((e)localObject3).wjx = ((ImageView)((View)localObject2).findViewById(2131304804));
        ((b.f)localObject1).wtF.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.wtu;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.wtl);
        ((e)localObject3).wjx.setTag(localObject3);
        ((e)localObject3).wjx.setOnClickListener(this.wtn);
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
        if (i >= paramViewGroup.wtF.size()) {
          break label667;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.wtF.get(i);
        this.wto.add(localObject1);
        ((e)localObject1).wtD.setVisibility(8);
        ((e)localObject1).kXT.setVisibility(8);
        ((e)localObject1).qkS.setBackgroundResource(2131234037);
        ((e)localObject1).wtC.e(null, false, 0);
        ((e)localObject1).wtC.setCanPlay(false);
        ((e)localObject1).wtC.setForceRecordState(false);
        ((ImageView)((e)localObject1).wtC).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).wtE = null;
        ((e)localObject1).hFi.setVisibility(4);
        com.tencent.mm.ui.tools.j.w(((e)localObject1).wtB, 1.0F);
        i += 1;
      }
    }
    this.wts -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).wtE = null;
      ((e)localObject1).wtC.dqo();
      if (b.d.wtz != this.wtp) {
        break label645;
      }
      ((e)localObject1).wjx.setVisibility(0);
      com.tencent.mm.ui.tools.j.w(((e)localObject1).wtB, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).hFi.setVisibility(0);
      break;
      ((e)localObject1).wtE = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.wtv;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.zI(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.wts <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).x((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).wtC).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).wtC.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label645:
      ((e)localObject1).wjx.setVisibility(8);
      com.tencent.mm.ui.tools.j.w(((e)localObject1).wtB, 1.0F);
    }
    label667:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean dqN()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).kXT.setVisibility(8);
        b.c(b.this).wtC.setCanPlay(false);
        b.c(b.this).wtC.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).x(b.c(b.this).wtE.field_fileName, k.zI(b.c(b.this).wtE.field_fileName), true);
        b.c(b.this).wtC.setThumbBmp(localBitmap);
        b.c(b.this).qkS.setBackgroundResource(2131234037);
        com.tencent.mm.ui.tools.j.w(b.c(b.this).wtB, 1.0F);
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
      if (!(paramView.getTag() instanceof b.e))
      {
        AppMethodBeat.o(28667);
        return;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.wtE == null)
      {
        ad.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        dqN();
        b.a(b.this, null);
        AppMethodBeat.o(28667);
        return;
      }
      Object localObject1;
      if (b.c(b.this) != paramView)
      {
        dqN();
        localObject1 = k.zH(paramView.wtE.field_fileName);
        paramView.wtC.setCanPlay(true);
        paramView.wtC.e((String)localObject1, false, 0);
        paramView.qkS.setBackgroundResource(2131234038);
        localObject1 = paramView.wtB;
        if ((localObject1 != null) && (!d.lg(11))) {
          break label201;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).dqL();
        }
        AppMethodBeat.o(28667);
        return;
        label201:
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
      if (!(paramView.getTag() instanceof b.e))
      {
        AppMethodBeat.o(28669);
        return true;
      }
      paramView = (b.e)paramView.getTag();
      if (paramView.wtE == null)
      {
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.wtE.field_fileStatus)
      {
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.wtz, true);
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
      if (!(paramView.getTag() instanceof b.e))
      {
        AppMethodBeat.o(28670);
        return;
      }
      b.f(b.this).dqN();
      paramView = (b.e)paramView.getTag();
      if (paramView.wtE == null)
      {
        ad.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.wtE.field_fileStatus = 6;
      o.aCM().update(paramView.wtE, new String[] { "localId" });
      b.this.a(null, null);
      if (b.d(b.this) != null) {
        b.d(b.this);
      }
      AppMethodBeat.o(28670);
    }
  }
  
  static final class e
  {
    View hFi;
    TextView kXT;
    ImageView qkS;
    ImageView wjx;
    View wtB;
    com.tencent.mm.plugin.sight.decode.a.a wtC;
    View wtD;
    com.tencent.mm.modelvideo.j wtE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */