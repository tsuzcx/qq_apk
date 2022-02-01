package com.tencent.mm.plugin.sns.ad.timeline.c.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.e;
import com.tencent.mm.plugin.sns.ad.i.j.b;
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
  int JKP;
  List<a> JKQ;
  String adExtInfo;
  int currentIndex;
  String fLp;
  int scene;
  String uxInfo;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(248053);
    this.JKP = 0;
    this.JKQ = new ArrayList();
    this.currentIndex = -1;
    this.scene = paramInt;
    AppMethodBeat.o(248053);
  }
  
  private void I(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(248074);
    if (com.tencent.mm.plugin.sns.ad.i.d.isEmpty(this.JKQ))
    {
      AppMethodBeat.o(248074);
      return;
    }
    Iterator localIterator = this.JKQ.iterator();
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
    AppMethodBeat.o(248074);
  }
  
  private void aYI(String paramString)
  {
    AppMethodBeat.i(248061);
    this.uxInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(248061);
  }
  
  private boolean aeX(int paramInt)
  {
    AppMethodBeat.i(248066);
    int i = this.JKQ.size();
    if ((paramInt >= 0) && (paramInt < i))
    {
      AppMethodBeat.o(248066);
      return true;
    }
    AppMethodBeat.o(248066);
    return false;
  }
  
  private void setSnsId(String paramString)
  {
    AppMethodBeat.i(248057);
    this.fLp = Util.nullAsNil(paramString);
    AppMethodBeat.o(248057);
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt, com.tencent.mm.plugin.sns.ad.adxml.d paramd)
  {
    AppMethodBeat.i(248054);
    if (paramSnsInfo == null)
    {
      Log.i("SnsAd.AdChannelData", "the sns info is null!");
      AppMethodBeat.o(248054);
      return;
    }
    Object localObject = t.w(paramSnsInfo);
    if ((!TextUtils.isEmpty(this.fLp)) && (this.fLp.equals(localObject)))
    {
      Log.i("SnsAd.AdChannelData", "the new sns id is same as the old one!");
      AppMethodBeat.o(248054);
      return;
    }
    setSnsId((String)localObject);
    if (paramSnsInfo.getAdInfo(paramInt) != null) {
      aYI(paramSnsInfo.getUxinfo());
    }
    this.JKQ.clear();
    if ((paramd != null) && (paramd.Jym != null))
    {
      int j = paramd.Jym.size();
      paramInt = 0;
      if (paramInt < j)
      {
        paramSnsInfo = (e)paramd.Jym.get(paramInt);
        localObject = new a();
        ((a)localObject).index = paramInt;
        this.JKQ.add(localObject);
        if (paramSnsInfo != null) {
          if (!paramSnsInfo.fJE()) {
            break label205;
          }
        }
        label205:
        for (int i = 2;; i = 1)
        {
          ((a)localObject).mediaType = i;
          ((a)localObject).Jyq = Util.nullAsNil(paramSnsInfo.Jyq);
          paramInt += 1;
          break;
        }
      }
    }
    AppMethodBeat.o(248054);
  }
  
  public final void aeV(int paramInt)
  {
    AppMethodBeat.i(248063);
    a locala = afd(paramInt);
    if (locala != null) {
      locala.clickCount += 1;
    }
    AppMethodBeat.o(248063);
  }
  
  final a afd(int paramInt)
  {
    AppMethodBeat.i(248067);
    if (aeX(paramInt))
    {
      a locala = (a)this.JKQ.get(paramInt);
      AppMethodBeat.o(248067);
      return locala;
    }
    AppMethodBeat.o(248067);
    return null;
  }
  
  public final void bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(248069);
    try
    {
      paramJSONObject.putOpt("snsid", this.fLp);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      paramJSONObject.putOpt("scene", Integer.valueOf(this.scene));
      AppMethodBeat.o(248069);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(248069);
    }
  }
  
  public final void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(248071);
    try
    {
      paramJSONObject.putOpt("infoBarClickCount", Integer.valueOf(this.JKP));
      JSONArray localJSONArray = new JSONArray();
      paramJSONObject.putOpt("reportItemList", localJSONArray);
      I(localJSONArray);
      AppMethodBeat.o(248071);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(248071);
    }
  }
  
  public final String fJK()
  {
    return "sns_ad_finder_topic_report";
  }
  
  public final void fLG()
  {
    this.JKP += 1;
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(248068);
    String str = super.getContent();
    if (this.JKQ != null) {
      this.JKQ.clear();
    }
    this.fLp = "";
    this.JKP = 0;
    AppMethodBeat.o(248068);
    return str;
  }
  
  public final void jx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248065);
    a locala = afd(paramInt1);
    if (locala != null)
    {
      locala.JJO = paramInt2;
      locala.JJM += locala.JJP;
      locala.JJP = 0;
    }
    AppMethodBeat.o(248065);
  }
  
  static final class a
  {
    int FPs;
    int JGy;
    int JJL;
    int JJM;
    int JJN;
    int JJO;
    int JJP;
    String Jyq;
    int clickCount;
    int index;
    int mediaType;
    
    final JSONObject toJson()
    {
      AppMethodBeat.i(270125);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("index", Integer.valueOf(this.index));
        localJSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
        localJSONObject.putOpt("finderType", Util.nullAsNil(this.Jyq));
        localJSONObject.putOpt("exposureCount", Integer.valueOf(this.JGy));
        localJSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
        localJSONObject.putOpt("playCount", Integer.valueOf(this.FPs));
        localJSONObject.putOpt("finishPlayCount", Integer.valueOf(this.JJL));
        localJSONObject.putOpt("playTotalTime", Integer.valueOf(this.JJM + this.JJP));
        if (this.JJL > 0) {}
        for (int i = this.JJO;; i = this.JJN)
        {
          localJSONObject.putOpt("maxPlayTime", Integer.valueOf(i));
          localJSONObject.putOpt("videoTotalTime", Integer.valueOf(this.JJO));
          AppMethodBeat.o(270125);
          return localJSONObject;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(270125);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.c.a
 * JD-Core Version:    0.7.0.1
 */