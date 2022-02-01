package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckk
  extends com.tencent.mm.bw.a
{
  public String MpV;
  public String MpW;
  public String dQx;
  public String nnB;
  public int uSc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200215);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dQx != null) {
        paramVarArgs.e(1, this.dQx);
      }
      paramVarArgs.aM(2, this.uSc);
      if (this.nnB != null) {
        paramVarArgs.e(3, this.nnB);
      }
      if (this.MpV != null) {
        paramVarArgs.e(4, this.MpV);
      }
      if (this.MpW != null) {
        paramVarArgs.e(5, this.MpW);
      }
      AppMethodBeat.o(200215);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dQx == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = g.a.a.b.b.a.f(1, this.dQx) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.uSc);
      paramInt = i;
      if (this.nnB != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.nnB);
      }
      i = paramInt;
      if (this.MpV != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MpV);
      }
      paramInt = i;
      if (this.MpW != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MpW);
      }
      AppMethodBeat.o(200215);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(200215);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckk localckk = (ckk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(200215);
          return -1;
        case 1: 
          localckk.dQx = locala.UbS.readString();
          AppMethodBeat.o(200215);
          return 0;
        case 2: 
          localckk.uSc = locala.UbS.zi();
          AppMethodBeat.o(200215);
          return 0;
        case 3: 
          localckk.nnB = locala.UbS.readString();
          AppMethodBeat.o(200215);
          return 0;
        case 4: 
          localckk.MpV = locala.UbS.readString();
          AppMethodBeat.o(200215);
          return 0;
        }
        localckk.MpW = locala.UbS.readString();
        AppMethodBeat.o(200215);
        return 0;
      }
      AppMethodBeat.o(200215);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckk
 * JD-Core Version:    0.7.0.1
 */