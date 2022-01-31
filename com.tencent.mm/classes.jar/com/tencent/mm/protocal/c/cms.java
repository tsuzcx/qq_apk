package com.tencent.mm.protocal.c;

public final class cms
  extends com.tencent.mm.bv.a
{
  public int scene;
  public String tZt;
  public int tZu;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tZt != null) {
        paramVarArgs.d(1, this.tZt);
      }
      paramVarArgs.gB(2, this.scene);
      paramVarArgs.gB(3, this.tZu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tZt == null) {
        break label246;
      }
    }
    label246:
    for (paramInt = d.a.a.b.b.a.e(1, this.tZt) + 0;; paramInt = 0)
    {
      return paramInt + d.a.a.a.gy(2, this.scene) + d.a.a.a.gy(3, this.tZu);
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
        cms localcms = (cms)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcms.tZt = locala.xpH.readString();
          return 0;
        case 2: 
          localcms.scene = locala.xpH.oD();
          return 0;
        }
        localcms.tZu = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cms
 * JD-Core Version:    0.7.0.1
 */