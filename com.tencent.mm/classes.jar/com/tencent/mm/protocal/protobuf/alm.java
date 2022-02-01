package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alm
  extends com.tencent.mm.bx.a
{
  public String ZgZ;
  public String ZsA;
  public String ZsB;
  public String ZsC;
  public String ZsD;
  public String ZsE;
  public String ZsF;
  public String ZsG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZgZ != null) {
        paramVarArgs.g(1, this.ZgZ);
      }
      if (this.ZsA != null) {
        paramVarArgs.g(2, this.ZsA);
      }
      if (this.ZsB != null) {
        paramVarArgs.g(3, this.ZsB);
      }
      if (this.ZsC != null) {
        paramVarArgs.g(4, this.ZsC);
      }
      if (this.ZsD != null) {
        paramVarArgs.g(5, this.ZsD);
      }
      if (this.ZsE != null) {
        paramVarArgs.g(6, this.ZsE);
      }
      if (this.ZsF != null) {
        paramVarArgs.g(7, this.ZsF);
      }
      if (this.ZsG != null) {
        paramVarArgs.g(8, this.ZsG);
      }
      AppMethodBeat.o(257841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZgZ == null) {
        break label638;
      }
    }
    label638:
    for (int i = i.a.a.b.b.a.h(1, this.ZgZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZsA != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZsA);
      }
      i = paramInt;
      if (this.ZsB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZsB);
      }
      paramInt = i;
      if (this.ZsC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZsC);
      }
      i = paramInt;
      if (this.ZsD != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZsD);
      }
      paramInt = i;
      if (this.ZsE != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZsE);
      }
      i = paramInt;
      if (this.ZsF != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZsF);
      }
      paramInt = i;
      if (this.ZsG != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZsG);
      }
      AppMethodBeat.o(257841);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257841);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        alm localalm = (alm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257841);
          return -1;
        case 1: 
          localalm.ZgZ = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 2: 
          localalm.ZsA = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 3: 
          localalm.ZsB = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 4: 
          localalm.ZsC = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 5: 
          localalm.ZsD = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 6: 
          localalm.ZsE = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        case 7: 
          localalm.ZsF = locala.ajGk.readString();
          AppMethodBeat.o(257841);
          return 0;
        }
        localalm.ZsG = locala.ajGk.readString();
        AppMethodBeat.o(257841);
        return 0;
      }
      AppMethodBeat.o(257841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alm
 * JD-Core Version:    0.7.0.1
 */