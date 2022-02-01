package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alw
  extends com.tencent.mm.bx.a
{
  public String GlB;
  public long commentId;
  public long rIZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209273);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.rIZ);
      paramVarArgs.aY(2, this.commentId);
      if (this.GlB != null) {
        paramVarArgs.d(3, this.GlB);
      }
      AppMethodBeat.o(209273);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.rIZ) + 0 + f.a.a.b.b.a.p(2, this.commentId);
      paramInt = i;
      if (this.GlB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GlB);
      }
      AppMethodBeat.o(209273);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209273);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alw localalw = (alw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209273);
        return -1;
      case 1: 
        localalw.rIZ = locala.NPN.zd();
        AppMethodBeat.o(209273);
        return 0;
      case 2: 
        localalw.commentId = locala.NPN.zd();
        AppMethodBeat.o(209273);
        return 0;
      }
      localalw.GlB = locala.NPN.readString();
      AppMethodBeat.o(209273);
      return 0;
    }
    AppMethodBeat.o(209273);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alw
 * JD-Core Version:    0.7.0.1
 */