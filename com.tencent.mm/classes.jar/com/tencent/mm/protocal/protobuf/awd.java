package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awd
  extends com.tencent.mm.bw.a
{
  public int KTE;
  public String LFM;
  public String LGJ;
  public String LGK;
  public String LGL;
  public String LGM;
  public String LGN;
  public String LGO;
  public float LGP;
  public int LGQ;
  public String name;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209524);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LFM != null) {
        paramVarArgs.e(1, this.LFM);
      }
      paramVarArgs.aM(2, this.KTE);
      if (this.LGJ != null) {
        paramVarArgs.e(3, this.LGJ);
      }
      if (this.LGK != null) {
        paramVarArgs.e(4, this.LGK);
      }
      if (this.LGL != null) {
        paramVarArgs.e(5, this.LGL);
      }
      if (this.LGM != null) {
        paramVarArgs.e(6, this.LGM);
      }
      if (this.LGN != null) {
        paramVarArgs.e(7, this.LGN);
      }
      if (this.LGO != null) {
        paramVarArgs.e(8, this.LGO);
      }
      if (this.name != null) {
        paramVarArgs.e(9, this.name);
      }
      paramVarArgs.E(10, this.LGP);
      paramVarArgs.aM(11, this.LGQ);
      AppMethodBeat.o(209524);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LFM == null) {
        break label781;
      }
    }
    label781:
    for (paramInt = g.a.a.b.b.a.f(1, this.LFM) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KTE);
      paramInt = i;
      if (this.LGJ != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LGJ);
      }
      i = paramInt;
      if (this.LGK != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.LGK);
      }
      paramInt = i;
      if (this.LGL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LGL);
      }
      i = paramInt;
      if (this.LGM != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LGM);
      }
      paramInt = i;
      if (this.LGN != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LGN);
      }
      i = paramInt;
      if (this.LGO != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LGO);
      }
      paramInt = i;
      if (this.name != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.name);
      }
      i = g.a.a.b.b.a.fS(10);
      int j = g.a.a.b.b.a.bu(11, this.LGQ);
      AppMethodBeat.o(209524);
      return paramInt + (i + 4) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209524);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        awd localawd = (awd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(209524);
          return -1;
        case 1: 
          localawd.LFM = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 2: 
          localawd.KTE = locala.UbS.zi();
          AppMethodBeat.o(209524);
          return 0;
        case 3: 
          localawd.LGJ = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 4: 
          localawd.LGK = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 5: 
          localawd.LGL = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 6: 
          localawd.LGM = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 7: 
          localawd.LGN = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 8: 
          localawd.LGO = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 9: 
          localawd.name = locala.UbS.readString();
          AppMethodBeat.o(209524);
          return 0;
        case 10: 
          localawd.LGP = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(209524);
          return 0;
        }
        localawd.LGQ = locala.UbS.zi();
        AppMethodBeat.o(209524);
        return 0;
      }
      AppMethodBeat.o(209524);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awd
 * JD-Core Version:    0.7.0.1
 */