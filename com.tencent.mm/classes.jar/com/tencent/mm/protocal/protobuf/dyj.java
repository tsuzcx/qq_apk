package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dyj
  extends com.tencent.mm.bw.a
{
  public String MXX;
  public String MXY;
  public String MXZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32455);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MXX != null) {
        paramVarArgs.e(1, this.MXX);
      }
      if (this.MXY != null) {
        paramVarArgs.e(2, this.MXY);
      }
      if (this.MXZ != null) {
        paramVarArgs.e(3, this.MXZ);
      }
      AppMethodBeat.o(32455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MXX == null) {
        break label343;
      }
    }
    label343:
    for (int i = g.a.a.b.b.a.f(1, this.MXX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MXY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MXY);
      }
      i = paramInt;
      if (this.MXZ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MXZ);
      }
      AppMethodBeat.o(32455);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32455);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dyj localdyj = (dyj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32455);
          return -1;
        case 1: 
          localdyj.MXX = locala.UbS.readString();
          AppMethodBeat.o(32455);
          return 0;
        case 2: 
          localdyj.MXY = locala.UbS.readString();
          AppMethodBeat.o(32455);
          return 0;
        }
        localdyj.MXZ = locala.UbS.readString();
        AppMethodBeat.o(32455);
        return 0;
      }
      AppMethodBeat.o(32455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyj
 * JD-Core Version:    0.7.0.1
 */