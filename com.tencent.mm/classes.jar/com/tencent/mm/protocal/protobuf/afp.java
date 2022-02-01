package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afp
  extends com.tencent.mm.bw.a
{
  public int ExE;
  public String ExF;
  public String ExG;
  public String ExS;
  public String ExT;
  public int ExU;
  public int ExV;
  public String ExW;
  public String ExX;
  public String ExY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ExE);
      if (this.ExF != null) {
        paramVarArgs.d(2, this.ExF);
      }
      if (this.ExS != null) {
        paramVarArgs.d(3, this.ExS);
      }
      if (this.ExT != null) {
        paramVarArgs.d(4, this.ExT);
      }
      paramVarArgs.aR(5, this.ExU);
      paramVarArgs.aR(6, this.ExV);
      if (this.ExW != null) {
        paramVarArgs.d(7, this.ExW);
      }
      if (this.ExG != null) {
        paramVarArgs.d(8, this.ExG);
      }
      if (this.ExX != null) {
        paramVarArgs.d(9, this.ExX);
      }
      if (this.ExY != null) {
        paramVarArgs.d(10, this.ExY);
      }
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.ExE) + 0;
      paramInt = i;
      if (this.ExF != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ExF);
      }
      i = paramInt;
      if (this.ExS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ExS);
      }
      paramInt = i;
      if (this.ExT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ExT);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.ExU) + f.a.a.b.b.a.bx(6, this.ExV);
      paramInt = i;
      if (this.ExW != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ExW);
      }
      i = paramInt;
      if (this.ExG != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.ExG);
      }
      paramInt = i;
      if (this.ExX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ExX);
      }
      i = paramInt;
      if (this.ExY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.ExY);
      }
      AppMethodBeat.o(32206);
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
      AppMethodBeat.o(32206);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afp localafp = (afp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32206);
        return -1;
      case 1: 
        localafp.ExE = locala.LVo.xF();
        AppMethodBeat.o(32206);
        return 0;
      case 2: 
        localafp.ExF = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 3: 
        localafp.ExS = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 4: 
        localafp.ExT = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 5: 
        localafp.ExU = locala.LVo.xF();
        AppMethodBeat.o(32206);
        return 0;
      case 6: 
        localafp.ExV = locala.LVo.xF();
        AppMethodBeat.o(32206);
        return 0;
      case 7: 
        localafp.ExW = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 8: 
        localafp.ExG = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      case 9: 
        localafp.ExX = locala.LVo.readString();
        AppMethodBeat.o(32206);
        return 0;
      }
      localafp.ExY = locala.LVo.readString();
      AppMethodBeat.o(32206);
      return 0;
    }
    AppMethodBeat.o(32206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afp
 * JD-Core Version:    0.7.0.1
 */