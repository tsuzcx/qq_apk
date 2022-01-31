package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ke
  extends kd
{
  protected boolean e;
  protected List<kd> f;
  
  public ke(boolean paramBoolean)
  {
    AppMethodBeat.i(148942);
    this.e = true;
    this.f = null;
    this.e = paramBoolean;
    if (this.f == null) {
      this.f = new ArrayList();
    }
    AppMethodBeat.o(148942);
  }
  
  protected void a(float paramFloat, Interpolator paramInterpolator)
  {
    AppMethodBeat.i(148945);
    if (this.f == null)
    {
      AppMethodBeat.o(148945);
      return;
    }
    int j = this.f.size();
    if (j == 0)
    {
      AppMethodBeat.o(148945);
      return;
    }
    int i = 0;
    if (i < j)
    {
      kd localkd = (kd)this.f.get(i);
      if (localkd != null)
      {
        if (this.e != true) {
          break label90;
        }
        localkd.a(paramFloat, paramInterpolator);
      }
      for (;;)
      {
        i += 1;
        break;
        label90:
        localkd.a(paramFloat, localkd.a());
      }
    }
    AppMethodBeat.o(148945);
  }
  
  public void a(kd.b paramb)
  {
    AppMethodBeat.i(148947);
    super.a(paramb);
    if (this.f == null)
    {
      AppMethodBeat.o(148947);
      return;
    }
    int j = this.f.size();
    if (j == 0)
    {
      AppMethodBeat.o(148947);
      return;
    }
    int i = 0;
    while (i < j)
    {
      kd localkd = (kd)this.f.get(i);
      if (localkd != null) {
        localkd.a(paramb);
      }
      i += 1;
    }
    AppMethodBeat.o(148947);
  }
  
  public void a(kd paramkd)
  {
    AppMethodBeat.i(148943);
    if (paramkd == null)
    {
      AppMethodBeat.o(148943);
      return;
    }
    this.f.add(paramkd);
    AppMethodBeat.o(148943);
  }
  
  public boolean a(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    AppMethodBeat.i(148946);
    boolean bool = super.a(paramGeoPoint1, paramGeoPoint2);
    if (!bool)
    {
      AppMethodBeat.o(148946);
      return false;
    }
    if (this.f == null)
    {
      AppMethodBeat.o(148946);
      return false;
    }
    int j = this.f.size();
    if (j == 0)
    {
      AppMethodBeat.o(148946);
      return false;
    }
    int i = 0;
    if (i < j)
    {
      kd localkd = (kd)this.f.get(i);
      if (localkd == null) {
        break label129;
      }
      if ((bool) && (localkd.a(paramGeoPoint1, paramGeoPoint2))) {
        bool = true;
      }
    }
    label129:
    for (;;)
    {
      i += 1;
      break;
      bool = false;
      continue;
      AppMethodBeat.o(148946);
      return bool;
    }
  }
  
  public void g()
  {
    AppMethodBeat.i(148944);
    if (this.f == null)
    {
      AppMethodBeat.o(148944);
      return;
    }
    this.f.clear();
    AppMethodBeat.o(148944);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ke
 * JD-Core Version:    0.7.0.1
 */