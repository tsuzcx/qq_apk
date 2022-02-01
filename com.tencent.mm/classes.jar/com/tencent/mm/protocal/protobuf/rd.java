package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rd
  extends com.tencent.mm.bx.a
{
  public int CJd;
  public String CQW;
  public String text;
  public int type;
  public String url;
  public int wmA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113966);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.type);
      if (this.text != null) {
        paramVarArgs.d(2, this.text);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.aR(4, this.wmA);
      paramVarArgs.aR(5, this.CJd);
      if (this.CQW != null) {
        paramVarArgs.d(6, this.CQW);
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.type) + 0;
      paramInt = i;
      if (this.text != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.text);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      i = i + f.a.a.b.b.a.bA(4, this.wmA) + f.a.a.b.b.a.bA(5, this.CJd);
      paramInt = i;
      if (this.CQW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CQW);
      }
      AppMethodBeat.o(113966);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(113966);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      rd localrd = (rd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(113966);
        return -1;
      case 1: 
        localrd.type = locala.KhF.xS();
        AppMethodBeat.o(113966);
        return 0;
      case 2: 
        localrd.text = locala.KhF.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 3: 
        localrd.url = locala.KhF.readString();
        AppMethodBeat.o(113966);
        return 0;
      case 4: 
        localrd.wmA = locala.KhF.xS();
        AppMethodBeat.o(113966);
        return 0;
      case 5: 
        localrd.CJd = locala.KhF.xS();
        AppMethodBeat.o(113966);
        return 0;
      }
      localrd.CQW = locala.KhF.readString();
      AppMethodBeat.o(113966);
      return 0;
    }
    AppMethodBeat.o(113966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rd
 * JD-Core Version:    0.7.0.1
 */