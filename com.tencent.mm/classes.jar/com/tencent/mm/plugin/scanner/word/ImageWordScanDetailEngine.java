package com.tencent.mm.plugin.scanner.word;

import android.util.Pair;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.worddetect.WordDetectNative.WordDetectDetailResult;
import com.tencent.worddetect.b.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ImageWordScanDetailEngine
  implements p, a<String, b>
{
  private ConcurrentHashMap<String, WordDetectNative.WordDetectDetailResult> PkZ;
  private ConcurrentHashMap<String, ArrayList<a.a<String, b>>> Pla;
  private boolean Plb;
  private boolean aUP;
  private MMActivity activity;
  private x<Pair<String, b>> resultLiveData;
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity)
  {
    this(paramMMActivity, (byte)0);
    this.Plb = false;
  }
  
  public ImageWordScanDetailEngine(MMActivity paramMMActivity, byte paramByte)
  {
    AppMethodBeat.i(313440);
    this.resultLiveData = new x();
    this.PkZ = new ConcurrentHashMap();
    this.Pla = new ConcurrentHashMap();
    this.aUP = false;
    this.Plb = true;
    paramMMActivity.getLifecycle().addObserver(this);
    this.activity = paramMMActivity;
    this.aUP = false;
    AppMethodBeat.o(313440);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  private void onActivityDestroy()
  {
    AppMethodBeat.i(313444);
    this.aUP = true;
    this.PkZ.clear();
    this.activity.getLifecycle().removeObserver(this);
    h.ahAA.bFQ("WordDetectThread");
    this.activity = null;
    this.Pla.clear();
    if (this.Plb) {
      com.tencent.worddetect.b.release();
    }
    AppMethodBeat.o(313444);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine
 * JD-Core Version:    0.7.0.1
 */