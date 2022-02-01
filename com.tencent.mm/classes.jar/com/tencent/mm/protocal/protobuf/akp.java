package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akp
  extends com.tencent.mm.bw.a
{
  public int dKW;
  public int index;
  public int otZ;
  public String query;
  public String rAT;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      paramVarArgs.aS(2, this.otZ);
      paramVarArgs.aS(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.d(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      if (this.rAT != null) {
        paramVarArgs.d(6, this.rAT);
      }
      paramVarArgs.aS(7, this.dKW);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0 + f.a.a.b.b.a.bz(2, this.otZ) + f.a.a.b.b.a.bz(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.query);
      }
      paramInt = i;
      if (this.rAT != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rAT);
      }
      i = f.a.a.b.b.a.bz(7, this.dKW);
      AppMethodBeat.o(127475);
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
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      akp localakp = (akp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localakp.scene = locala.OmT.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localakp.otZ = locala.OmT.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localakp.index = locala.OmT.zc();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localakp.sessionId = locala.OmT.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localakp.query = locala.OmT.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localakp.rAT = locala.OmT.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localakp.dKW = locala.OmT.zc();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akp
 * JD-Core Version:    0.7.0.1
 */