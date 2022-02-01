package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dvr
  extends com.tencent.mm.bx.a
{
  public String FIk;
  public String HHX;
  public String HId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207258);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHX != null) {
        paramVarArgs.d(1, this.HHX);
      }
      if (this.FIk != null) {
        paramVarArgs.d(2, this.FIk);
      }
      if (this.HId != null) {
        paramVarArgs.d(3, this.HId);
      }
      paramVarArgs.aS(4, this.scene);
      AppMethodBeat.o(207258);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HHX == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.HHX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FIk != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FIk);
      }
      i = paramInt;
      if (this.HId != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HId);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.scene);
      AppMethodBeat.o(207258);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(207258);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dvr localdvr = (dvr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(207258);
          return -1;
        case 1: 
          localdvr.HHX = locala.NPN.readString();
          AppMethodBeat.o(207258);
          return 0;
        case 2: 
          localdvr.FIk = locala.NPN.readString();
          AppMethodBeat.o(207258);
          return 0;
        case 3: 
          localdvr.HId = locala.NPN.readString();
          AppMethodBeat.o(207258);
          return 0;
        }
        localdvr.scene = locala.NPN.zc();
        AppMethodBeat.o(207258);
        return 0;
      }
      AppMethodBeat.o(207258);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvr
 * JD-Core Version:    0.7.0.1
 */