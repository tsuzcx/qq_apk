package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class op
  extends com.tencent.mm.bx.a
{
  public String YRJ;
  public String YRK;
  public int YRL;
  public int YRM;
  public String YRN;
  public String YRO;
  public int YRP;
  public String name;
  public int type;
  public int ver;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124416);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YRJ != null) {
        paramVarArgs.g(1, this.YRJ);
      }
      paramVarArgs.bS(2, this.type);
      if (this.YRK != null) {
        paramVarArgs.g(3, this.YRK);
      }
      if (this.name != null) {
        paramVarArgs.g(4, this.name);
      }
      paramVarArgs.bS(5, this.ver);
      paramVarArgs.bS(6, this.YRL);
      paramVarArgs.bS(7, this.YRM);
      if (this.YRN != null) {
        paramVarArgs.g(8, this.YRN);
      }
      if (this.YRO != null) {
        paramVarArgs.g(9, this.YRO);
      }
      paramVarArgs.bS(10, this.YRP);
      AppMethodBeat.o(124416);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YRJ == null) {
        break label678;
      }
    }
    label678:
    for (paramInt = i.a.a.b.b.a.h(1, this.YRJ) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.YRK != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YRK);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.name);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.ver) + i.a.a.b.b.a.cJ(6, this.YRL) + i.a.a.b.b.a.cJ(7, this.YRM);
      paramInt = i;
      if (this.YRN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YRN);
      }
      i = paramInt;
      if (this.YRO != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YRO);
      }
      paramInt = i.a.a.b.b.a.cJ(10, this.YRP);
      AppMethodBeat.o(124416);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(124416);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        op localop = (op)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124416);
          return -1;
        case 1: 
          localop.YRJ = locala.ajGk.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 2: 
          localop.type = locala.ajGk.aar();
          AppMethodBeat.o(124416);
          return 0;
        case 3: 
          localop.YRK = locala.ajGk.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 4: 
          localop.name = locala.ajGk.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 5: 
          localop.ver = locala.ajGk.aar();
          AppMethodBeat.o(124416);
          return 0;
        case 6: 
          localop.YRL = locala.ajGk.aar();
          AppMethodBeat.o(124416);
          return 0;
        case 7: 
          localop.YRM = locala.ajGk.aar();
          AppMethodBeat.o(124416);
          return 0;
        case 8: 
          localop.YRN = locala.ajGk.readString();
          AppMethodBeat.o(124416);
          return 0;
        case 9: 
          localop.YRO = locala.ajGk.readString();
          AppMethodBeat.o(124416);
          return 0;
        }
        localop.YRP = locala.ajGk.aar();
        AppMethodBeat.o(124416);
        return 0;
      }
      AppMethodBeat.o(124416);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.op
 * JD-Core Version:    0.7.0.1
 */