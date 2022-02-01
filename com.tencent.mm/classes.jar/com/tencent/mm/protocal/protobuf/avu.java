package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class avu
  extends com.tencent.mm.bw.a
{
  public int GMK;
  public int GMS;
  public String GMU;
  public String GMV;
  public String GMW;
  public String GMX;
  public int Scene;
  public String ikm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GMS);
      if (this.GMU != null) {
        paramVarArgs.d(2, this.GMU);
      }
      if (this.ikm != null) {
        paramVarArgs.d(3, this.ikm);
      }
      if (this.GMV != null) {
        paramVarArgs.d(4, this.GMV);
      }
      if (this.GMW != null) {
        paramVarArgs.d(5, this.GMW);
      }
      if (this.GMX != null) {
        paramVarArgs.d(7, this.GMX);
      }
      paramVarArgs.aS(8, this.GMK);
      paramVarArgs.aS(9, this.Scene);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GMS) + 0;
      paramInt = i;
      if (this.GMU != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GMU);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ikm);
      }
      paramInt = i;
      if (this.GMV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GMV);
      }
      i = paramInt;
      if (this.GMW != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GMW);
      }
      paramInt = i;
      if (this.GMX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GMX);
      }
      i = f.a.a.b.b.a.bz(8, this.GMK);
      int j = f.a.a.b.b.a.bz(9, this.Scene);
      AppMethodBeat.o(152546);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      avu localavu = (avu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localavu.GMS = locala.OmT.zc();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localavu.GMU = locala.OmT.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localavu.ikm = locala.OmT.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localavu.GMV = locala.OmT.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localavu.GMW = locala.OmT.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localavu.GMX = locala.OmT.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localavu.GMK = locala.OmT.zc();
        AppMethodBeat.o(152546);
        return 0;
      }
      localavu.Scene = locala.OmT.zc();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avu
 * JD-Core Version:    0.7.0.1
 */