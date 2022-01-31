package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar
  extends com.tencent.mm.bv.a
{
  public String gwU;
  public String jJA;
  public int jJS;
  public String jKG;
  public String wmA;
  public int wmq;
  public String wmr;
  public String wms;
  public int wmt;
  public int wmu;
  public String wmv;
  public int wmw;
  public String wmx;
  public String wmy;
  public int wmz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58883);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      paramVarArgs.aO(3, this.wmq);
      if (this.wmr != null) {
        paramVarArgs.e(4, this.wmr);
      }
      if (this.wms != null) {
        paramVarArgs.e(5, this.wms);
      }
      if (this.gwU != null) {
        paramVarArgs.e(6, this.gwU);
      }
      paramVarArgs.aO(8, this.jJS);
      paramVarArgs.aO(9, this.wmt);
      paramVarArgs.aO(10, this.wmu);
      if (this.wmv != null) {
        paramVarArgs.e(11, this.wmv);
      }
      paramVarArgs.aO(12, this.wmw);
      if (this.wmx != null) {
        paramVarArgs.e(13, this.wmx);
      }
      if (this.wmy != null) {
        paramVarArgs.e(14, this.wmy);
      }
      paramVarArgs.aO(15, this.wmz);
      if (this.wmA != null) {
        paramVarArgs.e(16, this.wmA);
      }
      AppMethodBeat.o(58883);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label978;
      }
    }
    label978:
    for (paramInt = e.a.a.b.b.a.f(1, this.jJA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.jKG);
      }
      i += e.a.a.b.b.a.bl(3, this.wmq);
      paramInt = i;
      if (this.wmr != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wmr);
      }
      i = paramInt;
      if (this.wms != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wms);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.gwU);
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.jJS) + e.a.a.b.b.a.bl(9, this.wmt) + e.a.a.b.b.a.bl(10, this.wmu);
      paramInt = i;
      if (this.wmv != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.wmv);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.wmw);
      paramInt = i;
      if (this.wmx != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wmx);
      }
      i = paramInt;
      if (this.wmy != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.wmy);
      }
      i += e.a.a.b.b.a.bl(15, this.wmz);
      paramInt = i;
      if (this.wmA != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wmA);
      }
      AppMethodBeat.o(58883);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(58883);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ar localar = (ar)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        default: 
          AppMethodBeat.o(58883);
          return -1;
        case 1: 
          localar.jJA = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 2: 
          localar.jKG = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 3: 
          localar.wmq = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        case 4: 
          localar.wmr = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 5: 
          localar.wms = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 6: 
          localar.gwU = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 8: 
          localar.jJS = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        case 9: 
          localar.wmt = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        case 10: 
          localar.wmu = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        case 11: 
          localar.wmv = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 12: 
          localar.wmw = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        case 13: 
          localar.wmx = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 14: 
          localar.wmy = locala.CLY.readString();
          AppMethodBeat.o(58883);
          return 0;
        case 15: 
          localar.wmz = locala.CLY.sl();
          AppMethodBeat.o(58883);
          return 0;
        }
        localar.wmA = locala.CLY.readString();
        AppMethodBeat.o(58883);
        return 0;
      }
      AppMethodBeat.o(58883);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ar
 * JD-Core Version:    0.7.0.1
 */