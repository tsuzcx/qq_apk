package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class en
  extends com.tencent.mm.cd.a
{
  public boolean IyX;
  public boolean Izq;
  public boolean Izr;
  public int RCo;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50078);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.RCo);
      if (this.value != null) {
        paramVarArgs.f(2, this.value);
      }
      paramVarArgs.co(3, this.Izq);
      paramVarArgs.co(4, this.IyX);
      paramVarArgs.co(5, this.Izr);
      paramVarArgs.aY(6, this.type);
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.RCo) + 0;
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.value);
      }
      i = g.a.a.b.b.a.gL(3);
      int j = g.a.a.b.b.a.gL(4);
      int k = g.a.a.b.b.a.gL(5);
      int m = g.a.a.b.b.a.bM(6, this.type);
      AppMethodBeat.o(50078);
      return paramInt + (i + 1) + (j + 1) + (k + 1) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(50078);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      en localen = (en)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(50078);
        return -1;
      case 1: 
        localen.RCo = locala.abFh.AK();
        AppMethodBeat.o(50078);
        return 0;
      case 2: 
        localen.value = locala.abFh.readString();
        AppMethodBeat.o(50078);
        return 0;
      case 3: 
        localen.Izq = locala.abFh.AB();
        AppMethodBeat.o(50078);
        return 0;
      case 4: 
        localen.IyX = locala.abFh.AB();
        AppMethodBeat.o(50078);
        return 0;
      case 5: 
        localen.Izr = locala.abFh.AB();
        AppMethodBeat.o(50078);
        return 0;
      }
      localen.type = locala.abFh.AK();
      AppMethodBeat.o(50078);
      return 0;
    }
    AppMethodBeat.o(50078);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.en
 * JD-Core Version:    0.7.0.1
 */