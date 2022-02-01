package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpv
  extends com.tencent.mm.bw.a
{
  public String Cyk;
  public String MvO;
  public int oUv;
  public String xMo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127501);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xMo != null) {
        paramVarArgs.e(1, this.xMo);
      }
      if (this.MvO != null) {
        paramVarArgs.e(2, this.MvO);
      }
      if (this.Cyk != null) {
        paramVarArgs.e(3, this.Cyk);
      }
      paramVarArgs.aM(4, this.oUv);
      AppMethodBeat.o(127501);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xMo == null) {
        break label378;
      }
    }
    label378:
    for (int i = g.a.a.b.b.a.f(1, this.xMo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MvO != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MvO);
      }
      i = paramInt;
      if (this.Cyk != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Cyk);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.oUv);
      AppMethodBeat.o(127501);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(127501);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        cpv localcpv = (cpv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127501);
          return -1;
        case 1: 
          localcpv.xMo = locala.UbS.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 2: 
          localcpv.MvO = locala.UbS.readString();
          AppMethodBeat.o(127501);
          return 0;
        case 3: 
          localcpv.Cyk = locala.UbS.readString();
          AppMethodBeat.o(127501);
          return 0;
        }
        localcpv.oUv = locala.UbS.zi();
        AppMethodBeat.o(127501);
        return 0;
      }
      AppMethodBeat.o(127501);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpv
 * JD-Core Version:    0.7.0.1
 */