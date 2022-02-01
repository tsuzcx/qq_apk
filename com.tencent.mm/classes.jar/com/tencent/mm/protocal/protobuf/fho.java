package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fho
  extends com.tencent.mm.bx.a
{
  public String QXS;
  public String Ywb;
  public String abIf;
  public int abIg;
  public int adType;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125845);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.adType);
      if (this.abIf != null) {
        paramVarArgs.g(2, this.abIf);
      }
      if (this.Ywb != null) {
        paramVarArgs.g(3, this.Ywb);
      }
      paramVarArgs.bS(4, this.source);
      if (this.QXS != null) {
        paramVarArgs.g(5, this.QXS);
      }
      paramVarArgs.bS(6, this.abIg);
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.adType) + 0;
      paramInt = i;
      if (this.abIf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abIf);
      }
      i = paramInt;
      if (this.Ywb != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ywb);
      }
      i += i.a.a.b.b.a.cJ(4, this.source);
      paramInt = i;
      if (this.QXS != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.QXS);
      }
      i = i.a.a.b.b.a.cJ(6, this.abIg);
      AppMethodBeat.o(125845);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(125845);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fho localfho = (fho)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125845);
        return -1;
      case 1: 
        localfho.adType = locala.ajGk.aar();
        AppMethodBeat.o(125845);
        return 0;
      case 2: 
        localfho.abIf = locala.ajGk.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 3: 
        localfho.Ywb = locala.ajGk.readString();
        AppMethodBeat.o(125845);
        return 0;
      case 4: 
        localfho.source = locala.ajGk.aar();
        AppMethodBeat.o(125845);
        return 0;
      case 5: 
        localfho.QXS = locala.ajGk.readString();
        AppMethodBeat.o(125845);
        return 0;
      }
      localfho.abIg = locala.ajGk.aar();
      AppMethodBeat.o(125845);
      return 0;
    }
    AppMethodBeat.o(125845);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fho
 * JD-Core Version:    0.7.0.1
 */