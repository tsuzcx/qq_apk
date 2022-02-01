package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Pair;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class ImageWordScanEngineImpl
  implements LifecycleObserver, a<String, Integer>
{
  private MMActivity activity;
  private MutableLiveData<Pair<String, Integer>> yBl;
  
  public ImageWordScanEngineImpl(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(91128);
    this.yBl = new MutableLiveData();
    paramMMActivity.getLifecycle().addObserver(this);
    this.activity = paramMMActivity;
    AppMethodBeat.o(91128);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onDestroy()
  {
    AppMethodBeat.i(91129);
    this.activity.getLifecycle().removeObserver(this);
    h.LTJ.aZz("MicroMsg.ImageWordScanEngineImpl");
    this.activity = null;
    AppMethodBeat.o(91129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanEngineImpl
 * JD-Core Version:    0.7.0.1
 */