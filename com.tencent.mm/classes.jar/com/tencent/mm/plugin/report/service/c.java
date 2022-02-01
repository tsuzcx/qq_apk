package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class c
  extends com.tencent.mm.bw.a
{
  public int gvt;
  public int nJA;
  public boolean yxg;
  public String yxn;
  public boolean yxo;
  public boolean yxp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yxn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.gvt);
      if (this.yxn != null) {
        paramVarArgs.d(2, this.yxn);
      }
      paramVarArgs.bC(3, this.yxo);
      paramVarArgs.bC(4, this.yxg);
      paramVarArgs.aS(5, this.nJA);
      paramVarArgs.bC(6, this.yxp);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.gvt) + 0;
      paramInt = i;
      if (this.yxn != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yxn);
      }
      i = f.a.a.b.b.a.amF(3);
      int j = f.a.a.b.b.a.amF(4);
      int k = f.a.a.b.b.a.bz(5, this.nJA);
      int m = f.a.a.b.b.a.amF(6);
      AppMethodBeat.o(143831);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.yxn == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      c localc = (c)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143831);
        return -1;
      case 1: 
        localc.gvt = locala.OmT.zc();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        localc.yxn = locala.OmT.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        localc.yxo = locala.OmT.gvY();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        localc.yxg = locala.OmT.gvY();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        localc.nJA = locala.OmT.zc();
        AppMethodBeat.o(143831);
        return 0;
      }
      localc.yxp = locala.OmT.gvY();
      AppMethodBeat.o(143831);
      return 0;
    }
    AppMethodBeat.o(143831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.report.service.c
 * JD-Core Version:    0.7.0.1
 */