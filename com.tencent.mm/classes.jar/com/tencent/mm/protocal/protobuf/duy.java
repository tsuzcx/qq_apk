package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class duy
  extends com.tencent.mm.bw.a
{
  public String MWb;
  public String MWc;
  public String dMl;
  public String sGF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122526);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.sGF != null) {
        paramVarArgs.e(1, this.sGF);
      }
      if (this.MWb != null) {
        paramVarArgs.e(2, this.MWb);
      }
      if (this.dMl != null) {
        paramVarArgs.e(3, this.dMl);
      }
      if (this.MWc != null) {
        paramVarArgs.e(4, this.MWc);
      }
      AppMethodBeat.o(122526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGF == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.sGF) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MWb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MWb);
      }
      i = paramInt;
      if (this.dMl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dMl);
      }
      paramInt = i;
      if (this.MWc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MWc);
      }
      AppMethodBeat.o(122526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122526);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        duy localduy = (duy)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122526);
          return -1;
        case 1: 
          localduy.sGF = locala.UbS.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 2: 
          localduy.MWb = locala.UbS.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 3: 
          localduy.dMl = locala.UbS.readString();
          AppMethodBeat.o(122526);
          return 0;
        }
        localduy.MWc = locala.UbS.readString();
        AppMethodBeat.o(122526);
        return 0;
      }
      AppMethodBeat.o(122526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duy
 * JD-Core Version:    0.7.0.1
 */