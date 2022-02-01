package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import java.util.concurrent.ConcurrentHashMap;

public class ImageWordScanDetailEngine
  implements LifecycleObserver, a<String, b>
{
  private MutableLiveData<Pair<String, b>> CVx;
  private ConcurrentHashMap<String, WordDetectNative.WordDetectDetailResult> CVy;
  private MMActivity activity;
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(194816);
    this.CVx = new MutableLiveData();
    this.CVy = new ConcurrentHashMap();
    paramMMActivity.getLifecycle().addObserver(this);
    this.activity = paramMMActivity;
    AppMethodBeat.o(194816);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  private void onActivityDestroy()
  {
    AppMethodBeat.i(194817);
    this.CVy.clear();
    this.activity.getLifecycle().removeObserver(this);
    h.RTc.bqo("MicroMsg.ImageWordScanEngineImpl");
    this.activity = null;
    AppMethodBeat.o(194817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine
 * JD-Core Version:    0.7.0.1
 */