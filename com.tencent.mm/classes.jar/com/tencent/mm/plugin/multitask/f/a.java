package com.tencent.mm.plugin.multitask.f;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/utils/MinusScreenUtil;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEWPAGER_SCROLL_MARGING", "", "getVIEWPAGER_SCROLL_MARGING", "()I", "doLoadFromImage", "Landroid/graphics/Bitmap;", "srcPath", "contentView", "Landroid/widget/ImageView;", "supportMultiTaskType", "", "multiTaskType", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a LIu;
  private static final int LIv;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(303722);
    LIu = new a();
    TAG = "MicroMsg.MinusScreenUtil";
    LIv = bd.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(303722);
  }
  
  public static boolean Qs(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 22) || (paramInt == 4) || (paramInt == 1) || (paramInt == 5) || (paramInt == 3) || (paramInt == 8);
  }
  
  public static Bitmap aNY(String paramString)
  {
    AppMethodBeat.i(303713);
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
      AppMethodBeat.o(303713);
    }
    if (paramString == null)
    {
      Log.e(TAG, "doCompressImage, decode bmp return null");
      AppMethodBeat.o(303713);
      return null;
    }
    return paramString;
  }
  
  public static int glP()
  {
    return LIv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.f.a
 * JD-Core Version:    0.7.0.1
 */