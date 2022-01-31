package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.a.b;
import android.support.v4.widget.j;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.map.lib.f;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.dc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class la
  extends j
  implements ht
{
  private List<kz> a;
  private List<kz> b;
  private List<kz> c;
  private kx d;
  private Handler e;
  
  public la(View paramView, kx paramkx)
  {
    super(paramView);
    AppMethodBeat.i(149116);
    this.a = new ArrayList();
    this.b = new ArrayList();
    this.c = new ArrayList();
    this.e = new Handler();
    this.d = paramkx;
    this.d.b().a(this);
    AppMethodBeat.o(149116);
  }
  
  private int b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149125);
    if ((this.a != null) && (this.a.size() > 0))
    {
      int i = this.a.size() - 1;
      kz localkz = (kz)this.a.get(i);
      if (((localkz instanceof lb)) && (localkz.a().contains((int)paramFloat1, (int)paramFloat2)))
      {
        AppMethodBeat.o(149125);
        return i;
      }
    }
    AppMethodBeat.o(149125);
    return -1;
  }
  
  public int a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149123);
    if ((this.a != null) && (this.a.size() > 0))
    {
      int i = b(paramFloat1, paramFloat2);
      if (i != -1)
      {
        AppMethodBeat.o(149123);
        return i;
      }
      i = 0;
      while (i < this.a.size())
      {
        if (((kz)this.a.get(i)).a().contains((int)paramFloat1, (int)paramFloat2))
        {
          AppMethodBeat.o(149123);
          return i;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(149123);
    return -1;
  }
  
  public void a()
  {
    AppMethodBeat.i(149124);
    this.e.post(new la.1(this));
    AppMethodBeat.o(149124);
  }
  
  public void a(jv paramjv)
  {
    AppMethodBeat.i(149126);
    if (paramjv == null)
    {
      AppMethodBeat.o(149126);
      return;
    }
    String str = paramjv.y.u();
    if (StringUtil.isEmpty(str))
    {
      AppMethodBeat.o(149126);
      return;
    }
    if (!paramjv.x())
    {
      AppMethodBeat.o(149126);
      return;
    }
    lb locallb = new lb(this.d, paramjv);
    if (this.a.size() > 0)
    {
      paramjv = (kz)this.a.get(this.a.size() - 1);
      if ((paramjv == null) || (!(paramjv instanceof lb))) {}
    }
    for (;;)
    {
      if (str.startsWith("我的位置"))
      {
        this.a.add(locallb);
        AppMethodBeat.o(149126);
        return;
      }
      this.a.clear();
      this.b.add(locallb);
      Collections.sort(this.b);
      this.a.addAll(this.b);
      this.a.addAll(this.c);
      if (paramjv != null) {
        this.a.add(paramjv);
      }
      AppMethodBeat.o(149126);
      return;
      paramjv = null;
    }
  }
  
  public boolean a(int paramInt)
  {
    AppMethodBeat.i(149122);
    if (paramInt >= this.a.size())
    {
      AppMethodBeat.o(149122);
      return false;
    }
    kz localkz = (kz)this.a.get(paramInt);
    if (localkz == null)
    {
      AppMethodBeat.o(149122);
      return false;
    }
    invalidateVirtualView(paramInt);
    sendEventForVirtualView(paramInt, 1);
    localkz.c();
    AppMethodBeat.o(149122);
    return true;
  }
  
  public void b()
  {
    AppMethodBeat.i(149127);
    this.d.b().a(this);
    a();
    AppMethodBeat.o(149127);
  }
  
  public void c()
  {
    AppMethodBeat.i(149128);
    this.d.b().b(this);
    AppMethodBeat.o(149128);
  }
  
  public void d()
  {
    AppMethodBeat.i(149129);
    this.d.b().b(this);
    this.a.clear();
    this.b.clear();
    this.c.clear();
    AppMethodBeat.o(149129);
  }
  
  public int getVirtualViewAt(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(149117);
    int i = a(paramFloat1, paramFloat2);
    if (i == -1)
    {
      AppMethodBeat.o(149117);
      return -2147483648;
    }
    AppMethodBeat.o(149117);
    return i;
  }
  
  public void getVisibleVirtualViews(List<Integer> paramList)
  {
    AppMethodBeat.i(149118);
    int i = 0;
    while (i < this.a.size())
    {
      paramList.add(Integer.valueOf(i));
      i += 1;
    }
    AppMethodBeat.o(149118);
  }
  
  public boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(149121);
    if (paramInt2 == 16)
    {
      boolean bool = a(paramInt1);
      AppMethodBeat.o(149121);
      return bool;
    }
    AppMethodBeat.o(149121);
    return false;
  }
  
  public void onPopulateEventForVirtualView(int paramInt, AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(149119);
    if (paramInt >= this.a.size())
    {
      paramAccessibilityEvent.getText().add("");
      AppMethodBeat.o(149119);
      return;
    }
    kz localkz = (kz)this.a.get(paramInt);
    if (localkz == null)
    {
      paramAccessibilityEvent = new IllegalArgumentException("Invalid virtual view id");
      AppMethodBeat.o(149119);
      throw paramAccessibilityEvent;
    }
    paramAccessibilityEvent.getText().add(localkz.b());
    AppMethodBeat.o(149119);
  }
  
  public void onPopulateNodeForVirtualView(int paramInt, b paramb)
  {
    AppMethodBeat.i(149120);
    if (paramInt >= this.a.size())
    {
      paramb.setText("");
      paramb.setBoundsInParent(new Rect());
      AppMethodBeat.o(149120);
      return;
    }
    kz localkz = (kz)this.a.get(paramInt);
    if (localkz == null)
    {
      paramb = new IllegalArgumentException("Invalid virtual view id");
      AppMethodBeat.o(149120);
      throw paramb;
    }
    paramb.setText(localkz.b());
    paramb.setBoundsInParent(localkz.a());
    paramb.addAction(16);
    AppMethodBeat.o(149120);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.la
 * JD-Core Version:    0.7.0.1
 */