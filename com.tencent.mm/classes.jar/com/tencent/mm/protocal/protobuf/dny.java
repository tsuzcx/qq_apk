package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dny
  extends com.tencent.mm.bw.a
{
  public String path;
  public String username;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91716);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(2, this.path);
      }
      paramVarArgs.aS(3, this.version);
      AppMethodBeat.o(91716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.path != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.path);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.version);
      AppMethodBeat.o(91716);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91716);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dny localdny = (dny)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91716);
          return -1;
        case 1: 
          localdny.username = locala.OmT.readString();
          AppMethodBeat.o(91716);
          return 0;
        case 2: 
          localdny.path = locala.OmT.readString();
          AppMethodBeat.o(91716);
          return 0;
        }
        localdny.version = locala.OmT.zc();
        AppMethodBeat.o(91716);
        return 0;
      }
      AppMethodBeat.o(91716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dny
 * JD-Core Version:    0.7.0.1
 */