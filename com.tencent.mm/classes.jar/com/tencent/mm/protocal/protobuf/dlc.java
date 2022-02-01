package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlc
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int YQB;
  public int aaJu;
  public int aaQU;
  public int aaQV;
  public String aaQW;
  public int aaQX;
  public String appid;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147770);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bS(3, this.aaJu);
      paramVarArgs.bS(4, this.YQB);
      paramVarArgs.bS(5, this.IJG);
      paramVarArgs.bS(6, this.aaQU);
      paramVarArgs.bS(7, this.aaQV);
      if (this.aaQW != null) {
        paramVarArgs.g(8, this.aaQW);
      }
      paramVarArgs.bS(9, this.aaQX);
      AppMethodBeat.o(147770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aaJu) + i.a.a.b.b.a.cJ(4, this.YQB) + i.a.a.b.b.a.cJ(5, this.IJG) + i.a.a.b.b.a.cJ(6, this.aaQU) + i.a.a.b.b.a.cJ(7, this.aaQV);
      paramInt = i;
      if (this.aaQW != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaQW);
      }
      i = i.a.a.b.b.a.cJ(9, this.aaQX);
      AppMethodBeat.o(147770);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147770);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dlc localdlc = (dlc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147770);
          return -1;
        case 1: 
          localdlc.appid = locala.ajGk.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 2: 
          localdlc.username = locala.ajGk.readString();
          AppMethodBeat.o(147770);
          return 0;
        case 3: 
          localdlc.aaJu = locala.ajGk.aar();
          AppMethodBeat.o(147770);
          return 0;
        case 4: 
          localdlc.YQB = locala.ajGk.aar();
          AppMethodBeat.o(147770);
          return 0;
        case 5: 
          localdlc.IJG = locala.ajGk.aar();
          AppMethodBeat.o(147770);
          return 0;
        case 6: 
          localdlc.aaQU = locala.ajGk.aar();
          AppMethodBeat.o(147770);
          return 0;
        case 7: 
          localdlc.aaQV = locala.ajGk.aar();
          AppMethodBeat.o(147770);
          return 0;
        case 8: 
          localdlc.aaQW = locala.ajGk.readString();
          AppMethodBeat.o(147770);
          return 0;
        }
        localdlc.aaQX = locala.ajGk.aar();
        AppMethodBeat.o(147770);
        return 0;
      }
      AppMethodBeat.o(147770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlc
 * JD-Core Version:    0.7.0.1
 */