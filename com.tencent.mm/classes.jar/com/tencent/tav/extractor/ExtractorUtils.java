package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderUtils;

public class ExtractorUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  
  public static void applyMirror(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(215058);
    if (paramMatrix == null)
    {
      AppMethodBeat.o(215058);
      return;
    }
    Matrix localMatrix = new Matrix();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramMatrix.postConcat(localMatrix);
      AppMethodBeat.o(215058);
      return;
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramInt2, 0.0F);
      continue;
      localMatrix.postScale(1.0F, -1.0F);
      localMatrix.postTranslate(0.0F, paramInt3);
      continue;
      localMatrix.postScale(-1.0F, -1.0F);
      localMatrix.postTranslate(paramInt2, paramInt3);
    }
  }
  
  public static int getFrameRate(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(215071);
    if (paramMediaFormat != null) {}
    try
    {
      if (paramMediaFormat.containsKey("frame-rate"))
      {
        int i = paramMediaFormat.getInteger("frame-rate");
        AppMethodBeat.o(215071);
        return i;
      }
    }
    catch (Exception paramMediaFormat)
    {
      AppMethodBeat.o(215071);
      return 0;
    }
    catch (Error paramMediaFormat)
    {
      label33:
      break label33;
    }
  }
  
  public static int getPreferRotation(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(215040);
    try
    {
      paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
      if ((paramAssetExtractor != null) && (paramAssetExtractor.containsKey("rotation-degrees")))
      {
        int i = paramAssetExtractor.getInteger("rotation-degrees") / 90;
        AppMethodBeat.o(215040);
        return i;
      }
    }
    catch (Exception paramAssetExtractor)
    {
      AppMethodBeat.o(215040);
      return 0;
    }
    catch (Error paramAssetExtractor)
    {
      label43:
      break label43;
    }
  }
  
  public static CGSize getVideoSize(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(215023);
    for (;;)
    {
      try
      {
        paramAssetExtractor = DecoderUtils.getFirstFormat(paramAssetExtractor, "video/");
        localCGSize = new CGSize();
        if (paramAssetExtractor != null)
        {
          if (!paramAssetExtractor.containsKey("display-width")) {
            continue;
          }
          localCGSize.width = paramAssetExtractor.getInteger("display-width");
          if (!paramAssetExtractor.containsKey("display-height")) {
            continue;
          }
          localCGSize.height = paramAssetExtractor.getInteger("display-height");
        }
      }
      catch (Exception paramAssetExtractor)
      {
        CGSize localCGSize;
        paramAssetExtractor = new CGSize();
        AppMethodBeat.o(215023);
        return paramAssetExtractor;
        localCGSize.height = paramAssetExtractor.getInteger("height");
        continue;
      }
      catch (Error paramAssetExtractor)
      {
        continue;
      }
      AppMethodBeat.o(215023);
      return localCGSize;
      localCGSize.width = paramAssetExtractor.getInteger("width");
    }
  }
  
  public static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    AppMethodBeat.i(215088);
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null)) {}
    for (int i = 1; (i != 0) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)); i = 0)
    {
      AppMethodBeat.o(215088);
      return true;
    }
    AppMethodBeat.o(215088);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorUtils
 * JD-Core Version:    0.7.0.1
 */