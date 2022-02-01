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
  private Uri adsJ;
  Uri adsK;
  File adsL;
  public File adsM;
  boolean adsN;
  boolean adsO;
  boolean adsP;
  int adsQ;
  long adsR;
  long adsS;
  private c.a adsT;
  HashMap<String, String> adsU;
  public f adsV;
  private e adsW;
  public b adsX;
  private d adsY;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(231997);
    this.mCancelled = false;
    this.adsN = true;
    this.adsO = true;
    this.adsP = false;
    this.adsQ = 0;
    this.adsR = 0L;
    this.mContentLength = -1L;
    this.adsS = 1000L;
    this.adsT = c.a.adta;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(231997);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.adsU = new HashMap();
    this.mState = 2000;
    this.adsJ = paramString;
    this.adsK = paramString;
    AppMethodBeat.o(231997);
  }
  
  public final c Q(File paramFile)
  {
    AppMethodBeat.i(232000);
    this.adsM = paramFile;
    this.adsL = new File(paramFile.getAbsolutePath() + ".tmp");
    AppMethodBeat.o(232000);
    return this;
  }
  
  final void finish()
  {
    AppMethodBeat.i(232010);
    if (this.adsY != null) {
      this.adsY.f(this);
    }
    AppMethodBeat.o(232010);
  }
  
  final e jhc()
  {
    AppMethodBeat.i(232006);
    while (this.adsW == null) {
      this.adsW = new e.a();
    }
    e locale = this.adsW;
    AppMethodBeat.o(232006);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */