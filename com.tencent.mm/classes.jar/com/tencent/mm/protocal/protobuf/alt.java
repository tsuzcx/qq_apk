package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class alt
  extends com.tencent.mm.bw.a
{
  public String EFm;
  public float dmL;
  public float doB;
  public String exV;
  public String exW;
  public String gPy;
  public String hUi;
  public String yAV;
  public int yAX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.x(1, this.doB);
      paramVarArgs.x(2, this.dmL);
      if (this.exW != null) {
        paramVarArgs.d(3, this.exW);
      }
      if (this.gPy != null) {
        paramVarArgs.d(4, this.gPy);
      }
      if (this.yAV != null) {
        paramVarArgs.d(5, this.yAV);
      }
      if (this.EFm != null) {
        paramVarArgs.d(6, this.EFm);
      }
      paramVarArgs.aR(7, this.yAX);
      if (this.exV != null) {
        paramVarArgs.d(8, this.exV);
      }
      if (this.hUi != null) {
        paramVarArgs.d(9, this.hUi);
      }
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.fK(1) + 4 + 0 + (f.a.a.b.b.a.fK(2) + 4);
      paramInt = i;
      if (this.exW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.exW);
      }
      i = paramInt;
      if (this.gPy != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.gPy);
      }
      paramInt = i;
      if (this.yAV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.yAV);
      }
      i = paramInt;
      if (this.EFm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EFm);
      }
      i += f.a.a.b.b.a.bx(7, this.yAX);
      paramInt = i;
      if (this.exV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.exV);
      }
      i = paramInt;
      if (this.hUi != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hUi);
      }
      AppMethodBeat.o(169004);
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
      AppMethodBeat.o(169004);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      alt localalt = (alt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169004);
        return -1;
      case 1: 
        localalt.doB = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169004);
        return 0;
      case 2: 
        localalt.dmL = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(169004);
        return 0;
      case 3: 
        localalt.exW = locala.LVo.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 4: 
        localalt.gPy = locala.LVo.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 5: 
        localalt.yAV = locala.LVo.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 6: 
        localalt.EFm = locala.LVo.readString();
        AppMethodBeat.o(169004);
        return 0;
      case 7: 
        localalt.yAX = locala.LVo.xF();
        AppMethodBeat.o(169004);
        return 0;
      case 8: 
        localalt.exV = locala.LVo.readString();
        AppMethodBeat.o(169004);
        return 0;
      }
      localalt.hUi = locala.LVo.readString();
      AppMethodBeat.o(169004);
      return 0;
    }
    AppMethodBeat.o(169004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alt
 * JD-Core Version:    0.7.0.1
 */