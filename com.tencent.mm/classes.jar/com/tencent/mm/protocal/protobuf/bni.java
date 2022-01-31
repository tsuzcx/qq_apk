package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bni
  extends com.tencent.mm.bv.a
{
  public int type;
  public String xBy;
  public String xBz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114982);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.type);
      if (this.xBy != null) {
        paramVarArgs.e(2, this.xBy);
      }
      if (this.xBz != null) {
        paramVarArgs.e(3, this.xBz);
      }
      AppMethodBeat.o(114982);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.type) + 0;
      paramInt = i;
      if (this.xBy != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xBy);
      }
      i = paramInt;
      if (this.xBz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xBz);
      }
      AppMethodBeat.o(114982);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(114982);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bni localbni = (bni)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114982);
        return -1;
      case 1: 
        localbni.type = locala.CLY.sl();
        AppMethodBeat.o(114982);
        return 0;
      case 2: 
        localbni.xBy = locala.CLY.readString();
        AppMethodBeat.o(114982);
        return 0;
      }
      localbni.xBz = locala.CLY.readString();
      AppMethodBeat.o(114982);
      return 0;
    }
    AppMethodBeat.o(114982);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bni
 * JD-Core Version:    0.7.0.1
 */