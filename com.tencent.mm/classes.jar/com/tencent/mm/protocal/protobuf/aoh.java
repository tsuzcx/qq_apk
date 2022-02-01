package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aoh
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String Zui;
  public String akjY;
  public String akjZ;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104775);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.Zui != null) {
        paramVarArgs.g(2, this.Zui);
      }
      if (this.akjY != null) {
        paramVarArgs.g(3, this.akjY);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      if (this.akjZ != null) {
        paramVarArgs.g(5, this.akjZ);
      }
      AppMethodBeat.o(104775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label450;
      }
    }
    label450:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zui != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Zui);
      }
      i = paramInt;
      if (this.akjY != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.akjY);
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      i = paramInt;
      if (this.akjZ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.akjZ);
      }
      AppMethodBeat.o(104775);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104775);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aoh localaoh = (aoh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104775);
          return -1;
        case 1: 
          localaoh.hAP = locala.ajGk.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 2: 
          localaoh.Zui = locala.ajGk.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 3: 
          localaoh.akjY = locala.ajGk.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 4: 
          localaoh.IGG = locala.ajGk.readString();
          AppMethodBeat.o(104775);
          return 0;
        }
        localaoh.akjZ = locala.ajGk.readString();
        AppMethodBeat.o(104775);
        return 0;
      }
      AppMethodBeat.o(104775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoh
 * JD-Core Version:    0.7.0.1
 */