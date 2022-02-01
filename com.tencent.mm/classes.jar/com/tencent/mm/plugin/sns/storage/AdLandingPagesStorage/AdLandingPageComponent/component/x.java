package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.an;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class x
  extends a
{
  private l zUn;
  LinearLayout zWE;
  
  public x(Context paramContext, z paramz, ViewGroup paramViewGroup)
  {
    super(paramContext, paramz, paramViewGroup);
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(96623);
    this.zWE = ((LinearLayout)this.contentView.findViewById(2131304906));
    AppMethodBeat.o(96623);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96622);
    if (((z)this.zUP).zRr == 0)
    {
      this.zWE.setOrientation(1);
      if (this.zUn != null) {
        break label117;
      }
      this.zUn = new l(((z)this.zUP).zRq, this.context, this.zWE);
      this.zUn.layout();
    }
    for (;;)
    {
      an.a(this.contentView, ((z)this.zUP).zRf);
      AppMethodBeat.o(96622);
      return;
      if (((z)this.zUP).zRr != 1) {
        break;
      }
      this.zWE.setOrientation(0);
      break;
      label117:
      this.zUn.fY(((z)this.zUP).zRq);
    }
  }
  
  public final void dUK()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.zUn.ebh().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dUK();
      }
    }
    super.dUK();
    AppMethodBeat.o(96616);
  }
  
  public final void dUL()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.zUn.ebh().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUL();
    }
    super.dUL();
    AppMethodBeat.o(96620);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96621);
    super.dUM();
    Iterator localIterator = this.zUn.ebh().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).dUM();
    }
    AppMethodBeat.o(96621);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.zUn.ebh().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.eay()) {
        localm.dZO();
      }
    }
    super.dZO();
    AppMethodBeat.o(96617);
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void eai()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.zUn.ebh().iterator();
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
    AppMethodBeat.o(96618);
  }
  
  public final List<m> eaj()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.zUn.ebh());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  protected final int getLayout()
  {
    return 2131495504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */