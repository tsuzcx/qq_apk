package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajp
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public long HlH;
  public int HmZ;
  public int Hna;
  public String MD5;
  public int Suc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109447);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      paramVarArgs.aY(2, this.Hna);
      paramVarArgs.aY(3, this.HmZ);
      if (this.MD5 != null) {
        paramVarArgs.f(4, this.MD5);
      }
      paramVarArgs.aY(5, this.Suc);
      paramVarArgs.bm(6, this.HlH);
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CqV) + 0 + g.a.a.b.b.a.bM(2, this.Hna) + g.a.a.b.b.a.bM(3, this.HmZ);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.MD5);
      }
      i = g.a.a.b.b.a.bM(5, this.Suc);
      int j = g.a.a.b.b.a.p(6, this.HlH);
      AppMethodBeat.o(109447);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(109447);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ajp localajp = (ajp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(109447);
        return -1;
      case 1: 
        localajp.CqV = locala.abFh.AK();
        AppMethodBeat.o(109447);
        return 0;
      case 2: 
        localajp.Hna = locala.abFh.AK();
        AppMethodBeat.o(109447);
        return 0;
      case 3: 
        localajp.HmZ = locala.abFh.AK();
        AppMethodBeat.o(109447);
        return 0;
      case 4: 
        localajp.MD5 = locala.abFh.readString();
        AppMethodBeat.o(109447);
        return 0;
      case 5: 
        localajp.Suc = locala.abFh.AK();
        AppMethodBeat.o(109447);
        return 0;
      }
      localajp.HlH = locala.abFh.AN();
      AppMethodBeat.o(109447);
      return 0;
    }
    AppMethodBeat.o(109447);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajp
 * JD-Core Version:    0.7.0.1
 */