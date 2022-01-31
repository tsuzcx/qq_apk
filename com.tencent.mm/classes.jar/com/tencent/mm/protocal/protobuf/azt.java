package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class azt
  extends com.tencent.mm.bv.a
{
  public float wDh;
  public float wDi;
  public int wSk;
  public String wSl;
  public String wSm;
  public int wSn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80113);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.q(1, this.wDh);
      paramVarArgs.q(2, this.wDi);
      paramVarArgs.aO(3, this.wSk);
      if (this.wSl != null) {
        paramVarArgs.e(4, this.wSl);
      }
      if (this.wSm != null) {
        paramVarArgs.e(5, this.wSm);
      }
      paramVarArgs.aO(6, this.wSn);
      AppMethodBeat.o(80113);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.eW(1) + 4 + 0 + (e.a.a.b.b.a.eW(2) + 4) + e.a.a.b.b.a.bl(3, this.wSk);
      paramInt = i;
      if (this.wSl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wSl);
      }
      i = paramInt;
      if (this.wSm != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wSm);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wSn);
      AppMethodBeat.o(80113);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(80113);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      azt localazt = (azt)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(80113);
        return -1;
      case 1: 
        localazt.wDh = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(80113);
        return 0;
      case 2: 
        localazt.wDi = Float.intBitsToFloat(locala.CLY.emx());
        AppMethodBeat.o(80113);
        return 0;
      case 3: 
        localazt.wSk = locala.CLY.sl();
        AppMethodBeat.o(80113);
        return 0;
      case 4: 
        localazt.wSl = locala.CLY.readString();
        AppMethodBeat.o(80113);
        return 0;
      case 5: 
        localazt.wSm = locala.CLY.readString();
        AppMethodBeat.o(80113);
        return 0;
      }
      localazt.wSn = locala.CLY.sl();
      AppMethodBeat.o(80113);
      return 0;
    }
    AppMethodBeat.o(80113);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azt
 * JD-Core Version:    0.7.0.1
 */