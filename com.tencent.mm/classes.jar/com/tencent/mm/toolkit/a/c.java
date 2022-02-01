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
  private Uri VOE;
  Uri VOF;
  File VOG;
  public File VOH;
  boolean VOI;
  boolean VOJ;
  boolean VOK;
  int VOL;
  long VOM;
  long VON;
  private c.a VOO;
  HashMap<String, String> VOP;
  public f VOQ;
  private e VOR;
  public b VOS;
  private d VOT;
  boolean mCancelled;
  public long mContentLength;
  int mId;
  int mState;
  
  public c(String paramString)
  {
    AppMethodBeat.i(220786);
    this.mCancelled = false;
    this.VOI = true;
    this.VOJ = true;
    this.VOK = false;
    this.VOL = 0;
    this.VOM = 0L;
    this.mContentLength = -1L;
    this.VON = 1000L;
    this.VOO = c.a.VOV;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new NullPointerException("uri is invalid!");
      AppMethodBeat.o(220786);
      throw paramString;
    }
    paramString = Uri.parse(paramString);
    this.VOP = new HashMap();
    this.mState = 2000;
    this.VOE = paramString;
    this.VOF = paramString;
    AppMethodBeat.o(220786);
  }
  
  public final c L(File paramFile)
  {
    AppMethodBeat.i(220787);
    this.VOH = paramFile;
    this.VOG = new File(paramFile.getAbsolutePath() + ".tmp");
    AppMethodBeat.o(220787);
    return this;
  }
  
  final void finish()
  {
    AppMethodBeat.i(220790);
    if (this.VOT != null) {
      this.VOT.f(this);
    }
    AppMethodBeat.o(220790);
  }
  
  final e hEP()
  {
    AppMethodBeat.i(220788);
    while (this.VOR == null) {
      this.VOR = new e.a();
    }
    e locale = this.VOR;
    AppMethodBeat.o(220788);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.toolkit.a.c
 * JD-Core Version:    0.7.0.1
 */