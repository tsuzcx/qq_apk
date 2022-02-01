package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dko
  extends com.tencent.mm.bx.a
{
  public String YPz;
  public int Zhu;
  public String aaQL;
  public String aaQM;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaQL != null) {
        paramVarArgs.g(1, this.aaQL);
      }
      if (this.YPz != null) {
        paramVarArgs.g(2, this.YPz);
      }
      if (this.type != null) {
        paramVarArgs.g(3, this.type);
      }
      paramVarArgs.bS(4, this.Zhu);
      if (this.aaQM != null) {
        paramVarArgs.g(5, this.aaQM);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaQL == null) {
        break label434;
      }
    }
    label434:
    for (int i = i.a.a.b.b.a.h(1, this.aaQL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YPz != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YPz);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.type);
      }
      i += i.a.a.b.b.a.cJ(4, this.Zhu);
      paramInt = i;
      if (this.aaQM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaQM);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dko localdko = (dko)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localdko.aaQL = locala.ajGk.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localdko.YPz = locala.ajGk.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localdko.type = locala.ajGk.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localdko.Zhu = locala.ajGk.aar();
          AppMethodBeat.o(116340);
          return 0;
        }
        localdko.aaQM = locala.ajGk.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dko
 * JD-Core Version:    0.7.0.1
 */