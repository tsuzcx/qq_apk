package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cei
  extends com.tencent.mm.cd.a
{
  public int CqV;
  public String SZL;
  public int SZN;
  public int TlV;
  public String TlW;
  public String TlX;
  public String UserName;
  public String fwr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      if (this.SZL != null) {
        paramVarArgs.f(2, this.SZL);
      }
      paramVarArgs.aY(3, this.SZN);
      paramVarArgs.aY(4, this.TlV);
      if (this.fwr != null) {
        paramVarArgs.f(5, this.fwr);
      }
      if (this.UserName != null) {
        paramVarArgs.f(6, this.UserName);
      }
      if (this.TlW != null) {
        paramVarArgs.f(7, this.TlW);
      }
      if (this.TlX != null) {
        paramVarArgs.f(8, this.TlX);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.CqV) + 0;
      paramInt = i;
      if (this.SZL != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.SZL);
      }
      i = paramInt + g.a.a.b.b.a.bM(3, this.SZN) + g.a.a.b.b.a.bM(4, this.TlV);
      paramInt = i;
      if (this.fwr != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fwr);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.UserName);
      }
      paramInt = i;
      if (this.TlW != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TlW);
      }
      i = paramInt;
      if (this.TlX != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.TlX);
      }
      AppMethodBeat.o(152608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cei localcei = (cei)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localcei.CqV = locala.abFh.AK();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localcei.SZL = locala.abFh.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localcei.SZN = locala.abFh.AK();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localcei.TlV = locala.abFh.AK();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localcei.fwr = locala.abFh.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localcei.UserName = locala.abFh.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localcei.TlW = locala.abFh.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localcei.TlX = locala.abFh.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cei
 * JD-Core Version:    0.7.0.1
 */