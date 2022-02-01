package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  View.OnClickListener cNE;
  Context mContext;
  String mKey = "";
  boolean uaD = false;
  protected String wFI = "";
  private ArrayList<b> wFO = new ArrayList();
  private HashSet<String> wFP = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> wFQ = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> wFR;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> wFS;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> wFT;
  BackwardSupportUtil.ExifHelper.LatLongData wFU;
  boolean wFV = true;
  int wFW = 0;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.cNE = paramOnClickListener;
    this.mKey = paramString;
    this.uaD = paramBoolean;
    this.wFQ = new ArrayList();
    this.wFR = new HashMap();
    this.wFS = new HashMap();
    this.wFT = new HashMap();
  }
  
  public static String eH(List<cxn> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      cxn localcxn = (cxn)paramList.get(i);
      if ((localcxn != null) && (localcxn.HId != null) && (!localcxn.HId.equals("")) && (!localcxn.HId.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localcxn.HId);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final b Mo(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.wFO.size())) {
      return (b)this.wFO.get(paramInt);
    }
    return new b("", new buf());
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.wFR.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.wFR.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.wFP.contains(paramb.wFv)) && (paramInt <= this.wFO.size()))
    {
      this.wFO.add(paramInt, paramb);
      this.wFP.add(paramb.wFv);
      this.wFT.put(paramb.wFv, this.wFU);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.dzE;
    float f2 = paramLatLongData.iev;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      ae.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.wFQ.contains(paramLatLongData)) || ((this.wFU != null) && (this.wFU.equals(paramLatLongData))))
      {
        this.wFS.put(paramLatLongData, Integer.valueOf(paramInt));
        this.wFR.put(paramLatLongData, paramSKBuiltinBuffer_t);
      }
      return;
      i = paramSKBuiltinBuffer_t.getILen();
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    ae.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.wFP.contains(localb.wFv))
      {
        this.wFO.add(localb);
        this.wFP.add(localb.wFv);
        this.wFT.put(localb.wFv, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void ao(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.wFQ = paramArrayList;
    }
  }
  
  public final void aul(String paramString)
  {
    if (paramString != null) {
      this.wFI = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData aum(String paramString)
  {
    if (this.wFT.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.wFT.get(paramString);
    }
    return null;
  }
  
  public final boolean aun(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.wFO.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!bu.isNullOrNil(localb.Title)) && (paramString.equals(localb.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int auo(String paramString)
  {
    Iterator localIterator = this.wFO.iterator();
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
    } while (!localb.wFv.equals(paramString));
    return j;
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.wFS.containsKey(paramLatLongData)) {
      return ((Integer)this.wFS.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void dxr()
  {
    this.wFO.clear();
    this.wFP.clear();
    this.wFS.clear();
    this.wFR.clear();
    this.wFT.clear();
    this.wFW = 0;
    notifyDataSetChanged();
  }
  
  public final String dxs()
  {
    return this.wFI;
  }
  
  public final boolean dxt()
  {
    Iterator localIterator = this.wFQ.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.wFV) {
      return b(this.wFU) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.wFO.size();
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