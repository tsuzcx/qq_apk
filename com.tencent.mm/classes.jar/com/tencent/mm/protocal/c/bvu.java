package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class bvu
  extends com.tencent.mm.bv.a
{
  public String content;
  public String type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.type == null) {
        throw new b("Not all required fields were included: type");
      }
      if (this.type != null) {
        paramVarArgs.d(1, this.type);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.type == null) {
        break label266;
      }
    }
    label266:
    for (paramInt = d.a.a.b.b.a.e(1, this.type) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.content != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.content);
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
        if (this.type != null) {
          break;
        }
        throw new b("Not all required fields were included: type");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        bvu localbvu = (bvu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbvu.type = locala.xpH.readString();
          return 0;
        }
        localbvu.content = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bvu
 * JD-Core Version:    0.7.0.1
 */