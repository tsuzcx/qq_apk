package com.tencent.tencentmap.mapsdk.a;

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class mq
  implements AdapterView.OnItemClickListener, mp, mr.a
{
  private static final int p = Color.argb(200, 56, 56, 56);
  public boolean a = false;
  private RelativeLayout b;
  private mr c;
  private TextView d;
  private View e;
  private View f;
  private View g;
  private Bitmap h;
  private Bitmap i;
  private float j = 1.0F;
  private final int k = 45;
  private final int l = 4;
  private final int m = 50;
  private final int n = 8;
  private int o = 0;
  private mq.a q;
  private Context r;
  private af s;
  private int t = -1;
  private int u = 0;
  private py v;
  private String w;
  private boolean x = false;
  private pm y;
  private mq.a.a z = null;
  
  public mq(Context paramContext, af paramaf)
  {
    this.s = paramaf;
    this.r = paramContext;
    this.x = true;
  }
  
  private void a(Context paramContext)
  {
    this.j = paramContext.getApplicationContext().getResources().getDisplayMetrics().density;
    this.o = ((int)(234.0D * this.j));
  }
  
  @TargetApi(9)
  private void a(Context paramContext, mq.a parama)
  {
    this.b = new RelativeLayout(paramContext);
    this.d = new TextView(paramContext);
    this.e = new View(paramContext);
    this.c = new mr(paramContext);
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
      lc locallc = lc.a(parama);
      paramContext = new Rect();
      if (locallc != null) {
        paramContext = locallc.a;
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
  }
  
  private void a(List<qa> paramList)
  {
    FrameLayout.LayoutParams localLayoutParams;
    if ((paramList.size() < 4) && (paramList.size() != this.u))
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.height -= (4 - paramList.size()) * 45;
      this.s.updateViewLayout(this.b, localLayoutParams);
    }
    for (;;)
    {
      this.u = paramList.size();
      if (this.q != null) {
        this.q.a(paramList);
      }
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
    this.h = lq.b(paramContext, "indoor_background.9.png");
    this.i = lq.b(paramContext, "item_selected_background.png");
  }
  
  private void e()
  {
    if (this.b == null)
    {
      this.q = new mq.a(this, this.r, new ArrayList());
      a(this.r);
      b(this.r);
      a(this.r, this.q);
      if ((this.s.getMap() != null) && (this.s.getMap().c() != null) && (this.s.getMap().c().l() != null)) {
        this.y = this.s.getMap().c().l().getIndoorMapControl();
      }
    }
  }
  
  private FrameLayout.LayoutParams f()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, this.o);
    localLayoutParams.gravity = 19;
    localLayoutParams.leftMargin = ((int)(8.0F * this.j));
    return localLayoutParams;
  }
  
  private void g()
  {
    if (this.v == null) {}
    int i1;
    do
    {
      do
      {
        return;
        i1 = this.v.d();
        localObject = this.v.c();
      } while ((localObject == null) || (i1 >= ((List)localObject).size()));
      localObject = (qa)((List)localObject).get(i1);
    } while (localObject == null);
    Object localObject = ((qa)localObject).a();
    if ((this.w != null) && (this.a) && (this.w.equals(this.v.b())))
    {
      this.c.setItemChecked(i1, true);
      this.a = false;
    }
    for (;;)
    {
      this.t = i1;
      this.s.getMap().a(this.v.a(), (String)localObject);
      this.w = this.v.b();
      return;
      this.c.setSelectionFromTop(i1, (int)(45.0F * this.j + 0.5D) * 2);
    }
  }
  
  public void a()
  {
    if (this.h != null) {
      this.h.recycle();
    }
    if (this.i != null) {
      this.i.recycle();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.x) && (paramInt2 < this.o + 100.0F * this.j))
    {
      this.b.setVisibility(8);
      return;
    }
    this.b.setVisibility(0);
  }
  
  public void a(py parampy)
  {
    if (parampy == null) {
      return;
    }
    if (this.b == null) {
      e();
    }
    this.v = parampy;
    a(parampy.c());
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.s == null) || (this.s.getMap() == null)) {
      return;
    }
    if (paramBoolean) {}
    for (this.x = true;; this.x = false)
    {
      b(this.x);
      return;
    }
  }
  
  public boolean a(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.indexOfChild(this.b) < 0) {
      paramViewGroup.addView(this.b, f());
    }
    return true;
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.s == null) || (this.s.getMap() == null)) {}
    do
    {
      ah localah;
      pu localpu;
      do
      {
        return;
        if (this.b == null) {
          e();
        }
        localah = this.s.getMap();
        localpu = localah.d();
        if ((!this.x) || (!paramBoolean) || (localpu == null) || (this.y == null) || (!this.y.a()) || (localpu.b < 18.0F)) {
          break;
        }
      } while (this.b.getVisibility() == 0);
      this.b.setVisibility(0);
      a(localah.c().c(localpu.a));
      return;
    } while (this.b.getVisibility() != 0);
    this.b.setVisibility(8);
  }
  
  public boolean b()
  {
    return this.x;
  }
  
  public void c()
  {
    g();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.s.getMap();
    if (paramAdapterView == null) {
      return;
    }
    if (this.z != null)
    {
      this.z.a.setTextColor(-16777216);
      this.z.b.setVisibility(4);
    }
    paramView = (mq.a.a)paramView.getTag();
    paramView.a.setTextColor(-1);
    paramView.b.setVisibility(0);
    this.z = paramView;
    this.t = paramInt;
    this.a = true;
    paramAdapterView.c(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.mq
 * JD-Core Version:    0.7.0.1
 */