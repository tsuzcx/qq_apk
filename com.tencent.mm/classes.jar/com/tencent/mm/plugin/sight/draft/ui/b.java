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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.r;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class b
  extends r<com.tencent.mm.modelvideo.j>
{
  private int it;
  private int onm;
  a xEB;
  private b xEC;
  private c xED;
  private Set<e> xEE;
  private b.d xEF;
  a xEG;
  int xEH;
  int xEI;
  private int xEJ;
  private int xEK;
  private c xEL;
  e xEM;
  
  public b(Context paramContext, a parama)
  {
    super(paramContext, null);
    AppMethodBeat.i(28675);
    this.xEB = new a((byte)0);
    this.xEC = new b((byte)0);
    this.xED = new c((byte)0);
    this.xEE = new HashSet();
    this.xEF = b.d.xEO;
    this.xEH = 2131763698;
    this.xEI = 0;
    this.xEL = new c()
    {
      public final void s(String paramAnonymousString, Bitmap paramAnonymousBitmap)
      {
        AppMethodBeat.i(28666);
        Iterator localIterator = b.a(b.this).iterator();
        while (localIterator.hasNext())
        {
          b.e locale = (b.e)localIterator.next();
          if ((locale.xEU != null) && (bs.bG(paramAnonymousString, "").equals(locale.xEU.field_fileName))) {
            locale.xES.setThumbBmp(paramAnonymousBitmap);
          }
        }
        AppMethodBeat.o(28666);
      }
    };
    this.xEG = parama;
    int i = paramContext.getResources().getDimensionPixelSize(2131166802) * 2;
    this.xEJ = (paramContext.getResources().getDisplayMetrics().widthPixels / 3);
    this.onm = (this.xEJ - i);
    this.it = (this.onm * 3 / 4);
    this.xEK = (i + this.it);
    AppMethodBeat.o(28675);
  }
  
  public final void Xb()
  {
    AppMethodBeat.i(28680);
    Xc();
    super.notifyDataSetChanged();
    AppMethodBeat.o(28680);
  }
  
  public final void Xc()
  {
    AppMethodBeat.i(28681);
    setCursor(o.aJC().aJt());
    AppMethodBeat.o(28681);
  }
  
  final void a(e parame)
  {
    AppMethodBeat.i(28677);
    if (parame == null)
    {
      parame = this.xEE.iterator();
      while (parame.hasNext()) {
        ((e)parame.next()).xET.setVisibility(8);
      }
      AppMethodBeat.o(28677);
      return;
    }
    Iterator localIterator = this.xEE.iterator();
    if (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      View localView = locale.xET;
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
    this.xEE.clear();
    super.a(paramString, paramm);
    AppMethodBeat.o(28679);
  }
  
  public final boolean a(b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(28678);
    if (paramd == this.xEF)
    {
      if ((paramBoolean) && (this.xEG != null)) {
        this.xEG.dEV();
      }
      AppMethodBeat.o(28678);
      return false;
    }
    this.xEF = paramd;
    this.xEB.dEW();
    notifyDataSetChanged();
    if ((paramBoolean) && (this.xEG != null)) {
      this.xEG.dEV();
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
        ((e)localObject3).ifK = ((View)localObject2);
        ((e)localObject3).ifK.setTag(localObject3);
        ((e)localObject3).xER = ((View)localObject2).findViewById(2131304815);
        ((e)localObject3).xES = ((com.tencent.mm.plugin.sight.decode.a.a)((View)localObject2).findViewById(2131304819));
        ((e)localObject3).qTu = ((ImageView)((View)localObject2).findViewById(2131304820));
        ((e)localObject3).xET = ((View)localObject2).findViewById(2131304673);
        ((e)localObject3).lzD = ((TextView)((View)localObject2).findViewById(2131304818));
        ((e)localObject3).lzD.setText(this.xEH);
        ((e)localObject3).xuN = ((ImageView)((View)localObject2).findViewById(2131304804));
        ((b.f)localObject1).xEV.add(localObject3);
        localObject4 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
        ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject4).height = this.xEK;
        paramView.addView((View)localObject2);
        ((View)localObject2).setOnClickListener(this.xEB);
        ((e)localObject3).xuN.setTag(localObject3);
        ((e)localObject3).xuN.setOnClickListener(this.xED);
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
        if (i >= paramViewGroup.xEV.size()) {
          break label667;
        }
        j = paramInt * 3 + i;
        localObject1 = (e)paramViewGroup.xEV.get(i);
        this.xEE.add(localObject1);
        ((e)localObject1).xET.setVisibility(8);
        ((e)localObject1).lzD.setVisibility(8);
        ((e)localObject1).qTu.setBackgroundResource(2131234037);
        ((e)localObject1).xES.e(null, false, 0);
        ((e)localObject1).xES.setCanPlay(false);
        ((e)localObject1).xES.setForceRecordState(false);
        ((ImageView)((e)localObject1).xES).setBackgroundResource(0);
        if (j < getRealCount()) {
          break;
        }
        ((e)localObject1).xEU = null;
        ((e)localObject1).ifK.setVisibility(4);
        com.tencent.mm.ui.tools.j.x(((e)localObject1).xER, 1.0F);
        i += 1;
      }
    }
    this.xEI -= 1;
    Object localObject4 = (com.tencent.mm.modelvideo.j)getItem(j);
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      ((e)localObject1).xEU = null;
      ((e)localObject1).xES.dEx();
      if (b.d.xEP != this.xEF) {
        break label645;
      }
      ((e)localObject1).xuN.setVisibility(0);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).xER, 0.95F);
    }
    for (;;)
    {
      ((e)localObject1).ifK.setVisibility(0);
      break;
      ((e)localObject1).xEU = ((com.tencent.mm.modelvideo.j)localObject4);
      localObject2 = this.xEL;
      localObject3 = ((com.tencent.mm.modelvideo.j)localObject4).field_fileName;
      localObject4 = k.DN(((com.tencent.mm.modelvideo.j)localObject4).field_fileName);
      if (this.xEI <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject2 = ((c)localObject2).x((String)localObject3, (String)localObject4, bool);
        ((ImageView)((e)localObject1).xES).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((e)localObject1).xES.setThumbBmp((Bitmap)localObject2);
        break;
      }
      label645:
      ((e)localObject1).xuN.setVisibility(8);
      com.tencent.mm.ui.tools.j.x(((e)localObject1).xER, 1.0F);
    }
    label667:
    AppMethodBeat.o(28676);
    return paramView;
  }
  
  final class a
    implements View.OnClickListener
  {
    private a() {}
    
    public final boolean dEW()
    {
      AppMethodBeat.i(28668);
      if (b.c(b.this) != null)
      {
        b.c(b.this).lzD.setVisibility(8);
        b.c(b.this).xES.setCanPlay(false);
        b.c(b.this).xES.e(null, false, 0);
        Bitmap localBitmap = b.e(b.this).x(b.c(b.this).xEU.field_fileName, k.DN(b.c(b.this).xEU.field_fileName), true);
        b.c(b.this).xES.setThumbBmp(localBitmap);
        b.c(b.this).qTu.setBackgroundResource(2131234037);
        com.tencent.mm.ui.tools.j.x(b.c(b.this).xER, 1.0F);
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
      if (paramView.xEU == null)
      {
        ac.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[] { b.b(b.this) });
        dEW();
        b.a(b.this, null);
        AppMethodBeat.o(28667);
        return;
      }
      Object localObject1;
      if (b.c(b.this) != paramView)
      {
        dEW();
        localObject1 = k.DM(paramView.xEU.field_fileName);
        paramView.xES.setCanPlay(true);
        paramView.xES.e((String)localObject1, false, 0);
        paramView.qTu.setBackgroundResource(2131234038);
        localObject1 = paramView.xER;
        if ((localObject1 != null) && (!d.la(11))) {
          break label201;
        }
      }
      for (;;)
      {
        b.b(b.this, paramView);
        b.a(b.this, paramView);
        if (b.d(b.this) != null) {
          b.d(b.this).dEU();
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
      if (paramView.xEU == null)
      {
        AppMethodBeat.o(28669);
        return true;
      }
      if (-1 == paramView.xEU.field_fileStatus)
      {
        AppMethodBeat.o(28669);
        return true;
      }
      b.this.a(b.d.xEP, true);
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
      b.f(b.this).dEW();
      paramView = (b.e)paramView.getTag();
      if (paramView.xEU == null)
      {
        ac.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
        AppMethodBeat.o(28670);
        return;
      }
      paramView.xEU.field_fileStatus = 6;
      o.aJC().update(paramView.xEU, new String[] { "localId" });
      b.this.a(null, null);
      if (b.d(b.this) != null) {
        b.d(b.this);
      }
      AppMethodBeat.o(28670);
    }
  }
  
  static final class e
  {
    View ifK;
    TextView lzD;
    ImageView qTu;
    View xER;
    com.tencent.mm.plugin.sight.decode.a.a xES;
    View xET;
    com.tencent.mm.modelvideo.j xEU;
    ImageView xuN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.draft.ui.b
 * JD-Core Version:    0.7.0.1
 */