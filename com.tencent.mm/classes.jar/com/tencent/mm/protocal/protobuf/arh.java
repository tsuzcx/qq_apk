package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class arh
  extends com.tencent.mm.bx.a
{
  public String Gnu;
  public float dAp;
  public float dyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(164044);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gnu != null) {
        paramVarArgs.d(1, this.Gnu);
      }
      paramVarArgs.z(2, this.dAp);
      paramVarArgs.z(3, this.dyz);
      AppMethodBeat.o(164044);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gnu == null) {
        break label304;
      }
    }
    label304:
    for (paramInt = f.a.a.b.b.a.e(1, this.Gnu) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      AppMethodBeat.o(164044);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(164044);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        arh localarh = (arh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(164044);
          return -1;
        case 1: 
          localarh.Gnu = locala.NPN.readString();
          AppMethodBeat.o(164044);
          return 0;
        case 2: 
          localarh.dAp = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(164044);
          return 0;
        }
        localarh.dyz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(164044);
        return 0;
      }
      AppMethodBeat.o(164044);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arh
 * JD-Core Version:    0.7.0.1
 */