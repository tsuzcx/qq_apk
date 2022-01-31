package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.compatible.util.Exif.a;
import com.tencent.mm.vfs.e;
import java.io.InputStream;

public final class BackwardSupportUtil
{
  public static final class ExifHelper
  {
    public static int YS(String paramString)
    {
      if (bk.bl(paramString))
      {
        y.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
        return 0;
      }
      if (!e.bK(paramString))
      {
        y.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
        return 0;
      }
      return Exif.fromFile(paramString).getOrientationInDegree();
    }
    
    public static LatLongData YT(String paramString)
    {
      if (bk.bl(paramString)) {
        y.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
      }
      do
      {
        return null;
        if (!e.bK(paramString))
        {
          y.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", new Object[] { paramString });
          return null;
        }
        paramString = Exif.fromFile(paramString).getLocation();
      } while (paramString == null);
      LatLongData localLatLongData = new LatLongData();
      localLatLongData.bRt = ((float)paramString.latitude);
      localLatLongData.epo = ((float)paramString.longitude);
      return localLatLongData;
    }
    
    public static class LatLongData
      implements Parcelable
    {
      public static final Parcelable.Creator<LatLongData> CREATOR = new Parcelable.Creator() {};
      public float bRt;
      public float epo;
      
      public LatLongData()
      {
        this.bRt = 0.0F;
        this.epo = 0.0F;
      }
      
      public LatLongData(float paramFloat1, float paramFloat2)
      {
        this.bRt = paramFloat1;
        this.epo = paramFloat2;
      }
      
      public int describeContents()
      {
        return 0;
      }
      
      public boolean equals(Object paramObject)
      {
        if (!(paramObject instanceof LatLongData)) {}
        do
        {
          return false;
          paramObject = (LatLongData)paramObject;
        } while ((Math.abs(this.bRt - paramObject.bRt) >= 1.0E-006F) || (Math.abs(this.epo - paramObject.epo) >= 1.0E-006F));
        return true;
      }
      
      public int hashCode()
      {
        return (int)(this.bRt * 10000.0F) + (int)(this.epo * 10000.0F);
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        paramParcel.writeFloat(this.bRt);
        paramParcel.writeFloat(this.epo);
      }
    }
  }
  
  public static final class a
  {
    public static void a(View paramView, Animation paramAnimation)
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        new b();
        paramAnimation.cancel();
      }
      do
      {
        return;
        new a();
      } while (paramView == null);
      paramView.setAnimation(null);
    }
  }
  
  public static final class b
  {
    public static Bitmap a(InputStream paramInputStream, float paramFloat)
    {
      paramInputStream = c.a(paramInputStream, paramFloat, 0, 0);
      if (paramInputStream != null) {
        paramInputStream.setDensity((int)(160.0F * paramFloat));
      }
      return paramInputStream;
    }
    
    public static int b(Context paramContext, float paramFloat)
    {
      return Math.round(paramContext.getResources().getDisplayMetrics().densityDpi * paramFloat / 160.0F);
    }
    
    public static Bitmap e(String paramString, float paramFloat)
    {
      paramString = c.f(paramString, paramFloat);
      if (paramString != null) {
        paramString.setDensity((int)(160.0F * paramFloat));
      }
      return paramString;
    }
    
    public static String fo(Context paramContext)
    {
      Object localObject = paramContext.getResources().getDisplayMetrics();
      Configuration localConfiguration = paramContext.getResources().getConfiguration();
      if (((DisplayMetrics)localObject).density < 1.0F)
      {
        paramContext = "" + "LDPI";
        localObject = new StringBuilder().append(paramContext);
        if (localConfiguration.orientation != 2) {
          break label136;
        }
      }
      label136:
      for (paramContext = "_L";; paramContext = "_P")
      {
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
  }
  
  public static final class c
  {
    public static void a(ListView paramListView)
    {
      if (paramListView == null) {}
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 8) {
          break;
        }
        new be();
        if (paramListView.getFirstVisiblePosition() > 10) {
          paramListView.setSelection(10);
        }
      } while (Build.VERSION.SDK_INT < 8);
      paramListView.smoothScrollToPosition(0);
      return;
      new bd();
      paramListView.setSelection(0);
    }
    
    public static void b(ListView paramListView, int paramInt)
    {
      if (paramListView == null) {}
      for (;;)
      {
        return;
        if (Build.VERSION.SDK_INT < 8) {
          break;
        }
        new be();
        int i = paramListView.getFirstVisiblePosition();
        if ((i > paramInt) && (i - paramInt > 10)) {
          paramListView.setSelection(paramInt + 10);
        }
        while (Build.VERSION.SDK_INT >= 8)
        {
          paramListView.smoothScrollToPosition(paramInt);
          return;
          if ((i < paramInt) && (paramInt - i > 10)) {
            paramListView.setSelection(paramInt - 10);
          }
        }
      }
      new bd();
      paramListView.setSelection(paramInt);
    }
    
    public static void c(ListView paramListView, int paramInt)
    {
      if (paramListView == null) {}
      for (;;)
      {
        return;
        if (Build.VERSION.SDK_INT < 11) {
          break;
        }
        new be();
        int i = paramListView.getFirstVisiblePosition();
        if ((i < paramInt) && (i + 10 < paramInt)) {
          paramListView.setSelectionFromTop(paramInt - 10, 0);
        }
        while (Build.VERSION.SDK_INT >= 11)
        {
          paramListView.smoothScrollToPositionFromTop(paramInt, 0);
          return;
          if ((i > paramInt) && (i - 10 > paramInt)) {
            paramListView.setSelectionFromTop(paramInt + 10, 0);
          }
        }
      }
      new bd();
      paramListView.setSelectionFromTop(paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil
 * JD-Core Version:    0.7.0.1
 */