package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fm
  extends com.tencent.mm.bw.a
{
  public int DSA;
  public long DSB;
  public int DSC;
  public String DSy;
  public int DSz;
  public long hlF;
  public int idx;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124388);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DSy != null) {
        paramVarArgs.d(1, this.DSy);
      }
      paramVarArgs.aO(2, this.hlF);
      paramVarArgs.aR(3, this.idx);
      paramVarArgs.aR(4, this.DSz);
      paramVarArgs.aR(5, this.DSA);
      paramVarArgs.aO(6, this.DSB);
      paramVarArgs.aR(7, this.DSC);
      if (this.url != null) {
        paramVarArgs.d(8, this.url);
      }
      AppMethodBeat.o(124388);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DSy == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.DSy) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.hlF) + f.a.a.b.b.a.bx(3, this.idx) + f.a.a.b.b.a.bx(4, this.DSz) + f.a.a.b.b.a.bx(5, this.DSA) + f.a.a.b.b.a.p(6, this.DSB) + f.a.a.b.b.a.bx(7, this.DSC);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.url);
      }
      AppMethodBeat.o(124388);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124388);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        fm localfm = (fm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124388);
          return -1;
        case 1: 
          localfm.DSy = locala.LVo.readString();
          AppMethodBeat.o(124388);
          return 0;
        case 2: 
          localfm.hlF = locala.LVo.xG();
          AppMethodBeat.o(124388);
          return 0;
        case 3: 
          localfm.idx = locala.LVo.xF();
          AppMethodBeat.o(124388);
          return 0;
        case 4: 
          localfm.DSz = locala.LVo.xF();
          AppMethodBeat.o(124388);
          return 0;
        case 5: 
          localfm.DSA = locala.LVo.xF();
          AppMethodBeat.o(124388);
          return 0;
        case 6: 
          localfm.DSB = locala.LVo.xG();
          AppMethodBeat.o(124388);
          return 0;
        case 7: 
          localfm.DSC = locala.LVo.xF();
          AppMethodBeat.o(124388);
          return 0;
        }
        localfm.url = locala.LVo.readString();
        AppMethodBeat.o(124388);
        return 0;
      }
      AppMethodBeat.o(124388);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fm
 * JD-Core Version:    0.7.0.1
 */