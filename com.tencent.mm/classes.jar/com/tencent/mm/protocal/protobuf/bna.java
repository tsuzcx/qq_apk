package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bna
  extends com.tencent.mm.bx.a
{
  public String GHa;
  public String GHb;
  public String dDH;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72495);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GHa != null) {
        paramVarArgs.d(1, this.GHa);
      }
      if (this.GHb != null) {
        paramVarArgs.d(2, this.GHb);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.dDH != null) {
        paramVarArgs.d(4, this.dDH);
      }
      AppMethodBeat.o(72495);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GHa == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.GHa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GHb != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GHb);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.dDH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dDH);
      }
      AppMethodBeat.o(72495);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72495);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bna localbna = (bna)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72495);
          return -1;
        case 1: 
          localbna.GHa = locala.NPN.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 2: 
          localbna.GHb = locala.NPN.readString();
          AppMethodBeat.o(72495);
          return 0;
        case 3: 
          localbna.url = locala.NPN.readString();
          AppMethodBeat.o(72495);
          return 0;
        }
        localbna.dDH = locala.NPN.readString();
        AppMethodBeat.o(72495);
        return 0;
      }
      AppMethodBeat.o(72495);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bna
 * JD-Core Version:    0.7.0.1
 */