package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class pw
  extends com.tencent.mm.bw.a
{
  public b Gdu;
  public b Gdv;
  public int port;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133158);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      paramVarArgs.aS(2, this.port);
      if (this.Gdu != null) {
        paramVarArgs.c(3, this.Gdu);
      }
      if (this.Gdv != null) {
        paramVarArgs.c(4, this.Gdv);
      }
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0 + f.a.a.b.b.a.bz(2, this.port);
      paramInt = i;
      if (this.Gdu != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Gdu);
      }
      i = paramInt;
      if (this.Gdv != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.Gdv);
      }
      AppMethodBeat.o(133158);
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
      AppMethodBeat.o(133158);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      pw localpw = (pw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(133158);
        return -1;
      case 1: 
        localpw.type = locala.OmT.zc();
        AppMethodBeat.o(133158);
        return 0;
      case 2: 
        localpw.port = locala.OmT.zc();
        AppMethodBeat.o(133158);
        return 0;
      case 3: 
        localpw.Gdu = locala.OmT.gCk();
        AppMethodBeat.o(133158);
        return 0;
      }
      localpw.Gdv = locala.OmT.gCk();
      AppMethodBeat.o(133158);
      return 0;
    }
    AppMethodBeat.o(133158);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pw
 * JD-Core Version:    0.7.0.1
 */