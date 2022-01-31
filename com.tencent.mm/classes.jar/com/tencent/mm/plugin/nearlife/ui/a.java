package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class a
  extends BaseAdapter
{
  View.OnClickListener bTw;
  Context mContext;
  String mKey = "";
  protected String pej = "";
  boolean peo = false;
  private ArrayList<com.tencent.mm.plugin.nearlife.b.a> pep = new ArrayList();
  private HashSet<String> peq = new HashSet();
  ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> per = null;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, SKBuiltinBuffer_t> pes;
  private Map<BackwardSupportUtil.ExifHelper.LatLongData, Integer> pet;
  private Map<String, BackwardSupportUtil.ExifHelper.LatLongData> peu;
  BackwardSupportUtil.ExifHelper.LatLongData pev;
  boolean pew = true;
  int pex = 0;
  
  public a(Context paramContext, View.OnClickListener paramOnClickListener, String paramString, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.bTw = paramOnClickListener;
    this.mKey = paramString;
    this.peo = paramBoolean;
    this.per = new ArrayList();
    this.pes = new HashMap();
    this.pet = new HashMap();
    this.peu = new HashMap();
  }
  
  public static String cq(List<bwc> paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramList.size())
    {
      bwc localbwc = (bwc)paramList.get(i);
      if ((localbwc != null) && (localbwc.xJE != null) && (!localbwc.xJE.equals("")) && (!localbwc.xJE.toLowerCase().equals("null")))
      {
        localStringBuffer.append(localbwc.xJE);
        if (i < paramList.size() - 1) {
          localStringBuffer.append("·");
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public final com.tencent.mm.plugin.nearlife.b.a AF(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.pep.size())) {
      return (com.tencent.mm.plugin.nearlife.b.a)this.pep.get(paramInt);
    }
    return new com.tencent.mm.plugin.nearlife.b.a("", new azs());
  }
  
  public final void K(ArrayList<BackwardSupportUtil.ExifHelper.LatLongData> paramArrayList)
  {
    if (paramArrayList != null) {
      this.per = paramArrayList;
    }
  }
  
  public final void VO(String paramString)
  {
    if (paramString != null) {
      this.pej = paramString;
    }
  }
  
  public final BackwardSupportUtil.ExifHelper.LatLongData VP(String paramString)
  {
    if (this.peu.containsKey(paramString)) {
      return (BackwardSupportUtil.ExifHelper.LatLongData)this.peu.get(paramString);
    }
    return null;
  }
  
  public final boolean VQ(String paramString)
  {
    paramString = paramString.trim();
    Iterator localIterator = this.pep.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.nearlife.b.a locala = (com.tencent.mm.plugin.nearlife.b.a)localIterator.next();
      if ((!bo.isNullOrNil(locala.Title)) && (paramString.equals(locala.Title.trim()))) {
        return true;
      }
    }
    return false;
  }
  
  public final int VR(String paramString)
  {
    Iterator localIterator = this.pep.iterator();
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
    } while (!locala.pdW.equals(paramString));
    return j;
  }
  
  public final SKBuiltinBuffer_t a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.pes.containsKey(paramLatLongData)) {
      return (SKBuiltinBuffer_t)this.pes.get(paramLatLongData);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.nearlife.b.a parama, int paramInt)
  {
    if ((!this.peq.contains(parama.pdW)) && (paramInt <= this.pep.size()))
    {
      this.pep.add(paramInt, parama);
      this.peq.add(parama.pdW);
      this.peu.put(parama.pdW, this.pev);
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, int paramInt, SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    int i = 0;
    float f1 = paramLatLongData.cyV;
    float f2 = paramLatLongData.fFN;
    if (paramSKBuiltinBuffer_t == null) {}
    for (;;)
    {
      ab.d("MicroMsg.BaseLifeAdapter", "set flag & buf, lat:%f long:%f flag:%d len:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(paramInt), Integer.valueOf(i) });
      if ((this.per.contains(paramLatLongData)) || ((this.pev != null) && (this.pev.equals(paramLatLongData))))
      {
        this.pet.put(paramLatLongData, Integer.valueOf(paramInt));
        this.pes.put(paramLatLongData, paramSKBuiltinBuffer_t);
      }
      return;
      i = paramSKBuiltinBuffer_t.getILen();
    }
  }
  
  public final void a(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData, List<com.tencent.mm.plugin.nearlife.b.a> paramList)
  {
    ab.i("MicroMsg.BaseLifeAdapter", "mkey %s addlifes %d", new Object[] { this.mKey, Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.nearlife.b.a locala = (com.tencent.mm.plugin.nearlife.b.a)paramList.next();
      if (!this.peq.contains(locala.pdW))
      {
        this.pep.add(locala);
        this.peq.add(locala.pdW);
        this.peu.put(locala.pdW, paramLatLongData);
      }
    }
    notifyDataSetChanged();
  }
  
  public final int b(BackwardSupportUtil.ExifHelper.LatLongData paramLatLongData)
  {
    if (this.pet.containsKey(paramLatLongData)) {
      return ((Integer)this.pet.get(paramLatLongData)).intValue();
    }
    return 1;
  }
  
  public final void bWI()
  {
    this.pep.clear();
    this.peq.clear();
    this.pet.clear();
    this.pes.clear();
    this.peu.clear();
    this.pex = 0;
    notifyDataSetChanged();
  }
  
  public final String bWJ()
  {
    return this.pej;
  }
  
  public final boolean bWK()
  {
    Iterator localIterator = this.per.iterator();
    while (localIterator.hasNext()) {
      if (b((BackwardSupportUtil.ExifHelper.LatLongData)localIterator.next()) > 0) {
        return true;
      }
    }
    if (this.pew) {
      return b(this.pev) > 0;
    }
    return false;
  }
  
  public int getCount()
  {
    return this.pep.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.nearlife.ui.a
 * JD-Core Version:    0.7.0.1
 */