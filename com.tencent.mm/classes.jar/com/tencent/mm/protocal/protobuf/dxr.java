package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dxr
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String DPY;
  public int Fkw;
  public int GdX;
  public int ncL;
  public int ndI;
  public String tlJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32560);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tlJ != null) {
        paramVarArgs.d(1, this.tlJ);
      }
      paramVarArgs.aR(2, this.ndI);
      paramVarArgs.aR(3, this.ncL);
      paramVarArgs.aR(4, this.CreateTime);
      paramVarArgs.aR(5, this.Fkw);
      if (this.DPY != null) {
        paramVarArgs.d(6, this.DPY);
      }
      paramVarArgs.aR(7, this.GdX);
      AppMethodBeat.o(32560);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tlJ == null) {
        break label507;
      }
    }
    label507:
    for (paramInt = f.a.a.b.b.a.e(1, this.tlJ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ndI) + f.a.a.b.b.a.bx(3, this.ncL) + f.a.a.b.b.a.bx(4, this.CreateTime) + f.a.a.b.b.a.bx(5, this.Fkw);
      paramInt = i;
      if (this.DPY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DPY);
      }
      i = f.a.a.b.b.a.bx(7, this.GdX);
      AppMethodBeat.o(32560);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32560);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dxr localdxr = (dxr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32560);
          return -1;
        case 1: 
          localdxr.tlJ = locala.LVo.readString();
          AppMethodBeat.o(32560);
          return 0;
        case 2: 
          localdxr.ndI = locala.LVo.xF();
          AppMethodBeat.o(32560);
          return 0;
        case 3: 
          localdxr.ncL = locala.LVo.xF();
          AppMethodBeat.o(32560);
          return 0;
        case 4: 
          localdxr.CreateTime = locala.LVo.xF();
          AppMethodBeat.o(32560);
          return 0;
        case 5: 
          localdxr.Fkw = locala.LVo.xF();
          AppMethodBeat.o(32560);
          return 0;
        case 6: 
          localdxr.DPY = locala.LVo.readString();
          AppMethodBeat.o(32560);
          return 0;
        }
        localdxr.GdX = locala.LVo.xF();
        AppMethodBeat.o(32560);
        return 0;
      }
      AppMethodBeat.o(32560);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxr
 * JD-Core Version:    0.7.0.1
 */