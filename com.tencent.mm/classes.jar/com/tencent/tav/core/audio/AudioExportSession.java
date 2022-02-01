package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;

public class AudioExportSession
{
  public static int SEGMENT_DURATION_US = 5000000;
  
  public static IAudioExportTask generateAudioAssetExportTask(Asset paramAsset, String paramString)
  {
    AppMethodBeat.i(189443);
    paramAsset = new AudioExportTask(new AudioSourceComposition(paramAsset), paramString);
    AppMethodBeat.o(189443);
    return paramAsset;
  }
  
  public static IAudioExportTask generateAudioTrackExportTask(AssetTrack paramAssetTrack, String paramString)
  {
    AppMethodBeat.i(189444);
    paramAssetTrack = new AudioExportTask(new AudioSourceTrack(paramAssetTrack), paramString);
    AppMethodBeat.o(189444);
    return paramAssetTrack;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioExportSession
 * JD-Core Version:    0.7.0.1
 */