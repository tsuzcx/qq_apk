package com.tencent.mm.sdk.platformtools;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.vfs.s;

public class BackwardSupportUtil
{
  public static final int ANDROID_API_LEVEL_16 = 16;
  private static final int ANDROID_API_LEVEL_8 = 8;
  private static final String TAG = "MicroMsg.SDK.BackwardSupportUtil";
  
  public static BackwardSupportUtil.ExifHelper.LatLongData getVideoLatLong(String paramString)
  {
    AppMethodBeat.i(156076);
    Object localObject = new d();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(23);
      ((MediaMetadataRetriever)localObject).release();
      Log.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
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
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156076);
      return null;
    }
    int j = paramString.lastIndexOf('+');
    int i = j;
    if (-1 == j) {
      i = paramString.lastIndexOf('-');
    }
    localObject = new BackwardSupportUtil.ExifHelper.LatLongData();
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).latitude = Util.safeParseFloat(paramString.substring(0, i));
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).longtitude = Util.safeParseFloat(paramString.substring(i));
    AppMethodBeat.o(156076);
    return localObject;
    label227:
    AppMethodBeat.o(156076);
    return null;
  }
  
  public static String getVideoTakeTime(String paramString)
  {
    AppMethodBeat.i(156077);
    d locald = new d();
    try
    {
      locald.setDataSource(paramString);
      paramString = locald.extractMetadata(5);
      locald.release();
      Log.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(156077);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(156077);
    }
    return null;
  }
  
  public static class ExifHelper
  {
    public static BackwardSupportUtil.ExifHelper.LatLongData getExifLatLong(String paramString)
    {
      AppMethodBeat.i(156072);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156072);
        return null;
      }
      if (!s.YS(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156072);
        return null;
      }
      paramString = Exif.fromFile(paramString).getLocation();
      if (paramString != null)
      {
        BackwardSupportUtil.ExifHelper.LatLongData localLatLongData = new BackwardSupportUtil.ExifHelper.LatLongData();
        localLatLongData.latitude = ((float)paramString.latitude);
        localLatLongData.longtitude = ((float)paramString.longitude);
        AppMethodBeat.o(156072);
        return localLatLongData;
      }
      AppMethodBeat.o(156072);
      return null;
    }
    
    public static int getExifOrientation(String paramString)
    {
      AppMethodBeat.i(156071);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(156071);
        return 0;
      }
      if (!s.YS(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(156071);
        return 0;
      }
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      AppMethodBeat.o(156071);
      return i;
    }
    
    public static String getExifTime(String paramString)
    {
      AppMethodBeat.i(215292);
      if (Util.isNullOrNil(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(215292);
        return null;
      }
      if (!s.YS(paramString))
      {
        Log.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(215292);
        return null;
      }
      paramString = Exif.fromFile(paramString).dateTime;
      AppMethodBeat.o(215292);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */