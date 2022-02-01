package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ckt
  extends com.tencent.mm.bw.a
{
  public String KRe;
  public int Lia;
  public String Mqu;
  public String Mqv;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mqu != null) {
        paramVarArgs.e(1, this.Mqu);
      }
      if (this.KRe != null) {
        paramVarArgs.e(2, this.KRe);
      }
      if (this.type != null) {
        paramVarArgs.e(3, this.type);
      }
      paramVarArgs.aM(4, this.Lia);
      if (this.Mqv != null) {
        paramVarArgs.e(5, this.Mqv);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mqu == null) {
        break label438;
      }
    }
    label438:
    for (int i = g.a.a.b.b.a.f(1, this.Mqu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KRe != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KRe);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.type);
      }
      i += g.a.a.b.b.a.bu(4, this.Lia);
      paramInt = i;
      if (this.Mqv != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Mqv);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        ckt localckt = (ckt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localckt.Mqu = locala.UbS.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localckt.KRe = locala.UbS.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localckt.type = locala.UbS.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localckt.Lia = locala.UbS.zi();
          AppMethodBeat.o(116340);
          return 0;
        }
        localckt.Mqv = locala.UbS.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckt
 * JD-Core Version:    0.7.0.1
 */