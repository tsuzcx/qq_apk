package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmx
  extends com.tencent.mm.bx.a
{
  public int EDv;
  public int EDw;
  public int EDx;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115903);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.mBH);
      paramVarArgs.aR(2, this.EDv);
      paramVarArgs.aR(3, this.EDw);
      paramVarArgs.aR(4, this.EDx);
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.mBH);
      int i = f.a.a.b.b.a.bA(2, this.EDv);
      int j = f.a.a.b.b.a.bA(3, this.EDw);
      int k = f.a.a.b.b.a.bA(4, this.EDx);
      AppMethodBeat.o(115903);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(115903);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dmx localdmx = (dmx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115903);
        return -1;
      case 1: 
        localdmx.mBH = locala.KhF.xS();
        AppMethodBeat.o(115903);
        return 0;
      case 2: 
        localdmx.EDv = locala.KhF.xS();
        AppMethodBeat.o(115903);
        return 0;
      case 3: 
        localdmx.EDw = locala.KhF.xS();
        AppMethodBeat.o(115903);
        return 0;
      }
      localdmx.EDx = locala.KhF.xS();
      AppMethodBeat.o(115903);
      return 0;
    }
    AppMethodBeat.o(115903);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmx
 * JD-Core Version:    0.7.0.1
 */