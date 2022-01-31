package com.tencent.mm.plugin.websearch.widget.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.i;
import android.support.v4.view.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ServiceWidgetView$a
  extends i
{
  List<WidgetData> kQw;
  private List<ServiceWidgetView.MyFragment> rzK;
  
  public ServiceWidgetView$a(ServiceWidgetView paramServiceWidgetView, android.support.v4.app.g paramg)
  {
    super(paramg);
    AppMethodBeat.i(91491);
    this.rzK = new ArrayList();
    this.kQw = Collections.emptyList();
    AppMethodBeat.o(91491);
  }
  
  public final b JF(int paramInt)
  {
    AppMethodBeat.i(91492);
    if ((paramInt < 0) || (paramInt >= this.rzK.size()))
    {
      AppMethodBeat.o(91492);
      return null;
    }
    b localb = ((ServiceWidgetView.MyFragment)this.rzK.get(paramInt)).uMR;
    AppMethodBeat.o(91492);
    return localb;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(91495);
    if (this.kQw == null)
    {
      AppMethodBeat.o(91495);
      return 0;
    }
    int i = this.kQw.size();
    AppMethodBeat.o(91495);
    return i;
  }
  
  public final Fragment getItem(final int paramInt)
  {
    AppMethodBeat.i(91494);
    ServiceWidgetView.MyFragment localMyFragment;
    if (paramInt >= this.rzK.size())
    {
      localMyFragment = new ServiceWidgetView.MyFragment();
      Object localObject = new Bundle();
      ((Bundle)localObject).putParcelable("data", (Parcelable)this.kQw.get(paramInt));
      localMyFragment.setArguments((Bundle)localObject);
      this.rzK.add(localMyFragment);
      localObject = localMyFragment.uMR;
      MMActivity localMMActivity = this.uMQ.hwZ;
      ServiceWidgetView localServiceWidgetView = this.uMQ;
      b.b localb = this.uMQ.uMP;
      b.a local1 = new b.a()
      {
        public final int dah()
        {
          AppMethodBeat.i(91489);
          if (ServiceWidgetView.a.this.kQw == null)
          {
            AppMethodBeat.o(91489);
            return 0;
          }
          int i = ServiceWidgetView.a.this.kQw.size();
          AppMethodBeat.o(91489);
          return i;
        }
        
        public final List<y> dai()
        {
          return ServiceWidgetView.a.this.uMQ.uMO;
        }
        
        public final boolean daj()
        {
          return paramInt > 0;
        }
        
        public final boolean hasNext()
        {
          AppMethodBeat.i(91490);
          if (paramInt < ServiceWidgetView.a.this.kQw.size() - 1)
          {
            AppMethodBeat.o(91490);
            return true;
          }
          AppMethodBeat.o(91490);
          return false;
        }
      };
      com.tencent.mm.plugin.websearch.api.g localg = this.uMQ.mYf;
      WidgetData localWidgetData = (WidgetData)this.kQw.get(paramInt);
      ((b)localObject).hwZ = localMMActivity;
      ((b)localObject).mXR = localServiceWidgetView;
      ((b)localObject).uMP = localb;
      ((b)localObject).uNf = local1;
      ((b)localObject).mYf = localg;
      ((b)localObject).uNg = localWidgetData;
      if (paramInt != this.uMQ.rwj.getCurrentItem()) {
        break label240;
      }
      ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(true);
    }
    for (;;)
    {
      ab.i("ServiceWidgetView", "getItem %s, fragment %s", new Object[] { Integer.valueOf(paramInt), localMyFragment.toString() });
      AppMethodBeat.o(91494);
      return localMyFragment;
      localMyFragment = (ServiceWidgetView.MyFragment)this.rzK.get(paramInt);
      break;
      label240:
      ServiceWidgetView.MyFragment.a(localMyFragment).setSelected(false);
    }
  }
  
  public final int getItemPosition(Object paramObject)
  {
    AppMethodBeat.i(91493);
    paramObject = ((ServiceWidgetView.MyFragment)paramObject).uMR;
    if (paramObject != null)
    {
      int i = this.kQw.indexOf(paramObject.uNg);
      if (i >= 0)
      {
        AppMethodBeat.o(91493);
        return i;
      }
      AppMethodBeat.o(91493);
      return -2;
    }
    AppMethodBeat.o(91493);
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.a
 * JD-Core Version:    0.7.0.1
 */