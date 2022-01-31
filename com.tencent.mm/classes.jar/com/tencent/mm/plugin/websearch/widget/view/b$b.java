package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.m;
import android.support.v4.view.ViewPager;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b$b
  extends m
{
  List<WidgetData> iJQ = Collections.emptyList();
  private List<b.a> oJM = new ArrayList();
  
  public b$b(b paramb, j paramj)
  {
    super(paramj);
  }
  
  public final c BN(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.oJM.size())) {
      return null;
    }
    return ((b.a)this.oJM.get(paramInt)).qXD;
  }
  
  public final int F(Object paramObject)
  {
    paramObject = ((b.a)paramObject).qXD;
    if (paramObject != null)
    {
      int i = this.iJQ.indexOf(paramObject.qXS);
      if (i >= 0) {
        return i;
      }
      return -2;
    }
    return -2;
  }
  
  public final Fragment ae(int paramInt)
  {
    b.a locala;
    if (paramInt >= this.oJM.size())
    {
      locala = new b.a();
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("data", (Parcelable)this.iJQ.get(paramInt));
      locala.setArguments((Bundle)localObject);
      this.oJM.add(locala);
      localObject = locala.qXD;
      MMActivity localMMActivity = this.qXC.gfb;
      b localb = this.qXC;
      c.b localb1 = this.qXC.qXB;
      b.b.1 local1 = new b.b.1(this, paramInt);
      g localg = this.qXC.kCj;
      WidgetData localWidgetData = (WidgetData)this.iJQ.get(paramInt);
      ((c)localObject).gfb = localMMActivity;
      ((c)localObject).kBU = localb;
      ((c)localObject).qXB = localb1;
      ((c)localObject).qXR = local1;
      ((c)localObject).kCj = localg;
      ((c)localObject).qXS = localWidgetData;
      if (paramInt != this.qXC.oGu.getCurrentItem()) {
        break label230;
      }
      b.a.a(locala).setSelected(true);
    }
    for (;;)
    {
      y.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), locala.toString() });
      return locala;
      locala = (b.a)this.oJM.get(paramInt);
      break;
      label230:
      b.a.a(locala).setSelected(false);
    }
  }
  
  public final int getCount()
  {
    if (this.iJQ == null) {
      return 0;
    }
    return this.iJQ.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.b
 * JD-Core Version:    0.7.0.1
 */