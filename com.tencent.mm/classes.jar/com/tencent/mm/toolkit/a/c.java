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
  public f OvA;
  private e OvB;
  public b OvC;
  private d OvD;
  private Uri Ovo;
  Uri Ovp;
  File Ovq;
  public File Ovr;
  boolean Ovs;
  boolean Ovt;
  boolean Ovu;
  int Ovv;
  long Ovw;
  long Ovx;
  private a Ovy;
  HashMap<String, String> Ovz;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(196814);
    this.mCancelled = false;
    this.Ovs = true;
    this.Ovt = true;
    this.Ovu = false;
    this.Ovv = 0;
    this.Ovw = 0L;
    this.mContentLength = -1L;
    this.Ovx = 1000L;
    this.Ovy = a.OvF;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(196814);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.Ovz = new HashMap();
    this.mState = 2000;
    this.Ovo = paramString;
    this.Ovp = paramString;
    AppMethodBeat.o(196814);
  }
  
  public final c T(File paramFile)
  {
    AppMethodBeat.i(196815);
    this.Ovr = paramFile;
    this.Ovq = new File(paramFile.getAbsolutePath() + ".tmp");
    AppMethodBeat.o(196815);
    return this;
  }
  
  final void finish()
  {
    AppMethodBeat.i(196817);
    if (this.OvD != null) {
      this.OvD.f(this);
    }
    AppMethodBeat.o(196817);
  }
  
  final e gGc()
  {
    AppMethodBeat.i(196816);
    while (this.OvB == null) {
      this.OvB = new e.a();
    }
    e locale = this.OvB;
    AppMethodBeat.o(196816);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(196813);
      OvE = new a("LOW", 0);
      OvF = new a("NORMAL", 1);
      OvG = new a("HIGH", 2);
      OvH = new a("IMMEDIATE", 3);
      OvI = new a[] { OvE, OvF, OvG, OvH };
      AppMethodBeat.o(196813);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */