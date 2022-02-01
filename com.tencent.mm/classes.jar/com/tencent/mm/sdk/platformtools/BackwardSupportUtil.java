package com.tencent.mm.sdk.platformtools;

import android.media.MediaMetadataRetriever;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.vfs.o;

public final class BackwardSupportUtil
{
  public static BackwardSupportUtil.ExifHelper.LatLongData aRv(String paramString)
  {
    AppMethodBeat.i(156076);
    Object localObject = new d();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(23);
      ((MediaMetadataRetriever)localObject).release();
      ae.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
      if (TextUtils.isEmpty(paramString)) {
        break label227;
      }
      paramString = paramString.toCharArray();
      localObject = new StringBuilder();
      j = paramString.length;
      i = 0;
      while (i < j)
      {
        char c = paramString[i];
        if ((c == '+') || (c == '-') || (c == '.') || (TextUtils.isDigitsOnly(String.valueOf(c)))) {
          ((StringBuilder)localObject).append(c);
        }
        i += 1;
      }
      paramString = ((StringBuilder)localObject).toString();
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156076);
      return null;
    }
    int j = paramString.lastIndexOf('+');
    int i = j;
    if (-1 == j) {
      i = paramString.lastIndexOf('-');
    }
    localObject = new BackwardSupportUtil.ExifHelper.LatLongData();
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dzE = bu.aSE(paramString.substring(0, i));
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).iev = bu.aSE(paramString.substring(i));
    AppMethodBeat.o(156076);
    return localObject;
    label227:
    AppMethodBeat.o(156076);
    return null;
  }
  
  public static String aRw(String paramString)
  {
    AppMethodBeat.i(156077);
    d locald = new d();
    try
    {
      locald.setDataSource(paramString);
      paramString = locald.extractMetadata(5);
      locald.release();
      ae.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156077);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156077);
    }
    return null;
  }
  
  public static final class ExifHelper
  {
    public static LatLongData aRx(String paramString)
    {
      AppMethodBeat.i(156072);
      if (bu.isNullOrNil(paramString))
      {
        ae.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156072);
        return null;
      }
      if (!o.fB(paramString))
      {
        ae.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156072);
        return null;
      }
      paramString = Exif.fromFile(paramString).getLocation();
      if (paramString != null)
      {
        LatLongData localLatLongData = new LatLongData();
        localLatLongData.dzE = ((float)paramString.latitude);
        localLatLongData.iev = ((float)paramString.longitude);
        AppMethodBeat.o(156072);
        return localLatLongData;
      }
      AppMethodBeat.o(156072);
      return null;
    }
    
    public static int df(String paramString)
    {
      AppMethodBeat.i(156071);
      if (bu.isNullOrNil(paramString))
      {
        ae.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156071);
        return 0;
      }
      if (!o.fB(paramString))
      {
        ae.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156071);
        return 0;
      }
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      AppMethodBeat.o(156071);
      return i;
    }
    
    public static class LatLongData
      implements Parcelable
    {
      public static final Parcelable.Creator<LatLongData> CREATOR;
      public float dzE;
      public float iev;
      
      static
      {
        AppMethodBeat.i(156070);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(156070);
      }
      
      public LatLongData()
      {
        this.dzE = 0.0F;
        this.iev = 0.0F;
      }
      
      public LatLongData(float paramFloat1, float paramFloat2)
      {
        this.dzE = paramFloat1;
        this.iev = paramFloat2;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(156068);
        if (!(paramObject instanceof LatLongData))
        {
          AppMethodBeat.o(156068);
          return false;
        }
        paramObject = (LatLongData)paramObject;
        if ((Math.abs(this.dzE - paramObject.dzE) < 1.0E-006F) && (Math.abs(this.iev - paramObject.iev) < 1.0E-006F))
        {
          AppMethodBeat.o(156068);
          return true;
        }
        AppMethodBeat.o(156068);
        return false;
      }
      
      public int hashCode()
      {
        return (int)(this.dzE * 10000.0F) + (int)(this.iev * 10000.0F);
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(156069);
        paramParcel.writeFloat(this.dzE);
        paramParcel.writeFloat(this.iev);
        AppMethodBeat.o(156069);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */