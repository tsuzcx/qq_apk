package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bkk
  extends com.tencent.mm.bx.a
{
  public String Vyi;
  public String YSR;
  public int ZTG;
  public int ZTH;
  public int ZTI;
  public String coverImgUrl;
  public String hAR;
  public int startTime;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259658);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.startTime);
      paramVarArgs.bS(2, this.status);
      if (this.coverImgUrl != null) {
        paramVarArgs.g(3, this.coverImgUrl);
      }
      if (this.YSR != null) {
        paramVarArgs.g(4, this.YSR);
      }
      if (this.hAR != null) {
        paramVarArgs.g(5, this.hAR);
      }
      paramVarArgs.bS(6, this.ZTG);
      paramVarArgs.bS(7, this.ZTH);
      paramVarArgs.bS(8, this.ZTI);
      if (this.Vyi != null) {
        paramVarArgs.g(9, this.Vyi);
      }
      AppMethodBeat.o(259658);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.startTime) + 0 + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.coverImgUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.coverImgUrl);
      }
      i = paramInt;
      if (this.YSR != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YSR);
      }
      paramInt = i;
      if (this.hAR != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.hAR);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.ZTG) + i.a.a.b.b.a.cJ(7, this.ZTH) + i.a.a.b.b.a.cJ(8, this.ZTI);
      paramInt = i;
      if (this.Vyi != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Vyi);
      }
      AppMethodBeat.o(259658);
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
      AppMethodBeat.o(259658);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bkk localbkk = (bkk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259658);
        return -1;
      case 1: 
        localbkk.startTime = locala.ajGk.aar();
        AppMethodBeat.o(259658);
        return 0;
      case 2: 
        localbkk.status = locala.ajGk.aar();
        AppMethodBeat.o(259658);
        return 0;
      case 3: 
        localbkk.coverImgUrl = locala.ajGk.readString();
        AppMethodBeat.o(259658);
        return 0;
      case 4: 
        localbkk.YSR = locala.ajGk.readString();
        AppMethodBeat.o(259658);
        return 0;
      case 5: 
        localbkk.hAR = locala.ajGk.readString();
        AppMethodBeat.o(259658);
        return 0;
      case 6: 
        localbkk.ZTG = locala.ajGk.aar();
        AppMethodBeat.o(259658);
        return 0;
      case 7: 
        localbkk.ZTH = locala.ajGk.aar();
        AppMethodBeat.o(259658);
        return 0;
      case 8: 
        localbkk.ZTI = locala.ajGk.aar();
        AppMethodBeat.o(259658);
        return 0;
      }
      localbkk.Vyi = locala.ajGk.readString();
      AppMethodBeat.o(259658);
      return 0;
    }
    AppMethodBeat.o(259658);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkk
 * JD-Core Version:    0.7.0.1
 */