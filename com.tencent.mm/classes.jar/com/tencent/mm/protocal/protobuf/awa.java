package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awa
  extends com.tencent.mm.bx.a
{
  public int Fwg;
  public int GuN;
  public String iht;
  public int nEf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123572);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.iht != null) {
        paramVarArgs.d(1, this.iht);
      }
      paramVarArgs.aS(2, this.nEf);
      paramVarArgs.aS(3, this.Fwg);
      paramVarArgs.aS(4, this.GuN);
      AppMethodBeat.o(123572);
      return 0;
    }
    if (paramInt == 1) {
      if (this.iht == null) {
        break label350;
      }
    }
    label350:
    for (paramInt = f.a.a.b.b.a.e(1, this.iht) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.nEf);
      int j = f.a.a.b.b.a.bz(3, this.Fwg);
      int k = f.a.a.b.b.a.bz(4, this.GuN);
      AppMethodBeat.o(123572);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123572);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        awa localawa = (awa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123572);
          return -1;
        case 1: 
          localawa.iht = locala.NPN.readString();
          AppMethodBeat.o(123572);
          return 0;
        case 2: 
          localawa.nEf = locala.NPN.zc();
          AppMethodBeat.o(123572);
          return 0;
        case 3: 
          localawa.Fwg = locala.NPN.zc();
          AppMethodBeat.o(123572);
          return 0;
        }
        localawa.GuN = locala.NPN.zc();
        AppMethodBeat.o(123572);
        return 0;
      }
      AppMethodBeat.o(123572);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awa
 * JD-Core Version:    0.7.0.1
 */