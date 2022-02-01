package com.tencent.mm.plugin.multitask.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/utils/MinusScreenUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEWPAGER_SCROLL_MARGING", "", "getVIEWPAGER_SCROLL_MARGING", "()I", "doLoadFromImage", "Landroid/graphics/Bitmap;", "srcPath", "contentView", "Landroid/widget/ImageView;", "supportMultiTaskType", "", "multiTaskType", "plugin-multitask_release"})
public final class a
{
  private static final int FNy;
  public static final a FNz;
  private static final String TAG = "MicroMsg.MinusScreenUtil";
  
  static
  {
    AppMethodBeat.i(249061);
    FNz = new a();
    TAG = "MicroMsg.MinusScreenUtil";
    FNy = aw.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(249061);
  }
  
  public static boolean Of(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 22) || (paramInt == 4) || (paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8);
  }
  
  public static Bitmap aRg(String paramString)
  {
    AppMethodBeat.i(249055);
    try
    {
      Bitmap localBitmap = MMBitmapFactory.decodeFile(paramString);
      paramString = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Log.e(TAG, "doCompressImage, decode bmp oom");
        try
        {
          paramString = BitmapUtil.decodeFile(paramString, null);
        }
        catch (OutOfMemoryError paramString)
        {
          Log.e(TAG, "doCompressImage, decode bmp oom retry, oom again");
          paramString = null;
        }
        catch (Exception paramString)
        {
          Log.e(TAG, "doCompressImage, decode bmp oom retry, e $e");
          paramString = null;
        }
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        try
        {
          paramString = BitmapUtil.decodeFile(paramString, null);
        }
        catch (Exception paramString)
        {
          Log.e(TAG, "doCompressImage, decode bmp npe retry, e $e");
          paramString = null;
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(TAG, "doCompressImage, decode bmp e $e");
        paramString = null;
      }
      AppMethodBeat.o(249055);
    }
    if (paramString == null)
    {
      Log.e(TAG, "doCompressImage, decode bmp return null");
      AppMethodBeat.o(249055);
      return null;
    }
    return paramString;
  }
  
  public static int fcM()
  {
    return FNy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.a
 * JD-Core Version:    0.7.0.1
 */