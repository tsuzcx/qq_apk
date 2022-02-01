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
  public File HdA;
  boolean HdB;
  boolean HdC;
  boolean HdD;
  int HdE;
  long HdF;
  long HdG;
  private c.a HdH;
  HashMap<String, String> HdI;
  public f HdJ;
  private e HdK;
  public b HdL;
  private d HdM;
  private Uri Hdx;
  Uri Hdy;
  public File Hdz;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(193026);
    this.mCancelled = false;
    this.HdB = true;
    this.HdC = true;
    this.HdD = false;
    this.HdE = 0;
    this.HdF = 0L;
    this.mContentLength = -1L;
    this.HdG = 1000L;
    this.HdH = c.a.HdO;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(193026);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.HdI = new HashMap();
    this.mState = 2000;
    this.Hdx = paramString;
    this.Hdy = paramString;
    AppMethodBeat.o(193026);
  }
  
  final e fef()
  {
    AppMethodBeat.i(193027);
    while (this.HdK == null) {
      this.HdK = new e.a();
    }
    e locale = this.HdK;
    AppMethodBeat.o(193027);
    return locale;
  }
  
  final void finish()
  {
    AppMethodBeat.i(193028);
    if (this.HdM != null) {
      this.HdM.f(this);
    }
    AppMethodBeat.o(193028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */