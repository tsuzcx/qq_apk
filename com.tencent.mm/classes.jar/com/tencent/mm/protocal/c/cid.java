package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;

public final class cid
  extends com.tencent.mm.bv.a
{
  public b tWG;
  public b tWw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tWw != null) {
        paramVarArgs.b(1, this.tWw);
      }
      if (this.tWG != null) {
        paramVarArgs.b(2, this.tWG);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tWw == null) {
        break label228;
      }
    }
    label228:
    for (paramInt = d.a.a.a.a(1, this.tWw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tWG != null) {
        i = paramInt + d.a.a.a.a(2, this.tWG);
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
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        cid localcid = (cid)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localcid.tWw = locala.cUs();
          return 0;
        }
        localcid.tWG = locala.cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cid
 * JD-Core Version:    0.7.0.1
 */