package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class aez
  extends com.tencent.mm.bv.a
{
  public String jnU;
  public String jnV;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.jnV == null) {
        throw new b("Not all required fields were included: ActivityId");
      }
      if (this.jnV != null) {
        paramVarArgs.d(1, this.jnV);
      }
      if (this.jnU != null) {
        paramVarArgs.d(2, this.jnU);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.jnV == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = d.a.a.b.b.a.e(1, this.jnV) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jnU != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.jnU);
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
        if (this.jnV != null) {
          break;
        }
        throw new b("Not all required fields were included: ActivityId");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        aez localaez = (aez)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaez.jnV = locala.xpH.readString();
          return 0;
        }
        localaez.jnU = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aez
 * JD-Core Version:    0.7.0.1
 */