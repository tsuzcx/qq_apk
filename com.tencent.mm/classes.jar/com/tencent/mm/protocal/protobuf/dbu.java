package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbu
  extends com.tencent.mm.bv.a
{
  public int yhZ;
  public boolean yia;
  public boolean yib;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96349);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.yhZ);
      paramVarArgs.aS(2, this.yia);
      paramVarArgs.aS(3, this.yib);
      AppMethodBeat.o(96349);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.yhZ);
      int i = e.a.a.b.b.a.eW(2);
      int j = e.a.a.b.b.a.eW(3);
      AppMethodBeat.o(96349);
      return paramInt + 0 + (i + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(96349);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      dbu localdbu = (dbu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(96349);
        return -1;
      case 1: 
        localdbu.yhZ = locala.CLY.sl();
        AppMethodBeat.o(96349);
        return 0;
      case 2: 
        localdbu.yia = locala.CLY.emu();
        AppMethodBeat.o(96349);
        return 0;
      }
      localdbu.yib = locala.CLY.emu();
      AppMethodBeat.o(96349);
      return 0;
    }
    AppMethodBeat.o(96349);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbu
 * JD-Core Version:    0.7.0.1
 */