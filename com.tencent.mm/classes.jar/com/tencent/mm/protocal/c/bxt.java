package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bxt
  extends com.tencent.mm.bv.a
{
  public String key;
  public String value;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.key == null) {
        throw new b("Not all required fields were included: key");
      }
      if (this.value == null) {
        throw new b("Not all required fields were included: value");
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.value != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.value);
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
        if (this.key == null) {
          throw new b("Not all required fields were included: key");
        }
        if (this.value != null) {
          break;
        }
        throw new b("Not all required fields were included: value");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bxt localbxt = (bxt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbxt.key = locala.xpH.readString();
          return 0;
        }
        localbxt.value = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bxt
 * JD-Core Version:    0.7.0.1
 */