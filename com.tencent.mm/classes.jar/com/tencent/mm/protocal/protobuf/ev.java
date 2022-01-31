package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ev
  extends com.tencent.mm.bv.a
{
  public int height;
  public long kfu;
  public String url;
  public int width;
  public int wqX;
  public int wqY;
  public int wqZ;
  public int wra;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14706);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      paramVarArgs.aO(2, this.wqX);
      paramVarArgs.aO(3, this.wqY);
      paramVarArgs.am(4, this.kfu);
      paramVarArgs.aO(5, this.width);
      paramVarArgs.aO(6, this.height);
      paramVarArgs.aO(10, this.wqZ);
      paramVarArgs.aO(11, this.wra);
      AppMethodBeat.o(14706);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label568;
      }
    }
    label568:
    for (paramInt = e.a.a.b.b.a.f(1, this.url) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wqX);
      int j = e.a.a.b.b.a.bl(3, this.wqY);
      int k = e.a.a.b.b.a.p(4, this.kfu);
      int m = e.a.a.b.b.a.bl(5, this.width);
      int n = e.a.a.b.b.a.bl(6, this.height);
      int i1 = e.a.a.b.b.a.bl(10, this.wqZ);
      int i2 = e.a.a.b.b.a.bl(11, this.wra);
      AppMethodBeat.o(14706);
      return paramInt + i + j + k + m + n + i1 + i2;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14706);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        ev localev = (ev)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 7: 
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(14706);
          return -1;
        case 1: 
          localev.url = locala.CLY.readString();
          AppMethodBeat.o(14706);
          return 0;
        case 2: 
          localev.wqX = locala.CLY.sl();
          AppMethodBeat.o(14706);
          return 0;
        case 3: 
          localev.wqY = locala.CLY.sl();
          AppMethodBeat.o(14706);
          return 0;
        case 4: 
          localev.kfu = locala.CLY.sm();
          AppMethodBeat.o(14706);
          return 0;
        case 5: 
          localev.width = locala.CLY.sl();
          AppMethodBeat.o(14706);
          return 0;
        case 6: 
          localev.height = locala.CLY.sl();
          AppMethodBeat.o(14706);
          return 0;
        case 10: 
          localev.wqZ = locala.CLY.sl();
          AppMethodBeat.o(14706);
          return 0;
        }
        localev.wra = locala.CLY.sl();
        AppMethodBeat.o(14706);
        return 0;
      }
      AppMethodBeat.o(14706);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ev
 * JD-Core Version:    0.7.0.1
 */