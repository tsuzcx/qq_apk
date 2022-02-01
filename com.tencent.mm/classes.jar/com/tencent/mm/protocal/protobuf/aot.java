package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aot
  extends com.tencent.mm.bx.a
{
  public int ZvW;
  public String appid;
  public int count;
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
    AppMethodBeat.i(50085);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.count);
      if (this.tNS != null) {
        paramVarArgs.g(3, this.tNS);
      }
      if (this.tNT != null) {
        paramVarArgs.g(4, this.tNT);
      }
      paramVarArgs.bS(5, this.ZvW);
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
      AppMethodBeat.o(50085);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.count);
      paramInt = i;
      if (this.tNS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.tNS);
      }
      i = paramInt;
      if (this.tNT != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.tNT);
      }
      i += i.a.a.b.b.a.cJ(5, this.ZvW);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.appid);
      }
      i = paramInt;
      if (this.tNU != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.tNU);
      }
      paramInt = i;
      if (this.tNV != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.tNV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.tNW);
      paramInt = i;
      if (this.tNX != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.tNX);
      }
      i = i.a.a.b.b.a.cJ(11, this.position);
      AppMethodBeat.o(50085);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(50085);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aot localaot = (aot)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(50085);
          return -1;
        case 1: 
          localaot.username = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 2: 
          localaot.count = locala.ajGk.aar();
          AppMethodBeat.o(50085);
          return 0;
        case 3: 
          localaot.tNS = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 4: 
          localaot.tNT = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 5: 
          localaot.ZvW = locala.ajGk.aar();
          AppMethodBeat.o(50085);
          return 0;
        case 6: 
          localaot.appid = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 7: 
          localaot.tNU = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 8: 
          localaot.tNV = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        case 9: 
          localaot.tNW = locala.ajGk.aar();
          AppMethodBeat.o(50085);
          return 0;
        case 10: 
          localaot.tNX = locala.ajGk.readString();
          AppMethodBeat.o(50085);
          return 0;
        }
        localaot.position = locala.ajGk.aar();
        AppMethodBeat.o(50085);
        return 0;
      }
      AppMethodBeat.o(50085);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aot
 * JD-Core Version:    0.7.0.1
 */