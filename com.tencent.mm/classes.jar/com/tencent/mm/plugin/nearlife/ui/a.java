package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.cqf;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eaf;
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
  boolean Cem = false;
  protected String GtV = "";
  private ArrayList<b> Gub = new ArrayList();
  private HashSet<String> Guc = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> Gud = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, eae> Gue;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> Guf;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> Gug;
  BackwardSupportUtil.ExifHelper.LatLongData Guh;
  boolean Gui = true;
  int Guj = 0;
  View.OnClickListener dig;
  Context mContext;
  String mKey = "";
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.dig = paramOnClickListener;
    this.mKey = paramString;
    this.Cem = paramBoolean;
    this.Gud = new ArrayList();
    this.Gue = new HashMap();
    this.Guf = new HashMap();
    this.Gug = new HashMap();
  }
  
  public static String gj(List<eaf> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      eaf localeaf = (eaf)paramList.get(i);
      if ((localeaf != null) && (localeaf.Ufy != null) && (!localeaf.Ufy.equals("")) && (!localeaf.Ufy.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localeaf.Ufy);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final eae a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.Gue.containsKey(paramLatLongData)) {
      return (eae)this.Gue.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.Guc.contains(paramb.GtI)) && (paramInt <= this.Gub.size()))
    {
      this.Gub.add(paramInt, paramb);
      this.Guc.add(paramb.GtI);
      this.Gug.put(paramb.GtI, this.Guh);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, eae parameae)
  {
    int i = 0;
    float f1 = paramLatLongData.latitude;
    float f2 = paramLatLongData.longtitude;
    if (parameae == null) {}
    for (;;)
    {
      Log.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.Gud.contains(paramLatLongData)) || ((this.Guh != null) && (this.Guh.equals(paramLatLongData))))
      {
        this.Guf.put(paramLatLongData, Integer.valueOf(paramInt));
        this.Gue.put(paramLatLongData, parameae);
      }
      return;
      i = parameae.Ufv;
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<b> paramList)
  {
    Log.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      if (!this.Guc.contains(localb.GtI))
      {
        this.Gub.add(localb);
        this.Guc.add(localb.GtI);
        this.Gug.put(localb.GtI, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void aN(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.Gud = paramArrayList;
    }
  }
  
  public final void aSO(String paramString)
  {
    if (paramString != null) {
      this.GtV = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData aSP(String paramString)
  {
    if (this.Gug.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.Gug.get(paramString);
    }
    return null;
  }
  
  public final boolean aSQ(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.Gub.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!Util.isNullOrNil(localb.fwr)) && (paramString.equals(localb.fwr.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int aSR(String paramString)
  {
    Iterator localIterator = this.Gub.iterator();
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
    } while (!localb.GtI.equals(paramString));
    return j;
  }
  
  public final b aah(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.Gub.size())) {
      return (b)this.Gub.get(paramInt);
    }
    return new b("", new cqf());
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.Guf.containsKey(paramLatLongData)) {
      return ((Integer)this.Guf.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void fiC()
  {
    this.Gub.clear();
    this.Guc.clear();
    this.Guf.clear();
    this.Gue.clear();
    this.Gug.clear();
    this.Guj = 0;
    notifyDataSetChanged();
  }
  
  public final String fiD()
  {
    return this.GtV;
  }
  
  public final boolean fiE()
  {
    Iterator localIterator = this.Gud.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.Gui) {
      return b(this.Guh) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.Gub.size();
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