package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drz
  extends com.tencent.mm.bx.a
{
  public String dpf;
  public String dvs;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181514);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dvs != null) {
        paramVarArgs.d(1, this.dvs);
      }
      if (this.dpf != null) {
        paramVarArgs.d(2, this.dpf);
      }
      paramVarArgs.aS(3, this.scene);
      AppMethodBeat.o(181514);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dvs == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.dvs) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dpf != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dpf);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.scene);
      AppMethodBeat.o(181514);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(181514);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        drz localdrz = (drz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181514);
          return -1;
        case 1: 
          localdrz.dvs = locala.NPN.readString();
          AppMethodBeat.o(181514);
          return 0;
        case 2: 
          localdrz.dpf = locala.NPN.readString();
          AppMethodBeat.o(181514);
          return 0;
        }
        localdrz.scene = locala.NPN.zc();
        AppMethodBeat.o(181514);
        return 0;
      }
      AppMethodBeat.o(181514);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drz
 * JD-Core Version:    0.7.0.1
 */