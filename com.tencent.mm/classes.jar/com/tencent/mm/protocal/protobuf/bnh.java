package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bnh
  extends com.tencent.mm.bv.a
{
  public String path;
  public String query;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114981);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.e(1, this.path);
      }
      if (this.query != null) {
        paramVarArgs.e(2, this.query);
      }
      paramVarArgs.aO(3, this.scene);
      AppMethodBeat.o(114981);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.query != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.query);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.scene);
      AppMethodBeat.o(114981);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(114981);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bnh localbnh = (bnh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(114981);
          return -1;
        case 1: 
          localbnh.path = locala.CLY.readString();
          AppMethodBeat.o(114981);
          return 0;
        case 2: 
          localbnh.query = locala.CLY.readString();
          AppMethodBeat.o(114981);
          return 0;
        }
        localbnh.scene = locala.CLY.sl();
        AppMethodBeat.o(114981);
        return 0;
      }
      AppMethodBeat.o(114981);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnh
 * JD-Core Version:    0.7.0.1
 */