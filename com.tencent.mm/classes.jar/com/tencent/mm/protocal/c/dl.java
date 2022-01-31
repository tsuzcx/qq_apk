package com.tencent.mm.protocal.c;

public final class dl
  extends com.tencent.mm.bv.a
{
  public String swK;
  public String swL;
  public String swM;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.swK != null) {
        paramVarArgs.d(1, this.swK);
      }
      if (this.swL != null) {
        paramVarArgs.d(2, this.swL);
      }
      if (this.swM != null) {
        paramVarArgs.d(3, this.swM);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.swK == null) {
        break label289;
      }
    }
    label289:
    for (int i = d.a.a.b.b.a.e(1, this.swK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swL != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swL);
      }
      i = paramInt;
      if (this.swM != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.swM);
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
        dl localdl = (dl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localdl.swK = locala.xpH.readString();
          return 0;
        case 2: 
          localdl.swL = locala.xpH.readString();
          return 0;
        }
        localdl.swM = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.dl
 * JD-Core Version:    0.7.0.1
 */