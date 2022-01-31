package com.tencent.mm.protocal.c;

public final class bek
  extends com.tencent.mm.bv.a
{
  public String mOb;
  public String tzs;
  public String tzt;
  public String tzu;
  public String tzv;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tzs != null) {
        paramVarArgs.d(1, this.tzs);
      }
      if (this.tzt != null) {
        paramVarArgs.d(2, this.tzt);
      }
      if (this.mOb != null) {
        paramVarArgs.d(3, this.mOb);
      }
      if (this.tzu != null) {
        paramVarArgs.d(4, this.tzu);
      }
      if (this.tzv != null) {
        paramVarArgs.d(5, this.tzv);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tzs == null) {
        break label399;
      }
    }
    label399:
    for (int i = d.a.a.b.b.a.e(1, this.tzs) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tzt != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tzt);
      }
      i = paramInt;
      if (this.mOb != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.mOb);
      }
      paramInt = i;
      if (this.tzu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tzu);
      }
      i = paramInt;
      if (this.tzv != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tzv);
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
        bek localbek = (bek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbek.tzs = locala.xpH.readString();
          return 0;
        case 2: 
          localbek.tzt = locala.xpH.readString();
          return 0;
        case 3: 
          localbek.mOb = locala.xpH.readString();
          return 0;
        case 4: 
          localbek.tzu = locala.xpH.readString();
          return 0;
        }
        localbek.tzv = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bek
 * JD-Core Version:    0.7.0.1
 */