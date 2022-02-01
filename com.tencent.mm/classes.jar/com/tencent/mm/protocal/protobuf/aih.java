package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aih
  extends com.tencent.mm.bw.a
{
  public int GxS;
  public String GxT;
  public String GxU;
  public String GxV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32199);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GxS);
      if (this.GxT != null) {
        paramVarArgs.d(2, this.GxT);
      }
      if (this.GxU != null) {
        paramVarArgs.d(3, this.GxU);
      }
      if (this.GxV != null) {
        paramVarArgs.d(4, this.GxV);
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.GxS) + 0;
      paramInt = i;
      if (this.GxT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GxT);
      }
      i = paramInt;
      if (this.GxU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GxU);
      }
      paramInt = i;
      if (this.GxV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GxV);
      }
      AppMethodBeat.o(32199);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32199);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aih localaih = (aih)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32199);
        return -1;
      case 1: 
        localaih.GxS = locala.OmT.zc();
        AppMethodBeat.o(32199);
        return 0;
      case 2: 
        localaih.GxT = locala.OmT.readString();
        AppMethodBeat.o(32199);
        return 0;
      case 3: 
        localaih.GxU = locala.OmT.readString();
        AppMethodBeat.o(32199);
        return 0;
      }
      localaih.GxV = locala.OmT.readString();
      AppMethodBeat.o(32199);
      return 0;
    }
    AppMethodBeat.o(32199);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aih
 * JD-Core Version:    0.7.0.1
 */