package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class eie
  extends com.tencent.mm.bw.a
{
  public b FZb;
  public String Hhh;
  public String dwb;
  public String phf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123700);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hhh != null) {
        paramVarArgs.d(1, this.Hhh);
      }
      if (this.FZb != null) {
        paramVarArgs.c(2, this.FZb);
      }
      if (this.dwb != null) {
        paramVarArgs.d(3, this.dwb);
      }
      if (this.phf != null) {
        paramVarArgs.d(4, this.phf);
      }
      AppMethodBeat.o(123700);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hhh == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.Hhh) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FZb != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.FZb);
      }
      i = paramInt;
      if (this.dwb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dwb);
      }
      paramInt = i;
      if (this.phf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.phf);
      }
      AppMethodBeat.o(123700);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(123700);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eie localeie = (eie)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(123700);
          return -1;
        case 1: 
          localeie.Hhh = locala.OmT.readString();
          AppMethodBeat.o(123700);
          return 0;
        case 2: 
          localeie.FZb = locala.OmT.gCk();
          AppMethodBeat.o(123700);
          return 0;
        case 3: 
          localeie.dwb = locala.OmT.readString();
          AppMethodBeat.o(123700);
          return 0;
        }
        localeie.phf = locala.OmT.readString();
        AppMethodBeat.o(123700);
        return 0;
      }
      AppMethodBeat.o(123700);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eie
 * JD-Core Version:    0.7.0.1
 */