package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acu
  extends com.tencent.mm.bx.a
{
  public int Zlq;
  public int Zlr;
  public String appid;
  public int position;
  public String tNS;
  public String tNT;
  public String tNU;
  public String tNV;
  public int tNW;
  public String tNX;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50083);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      if (this.tNS != null) {
        paramVarArgs.g(2, this.tNS);
      }
      paramVarArgs.bS(3, this.Zlq);
      paramVarArgs.bS(4, this.Zlr);
      if (this.tNT != null) {
        paramVarArgs.g(5, this.tNT);
      }
      if (this.appid != null) {
        paramVarArgs.g(6, this.appid);
      }
      if (this.tNU != null) {
        paramVarArgs.g(7, this.tNU);
      }
      if (this.tNV != null) {
        paramVarArgs.g(8, this.tNV);
      }
      paramVarArgs.bS(9, this.tNW);
      if (this.tNX != null) {
        paramVarArgs.g(10, this.tNX);
      }
      paramVarArgs.bS(11, this.position);
      AppMethodBeat.o(50083);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.tNS != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.tNS);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.Zlq) + i.a.a.b.b.a.cJ(4, this.Zlr);
      paramInt = i;
      if (this.tNT != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.tNT);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.appid);
      }
      paramInt = i;
      if (this.tNU != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.tNU);
      }
      i = paramInt;
      if (this.tNV != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.tNV);
      }
      i += i.a.a.b.b.a.cJ(9, this.tNW);
      paramInt = i;
      if (this.tNX != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.tNX);
      }
      i = i.a.a.b.b.a.cJ(11, this.position);
      AppMethodBeat.o(50083);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50083);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        acu localacu = (acu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50083);
          return -1;
        case 1: 
          localacu.username = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 2: 
          localacu.tNS = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 3: 
          localacu.Zlq = locala.ajGk.aar();
          AppMethodBeat.o(50083);
          return 0;
        case 4: 
          localacu.Zlr = locala.ajGk.aar();
          AppMethodBeat.o(50083);
          return 0;
        case 5: 
          localacu.tNT = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 6: 
          localacu.appid = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 7: 
          localacu.tNU = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 8: 
          localacu.tNV = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        case 9: 
          localacu.tNW = locala.ajGk.aar();
          AppMethodBeat.o(50083);
          return 0;
        case 10: 
          localacu.tNX = locala.ajGk.readString();
          AppMethodBeat.o(50083);
          return 0;
        }
        localacu.position = locala.ajGk.aar();
        AppMethodBeat.o(50083);
        return 0;
      }
      AppMethodBeat.o(50083);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acu
 * JD-Core Version:    0.7.0.1
 */