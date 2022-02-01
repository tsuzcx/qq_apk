package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class x
  extends a
{
  private l Dtq;
  LinearLayout EeN;
  
  public x(Context paramContext, aa paramaa, ViewGroup paramViewGroup)
  {
    super(paramContext, paramaa, paramViewGroup);
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(96622);
    if (((aa)this.EcX).DZx == 0)
    {
      this.EeN.setOrientation(1);
      if (this.Dtq != null) {
        break label117;
      }
      this.Dtq = new l(((aa)this.EcX).DZw, this.context, this.EeN);
      this.Dtq.layout();
    }
    for (;;)
    {
      ap.a(this.contentView, ((aa)this.EcX).DZh);
      AppMethodBeat.o(96622);
      return;
      if (((aa)this.EcX).DZx != 1) {
        break;
      }
      this.EeN.setOrientation(0);
      break;
      label117:
      this.Dtq.gV(((aa)this.EcX).DZw);
    }
  }
  
  public final List<m> eWU()
  {
    AppMethodBeat.i(96624);
    ArrayList localArrayList = new ArrayList(this.Dtq.fdY());
    AppMethodBeat.o(96624);
    return localArrayList;
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96619);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96619);
  }
  
  public final void eWZ()
  {
    AppMethodBeat.i(96616);
    Iterator localIterator = this.Dtq.fdY().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eWZ();
      }
    }
    super.eWZ();
    AppMethodBeat.o(96616);
  }
  
  public final void eXa()
  {
    AppMethodBeat.i(96620);
    Iterator localIterator = this.Dtq.fdY().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXa();
    }
    super.eXa();
    AppMethodBeat.o(96620);
  }
  
  public final void eXb()
  {
    AppMethodBeat.i(96617);
    Iterator localIterator = this.Dtq.fdY().iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      if (localm.fdm()) {
        localm.eXb();
      }
    }
    super.eXb();
    AppMethodBeat.o(96617);
  }
  
  public final void eXc()
  {
    AppMethodBeat.i(96618);
    Iterator localIterator = this.Dtq.fdY().iterator();
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
    AppMethodBeat.o(96618);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96621);
    super.eXd();
    Iterator localIterator = this.Dtq.fdY().iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).eXd();
    }
    AppMethodBeat.o(96621);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96623);
    this.EeN = ((LinearLayout)this.contentView.findViewById(2131308042));
    AppMethodBeat.o(96623);
  }
  
  protected final int getLayout()
  {
    return 2131496389;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x
 * JD-Core Version:    0.7.0.1
 */