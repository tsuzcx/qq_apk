package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class xb
  extends com.tencent.mm.bx.a
{
  public int ZeQ;
  public int ZeR;
  public int ZeS;
  public String ZeT;
  public int oUF;
  public int tag;
  public String url;
  public String xms;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258659);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.tag);
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      paramVarArgs.bS(3, this.ZeQ);
      if (this.xms != null) {
        paramVarArgs.g(4, this.xms);
      }
      paramVarArgs.bS(5, this.oUF);
      paramVarArgs.bS(6, this.ZeR);
      paramVarArgs.bS(7, this.ZeS);
      if (this.ZeT != null) {
        paramVarArgs.g(8, this.ZeT);
      }
      AppMethodBeat.o(258659);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.tag) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.ZeQ);
      paramInt = i;
      if (this.xms != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xms);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.oUF) + i.a.a.b.b.a.cJ(6, this.ZeR) + i.a.a.b.b.a.cJ(7, this.ZeS);
      paramInt = i;
      if (this.ZeT != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZeT);
      }
      AppMethodBeat.o(258659);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258659);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      xb localxb = (xb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258659);
        return -1;
      case 1: 
        localxb.tag = locala.ajGk.aar();
        AppMethodBeat.o(258659);
        return 0;
      case 2: 
        localxb.url = locala.ajGk.readString();
        AppMethodBeat.o(258659);
        return 0;
      case 3: 
        localxb.ZeQ = locala.ajGk.aar();
        AppMethodBeat.o(258659);
        return 0;
      case 4: 
        localxb.xms = locala.ajGk.readString();
        AppMethodBeat.o(258659);
        return 0;
      case 5: 
        localxb.oUF = locala.ajGk.aar();
        AppMethodBeat.o(258659);
        return 0;
      case 6: 
        localxb.ZeR = locala.ajGk.aar();
        AppMethodBeat.o(258659);
        return 0;
      case 7: 
        localxb.ZeS = locala.ajGk.aar();
        AppMethodBeat.o(258659);
        return 0;
      }
      localxb.ZeT = locala.ajGk.readString();
      AppMethodBeat.o(258659);
      return 0;
    }
    AppMethodBeat.o(258659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xb
 * JD-Core Version:    0.7.0.1
 */