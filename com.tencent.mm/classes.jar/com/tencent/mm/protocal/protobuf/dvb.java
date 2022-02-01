package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvb
  extends com.tencent.mm.bw.a
{
  public String MWb;
  public String dMl;
  public String sGF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122530);
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
      AppMethodBeat.o(122530);
      return 0;
    }
    if (paramInt == 1) {
      if (this.sGF == null) {
        break label334;
      }
    }
    label334:
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
      AppMethodBeat.o(122530);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122530);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dvb localdvb = (dvb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122530);
          return -1;
        case 1: 
          localdvb.sGF = locala.UbS.readString();
          AppMethodBeat.o(122530);
          return 0;
        case 2: 
          localdvb.MWb = locala.UbS.readString();
          AppMethodBeat.o(122530);
          return 0;
        }
        localdvb.dMl = locala.UbS.readString();
        AppMethodBeat.o(122530);
        return 0;
      }
      AppMethodBeat.o(122530);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvb
 * JD-Core Version:    0.7.0.1
 */