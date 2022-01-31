package com.tencent.mm.protocal.c;

public final class bjl
  extends com.tencent.mm.bv.a
{
  public String tDm;
  public String tDn;
  public int tDo;
  public int tDp = 0;
  public String tDq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tDm != null) {
        paramVarArgs.d(1, this.tDm);
      }
      if (this.tDn != null) {
        paramVarArgs.d(2, this.tDn);
      }
      paramVarArgs.gB(3, this.tDo);
      paramVarArgs.gB(4, this.tDp);
      if (this.tDq != null) {
        paramVarArgs.d(5, this.tDq);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tDm == null) {
        break label363;
      }
    }
    label363:
    for (paramInt = d.a.a.b.b.a.e(1, this.tDm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tDn != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.tDn);
      }
      i = i + d.a.a.a.gy(3, this.tDo) + d.a.a.a.gy(4, this.tDp);
      paramInt = i;
      if (this.tDq != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tDq);
      }
      return paramInt;
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
        bjl localbjl = (bjl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbjl.tDm = locala.xpH.readString();
          return 0;
        case 2: 
          localbjl.tDn = locala.xpH.readString();
          return 0;
        case 3: 
          localbjl.tDo = locala.xpH.oD();
          return 0;
        case 4: 
          localbjl.tDp = locala.xpH.oD();
          return 0;
        }
        localbjl.tDq = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bjl
 * JD-Core Version:    0.7.0.1
 */