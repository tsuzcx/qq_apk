package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aps
  extends com.tencent.mm.bw.a
{
  public String LBC;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209358);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LBC != null) {
        paramVarArgs.e(1, this.LBC);
      }
      if (this.session_id != null) {
        paramVarArgs.e(2, this.session_id);
      }
      AppMethodBeat.o(209358);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LBC == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = g.a.a.b.b.a.f(1, this.LBC) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.session_id != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.session_id);
      }
      AppMethodBeat.o(209358);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209358);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        aps localaps = (aps)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209358);
          return -1;
        case 1: 
          localaps.LBC = locala.UbS.readString();
          AppMethodBeat.o(209358);
          return 0;
        }
        localaps.session_id = locala.UbS.readString();
        AppMethodBeat.o(209358);
        return 0;
      }
      AppMethodBeat.o(209358);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aps
 * JD-Core Version:    0.7.0.1
 */