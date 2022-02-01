package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dna
  extends com.tencent.mm.bw.a
{
  public int HUj;
  public String HUk;
  public int Hzv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.HUj);
      paramVarArgs.aS(2, this.Hzv);
      if (this.HUk != null) {
        paramVarArgs.d(3, this.HUk);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.HUj) + 0 + f.a.a.b.b.a.bz(2, this.Hzv);
      paramInt = i;
      if (this.HUk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.HUk);
      }
      AppMethodBeat.o(32466);
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
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dna localdna = (dna)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localdna.HUj = locala.OmT.zc();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localdna.Hzv = locala.OmT.zc();
        AppMethodBeat.o(32466);
        return 0;
      }
      localdna.HUk = locala.OmT.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dna
 * JD-Core Version:    0.7.0.1
 */