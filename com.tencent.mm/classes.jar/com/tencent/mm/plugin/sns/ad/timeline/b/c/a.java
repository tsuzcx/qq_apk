package com.tencent.mm.plugin.sns.ad.timeline.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.f;
import com.tencent.mm.plugin.sns.ad.adxml.g;
import com.tencent.mm.plugin.sns.ad.j.d;
import com.tencent.mm.plugin.sns.ad.j.j.b;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends j.b
{
  int Qcy;
  List<a> Qcz;
  String adExtInfo;
  int currentIndex;
  String hQX;
  int scene;
  String uxInfo;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(311212);
    this.Qcy = 0;
    this.Qcz = new ArrayList();
    this.currentIndex = -1;
    this.scene = paramInt;
    AppMethodBeat.o(311212);
  }
  
  private void N(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(311242);
    if (d.isEmpty(this.Qcz))
    {
      AppMethodBeat.o(311242);
      return;
    }
    Iterator localIterator = this.Qcz.iterator();
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
    AppMethodBeat.o(311242);
  }
  
  private void aWO(String paramString)
  {
    AppMethodBeat.i(311227);
    this.uxInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(311227);
  }
  
  private boolean ajG(int paramInt)
  {
    AppMethodBeat.i(311233);
    int i = this.Qcz.size();
    if ((paramInt >= 0) && (paramInt < i))
    {
      AppMethodBeat.o(311233);
      return true;
    }
    AppMethodBeat.o(311233);
    return false;
  }
  
  private void setSnsId(String paramString)
  {
    AppMethodBeat.i(311222);
    this.hQX = Util.nullAsNil(paramString);
    AppMethodBeat.o(311222);
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt, f paramf)
  {
    AppMethodBeat.i(311254);
    if (paramSnsInfo == null)
    {
      Log.i("SnsAd.AdChannelData", "the sns info is null!");
      AppMethodBeat.o(311254);
      return;
    }
    Object localObject = t.x(paramSnsInfo);
    if ((!TextUtils.isEmpty(this.hQX)) && (this.hQX.equals(localObject)))
    {
      Log.i("SnsAd.AdChannelData", "the new sns id is same as the old one!");
      AppMethodBeat.o(311254);
      return;
    }
    setSnsId((String)localObject);
    if (paramSnsInfo.getAdInfo(paramInt) != null) {
      aWO(paramSnsInfo.getUxinfo());
    }
    this.Qcz.clear();
    if ((paramf != null) && (paramf.PMG != null))
    {
      int j = paramf.PMG.size();
      paramInt = 0;
      if (paramInt < j)
      {
        paramSnsInfo = (g)paramf.PMG.get(paramInt);
        localObject = new a();
        ((a)localObject).index = paramInt;
        this.Qcz.add(localObject);
        if (paramSnsInfo != null) {
          if (!paramSnsInfo.gZy()) {
            break label205;
          }
        }
        label205:
        for (int i = 2;; i = 1)
        {
          ((a)localObject).mediaType = i;
          ((a)localObject).PMK = Util.nullAsNil(paramSnsInfo.PMK);
          paramInt += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(311254);
  }
  
  public final void ajE(int paramInt)
  {
    AppMethodBeat.i(311268);
    a locala = ajM(paramInt);
    if (locala != null) {
      locala.clickCount += 1;
    }
    AppMethodBeat.o(311268);
  }
  
  final a ajM(int paramInt)
  {
    AppMethodBeat.i(311284);
    if (ajG(paramInt))
    {
      a locala = (a)this.Qcz.get(paramInt);
      AppMethodBeat.o(311284);
      return locala;
    }
    AppMethodBeat.o(311284);
    return null;
  }
  
  public final void bN(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(311306);
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
      AppMethodBeat.o(311306);
    }
  }
  
  public final void bO(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(311311);
    try
    {
      paramJSONObject.putOpt("infoBarClickCount", Integer.valueOf(this.Qcy));
      JSONArray localJSONArray = new JSONArray();
      paramJSONObject.putOpt("reportItemList", localJSONArray);
      N(localJSONArray);
      return;
    }
    finally
    {
      AppMethodBeat.o(311311);
    }
  }
  
  public final String gZE()
  {
    return "sns_ad_finder_topic_report";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(311294);
    String str = super.getContent();
    if (this.Qcz != null) {
      this.Qcz.clear();
    }
    this.hQX = "";
    this.Qcy = 0;
    AppMethodBeat.o(311294);
    return str;
  }
  
  public final void hcc()
  {
    this.Qcy += 1;
  }
  
  public final void lg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(311276);
    a locala = ajM(paramInt1);
    if (locala != null)
    {
      locala.Qbs = paramInt2;
      locala.Qbq += locala.Qbt;
      locala.Qbt = 0;
    }
    AppMethodBeat.o(311276);
  }
  
  static final class a
  {
    int LKo;
    String PMK;
    int PXy;
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
      AppMethodBeat.i(311240);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("index", Integer.valueOf(this.index));
        localJSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
        localJSONObject.putOpt("finderType", Util.nullAsNil(this.PMK));
        localJSONObject.putOpt("exposureCount", Integer.valueOf(this.PXy));
        localJSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
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
        AppMethodBeat.o(311240);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.b.c.a
 * JD-Core Version:    0.7.0.1
 */