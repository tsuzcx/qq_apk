package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class c$a
{
  long mEndTime = -1L;
  long mStartTime = -1L;
  long reO;
  d rlo;
  int rlp = 0;
  int rlq = 0;
  String rlr = "";
  String rls = "";
  String rlt;
  
  public c$a(long paramLong1, long paramLong2, String paramString, d paramd)
  {
    this.rlo = paramd;
    this.mStartTime = paramLong1;
    this.reO = paramLong2;
    this.rlt = paramString;
  }
  
  private void addAction(String paramString)
  {
    AppMethodBeat.i(36782);
    if (!bo.isNullOrNil(this.rls)) {
      this.rls += "|";
    }
    this.rls += paramString;
    AppMethodBeat.o(36782);
  }
  
  public final void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(36781);
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      AppMethodBeat.o(36781);
      return;
    }
    String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
    String str2 = paramInt1 + ":" + paramInt2;
    if ((str1.equals(this.rlr)) || ((this.rlr.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)))
    {
      AppMethodBeat.o(36781);
      return;
    }
    this.rlr = str1;
    addAction(paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4);
    AppMethodBeat.o(36781);
  }
  
  public final void fw(int paramInt1, int paramInt2)
  {
    this.rlp = paramInt1;
    this.rlq = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.c.a
 * JD-Core Version:    0.7.0.1
 */