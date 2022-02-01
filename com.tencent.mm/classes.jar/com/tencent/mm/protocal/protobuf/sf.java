package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class sf
  extends com.tencent.mm.bx.a
{
  public int YXd;
  public int YXe;
  public int YXf;
  public int eQp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91367);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.eQp);
      paramVarArgs.bS(2, this.YXd);
      paramVarArgs.bS(3, this.YXe);
      paramVarArgs.bS(4, this.YXf);
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.eQp);
      int i = i.a.a.b.b.a.cJ(2, this.YXd);
      int j = i.a.a.b.b.a.cJ(3, this.YXe);
      int k = i.a.a.b.b.a.cJ(4, this.YXf);
      AppMethodBeat.o(91367);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91367);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      sf localsf = (sf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91367);
        return -1;
      case 1: 
        localsf.eQp = locala.ajGk.aar();
        AppMethodBeat.o(91367);
        return 0;
      case 2: 
        localsf.YXd = locala.ajGk.aar();
        AppMethodBeat.o(91367);
        return 0;
      case 3: 
        localsf.YXe = locala.ajGk.aar();
        AppMethodBeat.o(91367);
        return 0;
      }
      localsf.YXf = locala.ajGk.aar();
      AppMethodBeat.o(91367);
      return 0;
    }
    AppMethodBeat.o(91367);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sf
 * JD-Core Version:    0.7.0.1
 */