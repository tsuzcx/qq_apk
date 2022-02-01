package com.tencent.mm.plugin.sns.ad.timeline.c.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.adxml.i;
import com.tencent.mm.plugin.sns.ad.adxml.j;
import com.tencent.mm.plugin.sns.ad.i.d;
import com.tencent.mm.plugin.sns.ad.i.j.b;
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
  List<a> JJJ;
  int JyE;
  String adExtInfo;
  int currentIndex;
  String fLp;
  int scene;
  String uxInfo;
  
  public b(int paramInt)
  {
    AppMethodBeat.i(257091);
    this.JJJ = new ArrayList();
    this.currentIndex = -1;
    this.scene = paramInt;
    AppMethodBeat.o(257091);
  }
  
  private void I(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(257101);
    if (d.isEmpty(this.JJJ))
    {
      AppMethodBeat.o(257101);
      return;
    }
    Iterator localIterator = this.JJJ.iterator();
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
    AppMethodBeat.o(257101);
  }
  
  private void aYI(String paramString)
  {
    AppMethodBeat.i(257096);
    this.uxInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(257096);
  }
  
  private void aYJ(String paramString)
  {
    AppMethodBeat.i(257097);
    this.adExtInfo = Util.nullAsNil(paramString);
    AppMethodBeat.o(257097);
  }
  
  private boolean aeX(int paramInt)
  {
    AppMethodBeat.i(257107);
    int i = this.JJJ.size();
    if ((paramInt >= 0) && (paramInt < i))
    {
      AppMethodBeat.o(257107);
      return true;
    }
    AppMethodBeat.o(257107);
    return false;
  }
  
  private void setSnsId(String paramString)
  {
    AppMethodBeat.i(257093);
    this.fLp = Util.nullAsNil(paramString);
    AppMethodBeat.o(257093);
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt, j paramj)
  {
    AppMethodBeat.i(257092);
    if (paramSnsInfo == null)
    {
      Log.i("SlideFullCardAdChannelData", "the sns info is null!");
      AppMethodBeat.o(257092);
      return;
    }
    Object localObject = t.w(paramSnsInfo);
    if ((!TextUtils.isEmpty(this.fLp)) && (this.fLp.equals(localObject)))
    {
      Log.i("SlideFullCardAdChannelData", "the new sns id is same as the old one!");
      AppMethodBeat.o(257092);
      return;
    }
    setSnsId((String)localObject);
    if (paramSnsInfo.getAdInfo(paramInt) != null) {
      aYI(paramSnsInfo.getUxinfo());
    }
    aYJ(paramSnsInfo.getAdXml().adExtInfo);
    this.JJJ.clear();
    if ((paramj != null) && (paramj.Jym != null))
    {
      int j = paramj.Jym.size();
      this.JyE = paramj.JyE;
      paramInt = 0;
      if ((paramInt < j) && ((this.JyE > 4) || (paramInt != this.JyE)))
      {
        paramSnsInfo = (i)paramj.Jym.get(paramInt);
        localObject = new a();
        ((a)localObject).index = paramInt;
        this.JJJ.add(localObject);
        if (paramSnsInfo != null) {
          if (!paramSnsInfo.fJE()) {
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
    AppMethodBeat.o(257092);
  }
  
  public final void aeV(int paramInt)
  {
    AppMethodBeat.i(257104);
    a locala = aeY(paramInt);
    if (locala != null) {
      locala.clickCount += 1;
    }
    AppMethodBeat.o(257104);
  }
  
  public final void aeW(int paramInt)
  {
    AppMethodBeat.i(257105);
    a locala = aeY(paramInt);
    if (locala != null) {
      locala.JGC += 1;
    }
    AppMethodBeat.o(257105);
  }
  
  final a aeY(int paramInt)
  {
    AppMethodBeat.i(257108);
    int i = paramInt;
    if (this.JyE <= 4) {
      i = paramInt % this.JyE;
    }
    if (aeX(i))
    {
      a locala = (a)this.JJJ.get(i);
      AppMethodBeat.o(257108);
      return locala;
    }
    AppMethodBeat.o(257108);
    return null;
  }
  
  public final void bw(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(257099);
    try
    {
      paramJSONObject.putOpt("snsid", this.fLp);
      paramJSONObject.putOpt("uxinfo", this.uxInfo);
      paramJSONObject.putOpt("adExtInfo", this.adExtInfo);
      paramJSONObject.putOpt("scene", Integer.valueOf(this.scene));
      AppMethodBeat.o(257099);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(257099);
    }
  }
  
  public final void bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(257100);
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramJSONObject.putOpt("reportItemList", localJSONArray);
      I(localJSONArray);
      AppMethodBeat.o(257100);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      AppMethodBeat.o(257100);
    }
  }
  
  public final String fJK()
  {
    return "sns_ad_slider_card_report";
  }
  
  public final String getContent()
  {
    AppMethodBeat.i(257103);
    String str = super.getContent();
    if (this.JJJ != null) {
      this.JJJ.clear();
    }
    this.fLp = "";
    AppMethodBeat.o(257103);
    return str;
  }
  
  public final void jx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(257106);
    a locala = aeY(paramInt1);
    if (locala != null)
    {
      locala.JJO = paramInt2;
      locala.JJM += locala.JJP;
      locala.JJP = 0;
    }
    AppMethodBeat.o(257106);
  }
  
  static final class a
  {
    int FPs;
    int JGC;
    int JGy;
    int JJK;
    int JJL;
    int JJM;
    int JJN;
    int JJO;
    int JJP;
    int clickCount;
    int index;
    int mediaType;
    
    final JSONObject toJson()
    {
      AppMethodBeat.i(196764);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.putOpt("index", Integer.valueOf(this.index));
        localJSONObject.putOpt("mediaType", Integer.valueOf(this.mediaType));
        localJSONObject.putOpt("exposureCount", Integer.valueOf(this.JGy));
        localJSONObject.putOpt("autoSlideInCount", Integer.valueOf(this.JJK));
        localJSONObject.putOpt("clickCount", Integer.valueOf(this.clickCount));
        localJSONObject.putOpt("btnClickCount", Integer.valueOf(this.JGC));
        localJSONObject.putOpt("playCount", Integer.valueOf(this.FPs));
        localJSONObject.putOpt("finishPlayCount", Integer.valueOf(this.JJL));
        localJSONObject.putOpt("playTotalTime", Integer.valueOf(this.JJM + this.JJP));
        if (this.JJL > 0) {}
        for (int i = this.JJO;; i = this.JJN)
        {
          localJSONObject.putOpt("maxPlayTime", Integer.valueOf(i));
          localJSONObject.putOpt("videoTotalTime", Integer.valueOf(this.JJO));
          AppMethodBeat.o(196764);
          return localJSONObject;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        AppMethodBeat.o(196764);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.a.b
 * JD-Core Version:    0.7.0.1
 */