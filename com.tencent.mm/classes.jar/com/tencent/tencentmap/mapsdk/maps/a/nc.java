package com.tencent.tencentmap.mapsdk.maps.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.aa;
import com.tencent.tencentmap.mapsdk.a.ah;
import com.tencent.tencentmap.mapsdk.a.ap;
import com.tencent.tencentmap.mapsdk.a.cf;
import com.tencent.tencentmap.mapsdk.a.cn;
import com.tencent.tencentmap.mapsdk.a.cu;
import com.tencent.tencentmap.mapsdk.a.cw;
import java.util.ArrayList;
import java.util.List;

public class nc
  implements AdapterView.OnItemClickListener, nb, nd.a
{
  private static final int p;
  public boolean a;
  private RelativeLayout b;
  private nd c;
  private TextView d;
  private View e;
  private View f;
  private View g;
  private Bitmap h;
  private Bitmap i;
  private float j;
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private int o;
  private nc.a q;
  private Context r;
  private aa s;
  private int t;
  private int u;
  private cu v;
  private String w;
  private boolean x;
  private cf y;
  private nc.a.a z;
  
  static
  {
    AppMethodBeat.i(149396);
    p = Color.argb(200, 56, 56, 56);
    AppMethodBeat.o(149396);
  }
  
  public nc(Context paramContext, aa paramaa)
  {
    AppMethodBeat.i(149378);
    this.j = 1.0F;
    this.k = 45;
    this.l = 4;
    this.m = 90;
    this.n = 10;
    this.o = 0;
    this.t = -1;
    this.u = 0;
    this.x = false;
    this.a = false;
    this.z = null;
    this.s = paramaa;
    this.r = paramContext.getApplicationContext();
    this.x = true;
    AppMethodBeat.o(149378);
  }
  
  private int a(Adapter paramAdapter)
  {
    AppMethodBeat.i(149394);
    this.d.measure(0, 0);
    int i1 = this.d.getMeasuredWidth();
    int i4 = paramAdapter.getCount();
    int i2 = 0;
    View localView = null;
    if (i2 < i4)
    {
      localView = paramAdapter.getView(i2, localView, this.c);
      localView.measure(0, 0);
      int i3 = localView.getMeasuredWidth();
      if (i3 <= i1) {
        break label93;
      }
      i1 = i3;
    }
    label93:
    for (;;)
    {
      i2 += 1;
      break;
      AppMethodBeat.o(149394);
      return i1;
    }
  }
  
  private void a(Context paramContext)
  {
    AppMethodBeat.i(149380);
    this.j = paramContext.getApplicationContext().getResources().getDisplayMetrics().density;
    this.o = ((int)(234.0D * this.j));
    AppMethodBeat.o(149380);
  }
  
  @TargetApi(9)
  private void a(Context paramContext, nc.a parama)
  {
    AppMethodBeat.i(149384);
    this.b = new RelativeLayout(paramContext);
    this.d = new TextView(paramContext);
    this.d.setSingleLine(true);
    this.e = new View(paramContext);
    this.c = new nd(paramContext);
    this.f = new View(paramContext);
    this.g = new View(paramContext);
    this.c.setChoiceMode(1);
    this.c.setAdapter(parama);
    this.c.setOnItemClickListener(this);
    this.c.setVerticalScrollBarEnabled(false);
    this.c.setHorizontalScrollBarEnabled(false);
    this.c.setOverScrollMode(2);
    this.c.setDivider(null);
    this.c.setDividerHeight(0);
    this.c.setOnDataChangedListener(this);
    paramContext = new RelativeLayout.LayoutParams((int)(30.0F * this.j), -2);
    paramContext.addRule(14, -1);
    paramContext.topMargin = ((int)(this.j * 6.0F));
    this.d.setId(this.d.hashCode());
    this.d.setText("楼层");
    this.d.setTextSize(12.0F);
    this.d.setGravity(17);
    this.d.setTextColor(Color.argb(200, 56, 56, 56));
    this.b.addView(this.d, paramContext);
    paramContext = new RelativeLayout.LayoutParams((int)(30.0F * this.j), (int)(1.0F * this.j));
    paramContext.addRule(3, this.d.getId());
    paramContext.addRule(14, -1);
    paramContext.topMargin = ((int)(this.j * 6.0F));
    this.e.setBackgroundColor(-3355444);
    this.e.setId(this.e.hashCode());
    this.b.addView(this.e, paramContext);
    if (this.h != null)
    {
      parama = this.h.getNinePatchChunk();
      jl localjl = jl.a(parama);
      paramContext = new Rect();
      if (localjl != null) {
        paramContext = localjl.a;
      }
      paramContext = new NinePatchDrawable(this.r.getResources(), this.h, parama, paramContext, null);
      this.b.setBackgroundDrawable(paramContext);
    }
    paramContext = new RelativeLayout.LayoutParams((int)(25.0F * this.j), (int)(180.0F * this.j));
    paramContext.addRule(3, this.e.getId());
    paramContext.addRule(14, -1);
    this.b.addView(this.c, paramContext);
    a(this.s);
    this.b.measure(0, 0);
    this.b.setVisibility(8);
    AppMethodBeat.o(149384);
  }
  
  private void a(List<cw> paramList)
  {
    AppMethodBeat.i(149391);
    FrameLayout.LayoutParams localLayoutParams;
    if ((paramList.size() < 4) && (paramList.size() != this.u))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.height = ((int)(this.o - (4 - paramList.size()) * 45 * this.j));
      this.s.updateViewLayout(this.b, localLayoutParams);
    }
    for (;;)
    {
      this.u = paramList.size();
      if (this.q != null) {
        this.q.a(paramList);
      }
      if (this.b.getVisibility() != 0) {
        this.b.post(new nc.1(this));
      }
      AppMethodBeat.o(149391);
      return;
      if ((paramList.size() != this.u) && (this.u < 4))
      {
        localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
        localLayoutParams.height = this.o;
        this.s.updateViewLayout(this.b, localLayoutParams);
      }
    }
  }
  
  private void b(Context paramContext)
  {
    AppMethodBeat.i(149381);
    this.h = ka.b(paramContext, "indoor_background.9.png");
    this.i = ka.b(paramContext, "item_selected_background.png");
    AppMethodBeat.o(149381);
  }
  
  private void e()
  {
    AppMethodBeat.i(149379);
    if (this.b == null)
    {
      this.q = new nc.a(this, this.r, new ArrayList());
      a(this.r);
      b(this.r);
      a(this.r, this.q);
      if ((this.s.getMap() != null) && (this.s.getMap().c() != null) && (this.s.getMap().c().k() != null)) {
        this.y = this.s.getMap().c().k().H();
      }
    }
    AppMethodBeat.o(149379);
  }
  
  private FrameLayout.LayoutParams f()
  {
    AppMethodBeat.i(149389);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, this.o);
    localLayoutParams.gravity = 83;
    localLayoutParams.leftMargin = ((int)(10.0F * this.j));
    localLayoutParams.bottomMargin = ((int)(90.0F * this.j));
    AppMethodBeat.o(149389);
    return localLayoutParams;
  }
  
  private void g()
  {
    AppMethodBeat.i(149392);
    if (this.v == null)
    {
      AppMethodBeat.o(149392);
      return;
    }
    int i1 = this.v.d();
    List localList = this.v.c();
    if ((localList == null) || (i1 >= localList.size()) || (i1 == -1))
    {
      AppMethodBeat.o(149392);
      return;
    }
    if ((cw)localList.get(i1) == null)
    {
      AppMethodBeat.o(149392);
      return;
    }
    if ((this.w != null) && (this.a) && (this.w.equals(this.v.a())))
    {
      this.c.setItemChecked(i1, true);
      this.a = false;
    }
    for (;;)
    {
      this.t = i1;
      this.w = this.v.a();
      AppMethodBeat.o(149392);
      return;
      this.c.setSelectionFromTop(i1, (int)(45.0F * this.j + 0.5D) * 2);
    }
  }
  
  private void h()
  {
    AppMethodBeat.i(149393);
    if (this.c != null)
    {
      ((RelativeLayout.LayoutParams)this.c.getLayoutParams()).width = a(this.q);
      this.c.requestLayout();
    }
    AppMethodBeat.o(149393);
  }
  
  public void a()
  {
    AppMethodBeat.i(149386);
    if (this.h != null) {
      this.h.recycle();
    }
    if (this.i != null) {
      this.i.recycle();
    }
    AppMethodBeat.o(149386);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(149385);
    if ((this.x) && (paramInt2 < this.o + 90.0F * this.j))
    {
      this.b.setVisibility(8);
      AppMethodBeat.o(149385);
      return;
    }
    this.b.setVisibility(0);
    AppMethodBeat.o(149385);
  }
  
  public void a(cu paramcu)
  {
    AppMethodBeat.i(149383);
    if (paramcu == null)
    {
      AppMethodBeat.o(149383);
      return;
    }
    if (this.b == null) {
      e();
    }
    this.v = paramcu;
    a(paramcu.c());
    AppMethodBeat.o(149383);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(149382);
    if ((this.s == null) || (this.s.getMap() == null))
    {
      AppMethodBeat.o(149382);
      return;
    }
    if (paramBoolean) {}
    for (this.x = true;; this.x = false)
    {
      b(this.x);
      AppMethodBeat.o(149382);
      return;
    }
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(149387);
    if (paramViewGroup.indexOfChild(this.b) < 0) {
      paramViewGroup.addView(this.b, f());
    }
    h();
    AppMethodBeat.o(149387);
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    AppMethodBeat.i(149390);
    if ((this.s == null) || (this.s.getMap() == null))
    {
      AppMethodBeat.o(149390);
      return;
    }
    if (this.b == null)
    {
      if (!paramBoolean)
      {
        AppMethodBeat.o(149390);
        return;
      }
      e();
    }
    ah localah = this.s.getMap();
    cn localcn = localah.d();
    if ((this.x) && (paramBoolean) && (localcn != null) && (this.y != null) && (this.y.c()))
    {
      if (this.b.getVisibility() != 0)
      {
        a(localah.c().c(localcn.a));
        AppMethodBeat.o(149390);
      }
    }
    else if (this.b.getVisibility() == 0) {
      this.b.setVisibility(8);
    }
    AppMethodBeat.o(149390);
  }
  
  public boolean b()
  {
    return this.x;
  }
  
  public void c()
  {
    AppMethodBeat.i(149395);
    h();
    g();
    AppMethodBeat.o(149395);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(149388);
    paramAdapterView = this.s.getMap();
    if (paramAdapterView == null)
    {
      AppMethodBeat.o(149388);
      return;
    }
    if (this.z != null)
    {
      this.z.a.setTextColor(-16777216);
      this.z.b.setVisibility(4);
    }
    paramView = (nc.a.a)paramView.getTag();
    paramView.a.setTextColor(-1);
    paramView.b.setVisibility(0);
    this.z = paramView;
    this.t = paramInt;
    this.a = true;
    paramAdapterView.c(paramInt);
    AppMethodBeat.o(149388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.nc
 * JD-Core Version:    0.7.0.1
 */