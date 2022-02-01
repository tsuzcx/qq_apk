package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gg
  extends com.tencent.mm.bw.a
{
  public long KKb;
  public int ReqType;
  public String Url;
  public int iAb;
  public String izX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124391);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.izX != null) {
        paramVarArgs.e(1, this.izX);
      }
      if (this.Url != null) {
        paramVarArgs.e(2, this.Url);
      }
      paramVarArgs.aM(3, this.ReqType);
      paramVarArgs.aM(4, this.iAb);
      paramVarArgs.bb(5, this.KKb);
      AppMethodBeat.o(124391);
      return 0;
    }
    if (paramInt == 1) {
      if (this.izX == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = g.a.a.b.b.a.f(1, this.izX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Url != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Url);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.ReqType);
      int j = g.a.a.b.b.a.bu(4, this.iAb);
      int k = g.a.a.b.b.a.r(5, this.KKb);
      AppMethodBeat.o(124391);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124391);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        gg localgg = (gg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124391);
          return -1;
        case 1: 
          localgg.izX = locala.UbS.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 2: 
          localgg.Url = locala.UbS.readString();
          AppMethodBeat.o(124391);
          return 0;
        case 3: 
          localgg.ReqType = locala.UbS.zi();
          AppMethodBeat.o(124391);
          return 0;
        case 4: 
          localgg.iAb = locala.UbS.zi();
          AppMethodBeat.o(124391);
          return 0;
        }
        localgg.KKb = locala.UbS.zl();
        AppMethodBeat.o(124391);
        return 0;
      }
      AppMethodBeat.o(124391);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gg
 * JD-Core Version:    0.7.0.1
 */