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

public class ImageWordScanEngineImpl
  implements LifecycleObserver, a<String, Integer>
{
  private MutableLiveData<Pair<String, Integer>> CVx;
  private MMActivity activity;
  
  public ImageWordScanEngineImpl(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(91128);
    this.CVx = new MutableLiveData();
    paramMMActivity.getLifecycle().addObserver(this);
    this.activity = paramMMActivity;
    AppMethodBeat.o(91128);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    AppMethodBeat.i(91129);
    this.activity.getLifecycle().removeObserver(this);
    h.RTc.bqo("MicroMsg.ImageWordScanEngineImpl");
    this.activity = null;
    AppMethodBeat.o(91129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl
 * JD-Core Version:    0.7.0.1
 */