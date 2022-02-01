package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class egc
  extends com.tencent.mm.bx.a
{
  public String path;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153293);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.g(1, this.path);
      }
      if (this.query != null) {
        paramVarArgs.g(2, this.query);
      }
      paramVarArgs.bS(3, this.scene);
      AppMethodBeat.o(153293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.query);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.scene);
      AppMethodBeat.o(153293);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153293);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        egc localegc = (egc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153293);
          return -1;
        case 1: 
          localegc.path = locala.ajGk.readString();
          AppMethodBeat.o(153293);
          return 0;
        case 2: 
          localegc.query = locala.ajGk.readString();
          AppMethodBeat.o(153293);
          return 0;
        }
        localegc.scene = locala.ajGk.aar();
        AppMethodBeat.o(153293);
        return 0;
      }
      AppMethodBeat.o(153293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egc
 * JD-Core Version:    0.7.0.1
 */