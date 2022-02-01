package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bzj
  extends com.tencent.mm.bw.a
{
  public float Hna;
  public float Hnb;
  public float Hnc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125746);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(1, this.Hna);
      paramVarArgs.y(2, this.Hnb);
      paramVarArgs.y(3, this.Hnc);
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(1);
      int i = f.a.a.b.b.a.amE(2);
      int j = f.a.a.b.b.a.amE(3);
      AppMethodBeat.o(125746);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125746);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bzj localbzj = (bzj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125746);
        return -1;
      case 1: 
        localbzj.Hna = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125746);
        return 0;
      case 2: 
        localbzj.Hnb = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(125746);
        return 0;
      }
      localbzj.Hnc = Float.intBitsToFloat(locala.OmT.gwb());
      AppMethodBeat.o(125746);
      return 0;
    }
    AppMethodBeat.o(125746);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzj
 * JD-Core Version:    0.7.0.1
 */