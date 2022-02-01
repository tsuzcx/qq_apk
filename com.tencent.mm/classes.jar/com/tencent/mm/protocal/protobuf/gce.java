package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class gce
  extends com.tencent.mm.bx.a
{
  public int YCv;
  public b Zsu;
  public int acan;
  public int bGp;
  public String kDf;
  public int oUj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147790);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.oUj);
      paramVarArgs.bS(2, this.bGp);
      if (this.kDf != null) {
        paramVarArgs.g(3, this.kDf);
      }
      if (this.Zsu != null) {
        paramVarArgs.d(4, this.Zsu);
      }
      paramVarArgs.bS(5, this.YCv);
      paramVarArgs.bS(6, this.acan);
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.oUj) + 0 + i.a.a.b.b.a.cJ(2, this.bGp);
      paramInt = i;
      if (this.kDf != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.kDf);
      }
      i = paramInt;
      if (this.Zsu != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.Zsu);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.YCv);
      int j = i.a.a.b.b.a.cJ(6, this.acan);
      AppMethodBeat.o(147790);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(147790);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gce localgce = (gce)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(147790);
        return -1;
      case 1: 
        localgce.oUj = locala.ajGk.aar();
        AppMethodBeat.o(147790);
        return 0;
      case 2: 
        localgce.bGp = locala.ajGk.aar();
        AppMethodBeat.o(147790);
        return 0;
      case 3: 
        localgce.kDf = locala.ajGk.readString();
        AppMethodBeat.o(147790);
        return 0;
      case 4: 
        localgce.Zsu = locala.ajGk.kFX();
        AppMethodBeat.o(147790);
        return 0;
      case 5: 
        localgce.YCv = locala.ajGk.aar();
        AppMethodBeat.o(147790);
        return 0;
      }
      localgce.acan = locala.ajGk.aar();
      AppMethodBeat.o(147790);
      return 0;
    }
    AppMethodBeat.o(147790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gce
 * JD-Core Version:    0.7.0.1
 */