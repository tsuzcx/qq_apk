package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.dgz;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.gol;
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
  boolean HQr = false;
  protected String MpV = "";
  private ArrayList<b> Mqa = new ArrayList();
  private HashSet<String> Mqb = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> Mqc = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, gol> Mqd;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> Mqe;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> Mqf;
  BackwardSupportUtil.ExifHelper.LatLongData Mqg;
  boolean Mqh = true;
  int Mqi = 0;
  View.OnClickListener fhU;
  Context mContext;
  String mKey = "";
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.fhU = paramOnClickListener;
    this.mKey = paramString;
    this.HQr = paramBoolean;
    this.Mqc = new ArrayList();
    this.Mqd = new HashMap();
    this.Mqe = new HashMap();
    this.Mqf = new HashMap();
  }
  
  public static String ji(List<etl> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      etl localetl = (etl)paramList.get(i);
      if ((localetl != null) && (localetl.abwM != null) && (!localetl.abwM.equals("")) && (!localetl.abwM.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localetl.abwM);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final gol a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.Mqd.containsKey(paramLatLongData)) {
      return (gol)this.Mqd.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.Mqb.contains(paramb.MpI)) && (paramInt <= this.Mqa.size()))
    {
      this.Mqa.add(paramInt, paramb);
      this.Mqb.add(paramb.MpI);
      this.Mqf.put(paramb.MpI, this.Mqg);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, gol paramgol)
  {
    int i = 0;
    float f1 = paramLatLongData.latitude;
    float f2 = paramLatLongData.longtitude;
    if (paramgol == null) {}
    for (;;)
    {
      Log.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.Mqc.contains(paramLatLongData)) || ((this.Mqg != null) && (this.Mqg.equals(paramLatLongData))))
      {
        this.Mqe.put(paramLatLongData, Integer.valueOf(paramInt));
        this.Mqd.put(paramLatLongData, paramgol);
      }
      return;
      i = paramgol.abwJ;
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    Log.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.Mqb.contains(localb.MpI))
      {
        this.Mqa.add(localb);
        this.Mqb.add(localb.MpI);
        this.Mqf.put(localb.MpI, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void aPN(String paramString)
  {
    if (paramString != null) {
      this.MpV = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData aPO(String paramString)
  {
    if (this.Mqf.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.Mqf.get(paramString);
    }
    return null;
  }
  
  public final boolean aPP(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.Mqa.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!Util.isNullOrNil(localb.hAP)) && (paramString.equals(localb.hAP.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int aPQ(String paramString)
  {
    Iterator localIterator = this.Mqa.iterator();
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
    } while (!localb.MpI.equals(paramString));
    return j;
  }
  
  public final b aeA(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.Mqa.size())) {
      return (b)this.Mqa.get(paramInt);
    }
    return new b("", new dgz());
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.Mqe.containsKey(paramLatLongData)) {
      return ((Integer)this.Mqe.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void bj(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.Mqc = paramArrayList;
    }
  }
  
  public int getCount()
  {
    return this.Mqa.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final void gsT()
  {
    this.Mqa.clear();
    this.Mqb.clear();
    this.Mqe.clear();
    this.Mqd.clear();
    this.Mqf.clear();
    this.Mqi = 0;
    notifyDataSetChanged();
  }
  
  public final String gsU()
  {
    return this.MpV;
  }
  
  public final boolean gsV()
  {
    Iterator localIterator = this.Mqc.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.Mqh) {
      return b(this.Mqg) > 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */