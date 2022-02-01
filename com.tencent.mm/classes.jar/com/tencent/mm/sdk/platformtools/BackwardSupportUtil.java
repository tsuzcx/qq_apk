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
import com.tencent.mm.vfs.i;

public final class BackwardSupportUtil
{
  public static BackwardSupportUtil.ExifHelper.LatLongData aKs(String paramString)
  {
    AppMethodBeat.i(156076);
    Object localObject = new d();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(23);
      ((MediaMetadataRetriever)localObject).release();
      ac.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
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
      ac.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156076);
      return null;
    }
    int j = paramString.lastIndexOf('+');
    int i = j;
    if (-1 == j) {
      i = paramString.lastIndexOf('-');
    }
    localObject = new BackwardSupportUtil.ExifHelper.LatLongData();
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).dmL = bs.aLB(paramString.substring(0, i));
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).hIO = bs.aLB(paramString.substring(i));
    AppMethodBeat.o(156076);
    return localObject;
    label227:
    AppMethodBeat.o(156076);
    return null;
  }
  
  public static String aKt(String paramString)
  {
    AppMethodBeat.i(156077);
    d locald = new d();
    try
    {
      locald.setDataSource(paramString);
      paramString = locald.extractMetadata(5);
      locald.release();
      ac.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156077);
      return paramString;
    }
    catch (Exception paramString)
    {
      ac.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156077);
    }
    return null;
  }
  
  public static final class ExifHelper
  {
    public static LatLongData aKu(String paramString)
    {
      AppMethodBeat.i(156072);
      if (bs.isNullOrNil(paramString))
      {
        ac.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156072);
        return null;
      }
      if (!i.eA(paramString))
      {
        ac.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156072);
        return null;
      }
      paramString = Exif.fromFile(paramString).getLocation();
      if (paramString != null)
      {
        LatLongData localLatLongData = new LatLongData();
        localLatLongData.dmL = ((float)paramString.latitude);
        localLatLongData.hIO = ((float)paramString.longitude);
        AppMethodBeat.o(156072);
        return localLatLongData;
      }
      AppMethodBeat.o(156072);
      return null;
    }
    
    public static int ce(String paramString)
    {
      AppMethodBeat.i(156071);
      if (bs.isNullOrNil(paramString))
      {
        ac.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156071);
        return 0;
      }
      if (!i.eA(paramString))
      {
        ac.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
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
      public float dmL;
      public float hIO;
      
      static
      {
        AppMethodBeat.i(156070);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(156070);
      }
      
      public LatLongData()
      {
        this.dmL = 0.0F;
        this.hIO = 0.0F;
      }
      
      public LatLongData(float paramFloat1, float paramFloat2)
      {
        this.dmL = paramFloat1;
        this.hIO = paramFloat2;
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
        if ((Math.abs(this.dmL - paramObject.dmL) < 1.0E-006F) && (Math.abs(this.hIO - paramObject.hIO) < 1.0E-006F))
        {
          AppMethodBeat.o(156068);
          return true;
        }
        AppMethodBeat.o(156068);
        return false;
      }
      
      public int hashCode()
      {
        return (int)(this.dmL * 10000.0F) + (int)(this.hIO * 10000.0F);
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(156069);
        paramParcel.writeFloat(this.dmL);
        paramParcel.writeFloat(this.hIO);
        AppMethodBeat.o(156069);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */