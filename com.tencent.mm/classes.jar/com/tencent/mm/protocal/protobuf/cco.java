package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cco
  extends com.tencent.mm.bw.a
{
  public String EIR = "";
  public boolean FqW = false;
  public String FqX;
  public boolean FqY;
  public String FqZ = "";
  public int dmJ = -1;
  public String dnh = "";
  public long endTime = 0L;
  public String qoi = "";
  public long seq = 0L;
  public long startTime = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122521);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dnh != null) {
        paramVarArgs.d(1, this.dnh);
      }
      paramVarArgs.bl(2, this.FqW);
      paramVarArgs.aO(3, this.seq);
      paramVarArgs.aO(4, this.startTime);
      paramVarArgs.aO(5, this.endTime);
      paramVarArgs.aR(6, this.dmJ);
      if (this.qoi != null) {
        paramVarArgs.d(7, this.qoi);
      }
      if (this.EIR != null) {
        paramVarArgs.d(8, this.EIR);
      }
      if (this.FqX != null) {
        paramVarArgs.d(9, this.FqX);
      }
      paramVarArgs.bl(10, this.FqY);
      if (this.FqZ != null) {
        paramVarArgs.d(11, this.FqZ);
      }
      AppMethodBeat.o(122521);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dnh == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.b.b.a.e(1, this.dnh) + 0;; paramInt = 0)
    {
      int i = paramInt + (f.a.a.b.b.a.fK(2) + 1) + f.a.a.b.b.a.p(3, this.seq) + f.a.a.b.b.a.p(4, this.startTime) + f.a.a.b.b.a.p(5, this.endTime) + f.a.a.b.b.a.bx(6, this.dmJ);
      paramInt = i;
      if (this.qoi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.qoi);
      }
      i = paramInt;
      if (this.EIR != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.EIR);
      }
      paramInt = i;
      if (this.FqX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FqX);
      }
      i = paramInt + (f.a.a.b.b.a.fK(10) + 1);
      paramInt = i;
      if (this.FqZ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FqZ);
      }
      AppMethodBeat.o(122521);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122521);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cco localcco = (cco)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122521);
          return -1;
        case 1: 
          localcco.dnh = locala.LVo.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 2: 
          localcco.FqW = locala.LVo.fZX();
          AppMethodBeat.o(122521);
          return 0;
        case 3: 
          localcco.seq = locala.LVo.xG();
          AppMethodBeat.o(122521);
          return 0;
        case 4: 
          localcco.startTime = locala.LVo.xG();
          AppMethodBeat.o(122521);
          return 0;
        case 5: 
          localcco.endTime = locala.LVo.xG();
          AppMethodBeat.o(122521);
          return 0;
        case 6: 
          localcco.dmJ = locala.LVo.xF();
          AppMethodBeat.o(122521);
          return 0;
        case 7: 
          localcco.qoi = locala.LVo.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 8: 
          localcco.EIR = locala.LVo.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 9: 
          localcco.FqX = locala.LVo.readString();
          AppMethodBeat.o(122521);
          return 0;
        case 10: 
          localcco.FqY = locala.LVo.fZX();
          AppMethodBeat.o(122521);
          return 0;
        }
        localcco.FqZ = locala.LVo.readString();
        AppMethodBeat.o(122521);
        return 0;
      }
      AppMethodBeat.o(122521);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cco
 * JD-Core Version:    0.7.0.1
 */