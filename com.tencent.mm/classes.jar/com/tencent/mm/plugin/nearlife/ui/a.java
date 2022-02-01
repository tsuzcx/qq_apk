package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.nearlife.b.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.blc;
import com.tencent.mm.protocal.protobuf.cmf;
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
  View.OnClickListener cEO;
  Context mContext;
  String mKey = "";
  boolean rLt = false;
  protected String ubJ = "";
  private ArrayList<b> ubO = new ArrayList();
  private HashSet<String> ubP = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> ubQ = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> ubR;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> ubS;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> ubT;
  BackwardSupportUtil.ExifHelper.LatLongData ubU;
  boolean ubV = true;
  int ubW = 0;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.cEO = paramOnClickListener;
    this.mKey = paramString;
    this.rLt = paramBoolean;
    this.ubQ = new ArrayList();
    this.ubR = new HashMap();
    this.ubS = new HashMap();
    this.ubT = new HashMap();
  }
  
  public static String ej(List<cmf> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      cmf localcmf = (cmf)paramList.get(i);
      if ((localcmf != null) && (localcmf.Ehn != null) && (!localcmf.Ehn.equals("")) && (!localcmf.Ehn.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localcmf.Ehn);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final b Ii(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.ubO.size())) {
      return (b)this.ubO.get(paramInt);
    }
    return new b("", new blc());
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.ubR.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.ubR.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(b paramb, int paramInt)
  {
    if ((!this.ubP.contains(paramb.ubw)) && (paramInt <= this.ubO.size()))
    {
      this.ubO.add(paramInt, paramb);
      this.ubP.add(paramb.ubw);
      this.ubT.put(paramb.ubw, this.ubU);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.dpb;
    float f2 = paramLatLongData.hil;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      ad.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.ubQ.contains(paramLatLongData)) || ((this.ubU != null) && (this.ubU.equals(paramLatLongData))))
      {
        this.ubS.put(paramLatLongData, Integer.valueOf(paramInt));
        this.ubR.put(paramLatLongData, paramSKBuiltinBuffer_t);
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
      if (!this.ubP.contains(localb.ubw))
      {
        this.ubO.add(localb);
        this.ubP.add(localb.ubw);
        this.ubT.put(localb.ubw, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void ad(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.ubQ = paramArrayList;
    }
  }
  
  public final void ajb(String paramString)
  {
    if (paramString != null) {
      this.ubJ = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData ajc(String paramString)
  {
    if (this.ubT.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.ubT.get(paramString);
    }
    return null;
  }
  
  public final boolean ajd(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.ubO.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if ((!bt.isNullOrNil(localb.Title)) && (paramString.equals(localb.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int aje(String paramString)
  {
    Iterator localIterator = this.ubO.iterator();
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
    } while (!localb.ubw.equals(paramString));
    return j;
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.ubS.containsKey(paramLatLongData)) {
      return ((Integer)this.ubS.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void cWi()
  {
    this.ubO.clear();
    this.ubP.clear();
    this.ubS.clear();
    this.ubR.clear();
    this.ubT.clear();
    this.ubW = 0;
    notifyDataSetChanged();
  }
  
  public final String cWj()
  {
    return this.ubJ;
  }
  
  public final boolean cWk()
  {
    Iterator localIterator = this.ubQ.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.ubV) {
      return b(this.ubU) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.ubO.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */