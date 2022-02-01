package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bea
  extends com.tencent.mm.cd.a
{
  public float SPf;
  public float SPg;
  public float SPh;
  public float SPi;
  public float SPj;
  public boolean SPk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(208094);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(1, this.SPf);
      paramVarArgs.i(2, this.SPg);
      paramVarArgs.i(3, this.SPh);
      paramVarArgs.i(4, this.SPi);
      paramVarArgs.i(5, this.SPj);
      paramVarArgs.co(6, this.SPk);
      AppMethodBeat.o(208094);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(1);
      int i = g.a.a.b.b.a.gL(2);
      int j = g.a.a.b.b.a.gL(3);
      int k = g.a.a.b.b.a.gL(4);
      int m = g.a.a.b.b.a.gL(5);
      int n = g.a.a.b.b.a.gL(6);
      AppMethodBeat.o(208094);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + (m + 4) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(208094);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bea localbea = (bea)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(208094);
        return -1;
      case 1: 
        localbea.SPf = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208094);
        return 0;
      case 2: 
        localbea.SPg = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208094);
        return 0;
      case 3: 
        localbea.SPh = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208094);
        return 0;
      case 4: 
        localbea.SPi = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208094);
        return 0;
      case 5: 
        localbea.SPj = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(208094);
        return 0;
      }
      localbea.SPk = locala.abFh.AB();
      AppMethodBeat.o(208094);
      return 0;
    }
    AppMethodBeat.o(208094);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bea
 * JD-Core Version:    0.7.0.1
 */