package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vl
  extends com.tencent.mm.bw.a
{
  public String EpD;
  public String EpE;
  public String EpF;
  public String EpG;
  public String EpH;
  public String EpI;
  public int Scene;
  public int ndI;
  public String tCb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127628);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Scene);
      paramVarArgs.aR(2, this.ndI);
      if (this.EpD != null) {
        paramVarArgs.d(3, this.EpD);
      }
      if (this.EpE != null) {
        paramVarArgs.d(4, this.EpE);
      }
      if (this.tCb != null) {
        paramVarArgs.d(5, this.tCb);
      }
      if (this.EpF != null) {
        paramVarArgs.d(6, this.EpF);
      }
      if (this.EpG != null) {
        paramVarArgs.d(7, this.EpG);
      }
      if (this.EpH != null) {
        paramVarArgs.d(8, this.EpH);
      }
      if (this.EpI != null) {
        paramVarArgs.d(9, this.EpI);
      }
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bx(1, this.Scene) + 0 + f.a.a.b.b.a.bx(2, this.ndI);
      paramInt = i;
      if (this.EpD != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EpD);
      }
      i = paramInt;
      if (this.EpE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EpE);
      }
      paramInt = i;
      if (this.tCb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.tCb);
      }
      i = paramInt;
      if (this.EpF != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.EpF);
      }
      paramInt = i;
      if (this.EpG != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EpG);
      }
      i = paramInt;
      if (this.EpH != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EpH);
      }
      paramInt = i;
      if (this.EpI != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EpI);
      }
      AppMethodBeat.o(127628);
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
      AppMethodBeat.o(127628);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      vl localvl = (vl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(127628);
        return -1;
      case 1: 
        localvl.Scene = locala.LVo.xF();
        AppMethodBeat.o(127628);
        return 0;
      case 2: 
        localvl.ndI = locala.LVo.xF();
        AppMethodBeat.o(127628);
        return 0;
      case 3: 
        localvl.EpD = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 4: 
        localvl.EpE = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 5: 
        localvl.tCb = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 6: 
        localvl.EpF = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 7: 
        localvl.EpG = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      case 8: 
        localvl.EpH = locala.LVo.readString();
        AppMethodBeat.o(127628);
        return 0;
      }
      localvl.EpI = locala.LVo.readString();
      AppMethodBeat.o(127628);
      return 0;
    }
    AppMethodBeat.o(127628);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vl
 * JD-Core Version:    0.7.0.1
 */