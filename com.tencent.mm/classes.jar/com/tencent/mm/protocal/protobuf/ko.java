package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ko
  extends com.tencent.mm.bv.a
{
  public String wxW;
  public int wxX;
  public String wxY;
  public int wxZ;
  public int wya;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151370);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wxW != null) {
        paramVarArgs.e(1, this.wxW);
      }
      paramVarArgs.aO(2, this.wxX);
      if (this.wxY != null) {
        paramVarArgs.e(3, this.wxY);
      }
      paramVarArgs.aO(4, this.wxZ);
      paramVarArgs.aO(5, this.wya);
      AppMethodBeat.o(151370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wxW == null) {
        break label410;
      }
    }
    label410:
    for (paramInt = e.a.a.b.b.a.f(1, this.wxW) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wxX);
      paramInt = i;
      if (this.wxY != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wxY);
      }
      i = e.a.a.b.b.a.bl(4, this.wxZ);
      int j = e.a.a.b.b.a.bl(5, this.wya);
      AppMethodBeat.o(151370);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(151370);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ko localko = (ko)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(151370);
          return -1;
        case 1: 
          localko.wxW = locala.CLY.readString();
          AppMethodBeat.o(151370);
          return 0;
        case 2: 
          localko.wxX = locala.CLY.sl();
          AppMethodBeat.o(151370);
          return 0;
        case 3: 
          localko.wxY = locala.CLY.readString();
          AppMethodBeat.o(151370);
          return 0;
        case 4: 
          localko.wxZ = locala.CLY.sl();
          AppMethodBeat.o(151370);
          return 0;
        }
        localko.wya = locala.CLY.sl();
        AppMethodBeat.o(151370);
        return 0;
      }
      AppMethodBeat.o(151370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ko
 * JD-Core Version:    0.7.0.1
 */