package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apl
  extends com.tencent.mm.bx.a
{
  public String ZwA;
  public String ZwB;
  public int ZwC;
  public int ZwD;
  public String ZwE;
  public String ZwF;
  public String ZwG;
  public String ZwH;
  public int ZwI;
  public String ZwJ;
  public int Zwh;
  public String Zwi;
  public String Zwj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zwh);
      if (this.Zwi != null) {
        paramVarArgs.g(2, this.Zwi);
      }
      if (this.ZwA != null) {
        paramVarArgs.g(3, this.ZwA);
      }
      if (this.ZwB != null) {
        paramVarArgs.g(4, this.ZwB);
      }
      paramVarArgs.bS(5, this.ZwC);
      paramVarArgs.bS(6, this.ZwD);
      if (this.ZwE != null) {
        paramVarArgs.g(7, this.ZwE);
      }
      if (this.Zwj != null) {
        paramVarArgs.g(8, this.Zwj);
      }
      if (this.ZwF != null) {
        paramVarArgs.g(9, this.ZwF);
      }
      if (this.ZwG != null) {
        paramVarArgs.g(10, this.ZwG);
      }
      if (this.ZwH != null) {
        paramVarArgs.g(11, this.ZwH);
      }
      paramVarArgs.bS(12, this.ZwI);
      if (this.ZwJ != null) {
        paramVarArgs.g(13, this.ZwJ);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zwh) + 0;
      paramInt = i;
      if (this.Zwi != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zwi);
      }
      i = paramInt;
      if (this.ZwA != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZwA);
      }
      paramInt = i;
      if (this.ZwB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZwB);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.ZwC) + i.a.a.b.b.a.cJ(6, this.ZwD);
      paramInt = i;
      if (this.ZwE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZwE);
      }
      i = paramInt;
      if (this.Zwj != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Zwj);
      }
      paramInt = i;
      if (this.ZwF != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZwF);
      }
      i = paramInt;
      if (this.ZwG != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZwG);
      }
      paramInt = i;
      if (this.ZwH != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZwH);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.ZwI);
      paramInt = i;
      if (this.ZwJ != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZwJ);
      }
      AppMethodBeat.o(32206);
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
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      apl localapl = (apl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localapl.Zwh = locala.ajGk.aar();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localapl.Zwi = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localapl.ZwA = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localapl.ZwB = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localapl.ZwC = locala.ajGk.aar();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localapl.ZwD = locala.ajGk.aar();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localapl.ZwE = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localapl.Zwj = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localapl.ZwF = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 10: 
        localapl.ZwG = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 11: 
        localapl.ZwH = locala.ajGk.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 12: 
        localapl.ZwI = locala.ajGk.aar();
        AppMethodBeat.o(32206);
        return 0;
      }
      localapl.ZwJ = locala.ajGk.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apl
 * JD-Core Version:    0.7.0.1
 */