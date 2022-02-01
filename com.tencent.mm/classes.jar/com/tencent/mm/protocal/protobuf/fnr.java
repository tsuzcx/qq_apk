package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fnr
  extends com.tencent.mm.bx.a
{
  public String aaoj;
  public String abND;
  public int abNE;
  public String sign;
  public String wDe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91717);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abND != null) {
        paramVarArgs.g(4, this.abND);
      }
      if (this.sign != null) {
        paramVarArgs.g(5, this.sign);
      }
      if (this.wDe != null) {
        paramVarArgs.g(6, this.wDe);
      }
      paramVarArgs.bS(7, this.abNE);
      if (this.aaoj != null) {
        paramVarArgs.g(8, this.aaoj);
      }
      AppMethodBeat.o(91717);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abND == null) {
        break label442;
      }
    }
    label442:
    for (int i = i.a.a.b.b.a.h(4, this.abND) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sign != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.sign);
      }
      i = paramInt;
      if (this.wDe != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.wDe);
      }
      i += i.a.a.b.b.a.cJ(7, this.abNE);
      paramInt = i;
      if (this.aaoj != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaoj);
      }
      AppMethodBeat.o(91717);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91717);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnr localfnr = (fnr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91717);
          return -1;
        case 4: 
          localfnr.abND = locala.ajGk.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 5: 
          localfnr.sign = locala.ajGk.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 6: 
          localfnr.wDe = locala.ajGk.readString();
          AppMethodBeat.o(91717);
          return 0;
        case 7: 
          localfnr.abNE = locala.ajGk.aar();
          AppMethodBeat.o(91717);
          return 0;
        }
        localfnr.aaoj = locala.ajGk.readString();
        AppMethodBeat.o(91717);
        return 0;
      }
      AppMethodBeat.o(91717);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnr
 * JD-Core Version:    0.7.0.1
 */