package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bgi
  extends com.tencent.mm.cd.a
{
  public int SRe;
  public int SRf;
  public int SRg;
  public int SRh;
  public int SRi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200906);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SRe);
      paramVarArgs.aY(2, this.SRf);
      paramVarArgs.aY(3, this.SRg);
      paramVarArgs.aY(4, this.SRh);
      paramVarArgs.aY(5, this.SRi);
      AppMethodBeat.o(200906);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.SRe);
      int i = g.a.a.b.b.a.bM(2, this.SRf);
      int j = g.a.a.b.b.a.bM(3, this.SRg);
      int k = g.a.a.b.b.a.bM(4, this.SRh);
      int m = g.a.a.b.b.a.bM(5, this.SRi);
      AppMethodBeat.o(200906);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(200906);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bgi localbgi = (bgi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(200906);
        return -1;
      case 1: 
        localbgi.SRe = locala.abFh.AK();
        AppMethodBeat.o(200906);
        return 0;
      case 2: 
        localbgi.SRf = locala.abFh.AK();
        AppMethodBeat.o(200906);
        return 0;
      case 3: 
        localbgi.SRg = locala.abFh.AK();
        AppMethodBeat.o(200906);
        return 0;
      case 4: 
        localbgi.SRh = locala.abFh.AK();
        AppMethodBeat.o(200906);
        return 0;
      }
      localbgi.SRi = locala.abFh.AK();
      AppMethodBeat.o(200906);
      return 0;
    }
    AppMethodBeat.o(200906);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgi
 * JD-Core Version:    0.7.0.1
 */