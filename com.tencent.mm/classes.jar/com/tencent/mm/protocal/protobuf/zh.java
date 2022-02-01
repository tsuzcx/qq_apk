package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zh
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZhN;
  public String ZhO;
  public String ZhP;
  public int ZhQ;
  public String ZhR;
  public String ZhS;
  public String ZhT;
  public String ZhU;
  public String ZhV;
  public String ZhW;
  public String ZhX;
  public String ZhY;
  public int ZhZ;
  public String Zia;
  public String Zib;
  public String Zic;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.ZhN != null) {
        paramVarArgs.g(3, this.ZhN);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(4, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(5, this.ZhP);
      }
      paramVarArgs.bS(6, this.ZhQ);
      if (this.ZhR != null) {
        paramVarArgs.g(7, this.ZhR);
      }
      if (this.ZhS != null) {
        paramVarArgs.g(9, this.ZhS);
      }
      if (this.ZhT != null) {
        paramVarArgs.g(10, this.ZhT);
      }
      if (this.ZhU != null) {
        paramVarArgs.g(11, this.ZhU);
      }
      if (this.ZhV != null) {
        paramVarArgs.g(12, this.ZhV);
      }
      if (this.ZhW != null) {
        paramVarArgs.g(13, this.ZhW);
      }
      if (this.ZhX != null) {
        paramVarArgs.g(14, this.ZhX);
      }
      if (this.ZhY != null) {
        paramVarArgs.g(15, this.ZhY);
      }
      paramVarArgs.bS(16, this.ZhZ);
      if (this.Zia != null) {
        paramVarArgs.g(17, this.Zia);
      }
      if (this.Zib != null) {
        paramVarArgs.g(18, this.Zib);
      }
      if (this.Zic != null) {
        paramVarArgs.g(19, this.Zic);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1230;
      }
    }
    label1230:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.ZhN != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZhN);
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZhP);
      }
      i += i.a.a.b.b.a.cJ(6, this.ZhQ);
      paramInt = i;
      if (this.ZhR != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZhR);
      }
      i = paramInt;
      if (this.ZhS != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ZhS);
      }
      paramInt = i;
      if (this.ZhT != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ZhT);
      }
      i = paramInt;
      if (this.ZhU != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ZhU);
      }
      paramInt = i;
      if (this.ZhV != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.ZhV);
      }
      i = paramInt;
      if (this.ZhW != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.ZhW);
      }
      paramInt = i;
      if (this.ZhX != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ZhX);
      }
      i = paramInt;
      if (this.ZhY != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.ZhY);
      }
      i += i.a.a.b.b.a.cJ(16, this.ZhZ);
      paramInt = i;
      if (this.Zia != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Zia);
      }
      i = paramInt;
      if (this.Zib != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.Zib);
      }
      paramInt = i;
      if (this.Zic != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.Zic);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        zh localzh = (zh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localzh.UserName = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localzh.vhX = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localzh.ZhN = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localzh.ZhO = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localzh.ZhP = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localzh.ZhQ = locala.ajGk.aar();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localzh.ZhR = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 9: 
          localzh.ZhS = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localzh.ZhT = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 11: 
          localzh.ZhU = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 12: 
          localzh.ZhV = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 13: 
          localzh.ZhW = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 14: 
          localzh.ZhX = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 15: 
          localzh.ZhY = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 16: 
          localzh.ZhZ = locala.ajGk.aar();
          AppMethodBeat.o(43087);
          return 0;
        case 17: 
          localzh.Zia = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 18: 
          localzh.Zib = locala.ajGk.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localzh.Zic = locala.ajGk.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zh
 * JD-Core Version:    0.7.0.1
 */