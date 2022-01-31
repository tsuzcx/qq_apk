package com.tencent.mm.protocal.c;

import d.a.a.b;

public final class ayo
  extends com.tencent.mm.bv.a
{
  public String content;
  public String lang;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.lang == null) {
        throw new b("Not all required fields were included: lang");
      }
      if (this.content == null) {
        throw new b("Not all required fields were included: content");
      }
      if (this.lang != null) {
        paramVarArgs.d(1, this.lang);
      }
      if (this.content != null) {
        paramVarArgs.d(2, this.content);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.lang == null) {
        break label302;
      }
    }
    label302:
    for (paramInt = d.a.a.b.b.a.e(1, this.lang) + 0;; paramInt = 0)
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
        if (this.lang == null) {
          throw new b("Not all required fields were included: lang");
        }
        if (this.content != null) {
          break;
        }
        throw new b("Not all required fields were included: content");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ayo localayo = (ayo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localayo.lang = locala.xpH.readString();
          return 0;
        }
        localayo.content = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ayo
 * JD-Core Version:    0.7.0.1
 */