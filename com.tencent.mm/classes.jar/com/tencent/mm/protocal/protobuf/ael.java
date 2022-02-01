package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ael
  extends com.tencent.mm.bx.a
{
  public String DVu;
  public int YHv;
  public String YTW;
  public int Zms;
  public int Zmt;
  public int Zmu;
  public boolean Zmv;
  public boolean Zmw;
  public int pos;
  public int style;
  public int tNW;
  public int time;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257363);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Zms);
      paramVarArgs.bS(2, this.Zmt);
      paramVarArgs.bS(3, this.Zmu);
      paramVarArgs.bS(4, this.time);
      paramVarArgs.bS(5, this.YHv);
      paramVarArgs.bS(6, this.tNW);
      paramVarArgs.bS(7, this.pos);
      paramVarArgs.di(8, this.Zmv);
      paramVarArgs.di(9, this.Zmw);
      if (this.DVu != null) {
        paramVarArgs.g(10, this.DVu);
      }
      if (this.YTW != null) {
        paramVarArgs.g(11, this.YTW);
      }
      paramVarArgs.bS(12, this.style);
      AppMethodBeat.o(257363);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Zms) + 0 + i.a.a.b.b.a.cJ(2, this.Zmt) + i.a.a.b.b.a.cJ(3, this.Zmu) + i.a.a.b.b.a.cJ(4, this.time) + i.a.a.b.b.a.cJ(5, this.YHv) + i.a.a.b.b.a.cJ(6, this.tNW) + i.a.a.b.b.a.cJ(7, this.pos) + (i.a.a.b.b.a.ko(8) + 1) + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.DVu != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.DVu);
      }
      i = paramInt;
      if (this.YTW != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YTW);
      }
      paramInt = i.a.a.b.b.a.cJ(12, this.style);
      AppMethodBeat.o(257363);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257363);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ael localael = (ael)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(257363);
        return -1;
      case 1: 
        localael.Zms = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 2: 
        localael.Zmt = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 3: 
        localael.Zmu = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 4: 
        localael.time = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 5: 
        localael.YHv = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 6: 
        localael.tNW = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 7: 
        localael.pos = locala.ajGk.aar();
        AppMethodBeat.o(257363);
        return 0;
      case 8: 
        localael.Zmv = locala.ajGk.aai();
        AppMethodBeat.o(257363);
        return 0;
      case 9: 
        localael.Zmw = locala.ajGk.aai();
        AppMethodBeat.o(257363);
        return 0;
      case 10: 
        localael.DVu = locala.ajGk.readString();
        AppMethodBeat.o(257363);
        return 0;
      case 11: 
        localael.YTW = locala.ajGk.readString();
        AppMethodBeat.o(257363);
        return 0;
      }
      localael.style = locala.ajGk.aar();
      AppMethodBeat.o(257363);
      return 0;
    }
    AppMethodBeat.o(257363);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ael
 * JD-Core Version:    0.7.0.1
 */