package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class boo
  extends com.tencent.mm.bw.a
{
  public String Dct;
  public String desc;
  public String hBq;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.hBq != null) {
        paramVarArgs.d(3, this.hBq);
      }
      if (this.Dct != null) {
        paramVarArgs.d(4, this.Dct);
      }
      AppMethodBeat.o(72498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.hBq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hBq);
      }
      paramInt = i;
      if (this.Dct != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dct);
      }
      AppMethodBeat.o(72498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72498);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        boo localboo = (boo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72498);
          return -1;
        case 1: 
          localboo.title = locala.OmT.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 2: 
          localboo.desc = locala.OmT.readString();
          AppMethodBeat.o(72498);
          return 0;
        case 3: 
          localboo.hBq = locala.OmT.readString();
          AppMethodBeat.o(72498);
          return 0;
        }
        localboo.Dct = locala.OmT.readString();
        AppMethodBeat.o(72498);
        return 0;
      }
      AppMethodBeat.o(72498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.boo
 * JD-Core Version:    0.7.0.1
 */