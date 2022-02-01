package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;

public final class jc
  extends com.tencent.mm.bx.a
{
  public b FCd;
  public b FCe;
  public int FCf;
  public b FCg;
  public int Scene;
  public int qdX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FCd != null) {
        paramVarArgs.c(1, this.FCd);
      }
      paramVarArgs.aS(2, this.qdX);
      if (this.FCe != null) {
        paramVarArgs.c(3, this.FCe);
      }
      paramVarArgs.aS(4, this.FCf);
      if (this.FCg != null) {
        paramVarArgs.c(5, this.FCg);
      }
      paramVarArgs.aS(6, this.Scene);
      AppMethodBeat.o(133156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FCd == null) {
        break label470;
      }
    }
    label470:
    for (paramInt = f.a.a.b.b.a.b(1, this.FCd) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qdX);
      paramInt = i;
      if (this.FCe != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.FCe);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.FCf);
      paramInt = i;
      if (this.FCg != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FCg);
      }
      i = f.a.a.b.b.a.bz(6, this.Scene);
      AppMethodBeat.o(133156);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(133156);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        jc localjc = (jc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(133156);
          return -1;
        case 1: 
          localjc.FCd = locala.NPN.gxI();
          AppMethodBeat.o(133156);
          return 0;
        case 2: 
          localjc.qdX = locala.NPN.zc();
          AppMethodBeat.o(133156);
          return 0;
        case 3: 
          localjc.FCe = locala.NPN.gxI();
          AppMethodBeat.o(133156);
          return 0;
        case 4: 
          localjc.FCf = locala.NPN.zc();
          AppMethodBeat.o(133156);
          return 0;
        case 5: 
          localjc.FCg = locala.NPN.gxI();
          AppMethodBeat.o(133156);
          return 0;
        }
        localjc.Scene = locala.NPN.zc();
        AppMethodBeat.o(133156);
        return 0;
      }
      AppMethodBeat.o(133156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jc
 * JD-Core Version:    0.7.0.1
 */