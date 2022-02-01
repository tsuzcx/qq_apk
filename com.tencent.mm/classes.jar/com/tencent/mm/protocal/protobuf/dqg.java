package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dqg
  extends com.tencent.mm.cd.a
{
  public String MD5;
  public int SXM;
  public String SXx;
  public int Svx;
  public int TWZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155451);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.SXM);
      if (this.SXx != null) {
        paramVarArgs.f(2, this.SXx);
      }
      if (this.MD5 != null) {
        paramVarArgs.f(3, this.MD5);
      }
      paramVarArgs.aY(4, this.Svx);
      paramVarArgs.aY(5, this.TWZ);
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.SXM) + 0;
      paramInt = i;
      if (this.SXx != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SXx);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.MD5);
      }
      paramInt = g.a.a.b.b.a.bM(4, this.Svx);
      int j = g.a.a.b.b.a.bM(5, this.TWZ);
      AppMethodBeat.o(155451);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(155451);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      dqg localdqg = (dqg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(155451);
        return -1;
      case 1: 
        localdqg.SXM = locala.abFh.AK();
        AppMethodBeat.o(155451);
        return 0;
      case 2: 
        localdqg.SXx = locala.abFh.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 3: 
        localdqg.MD5 = locala.abFh.readString();
        AppMethodBeat.o(155451);
        return 0;
      case 4: 
        localdqg.Svx = locala.abFh.AK();
        AppMethodBeat.o(155451);
        return 0;
      }
      localdqg.TWZ = locala.abFh.AK();
      AppMethodBeat.o(155451);
      return 0;
    }
    AppMethodBeat.o(155451);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqg
 * JD-Core Version:    0.7.0.1
 */