package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseBooleanArray;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.element.d;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ih
{
  public HashMap<Integer, GLIcon> a;
  public HashMap<Integer, GLIcon> b;
  private hl c;
  private if d;
  private CopyOnWriteArrayList<Integer> e;
  private SparseBooleanArray f;
  private ArrayList<Integer> g;
  
  ih(hl paramhl, com.tencent.map.lib.gl.b paramb, if paramif)
  {
    AppMethodBeat.i(148327);
    this.e = new CopyOnWriteArrayList();
    this.f = new SparseBooleanArray();
    this.g = new ArrayList();
    this.c = paramhl;
    this.d = paramif;
    this.a = new HashMap();
    this.b = new HashMap();
    AppMethodBeat.o(148327);
  }
  
  public static Bitmap a(String paramString)
  {
    AppMethodBeat.i(148332);
    paramString = com.tencent.map.lib.util.b.a(paramString);
    AppMethodBeat.o(148332);
    return paramString;
  }
  
  private int b(d paramd)
  {
    AppMethodBeat.i(148333);
    if (((this.c instanceof ik)) && (paramd != null) && (!paramd.l()))
    {
      Context localContext = ((ik)this.c).k();
      float f1 = paramd.n();
      paramd.a(SystemUtil.getDensity(localContext) * f1);
    }
    int i = this.c.f().a(paramd);
    paramd.a(i);
    if (!this.e.contains(Integer.valueOf(i)))
    {
      this.e.add(Integer.valueOf(i));
      this.f.append(i, paramd.l());
    }
    AppMethodBeat.o(148333);
    return i;
  }
  
  private void e()
  {
    AppMethodBeat.i(148330);
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.a.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
      Object localObject2 = ((Map.Entry)localObject3).getKey();
      localObject3 = (GLIcon)((Map.Entry)localObject3).getValue();
      if (!this.b.containsKey(localObject2))
      {
        localArrayList.add(Integer.valueOf(((Integer)localObject2).intValue()));
        com.tencent.map.lib.util.b.b(((GLIcon)localObject3).getIconName());
      }
    }
    int j = localArrayList.size();
    if (j <= 0)
    {
      AppMethodBeat.o(148330);
      return;
    }
    localObject1 = new int[j];
    int i = 0;
    while (i < j)
    {
      localObject1[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
    this.d.a((int[])localObject1, j);
    AppMethodBeat.o(148330);
  }
  
  private void f()
  {
    AppMethodBeat.i(148331);
    this.a.clear();
    this.a.putAll(this.b);
    this.b.clear();
    AppMethodBeat.o(148331);
  }
  
  public void a()
  {
    AppMethodBeat.i(148329);
    e();
    f();
    AppMethodBeat.o(148329);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(148334);
    this.c.f().a(paramInt, this.f.get(paramInt));
    this.f.delete(paramInt);
    this.e.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(148334);
  }
  
  public void a(GeoPoint paramGeoPoint, GLIcon paramGLIcon, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(148328);
    if (paramBoolean3) {}
    for (float f1 = 360.0F - paramGLIcon.getRotateAngle(); this.a.containsKey(Integer.valueOf(paramGLIcon.mDisplayId)); f1 = paramGLIcon.getRotateAngle())
    {
      if (paramGLIcon.isDirty())
      {
        this.d.a(paramGLIcon.mDisplayId, paramGLIcon.getIconName(), paramGLIcon.mPositionX, paramGLIcon.mPositionY, paramGLIcon.getAnchroX(), paramGLIcon.getAnchorY(), paramGLIcon.getScaleX(), paramGLIcon.getScaleY(), paramGLIcon.getAlpha(), f1, paramBoolean1, paramGLIcon.isFixPos(), paramGLIcon.isFastLoad(), paramGLIcon.isAvoidAnno(), paramInt2, paramInt3);
        if (paramGLIcon.isIconChanged())
        {
          com.tencent.map.lib.util.b.a(paramGLIcon.getIconName(), paramGLIcon.getTextureBm(0));
          if (!StringUtil.isEqual(paramGLIcon.getIconName(), paramGLIcon.getLastName())) {
            com.tencent.map.lib.util.b.b(paramGLIcon.getLastName());
          }
          paramGLIcon.setIconChanged(false);
        }
      }
      this.b.put(Integer.valueOf(paramGLIcon.mDisplayId), paramGLIcon);
      AppMethodBeat.o(148328);
      return;
    }
    paramGLIcon.mDisplayId = this.d.a(paramGLIcon.getIconName(), paramGLIcon.mPositionX, paramGLIcon.mPositionY, paramGLIcon.getAnchroX(), paramGLIcon.getAnchorY(), paramGLIcon.getScaleX(), paramGLIcon.getScaleY(), paramGLIcon.getAlpha(), f1, paramBoolean1, paramGLIcon.isFixPos(), paramGLIcon.isFastLoad(), paramGLIcon.isAvoidAnno(), paramInt2, paramInt3);
    com.tencent.map.lib.util.b.a(paramGLIcon.getIconName(), paramGLIcon.getTextureBm(0));
    paramGLIcon.setIconChanged(false);
    paramGLIcon.setDirty(false);
    this.b.put(Integer.valueOf(paramGLIcon.mDisplayId), paramGLIcon);
    AppMethodBeat.o(148328);
  }
  
  public void a(d paramd)
  {
    AppMethodBeat.i(148335);
    if (!this.e.contains(Integer.valueOf(paramd.s())))
    {
      paramd.a(b(paramd));
      this.d.c(paramd);
    }
    if (!this.g.contains(Integer.valueOf(paramd.s()))) {
      this.g.add(Integer.valueOf(paramd.s()));
    }
    this.d.b(paramd);
    this.d.d(paramd);
    if (paramd.t()) {
      this.d.h(paramd);
    }
    for (;;)
    {
      this.d.f(paramd);
      if (!StringUtil.isEmpty(paramd.w())) {
        this.d.e(paramd);
      }
      this.d.i(paramd);
      AppMethodBeat.o(148335);
      return;
      this.d.g(paramd);
    }
  }
  
  public hl b()
  {
    return this.c;
  }
  
  protected void c()
  {
    AppMethodBeat.i(148336);
    if ((this.e != null) && (this.e.size() > 0))
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        if (!this.g.contains(Integer.valueOf(i))) {
          a(i);
        }
      }
      this.g.clear();
    }
    AppMethodBeat.o(148336);
  }
  
  public float d()
  {
    AppMethodBeat.i(148337);
    float f1 = this.c.a().l();
    AppMethodBeat.o(148337);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ih
 * JD-Core Version:    0.7.0.1
 */