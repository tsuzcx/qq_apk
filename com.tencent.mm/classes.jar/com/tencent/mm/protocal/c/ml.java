package com.tencent.mm.protocal.c;

public final class ml
  extends com.tencent.mm.bv.a
{
  public String sJj;
  public String sJk;
  public int sJl;
  public int sJm;
  public int sJn;
  public int sJo;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sJj != null) {
        paramVarArgs.d(1, this.sJj);
      }
      if (this.sJk != null) {
        paramVarArgs.d(2, this.sJk);
      }
      paramVarArgs.gB(3, this.sJl);
      paramVarArgs.gB(4, this.sJm);
      paramVarArgs.gB(5, this.sJn);
      paramVarArgs.gB(6, this.sJo);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sJj == null) {
        break label382;
      }
    }
    label382:
    for (paramInt = d.a.a.b.b.a.e(1, this.sJj) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sJk != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.sJk);
      }
      return i + d.a.a.a.gy(3, this.sJl) + d.a.a.a.gy(4, this.sJm) + d.a.a.a.gy(5, this.sJn) + d.a.a.a.gy(6, this.sJo);
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
        ml localml = (ml)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localml.sJj = locala.xpH.readString();
          return 0;
        case 2: 
          localml.sJk = locala.xpH.readString();
          return 0;
        case 3: 
          localml.sJl = locala.xpH.oD();
          return 0;
        case 4: 
          localml.sJm = locala.xpH.oD();
          return 0;
        case 5: 
          localml.sJn = locala.xpH.oD();
          return 0;
        }
        localml.sJo = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ml
 * JD-Core Version:    0.7.0.1
 */