package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class akz
  extends com.tencent.mm.bx.a
{
  public boolean GkR;
  public String dxD;
  public String id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152991);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      paramVarArgs.bt(3, this.GkR);
      AppMethodBeat.o(152991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = f.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dxD != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dxD);
      }
      paramInt = f.a.a.b.b.a.alV(3);
      AppMethodBeat.o(152991);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152991);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        akz localakz = (akz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152991);
          return -1;
        case 1: 
          localakz.id = locala.NPN.readString();
          AppMethodBeat.o(152991);
          return 0;
        case 2: 
          localakz.dxD = locala.NPN.readString();
          AppMethodBeat.o(152991);
          return 0;
        }
        localakz.GkR = locala.NPN.grw();
        AppMethodBeat.o(152991);
        return 0;
      }
      AppMethodBeat.o(152991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akz
 * JD-Core Version:    0.7.0.1
 */