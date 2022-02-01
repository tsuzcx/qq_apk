package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fh
  extends com.tencent.mm.bx.a
{
  public boolean OAa;
  public boolean OzE;
  public boolean OzZ;
  public int YyQ;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YyQ);
      if (this.value != null) {
        paramVarArgs.g(2, this.value);
      }
      paramVarArgs.di(3, this.OzZ);
      paramVarArgs.di(4, this.OzE);
      paramVarArgs.di(5, this.OAa);
      paramVarArgs.bS(6, this.type);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YyQ) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.value);
      }
      i = i.a.a.b.b.a.ko(3);
      int j = i.a.a.b.b.a.ko(4);
      int k = i.a.a.b.b.a.ko(5);
      int m = i.a.a.b.b.a.cJ(6, this.type);
      AppMethodBeat.o(50078);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fh localfh = (fh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localfh.YyQ = locala.ajGk.aar();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localfh.value = locala.ajGk.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localfh.OzZ = locala.ajGk.aai();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localfh.OzE = locala.ajGk.aai();
        AppMethodBeat.o(50078);
        return 0;
      case 5: 
        localfh.OAa = locala.ajGk.aai();
        AppMethodBeat.o(50078);
        return 0;
      }
      localfh.type = locala.ajGk.aar();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fh
 * JD-Core Version:    0.7.0.1
 */