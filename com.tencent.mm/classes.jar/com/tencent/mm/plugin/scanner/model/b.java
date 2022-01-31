package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.plugin.scanner.util.f.a;
import com.tencent.mm.sdk.b.c;

public final class b
{
  Activity mActivity;
  String qud;
  f que;
  a quf;
  f.a qug;
  public c quh;
  public c qui;
  
  public b()
  {
    AppMethodBeat.i(80829);
    this.qug = new b.1(this);
    this.quh = new b.2(this);
    this.qui = new b.3(this);
    AppMethodBeat.o(80829);
  }
  
  public final void cid()
  {
    AppMethodBeat.i(80830);
    if (this.que != null)
    {
      this.que.cjt();
      this.que = null;
    }
    this.mActivity = null;
    this.qud = null;
    AppMethodBeat.o(80830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.b
 * JD-Core Version:    0.7.0.1
 */