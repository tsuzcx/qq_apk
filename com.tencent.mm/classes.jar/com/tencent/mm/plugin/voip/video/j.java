package com.tencent.mm.plugin.voip.video;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;

public final class j
{
  public ArrayList<j.a> jOc;
  public int mRotateAngle;
  public boolean tHF;
  public int tHG;
  public int tHH;
  public v2protocal tyA;
  
  public j()
  {
    AppMethodBeat.i(5116);
    this.tHF = false;
    this.mRotateAngle = 0;
    this.jOc = new ArrayList();
    this.tyA = new v2protocal(new ak(Looper.myLooper()));
    AppMethodBeat.o(5116);
  }
  
  public final void a(j.a parama)
  {
    AppMethodBeat.i(5117);
    if (this.jOc.contains(parama)) {
      this.jOc.remove(parama);
    }
    AppMethodBeat.o(5117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.j
 * JD-Core Version:    0.7.0.1
 */