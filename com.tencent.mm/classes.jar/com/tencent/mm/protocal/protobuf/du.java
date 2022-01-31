package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class du
  extends com.tencent.mm.bv.a
{
  public String Id;
  public String jKg;
  public String ntp;
  public String wpJ;
  public String wpK;
  public int wpL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94507);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      if (this.jKg != null) {
        paramVarArgs.e(2, this.jKg);
      }
      if (this.ntp != null) {
        paramVarArgs.e(3, this.ntp);
      }
      if (this.wpJ != null) {
        paramVarArgs.e(4, this.wpJ);
      }
      if (this.wpK != null) {
        paramVarArgs.e(5, this.wpK);
      }
      paramVarArgs.aO(6, this.wpL);
      AppMethodBeat.o(94507);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label502;
      }
    }
    label502:
    for (int i = e.a.a.b.b.a.f(1, this.Id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKg != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKg);
      }
      i = paramInt;
      if (this.ntp != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ntp);
      }
      paramInt = i;
      if (this.wpJ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wpJ);
      }
      i = paramInt;
      if (this.wpK != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wpK);
      }
      paramInt = e.a.a.b.b.a.bl(6, this.wpL);
      AppMethodBeat.o(94507);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94507);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        du localdu = (du)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(94507);
          return -1;
        case 1: 
          localdu.Id = locala.CLY.readString();
          AppMethodBeat.o(94507);
          return 0;
        case 2: 
          localdu.jKg = locala.CLY.readString();
          AppMethodBeat.o(94507);
          return 0;
        case 3: 
          localdu.ntp = locala.CLY.readString();
          AppMethodBeat.o(94507);
          return 0;
        case 4: 
          localdu.wpJ = locala.CLY.readString();
          AppMethodBeat.o(94507);
          return 0;
        case 5: 
          localdu.wpK = locala.CLY.readString();
          AppMethodBeat.o(94507);
          return 0;
        }
        localdu.wpL = locala.CLY.sl();
        AppMethodBeat.o(94507);
        return 0;
      }
      AppMethodBeat.o(94507);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.du
 * JD-Core Version:    0.7.0.1
 */