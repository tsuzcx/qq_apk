package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehd
  extends com.tencent.mm.bw.a
{
  public int IkQ;
  public int IkR;
  public int IkS;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208307);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.version);
      paramVarArgs.aS(2, this.IkQ);
      paramVarArgs.aS(3, this.IkR);
      paramVarArgs.aS(4, this.IkS);
      AppMethodBeat.o(208307);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.version);
      int i = f.a.a.b.b.a.bz(2, this.IkQ);
      int j = f.a.a.b.b.a.bz(3, this.IkR);
      int k = f.a.a.b.b.a.bz(4, this.IkS);
      AppMethodBeat.o(208307);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(208307);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehd localehd = (ehd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208307);
        return -1;
      case 1: 
        localehd.version = locala.OmT.zc();
        AppMethodBeat.o(208307);
        return 0;
      case 2: 
        localehd.IkQ = locala.OmT.zc();
        AppMethodBeat.o(208307);
        return 0;
      case 3: 
        localehd.IkR = locala.OmT.zc();
        AppMethodBeat.o(208307);
        return 0;
      }
      localehd.IkS = locala.OmT.zc();
      AppMethodBeat.o(208307);
      return 0;
    }
    AppMethodBeat.o(208307);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehd
 * JD-Core Version:    0.7.0.1
 */