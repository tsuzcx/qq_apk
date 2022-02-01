package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ezr
  extends com.tencent.mm.cd.a
{
  public String ORW;
  public String ORX;
  public String ORY;
  public int Utq;
  public int jDZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(250005);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.jDZ);
      if (this.ORW != null) {
        paramVarArgs.f(2, this.ORW);
      }
      if (this.ORX != null) {
        paramVarArgs.f(3, this.ORX);
      }
      if (this.ORY != null) {
        paramVarArgs.f(4, this.ORY);
      }
      paramVarArgs.aY(5, this.Utq);
      AppMethodBeat.o(250005);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.jDZ) + 0;
      paramInt = i;
      if (this.ORW != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.ORW);
      }
      i = paramInt;
      if (this.ORX != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ORX);
      }
      paramInt = i;
      if (this.ORY != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.ORY);
      }
      i = g.a.a.b.b.a.bM(5, this.Utq);
      AppMethodBeat.o(250005);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(250005);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ezr localezr = (ezr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(250005);
        return -1;
      case 1: 
        localezr.jDZ = locala.abFh.AK();
        AppMethodBeat.o(250005);
        return 0;
      case 2: 
        localezr.ORW = locala.abFh.readString();
        AppMethodBeat.o(250005);
        return 0;
      case 3: 
        localezr.ORX = locala.abFh.readString();
        AppMethodBeat.o(250005);
        return 0;
      case 4: 
        localezr.ORY = locala.abFh.readString();
        AppMethodBeat.o(250005);
        return 0;
      }
      localezr.Utq = locala.abFh.AK();
      AppMethodBeat.o(250005);
      return 0;
    }
    AppMethodBeat.o(250005);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezr
 * JD-Core Version:    0.7.0.1
 */