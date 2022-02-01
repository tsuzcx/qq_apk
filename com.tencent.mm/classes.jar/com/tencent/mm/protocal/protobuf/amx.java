package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class amx
  extends com.tencent.mm.bx.a
{
  public int CID;
  public String sDZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CID);
      if (this.sDZ != null) {
        paramVarArgs.d(2, this.sDZ);
      }
      AppMethodBeat.o(124491);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.CID) + 0;
      paramInt = i;
      if (this.sDZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sDZ);
      }
      AppMethodBeat.o(124491);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(124491);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      amx localamx = (amx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124491);
        return -1;
      case 1: 
        localamx.CID = locala.KhF.xS();
        AppMethodBeat.o(124491);
        return 0;
      }
      localamx.sDZ = locala.KhF.readString();
      AppMethodBeat.o(124491);
      return 0;
    }
    AppMethodBeat.o(124491);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amx
 * JD-Core Version:    0.7.0.1
 */