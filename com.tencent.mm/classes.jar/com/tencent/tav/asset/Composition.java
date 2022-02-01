package com.tencent.tav.asset;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.extractor.AssetExtractor;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Composition<CTrack extends CompositionTrack>
  extends Asset
{
  protected List<CTrack> tracks;
  
  protected Composition()
  {
    AppMethodBeat.i(197389);
    this.tracks = new ArrayList();
    AppMethodBeat.o(197389);
  }
  
  protected Composition(String paramString)
  {
    super(paramString);
    AppMethodBeat.i(197391);
    this.tracks = new ArrayList();
    AppMethodBeat.o(197391);
  }
  
  protected Composition(URL paramURL)
  {
    super(paramURL);
    AppMethodBeat.i(197390);
    this.tracks = new ArrayList();
    AppMethodBeat.o(197390);
  }
  
  @TargetApi(16)
  protected void createTracks()
  {
    AppMethodBeat.i(197394);
    int j = this.extractor.getTrackCount();
    if (this.tracks == null) {
      this.tracks = new ArrayList();
    }
    int i = 0;
    if (i < j)
    {
      Object localObject = this.extractor.getTrackFormat(i).getString("mime");
      int k;
      if (((String)localObject).startsWith("video/"))
      {
        k = this.trackIndex;
        this.trackIndex = (k + 1);
        localObject = new CompositionTrack(this, k, 1, new CMTimeRange(CMTime.CMTimeZero, getVideoDuration()));
        this.tracks.add(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if (((String)localObject).startsWith("audio/"))
        {
          k = this.trackIndex;
          this.trackIndex = (k + 1);
          localObject = new CompositionTrack(this, k, 2, new CMTimeRange(CMTime.CMTimeZero, getAudioDuration()));
          this.tracks.add(localObject);
        }
      }
    }
    Logger.e("Asset", " Composition createTracks finish, has track count: " + this.tracks);
    AppMethodBeat.o(197394);
  }
  
  protected CMTime getAudioDuration()
  {
    AppMethodBeat.i(197393);
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() != 2) {
        break label78;
      }
      CMTime localCMTime = ((CompositionTrack)localObject2).getDuration();
      localObject2 = localObject1;
      if (localCMTime.bigThan((CMTime)localObject1)) {
        localObject2 = localCMTime;
      }
      localObject1 = localObject2;
    }
    label78:
    for (;;)
    {
      break;
      AppMethodBeat.o(197393);
      return localObject1;
    }
  }
  
  public List<CTrack> getTracks()
  {
    AppMethodBeat.i(197395);
    new StringBuilder("getTracks finish, has track count: ").append(this.tracks);
    List localList = this.tracks;
    AppMethodBeat.o(197395);
    return localList;
  }
  
  protected CMTime getVideoDuration()
  {
    AppMethodBeat.i(197392);
    Object localObject1 = CMTime.CMTimeZero;
    Iterator localIterator = this.tracks.iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (CompositionTrack)localIterator.next();
      if (((CompositionTrack)localObject2).getMediaType() != 1) {
        break label78;
      }
      CMTime localCMTime = ((CompositionTrack)localObject2).getDuration();
      localObject2 = localObject1;
      if (localCMTime.bigThan((CMTime)localObject1)) {
        localObject2 = localCMTime;
      }
      localObject1 = localObject2;
    }
    label78:
    for (;;)
    {
      break;
      AppMethodBeat.o(197392);
      return localObject1;
    }
  }
  
  public void loadValuesAsynchronouslyForKeys(List<String> paramList, AsynchronousKeyValueLoading.loadCallback paramloadCallback) {}
  
  public int statusOfValueForKey(String paramString)
  {
    return 1;
  }
  
  public String toString()
  {
    AppMethodBeat.i(197396);
    String str = "Composition{tracks=" + this.tracks + ", trackCount=" + this.trackCount + '}';
    AppMethodBeat.o(197396);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.asset.Composition
 * JD-Core Version:    0.7.0.1
 */