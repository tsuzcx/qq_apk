package com.tencent.tav.core.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.asset.AssetTrackSegment;
import com.tencent.tav.asset.CompositionTrackSegment;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeMapping;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.AudioDecoderTrack;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.DecoderTrackSegment;
import com.tencent.tav.decoder.IDecoder.DecodeType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AudioSourceTrack
  implements IAudioSource<AudioDecoderTrack>
{
  public static final String TAG = "AudioCompositionTrackEncoder2";
  private AssetTrack mAssetTrack;
  private AudioInfo mAudioInfo;
  
  public AudioSourceTrack(AssetTrack paramAssetTrack)
  {
    AppMethodBeat.i(189540);
    this.mAudioInfo = new AudioInfo(44100, 1, 2);
    this.mAssetTrack = paramAssetTrack;
    AppMethodBeat.o(189540);
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, AssetTrackSegment paramAssetTrackSegment)
  {
    AppMethodBeat.i(189547);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramAssetTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.assetPath = paramAssetTrack.getSourcePath();
      localDecoderAssetTrack.trackId = paramAssetTrack.getTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
    }
    paramAssetTrack = paramAssetTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramAssetTrackSegment.getScaleDuration());
    AppMethodBeat.o(189547);
    return paramAssetTrack;
  }
  
  private DecoderTrackSegment createDecoderTrackSegment(AssetTrack paramAssetTrack, CompositionTrackSegment paramCompositionTrackSegment)
  {
    AppMethodBeat.i(189550);
    DecoderAssetTrack localDecoderAssetTrack = null;
    if (!paramCompositionTrackSegment.isEmpty())
    {
      localDecoderAssetTrack = new DecoderAssetTrack();
      localDecoderAssetTrack.trackId = paramCompositionTrackSegment.getSourceTrackID();
      localDecoderAssetTrack.mediaType = paramAssetTrack.getMediaType();
      localDecoderAssetTrack.assetPath = paramCompositionTrackSegment.getSourcePath();
      localDecoderAssetTrack.preferredTransform = paramAssetTrack.getPreferredTransform();
      localDecoderAssetTrack.size = paramAssetTrack.getNaturalSize();
      localDecoderAssetTrack.frameRate = ((int)paramAssetTrack.getNominalFrameRate());
      localDecoderAssetTrack.preferredVolume = paramAssetTrack.getPreferredVolume();
    }
    paramAssetTrack = paramCompositionTrackSegment.getTimeMapping().getSource();
    paramAssetTrack = new DecoderTrackSegment(new CMTimeRange(paramAssetTrack.getStart(), paramAssetTrack.getDuration()), localDecoderAssetTrack);
    paramAssetTrack.setScaledDuration(paramCompositionTrackSegment.getScaleDuration());
    AppMethodBeat.o(189550);
    return paramAssetTrack;
  }
  
  public CMTime getDuration()
  {
    AppMethodBeat.i(189559);
    CMTime localCMTime = this.mAssetTrack.getDuration();
    AppMethodBeat.o(189559);
    return localCMTime;
  }
  
  public AudioDecoderTrack getSourceAudioDecoder(CMTimeRange paramCMTimeRange)
  {
    AppMethodBeat.i(189557);
    AudioDecoderTrack localAudioDecoderTrack1 = new AudioDecoderTrack();
    if (this.mAssetTrack.getMediaType() == 2)
    {
      AudioDecoderTrack localAudioDecoderTrack2 = new AudioDecoderTrack();
      Object localObject = this.mAssetTrack.getSegments();
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrackSegment localAssetTrackSegment = (AssetTrackSegment)((Iterator)localObject).next();
        if ((localAssetTrackSegment instanceof CompositionTrackSegment)) {
          localArrayList.add(createDecoderTrackSegment(this.mAssetTrack, (CompositionTrackSegment)localAssetTrackSegment));
        } else {
          localArrayList.add(createDecoderTrackSegment(this.mAssetTrack, localAssetTrackSegment));
        }
      }
      localAudioDecoderTrack2.setTrackID(this.mAssetTrack.getTrackID());
      localAudioDecoderTrack2.setTrackSegments(localArrayList);
      localAudioDecoderTrack2.setFrameRate((int)this.mAssetTrack.getNominalFrameRate());
      localAudioDecoderTrack2.setVolume(this.mAssetTrack.getPreferredVolume());
      localAudioDecoderTrack2.setDecodeType(IDecoder.DecodeType.Audio);
      localAudioDecoderTrack2.setAudioInfo(this.mAudioInfo);
      localAudioDecoderTrack2.clipRangeAndClearRange(new CMTimeRange(CMTime.CMTimeZero, paramCMTimeRange.getEnd()));
      AppMethodBeat.o(189557);
      return localAudioDecoderTrack1;
    }
    AppMethodBeat.o(189557);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.audio.AudioSourceTrack
 * JD-Core Version:    0.7.0.1
 */