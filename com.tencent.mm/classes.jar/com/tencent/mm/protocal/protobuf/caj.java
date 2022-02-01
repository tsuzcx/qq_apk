package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class caj
  extends com.tencent.mm.bw.a
{
  public String MfC;
  public String MfD;
  public String icon;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MfC != null) {
        paramVarArgs.e(1, this.MfC);
      }
      if (this.MfD != null) {
        paramVarArgs.e(2, this.MfD);
      }
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      if (this.icon != null) {
        paramVarArgs.e(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MfC == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.MfC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MfD != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MfD);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.url);
      }
      paramInt = i;
      if (this.icon != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.icon);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        caj localcaj = (caj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localcaj.MfC = locala.UbS.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localcaj.MfD = locala.UbS.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localcaj.url = locala.UbS.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localcaj.icon = locala.UbS.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.caj
 * JD-Core Version:    0.7.0.1
 */