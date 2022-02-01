package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ddx
  extends com.tencent.mm.bw.a
{
  public String path;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      if (this.query != null) {
        paramVarArgs.e(2, this.query);
      }
      paramVarArgs.aM(3, this.scene);
      AppMethodBeat.o(153293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.query);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.scene);
      AppMethodBeat.o(153293);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153293);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ddx localddx = (ddx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153293);
          return -1;
        case 1: 
          localddx.path = locala.UbS.readString();
          AppMethodBeat.o(153293);
          return 0;
        case 2: 
          localddx.query = locala.UbS.readString();
          AppMethodBeat.o(153293);
          return 0;
        }
        localddx.scene = locala.UbS.zi();
        AppMethodBeat.o(153293);
        return 0;
      }
      AppMethodBeat.o(153293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddx
 * JD-Core Version:    0.7.0.1
 */