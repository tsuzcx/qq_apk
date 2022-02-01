package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqh
  extends com.tencent.mm.bw.a
{
  public String dsk;
  public int scene;
  public String sessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195195);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.scene);
      if (this.dsk != null) {
        paramVarArgs.d(2, this.dsk);
      }
      if (this.sessionId != null) {
        paramVarArgs.d(3, this.sessionId);
      }
      AppMethodBeat.o(195195);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.scene) + 0;
      paramInt = i;
      if (this.dsk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dsk);
      }
      i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sessionId);
      }
      AppMethodBeat.o(195195);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(195195);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqh localaqh = (aqh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195195);
        return -1;
      case 1: 
        localaqh.scene = locala.OmT.zc();
        AppMethodBeat.o(195195);
        return 0;
      case 2: 
        localaqh.dsk = locala.OmT.readString();
        AppMethodBeat.o(195195);
        return 0;
      }
      localaqh.sessionId = locala.OmT.readString();
      AppMethodBeat.o(195195);
      return 0;
    }
    AppMethodBeat.o(195195);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */