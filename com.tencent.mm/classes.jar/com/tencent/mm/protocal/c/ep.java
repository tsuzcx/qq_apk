package com.tencent.mm.protocal.c;

public final class ep
  extends com.tencent.mm.bv.a
{
  public String scope;
  public int state;
  public String syf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.syf != null) {
        paramVarArgs.d(2, this.syf);
      }
      paramVarArgs.gB(3, this.state);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.syf != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.syf);
      }
      return i + d.a.a.a.gy(3, this.state);
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
        ep localep = (ep)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localep.scope = locala.xpH.readString();
          return 0;
        case 2: 
          localep.syf = locala.xpH.readString();
          return 0;
        }
        localep.state = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ep
 * JD-Core Version:    0.7.0.1
 */