package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bwv
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String iEA;
  public String wAh;
  public int xJY;
  public String xmp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96284);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wAh != null) {
        paramVarArgs.e(1, this.wAh);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      paramVarArgs.aO(3, this.xJY);
      if (this.iEA != null) {
        paramVarArgs.e(4, this.iEA);
      }
      if (this.xmp != null) {
        paramVarArgs.e(5, this.xmp);
      }
      AppMethodBeat.o(96284);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wAh == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = e.a.a.b.b.a.f(1, this.wAh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Desc);
      }
      i += e.a.a.b.b.a.bl(3, this.xJY);
      paramInt = i;
      if (this.iEA != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.iEA);
      }
      i = paramInt;
      if (this.xmp != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xmp);
      }
      AppMethodBeat.o(96284);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(96284);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bwv localbwv = (bwv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(96284);
          return -1;
        case 1: 
          localbwv.wAh = locala.CLY.readString();
          AppMethodBeat.o(96284);
          return 0;
        case 2: 
          localbwv.Desc = locala.CLY.readString();
          AppMethodBeat.o(96284);
          return 0;
        case 3: 
          localbwv.xJY = locala.CLY.sl();
          AppMethodBeat.o(96284);
          return 0;
        case 4: 
          localbwv.iEA = locala.CLY.readString();
          AppMethodBeat.o(96284);
          return 0;
        }
        localbwv.xmp = locala.CLY.readString();
        AppMethodBeat.o(96284);
        return 0;
      }
      AppMethodBeat.o(96284);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwv
 * JD-Core Version:    0.7.0.1
 */