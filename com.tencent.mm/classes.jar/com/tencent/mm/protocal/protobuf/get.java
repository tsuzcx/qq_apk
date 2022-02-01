package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class get
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String MFw;
  public String aayf;
  public String abgw;
  public String acck;
  public String accl;
  public String accm;
  public String accn;
  public String acco;
  public int pQY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121110);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acck != null) {
        paramVarArgs.g(1, this.acck);
      }
      if (this.accl != null) {
        paramVarArgs.g(2, this.accl);
      }
      if (this.aayf != null) {
        paramVarArgs.g(3, this.aayf);
      }
      if (this.abgw != null) {
        paramVarArgs.g(4, this.abgw);
      }
      paramVarArgs.bS(5, this.pQY);
      if (this.MFw != null) {
        paramVarArgs.g(6, this.MFw);
      }
      if (this.accm != null) {
        paramVarArgs.g(7, this.accm);
      }
      if (this.accn != null) {
        paramVarArgs.g(8, this.accn);
      }
      paramVarArgs.bS(9, this.IJG);
      if (this.acco != null) {
        paramVarArgs.g(19, this.acco);
      }
      AppMethodBeat.o(121110);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acck == null) {
        break label766;
      }
    }
    label766:
    for (int i = i.a.a.b.b.a.h(1, this.acck) + 0;; i = 0)
    {
      paramInt = i;
      if (this.accl != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.accl);
      }
      i = paramInt;
      if (this.aayf != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aayf);
      }
      paramInt = i;
      if (this.abgw != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abgw);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.pQY);
      paramInt = i;
      if (this.MFw != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.MFw);
      }
      i = paramInt;
      if (this.accm != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.accm);
      }
      paramInt = i;
      if (this.accn != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.accn);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.IJG);
      paramInt = i;
      if (this.acco != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.acco);
      }
      AppMethodBeat.o(121110);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(121110);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        get localget = (get)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(121110);
          return -1;
        case 1: 
          localget.acck = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 2: 
          localget.accl = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 3: 
          localget.aayf = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 4: 
          localget.abgw = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 5: 
          localget.pQY = locala.ajGk.aar();
          AppMethodBeat.o(121110);
          return 0;
        case 6: 
          localget.MFw = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 7: 
          localget.accm = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 8: 
          localget.accn = locala.ajGk.readString();
          AppMethodBeat.o(121110);
          return 0;
        case 9: 
          localget.IJG = locala.ajGk.aar();
          AppMethodBeat.o(121110);
          return 0;
        }
        localget.acco = locala.ajGk.readString();
        AppMethodBeat.o(121110);
        return 0;
      }
      AppMethodBeat.o(121110);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.get
 * JD-Core Version:    0.7.0.1
 */