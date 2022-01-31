package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ayw
  extends com.tencent.mm.bv.a
{
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public String wAf;
  public int wWT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(70482);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAb != null) {
        paramVarArgs.e(1, this.wAb);
      }
      if (this.wAc != null) {
        paramVarArgs.e(2, this.wAc);
      }
      if (this.wAd != null) {
        paramVarArgs.e(3, this.wAd);
      }
      if (this.wAe != null) {
        paramVarArgs.e(4, this.wAe);
      }
      if (this.wAf != null) {
        paramVarArgs.e(5, this.wAf);
      }
      paramVarArgs.aO(6, this.wWT);
      AppMethodBeat.o(70482);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wAb == null) {
        break label502;
      }
    }
    label502:
    for (int i = e.a.a.b.b.a.f(1, this.wAb) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wAc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wAc);
      }
      i = paramInt;
      if (this.wAd != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wAd);
      }
      paramInt = i;
      if (this.wAe != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wAe);
      }
      i = paramInt;
      if (this.wAf != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wAf);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wWT);
      AppMethodBeat.o(70482);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(70482);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ayw localayw = (ayw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(70482);
          return -1;
        case 1: 
          localayw.wAb = locala.CLY.readString();
          AppMethodBeat.o(70482);
          return 0;
        case 2: 
          localayw.wAc = locala.CLY.readString();
          AppMethodBeat.o(70482);
          return 0;
        case 3: 
          localayw.wAd = locala.CLY.readString();
          AppMethodBeat.o(70482);
          return 0;
        case 4: 
          localayw.wAe = locala.CLY.readString();
          AppMethodBeat.o(70482);
          return 0;
        case 5: 
          localayw.wAf = locala.CLY.readString();
          AppMethodBeat.o(70482);
          return 0;
        }
        localayw.wWT = locala.CLY.sl();
        AppMethodBeat.o(70482);
        return 0;
      }
      AppMethodBeat.o(70482);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayw
 * JD-Core Version:    0.7.0.1
 */