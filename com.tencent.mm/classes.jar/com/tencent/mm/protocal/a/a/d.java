package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends com.tencent.mm.bx.a
{
  public int Crn;
  public com.tencent.mm.bx.b Crw;
  public int Crx;
  public int count;
  public int wmA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143943);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Crw == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Crn);
      if (this.Crw != null) {
        paramVarArgs.c(2, this.Crw);
      }
      paramVarArgs.aR(3, this.Crx);
      paramVarArgs.aR(4, this.wmA);
      paramVarArgs.aR(5, this.count);
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Crn) + 0;
      paramInt = i;
      if (this.Crw != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.Crw);
      }
      i = f.a.a.b.b.a.bA(3, this.Crx);
      int j = f.a.a.b.b.a.bA(4, this.wmA);
      int k = f.a.a.b.b.a.bA(5, this.count);
      AppMethodBeat.o(143943);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Crw == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: value");
        AppMethodBeat.o(143943);
        throw paramVarArgs;
      }
      AppMethodBeat.o(143943);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      d locald = (d)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(143943);
        return -1;
      case 1: 
        locald.Crn = locala.KhF.xS();
        AppMethodBeat.o(143943);
        return 0;
      case 2: 
        locald.Crw = locala.KhF.fMu();
        AppMethodBeat.o(143943);
        return 0;
      case 3: 
        locald.Crx = locala.KhF.xS();
        AppMethodBeat.o(143943);
        return 0;
      case 4: 
        locald.wmA = locala.KhF.xS();
        AppMethodBeat.o(143943);
        return 0;
      }
      locald.count = locala.KhF.xS();
      AppMethodBeat.o(143943);
      return 0;
    }
    AppMethodBeat.o(143943);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.d
 * JD-Core Version:    0.7.0.1
 */