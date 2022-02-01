package com.tencent.mm.plugin.scanner.word;

import android.util.Pair;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import com.tencent.worddetect.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ImageWordScanDetailEngine
  implements k, a<String, b>
{
  private r<Pair<String, b>> Jbh;
  private ConcurrentHashMap<String, WordDetectNative.WordDetectDetailResult> Jbi;
  private ConcurrentHashMap<String, ArrayList<a.a<String, b>>> Jbj;
  private boolean Jbk;
  private boolean aJQ;
  private MMActivity activity;
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity)
  {
    this(paramMMActivity, (byte)0);
    this.Jbk = false;
  }
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity, byte paramByte)
  {
    AppMethodBeat.i(193652);
    this.Jbh = new r();
    this.Jbi = new ConcurrentHashMap();
    this.Jbj = new ConcurrentHashMap();
    this.aJQ = false;
    this.Jbk = true;
    paramMMActivity.getLifecycle().a(this);
    this.activity = paramMMActivity;
    this.aJQ = false;
    AppMethodBeat.o(193652);
  }
  
  @t(jl=h.a.ON_DESTROY)
  private void onActivityDestroy()
  {
    AppMethodBeat.i(193654);
    this.aJQ = true;
    this.Jbi.clear();
    this.activity.getLifecycle().b(this);
    com.tencent.e.h.ZvG.bDh("WordDetectThread");
    this.activity = null;
    this.Jbj.clear();
    if (this.Jbk) {
      com.tencent.worddetect.b.release();
    }
    AppMethodBeat.o(193654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine
 * JD-Core Version:    0.7.0.1
 */