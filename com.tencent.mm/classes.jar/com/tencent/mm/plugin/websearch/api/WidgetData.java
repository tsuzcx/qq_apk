package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public WidgetData.MoreFooter Wqm;
  public Info Wqn;
  public Style Wqo;
  public int Wqp;
  public String hVW;
  public String query;
  
  static
  {
    AppMethodBeat.i(117833);
    CREATOR = new WidgetData.1();
    AppMethodBeat.o(117833);
  }
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    AppMethodBeat.i(117832);
    this.Wqm = ((WidgetData.MoreFooter)paramParcel.readParcelable(WidgetData.MoreFooter.class.getClassLoader()));
    this.Wqn = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.Wqo = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.Wqp = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.hVW = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData biE(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.Wqn = new Info();
    localWidgetData.Wqo = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.Wqn.appid = paramString.optString("appid");
        localWidgetData.Wqn.version = paramString.optInt("version");
        localWidgetData.Wqn.nickName = paramString.optString("nickName");
        localWidgetData.Wqn.userName = paramString.optString("username");
        localWidgetData.Wqn.oqe = paramString.optString("srcAppid");
        localWidgetData.Wqn.Wqq = paramString.optString("inputData");
        localWidgetData.Wqn.hzy = paramString.optString("pagePath");
        localWidgetData.Wqn.Wqr = paramString.optString("wxaData");
        localWidgetData.Wqn.Wqs = paramString.optString("launchwxawidget");
        localWidgetData.Wqn.serviceType = Util.safeParseInt(paramString.optString("serviceType"));
        Object localObject = localWidgetData.Wqn;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).tgv = i;
          localWidgetData.Wqn.mpa = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.Wqn.TpJ = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.Wqo;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).Wqy = i;
            localWidgetData.Wqo.height = paramString.optInt("height");
            localWidgetData.Wqo.width = paramString.optInt("width");
            localWidgetData.Wqo.qWk = paramString.optString("backgroundColor");
            localObject = localWidgetData.Wqo;
            if (!paramString.has("minHeight")) {
              break label527;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).Wqx = d;
            localWidgetData.Wqo.sep = paramString.optInt("offsetX");
            localWidgetData.Wqo.ser = paramString.optInt("offsetY");
            localObject = localWidgetData.Wqo;
            if (!paramString.has("show")) {
              break label532;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).icp = bool;
            AppMethodBeat.o(117830);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          Log.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        Log.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
        AppMethodBeat.o(117830);
        return null;
      }
      continue;
      label527:
      double d = 0.0D;
      continue;
      label532:
      boolean bool = true;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(117828);
    if (this == paramObject)
    {
      AppMethodBeat.o(117828);
      return true;
    }
    if (!(paramObject instanceof WidgetData))
    {
      AppMethodBeat.o(117828);
      return false;
    }
    paramObject = (WidgetData)paramObject;
    if ((this.Wqp == paramObject.Wqp) && (Objects.equals(this.Wqm, paramObject.Wqm)) && (Objects.equals(this.Wqn, paramObject.Wqn)) && (Objects.equals(this.Wqo, paramObject.Wqo)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.hVW, paramObject.hVW)))
    {
      AppMethodBeat.o(117828);
      return true;
    }
    AppMethodBeat.o(117828);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(117829);
    int i = Objects.hash(new Object[] { this.Wqm, this.Wqn, this.Wqo, Integer.valueOf(this.Wqp), this.query, this.hVW });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.Wqn == null)
    {
      str1 = "";
      if (this.Wqo != null) {
        break label64;
      }
    }
    label64:
    for (String str2 = "";; str2 = this.Wqo.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.Wqn.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.Wqm, paramInt);
    paramParcel.writeParcelable(this.Wqn, paramInt);
    paramParcel.writeParcelable(this.Wqo, paramInt);
    paramParcel.writeInt(this.Wqp);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.hVW);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public boolean FYI;
    public String HsD;
    public long TpJ;
    public String Wqq;
    public String Wqr;
    public String Wqs;
    public String Wqt;
    public String Wqu;
    public String appid;
    public String downloadUrl;
    public String footerWording;
    public String hzy;
    public String iconUrl;
    public String label;
    public String mpa;
    public String nickName;
    public String oqe;
    public int serviceType;
    public int tgv;
    public String userName;
    public int version;
    
    static
    {
      AppMethodBeat.i(117813);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117813);
    }
    
    public Info() {}
    
    protected Info(Parcel paramParcel)
    {
      AppMethodBeat.i(117812);
      this.serviceType = paramParcel.readInt();
      this.Wqq = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.Wqr = paramParcel.readString();
      this.Wqs = paramParcel.readString();
      this.hzy = paramParcel.readString();
      this.appid = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.tgv = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.HsD = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.Wqt = paramParcel.readString();
      this.mpa = paramParcel.readString();
      this.label = paramParcel.readString();
      this.TpJ = paramParcel.readLong();
      this.oqe = paramParcel.readString();
      this.Wqu = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.FYI = bool;
        AppMethodBeat.o(117812);
        return;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117809);
      if (this == paramObject)
      {
        AppMethodBeat.o(117809);
        return true;
      }
      if (!(paramObject instanceof Info))
      {
        AppMethodBeat.o(117809);
        return false;
      }
      paramObject = (Info)paramObject;
      if ((this.serviceType == paramObject.serviceType) && (this.tgv == paramObject.tgv) && (this.version == paramObject.version) && (this.TpJ == paramObject.TpJ) && (this.FYI == paramObject.FYI) && (Objects.equals(this.Wqq, paramObject.Wqq)) && (Objects.equals(this.nickName, paramObject.nickName)) && (Objects.equals(this.Wqr, paramObject.Wqr)) && (Objects.equals(this.Wqs, paramObject.Wqs)) && (Objects.equals(this.hzy, paramObject.hzy)) && (Objects.equals(this.appid, paramObject.appid)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.HsD, paramObject.HsD)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.Wqt, paramObject.Wqt)) && (Objects.equals(this.mpa, paramObject.mpa)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.oqe, paramObject.oqe)) && (Objects.equals(this.Wqu, paramObject.Wqu)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
      {
        AppMethodBeat.o(117809);
        return true;
      }
      AppMethodBeat.o(117809);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117810);
      int i = Objects.hash(new Object[] { Integer.valueOf(this.serviceType), this.Wqq, this.nickName, this.Wqr, this.Wqs, this.hzy, this.appid, this.userName, Integer.valueOf(this.tgv), Integer.valueOf(this.version), this.HsD, this.iconUrl, this.downloadUrl, this.Wqt, this.mpa, this.label, Long.valueOf(this.TpJ), this.oqe, this.Wqu, this.footerWording, Boolean.valueOf(this.FYI) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.appid, this.oqe, Long.valueOf(this.TpJ), this.hzy });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.Wqq);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.Wqr);
      paramParcel.writeString(this.Wqs);
      paramParcel.writeString(this.hzy);
      paramParcel.writeString(this.appid);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.tgv);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.HsD);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.Wqt);
      paramParcel.writeString(this.mpa);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.TpJ);
      paramParcel.writeString(this.oqe);
      paramParcel.writeString(this.Wqu);
      paramParcel.writeString(this.footerWording);
      if (this.FYI) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117811);
        return;
      }
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double Wqx;
    public int Wqy;
    public int height;
    public boolean icp;
    public String qWk;
    public int sep;
    public int ser;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.Wqx = 65.0D;
      this.icp = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.Wqx = 65.0D;
      this.icp = true;
      this.Wqx = paramParcel.readDouble();
      this.Wqy = paramParcel.readInt();
      this.sep = paramParcel.readInt();
      this.ser = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.qWk = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.icp = bool;
        AppMethodBeat.o(117823);
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117824);
      if (this == paramObject)
      {
        AppMethodBeat.o(117824);
        return true;
      }
      if (!(paramObject instanceof Style))
      {
        AppMethodBeat.o(117824);
        return false;
      }
      paramObject = (Style)paramObject;
      if ((Double.compare(paramObject.Wqx, this.Wqx) == 0) && (this.Wqy == paramObject.Wqy) && (this.sep == paramObject.sep) && (this.ser == paramObject.ser) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.icp == paramObject.icp) && (Objects.equals(this.qWk, paramObject.qWk)))
      {
        AppMethodBeat.o(117824);
        return true;
      }
      AppMethodBeat.o(117824);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117825);
      int i = Objects.hash(new Object[] { Double.valueOf(this.Wqx), Integer.valueOf(this.Wqy), Integer.valueOf(this.sep), Integer.valueOf(this.ser), Integer.valueOf(this.height), this.qWk, Integer.valueOf(this.width), Boolean.valueOf(this.icp) });
      AppMethodBeat.o(117825);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117821);
      String str = super.toString();
      AppMethodBeat.o(117821);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117822);
      paramParcel.writeDouble(this.Wqx);
      paramParcel.writeInt(this.Wqy);
      paramParcel.writeInt(this.sep);
      paramParcel.writeInt(this.ser);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.qWk);
      paramParcel.writeInt(this.width);
      if (this.icp) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */