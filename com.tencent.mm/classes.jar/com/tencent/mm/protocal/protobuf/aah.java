package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aah
  extends com.tencent.mm.bw.a
{
  public int Euw;
  public String Eux;
  public String Euy;
  public boolean enable;
  public String kbL;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195045);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.enable);
      paramVarArgs.aR(2, this.Euw);
      if (this.kbL != null) {
        paramVarArgs.d(3, this.kbL);
      }
      if (this.Eux != null) {
        paramVarArgs.d(4, this.Eux);
      }
      if (this.Euy != null) {
        paramVarArgs.d(5, this.Euy);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      AppMethodBeat.o(195045);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 1 + 0 + f.a.a.b.b.a.bx(2, this.Euw);
      paramInt = i;
      if (this.kbL != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.kbL);
      }
      i = paramInt;
      if (this.Eux != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Eux);
      }
      paramInt = i;
      if (this.Euy != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Euy);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.title);
      }
      AppMethodBeat.o(195045);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(195045);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aah localaah = (aah)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(195045);
        return -1;
      case 1: 
        localaah.enable = locala.LVo.fZX();
        AppMethodBeat.o(195045);
        return 0;
      case 2: 
        localaah.Euw = locala.LVo.xF();
        AppMethodBeat.o(195045);
        return 0;
      case 3: 
        localaah.kbL = locala.LVo.readString();
        AppMethodBeat.o(195045);
        return 0;
      case 4: 
        localaah.Eux = locala.LVo.readString();
        AppMethodBeat.o(195045);
        return 0;
      case 5: 
        localaah.Euy = locala.LVo.readString();
        AppMethodBeat.o(195045);
        return 0;
      }
      localaah.title = locala.LVo.readString();
      AppMethodBeat.o(195045);
      return 0;
    }
    AppMethodBeat.o(195045);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aah
 * JD-Core Version:    0.7.0.1
 */