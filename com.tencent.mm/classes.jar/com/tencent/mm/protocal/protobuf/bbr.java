package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbr
  extends com.tencent.mm.bx.a
{
  public int Ctr;
  public String DpA;
  public int Dzl;
  public String Dzm;
  public String Dzn;
  public int Ret;
  public String Title;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.DpA != null) {
        paramVarArgs.d(2, this.DpA);
      }
      paramVarArgs.aR(3, this.Ctr);
      paramVarArgs.aR(4, this.Dzl);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(6, this.mAQ);
      }
      if (this.Dzm != null) {
        paramVarArgs.d(7, this.Dzm);
      }
      if (this.Dzn != null) {
        paramVarArgs.d(8, this.Dzn);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.Ret) + 0;
      paramInt = i;
      if (this.DpA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DpA);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.Ctr) + f.a.a.b.b.a.bA(4, this.Dzl);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.mAQ);
      }
      paramInt = i;
      if (this.Dzm != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Dzm);
      }
      i = paramInt;
      if (this.Dzn != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Dzn);
      }
      AppMethodBeat.o(152608);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bbr localbbr = (bbr)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localbbr.Ret = locala.KhF.xS();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localbbr.DpA = locala.KhF.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localbbr.Ctr = locala.KhF.xS();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localbbr.Dzl = locala.KhF.xS();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localbbr.Title = locala.KhF.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localbbr.mAQ = locala.KhF.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localbbr.Dzm = locala.KhF.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localbbr.Dzn = locala.KhF.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbr
 * JD-Core Version:    0.7.0.1
 */