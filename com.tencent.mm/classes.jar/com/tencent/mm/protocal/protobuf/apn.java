package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apn
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public int DLH;
  public String DPQ;
  public String DPS;
  public String EIv;
  public int EIw;
  public int EIx;
  public int EIy;
  public String hkR;
  public String ncR;
  public String tlX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(149139);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DPQ != null) {
        paramVarArgs.d(1, this.DPQ);
      }
      paramVarArgs.aR(2, this.DLH);
      paramVarArgs.aR(3, this.CreateTime);
      if (this.DPS != null) {
        paramVarArgs.d(4, this.DPS);
      }
      if (this.tlX != null) {
        paramVarArgs.d(5, this.tlX);
      }
      if (this.EIv != null) {
        paramVarArgs.d(6, this.EIv);
      }
      if (this.ncR != null) {
        paramVarArgs.d(7, this.ncR);
      }
      paramVarArgs.aR(8, this.EIw);
      if (this.hkR != null) {
        paramVarArgs.d(9, this.hkR);
      }
      paramVarArgs.aR(10, this.EIx);
      paramVarArgs.aR(11, this.EIy);
      AppMethodBeat.o(149139);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DPQ == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = f.a.a.b.b.a.e(1, this.DPQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DLH) + f.a.a.b.b.a.bx(3, this.CreateTime);
      paramInt = i;
      if (this.DPS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPS);
      }
      i = paramInt;
      if (this.tlX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.tlX);
      }
      paramInt = i;
      if (this.EIv != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIv);
      }
      i = paramInt;
      if (this.ncR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ncR);
      }
      i += f.a.a.b.b.a.bx(8, this.EIw);
      paramInt = i;
      if (this.hkR != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hkR);
      }
      i = f.a.a.b.b.a.bx(10, this.EIx);
      int j = f.a.a.b.b.a.bx(11, this.EIy);
      AppMethodBeat.o(149139);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(149139);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apn localapn = (apn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(149139);
          return -1;
        case 1: 
          localapn.DPQ = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 2: 
          localapn.DLH = locala.LVo.xF();
          AppMethodBeat.o(149139);
          return 0;
        case 3: 
          localapn.CreateTime = locala.LVo.xF();
          AppMethodBeat.o(149139);
          return 0;
        case 4: 
          localapn.DPS = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 5: 
          localapn.tlX = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 6: 
          localapn.EIv = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 7: 
          localapn.ncR = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 8: 
          localapn.EIw = locala.LVo.xF();
          AppMethodBeat.o(149139);
          return 0;
        case 9: 
          localapn.hkR = locala.LVo.readString();
          AppMethodBeat.o(149139);
          return 0;
        case 10: 
          localapn.EIx = locala.LVo.xF();
          AppMethodBeat.o(149139);
          return 0;
        }
        localapn.EIy = locala.LVo.xF();
        AppMethodBeat.o(149139);
        return 0;
      }
      AppMethodBeat.o(149139);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apn
 * JD-Core Version:    0.7.0.1
 */