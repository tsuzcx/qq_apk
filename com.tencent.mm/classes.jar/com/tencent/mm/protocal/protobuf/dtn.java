package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtn
  extends com.tencent.mm.bx.a
{
  public int CLK;
  public int EIk;
  public String md5;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123680);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EIk);
      paramVarArgs.aR(2, this.CLK);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.md5 != null) {
        paramVarArgs.d(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EIk) + 0 + f.a.a.b.b.a.bA(2, this.CLK);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.md5);
      }
      AppMethodBeat.o(123680);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(123680);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dtn localdtn = (dtn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123680);
        return -1;
      case 1: 
        localdtn.EIk = locala.KhF.xS();
        AppMethodBeat.o(123680);
        return 0;
      case 2: 
        localdtn.CLK = locala.KhF.xS();
        AppMethodBeat.o(123680);
        return 0;
      case 3: 
        localdtn.url = locala.KhF.readString();
        AppMethodBeat.o(123680);
        return 0;
      }
      localdtn.md5 = locala.KhF.readString();
      AppMethodBeat.o(123680);
      return 0;
    }
    AppMethodBeat.o(123680);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtn
 * JD-Core Version:    0.7.0.1
 */