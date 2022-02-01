package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btl;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  View.OnClickListener cMV;
  Context mContext;
  String mKey = "";
  boolean tPM = false;
  protected String wpZ = "";
  private ArrayList<b> wqf = new ArrayList();
  private HashSet<String> wqg = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> wqh = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> wqi;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> wqj;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> wqk;
  BackwardSupportUtil.ExifHelper.LatLongData wql;
  boolean wqm = true;
  int wqn = 0;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.cMV = paramOnClickListener;
    this.mKey = paramString;
    this.tPM = paramBoolean;
    this.wqh = new ArrayList();
    this.wqi = new HashMap();
    this.wqj = new HashMap();
    this.wqk = new HashMap();
  }
  
  public static String eA(List<cwt> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      cwt localcwt = (cwt)paramList.get(i);
      if ((localcwt != null) && (localcwt.HoB != null) && (!localcwt.HoB.equals("")) && (!localcwt.HoB.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localcwt.HoB);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final b LJ(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.wqf.size())) {
      return (b)this.wqf.get(paramInt);
    }
    return new b("", new btl());
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.wqi.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.wqi.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.wqg.contains(paramb.wpM)) && (paramInt <= this.wqf.size()))
    {
      this.wqf.add(paramInt, paramb);
      this.wqg.add(paramb.wpM);
      this.wqk.put(paramb.wpM, this.wql);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.dyz;
    float f2 = paramLatLongData.ibC;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      ad.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.wqh.contains(paramLatLongData)) || ((this.wql != null) && (this.wql.equals(paramLatLongData))))
      {
        this.wqj.put(paramLatLongData, Integer.valueOf(paramInt));
        this.wqi.put(paramLatLongData, paramSKBuiltinBuffer_t);
      }
      return;
      i = paramSKBuiltinBuffer_t.getILen();
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    ad.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.wqg.contains(localb.wpM))
      {
        this.wqf.add(localb);
        this.wqg.add(localb.wpM);
        this.wqk.put(localb.wpM, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void an(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.wqh = paramArrayList;
    }
  }
  
  public final void asY(String paramString)
  {
    if (paramString != null) {
      this.wpZ = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData asZ(String paramString)
  {
    if (this.wqk.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.wqk.get(paramString);
    }
    return null;
  }
  
  public final boolean ata(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.wqf.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!bt.isNullOrNil(localb.Title)) && (paramString.equals(localb.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int atb(String paramString)
  {
    Iterator localIterator = this.wqf.iterator();
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
    } while (!localb.wpM.equals(paramString));
    return j;
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.wqj.containsKey(paramLatLongData)) {
      return ((Integer)this.wqj.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void duc()
  {
    this.wqf.clear();
    this.wqg.clear();
    this.wqj.clear();
    this.wqi.clear();
    this.wqk.clear();
    this.wqn = 0;
    notifyDataSetChanged();
  }
  
  public final String dud()
  {
    return this.wpZ;
  }
  
  public final boolean due()
  {
    Iterator localIterator = this.wqh.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.wqm) {
      return b(this.wql) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.wqf.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */