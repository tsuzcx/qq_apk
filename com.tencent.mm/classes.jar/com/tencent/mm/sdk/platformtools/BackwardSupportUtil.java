package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.vfs.e;
import java.io.InputStream;

public final class BackwardSupportUtil
{
  public static BackwardSupportUtil.ExifHelper.LatLongData aoQ(String paramString)
  {
    AppMethodBeat.i(93295);
    Object localObject = new MediaMetadataRetriever();
    try
    {
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(23);
      ((MediaMetadataRetriever)localObject).release();
      ab.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong locationString ".concat(String.valueOf(paramString)));
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
      ab.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(93295);
      return null;
    }
    int j = paramString.lastIndexOf('+');
    int i = j;
    if (-1 == j) {
      i = paramString.lastIndexOf('-');
    }
    localObject = new BackwardSupportUtil.ExifHelper.LatLongData();
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).cyV = bo.apY(paramString.substring(0, i));
    ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).fFN = bo.apY(paramString.substring(i));
    AppMethodBeat.o(93295);
    return localObject;
    label227:
    AppMethodBeat.o(93295);
    return null;
  }
  
  public static String aoR(String paramString)
  {
    AppMethodBeat.i(93296);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = localMediaMetadataRetriever.extractMetadata(5);
      localMediaMetadataRetriever.release();
      ab.i("MicroMsg.SDK.BackwardSupportUtil", "getVideoTakeTime timeString ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(93296);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.SDK.BackwardSupportUtil", "getVideoLatLong setDataSource failure: " + paramString.getMessage());
      AppMethodBeat.o(93296);
    }
    return null;
  }
  
  public static final class ExifHelper
  {
    public static LatLongData aoS(String paramString)
    {
      AppMethodBeat.i(93291);
      if (bo.isNullOrNil(paramString))
      {
        ab.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(93291);
        return null;
      }
      if (!e.cN(paramString))
      {
        ab.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(93291);
        return null;
      }
      paramString = Exif.fromFile(paramString).getLocation();
      if (paramString != null)
      {
        LatLongData localLatLongData = new LatLongData();
        localLatLongData.cyV = ((float)paramString.latitude);
        localLatLongData.fFN = ((float)paramString.longitude);
        AppMethodBeat.o(93291);
        return localLatLongData;
      }
      AppMethodBeat.o(93291);
      return null;
    }
    
    public static int bY(String paramString)
    {
      AppMethodBeat.i(93290);
      if (bo.isNullOrNil(paramString))
      {
        ab.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        AppMethodBeat.o(93290);
        return 0;
      }
      if (!e.cN(paramString))
      {
        ab.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        AppMethodBeat.o(93290);
        return 0;
      }
      int i = Exif.fromFile(paramString).getOrientationInDegree();
      AppMethodBeat.o(93290);
      return i;
    }
    
    public static class LatLongData
      implements Parcelable
    {
      public static final Parcelable.Creator<LatLongData> CREATOR;
      public float cyV;
      public float fFN;
      
      static
      {
        AppMethodBeat.i(93289);
        CREATOR = new Parcelable.Creator() {};
        AppMethodBeat.o(93289);
      }
      
      public LatLongData()
      {
        this.cyV = 0.0F;
        this.fFN = 0.0F;
      }
      
      public LatLongData(float paramFloat1, float paramFloat2)
      {
        this.cyV = paramFloat1;
        this.fFN = paramFloat2;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        AppMethodBeat.i(93287);
        if (!(paramObject instanceof LatLongData))
        {
          AppMethodBeat.o(93287);
          return false;
        }
        paramObject = (LatLongData)paramObject;
        if ((Math.abs(this.cyV - paramObject.cyV) < 1.0E-006F) && (Math.abs(this.fFN - paramObject.fFN) < 1.0E-006F))
        {
          AppMethodBeat.o(93287);
          return true;
        }
        AppMethodBeat.o(93287);
        return false;
      }
      
      public int hashCode()
      {
        return (int)(this.cyV * 10000.0F) + (int)(this.fFN * 10000.0F);
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        AppMethodBeat.i(93288);
        paramParcel.writeFloat(this.cyV);
        paramParcel.writeFloat(this.fFN);
        AppMethodBeat.o(93288);
      }
    }
  }
  
  public static final class a
  {
    public static void a(View paramView, Animation paramAnimation)
    {
      AppMethodBeat.i(93280);
      if (Build.VERSION.SDK_INT >= 8)
      {
        new b();
        paramAnimation.cancel();
        AppMethodBeat.o(93280);
        return;
      }
      new a();
      a.eG(paramView);
      AppMethodBeat.o(93280);
    }
  }
  
  public static final class b
  {
    public static Bitmap a(InputStream paramInputStream, float paramFloat)
    {
      AppMethodBeat.i(93283);
      paramInputStream = b(paramInputStream, paramFloat);
      AppMethodBeat.o(93283);
      return paramInputStream;
    }
    
    public static int b(Context paramContext, float paramFloat)
    {
      AppMethodBeat.i(93282);
      int i = Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
      AppMethodBeat.o(93282);
      return i;
    }
    
    public static Bitmap b(InputStream paramInputStream, float paramFloat)
    {
      AppMethodBeat.i(93284);
      paramInputStream = d.a(paramInputStream, paramFloat, 0, 0);
      if (paramInputStream != null) {
        paramInputStream.setDensity((int)(160.0F * paramFloat));
      }
      AppMethodBeat.o(93284);
      return paramInputStream;
    }
    
    public static String gB(Context paramContext)
    {
      AppMethodBeat.i(93285);
      Object localObject = paramContext.getResources().getDisplayMetrics();
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject).density < 1.0F)
      {
        paramContext = "" + "LDPI";
        localObject = new StringBuilder().append(paramContext);
        if (localConfiguration.orientation != 2) {
          break label148;
        }
      }
      label148:
      for (paramContext = "_L";; paramContext = "_P")
      {
        paramContext = paramContext;
        AppMethodBeat.o(93285);
        return paramContext;
        if (((DisplayMetrics)localObject).density >= 1.5F)
        {
          paramContext = "" + "HDPI";
          break;
        }
        paramContext = "" + "MDPI";
        break;
      }
    }
    
    public static Bitmap k(String paramString, float paramFloat)
    {
      AppMethodBeat.i(93281);
      paramString = d.l(paramString, paramFloat);
      if (paramString != null) {
        paramString.setDensity((int)(160.0F * paramFloat));
      }
      AppMethodBeat.o(93281);
      return paramString;
    }
  }
  
  public static final class c
  {
    public static void a(ListView paramListView)
    {
      AppMethodBeat.i(93292);
      if (paramListView == null)
      {
        AppMethodBeat.o(93292);
        return;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        new bi();
        bi.c(paramListView);
        AppMethodBeat.o(93292);
        return;
      }
      new bh();
      paramListView.setSelection(0);
      AppMethodBeat.o(93292);
    }
    
    public static void b(ListView paramListView, int paramInt)
    {
      AppMethodBeat.i(93293);
      if (paramListView == null)
      {
        AppMethodBeat.o(93293);
        return;
      }
      if (Build.VERSION.SDK_INT >= 8)
      {
        new bi();
        bi.d(paramListView, paramInt);
        AppMethodBeat.o(93293);
        return;
      }
      new bh();
      paramListView.setSelection(paramInt);
      AppMethodBeat.o(93293);
    }
    
    public static void c(ListView paramListView, int paramInt)
    {
      AppMethodBeat.i(93294);
      if (paramListView == null)
      {
        AppMethodBeat.o(93294);
        return;
      }
      if (Build.VERSION.SDK_INT >= 11)
      {
        new bi();
        int i = paramListView.getFirstVisiblePosition();
        if ((i < paramInt) && (i + 10 < paramInt)) {
          paramListView.setSelectionFromTop(paramInt - 10, 0);
        }
        for (;;)
        {
          if (Build.VERSION.SDK_INT >= 11) {
            paramListView.smoothScrollToPositionFromTop(paramInt, 0);
          }
          AppMethodBeat.o(93294);
          return;
          if ((i > paramInt) && (i - 10 > paramInt)) {
            paramListView.setSelectionFromTop(paramInt + 10, 0);
          }
        }
      }
      new bh();
      paramListView.setSelectionFromTop(paramInt, 0);
      AppMethodBeat.o(93294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */