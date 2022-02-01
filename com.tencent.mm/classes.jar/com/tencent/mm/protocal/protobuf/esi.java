package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class esi
  extends com.tencent.mm.cd.a
{
  public String TaX;
  public String Uuc;
  public int Uud;
  public String sign;
  public String tyH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Uuc != null) {
        paramVarArgs.f(4, this.Uuc);
      }
      if (this.sign != null) {
        paramVarArgs.f(5, this.sign);
      }
      if (this.tyH != null) {
        paramVarArgs.f(6, this.tyH);
      }
      paramVarArgs.aY(7, this.Uud);
      if (this.TaX != null) {
        paramVarArgs.f(8, this.TaX);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Uuc == null) {
        break label446;
      }
    }
    label446:
    for (int i = g.a.a.b.b.a.g(4, this.Uuc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.sign);
      }
      i = paramInt;
      if (this.tyH != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.tyH);
      }
      i += g.a.a.b.b.a.bM(7, this.Uud);
      paramInt = i;
      if (this.TaX != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TaX);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        esi localesi = (esi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localesi.Uuc = locala.abFh.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localesi.sign = locala.abFh.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localesi.tyH = locala.abFh.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localesi.Uud = locala.abFh.AK();
          AppMethodBeat.o(91717);
          return 0;
        }
        localesi.TaX = locala.abFh.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.esi
 * JD-Core Version:    0.7.0.1
 */