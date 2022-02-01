package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cey
  extends com.tencent.mm.bw.a
{
  public int Gdy;
  public int GqB;
  public int HrH;
  public String HrI;
  public String HrK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43114);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gdy);
      if (this.HrK != null) {
        paramVarArgs.d(3, this.HrK);
      }
      paramVarArgs.aS(4, this.HrH);
      paramVarArgs.aS(5, this.GqB);
      if (this.HrI != null) {
        paramVarArgs.d(6, this.HrI);
      }
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gdy) + 0;
      paramInt = i;
      if (this.HrK != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HrK);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.HrH) + f.a.a.b.b.a.bz(5, this.GqB);
      paramInt = i;
      if (this.HrI != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HrI);
      }
      AppMethodBeat.o(43114);
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
      AppMethodBeat.o(43114);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cey localcey = (cey)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 2: 
      default: 
        AppMethodBeat.o(43114);
        return -1;
      case 1: 
        localcey.Gdy = locala.OmT.zc();
        AppMethodBeat.o(43114);
        return 0;
      case 3: 
        localcey.HrK = locala.OmT.readString();
        AppMethodBeat.o(43114);
        return 0;
      case 4: 
        localcey.HrH = locala.OmT.zc();
        AppMethodBeat.o(43114);
        return 0;
      case 5: 
        localcey.GqB = locala.OmT.zc();
        AppMethodBeat.o(43114);
        return 0;
      }
      localcey.HrI = locala.OmT.readString();
      AppMethodBeat.o(43114);
      return 0;
    }
    AppMethodBeat.o(43114);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cey
 * JD-Core Version:    0.7.0.1
 */