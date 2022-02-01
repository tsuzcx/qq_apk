package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boy;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  View.OnClickListener cBW;
  Context mContext;
  String mKey = "";
  boolean sTi = false;
  protected String vkH = "";
  private ArrayList<b> vkN = new ArrayList();
  private HashSet<String> vkO = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> vkP = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> vkQ;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> vkR;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> vkS;
  BackwardSupportUtil.ExifHelper.LatLongData vkT;
  boolean vkU = true;
  int vkV = 0;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.cBW = paramOnClickListener;
    this.mKey = paramString;
    this.sTi = paramBoolean;
    this.vkP = new ArrayList();
    this.vkQ = new HashMap();
    this.vkR = new HashMap();
    this.vkS = new HashMap();
  }
  
  public static String en(List<crm> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      crm localcrm = (crm)paramList.get(i);
      if ((localcrm != null) && (localcrm.FEm != null) && (!localcrm.FEm.equals("")) && (!localcrm.FEm.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localcrm.FEm);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final b Kh(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.vkN.size())) {
      return (b)this.vkN.get(paramInt);
    }
    return new b("", new boy());
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.vkQ.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.vkQ.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.vkO.contains(paramb.vku)) && (paramInt <= this.vkN.size()))
    {
      this.vkN.add(paramInt, paramb);
      this.vkO.add(paramb.vku);
      this.vkS.put(paramb.vku, this.vkT);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.dmL;
    float f2 = paramLatLongData.hIO;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      ac.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.vkP.contains(paramLatLongData)) || ((this.vkT != null) && (this.vkT.equals(paramLatLongData))))
      {
        this.vkR.put(paramLatLongData, Integer.valueOf(paramInt));
        this.vkQ.put(paramLatLongData, paramSKBuiltinBuffer_t);
      }
      return;
      i = paramSKBuiltinBuffer_t.getILen();
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    ac.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.vkO.contains(localb.vku))
      {
        this.vkN.add(localb);
        this.vkO.add(localb.vku);
        this.vkS.put(localb.vku, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void anZ(String paramString)
  {
    if (paramString != null) {
      this.vkH = paramString;
    }
  }
  
  public final void ao(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.vkP = paramArrayList;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData aoa(String paramString)
  {
    if (this.vkS.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.vkS.get(paramString);
    }
    return null;
  }
  
  public final boolean aob(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.vkN.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!bs.isNullOrNil(localb.Title)) && (paramString.equals(localb.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int aoc(String paramString)
  {
    Iterator localIterator = this.vkN.iterator();
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
    } while (!localb.vku.equals(paramString));
    return j;
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.vkR.containsKey(paramLatLongData)) {
      return ((Integer)this.vkR.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void djQ()
  {
    this.vkN.clear();
    this.vkO.clear();
    this.vkR.clear();
    this.vkQ.clear();
    this.vkS.clear();
    this.vkV = 0;
    notifyDataSetChanged();
  }
  
  public final String djR()
  {
    return this.vkH;
  }
  
  public final boolean djS()
  {
    Iterator localIterator = this.vkP.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.vkU) {
      return b(this.vkT) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.vkN.size();
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