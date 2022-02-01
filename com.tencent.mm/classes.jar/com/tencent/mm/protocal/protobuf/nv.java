package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nv
  extends com.tencent.mm.bw.a
{
  public String KTu;
  public String pWm;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124418);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KTu != null) {
        paramVarArgs.e(1, this.KTu);
      }
      if (this.pWm != null) {
        paramVarArgs.e(2, this.pWm);
      }
      paramVarArgs.aM(3, this.ver);
      AppMethodBeat.o(124418);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KTu == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = g.a.a.b.b.a.f(1, this.KTu) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.pWm != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.pWm);
      }
      paramInt = g.a.a.b.b.a.bu(3, this.ver);
      AppMethodBeat.o(124418);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124418);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        nv localnv = (nv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124418);
          return -1;
        case 1: 
          localnv.KTu = locala.UbS.readString();
          AppMethodBeat.o(124418);
          return 0;
        case 2: 
          localnv.pWm = locala.UbS.readString();
          AppMethodBeat.o(124418);
          return 0;
        }
        localnv.ver = locala.UbS.zi();
        AppMethodBeat.o(124418);
        return 0;
      }
      AppMethodBeat.o(124418);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */