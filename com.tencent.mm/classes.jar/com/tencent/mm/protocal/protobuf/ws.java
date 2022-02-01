package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ws
  extends com.tencent.mm.bx.a
{
  public int Scene;
  public String Version;
  public String sag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110847);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.sag == null)
      {
        paramVarArgs = new b("Not all required fields were included: PkgId");
        AppMethodBeat.o(110847);
        throw paramVarArgs;
      }
      if (this.sag != null) {
        paramVarArgs.d(1, this.sag);
      }
      if (this.Version != null) {
        paramVarArgs.d(2, this.Version);
      }
      paramVarArgs.aR(3, this.Scene);
      AppMethodBeat.o(110847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sag == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.sag) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Version != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Version);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.Scene);
      AppMethodBeat.o(110847);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.sag == null)
        {
          paramVarArgs = new b("Not all required fields were included: PkgId");
          AppMethodBeat.o(110847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110847);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ws localws = (ws)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(110847);
          return -1;
        case 1: 
          localws.sag = locala.KhF.readString();
          AppMethodBeat.o(110847);
          return 0;
        case 2: 
          localws.Version = locala.KhF.readString();
          AppMethodBeat.o(110847);
          return 0;
        }
        localws.Scene = locala.KhF.xS();
        AppMethodBeat.o(110847);
        return 0;
      }
      AppMethodBeat.o(110847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ws
 * JD-Core Version:    0.7.0.1
 */