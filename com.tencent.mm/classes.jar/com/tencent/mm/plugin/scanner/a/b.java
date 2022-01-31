package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.sdk.b.c;

public final class b
{
  Activity mActivity;
  String nGM;
  e nGN;
  a nGO;
  e.a nGP = new b.1(this);
  public c nGQ = new b.2(this);
  public c nGR = new b.3(this);
  
  public final void bxf()
  {
    if (this.nGN != null)
    {
      this.nGN.bym();
      this.nGN = null;
    }
    this.mActivity = null;
    this.nGM = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.b
 * JD-Core Version:    0.7.0.1
 */