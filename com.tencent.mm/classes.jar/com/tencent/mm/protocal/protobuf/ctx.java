package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ctx
  extends com.tencent.mm.bv.a
{
  public String wNs;
  public String ycL;
  public String ycM;
  public String ycN;
  public int ycO;
  public float ycP;
  public float ycQ;
  public String ycR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(102402);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ycL != null) {
        paramVarArgs.e(1, this.ycL);
      }
      if (this.wNs != null) {
        paramVarArgs.e(2, this.wNs);
      }
      if (this.ycM != null) {
        paramVarArgs.e(3, this.ycM);
      }
      if (this.ycN != null) {
        paramVarArgs.e(4, this.ycN);
      }
      paramVarArgs.aO(5, this.ycO);
      paramVarArgs.q(6, this.ycP);
      paramVarArgs.q(7, this.ycQ);
      if (this.ycR != null) {
        paramVarArgs.e(8, this.ycR);
      }
      AppMethodBeat.o(102402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ycL == null) {
        break label592;
      }
    }
    label592:
    for (int i = e.a.a.b.b.a.f(1, this.ycL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wNs != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wNs);
      }
      i = paramInt;
      if (this.ycM != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ycM);
      }
      paramInt = i;
      if (this.ycN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ycN);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.ycO) + (e.a.a.b.b.a.eW(6) + 4) + (e.a.a.b.b.a.eW(7) + 4);
      paramInt = i;
      if (this.ycR != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.ycR);
      }
      AppMethodBeat.o(102402);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(102402);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ctx localctx = (ctx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(102402);
          return -1;
        case 1: 
          localctx.ycL = locala.CLY.readString();
          AppMethodBeat.o(102402);
          return 0;
        case 2: 
          localctx.wNs = locala.CLY.readString();
          AppMethodBeat.o(102402);
          return 0;
        case 3: 
          localctx.ycM = locala.CLY.readString();
          AppMethodBeat.o(102402);
          return 0;
        case 4: 
          localctx.ycN = locala.CLY.readString();
          AppMethodBeat.o(102402);
          return 0;
        case 5: 
          localctx.ycO = locala.CLY.sl();
          AppMethodBeat.o(102402);
          return 0;
        case 6: 
          localctx.ycP = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(102402);
          return 0;
        case 7: 
          localctx.ycQ = Float.intBitsToFloat(locala.CLY.emx());
          AppMethodBeat.o(102402);
          return 0;
        }
        localctx.ycR = locala.CLY.readString();
        AppMethodBeat.o(102402);
        return 0;
      }
      AppMethodBeat.o(102402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctx
 * JD-Core Version:    0.7.0.1
 */