package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cca
  extends com.tencent.mm.bv.a
{
  public int Height;
  public int Width;
  public String wQr;
  public String xJh;
  public String xMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28654);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wQr != null) {
        paramVarArgs.e(1, this.wQr);
      }
      paramVarArgs.aO(2, this.Width);
      paramVarArgs.aO(3, this.Height);
      if (this.xJh != null) {
        paramVarArgs.e(4, this.xJh);
      }
      if (this.xMy != null) {
        paramVarArgs.e(5, this.xMy);
      }
      AppMethodBeat.o(28654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wQr == null) {
        break label433;
      }
    }
    label433:
    for (paramInt = e.a.a.b.b.a.f(1, this.wQr) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Width) + e.a.a.b.b.a.bl(3, this.Height);
      paramInt = i;
      if (this.xJh != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xJh);
      }
      i = paramInt;
      if (this.xMy != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xMy);
      }
      AppMethodBeat.o(28654);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28654);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cca localcca = (cca)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28654);
          return -1;
        case 1: 
          localcca.wQr = locala.CLY.readString();
          AppMethodBeat.o(28654);
          return 0;
        case 2: 
          localcca.Width = locala.CLY.sl();
          AppMethodBeat.o(28654);
          return 0;
        case 3: 
          localcca.Height = locala.CLY.sl();
          AppMethodBeat.o(28654);
          return 0;
        case 4: 
          localcca.xJh = locala.CLY.readString();
          AppMethodBeat.o(28654);
          return 0;
        }
        localcca.xMy = locala.CLY.readString();
        AppMethodBeat.o(28654);
        return 0;
      }
      AppMethodBeat.o(28654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cca
 * JD-Core Version:    0.7.0.1
 */