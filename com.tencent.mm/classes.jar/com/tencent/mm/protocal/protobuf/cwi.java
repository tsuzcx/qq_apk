package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cwi
  extends com.tencent.mm.bv.a
{
  public String jJE;
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public String wsq;
  public String yex;
  public String yey;
  public String yez;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55729);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wsq != null) {
        paramVarArgs.e(1, this.wsq);
      }
      if (this.wAc != null) {
        paramVarArgs.e(2, this.wAc);
      }
      if (this.wAb != null) {
        paramVarArgs.e(3, this.wAb);
      }
      if (this.jJE != null) {
        paramVarArgs.e(4, this.jJE);
      }
      if (this.yex != null) {
        paramVarArgs.e(5, this.yex);
      }
      if (this.wAd != null) {
        paramVarArgs.e(6, this.wAd);
      }
      if (this.wAe != null) {
        paramVarArgs.e(7, this.wAe);
      }
      if (this.yey != null) {
        paramVarArgs.e(8, this.yey);
      }
      if (this.yez != null) {
        paramVarArgs.e(9, this.yez);
      }
      AppMethodBeat.o(55729);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wsq == null) {
        break label702;
      }
    }
    label702:
    for (int i = e.a.a.b.b.a.f(1, this.wsq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wAc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAc);
      }
      i = paramInt;
      if (this.wAb != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wAb);
      }
      paramInt = i;
      if (this.jJE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.jJE);
      }
      i = paramInt;
      if (this.yex != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.yex);
      }
      paramInt = i;
      if (this.wAd != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wAd);
      }
      i = paramInt;
      if (this.wAe != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wAe);
      }
      paramInt = i;
      if (this.yey != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.yey);
      }
      i = paramInt;
      if (this.yez != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.yez);
      }
      AppMethodBeat.o(55729);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55729);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cwi localcwi = (cwi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(55729);
          return -1;
        case 1: 
          localcwi.wsq = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 2: 
          localcwi.wAc = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 3: 
          localcwi.wAb = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 4: 
          localcwi.jJE = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 5: 
          localcwi.yex = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 6: 
          localcwi.wAd = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 7: 
          localcwi.wAe = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        case 8: 
          localcwi.yey = locala.CLY.readString();
          AppMethodBeat.o(55729);
          return 0;
        }
        localcwi.yez = locala.CLY.readString();
        AppMethodBeat.o(55729);
        return 0;
      }
      AppMethodBeat.o(55729);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwi
 * JD-Core Version:    0.7.0.1
 */