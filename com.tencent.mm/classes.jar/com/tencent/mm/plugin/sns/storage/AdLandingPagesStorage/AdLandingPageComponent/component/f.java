package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.as;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private q PPI;
  private z QOc;
  private List<n> aAO;
  
  public f(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    AppMethodBeat.i(96438);
    this.QOc = paramz;
    this.aAO = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(96448);
    if ((paramaa instanceof z)) {
      this.QOc = ((z)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(96448);
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96439);
    if (this.PPI == null)
    {
      this.PPI = new q(this.QOc.aAO, this.context, (FrameLayout)this.contentView);
      this.PPI.CY();
      this.aAO = hai();
    }
    for (;;)
    {
      as.a(this.contentView, this.QOc.QKF);
      AppMethodBeat.o(96439);
      return;
      this.PPI.notify(this.QOc.aAO);
    }
  }
  
  public final List<n> hai()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.PPI.hjV());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  protected final View ham()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    if (this.QOc.cornerRadius > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setColor(this.backgroundColor);
      localGradientDrawable.setCornerRadius(this.QOc.cornerRadius);
      localFrameLayout.setBackground(localGradientDrawable);
      localFrameLayout.setClipToOutline(true);
    }
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  public final void hao()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.hao();
      }
    }
    super.hao();
    AppMethodBeat.o(96442);
  }
  
  public final void hap()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).hap();
    }
    super.hap();
    AppMethodBeat.o(96443);
  }
  
  public final void haq()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji()) {
        localn.haq();
      }
    }
    super.haq();
    AppMethodBeat.o(96444);
  }
  
  public final void har()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext())
    {
      n localn = (n)localIterator.next();
      if (localn.hji())
      {
        localn.hao();
        localn.haq();
      }
      else
      {
        localn.hap();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96446);
    super.has();
    Iterator localIterator = this.aAO.iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).has();
    }
    AppMethodBeat.o(96446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */