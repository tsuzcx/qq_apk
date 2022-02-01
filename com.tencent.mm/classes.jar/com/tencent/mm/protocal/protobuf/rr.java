package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class rr
  extends com.tencent.mm.bw.a
{
  public String Ekb;
  public String Ekc;
  public String country;
  public String descriptor;
  public float dmL;
  public float doB;
  public String exV;
  public String exW;
  public String hEt;
  public String nUG;
  public String nWj;
  public String name;
  public float yhi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113969);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.descriptor != null) {
        paramVarArgs.d(2, this.descriptor);
      }
      if (this.nUG != null) {
        paramVarArgs.d(3, this.nUG);
      }
      if (this.country != null) {
        paramVarArgs.d(4, this.country);
      }
      if (this.exV != null) {
        paramVarArgs.d(5, this.exV);
      }
      if (this.exW != null) {
        paramVarArgs.d(6, this.exW);
      }
      if (this.hEt != null) {
        paramVarArgs.d(7, this.hEt);
      }
      paramVarArgs.x(8, this.yhi);
      paramVarArgs.x(9, this.doB);
      paramVarArgs.x(10, this.dmL);
      if (this.nWj != null) {
        paramVarArgs.d(11, this.nWj);
      }
      if (this.Ekb != null) {
        paramVarArgs.d(12, this.Ekb);
      }
      if (this.Ekc != null) {
        paramVarArgs.d(13, this.Ekc);
      }
      AppMethodBeat.o(113969);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label903;
      }
    }
    label903:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.descriptor != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.descriptor);
      }
      i = paramInt;
      if (this.nUG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nUG);
      }
      paramInt = i;
      if (this.country != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.country);
      }
      i = paramInt;
      if (this.exV != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.exV);
      }
      paramInt = i;
      if (this.exW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.exW);
      }
      i = paramInt;
      if (this.hEt != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hEt);
      }
      i = i + (f.a.a.b.b.a.fK(8) + 4) + (f.a.a.b.b.a.fK(9) + 4) + (f.a.a.b.b.a.fK(10) + 4);
      paramInt = i;
      if (this.nWj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.nWj);
      }
      i = paramInt;
      if (this.Ekb != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Ekb);
      }
      paramInt = i;
      if (this.Ekc != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Ekc);
      }
      AppMethodBeat.o(113969);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113969);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rr localrr = (rr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(113969);
          return -1;
        case 1: 
          localrr.name = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 2: 
          localrr.descriptor = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 3: 
          localrr.nUG = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 4: 
          localrr.country = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 5: 
          localrr.exV = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 6: 
          localrr.exW = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 7: 
          localrr.hEt = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 8: 
          localrr.yhi = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(113969);
          return 0;
        case 9: 
          localrr.doB = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(113969);
          return 0;
        case 10: 
          localrr.dmL = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(113969);
          return 0;
        case 11: 
          localrr.nWj = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        case 12: 
          localrr.Ekb = locala.LVo.readString();
          AppMethodBeat.o(113969);
          return 0;
        }
        localrr.Ekc = locala.LVo.readString();
        AppMethodBeat.o(113969);
        return 0;
      }
      AppMethodBeat.o(113969);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rr
 * JD-Core Version:    0.7.0.1
 */