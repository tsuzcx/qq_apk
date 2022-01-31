package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class c
  extends b
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(File paramFile, SharePatchInfo paramSharePatchInfo, String paramString)
  {
    AppMethodBeat.i(65548);
    super.a(paramFile, paramSharePatchInfo, paramString);
    AppMethodBeat.o(65548);
  }
  
  public final void a(File paramFile1, File paramFile2, String paramString, int paramInt)
  {
    AppMethodBeat.i(65547);
    super.a(paramFile1, paramFile2, paramString, paramInt);
    AppMethodBeat.o(65547);
  }
  
  public final void a(File paramFile, String paramString1, String paramString2)
  {
    AppMethodBeat.i(65545);
    super.a(paramFile, paramString1, paramString2);
    AppMethodBeat.o(65545);
  }
  
  public final void a(File paramFile, Throwable paramThrowable)
  {
    AppMethodBeat.i(65544);
    super.a(paramFile, paramThrowable);
    AppMethodBeat.o(65544);
  }
  
  public final void a(File paramFile, List<File> paramList, Throwable paramThrowable)
  {
    AppMethodBeat.i(65543);
    super.a(paramFile, paramList, paramThrowable);
    AppMethodBeat.o(65543);
  }
  
  public final void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(65542);
    super.a(paramFile, paramBoolean, paramLong);
    AppMethodBeat.o(65542);
  }
  
  public final void ac(Intent paramIntent)
  {
    AppMethodBeat.i(65541);
    super.ac(paramIntent);
    AppMethodBeat.o(65541);
  }
  
  public final void e(File paramFile, int paramInt)
  {
    AppMethodBeat.i(65546);
    super.e(paramFile, paramInt);
    AppMethodBeat.o(65546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tinkerboots.sdk.tinker.b.c
 * JD-Core Version:    0.7.0.1
 */