package com.tencent.mm.protocal.c;

public final class anq
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public String kRN;
  public String kSy;
  public String tjK;
  public String tjL;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tjK != null) {
        paramVarArgs.d(1, this.tjK);
      }
      if (this.kSy != null) {
        paramVarArgs.d(2, this.kSy);
      }
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      if (this.kRN != null) {
        paramVarArgs.d(4, this.kRN);
      }
      if (this.tjL != null) {
        paramVarArgs.d(5, this.tjL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tjK == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.tjK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.kSy != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.kSy);
      }
      i = paramInt;
      if (this.bGw != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bGw);
      }
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.kRN);
      }
      i = paramInt;
      if (this.tjL != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tjL);
      }
      return i;
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
        anq localanq = (anq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localanq.tjK = locala.xpH.readString();
          return 0;
        case 2: 
          localanq.kSy = locala.xpH.readString();
          return 0;
        case 3: 
          localanq.bGw = locala.xpH.readString();
          return 0;
        case 4: 
          localanq.kRN = locala.xpH.readString();
          return 0;
        }
        localanq.tjL = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.anq
 * JD-Core Version:    0.7.0.1
 */