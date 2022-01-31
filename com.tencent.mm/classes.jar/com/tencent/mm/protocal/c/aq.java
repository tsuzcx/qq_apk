package com.tencent.mm.protocal.c;

public final class aq
  extends com.tencent.mm.bv.a
{
  public String imo;
  public String imp;
  public String imq;
  public String imr;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.imo != null) {
        paramVarArgs.d(1, this.imo);
      }
      if (this.imp != null) {
        paramVarArgs.d(2, this.imp);
      }
      if (this.imq != null) {
        paramVarArgs.d(3, this.imq);
      }
      if (this.imr != null) {
        paramVarArgs.d(4, this.imr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.imo == null) {
        break label344;
      }
    }
    label344:
    for (int i = d.a.a.b.b.a.e(1, this.imo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.imp != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.imp);
      }
      i = paramInt;
      if (this.imq != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.imq);
      }
      paramInt = i;
      if (this.imr != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.imr);
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
        aq localaq = (aq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaq.imo = locala.xpH.readString();
          return 0;
        case 2: 
          localaq.imp = locala.xpH.readString();
          return 0;
        case 3: 
          localaq.imq = locala.xpH.readString();
          return 0;
        }
        localaq.imr = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aq
 * JD-Core Version:    0.7.0.1
 */