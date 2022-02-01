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
  public int PAa;
  public MoreFooter PzX;
  public Info PzY;
  public Style PzZ;
  public String fQb;
  public String query;
  
  static
  {
    AppMethodBeat.i(117833);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(117833);
  }
  
  public WidgetData() {}
  
  protected WidgetData(Parcel paramParcel)
  {
    AppMethodBeat.i(117832);
    this.PzX = ((MoreFooter)paramParcel.readParcelable(MoreFooter.class.getClassLoader()));
    this.PzY = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.PzZ = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.PAa = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.fQb = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData biW(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.PzY = new Info();
    localWidgetData.PzZ = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.PzY.appid = paramString.optString("appid");
        localWidgetData.PzY.version = paramString.optInt("version");
        localWidgetData.PzY.nickName = paramString.optString("nickName");
        localWidgetData.PzY.userName = paramString.optString("username");
        localWidgetData.PzY.lyD = paramString.optString("srcAppid");
        localWidgetData.PzY.PAb = paramString.optString("inputData");
        localWidgetData.PzY.fve = paramString.optString("pagePath");
        localWidgetData.PzY.PAc = paramString.optString("wxaData");
        localWidgetData.PzY.PAd = paramString.optString("launchwxawidget");
        localWidgetData.PzY.serviceType = Util.safeParseInt(paramString.optString("serviceType"));
        Object localObject = localWidgetData.PzY;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).qbu = i;
          localWidgetData.PzY.jQi = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.PzY.MFy = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.PzZ;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).PAj = i;
            localWidgetData.PzZ.height = paramString.optInt("height");
            localWidgetData.PzZ.width = paramString.optInt("width");
            localWidgetData.PzZ.nWx = paramString.optString("backgroundColor");
            localObject = localWidgetData.PzZ;
            if (!paramString.has("minHeight")) {
              break label529;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).PAi = d;
            localWidgetData.PzZ.oYQ = paramString.optInt("offsetX");
            localWidgetData.PzZ.oYR = paramString.optInt("offsetY");
            localObject = localWidgetData.PzZ;
            if (!paramString.has("show")) {
              break label534;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).fWq = bool;
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
      label529:
      double d = 0.0D;
      continue;
      label534:
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
    if ((this.PAa == paramObject.PAa) && (Objects.equals(this.PzX, paramObject.PzX)) && (Objects.equals(this.PzY, paramObject.PzY)) && (Objects.equals(this.PzZ, paramObject.PzZ)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.fQb, paramObject.fQb)))
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
    int i = Objects.hash(new Object[] { this.PzX, this.PzY, this.PzZ, Integer.valueOf(this.PAa), this.query, this.fQb });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.PzY == null)
    {
      str1 = "";
      if (this.PzZ != null) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.PzZ.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.PzY.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.PzX, paramInt);
    paramParcel.writeParcelable(this.PzY, paramInt);
    paramParcel.writeParcelable(this.PzZ, paramInt);
    paramParcel.writeInt(this.PAa);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.fQb);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public boolean AVv;
    public String BHW;
    public long MFy;
    public String PAb;
    public String PAc;
    public String PAd;
    public String PAe;
    public String PAf;
    public String appid;
    public String downloadUrl;
    public String footerWording;
    public String fve;
    public String iconUrl;
    public String jQi;
    public String label;
    public String lyD;
    public String nickName;
    public int qbu;
    public int serviceType;
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
      this.PAb = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.PAc = paramParcel.readString();
      this.PAd = paramParcel.readString();
      this.fve = paramParcel.readString();
      this.appid = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.qbu = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.BHW = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.PAe = paramParcel.readString();
      this.jQi = paramParcel.readString();
      this.label = paramParcel.readString();
      this.MFy = paramParcel.readLong();
      this.lyD = paramParcel.readString();
      this.PAf = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.AVv = bool;
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
      if ((this.serviceType == paramObject.serviceType) && (this.qbu == paramObject.qbu) && (this.version == paramObject.version) && (this.MFy == paramObject.MFy) && (this.AVv == paramObject.AVv) && (Objects.equals(this.PAb, paramObject.PAb)) && (Objects.equals(this.nickName, paramObject.nickName)) && (Objects.equals(this.PAc, paramObject.PAc)) && (Objects.equals(this.PAd, paramObject.PAd)) && (Objects.equals(this.fve, paramObject.fve)) && (Objects.equals(this.appid, paramObject.appid)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.BHW, paramObject.BHW)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.PAe, paramObject.PAe)) && (Objects.equals(this.jQi, paramObject.jQi)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.lyD, paramObject.lyD)) && (Objects.equals(this.PAf, paramObject.PAf)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
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
      int i = Objects.hash(new Object[] { Integer.valueOf(this.serviceType), this.PAb, this.nickName, this.PAc, this.PAd, this.fve, this.appid, this.userName, Integer.valueOf(this.qbu), Integer.valueOf(this.version), this.BHW, this.iconUrl, this.downloadUrl, this.PAe, this.jQi, this.label, Long.valueOf(this.MFy), this.lyD, this.PAf, this.footerWording, Boolean.valueOf(this.AVv) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.appid, this.lyD, Long.valueOf(this.MFy), this.fve });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.serviceType);
      paramParcel.writeString(this.PAb);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.PAc);
      paramParcel.writeString(this.PAd);
      paramParcel.writeString(this.fve);
      paramParcel.writeString(this.appid);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.qbu);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.BHW);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.PAe);
      paramParcel.writeString(this.jQi);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.MFy);
      paramParcel.writeString(this.lyD);
      paramParcel.writeString(this.PAf);
      paramParcel.writeString(this.footerWording);
      if (this.AVv) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117811);
        return;
      }
    }
  }
  
  public static class MoreFooter
    implements Parcelable
  {
    public static final Parcelable.Creator<MoreFooter> CREATOR;
    public String PAg;
    public String PAh;
    public String title;
    
    static
    {
      AppMethodBeat.i(117819);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117819);
    }
    
    public MoreFooter() {}
    
    protected MoreFooter(Parcel paramParcel)
    {
      AppMethodBeat.i(117816);
      this.title = paramParcel.readString();
      this.PAg = paramParcel.readString();
      this.PAh = paramParcel.readString();
      AppMethodBeat.o(117816);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(117817);
      if (this == paramObject)
      {
        AppMethodBeat.o(117817);
        return true;
      }
      if (!(paramObject instanceof MoreFooter))
      {
        AppMethodBeat.o(117817);
        return false;
      }
      paramObject = (MoreFooter)paramObject;
      if ((Objects.equals(this.title, paramObject.title)) && (Objects.equals(this.PAg, paramObject.PAg)) && (Objects.equals(this.PAh, paramObject.PAh)))
      {
        AppMethodBeat.o(117817);
        return true;
      }
      AppMethodBeat.o(117817);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(117818);
      int i = Objects.hash(new Object[] { this.title, this.PAg, this.PAh });
      AppMethodBeat.o(117818);
      return i;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117815);
      paramParcel.writeString(this.title);
      paramParcel.writeString(this.PAg);
      paramParcel.writeString(this.PAh);
      AppMethodBeat.o(117815);
    }
  }
  
  public static class Style
    implements Parcelable
  {
    public static final Parcelable.Creator<Style> CREATOR;
    public double PAi;
    public int PAj;
    public boolean fWq;
    public int height;
    public String nWx;
    public int oYQ;
    public int oYR;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.PAi = 65.0D;
      this.fWq = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.PAi = 65.0D;
      this.fWq = true;
      this.PAi = paramParcel.readDouble();
      this.PAj = paramParcel.readInt();
      this.oYQ = paramParcel.readInt();
      this.oYR = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.nWx = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.fWq = bool;
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
      if ((Double.compare(paramObject.PAi, this.PAi) == 0) && (this.PAj == paramObject.PAj) && (this.oYQ == paramObject.oYQ) && (this.oYR == paramObject.oYR) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.fWq == paramObject.fWq) && (Objects.equals(this.nWx, paramObject.nWx)))
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
      int i = Objects.hash(new Object[] { Double.valueOf(this.PAi), Integer.valueOf(this.PAj), Integer.valueOf(this.oYQ), Integer.valueOf(this.oYR), Integer.valueOf(this.height), this.nWx, Integer.valueOf(this.width), Boolean.valueOf(this.fWq) });
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
      paramParcel.writeDouble(this.PAi);
      paramParcel.writeInt(this.PAj);
      paramParcel.writeInt(this.oYQ);
      paramParcel.writeInt(this.oYR);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.nWx);
      paramParcel.writeInt(this.width);
      if (this.fWq) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */