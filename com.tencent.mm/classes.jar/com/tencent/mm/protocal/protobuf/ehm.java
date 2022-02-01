package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehm
  extends com.tencent.mm.bw.a
{
  public long NgY;
  public long NgZ;
  public int Nha;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125848);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NgY);
      paramVarArgs.bb(2, this.NgZ);
      paramVarArgs.aM(3, this.Nha);
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.r(1, this.NgY);
      int i = g.a.a.b.b.a.r(2, this.NgZ);
      int j = g.a.a.b.b.a.bu(3, this.Nha);
      AppMethodBeat.o(125848);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125848);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ehm localehm = (ehm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125848);
        return -1;
      case 1: 
        localehm.NgY = locala.UbS.zl();
        AppMethodBeat.o(125848);
        return 0;
      case 2: 
        localehm.NgZ = locala.UbS.zl();
        AppMethodBeat.o(125848);
        return 0;
      }
      localehm.Nha = locala.UbS.zi();
      AppMethodBeat.o(125848);
      return 0;
    }
    AppMethodBeat.o(125848);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehm
 * JD-Core Version:    0.7.0.1
 */