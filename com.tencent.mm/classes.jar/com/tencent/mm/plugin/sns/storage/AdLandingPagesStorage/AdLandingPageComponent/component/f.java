package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends a
{
  private List<l> aQH;
  private w zDk;
  private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l zDl;
  
  public f(Context paramContext, w paramw, ViewGroup paramViewGroup)
  {
    super(paramContext, paramw, paramViewGroup);
    AppMethodBeat.i(96438);
    this.zDk = paramw;
    this.aQH = new ArrayList();
    AppMethodBeat.o(96438);
  }
  
  public final void a(x paramx)
  {
    AppMethodBeat.i(96448);
    if ((paramx instanceof w)) {
      this.zDk = ((w)paramx);
    }
    super.a(paramx);
    AppMethodBeat.o(96448);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96439);
    if (this.zDl == null)
    {
      this.zDl = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l(this.zDk.aQH, this.context, (FrameLayout)this.contentView);
      this.zDl.layout();
      this.aQH = dWH();
      AppMethodBeat.o(96439);
      return;
    }
    this.zDl.fP(this.zDk.aQH);
    AppMethodBeat.o(96439);
  }
  
  public final void dRm()
  {
    AppMethodBeat.i(96442);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dRm();
      }
    }
    super.dRm();
    AppMethodBeat.o(96442);
  }
  
  public final void dRn()
  {
    AppMethodBeat.i(96443);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRn();
    }
    super.dRn();
    AppMethodBeat.o(96443);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96446);
    super.dRo();
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext()) {
      ((l)localIterator.next()).dRo();
    }
    AppMethodBeat.o(96446);
  }
  
  protected final View dWC()
  {
    AppMethodBeat.i(96441);
    FrameLayout localFrameLayout = new FrameLayout(this.context);
    AppMethodBeat.o(96441);
    return localFrameLayout;
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96440);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96440);
  }
  
  public final void dWG()
  {
    AppMethodBeat.i(96445);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU())
      {
        locall.dRm();
        locall.dWm();
      }
      else
      {
        locall.dRn();
      }
    }
    AppMethodBeat.o(96445);
  }
  
  public final List<l> dWH()
  {
    AppMethodBeat.i(96447);
    ArrayList localArrayList = new ArrayList(this.zDl.dXE());
    AppMethodBeat.o(96447);
    return localArrayList;
  }
  
  public final void dWm()
  {
    AppMethodBeat.i(96444);
    Iterator localIterator = this.aQH.iterator();
    while (localIterator.hasNext())
    {
      l locall = (l)localIterator.next();
      if (locall.dWU()) {
        locall.dWm();
      }
    }
    super.dWm();
    AppMethodBeat.o(96444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f
 * JD-Core Version:    0.7.0.1
 */