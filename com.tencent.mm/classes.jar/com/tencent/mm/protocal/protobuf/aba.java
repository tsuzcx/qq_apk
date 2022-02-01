package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aba
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String Jmq;
  public String Zjq;
  public String Zjr;
  public String Zjs;
  public String Zjt;
  public String Zju;
  public String Zjv;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      paramVarArgs.bS(2, this.vhJ);
      if (this.Zjq != null) {
        paramVarArgs.g(3, this.Zjq);
      }
      if (this.Zjr != null) {
        paramVarArgs.g(4, this.Zjr);
      }
      if (this.Jmq != null) {
        paramVarArgs.g(5, this.Jmq);
      }
      if (this.Zjs != null) {
        paramVarArgs.g(6, this.Zjs);
      }
      if (this.Zjt != null) {
        paramVarArgs.g(7, this.Zjt);
      }
      if (this.Zju != null) {
        paramVarArgs.g(8, this.Zju);
      }
      if (this.Zjv != null) {
        paramVarArgs.g(9, this.Zjv);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0 + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.Zjq != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zjq);
      }
      i = paramInt;
      if (this.Zjr != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Zjr);
      }
      paramInt = i;
      if (this.Jmq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Jmq);
      }
      i = paramInt;
      if (this.Zjs != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Zjs);
      }
      paramInt = i;
      if (this.Zjt != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Zjt);
      }
      i = paramInt;
      if (this.Zju != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Zju);
      }
      paramInt = i;
      if (this.Zjv != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Zjv);
      }
      AppMethodBeat.o(127628);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      aba localaba = (aba)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localaba.IJG = locala.ajGk.aar();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localaba.vhJ = locala.ajGk.aar();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localaba.Zjq = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localaba.Zjr = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localaba.Jmq = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localaba.Zjs = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localaba.Zjt = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localaba.Zju = locala.ajGk.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localaba.Zjv = locala.ajGk.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aba
 * JD-Core Version:    0.7.0.1
 */