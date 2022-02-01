package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dhe
  extends com.tencent.mm.bx.a
{
  public String Dts;
  public boolean Exw;
  public boolean Exx = false;
  public String MD5;
  public int Ret;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.MD5 != null) {
        paramVarArgs.d(4, this.MD5);
      }
      paramVarArgs.bg(5, this.Exw);
      if (this.Dts != null) {
        paramVarArgs.d(6, this.Dts);
      }
      paramVarArgs.bg(7, this.Exx);
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ret) + 0 + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.MD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.MD5);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 1);
      paramInt = i;
      if (this.Dts != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dts);
      }
      i = f.a.a.b.b.a.fY(7);
      AppMethodBeat.o(104841);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(104841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dhe localdhe = (dhe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(104841);
        return -1;
      case 1: 
        localdhe.Ret = locala.KhF.xS();
        AppMethodBeat.o(104841);
        return 0;
      case 2: 
        localdhe.uKR = locala.KhF.xS();
        AppMethodBeat.o(104841);
        return 0;
      case 3: 
        localdhe.uKQ = locala.KhF.xS();
        AppMethodBeat.o(104841);
        return 0;
      case 4: 
        localdhe.MD5 = locala.KhF.readString();
        AppMethodBeat.o(104841);
        return 0;
      case 5: 
        localdhe.Exw = locala.KhF.fHu();
        AppMethodBeat.o(104841);
        return 0;
      case 6: 
        localdhe.Dts = locala.KhF.readString();
        AppMethodBeat.o(104841);
        return 0;
      }
      localdhe.Exx = locala.KhF.fHu();
      AppMethodBeat.o(104841);
      return 0;
    }
    AppMethodBeat.o(104841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhe
 * JD-Core Version:    0.7.0.1
 */