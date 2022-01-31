package com.tencent.mm.plugin.subapp.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements f
{
  private static int ckO = 0;
  Queue<String> ckH;
  Queue<String> ckI;
  Map<String, g.a> ckJ;
  private boolean ckK;
  private boolean ckL;
  int ckM;
  private long ckN;
  g.a ckQ;
  private ap ckR;
  private boolean running;
  
  public j()
  {
    AppMethodBeat.i(25310);
    this.ckH = new LinkedList();
    this.ckI = new LinkedList();
    this.ckJ = new HashMap();
    this.ckK = false;
    this.ckL = false;
    this.running = false;
    this.ckM = 0;
    this.ckN = 0L;
    this.ckQ = new g.a();
    this.ckR = new ap(aw.RO().oNc.getLooper(), new j.3(this), false);
    aw.Rc().a(329, this);
    AppMethodBeat.o(25310);
  }
  
  private void ET()
  {
    AppMethodBeat.i(25312);
    this.ckJ.clear();
    this.ckH.clear();
    this.ckI.clear();
    this.ckL = false;
    this.ckK = false;
    this.running = false;
    ab.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.ckQ.Mm());
    AppMethodBeat.o(25312);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(25311);
    aw.RO().ac(new j.1(this, paramm, paramInt1, paramInt2));
    AppMethodBeat.o(25311);
  }
  
  public final void run()
  {
    AppMethodBeat.i(25313);
    aw.RO().ac(new j.2(this));
    AppMethodBeat.o(25313);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j
 * JD-Core Version:    0.7.0.1
 */