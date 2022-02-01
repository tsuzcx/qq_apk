package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfa
  extends com.tencent.mm.bx.a
{
  public String DCi;
  public String DCj;
  public String dub;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DCi != null) {
        paramVarArgs.d(1, this.DCi);
      }
      if (this.DCj != null) {
        paramVarArgs.d(2, this.DCj);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dub != null) {
        paramVarArgs.d(4, this.dub);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DCi == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.DCi) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DCj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DCj);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.dub != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dub);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfa localbfa = (bfa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localbfa.DCi = locala.KhF.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localbfa.DCj = locala.KhF.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localbfa.url = locala.KhF.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localbfa.dub = locala.KhF.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfa
 * JD-Core Version:    0.7.0.1
 */