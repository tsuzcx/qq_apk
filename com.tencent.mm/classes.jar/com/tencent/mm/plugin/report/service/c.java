package com.tencent.mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class c
  extends com.tencent.mm.bx.a
{
  public int gsR;
  public int nEf;
  public boolean yhp;
  public String yhw;
  public boolean yhx;
  public boolean yhy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.yhw == null)
      {
        paramVarArgs = new b("Not all required fields were included: Value");
        AppMethodBeat.o(143831);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.gsR);
      if (this.yhw != null) {
        paramVarArgs.d(2, this.yhw);
      }
      paramVarArgs.bt(3, this.yhx);
      paramVarArgs.bt(4, this.yhp);
      paramVarArgs.aS(5, this.nEf);
      paramVarArgs.bt(6, this.yhy);
      AppMethodBeat.o(143831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.gsR) + 0;
      paramInt = i;
      if (this.yhw != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.yhw);
      }
      i = f.a.a.b.b.a.alV(3);
      int j = f.a.a.b.b.a.alV(4);
      int k = f.a.a.b.b.a.bz(5, this.nEf);
      int m = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(143831);
      return paramInt + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.yhw == null)
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
        localc.gsR = locala.NPN.zc();
        AppMethodBeat.o(143831);
        return 0;
      case 2: 
        localc.yhw = locala.NPN.readString();
        AppMethodBeat.o(143831);
        return 0;
      case 3: 
        localc.yhx = locala.NPN.grw();
        AppMethodBeat.o(143831);
        return 0;
      case 4: 
        localc.yhp = locala.NPN.grw();
        AppMethodBeat.o(143831);
        return 0;
      case 5: 
        localc.nEf = locala.NPN.zc();
        AppMethodBeat.o(143831);
        return 0;
      }
      localc.yhy = locala.NPN.grw();
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