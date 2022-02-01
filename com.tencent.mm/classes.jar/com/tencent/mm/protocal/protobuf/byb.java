package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class byb
  extends com.tencent.mm.bw.a
{
  public String GWB;
  public String GeS;
  public long HkQ;
  public long HkR;
  public int nJA;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      if (this.GWB != null) {
        paramVarArgs.d(2, this.GWB);
      }
      paramVarArgs.aZ(3, this.HkQ);
      paramVarArgs.aZ(4, this.HkR);
      if (this.GeS != null) {
        paramVarArgs.d(5, this.GeS);
      }
      paramVarArgs.aS(6, this.nJA);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0;
      paramInt = i;
      if (this.GWB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GWB);
      }
      i = paramInt + f.a.a.b.b.a.p(3, this.HkQ) + f.a.a.b.b.a.p(4, this.HkR);
      paramInt = i;
      if (this.GeS != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GeS);
      }
      i = f.a.a.b.b.a.bz(6, this.nJA);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byb localbyb = (byb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localbyb.scene = locala.OmT.zc();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localbyb.GWB = locala.OmT.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localbyb.HkQ = locala.OmT.zd();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localbyb.HkR = locala.OmT.zd();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localbyb.GeS = locala.OmT.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localbyb.nJA = locala.OmT.zc();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byb
 * JD-Core Version:    0.7.0.1
 */