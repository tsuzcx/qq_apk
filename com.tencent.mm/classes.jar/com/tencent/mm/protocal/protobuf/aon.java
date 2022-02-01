package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class aon
  extends com.tencent.mm.bw.a
{
  public int EHC;
  public int EHD;
  public b EHE;
  public int count;
  public String oGN;
  public String path;
  public int tfk;
  public String title;
  public String vXx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.tfk);
      paramVarArgs.aR(2, this.count);
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.oGN != null) {
        paramVarArgs.d(4, this.oGN);
      }
      paramVarArgs.aR(5, this.EHC);
      if (this.path != null) {
        paramVarArgs.d(6, this.path);
      }
      if (this.vXx != null) {
        paramVarArgs.d(7, this.vXx);
      }
      paramVarArgs.aR(8, this.EHD);
      if (this.EHE != null) {
        paramVarArgs.c(9, this.EHE);
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.tfk) + 0 + f.a.a.b.b.a.bx(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.title);
      }
      i = paramInt;
      if (this.oGN != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.oGN);
      }
      i += f.a.a.b.b.a.bx(5, this.EHC);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.path);
      }
      i = paramInt;
      if (this.vXx != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.vXx);
      }
      i += f.a.a.b.b.a.bx(8, this.EHD);
      paramInt = i;
      if (this.EHE != null) {
        paramInt = i + f.a.a.b.b.a.b(9, this.EHE);
      }
      AppMethodBeat.o(184212);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aon localaon = (aon)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localaon.tfk = locala.LVo.xF();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localaon.count = locala.LVo.xF();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localaon.title = locala.LVo.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localaon.oGN = locala.LVo.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localaon.EHC = locala.LVo.xF();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localaon.path = locala.LVo.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localaon.vXx = locala.LVo.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localaon.EHD = locala.LVo.xF();
        AppMethodBeat.o(184212);
        return 0;
      }
      localaon.EHE = locala.LVo.gfk();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aon
 * JD-Core Version:    0.7.0.1
 */