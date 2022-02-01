package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class jm
  extends com.tencent.mm.bw.a
{
  public String KOb;
  public String KOc;
  public String imei;
  public String kxx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116465);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.imei != null) {
        paramVarArgs.e(1, this.imei);
      }
      if (this.KOb != null) {
        paramVarArgs.e(2, this.KOb);
      }
      if (this.kxx != null) {
        paramVarArgs.e(3, this.kxx);
      }
      if (this.KOc != null) {
        paramVarArgs.e(4, this.KOc);
      }
      AppMethodBeat.o(116465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.imei == null) {
        break label394;
      }
    }
    label394:
    for (int i = g.a.a.b.b.a.f(1, this.imei) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KOb != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KOb);
      }
      i = paramInt;
      if (this.kxx != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.kxx);
      }
      paramInt = i;
      if (this.KOc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KOc);
      }
      AppMethodBeat.o(116465);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116465);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        jm localjm = (jm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116465);
          return -1;
        case 1: 
          localjm.imei = locala.UbS.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 2: 
          localjm.KOb = locala.UbS.readString();
          AppMethodBeat.o(116465);
          return 0;
        case 3: 
          localjm.kxx = locala.UbS.readString();
          AppMethodBeat.o(116465);
          return 0;
        }
        localjm.KOc = locala.UbS.readString();
        AppMethodBeat.o(116465);
        return 0;
      }
      AppMethodBeat.o(116465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jm
 * JD-Core Version:    0.7.0.1
 */