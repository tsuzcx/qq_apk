package com.tencent.mm.plugin.subapp.c;

import android.os.HandlerThread;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j
  implements f
{
  private static int bEa = 0;
  Queue<String> bDS = new LinkedList();
  Queue<String> bDT = new LinkedList();
  Map<String, g.a> bDU = new HashMap();
  private boolean bDV = false;
  private boolean bDW = false;
  private boolean bDX = false;
  int bDY = 0;
  private long bDZ = 0L;
  g.a bEc = new g.a();
  private am bEd = new am(au.DS().mnU.getLooper(), new j.3(this), false);
  
  public j()
  {
    au.Dk().a(329, this);
  }
  
  private void uB()
  {
    this.bDU.clear();
    this.bDS.clear();
    this.bDT.clear();
    this.bDW = false;
    this.bDV = false;
    this.bDX = false;
    y.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.bEc.zJ());
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    au.DS().O(new j.1(this, paramm, paramInt1, paramInt2));
  }
  
  public final void run()
  {
    au.DS().O(new j.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.j
 * JD-Core Version:    0.7.0.1
 */