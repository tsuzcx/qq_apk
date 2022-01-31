package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.c.atn;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  View.OnClickListener kdc;
  Context mContext;
  protected String mEh = "";
  boolean mEl = false;
  ArrayList<com.tencent.mm.plugin.nearlife.b.a> mEm = new ArrayList();
  HashSet<String> mEn = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> mEo = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, bmk> mEp;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> mEq;
  Map<String, BackwardSupportUtil.ExifHelper.LatLongData> mEr;
  BackwardSupportUtil.ExifHelper.LatLongData mEs;
  boolean mEt = true;
  int mEu = 0;
  String mKey = "";
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.kdc = paramOnClickListener;
    this.mKey = paramString;
    this.mEl = paramBoolean;
    this.mEo = new ArrayList();
    this.mEp = new HashMap();
    this.mEq = new HashMap();
    this.mEr = new HashMap();
  }
  
  public static String bS(List<bml> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      bml localbml = (bml)paramList.get(i);
      if ((localbml != null) && (localbml.tFO != null) && (!localbml.tFO.equals("")) && (!localbml.tFO.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localbml.tFO);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final void I(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.mEo = paramArrayList;
    }
  }
  
  public final void JP(String paramString)
  {
    if (paramString != null) {
      this.mEh = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData JQ(String paramString)
  {
    if (this.mEr.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.mEr.get(paramString);
    }
    return null;
  }
  
  public final int JR(String paramString)
  {
    Iterator localIterator = this.mEm.iterator();
    int i = -1;
    int j;
    com.tencent.mm.plugin.nearlife.b.a locala;
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      locala = (com.tencent.mm.plugin.nearlife.b.a)localIterator.next();
      j = i + 1;
      i = j;
    } while (!locala.mDU.equals(paramString));
    return j;
  }
  
  public final bmk a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.mEp.containsKey(paramLatLongData)) {
      return (bmk)this.mEp.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.nearlife.b.a parama, int paramInt)
  {
    if ((!this.mEn.contains(parama.mDU)) && (paramInt <= this.mEm.size()))
    {
      this.mEm.add(paramInt, parama);
      this.mEn.add(parama.mDU);
      this.mEr.put(parama.mDU, this.mEs);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, bmk parambmk)
  {
    int i = 0;
    float f1 = paramLatLongData.bRt;
    float f2 = paramLatLongData.epo;
    if (parambmk == null) {}
    for (;;)
    {
      y.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.mEo.contains(paramLatLongData)) || ((this.mEs != null) && (this.mEs.equals(paramLatLongData))))
      {
        this.mEq.put(paramLatLongData, Integer.valueOf(paramInt));
        this.mEp.put(paramLatLongData, parambmk);
      }
      return;
      i = parambmk.tFK;
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<com.tencent.mm.plugin.nearlife.b.a> paramList)
  {
    y.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.nearlife.b.a locala = (com.tencent.mm.plugin.nearlife.b.a)paramList.next();
      if (!this.mEn.contains(locala.mDU))
      {
        this.mEm.add(locala);
        this.mEn.add(locala.mDU);
        this.mEr.put(locala.mDU, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.mEq.containsKey(paramLatLongData)) {
      return ((Integer)this.mEq.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void boj()
  {
    this.mEm.clear();
    this.mEn.clear();
    this.mEq.clear();
    this.mEp.clear();
    this.mEr.clear();
    this.mEu = 0;
    notifyDataSetChanged();
  }
  
  public final String bok()
  {
    return this.mEh;
  }
  
  public final boolean bol()
  {
    Iterator localIterator = this.mEo.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.mEt) {
      return b(this.mEs) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.mEm.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final com.tencent.mm.plugin.nearlife.b.a vh(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mEm.size())) {
      return (com.tencent.mm.plugin.nearlife.b.a)this.mEm.get(paramInt);
    }
    return new com.tencent.mm.plugin.nearlife.b.a("", new atn());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */