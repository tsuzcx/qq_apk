package com.tencent.mm.protocal.c;

public final class cbz
  extends com.tencent.mm.bv.a
{
  public String nRj;
  public int nRk;
  public String scope;
  public int state;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.nRj != null) {
        paramVarArgs.d(2, this.nRj);
      }
      paramVarArgs.gB(3, this.state);
      paramVarArgs.gB(4, this.nRk);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label308;
      }
    }
    label308:
    for (paramInt = d.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nRj != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.nRj);
      }
      return i + d.a.a.a.gy(3, this.state) + d.a.a.a.gy(4, this.nRk);
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
        cbz localcbz = (cbz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcbz.scope = locala.xpH.readString();
          return 0;
        case 2: 
          localcbz.nRj = locala.xpH.readString();
          return 0;
        case 3: 
          localcbz.state = locala.xpH.oD();
          return 0;
        }
        localcbz.nRk = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cbz
 * JD-Core Version:    0.7.0.1
 */