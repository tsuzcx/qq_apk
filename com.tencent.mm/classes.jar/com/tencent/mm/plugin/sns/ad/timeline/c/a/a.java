package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.a.d;
import com.tencent.mm.plugin.sns.ad.a.e;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.plugin.sns.ad.i.i.b;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends i.b
{
  int Dzm;
  List<a> Dzn;
  String adExtInfo;
  int currentIndex;
  String dRS;
  int scene;
  String uxInfo;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(202257);
    this.Dzm = 0;
    this.Dzn = new ArrayList();
    this.currentIndex = -1;
    this.scene = paramInt;
    AppMethodBeat.o(202257);
  }
  
  private void H(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(202268);
    if (c.isEmpty(this.Dzn))
    {
      AppMethodBeat.o(202268);
      return;
    }
    Iterator localIterator = this.Dzn.iterator();
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
    AppMethodBeat.o(202268);
  }
  
  private boolean XO(int paramInt)
  {
    AppMethodBeat.i(202263);
    int i = this.Dzn.size();
    if ((paramInt >= 0) && (paramInt < i))
    {
      AppMethodBeat.o(202263);
      return true;
    }
    AppMethodBeat.o(202263);
    return false;
  }
  
  private void aNS(String paramString)
  {
    AppMethodBeat.i(202260);
    this.uxInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(202260);
  }
  
  private void setSnsId(String paramString)
  {
    AppMethodBeat.i(202259);
    this.dRS = Util.nullAsNil(paramString);
    AppMethodBeat.o(202259);
  }
  
  public final void XN(int paramInt)
  {
    AppMethodBeat.i(202261);
    a locala = XP(paramInt);
    if (locala != null) {
      locala.clickCount += 1;
    }
    AppMethodBeat.o(202261);
  }
  
  final a XP(int paramInt)
  {
    AppMethodBeat.i(202264);
    if (XO(paramInt))
    {
      a locala = (a)this.Dzn.get(paramInt);
      AppMethodBeat.o(202264);
      return locala;
    }
    AppMethodBeat.o(202264);
    return null;
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt, d paramd)
  {
    AppMethodBeat.i(202258);
    if (paramSnsInfo == null)
    {
      Log.i("SnsAd.AdChannelData", "the sns info is null!");
      AppMethodBeat.o(202258);
      return;
    }
    Object localObject = r.v(paramSnsInfo);
    if ((!TextUtils.isEmpty(this.dRS)) && (this.dRS.equals(localObject)))
    {
      Log.i("SnsAd.AdChannelData", "the new sns id is same as the old one!");
      AppMethodBeat.o(202258);
      return;
    }
    setSnsId((String)localObject);
    if (paramSnsInfo.getAdInfo(paramInt) != null) {
      aNS(paramSnsInfo.getUxinfo());
    }
    this.Dzn.clear();
    if ((paramd != null) && (paramd.DrS != null))
    {
      int j = paramd.DrS.size();
      paramInt = 0;
      if (paramInt < j)
      {
        paramSnsInfo = (e)paramd.DrS.get(paramInt);
        localObject = new a();
        ((a)localObject).index = paramInt;
        this.Dzn.add(localObject);
        if (paramSnsInfo != null) {
          if (!paramSnsInfo.eWB()) {
            break label205;
          }
        }
        label205:
        for (int i = 2;; i = 1)
        {
          ((a)localObject).mediaType = i;
          ((a)localObject).DrW = Util.nullAsNil(paramSnsInfo.DrW);
          paramInt += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(202258);
  }
  
  public final void bn(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(202266);
    try
    {
      paramJSONObject.putOpt("snsid", this.dRS);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      paramJSONObject.putOpt("scene", Integer.valueOf(this.scene));
      AppMethodBeat.o(202266);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(202266);
    }
  }
  
  public final void bo(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(202267);
    try
    {
      paramJSONObject.putOpt("infoBarClickCount", Integer.valueOf(this.Dzm));
      JSONArray localJSONArray = new JSONArray();
      paramJSONObject.putOpt("reportItemList", localJSONArray);
      H(localJSONArray);
      AppMethodBeat.o(202267);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(202267);
    }
  }
  
  public final String eWH()
  {
    return "sns_ad_finder_topic_report";
  }
  
  public final void eXZ()
  {
    this.Dzm += 1;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(202265);
    String str = super.getContent();
    if (this.Dzn != null) {
      this.Dzn.clear();
    }
    this.dRS = "";
    this.Dzm = 0;
    AppMethodBeat.o(202265);
    return str;
  }
  
  public final void io(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202262);
    a locala = XP(paramInt1);
    if (locala != null)
    {
      locala.Dzs = paramInt2;
      locala.Dzq += locala.Dzt;
      locala.Dzt = 0;
    }
    AppMethodBeat.o(202262);
  }
  
  static final class a
  {
    int Aiv;
    String DrW;
    int Dzo;
    int Dzp;
    int Dzq;
    int Dzr;
    int Dzs;
    int Dzt;
    int clickCount;
    int index;
    int mediaType;
    
    final JSONObject toJson()
    {
      AppMethodBeat.i(202256);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("index", Integer.valueOf(this.index));
        localJSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
        localJSONObject.putOpt("finderType", Util.nullAsNil(this.DrW));
        localJSONObject.putOpt("exposureCount", Integer.valueOf(this.Dzo));
        localJSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
        localJSONObject.putOpt("playCount", Integer.valueOf(this.Aiv));
        localJSONObject.putOpt("finishPlayCount", Integer.valueOf(this.Dzp));
        localJSONObject.putOpt("playTotalTime", Integer.valueOf(this.Dzq + this.Dzt));
        if (this.Dzp > 0) {}
        for (int i = this.Dzs;; i = this.Dzr)
        {
          localJSONObject.putOpt("maxPlayTime", Integer.valueOf(i));
          localJSONObject.putOpt("videoTotalTime", Integer.valueOf(this.Dzs));
          AppMethodBeat.o(202256);
          return localJSONObject;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(202256);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.a
 * JD-Core Version:    0.7.0.1
 */