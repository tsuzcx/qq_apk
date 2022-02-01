package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bn
  extends com.tencent.mm.bx.a
{
  public boolean YCY = false;
  public boolean YCZ = false;
  public boolean YDa = false;
  public boolean YDb = false;
  public String YDc = "";
  public String YDd = "";
  public String YDe = "";
  public String YDf = "";
  public int YDg = -1;
  public String zKK = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.YCY);
      paramVarArgs.di(2, this.YCZ);
      paramVarArgs.di(3, this.YDa);
      paramVarArgs.di(4, this.YDb);
      if (this.YDc != null) {
        paramVarArgs.g(5, this.YDc);
      }
      if (this.YDd != null) {
        paramVarArgs.g(6, this.YDd);
      }
      if (this.YDe != null) {
        paramVarArgs.g(7, this.YDe);
      }
      if (this.YDf != null) {
        paramVarArgs.g(8, this.YDf);
      }
      paramVarArgs.bS(9, this.YDg);
      if (this.zKK != null) {
        paramVarArgs.g(10, this.zKK);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 1 + 0 + (i.a.a.b.b.a.ko(2) + 1) + (i.a.a.b.b.a.ko(3) + 1) + (i.a.a.b.b.a.ko(4) + 1);
      paramInt = i;
      if (this.YDc != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YDc);
      }
      i = paramInt;
      if (this.YDd != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YDd);
      }
      paramInt = i;
      if (this.YDe != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YDe);
      }
      i = paramInt;
      if (this.YDf != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YDf);
      }
      i += i.a.a.b.b.a.cJ(9, this.YDg);
      paramInt = i;
      if (this.zKK != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.zKK);
      }
      AppMethodBeat.o(122480);
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
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bn localbn = (bn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbn.YCY = locala.ajGk.aai();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbn.YCZ = locala.ajGk.aai();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbn.YDa = locala.ajGk.aai();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbn.YDb = locala.ajGk.aai();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbn.YDc = locala.ajGk.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbn.YDd = locala.ajGk.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbn.YDe = locala.ajGk.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbn.YDf = locala.ajGk.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbn.YDg = locala.ajGk.aar();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbn.zKK = locala.ajGk.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bn
 * JD-Core Version:    0.7.0.1
 */