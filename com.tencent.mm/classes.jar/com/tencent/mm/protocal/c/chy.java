package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class chy
  extends com.tencent.mm.bv.a
{
  public b tWw;
  public b tWx;
  public b tWy;
  public b tWz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWw != null) {
        paramVarArgs.b(1, this.tWw);
      }
      if (this.tWx != null) {
        paramVarArgs.b(2, this.tWx);
      }
      if (this.tWy != null) {
        paramVarArgs.b(3, this.tWy);
      }
      if (this.tWz != null) {
        paramVarArgs.b(4, this.tWz);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWw == null) {
        break label332;
      }
    }
    label332:
    for (int i = d.a.a.a.a(1, this.tWw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tWx != null) {
        paramInt = i + d.a.a.a.a(2, this.tWx);
      }
      i = paramInt;
      if (this.tWy != null) {
        i = paramInt + d.a.a.a.a(3, this.tWy);
      }
      paramInt = i;
      if (this.tWz != null) {
        paramInt = i + d.a.a.a.a(4, this.tWz);
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
        chy localchy = (chy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localchy.tWw = locala.cUs();
          return 0;
        case 2: 
          localchy.tWx = locala.cUs();
          return 0;
        case 3: 
          localchy.tWy = locala.cUs();
          return 0;
        }
        localchy.tWz = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.chy
 * JD-Core Version:    0.7.0.1
 */