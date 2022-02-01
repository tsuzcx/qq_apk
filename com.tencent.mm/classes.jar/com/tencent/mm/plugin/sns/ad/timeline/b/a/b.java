package com.tencent.mm.plugin.sns.ad.timeline.b.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.l;
import com.tencent.mm.plugin.sns.ad.adxml.m;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.j.j.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends j.b
{
  int PMZ;
  List<a> Qbn;
  String adExtInfo;
  int currentIndex;
  String hQX;
  int scene;
  String uxInfo;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(311273);
    this.Qbn = new ArrayList();
    this.currentIndex = -1;
    this.scene = paramInt;
    AppMethodBeat.o(311273);
  }
  
  private void N(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(311320);
    if (d.isEmpty(this.Qbn))
    {
      AppMethodBeat.o(311320);
      return;
    }
    Iterator localIterator = this.Qbn.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a)localIterator.next();
      if (localObject != null)
      {
        localObject = ((a)localObject).toJson();
        if (localObject != null) {
          paramJSONArray.put(localObject);
        }
      }
    }
    AppMethodBeat.o(311320);
  }
  
  private void aWO(String paramString)
  {
    AppMethodBeat.i(311296);
    this.uxInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(311296);
  }
  
  private void aWP(String paramString)
  {
    AppMethodBeat.i(311310);
    this.adExtInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(311310);
  }
  
  private boolean ajG(int paramInt)
  {
    AppMethodBeat.i(311332);
    int i = this.Qbn.size();
    if ((paramInt >= 0) && (paramInt < i))
    {
      AppMethodBeat.o(311332);
      return true;
    }
    AppMethodBeat.o(311332);
    return false;
  }
  
  private void setSnsId(String paramString)
  {
    AppMethodBeat.i(311286);
    this.hQX = Util.nullAsNil(paramString);
    AppMethodBeat.o(311286);
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt, m paramm)
  {
    AppMethodBeat.i(311352);
    if (paramSnsInfo == null)
    {
      Log.i("SlideFullCardAdChannelData", "the sns info is null!");
      AppMethodBeat.o(311352);
      return;
    }
    Object localObject = t.x(paramSnsInfo);
    if ((!TextUtils.isEmpty(this.hQX)) && (this.hQX.equals(localObject)))
    {
      Log.i("SlideFullCardAdChannelData", "the new sns id is same as the old one!");
      AppMethodBeat.o(311352);
      return;
    }
    setSnsId((String)localObject);
    if (paramSnsInfo.getAdInfo(paramInt) != null) {
      aWO(paramSnsInfo.getUxinfo());
    }
    aWP(paramSnsInfo.getAdXml().adExtInfo);
    this.Qbn.clear();
    if ((paramm != null) && (paramm.PMG != null))
    {
      int j = paramm.PMG.size();
      this.PMZ = paramm.PMZ;
      paramInt = 0;
      if ((paramInt < j) && ((this.PMZ > 4) || (paramInt != this.PMZ)))
      {
        paramSnsInfo = (l)paramm.PMG.get(paramInt);
        localObject = new a();
        ((a)localObject).index = paramInt;
        this.Qbn.add(localObject);
        if (paramSnsInfo != null) {
          if (!paramSnsInfo.gZy()) {
            break label228;
          }
        }
        label228:
        for (int i = 2;; i = 1)
        {
          ((a)localObject).mediaType = i;
          paramInt += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(311352);
  }
  
  public final void ajE(int paramInt)
  {
    AppMethodBeat.i(311405);
    a locala = ajH(paramInt);
    if (locala != null) {
      locala.clickCount += 1;
    }
    AppMethodBeat.o(311405);
  }
  
  public final void ajF(int paramInt)
  {
    AppMethodBeat.i(311410);
    a locala = ajH(paramInt);
    if (locala != null) {
      locala.PXC += 1;
    }
    AppMethodBeat.o(311410);
  }
  
  final a ajH(int paramInt)
  {
    AppMethodBeat.i(311428);
    int i = paramInt;
    if (this.PMZ <= 4) {
      i = paramInt % this.PMZ;
    }
    if (ajG(i))
    {
      a locala = (a)this.Qbn.get(i);
      AppMethodBeat.o(311428);
      return locala;
    }
    AppMethodBeat.o(311428);
    return null;
  }
  
  public final void bN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(311368);
    try
    {
      paramJSONObject.putOpt("snsid", this.hQX);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      paramJSONObject.putOpt("scene", Integer.valueOf(this.scene));
      return;
    }
    finally
    {
      AppMethodBeat.o(311368);
    }
  }
  
  public final void bO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(311381);
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramJSONObject.putOpt("reportItemList", localJSONArray);
      N(localJSONArray);
      return;
    }
    finally
    {
      AppMethodBeat.o(311381);
    }
  }
  
  public final String gZE()
  {
    return "sns_ad_slider_card_report";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(311397);
    String str = super.getContent();
    if (this.Qbn != null) {
      this.Qbn.clear();
    }
    this.hQX = "";
    AppMethodBeat.o(311397);
    return str;
  }
  
  public final void lg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311420);
    a locala = ajH(paramInt1);
    if (locala != null)
    {
      locala.Qbs = paramInt2;
      locala.Qbq += locala.Qbt;
      locala.Qbt = 0;
    }
    AppMethodBeat.o(311420);
  }
  
  static final class a
  {
    int LKo;
    int PXC;
    int PXy;
    int Qbo;
    int Qbp;
    int Qbq;
    int Qbr;
    int Qbs;
    int Qbt;
    int clickCount;
    int index;
    int mediaType;
    
    final JSONObject toJson()
    {
      AppMethodBeat.i(311280);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("index", Integer.valueOf(this.index));
        localJSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
        localJSONObject.putOpt("exposureCount", Integer.valueOf(this.PXy));
        localJSONObject.putOpt("autoSlideInCount", Integer.valueOf(this.Qbo));
        localJSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
        localJSONObject.putOpt("btnClickCount", Integer.valueOf(this.PXC));
        localJSONObject.putOpt("playCount", Integer.valueOf(this.LKo));
        localJSONObject.putOpt("finishPlayCount", Integer.valueOf(this.Qbp));
        localJSONObject.putOpt("playTotalTime", Integer.valueOf(this.Qbq + this.Qbt));
        if (this.Qbp > 0) {}
        for (int i = this.Qbs;; i = this.Qbr)
        {
          localJSONObject.putOpt("maxPlayTime", Integer.valueOf(i));
          localJSONObject.putOpt("videoTotalTime", Integer.valueOf(this.Qbs));
          return localJSONObject;
        }
        return null;
      }
      finally
      {
        AppMethodBeat.o(311280);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.a.b
 * JD-Core Version:    0.7.0.1
 */