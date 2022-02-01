package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class and
  extends com.tencent.mm.bw.a
{
  public int ecL;
  public int index;
  public int pHw;
  public String query;
  public int scene;
  public String sessionId;
  public String tay;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.scene);
      paramVarArgs.aM(2, this.pHw);
      paramVarArgs.aM(3, this.index);
      if (this.sessionId != null) {
        paramVarArgs.e(4, this.sessionId);
      }
      if (this.query != null) {
        paramVarArgs.e(5, this.query);
      }
      if (this.tay != null) {
        paramVarArgs.e(6, this.tay);
      }
      paramVarArgs.aM(7, this.ecL);
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.scene) + 0 + g.a.a.b.b.a.bu(2, this.pHw) + g.a.a.b.b.a.bu(3, this.index);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.sessionId);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.query);
      }
      paramInt = i;
      if (this.tay != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.tay);
      }
      i = g.a.a.b.b.a.bu(7, this.ecL);
      AppMethodBeat.o(127475);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(127475);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      and localand = (and)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127475);
        return -1;
      case 1: 
        localand.scene = locala.UbS.zi();
        AppMethodBeat.o(127475);
        return 0;
      case 2: 
        localand.pHw = locala.UbS.zi();
        AppMethodBeat.o(127475);
        return 0;
      case 3: 
        localand.index = locala.UbS.zi();
        AppMethodBeat.o(127475);
        return 0;
      case 4: 
        localand.sessionId = locala.UbS.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 5: 
        localand.query = locala.UbS.readString();
        AppMethodBeat.o(127475);
        return 0;
      case 6: 
        localand.tay = locala.UbS.readString();
        AppMethodBeat.o(127475);
        return 0;
      }
      localand.ecL = locala.UbS.zi();
      AppMethodBeat.o(127475);
      return 0;
    }
    AppMethodBeat.o(127475);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.and
 * JD-Core Version:    0.7.0.1
 */