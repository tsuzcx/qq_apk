package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpp
  extends com.tencent.mm.bw.a
{
  public String Gze;
  public int HBJ;
  public String qkD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32394);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qkD != null) {
        paramVarArgs.d(1, this.qkD);
      }
      paramVarArgs.aS(2, this.HBJ);
      if (this.Gze != null) {
        paramVarArgs.d(3, this.Gze);
      }
      AppMethodBeat.o(32394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qkD == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = f.a.a.b.b.a.e(1, this.qkD) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HBJ);
      paramInt = i;
      if (this.Gze != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gze);
      }
      AppMethodBeat.o(32394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32394);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cpp localcpp = (cpp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32394);
          return -1;
        case 1: 
          localcpp.qkD = locala.OmT.readString();
          AppMethodBeat.o(32394);
          return 0;
        case 2: 
          localcpp.HBJ = locala.OmT.zc();
          AppMethodBeat.o(32394);
          return 0;
        }
        localcpp.Gze = locala.OmT.readString();
        AppMethodBeat.o(32394);
        return 0;
      }
      AppMethodBeat.o(32394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpp
 * JD-Core Version:    0.7.0.1
 */