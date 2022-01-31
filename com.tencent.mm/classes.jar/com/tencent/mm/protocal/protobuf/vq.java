package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class vq
  extends com.tencent.mm.bv.a
{
  public String ueu;
  public String ulg;
  public String wOr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56768);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ueu != null) {
        paramVarArgs.e(1, this.ueu);
      }
      if (this.ulg != null) {
        paramVarArgs.e(2, this.ulg);
      }
      if (this.wOr != null) {
        paramVarArgs.e(3, this.wOr);
      }
      AppMethodBeat.o(56768);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ueu == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.ueu) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ulg != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ulg);
      }
      i = paramInt;
      if (this.wOr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wOr);
      }
      AppMethodBeat.o(56768);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56768);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        vq localvq = (vq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56768);
          return -1;
        case 1: 
          localvq.ueu = locala.CLY.readString();
          AppMethodBeat.o(56768);
          return 0;
        case 2: 
          localvq.ulg = locala.CLY.readString();
          AppMethodBeat.o(56768);
          return 0;
        }
        localvq.wOr = locala.CLY.readString();
        AppMethodBeat.o(56768);
        return 0;
      }
      AppMethodBeat.o(56768);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vq
 * JD-Core Version:    0.7.0.1
 */