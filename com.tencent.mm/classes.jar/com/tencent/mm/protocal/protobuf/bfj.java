package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bfj
  extends com.tencent.mm.bw.a
{
  public int DLI;
  public String EKB;
  public int EUH;
  public String EUI;
  public String EUJ;
  public int Ret;
  public String Title;
  public String ncR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152608);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.EKB != null) {
        paramVarArgs.d(2, this.EKB);
      }
      paramVarArgs.aR(3, this.DLI);
      paramVarArgs.aR(4, this.EUH);
      if (this.Title != null) {
        paramVarArgs.d(5, this.Title);
      }
      if (this.ncR != null) {
        paramVarArgs.d(6, this.ncR);
      }
      if (this.EUI != null) {
        paramVarArgs.d(7, this.EUI);
      }
      if (this.EUJ != null) {
        paramVarArgs.d(8, this.EUJ);
      }
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.EKB != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EKB);
      }
      i = paramInt + f.a.a.b.b.a.bx(3, this.DLI) + f.a.a.b.b.a.bx(4, this.EUH);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Title);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ncR);
      }
      paramInt = i;
      if (this.EUI != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EUI);
      }
      i = paramInt;
      if (this.EUJ != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EUJ);
      }
      AppMethodBeat.o(152608);
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
      AppMethodBeat.o(152608);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bfj localbfj = (bfj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(152608);
        return -1;
      case 1: 
        localbfj.Ret = locala.LVo.xF();
        AppMethodBeat.o(152608);
        return 0;
      case 2: 
        localbfj.EKB = locala.LVo.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 3: 
        localbfj.DLI = locala.LVo.xF();
        AppMethodBeat.o(152608);
        return 0;
      case 4: 
        localbfj.EUH = locala.LVo.xF();
        AppMethodBeat.o(152608);
        return 0;
      case 5: 
        localbfj.Title = locala.LVo.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 6: 
        localbfj.ncR = locala.LVo.readString();
        AppMethodBeat.o(152608);
        return 0;
      case 7: 
        localbfj.EUI = locala.LVo.readString();
        AppMethodBeat.o(152608);
        return 0;
      }
      localbfj.EUJ = locala.LVo.readString();
      AppMethodBeat.o(152608);
      return 0;
    }
    AppMethodBeat.o(152608);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfj
 * JD-Core Version:    0.7.0.1
 */