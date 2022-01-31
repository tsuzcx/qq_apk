package com.tencent.mm.protocal.c;

public final class brx
  extends com.tencent.mm.bv.a
{
  public int tIv;
  public int tIw;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      paramVarArgs.gB(2, this.tIv);
      paramVarArgs.gB(3, this.tIw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label246;
      }
    }
    label246:
    for (paramInt = d.a.a.b.b.a.e(1, this.url) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.tIv) + d.a.a.a.gy(3, this.tIw);
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
        brx localbrx = (brx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbrx.url = locala.xpH.readString();
          return 0;
        case 2: 
          localbrx.tIv = locala.xpH.oD();
          return 0;
        }
        localbrx.tIw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.brx
 * JD-Core Version:    0.7.0.1
 */