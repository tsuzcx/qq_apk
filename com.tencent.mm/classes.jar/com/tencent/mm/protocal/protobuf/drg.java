package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drg
  extends com.tencent.mm.bw.a
{
  public int density;
  public String resolution;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116475);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.resolution != null) {
        paramVarArgs.e(1, this.resolution);
      }
      paramVarArgs.aM(2, this.density);
      AppMethodBeat.o(116475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.resolution == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.f(1, this.resolution) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.density);
      AppMethodBeat.o(116475);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116475);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        drg localdrg = (drg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116475);
          return -1;
        case 1: 
          localdrg.resolution = locala.UbS.readString();
          AppMethodBeat.o(116475);
          return 0;
        }
        localdrg.density = locala.UbS.zi();
        AppMethodBeat.o(116475);
        return 0;
      }
      AppMethodBeat.o(116475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drg
 * JD-Core Version:    0.7.0.1
 */