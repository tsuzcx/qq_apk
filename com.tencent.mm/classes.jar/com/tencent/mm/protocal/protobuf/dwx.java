package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwx
  extends com.tencent.mm.bx.a
{
  public int EKQ;
  public String EKR;
  public String rNA;
  public String seb;
  public String sed;
  public String see;
  public int sef;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152730);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EKQ);
      if (this.rNA != null) {
        paramVarArgs.d(2, this.rNA);
      }
      if (this.seb != null) {
        paramVarArgs.d(3, this.seb);
      }
      if (this.EKR != null) {
        paramVarArgs.d(4, this.EKR);
      }
      if (this.sed != null) {
        paramVarArgs.d(5, this.sed);
      }
      if (this.see != null) {
        paramVarArgs.d(6, this.see);
      }
      paramVarArgs.aR(7, this.sef);
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EKQ) + 0;
      paramInt = i;
      if (this.rNA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.rNA);
      }
      i = paramInt;
      if (this.seb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.seb);
      }
      paramInt = i;
      if (this.EKR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKR);
      }
      i = paramInt;
      if (this.sed != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sed);
      }
      paramInt = i;
      if (this.see != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.see);
      }
      i = f.a.a.b.b.a.bA(7, this.sef);
      AppMethodBeat.o(152730);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152730);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dwx localdwx = (dwx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152730);
        return -1;
      case 1: 
        localdwx.EKQ = locala.KhF.xS();
        AppMethodBeat.o(152730);
        return 0;
      case 2: 
        localdwx.rNA = locala.KhF.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 3: 
        localdwx.seb = locala.KhF.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 4: 
        localdwx.EKR = locala.KhF.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 5: 
        localdwx.sed = locala.KhF.readString();
        AppMethodBeat.o(152730);
        return 0;
      case 6: 
        localdwx.see = locala.KhF.readString();
        AppMethodBeat.o(152730);
        return 0;
      }
      localdwx.sef = locala.KhF.xS();
      AppMethodBeat.o(152730);
      return 0;
    }
    AppMethodBeat.o(152730);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwx
 * JD-Core Version:    0.7.0.1
 */