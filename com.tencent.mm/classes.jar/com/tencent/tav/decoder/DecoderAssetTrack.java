package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import com.tencent.tav.extractor.ExtractorUtils;

public class DecoderAssetTrack
{
  public String assetPath;
  public int frameRate;
  public int mediaType;
  public int preferRotation;
  public Matrix preferredTransform;
  public float preferredVolume;
  public CGSize size;
  public int sourceType;
  public int trackId;
  
  public static DecoderAssetTrack create(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(214813);
    if ((paramAssetTrackSegment instanceof CompositionTrackSegment))
    {
      paramAssetTrack = createFromCompositionTrackSegment(paramAssetTrack, (CompositionTrackSegment)paramAssetTrackSegment);
      AppMethodBeat.o(214813);
      return paramAssetTrack;
    }
    paramAssetTrack = createFromTrackSegment(paramAssetTrack, paramAssetTrackSegment);
    AppMethodBeat.o(214813);
    return paramAssetTrack;
  }
  
  private static DecoderAssetTrack createFromCompositionTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(214811);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramCompositionTrackSegment.getSourcePath();
      localDecoderAssetTrack.trackId = paramCompositionTrackSegment.getSourceTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      if (!TextUtils.isEmpty(paramCompositionTrackSegment.getSourcePath()))
      {
        AssetExtractor localAssetExtractor = new AssetExtractor();
        localAssetExtractor.setDataSource(paramCompositionTrackSegment.getSourcePath());
        localDecoderAssetTrack.size = ExtractorUtils.getVideoSize(localAssetExtractor);
        localDecoderAssetTrack.preferRotation = localAssetExtractor.getPreferRotation();
        localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
        localDecoderAssetTrack.sourceType = paramCompositionTrackSegment.getSourceType();
      }
      localDecoderAssetTrack.preferredVolume = 1.0F;
      localDecoderAssetTrack.frameRate = 30;
    }
    AppMethodBeat.o(214811);
    return localDecoderAssetTrack;
  }
  
  private static DecoderAssetTrack createFromTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(214812);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramAssetTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramAssetTrack.getSourcePath();
      localDecoderAssetTrack.trackId = paramAssetTrack.getTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      if ((paramAssetTrackSegment instanceof CompositionTrackSegment)) {
        localDecoderAssetTrack.sourceType = ((CompositionTrackSegment)paramAssetTrackSegment).getSourceType();
      }
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
      localDecoderAssetTrack.preferRotation = paramAssetTrack.getPreferredRotation();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
    }
    AppMethodBeat.o(214812);
    return localDecoderAssetTrack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderAssetTrack
 * JD-Core Version:    0.7.0.1
 */