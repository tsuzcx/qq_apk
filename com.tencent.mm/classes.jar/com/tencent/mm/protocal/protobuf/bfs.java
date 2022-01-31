package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfs
  extends com.tencent.mm.bv.a
{
  public String path;
  public int type;
  public String username;
  public int wAy;
  public String xuE;
  public String xuF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96278);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.e(1, this.username);
      }
      if (this.xuE != null) {
        paramVarArgs.e(2, this.xuE);
      }
      if (this.xuF != null) {
        paramVarArgs.e(3, this.xuF);
      }
      if (this.path != null) {
        paramVarArgs.e(4, this.path);
      }
      paramVarArgs.aO(5, this.wAy);
      paramVarArgs.aO(6, this.type);
      AppMethodBeat.o(96278);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label486;
      }
    }
    label486:
    for (int i = e.a.a.b.b.a.f(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xuE != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xuE);
      }
      i = paramInt;
      if (this.xuF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xuF);
      }
      paramInt = i;
      if (this.path != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.path);
      }
      i = e.a.a.b.b.a.bl(5, this.wAy);
      int j = e.a.a.b.b.a.bl(6, this.type);
      AppMethodBeat.o(96278);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96278);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bfs localbfs = (bfs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96278);
          return -1;
        case 1: 
          localbfs.username = locala.CLY.readString();
          AppMethodBeat.o(96278);
          return 0;
        case 2: 
          localbfs.xuE = locala.CLY.readString();
          AppMethodBeat.o(96278);
          return 0;
        case 3: 
          localbfs.xuF = locala.CLY.readString();
          AppMethodBeat.o(96278);
          return 0;
        case 4: 
          localbfs.path = locala.CLY.readString();
          AppMethodBeat.o(96278);
          return 0;
        case 5: 
          localbfs.wAy = locala.CLY.sl();
          AppMethodBeat.o(96278);
          return 0;
        }
        localbfs.type = locala.CLY.sl();
        AppMethodBeat.o(96278);
        return 0;
      }
      AppMethodBeat.o(96278);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfs
 * JD-Core Version:    0.7.0.1
 */