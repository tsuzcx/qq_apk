package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ami
  extends com.tencent.mm.bw.a
{
  public String GED;
  public long commentId;
  public long rRn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189313);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.rRn);
      paramVarArgs.aZ(2, this.commentId);
      if (this.GED != null) {
        paramVarArgs.d(3, this.GED);
      }
      AppMethodBeat.o(189313);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rRn) + 0 + f.a.a.b.b.a.p(2, this.commentId);
      paramInt = i;
      if (this.GED != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GED);
      }
      AppMethodBeat.o(189313);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189313);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ami localami = (ami)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189313);
        return -1;
      case 1: 
        localami.rRn = locala.OmT.zd();
        AppMethodBeat.o(189313);
        return 0;
      case 2: 
        localami.commentId = locala.OmT.zd();
        AppMethodBeat.o(189313);
        return 0;
      }
      localami.GED = locala.OmT.readString();
      AppMethodBeat.o(189313);
      return 0;
    }
    AppMethodBeat.o(189313);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ami
 * JD-Core Version:    0.7.0.1
 */