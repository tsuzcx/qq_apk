package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private List<m> aQH;
  private x zUm;
  private l zUn;
  
  public f(Context paramContext, x paramx, ViewGroup paramViewGroup)
  {
    super(paramContext, paramx, paramViewGroup);
    AppMethodBeat.i(96438);
    this.zUm = paramx;
    this.aQH = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void a(y paramy)
  {
    AppMethodBeat.i(96448);
    if ((paramy instanceof x)) {
      this.zUm = ((x)paramy);
    }
    super.a(paramy);
    AppMethodBeat.o(96448);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96439);
    if (this.zUn == null)
    {
      this.zUn = new l(this.zUm.aQH, this.context, (FrameLayout)this.contentView);
      this.zUn.layout();
      this.aQH = eaj();
    }
    for (;;)
    {
      an.a(this.contentView, this.zUm.zRf);
      AppMethodBeat.o(96439);
      return;
      this.zUn.fY(this.zUm.aQH);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dUK();
      }
    }
    super.dUK();
    AppMethodBeat.o(96442);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUL();
    }
    super.dUL();
    AppMethodBeat.o(96443);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96446);
    super.dUM();
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUM();
    }
    AppMethodBeat.o(96446);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dZO();
      }
    }
    super.dZO();
    AppMethodBeat.o(96444);
  }
  
  protected final View eae()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    if (this.zUm.hF > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setColor(this.backgroundColor);
      localGradientDrawable.setCornerRadius(this.zUm.hF);
      localFrameLayout.setBackground(localGradientDrawable);
      localFrameLayout.setClipToOutline(true);
    }
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  public final void eai()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay())
      {
        localm.dUK();
        localm.dZO();
      }
      else
      {
        localm.dUL();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final List<m> eaj()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.zUn.ebh());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */