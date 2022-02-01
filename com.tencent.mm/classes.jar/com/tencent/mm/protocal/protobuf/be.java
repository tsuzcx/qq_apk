package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class be
  extends com.tencent.mm.bx.a
{
  public String CvA = "";
  public int CvB = -1;
  public boolean Cvt = false;
  public boolean Cvu = false;
  public boolean Cvv = false;
  public boolean Cvw = false;
  public String Cvx = "";
  public String Cvy = "";
  public String Cvz = "";
  public String pHA = "";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bg(1, this.Cvt);
      paramVarArgs.bg(2, this.Cvu);
      paramVarArgs.bg(3, this.Cvv);
      paramVarArgs.bg(4, this.Cvw);
      if (this.Cvx != null) {
        paramVarArgs.d(5, this.Cvx);
      }
      if (this.Cvy != null) {
        paramVarArgs.d(6, this.Cvy);
      }
      if (this.Cvz != null) {
        paramVarArgs.d(7, this.Cvz);
      }
      if (this.CvA != null) {
        paramVarArgs.d(8, this.CvA);
      }
      paramVarArgs.aR(9, this.CvB);
      if (this.pHA != null) {
        paramVarArgs.d(10, this.pHA);
      }
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fY(1) + 1 + 0 + (f.a.a.b.b.a.fY(2) + 1) + (f.a.a.b.b.a.fY(3) + 1) + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.Cvx != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Cvx);
      }
      i = paramInt;
      if (this.Cvy != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Cvy);
      }
      paramInt = i;
      if (this.Cvz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Cvz);
      }
      i = paramInt;
      if (this.CvA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CvA);
      }
      i += f.a.a.b.b.a.bA(9, this.CvB);
      paramInt = i;
      if (this.pHA != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.pHA);
      }
      AppMethodBeat.o(122480);
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
      AppMethodBeat.o(122480);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      be localbe = (be)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(122480);
        return -1;
      case 1: 
        localbe.Cvt = locala.KhF.fHu();
        AppMethodBeat.o(122480);
        return 0;
      case 2: 
        localbe.Cvu = locala.KhF.fHu();
        AppMethodBeat.o(122480);
        return 0;
      case 3: 
        localbe.Cvv = locala.KhF.fHu();
        AppMethodBeat.o(122480);
        return 0;
      case 4: 
        localbe.Cvw = locala.KhF.fHu();
        AppMethodBeat.o(122480);
        return 0;
      case 5: 
        localbe.Cvx = locala.KhF.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 6: 
        localbe.Cvy = locala.KhF.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 7: 
        localbe.Cvz = locala.KhF.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 8: 
        localbe.CvA = locala.KhF.readString();
        AppMethodBeat.o(122480);
        return 0;
      case 9: 
        localbe.CvB = locala.KhF.xS();
        AppMethodBeat.o(122480);
        return 0;
      }
      localbe.pHA = locala.KhF.readString();
      AppMethodBeat.o(122480);
      return 0;
    }
    AppMethodBeat.o(122480);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.be
 * JD-Core Version:    0.7.0.1
 */