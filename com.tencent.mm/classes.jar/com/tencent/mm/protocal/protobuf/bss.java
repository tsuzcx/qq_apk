package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bss
  extends com.tencent.mm.bw.a
{
  public int action;
  public String dyI;
  public String url;
  public String username;
  public String ypt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72510);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      paramVarArgs.aS(2, this.action);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.username != null) {
        paramVarArgs.d(4, this.username);
      }
      if (this.ypt != null) {
        paramVarArgs.d(5, this.ypt);
      }
      AppMethodBeat.o(72510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.action);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.url);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.username);
      }
      paramInt = i;
      if (this.ypt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ypt);
      }
      AppMethodBeat.o(72510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72510);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bss localbss = (bss)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72510);
          return -1;
        case 1: 
          localbss.dyI = locala.OmT.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 2: 
          localbss.action = locala.OmT.zc();
          AppMethodBeat.o(72510);
          return 0;
        case 3: 
          localbss.url = locala.OmT.readString();
          AppMethodBeat.o(72510);
          return 0;
        case 4: 
          localbss.username = locala.OmT.readString();
          AppMethodBeat.o(72510);
          return 0;
        }
        localbss.ypt = locala.OmT.readString();
        AppMethodBeat.o(72510);
        return 0;
      }
      AppMethodBeat.o(72510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bss
 * JD-Core Version:    0.7.0.1
 */