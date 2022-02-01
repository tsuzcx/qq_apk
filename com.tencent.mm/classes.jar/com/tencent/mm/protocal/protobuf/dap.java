package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dap
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String Md5;
  public String Url;
  public String YKw;
  public String ZaN;
  public int aaFZ;
  public String aaGh;
  public String crp;
  public int vhE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32325);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.crp != null) {
        paramVarArgs.g(1, this.crp);
      }
      if (this.IGU != null) {
        paramVarArgs.g(2, this.IGU);
      }
      paramVarArgs.bS(3, this.vhE);
      if (this.Md5 != null) {
        paramVarArgs.g(4, this.Md5);
      }
      if (this.YKw != null) {
        paramVarArgs.g(5, this.YKw);
      }
      if (this.ZaN != null) {
        paramVarArgs.g(6, this.ZaN);
      }
      if (this.Url != null) {
        paramVarArgs.g(7, this.Url);
      }
      if (this.aaGh != null) {
        paramVarArgs.g(8, this.aaGh);
      }
      paramVarArgs.bS(9, this.aaFZ);
      AppMethodBeat.o(32325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.crp == null) {
        break label681;
      }
    }
    label681:
    for (paramInt = i.a.a.b.b.a.h(1, this.crp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.IGU != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.IGU);
      }
      i += i.a.a.b.b.a.cJ(3, this.vhE);
      paramInt = i;
      if (this.Md5 != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Md5);
      }
      i = paramInt;
      if (this.YKw != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YKw);
      }
      paramInt = i;
      if (this.ZaN != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZaN);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Url);
      }
      paramInt = i;
      if (this.aaGh != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaGh);
      }
      i = i.a.a.b.b.a.cJ(9, this.aaFZ);
      AppMethodBeat.o(32325);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32325);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dap localdap = (dap)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32325);
          return -1;
        case 1: 
          localdap.crp = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 2: 
          localdap.IGU = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 3: 
          localdap.vhE = locala.ajGk.aar();
          AppMethodBeat.o(32325);
          return 0;
        case 4: 
          localdap.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 5: 
          localdap.YKw = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 6: 
          localdap.ZaN = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 7: 
          localdap.Url = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        case 8: 
          localdap.aaGh = locala.ajGk.readString();
          AppMethodBeat.o(32325);
          return 0;
        }
        localdap.aaFZ = locala.ajGk.aar();
        AppMethodBeat.o(32325);
        return 0;
      }
      AppMethodBeat.o(32325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dap
 * JD-Core Version:    0.7.0.1
 */