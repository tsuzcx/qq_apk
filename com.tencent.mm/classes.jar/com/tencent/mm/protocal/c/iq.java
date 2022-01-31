package com.tencent.mm.protocal.c;

public final class iq
  extends com.tencent.mm.bv.a
{
  public String ipb;
  public String sCP;
  public int ver;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sCP != null) {
        paramVarArgs.d(1, this.sCP);
      }
      if (this.ipb != null) {
        paramVarArgs.d(2, this.ipb);
      }
      paramVarArgs.gB(3, this.ver);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sCP == null) {
        break label269;
      }
    }
    label269:
    for (paramInt = d.a.a.b.b.a.e(1, this.sCP) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ipb != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.ipb);
      }
      return i + d.a.a.a.gy(3, this.ver);
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
        iq localiq = (iq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localiq.sCP = locala.xpH.readString();
          return 0;
        case 2: 
          localiq.ipb = locala.xpH.readString();
          return 0;
        }
        localiq.ver = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.iq
 * JD-Core Version:    0.7.0.1
 */