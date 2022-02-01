package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.rl;
import com.tencent.mm.plugin.scanner.f.e.a;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.c;
import com.tencent.mm.sdk.event.IListener;

public final class e
{
  String CFr;
  c CFs;
  a CFt;
  e.a CFu;
  public IListener CFv;
  public IListener CFw;
  public IListener CFx;
  Activity mActivity;
  
  public e()
  {
    AppMethodBeat.i(51615);
    this.CFu = new e.1(this);
    this.CFv = new IListener() {};
    this.CFw = new e.3(this);
    this.CFx = new IListener() {};
    AppMethodBeat.o(51615);
  }
  
  public final void ePN()
  {
    AppMethodBeat.i(51616);
    if (this.CFs != null)
    {
      this.CFs.eRR();
      this.CFs = null;
    }
    this.mActivity = null;
    this.CFr = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.e
 * JD-Core Version:    0.7.0.1
 */