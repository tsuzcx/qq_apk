package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajv
  extends com.tencent.mm.cd.a
{
  public String DSF;
  public int Height;
  public String Tem;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104769);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.DSF != null) {
        paramVarArgs.f(1, this.DSF);
      }
      paramVarArgs.aY(2, this.Width);
      paramVarArgs.aY(3, this.Height);
      if (this.Tem != null) {
        paramVarArgs.f(4, this.Tem);
      }
      AppMethodBeat.o(104769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSF == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = g.a.a.b.b.a.g(1, this.DSF) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Width) + g.a.a.b.b.a.bM(3, this.Height);
      paramInt = i;
      if (this.Tem != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tem);
      }
      AppMethodBeat.o(104769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(104769);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ajv localajv = (ajv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104769);
          return -1;
        case 1: 
          localajv.DSF = locala.abFh.readString();
          AppMethodBeat.o(104769);
          return 0;
        case 2: 
          localajv.Width = locala.abFh.AK();
          AppMethodBeat.o(104769);
          return 0;
        case 3: 
          localajv.Height = locala.abFh.AK();
          AppMethodBeat.o(104769);
          return 0;
        }
        localajv.Tem = locala.abFh.readString();
        AppMethodBeat.o(104769);
        return 0;
      }
      AppMethodBeat.o(104769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajv
 * JD-Core Version:    0.7.0.1
 */