package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dld
  extends com.tencent.mm.bx.a
{
  public int EAL;
  public String EAP;
  public int hno;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32501);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EAL);
      paramVarArgs.aR(2, this.hno);
      if (this.EAP != null) {
        paramVarArgs.d(3, this.EAP);
      }
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EAL) + 0 + f.a.a.b.b.a.bA(2, this.hno);
      paramInt = i;
      if (this.EAP != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EAP);
      }
      AppMethodBeat.o(32501);
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
      AppMethodBeat.o(32501);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dld localdld = (dld)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32501);
        return -1;
      case 1: 
        localdld.EAL = locala.KhF.xS();
        AppMethodBeat.o(32501);
        return 0;
      case 2: 
        localdld.hno = locala.KhF.xS();
        AppMethodBeat.o(32501);
        return 0;
      }
      localdld.EAP = locala.KhF.readString();
      AppMethodBeat.o(32501);
      return 0;
    }
    AppMethodBeat.o(32501);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dld
 * JD-Core Version:    0.7.0.1
 */