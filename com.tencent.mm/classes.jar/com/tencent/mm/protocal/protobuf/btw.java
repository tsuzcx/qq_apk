package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class btw
  extends com.tencent.mm.bv.a
{
  public String jKf;
  public int qWW;
  public String wAb;
  public String wAc;
  public String wAd;
  public String wAe;
  public int xHm;
  public int xHn;
  public String xHo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96283);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jKf != null) {
        paramVarArgs.e(1, this.jKf);
      }
      paramVarArgs.aO(2, this.xHm);
      if (this.wAb != null) {
        paramVarArgs.e(3, this.wAb);
      }
      if (this.wAc != null) {
        paramVarArgs.e(4, this.wAc);
      }
      paramVarArgs.aO(5, this.qWW);
      paramVarArgs.aO(6, this.xHn);
      if (this.wAd != null) {
        paramVarArgs.e(7, this.wAd);
      }
      if (this.wAe != null) {
        paramVarArgs.e(8, this.wAe);
      }
      if (this.xHo != null) {
        paramVarArgs.e(9, this.xHo);
      }
      AppMethodBeat.o(96283);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jKf == null) {
        break label654;
      }
    }
    label654:
    for (paramInt = e.a.a.b.b.a.f(1, this.jKf) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xHm);
      paramInt = i;
      if (this.wAb != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wAb);
      }
      i = paramInt;
      if (this.wAc != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wAc);
      }
      i = i + e.a.a.b.b.a.bl(5, this.qWW) + e.a.a.b.b.a.bl(6, this.xHn);
      paramInt = i;
      if (this.wAd != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wAd);
      }
      i = paramInt;
      if (this.wAe != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wAe);
      }
      paramInt = i;
      if (this.xHo != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xHo);
      }
      AppMethodBeat.o(96283);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96283);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        btw localbtw = (btw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96283);
          return -1;
        case 1: 
          localbtw.jKf = locala.CLY.readString();
          AppMethodBeat.o(96283);
          return 0;
        case 2: 
          localbtw.xHm = locala.CLY.sl();
          AppMethodBeat.o(96283);
          return 0;
        case 3: 
          localbtw.wAb = locala.CLY.readString();
          AppMethodBeat.o(96283);
          return 0;
        case 4: 
          localbtw.wAc = locala.CLY.readString();
          AppMethodBeat.o(96283);
          return 0;
        case 5: 
          localbtw.qWW = locala.CLY.sl();
          AppMethodBeat.o(96283);
          return 0;
        case 6: 
          localbtw.xHn = locala.CLY.sl();
          AppMethodBeat.o(96283);
          return 0;
        case 7: 
          localbtw.wAd = locala.CLY.readString();
          AppMethodBeat.o(96283);
          return 0;
        case 8: 
          localbtw.wAe = locala.CLY.readString();
          AppMethodBeat.o(96283);
          return 0;
        }
        localbtw.xHo = locala.CLY.readString();
        AppMethodBeat.o(96283);
        return 0;
      }
      AppMethodBeat.o(96283);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btw
 * JD-Core Version:    0.7.0.1
 */