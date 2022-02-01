package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private l Dtq;
  private y Ecu;
  private List<m> aQz;
  
  public f(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
    AppMethodBeat.i(96438);
    this.Ecu = paramy;
    this.aQz = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void b(z paramz)
  {
    AppMethodBeat.i(96448);
    if ((paramz instanceof y)) {
      this.Ecu = ((y)paramz);
    }
    super.b(paramz);
    AppMethodBeat.o(96448);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96439);
    if (this.Dtq == null)
    {
      this.Dtq = new l(this.Ecu.aQz, this.context, (FrameLayout)this.contentView);
      this.Dtq.layout();
      this.aQz = eWU();
    }
    for (;;)
    {
      ap.a(this.contentView, this.Ecu.DZh);
      AppMethodBeat.o(96439);
      return;
      this.Dtq.gV(this.Ecu.aQz);
    }
  }
  
  public final List<m> eWU()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.Dtq.fdY());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  protected final View eWY()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    if (this.Ecu.hH > 0)
    {
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      localGradientDrawable.setColor(this.backgroundColor);
      localGradientDrawable.setCornerRadius(this.Ecu.hH);
      localFrameLayout.setBackground(localGradientDrawable);
      localFrameLayout.setClipToOutline(true);
    }
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eWZ();
      }
    }
    super.eWZ();
    AppMethodBeat.o(96442);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXa();
    }
    super.eXa();
    AppMethodBeat.o(96443);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eXb();
      }
    }
    super.eXb();
    AppMethodBeat.o(96444);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm())
      {
        localm.eWZ();
        localm.eXb();
      }
      else
      {
        localm.eXa();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96446);
    super.eXd();
    Iterator localIterator = this.aQz.iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXd();
    }
    AppMethodBeat.o(96446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */