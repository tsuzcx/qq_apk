package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadParamAidl
  implements Parcelable
{
  public static final Parcelable.Creator<TPDownloadParamAidl> CREATOR;
  private int dlType;
  private Map<String, Object> extInfoMap;
  private ArrayList<String> urlList;
  
  static
  {
    AppMethodBeat.i(255434);
    CREATOR = new Parcelable.Creator()
    {
      public final TPDownloadParamAidl createFromParcel(Parcel paramAnonymousParcel)
      {
        AppMethodBeat.i(255407);
        paramAnonymousParcel = new TPDownloadParamAidl(paramAnonymousParcel);
        AppMethodBeat.o(255407);
        return paramAnonymousParcel;
      }
      
      public final TPDownloadParamAidl[] newArray(int paramAnonymousInt)
      {
        return new TPDownloadParamAidl[paramAnonymousInt];
      }
    };
    AppMethodBeat.o(255434);
  }
  
  protected TPDownloadParamAidl(Parcel paramParcel)
  {
    AppMethodBeat.i(255423);
    try
    {
      this.urlList = paramParcel.createStringArrayList();
      this.dlType = paramParcel.readInt();
      this.extInfoMap = paramParcel.readHashMap(TPDownloadParamAidl.class.getClassLoader());
      AppMethodBeat.o(255423);
      return;
    }
    catch (Throwable paramParcel)
    {
      TPDLProxyLog.e("TPDownloadParamAidl", 0, "tpdlnative", paramParcel.toString());
      this.urlList = new ArrayList();
      this.dlType = 0;
      this.extInfoMap = new HashMap();
      AppMethodBeat.o(255423);
    }
  }
  
  public TPDownloadParamAidl(ArrayList<String> paramArrayList, int paramInt, Map<String, Object> paramMap)
  {
    this.urlList = paramArrayList;
    this.dlType = paramInt;
    this.extInfoMap = paramMap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getDlType()
  {
    return this.dlType;
  }
  
  public Map<String, Object> getExtInfoMap()
  {
    return this.extInfoMap;
  }
  
  public ArrayList<String> getUrlList()
  {
    return this.urlList;
  }
  
  public void setDlType(int paramInt)
  {
    this.dlType = paramInt;
  }
  
  public void setExtInfoMap(Map<String, Object> paramMap)
  {
    this.extInfoMap = paramMap;
  }
  
  public void setUrlList(ArrayList<String> paramArrayList)
  {
    this.urlList = paramArrayList;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(255425);
    paramParcel.writeStringList(this.urlList);
    paramParcel.writeInt(this.dlType);
    paramParcel.writeMap(this.extInfoMap);
    AppMethodBeat.o(255425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadParamAidl
 * JD-Core Version:    0.7.0.1
 */