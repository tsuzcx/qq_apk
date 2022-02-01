package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class det
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> HLR;
  public LinkedList<String> HLT;
  public LinkedList<Integer> HLU;
  public LinkedList<Integer> HLV;
  
  public det()
  {
    AppMethodBeat.i(114079);
    this.HLR = new LinkedList();
    this.HLT = new LinkedList();
    this.HLU = new LinkedList();
    this.HLV = new LinkedList();
    AppMethodBeat.o(114079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114080);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.HLR);
      paramVarArgs.e(2, 1, this.HLT);
      paramVarArgs.e(3, 2, this.HLU);
      paramVarArgs.e(4, 2, this.HLV);
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.HLR);
      int i = f.a.a.a.c(2, 1, this.HLT);
      int j = f.a.a.a.c(3, 2, this.HLU);
      int k = f.a.a.a.c(4, 2, this.HLV);
      AppMethodBeat.o(114080);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HLR.clear();
      this.HLT.clear();
      this.HLU.clear();
      this.HLV.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(114080);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      det localdet = (det)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(114080);
        return -1;
      case 1: 
        localdet.HLR.add(locala.OmT.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 2: 
        localdet.HLT.add(locala.OmT.readString());
        AppMethodBeat.o(114080);
        return 0;
      case 3: 
        localdet.HLU.add(Integer.valueOf(locala.OmT.zc()));
        AppMethodBeat.o(114080);
        return 0;
      }
      localdet.HLV.add(Integer.valueOf(locala.OmT.zc()));
      AppMethodBeat.o(114080);
      return 0;
    }
    AppMethodBeat.o(114080);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.det
 * JD-Core Version:    0.7.0.1
 */