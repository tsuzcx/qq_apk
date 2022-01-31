package com.tencent.mm.plugin.qqmail.b;

import d.a.a.b;

public final class ai
  extends com.tencent.mm.bv.a
{
  public String name;
  public long nfq;
  public String nfr;
  public String path;
  public long size;
  public int state;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.path == null) {
        throw new b("Not all required fields were included: path");
      }
      if (this.name == null) {
        throw new b("Not all required fields were included: name");
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      paramVarArgs.Y(3, this.size);
      paramVarArgs.gB(4, this.state);
      paramVarArgs.Y(5, this.nfq);
      if (this.nfr != null) {
        paramVarArgs.d(6, this.nfr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = d.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.name != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.name);
      }
      i = i + d.a.a.a.X(3, this.size) + d.a.a.a.gy(4, this.state) + d.a.a.a.X(5, this.nfq);
      paramInt = i;
      if (this.nfr != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.nfr);
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
        if (this.path == null) {
          throw new b("Not all required fields were included: path");
        }
        if (this.name != null) {
          break;
        }
        throw new b("Not all required fields were included: name");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ai localai = (ai)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localai.path = locala.xpH.readString();
          return 0;
        case 2: 
          localai.name = locala.xpH.readString();
          return 0;
        case 3: 
          localai.size = locala.xpH.oE();
          return 0;
        case 4: 
          localai.state = locala.xpH.oD();
          return 0;
        case 5: 
          localai.nfq = locala.xpH.oE();
          return 0;
        }
        localai.nfr = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ai
 * JD-Core Version:    0.7.0.1
 */