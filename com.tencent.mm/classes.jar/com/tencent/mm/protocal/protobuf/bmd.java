package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bmd
  extends com.tencent.mm.bv.a
{
  public int CreateTime;
  public String ntp;
  public String ppY;
  public String pqa;
  public String pqb;
  public int pqc;
  public String pqd;
  public int pqe;
  public int pqf;
  public String pqh;
  public String pqi;
  public String pqj;
  public String pqk;
  public int xAm;
  public String xAy;
  public String xAz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56917);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ppY != null) {
        paramVarArgs.e(1, this.ppY);
      }
      paramVarArgs.aO(2, this.xAm);
      if (this.pqa != null) {
        paramVarArgs.e(3, this.pqa);
      }
      paramVarArgs.aO(4, this.CreateTime);
      if (this.pqb != null) {
        paramVarArgs.e(5, this.pqb);
      }
      paramVarArgs.aO(6, this.pqc);
      if (this.pqd != null) {
        paramVarArgs.e(7, this.pqd);
      }
      paramVarArgs.aO(8, this.pqe);
      paramVarArgs.aO(9, this.pqf);
      if (this.ntp != null) {
        paramVarArgs.e(11, this.ntp);
      }
      if (this.pqh != null) {
        paramVarArgs.e(12, this.pqh);
      }
      if (this.pqi != null) {
        paramVarArgs.e(13, this.pqi);
      }
      if (this.pqj != null) {
        paramVarArgs.e(14, this.pqj);
      }
      if (this.pqk != null) {
        paramVarArgs.e(15, this.pqk);
      }
      if (this.xAy != null) {
        paramVarArgs.e(18, this.xAy);
      }
      if (this.xAz != null) {
        paramVarArgs.e(19, this.xAz);
      }
      AppMethodBeat.o(56917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ppY == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = e.a.a.b.b.a.f(1, this.ppY) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xAm);
      paramInt = i;
      if (this.pqa != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.pqa);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.CreateTime);
      paramInt = i;
      if (this.pqb != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.pqb);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.pqc);
      paramInt = i;
      if (this.pqd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.pqd);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.pqe) + e.a.a.b.b.a.bl(9, this.pqf);
      paramInt = i;
      if (this.ntp != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.ntp);
      }
      i = paramInt;
      if (this.pqh != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.pqh);
      }
      paramInt = i;
      if (this.pqi != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.pqi);
      }
      i = paramInt;
      if (this.pqj != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.pqj);
      }
      paramInt = i;
      if (this.pqk != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.pqk);
      }
      i = paramInt;
      if (this.xAy != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.xAy);
      }
      paramInt = i;
      if (this.xAz != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xAz);
      }
      AppMethodBeat.o(56917);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56917);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bmd localbmd = (bmd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 10: 
        case 16: 
        case 17: 
        default: 
          AppMethodBeat.o(56917);
          return -1;
        case 1: 
          localbmd.ppY = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 2: 
          localbmd.xAm = locala.CLY.sl();
          AppMethodBeat.o(56917);
          return 0;
        case 3: 
          localbmd.pqa = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 4: 
          localbmd.CreateTime = locala.CLY.sl();
          AppMethodBeat.o(56917);
          return 0;
        case 5: 
          localbmd.pqb = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 6: 
          localbmd.pqc = locala.CLY.sl();
          AppMethodBeat.o(56917);
          return 0;
        case 7: 
          localbmd.pqd = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 8: 
          localbmd.pqe = locala.CLY.sl();
          AppMethodBeat.o(56917);
          return 0;
        case 9: 
          localbmd.pqf = locala.CLY.sl();
          AppMethodBeat.o(56917);
          return 0;
        case 11: 
          localbmd.ntp = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 12: 
          localbmd.pqh = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 13: 
          localbmd.pqi = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 14: 
          localbmd.pqj = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 15: 
          localbmd.pqk = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        case 18: 
          localbmd.xAy = locala.CLY.readString();
          AppMethodBeat.o(56917);
          return 0;
        }
        localbmd.xAz = locala.CLY.readString();
        AppMethodBeat.o(56917);
        return 0;
      }
      AppMethodBeat.o(56917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmd
 * JD-Core Version:    0.7.0.1
 */