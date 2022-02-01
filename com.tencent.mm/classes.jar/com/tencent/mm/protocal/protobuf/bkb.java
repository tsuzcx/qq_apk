package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bkb
  extends com.tencent.mm.bw.a
{
  public String EPH;
  public int EZF;
  public long EZG;
  public long EZH;
  public String Eph;
  public long Eub;
  public String drM;
  public int lRv;
  public String nVJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eph != null) {
        paramVarArgs.d(1, this.Eph);
      }
      paramVarArgs.aO(2, this.Eub);
      paramVarArgs.aR(3, this.EZF);
      paramVarArgs.aO(4, this.EZG);
      paramVarArgs.aO(5, this.EZH);
      if (this.EPH != null) {
        paramVarArgs.d(6, this.EPH);
      }
      if (this.nVJ != null) {
        paramVarArgs.d(7, this.nVJ);
      }
      paramVarArgs.aR(8, this.lRv);
      if (this.drM != null) {
        paramVarArgs.d(9, this.drM);
      }
      AppMethodBeat.o(72504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eph == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = f.a.a.b.b.a.e(1, this.Eph) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Eub) + f.a.a.b.b.a.bx(3, this.EZF) + f.a.a.b.b.a.p(4, this.EZG) + f.a.a.b.b.a.p(5, this.EZH);
      paramInt = i;
      if (this.EPH != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EPH);
      }
      i = paramInt;
      if (this.nVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nVJ);
      }
      i += f.a.a.b.b.a.bx(8, this.lRv);
      paramInt = i;
      if (this.drM != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.drM);
      }
      AppMethodBeat.o(72504);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72504);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bkb localbkb = (bkb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72504);
          return -1;
        case 1: 
          localbkb.Eph = locala.LVo.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 2: 
          localbkb.Eub = locala.LVo.xG();
          AppMethodBeat.o(72504);
          return 0;
        case 3: 
          localbkb.EZF = locala.LVo.xF();
          AppMethodBeat.o(72504);
          return 0;
        case 4: 
          localbkb.EZG = locala.LVo.xG();
          AppMethodBeat.o(72504);
          return 0;
        case 5: 
          localbkb.EZH = locala.LVo.xG();
          AppMethodBeat.o(72504);
          return 0;
        case 6: 
          localbkb.EPH = locala.LVo.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 7: 
          localbkb.nVJ = locala.LVo.readString();
          AppMethodBeat.o(72504);
          return 0;
        case 8: 
          localbkb.lRv = locala.LVo.xF();
          AppMethodBeat.o(72504);
          return 0;
        }
        localbkb.drM = locala.LVo.readString();
        AppMethodBeat.o(72504);
        return 0;
      }
      AppMethodBeat.o(72504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkb
 * JD-Core Version:    0.7.0.1
 */