package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bk;

final class c$a
{
  long mEndTime = -1L;
  long mStartTime = -1L;
  long oqh;
  d owu;
  int owv = 0;
  int oww = 0;
  String owx = "";
  String owy = "";
  String owz;
  
  public c$a(long paramLong1, long paramLong2, String paramString, d paramd)
  {
    this.owu = paramd;
    this.mStartTime = paramLong1;
    this.oqh = paramLong2;
    this.owz = paramString;
  }
  
  public final void dN(int paramInt1, int paramInt2)
  {
    this.owv = paramInt1;
    this.oww = paramInt2;
  }
  
  public final void x(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1)) {}
    String str2;
    do
    {
      return;
      str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
      str2 = paramInt1 + ":" + paramInt2;
    } while ((str1.equals(this.owx)) || ((this.owx.startsWith(str2)) && (paramInt3 == 0) && (paramInt4 == 0)));
    this.owx = str1;
    String str1 = paramInt1 + ":" + paramInt2 + ":" + paramInt3 + ":" + paramInt4;
    if (!bk.bl(this.owy)) {
      this.owy += "|";
    }
    this.owy += str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.c.a
 * JD-Core Version:    0.7.0.1
 */