package com.tencent.mm.protocal.c;

public final class bey
  extends com.tencent.mm.bv.a
{
  public String ffj;
  public String ffq;
  public float sGJ;
  public float sGK;
  public String tlI;
  public String tzJ;
  public String tzK;
  public long tzL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tzJ != null) {
        paramVarArgs.d(1, this.tzJ);
      }
      if (this.ffq != null) {
        paramVarArgs.d(2, this.ffq);
      }
      if (this.ffj != null) {
        paramVarArgs.d(3, this.ffj);
      }
      if (this.tlI != null) {
        paramVarArgs.d(4, this.tlI);
      }
      paramVarArgs.m(5, this.sGK);
      paramVarArgs.m(6, this.sGJ);
      if (this.tzK != null) {
        paramVarArgs.d(7, this.tzK);
      }
      paramVarArgs.Y(8, this.tzL);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tzJ == null) {
        break label512;
      }
    }
    label512:
    for (int i = d.a.a.b.b.a.e(1, this.tzJ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ffq != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ffq);
      }
      i = paramInt;
      if (this.ffj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ffj);
      }
      paramInt = i;
      if (this.tlI != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tlI);
      }
      i = paramInt + (d.a.a.b.b.a.dQ(5) + 4) + (d.a.a.b.b.a.dQ(6) + 4);
      paramInt = i;
      if (this.tzK != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tzK);
      }
      return paramInt + d.a.a.a.X(8, this.tzL);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bey localbey = (bey)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbey.tzJ = locala.xpH.readString();
          return 0;
        case 2: 
          localbey.ffq = locala.xpH.readString();
          return 0;
        case 3: 
          localbey.ffj = locala.xpH.readString();
          return 0;
        case 4: 
          localbey.tlI = locala.xpH.readString();
          return 0;
        case 5: 
          localbey.sGK = locala.xpH.readFloat();
          return 0;
        case 6: 
          localbey.sGJ = locala.xpH.readFloat();
          return 0;
        case 7: 
          localbey.tzK = locala.xpH.readString();
          return 0;
        }
        localbey.tzL = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bey
 * JD-Core Version:    0.7.0.1
 */