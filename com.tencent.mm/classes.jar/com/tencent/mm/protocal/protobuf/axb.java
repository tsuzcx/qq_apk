package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class axb
  extends com.tencent.mm.bv.a
{
  public int wsg;
  public String xmo;
  public String xmp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10197);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xmo != null) {
        paramVarArgs.e(1, this.xmo);
      }
      paramVarArgs.aO(2, this.wsg);
      if (this.xmp != null) {
        paramVarArgs.e(3, this.xmp);
      }
      AppMethodBeat.o(10197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xmo == null) {
        break label327;
      }
    }
    label327:
    for (paramInt = e.a.a.b.b.a.f(1, this.xmo) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wsg);
      paramInt = i;
      if (this.xmp != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xmp);
      }
      AppMethodBeat.o(10197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10197);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        axb localaxb = (axb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10197);
          return -1;
        case 1: 
          localaxb.xmo = locala.CLY.readString();
          AppMethodBeat.o(10197);
          return 0;
        case 2: 
          localaxb.wsg = locala.CLY.sl();
          AppMethodBeat.o(10197);
          return 0;
        }
        localaxb.xmp = locala.CLY.readString();
        AppMethodBeat.o(10197);
        return 0;
      }
      AppMethodBeat.o(10197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axb
 * JD-Core Version:    0.7.0.1
 */