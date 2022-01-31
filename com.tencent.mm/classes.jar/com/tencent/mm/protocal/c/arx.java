package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class arx
  extends com.tencent.mm.bv.a
{
  public String nRj;
  public String scope;
  public int tnk;
  public LinkedList<String> tnl = new LinkedList();
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      paramVarArgs.gB(2, this.tnk);
      if (this.nRj != null) {
        paramVarArgs.d(3, this.nRj);
      }
      paramVarArgs.d(4, 1, this.tnl);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label324;
      }
    }
    label324:
    for (paramInt = d.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.tnk);
      paramInt = i;
      if (this.nRj != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.nRj);
      }
      return paramInt + d.a.a.a.c(4, 1, this.tnl);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tnl.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        arx localarx = (arx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localarx.scope = locala.xpH.readString();
          return 0;
        case 2: 
          localarx.tnk = locala.xpH.oD();
          return 0;
        case 3: 
          localarx.nRj = locala.xpH.readString();
          return 0;
        }
        localarx.tnl.add(locala.xpH.readString());
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.arx
 * JD-Core Version:    0.7.0.1
 */