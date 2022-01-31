package com.tencent.mm.protocal.c;

public final class auv
  extends com.tencent.mm.bv.a
{
  public int sLt;
  public String tdF;
  public String tqE;
  public String tqF;
  public String type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tqE != null) {
        paramVarArgs.d(1, this.tqE);
      }
      if (this.tdF != null) {
        paramVarArgs.d(2, this.tdF);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      paramVarArgs.gB(4, this.sLt);
      if (this.tqF != null) {
        paramVarArgs.d(5, this.tqF);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tqE == null) {
        break label383;
      }
    }
    label383:
    for (int i = d.a.a.b.b.a.e(1, this.tqE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tdF != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tdF);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.type);
      }
      i += d.a.a.a.gy(4, this.sLt);
      paramInt = i;
      if (this.tqF != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.tqF);
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
        auv localauv = (auv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localauv.tqE = locala.xpH.readString();
          return 0;
        case 2: 
          localauv.tdF = locala.xpH.readString();
          return 0;
        case 3: 
          localauv.type = locala.xpH.readString();
          return 0;
        case 4: 
          localauv.sLt = locala.xpH.oD();
          return 0;
        }
        localauv.tqF = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.auv
 * JD-Core Version:    0.7.0.1
 */