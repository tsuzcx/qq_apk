package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fmo
  extends com.tencent.mm.bx.a
{
  public long Tqa;
  public String abMP;
  public String abMQ;
  public String abMR;
  public String abMS;
  public String mdD;
  public String mdQ;
  public String nickname;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258729);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.Tqa);
      if (this.mdD != null) {
        paramVarArgs.g(2, this.mdD);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(4, this.nickname);
      }
      if (this.mdQ != null) {
        paramVarArgs.g(5, this.mdQ);
      }
      if (this.abMP != null) {
        paramVarArgs.g(6, this.abMP);
      }
      if (this.abMQ != null) {
        paramVarArgs.g(7, this.abMQ);
      }
      if (this.abMR != null) {
        paramVarArgs.g(8, this.abMR);
      }
      if (this.abMS != null) {
        paramVarArgs.g(9, this.abMS);
      }
      AppMethodBeat.o(258729);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Tqa) + 0;
      paramInt = i;
      if (this.mdD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.mdD);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.nickname);
      }
      i = paramInt;
      if (this.mdQ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.mdQ);
      }
      paramInt = i;
      if (this.abMP != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abMP);
      }
      i = paramInt;
      if (this.abMQ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abMQ);
      }
      paramInt = i;
      if (this.abMR != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abMR);
      }
      i = paramInt;
      if (this.abMS != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abMS);
      }
      AppMethodBeat.o(258729);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258729);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fmo localfmo = (fmo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258729);
        return -1;
      case 1: 
        localfmo.Tqa = locala.ajGk.aaw();
        AppMethodBeat.o(258729);
        return 0;
      case 2: 
        localfmo.mdD = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 3: 
        localfmo.username = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 4: 
        localfmo.nickname = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 5: 
        localfmo.mdQ = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 6: 
        localfmo.abMP = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 7: 
        localfmo.abMQ = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      case 8: 
        localfmo.abMR = locala.ajGk.readString();
        AppMethodBeat.o(258729);
        return 0;
      }
      localfmo.abMS = locala.ajGk.readString();
      AppMethodBeat.o(258729);
      return 0;
    }
    AppMethodBeat.o(258729);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fmo
 * JD-Core Version:    0.7.0.1
 */