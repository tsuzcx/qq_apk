package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class ImageWordScanEngineImpl
  implements LifecycleObserver, a<String, Integer>
{
  private MMActivity hwZ;
  private MutableLiveData<Pair<String, Integer>> qDS;
  
  public ImageWordScanEngineImpl(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(138721);
    this.qDS = new MutableLiveData();
    paramMMActivity.getLifecycle().addObserver(this);
    this.hwZ = paramMMActivity;
    AppMethodBeat.o(138721);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    AppMethodBeat.i(138722);
    this.hwZ.getLifecycle().removeObserver(this);
    this.hwZ = null;
    AppMethodBeat.o(138722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl
 * JD-Core Version:    0.7.0.1
 */