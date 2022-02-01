package com.tencent.mm.plugin.scanner.word;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;

public class ImageWordScanDetailEngine
  implements LifecycleObserver, a<String, b>
{
  private MMActivity activity;
  private MutableLiveData<Pair<String, b>> yRl;
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(196679);
    this.yRl = new MutableLiveData();
    paramMMActivity.getLifecycle().addObserver(this);
    this.activity = paramMMActivity;
    AppMethodBeat.o(196679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine
 * JD-Core Version:    0.7.0.1
 */