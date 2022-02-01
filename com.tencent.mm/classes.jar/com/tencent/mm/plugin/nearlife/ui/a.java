package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  protected String AAT = "";
  private ArrayList<b> AAZ = new ArrayList();
  private HashSet<String> ABa = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ABb = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> ABc;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> ABd;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> ABe;
  BackwardSupportUtil.ExifHelper.LatLongData ABf;
  boolean ABg = true;
  int ABh = 0;
  View.OnClickListener dec;
  Context mContext;
  String mKey = "";
  boolean xrR = false;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.dec = paramOnClickListener;
    this.mKey = paramString;
    this.xrR = paramBoolean;
    this.ABb = new ArrayList();
    this.ABc = new HashMap();
    this.ABd = new HashMap();
    this.ABe = new HashMap();
  }
  
  public static String fF(List<dqi> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      dqi localdqi = (dqi)paramList.get(i);
      if ((localdqi != null) && (localdqi.MTo != null) && (!localdqi.MTo.equals("")) && (!localdqi.MTo.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localdqi.MTo);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final b Tv(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.AAZ.size())) {
      return (b)this.AAZ.get(paramInt);
    }
    return new b("", new chj());
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.ABc.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.ABc.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.ABa.contains(paramb.AAG)) && (paramInt <= this.AAZ.size()))
    {
      this.AAZ.add(paramInt, paramb);
      this.ABa.add(paramb.AAG);
      this.ABe.put(paramb.AAG, this.ABf);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.latitude;
    float f2 = paramLatLongData.longtitude;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      Log.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.ABb.contains(paramLatLongData)) || ((this.ABf != null) && (this.ABf.equals(paramLatLongData))))
      {
        this.ABd.put(paramLatLongData, Integer.valueOf(paramInt));
        this.ABc.put(paramLatLongData, paramSKBuiltinBuffer_t);
      }
      return;
      i = paramSKBuiltinBuffer_t.getILen();
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    Log.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.ABa.contains(localb.AAG))
      {
        this.AAZ.add(localb);
        this.ABa.add(localb.AAG);
        this.ABe.put(localb.AAG, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void aF(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.ABb = paramArrayList;
    }
  }
  
  public final void aIu(String paramString)
  {
    if (paramString != null) {
      this.AAT = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData aIv(String paramString)
  {
    if (this.ABe.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.ABe.get(paramString);
    }
    return null;
  }
  
  public final boolean aIw(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.AAZ.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!Util.isNullOrNil(localb.Title)) && (paramString.equals(localb.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int aIx(String paramString)
  {
    Iterator localIterator = this.AAZ.iterator();
    int i = -1;
    int j;
    b localb;
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      localb = (b)localIterator.next();
      j = i + 1;
      i = j;
    } while (!localb.AAG.equals(paramString));
    return j;
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.ABd.containsKey(paramLatLongData)) {
      return ((Integer)this.ABd.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void ewZ()
  {
    this.AAZ.clear();
    this.ABa.clear();
    this.ABd.clear();
    this.ABc.clear();
    this.ABe.clear();
    this.ABh = 0;
    notifyDataSetChanged();
  }
  
  public final String exa()
  {
    return this.AAT;
  }
  
  public final boolean exb()
  {
    Iterator localIterator = this.ABb.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.ABg) {
      return b(this.ABf) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.AAZ.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */