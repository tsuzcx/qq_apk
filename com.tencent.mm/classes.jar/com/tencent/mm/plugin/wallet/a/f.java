package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends com.tencent.mm.bx.a
{
  public String zOl;
  public String zOm;
  public String zOn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91290);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.zOl != null) {
        paramVarArgs.d(1, this.zOl);
      }
      if (this.zOm != null) {
        paramVarArgs.d(2, this.zOm);
      }
      if (this.zOn != null) {
        paramVarArgs.d(3, this.zOn);
      }
      AppMethodBeat.o(91290);
      return 0;
    }
    if (paramInt == 1) {
      if (this.zOl == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.zOl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.zOm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.zOm);
      }
      i = paramInt;
      if (this.zOn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.zOn);
      }
      AppMethodBeat.o(91290);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91290);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        f localf = (f)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91290);
          return -1;
        case 1: 
          localf.zOl = locala.KhF.readString();
          AppMethodBeat.o(91290);
          return 0;
        case 2: 
          localf.zOm = locala.KhF.readString();
          AppMethodBeat.o(91290);
          return 0;
        }
        localf.zOn = locala.KhF.readString();
        AppMethodBeat.o(91290);
        return 0;
      }
      AppMethodBeat.o(91290);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.f
 * JD-Core Version:    0.7.0.1
 */