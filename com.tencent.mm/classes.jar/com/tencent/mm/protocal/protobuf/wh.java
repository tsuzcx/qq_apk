package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class wh
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public int PzZ;
  public String mdZ;
  public String text;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.text != null) {
        paramVarArgs.g(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.g(3, this.url);
      }
      paramVarArgs.bS(4, this.PzZ);
      paramVarArgs.bS(5, this.HTK);
      if (this.mdZ != null) {
        paramVarArgs.g(6, this.mdZ);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.url);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.PzZ) + i.a.a.b.b.a.cJ(5, this.HTK);
      paramInt = i;
      if (this.mdZ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.mdZ);
      }
      AppMethodBeat.o(113966);
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
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      wh localwh = (wh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localwh.type = locala.ajGk.aar();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localwh.text = locala.ajGk.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localwh.url = locala.ajGk.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localwh.PzZ = locala.ajGk.aar();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localwh.HTK = locala.ajGk.aar();
        AppMethodBeat.o(113966);
        return 0;
      }
      localwh.mdZ = locala.ajGk.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wh
 * JD-Core Version:    0.7.0.1
 */