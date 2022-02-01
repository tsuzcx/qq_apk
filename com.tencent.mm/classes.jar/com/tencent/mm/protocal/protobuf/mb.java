package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class mb
  extends com.tencent.mm.bx.a
{
  public String FES;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207218);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      if (this.path != null) {
        paramVarArgs.d(2, this.path);
      }
      if (this.FES != null) {
        paramVarArgs.d(3, this.FES);
      }
      AppMethodBeat.o(207218);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.path);
      }
      i = paramInt;
      if (this.FES != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FES);
      }
      AppMethodBeat.o(207218);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207218);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        mb localmb = (mb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207218);
          return -1;
        case 1: 
          localmb.username = locala.NPN.readString();
          AppMethodBeat.o(207218);
          return 0;
        case 2: 
          localmb.path = locala.NPN.readString();
          AppMethodBeat.o(207218);
          return 0;
        }
        localmb.FES = locala.NPN.readString();
        AppMethodBeat.o(207218);
        return 0;
      }
      AppMethodBeat.o(207218);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mb
 * JD-Core Version:    0.7.0.1
 */