package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aic
  extends com.tencent.mm.bw.a
{
  public int GxP;
  public int defaultValue;
  public String key;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(218923);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      paramVarArgs.aS(3, this.defaultValue);
      paramVarArgs.aS(4, this.GxP);
      AppMethodBeat.o(218923);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = f.a.a.b.b.a.e(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.title);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.defaultValue);
      int j = f.a.a.b.b.a.bz(4, this.GxP);
      AppMethodBeat.o(218923);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(218923);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aic localaic = (aic)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(218923);
          return -1;
        case 1: 
          localaic.key = locala.OmT.readString();
          AppMethodBeat.o(218923);
          return 0;
        case 2: 
          localaic.title = locala.OmT.readString();
          AppMethodBeat.o(218923);
          return 0;
        case 3: 
          localaic.defaultValue = locala.OmT.zc();
          AppMethodBeat.o(218923);
          return 0;
        }
        localaic.GxP = locala.OmT.zc();
        AppMethodBeat.o(218923);
        return 0;
      }
      AppMethodBeat.o(218923);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aic
 * JD-Core Version:    0.7.0.1
 */