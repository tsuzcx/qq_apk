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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aq;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private l JAh;
  private z KpV;
  private List<m> ayS;
  
  public f(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
    AppMethodBeat.i(96438);
    this.KpV = paramz;
    this.ayS = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void c(aa paramaa)
  {
    AppMethodBeat.i(96448);
    if ((paramaa instanceof z)) {
      this.KpV = ((z)paramaa);
    }
    super.c(paramaa);
    AppMethodBeat.o(96448);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96439);
    if (this.JAh == null)
    {
      this.JAh = new l(this.KpV.ayS, this.context, (FrameLayout)this.contentView);
      this.JAh.fP();
      this.ayS = fKf();
    }
    for (;;)
    {
      aq.a(this.contentView, this.KpV.KmA);
      AppMethodBeat.o(96439);
      return;
      this.JAh.notify(this.KpV.ayS);
    }
  }
  
  public final List<m> fKf()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.JAh.fRQ());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  protected final View fKj()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    if (this.KpV.cornerRadius > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setColor(this.backgroundColor);
      localGradientDrawable.setCornerRadius(this.KpV.cornerRadius);
      localFrameLayout.setBackground(localGradientDrawable);
      localFrameLayout.setClipToOutline(true);
    }
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  public final void fKk()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKk();
      }
    }
    super.fKk();
    AppMethodBeat.o(96442);
  }
  
  public final void fKl()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKl();
    }
    super.fKl();
    AppMethodBeat.o(96443);
  }
  
  public final void fKm()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj()) {
        localm.fKm();
      }
    }
    super.fKm();
    AppMethodBeat.o(96444);
  }
  
  public final void fKn()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fRj())
      {
        localm.fKk();
        localm.fKm();
      }
      else
      {
        localm.fKl();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96446);
    super.fKo();
    Iterator localIterator = this.ayS.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).fKo();
    }
    AppMethodBeat.o(96446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */