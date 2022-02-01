package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cek
  extends com.tencent.mm.bw.a
{
  public String Fth;
  public String Fti;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91595);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.Fth != null) {
        paramVarArgs.d(2, this.Fth);
      }
      if (this.Fti != null) {
        paramVarArgs.d(3, this.Fti);
      }
      AppMethodBeat.o(91595);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fth != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fth);
      }
      i = paramInt;
      if (this.Fti != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fti);
      }
      AppMethodBeat.o(91595);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91595);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cek localcek = (cek)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91595);
          return -1;
        case 1: 
          localcek.title = locala.LVo.readString();
          AppMethodBeat.o(91595);
          return 0;
        case 2: 
          localcek.Fth = locala.LVo.readString();
          AppMethodBeat.o(91595);
          return 0;
        }
        localcek.Fti = locala.LVo.readString();
        AppMethodBeat.o(91595);
        return 0;
      }
      AppMethodBeat.o(91595);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cek
 * JD-Core Version:    0.7.0.1
 */