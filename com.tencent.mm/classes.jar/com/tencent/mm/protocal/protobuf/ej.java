package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ej
  extends com.tencent.mm.bx.a
{
  public int Fwg;
  public String Fwh;
  public String iht;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123539);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.Fwg);
      if (this.Fwh != null) {
        paramVarArgs.d(4, this.Fwh);
      }
      AppMethodBeat.o(123539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.iht) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.nEf) + f.a.a.b.b.a.bz(3, this.Fwg);
      paramInt = i;
      if (this.Fwh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fwh);
      }
      AppMethodBeat.o(123539);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123539);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123539);
          return -1;
        case 1: 
          localej.iht = locala.NPN.readString();
          AppMethodBeat.o(123539);
          return 0;
        case 2: 
          localej.nEf = locala.NPN.zc();
          AppMethodBeat.o(123539);
          return 0;
        case 3: 
          localej.Fwg = locala.NPN.zc();
          AppMethodBeat.o(123539);
          return 0;
        }
        localej.Fwh = locala.NPN.readString();
        AppMethodBeat.o(123539);
        return 0;
      }
      AppMethodBeat.o(123539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ej
 * JD-Core Version:    0.7.0.1
 */