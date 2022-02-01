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
  boolean JlA;
  boolean JlB;
  int JlC;
  long JlD;
  long JlE;
  private a JlF;
  HashMap<String, String> JlG;
  public f JlH;
  private e JlI;
  public b JlJ;
  private d JlK;
  private Uri Jlv;
  Uri Jlw;
  File Jlx;
  public File Jly;
  boolean Jlz;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(189002);
    this.mCancelled = false;
    this.Jlz = true;
    this.JlA = true;
    this.JlB = false;
    this.JlC = 0;
    this.JlD = 0L;
    this.mContentLength = -1L;
    this.JlE = 1000L;
    this.JlF = a.JlM;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(189002);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.JlG = new HashMap();
    this.mState = 2000;
    this.Jlv = paramString;
    this.Jlw = paramString;
    AppMethodBeat.o(189002);
  }
  
  public final c T(File paramFile)
  {
    AppMethodBeat.i(189003);
    this.Jly = paramFile;
    this.Jlx = new File(paramFile.getAbsolutePath() + ".tmp");
    AppMethodBeat.o(189003);
    return this;
  }
  
  final void finish()
  {
    AppMethodBeat.i(189005);
    if (this.JlK != null) {
      this.JlK.f(this);
    }
    AppMethodBeat.o(189005);
  }
  
  final e fyo()
  {
    AppMethodBeat.i(189004);
    while (this.JlI == null) {
      this.JlI = new e.a();
    }
    e locale = this.JlI;
    AppMethodBeat.o(189004);
    return locale;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(189001);
      JlL = new a("LOW", 0);
      JlM = new a("NORMAL", 1);
      JlN = new a("HIGH", 2);
      JlO = new a("IMMEDIATE", 3);
      JlP = new a[] { JlL, JlM, JlN, JlO };
      AppMethodBeat.o(189001);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */