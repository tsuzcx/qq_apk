package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;

public final class bkw
  extends com.tencent.mm.bv.a
{
  public int jJS;
  public int wuC;
  public String xzA;
  public String xzw;
  public b xzx;
  public b xzy;
  public b xzz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56882);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xzw != null) {
        paramVarArgs.e(1, this.xzw);
      }
      paramVarArgs.aO(2, this.jJS);
      if (this.xzx != null) {
        paramVarArgs.c(3, this.xzx);
      }
      if (this.xzy != null) {
        paramVarArgs.c(4, this.xzy);
      }
      if (this.xzz != null) {
        paramVarArgs.c(5, this.xzz);
      }
      paramVarArgs.aO(6, this.wuC);
      if (this.xzA != null) {
        paramVarArgs.e(7, this.xzA);
      }
      AppMethodBeat.o(56882);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xzw == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = e.a.a.b.b.a.f(1, this.xzw) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jJS);
      paramInt = i;
      if (this.xzx != null) {
        paramInt = i + e.a.a.b.b.a.b(3, this.xzx);
      }
      i = paramInt;
      if (this.xzy != null) {
        i = paramInt + e.a.a.b.b.a.b(4, this.xzy);
      }
      paramInt = i;
      if (this.xzz != null) {
        paramInt = i + e.a.a.b.b.a.b(5, this.xzz);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.wuC);
      paramInt = i;
      if (this.xzA != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xzA);
      }
      AppMethodBeat.o(56882);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56882);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bkw localbkw = (bkw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56882);
          return -1;
        case 1: 
          localbkw.xzw = locala.CLY.readString();
          AppMethodBeat.o(56882);
          return 0;
        case 2: 
          localbkw.jJS = locala.CLY.sl();
          AppMethodBeat.o(56882);
          return 0;
        case 3: 
          localbkw.xzx = locala.CLY.eqS();
          AppMethodBeat.o(56882);
          return 0;
        case 4: 
          localbkw.xzy = locala.CLY.eqS();
          AppMethodBeat.o(56882);
          return 0;
        case 5: 
          localbkw.xzz = locala.CLY.eqS();
          AppMethodBeat.o(56882);
          return 0;
        case 6: 
          localbkw.wuC = locala.CLY.sl();
          AppMethodBeat.o(56882);
          return 0;
        }
        localbkw.xzA = locala.CLY.readString();
        AppMethodBeat.o(56882);
        return 0;
      }
      AppMethodBeat.o(56882);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkw
 * JD-Core Version:    0.7.0.1
 */