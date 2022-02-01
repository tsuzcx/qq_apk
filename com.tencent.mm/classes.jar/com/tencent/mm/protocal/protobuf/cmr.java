package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cmr
  extends com.tencent.mm.bw.a
{
  public int KXC;
  public String Mse;
  public String Msf;
  public String dNI;
  public String qFU;
  public String qGB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(227877);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNI != null) {
        paramVarArgs.e(1, this.dNI);
      }
      if (this.qGB != null) {
        paramVarArgs.e(2, this.qGB);
      }
      if (this.Mse != null) {
        paramVarArgs.e(3, this.Mse);
      }
      if (this.Msf != null) {
        paramVarArgs.e(4, this.Msf);
      }
      paramVarArgs.aM(5, this.KXC);
      if (this.qFU != null) {
        paramVarArgs.e(6, this.qFU);
      }
      AppMethodBeat.o(227877);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dNI == null) {
        break label502;
      }
    }
    label502:
    for (int i = g.a.a.b.b.a.f(1, this.dNI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.qGB != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.qGB);
      }
      i = paramInt;
      if (this.Mse != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Mse);
      }
      paramInt = i;
      if (this.Msf != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Msf);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.KXC);
      paramInt = i;
      if (this.qFU != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.qFU);
      }
      AppMethodBeat.o(227877);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(227877);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cmr localcmr = (cmr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(227877);
          return -1;
        case 1: 
          localcmr.dNI = locala.UbS.readString();
          AppMethodBeat.o(227877);
          return 0;
        case 2: 
          localcmr.qGB = locala.UbS.readString();
          AppMethodBeat.o(227877);
          return 0;
        case 3: 
          localcmr.Mse = locala.UbS.readString();
          AppMethodBeat.o(227877);
          return 0;
        case 4: 
          localcmr.Msf = locala.UbS.readString();
          AppMethodBeat.o(227877);
          return 0;
        case 5: 
          localcmr.KXC = locala.UbS.zi();
          AppMethodBeat.o(227877);
          return 0;
        }
        localcmr.qFU = locala.UbS.readString();
        AppMethodBeat.o(227877);
        return 0;
      }
      AppMethodBeat.o(227877);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmr
 * JD-Core Version:    0.7.0.1
 */