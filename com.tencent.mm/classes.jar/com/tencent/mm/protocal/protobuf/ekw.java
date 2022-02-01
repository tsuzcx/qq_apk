package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class ekw
  extends com.tencent.mm.bw.a
{
  public b Nkg;
  public String Nkh;
  public b Nki;
  public int uin;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82480);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Nkg != null) {
        paramVarArgs.c(1, this.Nkg);
      }
      if (this.Nkh != null) {
        paramVarArgs.e(2, this.Nkh);
      }
      if (this.Nki != null) {
        paramVarArgs.c(3, this.Nki);
      }
      paramVarArgs.aM(4, this.uin);
      AppMethodBeat.o(82480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Nkg == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.b(1, this.Nkg) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Nkh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Nkh);
      }
      i = paramInt;
      if (this.Nki != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.Nki);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.uin);
      AppMethodBeat.o(82480);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(82480);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ekw localekw = (ekw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82480);
          return -1;
        case 1: 
          localekw.Nkg = locala.UbS.hPo();
          AppMethodBeat.o(82480);
          return 0;
        case 2: 
          localekw.Nkh = locala.UbS.readString();
          AppMethodBeat.o(82480);
          return 0;
        case 3: 
          localekw.Nki = locala.UbS.hPo();
          AppMethodBeat.o(82480);
          return 0;
        }
        localekw.uin = locala.UbS.zi();
        AppMethodBeat.o(82480);
        return 0;
      }
      AppMethodBeat.o(82480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekw
 * JD-Core Version:    0.7.0.1
 */