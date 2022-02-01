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
  private Uri IQN;
  Uri IQO;
  File IQP;
  public File IQQ;
  boolean IQR;
  boolean IQS;
  boolean IQT;
  int IQU;
  long IQV;
  long IQW;
  private a IQX;
  HashMap<String, String> IQY;
  public f IQZ;
  private e IRa;
  public b IRb;
  private d IRc;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(211571);
    this.mCancelled = false;
    this.IQR = true;
    this.IQS = true;
    this.IQT = false;
    this.IQU = 0;
    this.IQV = 0L;
    this.mContentLength = -1L;
    this.IQW = 1000L;
    this.IQX = a.IRe;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(211571);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.IQY = new HashMap();
    this.mState = 2000;
    this.IQN = paramString;
    this.IQO = paramString;
    AppMethodBeat.o(211571);
  }
  
  public final c T(File paramFile)
  {
    AppMethodBeat.i(211572);
    this.IQQ = paramFile;
    this.IQP = new File(paramFile.getAbsolutePath() + ".tmp");
    AppMethodBeat.o(211572);
    return this;
  }
  
  final void finish()
  {
    AppMethodBeat.i(211574);
    if (this.IRc != null) {
      this.IRc.f(this);
    }
    AppMethodBeat.o(211574);
  }
  
  final e fun()
  {
    AppMethodBeat.i(211573);
    while (this.IRa == null) {
      this.IRa = new e.a();
    }
    e locale = this.IRa;
    AppMethodBeat.o(211573);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(211570);
      IRd = new a("LOW", 0);
      IRe = new a("NORMAL", 1);
      IRf = new a("HIGH", 2);
      IRg = new a("IMMEDIATE", 3);
      IRh = new a[] { IRd, IRe, IRf, IRg };
      AppMethodBeat.o(211570);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */