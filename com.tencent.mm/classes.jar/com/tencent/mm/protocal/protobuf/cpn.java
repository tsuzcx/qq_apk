package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpn
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String jJE;
  public String ntp;
  public String wNG;
  public String wsq;
  public long xYx;
  public String xjj;
  public String xzp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28694);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wNG != null) {
        paramVarArgs.e(1, this.wNG);
      }
      if (this.wsq != null) {
        paramVarArgs.e(2, this.wsq);
      }
      if (this.xzp != null) {
        paramVarArgs.e(3, this.xzp);
      }
      if (this.ntp != null) {
        paramVarArgs.e(4, this.ntp);
      }
      if (this.jJE != null) {
        paramVarArgs.e(5, this.jJE);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(6, this.IconUrl);
      }
      if (this.xjj != null) {
        paramVarArgs.e(7, this.xjj);
      }
      paramVarArgs.am(8, this.xYx);
      AppMethodBeat.o(28694);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wNG == null) {
        break label640;
      }
    }
    label640:
    for (int i = e.a.a.b.b.a.f(1, this.wNG) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wsq != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wsq);
      }
      i = paramInt;
      if (this.xzp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xzp);
      }
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ntp);
      }
      i = paramInt;
      if (this.jJE != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jJE);
      }
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.IconUrl);
      }
      i = paramInt;
      if (this.xjj != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xjj);
      }
      paramInt = e.a.a.b.b.a.p(8, this.xYx);
      AppMethodBeat.o(28694);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28694);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpn localcpn = (cpn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28694);
          return -1;
        case 1: 
          localcpn.wNG = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 2: 
          localcpn.wsq = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 3: 
          localcpn.xzp = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 4: 
          localcpn.ntp = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 5: 
          localcpn.jJE = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 6: 
          localcpn.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        case 7: 
          localcpn.xjj = locala.CLY.readString();
          AppMethodBeat.o(28694);
          return 0;
        }
        localcpn.xYx = locala.CLY.sm();
        AppMethodBeat.o(28694);
        return 0;
      }
      AppMethodBeat.o(28694);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpn
 * JD-Core Version:    0.7.0.1
 */