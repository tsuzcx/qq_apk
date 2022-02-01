package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class dzk
  extends com.tencent.mm.bx.a
{
  public String abeA;
  public String abeB;
  public String abeC;
  public String abeD;
  public String abex;
  public String abey;
  public String abez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257538);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abex != null) {
        paramVarArgs.g(1, this.abex);
      }
      if (this.abey != null) {
        paramVarArgs.g(2, this.abey);
      }
      if (this.abez != null) {
        paramVarArgs.g(3, this.abez);
      }
      if (this.abeA != null) {
        paramVarArgs.g(4, this.abeA);
      }
      if (this.abeB != null) {
        paramVarArgs.g(5, this.abeB);
      }
      if (this.abeC != null) {
        paramVarArgs.g(6, this.abeC);
      }
      if (this.abeD != null) {
        paramVarArgs.g(7, this.abeD);
      }
      AppMethodBeat.o(257538);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abex == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.abex) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abey);
      }
      i = paramInt;
      if (this.abez != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abez);
      }
      paramInt = i;
      if (this.abeA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abeA);
      }
      i = paramInt;
      if (this.abeB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abeB);
      }
      paramInt = i;
      if (this.abeC != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abeC);
      }
      i = paramInt;
      if (this.abeD != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abeD);
      }
      AppMethodBeat.o(257538);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257538);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dzk localdzk = (dzk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257538);
          return -1;
        case 1: 
          localdzk.abex = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        case 2: 
          localdzk.abey = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        case 3: 
          localdzk.abez = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        case 4: 
          localdzk.abeA = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        case 5: 
          localdzk.abeB = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        case 6: 
          localdzk.abeC = locala.ajGk.readString();
          AppMethodBeat.o(257538);
          return 0;
        }
        localdzk.abeD = locala.ajGk.readString();
        AppMethodBeat.o(257538);
        return 0;
      }
      AppMethodBeat.o(257538);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzk
 * JD-Core Version:    0.7.0.1
 */