package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class z
  extends com.tencent.mm.bw.a
{
  public int FIU;
  public String kCZ;
  public String kDa;
  public String vCG;
  public String vCH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91339);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FIU);
      if (this.vCG != null) {
        paramVarArgs.d(2, this.vCG);
      }
      if (this.kCZ != null) {
        paramVarArgs.d(3, this.kCZ);
      }
      if (this.kDa != null) {
        paramVarArgs.d(4, this.kDa);
      }
      if (this.vCH != null) {
        paramVarArgs.d(5, this.vCH);
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FIU) + 0;
      paramInt = i;
      if (this.vCG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.vCG);
      }
      i = paramInt;
      if (this.kCZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.kCZ);
      }
      paramInt = i;
      if (this.kDa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.kDa);
      }
      i = paramInt;
      if (this.vCH != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.vCH);
      }
      AppMethodBeat.o(91339);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91339);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      z localz = (z)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91339);
        return -1;
      case 1: 
        localz.FIU = locala.OmT.zc();
        AppMethodBeat.o(91339);
        return 0;
      case 2: 
        localz.vCG = locala.OmT.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 3: 
        localz.kCZ = locala.OmT.readString();
        AppMethodBeat.o(91339);
        return 0;
      case 4: 
        localz.kDa = locala.OmT.readString();
        AppMethodBeat.o(91339);
        return 0;
      }
      localz.vCH = locala.OmT.readString();
      AppMethodBeat.o(91339);
      return 0;
    }
    AppMethodBeat.o(91339);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.z
 * JD-Core Version:    0.7.0.1
 */