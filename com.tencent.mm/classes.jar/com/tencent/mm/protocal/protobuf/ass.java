package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ass
  extends com.tencent.mm.bw.a
{
  public int GEB;
  public long GJI;
  public String GJJ;
  public String GJK;
  public String GJL;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189413);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.GJI);
      if (this.GJJ != null) {
        paramVarArgs.d(2, this.GJJ);
      }
      paramVarArgs.aS(3, this.GEB);
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.GJK != null) {
        paramVarArgs.d(5, this.GJK);
      }
      if (this.GJL != null) {
        paramVarArgs.d(6, this.GJL);
      }
      AppMethodBeat.o(189413);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.GJI) + 0;
      paramInt = i;
      if (this.GJJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GJJ);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.GEB);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.username);
      }
      i = paramInt;
      if (this.GJK != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GJK);
      }
      paramInt = i;
      if (this.GJL != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GJL);
      }
      AppMethodBeat.o(189413);
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
      AppMethodBeat.o(189413);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ass localass = (ass)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189413);
        return -1;
      case 1: 
        localass.GJI = locala.OmT.zd();
        AppMethodBeat.o(189413);
        return 0;
      case 2: 
        localass.GJJ = locala.OmT.readString();
        AppMethodBeat.o(189413);
        return 0;
      case 3: 
        localass.GEB = locala.OmT.zc();
        AppMethodBeat.o(189413);
        return 0;
      case 4: 
        localass.username = locala.OmT.readString();
        AppMethodBeat.o(189413);
        return 0;
      case 5: 
        localass.GJK = locala.OmT.readString();
        AppMethodBeat.o(189413);
        return 0;
      }
      localass.GJL = locala.OmT.readString();
      AppMethodBeat.o(189413);
      return 0;
    }
    AppMethodBeat.o(189413);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */