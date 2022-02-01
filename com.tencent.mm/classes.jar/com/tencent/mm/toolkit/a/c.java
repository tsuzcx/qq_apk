package com.tencent.mm.toolkit.a;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.b;
import com.tencent.mm.toolkit.a.a.d;
import com.tencent.mm.toolkit.a.a.e;
import com.tencent.mm.toolkit.a.a.e.a;
import com.tencent.mm.toolkit.a.a.f;
import java.io.File;
import java.util.HashMap;

public final class c
  implements Comparable<c>
{
  boolean FEA;
  int FEB;
  long FEC;
  long FED;
  private c.a FEE;
  HashMap<String, String> FEF;
  public f FEG;
  private e FEH;
  public b FEI;
  private d FEJ;
  private Uri FEu;
  Uri FEv;
  public File FEw;
  public File FEx;
  boolean FEy;
  boolean FEz;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(189805);
    this.mCancelled = false;
    this.FEy = true;
    this.FEz = true;
    this.FEA = false;
    this.FEB = 0;
    this.FEC = 0L;
    this.mContentLength = -1L;
    this.FED = 1000L;
    this.FEE = c.a.FEL;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(189805);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.FEF = new HashMap();
    this.mState = 2000;
    this.FEu = paramString;
    this.FEv = paramString;
    AppMethodBeat.o(189805);
  }
  
  final e eOB()
  {
    AppMethodBeat.i(189806);
    while (this.FEH == null) {
      this.FEH = new e.a();
    }
    e locale = this.FEH;
    AppMethodBeat.o(189806);
    return locale;
  }
  
  final void finish()
  {
    AppMethodBeat.i(189807);
    if (this.FEJ != null) {
      this.FEJ.f(this);
    }
    AppMethodBeat.o(189807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */