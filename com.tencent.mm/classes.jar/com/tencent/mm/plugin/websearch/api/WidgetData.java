package com.tencent.mm.plugin.websearch.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

public class WidgetData
  implements Parcelable
{
  public static final Parcelable.Creator<WidgetData> CREATOR;
  public WidgetData.MoreFooter BZR;
  public Info BZS;
  public Style BZT;
  public int BZU;
  public String BZV;
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
    this.BZR = ((WidgetData.MoreFooter)paramParcel.readParcelable(WidgetData.MoreFooter.class.getClassLoader()));
    this.BZS = ((Info)paramParcel.readParcelable(Info.class.getClassLoader()));
    this.BZT = ((Style)paramParcel.readParcelable(Style.class.getClassLoader()));
    this.BZU = paramParcel.readInt();
    this.query = paramParcel.readString();
    this.BZV = paramParcel.readString();
    AppMethodBeat.o(117832);
  }
  
  public static WidgetData aAC(String paramString)
  {
    AppMethodBeat.i(117830);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ac.i("WidgetData", "insert args invalid");
      AppMethodBeat.o(117830);
      return null;
    }
    WidgetData localWidgetData = new WidgetData();
    localWidgetData.BZS = new Info();
    localWidgetData.BZT = new Style();
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        localWidgetData.BZS.djj = paramString.optString("appid");
        localWidgetData.BZS.version = paramString.optInt("version");
        localWidgetData.BZS.bLs = paramString.optString("nickName");
        localWidgetData.BZS.userName = paramString.optString("username");
        localWidgetData.BZS.hsk = paramString.optString("srcAppid");
        localWidgetData.BZS.BZW = paramString.optString("inputData");
        localWidgetData.BZS.cYQ = paramString.optString("pagePath");
        localWidgetData.BZS.BZX = paramString.optString("wxaData");
        localWidgetData.BZS.BZY = paramString.optString("launchwxawidget");
        localWidgetData.BZS.cFI = bs.aLy(paramString.optString("serviceType"));
        Object localObject = localWidgetData.BZS;
        if (!paramString.has("debugMode"))
        {
          i = 0;
          ((Info)localObject).BZZ = i;
          localWidgetData.BZS.jKB = paramString.optString("searchId");
          localObject = paramString.optString("relayInfoStr");
        }
        try
        {
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("openapp_permission")) {
              localWidgetData.BZS.Cab = ((JSONObject)localObject).optLong("openapp_permission");
            }
          }
          localObject = localWidgetData.BZT;
          if (paramString.has("maxHeight"))
          {
            i = paramString.optInt("maxHeight");
            ((Style)localObject).Cag = i;
            localWidgetData.BZT.height = paramString.optInt("height");
            localWidgetData.BZT.width = paramString.optInt("width");
            localWidgetData.BZT.jBX = paramString.optString("backgroundColor");
            localObject = localWidgetData.BZT;
            if (!paramString.has("minHeight")) {
              break label529;
            }
            d = paramString.optDouble("minHeight");
            ((Style)localObject).Caf = d;
            localWidgetData.BZT.kwc = paramString.optInt("offsetX");
            localWidgetData.BZT.kwd = paramString.optInt("offsetY");
            localObject = localWidgetData.BZT;
            if (!paramString.has("show")) {
              break label534;
            }
            bool = paramString.optBoolean("show");
            ((Style)localObject).dxa = bool;
            AppMethodBeat.o(117830);
            return localWidgetData;
            i = paramString.optInt("debugMode");
          }
        }
        catch (JSONException localJSONException)
        {
          ac.printErrStackTrace("WidgetData", localJSONException, "", new Object[0]);
          continue;
        }
        int i = 2147483647;
      }
      catch (JSONException paramString)
      {
        ac.printErrStackTrace("WidgetData", paramString, "", new Object[0]);
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
    if ((this.BZU == paramObject.BZU) && (Objects.equals(this.BZR, paramObject.BZR)) && (Objects.equals(this.BZS, paramObject.BZS)) && (Objects.equals(this.BZT, paramObject.BZT)) && (Objects.equals(this.query, paramObject.query)) && (Objects.equals(this.BZV, paramObject.BZV)))
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
    int i = Objects.hash(new Object[] { this.BZR, this.BZS, this.BZT, Integer.valueOf(this.BZU), this.query, this.BZV });
    AppMethodBeat.o(117829);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(117827);
    String str1;
    if (this.BZS == null)
    {
      str1 = "";
      if (this.BZT != null) {
        break label66;
      }
    }
    label66:
    for (String str2 = "";; str2 = this.BZT.toString())
    {
      str1 = String.format("info: [%s], style:[%s]", new Object[] { str1, str2 });
      AppMethodBeat.o(117827);
      return str1;
      str1 = this.BZS.toString();
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(117831);
    paramParcel.writeParcelable(this.BZR, paramInt);
    paramParcel.writeParcelable(this.BZS, paramInt);
    paramParcel.writeParcelable(this.BZT, paramInt);
    paramParcel.writeInt(this.BZU);
    paramParcel.writeString(this.query);
    paramParcel.writeString(this.BZV);
    AppMethodBeat.o(117831);
  }
  
  public static class Info
    implements Parcelable
  {
    public static final Parcelable.Creator<Info> CREATOR;
    public String BZW;
    public String BZX;
    public String BZY;
    public int BZZ;
    public String Caa;
    public long Cab;
    public String Cac;
    public String bLs;
    public int cFI;
    public String cYQ;
    public String djj;
    public String downloadUrl;
    public String footerWording;
    public String hsk;
    public String iconUrl;
    public String jKB;
    public String label;
    public boolean rVS;
    public String sxK;
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
      this.cFI = paramParcel.readInt();
      this.BZW = paramParcel.readString();
      this.bLs = paramParcel.readString();
      this.BZX = paramParcel.readString();
      this.BZY = paramParcel.readString();
      this.cYQ = paramParcel.readString();
      this.djj = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.BZZ = paramParcel.readInt();
      this.version = paramParcel.readInt();
      this.sxK = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      this.downloadUrl = paramParcel.readString();
      this.Caa = paramParcel.readString();
      this.jKB = paramParcel.readString();
      this.label = paramParcel.readString();
      this.Cab = paramParcel.readLong();
      this.hsk = paramParcel.readString();
      this.Cac = paramParcel.readString();
      this.footerWording = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.rVS = bool;
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
      if ((this.cFI == paramObject.cFI) && (this.BZZ == paramObject.BZZ) && (this.version == paramObject.version) && (this.Cab == paramObject.Cab) && (this.rVS == paramObject.rVS) && (Objects.equals(this.BZW, paramObject.BZW)) && (Objects.equals(this.bLs, paramObject.bLs)) && (Objects.equals(this.BZX, paramObject.BZX)) && (Objects.equals(this.BZY, paramObject.BZY)) && (Objects.equals(this.cYQ, paramObject.cYQ)) && (Objects.equals(this.djj, paramObject.djj)) && (Objects.equals(this.userName, paramObject.userName)) && (Objects.equals(this.sxK, paramObject.sxK)) && (Objects.equals(this.iconUrl, paramObject.iconUrl)) && (Objects.equals(this.downloadUrl, paramObject.downloadUrl)) && (Objects.equals(this.Caa, paramObject.Caa)) && (Objects.equals(this.jKB, paramObject.jKB)) && (Objects.equals(this.label, paramObject.label)) && (Objects.equals(this.hsk, paramObject.hsk)) && (Objects.equals(this.Cac, paramObject.Cac)) && (Objects.equals(this.footerWording, paramObject.footerWording)))
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
      int i = Objects.hash(new Object[] { Integer.valueOf(this.cFI), this.BZW, this.bLs, this.BZX, this.BZY, this.cYQ, this.djj, this.userName, Integer.valueOf(this.BZZ), Integer.valueOf(this.version), this.sxK, this.iconUrl, this.downloadUrl, this.Caa, this.jKB, this.label, Long.valueOf(this.Cab), this.hsk, this.Cac, this.footerWording, Boolean.valueOf(this.rVS) });
      AppMethodBeat.o(117810);
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(117808);
      String str = String.format("appid:%s, srcAppid %s, permission %d, pathPath: %s", new Object[] { this.djj, this.hsk, Long.valueOf(this.Cab), this.cYQ });
      AppMethodBeat.o(117808);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(117811);
      paramParcel.writeInt(this.cFI);
      paramParcel.writeString(this.BZW);
      paramParcel.writeString(this.bLs);
      paramParcel.writeString(this.BZX);
      paramParcel.writeString(this.BZY);
      paramParcel.writeString(this.cYQ);
      paramParcel.writeString(this.djj);
      paramParcel.writeString(this.userName);
      paramParcel.writeInt(this.BZZ);
      paramParcel.writeInt(this.version);
      paramParcel.writeString(this.sxK);
      paramParcel.writeString(this.iconUrl);
      paramParcel.writeString(this.downloadUrl);
      paramParcel.writeString(this.Caa);
      paramParcel.writeString(this.jKB);
      paramParcel.writeString(this.label);
      paramParcel.writeLong(this.Cab);
      paramParcel.writeString(this.hsk);
      paramParcel.writeString(this.Cac);
      paramParcel.writeString(this.footerWording);
      if (this.rVS) {}
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
    public double Caf;
    public int Cag;
    public boolean dxa;
    public int height;
    public String jBX;
    public int kwc;
    public int kwd;
    public int width;
    
    static
    {
      AppMethodBeat.i(117826);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(117826);
    }
    
    public Style()
    {
      this.Caf = 65.0D;
      this.dxa = true;
    }
    
    protected Style(Parcel paramParcel)
    {
      AppMethodBeat.i(117823);
      this.Caf = 65.0D;
      this.dxa = true;
      this.Caf = paramParcel.readDouble();
      this.Cag = paramParcel.readInt();
      this.kwc = paramParcel.readInt();
      this.kwd = paramParcel.readInt();
      this.height = paramParcel.readInt();
      this.jBX = paramParcel.readString();
      this.width = paramParcel.readInt();
      if (paramParcel.readByte() != 0) {}
      for (;;)
      {
        this.dxa = bool;
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
      if ((Double.compare(paramObject.Caf, this.Caf) == 0) && (this.Cag == paramObject.Cag) && (this.kwc == paramObject.kwc) && (this.kwd == paramObject.kwd) && (this.height == paramObject.height) && (this.width == paramObject.width) && (this.dxa == paramObject.dxa) && (Objects.equals(this.jBX, paramObject.jBX)))
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
      int i = Objects.hash(new Object[] { Double.valueOf(this.Caf), Integer.valueOf(this.Cag), Integer.valueOf(this.kwc), Integer.valueOf(this.kwd), Integer.valueOf(this.height), this.jBX, Integer.valueOf(this.width), Boolean.valueOf(this.dxa) });
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
      paramParcel.writeDouble(this.Caf);
      paramParcel.writeInt(this.Cag);
      paramParcel.writeInt(this.kwc);
      paramParcel.writeInt(this.kwd);
      paramParcel.writeInt(this.height);
      paramParcel.writeString(this.jBX);
      paramParcel.writeInt(this.width);
      if (this.dxa) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(117822);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.WidgetData
 * JD-Core Version:    0.7.0.1
 */