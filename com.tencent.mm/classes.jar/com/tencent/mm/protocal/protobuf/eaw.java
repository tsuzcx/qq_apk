package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eaw
  extends com.tencent.mm.bw.a
{
  public String HdF;
  public long IgG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.IgG);
      if (this.HdF != null) {
        paramVarArgs.d(2, this.HdF);
      }
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.IgG) + 0;
      paramInt = i;
      if (this.HdF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HdF);
      }
      AppMethodBeat.o(147787);
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
      AppMethodBeat.o(147787);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eaw localeaw = (eaw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147787);
        return -1;
      case 1: 
        localeaw.IgG = locala.OmT.zd();
        AppMethodBeat.o(147787);
        return 0;
      }
      localeaw.HdF = locala.OmT.readString();
      AppMethodBeat.o(147787);
      return 0;
    }
    AppMethodBeat.o(147787);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */