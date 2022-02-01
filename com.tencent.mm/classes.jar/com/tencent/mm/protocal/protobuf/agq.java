package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class agq
  extends com.tencent.mm.bx.a
{
  public int dzK;
  public int index;
  public int niJ;
  public String pZZ;
  public String query;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.scene);
      paramVarArgs.aR(2, this.niJ);
      paramVarArgs.aR(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.d(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.d(5, this.query);
      }
      if (this.pZZ != null) {
        paramVarArgs.d(6, this.pZZ);
      }
      paramVarArgs.aR(7, this.dzK);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.scene) + 0 + f.a.a.b.b.a.bA(2, this.niJ) + f.a.a.b.b.a.bA(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.query);
      }
      paramInt = i;
      if (this.pZZ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.pZZ);
      }
      i = f.a.a.b.b.a.bA(7, this.dzK);
      AppMethodBeat.o(127475);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      agq localagq = (agq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localagq.scene = locala.KhF.xS();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localagq.niJ = locala.KhF.xS();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localagq.index = locala.KhF.xS();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localagq.sessionId = locala.KhF.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localagq.query = locala.KhF.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localagq.pZZ = locala.KhF.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localagq.dzK = locala.KhF.xS();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agq
 * JD-Core Version:    0.7.0.1
 */