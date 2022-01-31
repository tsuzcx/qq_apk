package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class dbe
  extends com.tencent.mm.bv.a
{
  public String IconUrl;
  public String fKw;
  public String jJA;
  public String jKG;
  public String nuv;
  public String woO;
  public int wwX;
  public b xKJ;
  public String yhl;
  public float yhm;
  public float yhn;
  public int yho;
  public String yhp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151934);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yhl != null) {
        paramVarArgs.e(1, this.yhl);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(3, this.IconUrl);
      }
      if (this.jJA != null) {
        paramVarArgs.e(4, this.jJA);
      }
      paramVarArgs.aO(5, this.wwX);
      if (this.woO != null) {
        paramVarArgs.e(6, this.woO);
      }
      if (this.nuv != null) {
        paramVarArgs.e(7, this.nuv);
      }
      paramVarArgs.q(8, this.yhm);
      paramVarArgs.q(9, this.yhn);
      paramVarArgs.aO(10, this.yho);
      if (this.fKw != null) {
        paramVarArgs.e(11, this.fKw);
      }
      if (this.yhp != null) {
        paramVarArgs.e(12, this.yhp);
      }
      if (this.xKJ != null) {
        paramVarArgs.c(13, this.xKJ);
      }
      AppMethodBeat.o(151934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yhl == null) {
        break label884;
      }
    }
    label884:
    for (int i = e.a.a.b.b.a.f(1, this.yhl) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.IconUrl);
      }
      paramInt = i;
      if (this.jJA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jJA);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wwX);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.woO);
      }
      i = paramInt;
      if (this.nuv != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.nuv);
      }
      i = i + (e.a.a.b.b.a.eW(8) + 4) + (e.a.a.b.b.a.eW(9) + 4) + e.a.a.b.b.a.bl(10, this.yho);
      paramInt = i;
      if (this.fKw != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.fKw);
      }
      i = paramInt;
      if (this.yhp != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.yhp);
      }
      paramInt = i;
      if (this.xKJ != null) {
        paramInt = i + e.a.a.b.b.a.b(13, this.xKJ);
      }
      AppMethodBeat.o(151934);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151934);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        dbe localdbe = (dbe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151934);
          return -1;
        case 1: 
          localdbe.yhl = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 2: 
          localdbe.jKG = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 3: 
          localdbe.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 4: 
          localdbe.jJA = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 5: 
          localdbe.wwX = locala.CLY.sl();
          AppMethodBeat.o(151934);
          return 0;
        case 6: 
          localdbe.woO = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 7: 
          localdbe.nuv = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 8: 
          localdbe.yhm = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(151934);
          return 0;
        case 9: 
          localdbe.yhn = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(151934);
          return 0;
        case 10: 
          localdbe.yho = locala.CLY.sl();
          AppMethodBeat.o(151934);
          return 0;
        case 11: 
          localdbe.fKw = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        case 12: 
          localdbe.yhp = locala.CLY.readString();
          AppMethodBeat.o(151934);
          return 0;
        }
        localdbe.xKJ = locala.CLY.eqS();
        AppMethodBeat.o(151934);
        return 0;
      }
      AppMethodBeat.o(151934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbe
 * JD-Core Version:    0.7.0.1
 */