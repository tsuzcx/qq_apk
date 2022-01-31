package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxn
  extends com.tencent.mm.bv.a
{
  public String xKK;
  public int xRf;
  public com.tencent.mm.bv.b yeV;
  public com.tencent.mm.bv.b yeW;
  public String yeX;
  public String yeY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28751);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xKK == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(28751);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xRf);
      if (this.xKK != null) {
        paramVarArgs.e(2, this.xKK);
      }
      if (this.yeV != null) {
        paramVarArgs.c(3, this.yeV);
      }
      if (this.yeW != null) {
        paramVarArgs.c(4, this.yeW);
      }
      if (this.yeX != null) {
        paramVarArgs.e(5, this.yeX);
      }
      if (this.yeY != null) {
        paramVarArgs.e(6, this.yeY);
      }
      AppMethodBeat.o(28751);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xRf) + 0;
      paramInt = i;
      if (this.xKK != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xKK);
      }
      i = paramInt;
      if (this.yeV != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.yeV);
      }
      paramInt = i;
      if (this.yeW != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.yeW);
      }
      i = paramInt;
      if (this.yeX != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.yeX);
      }
      paramInt = i;
      if (this.yeY != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.yeY);
      }
      AppMethodBeat.o(28751);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.xKK == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: Msg");
        AppMethodBeat.o(28751);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28751);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxn localcxn = (cxn)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28751);
        return -1;
      case 1: 
        localcxn.xRf = locala.CLY.sl();
        AppMethodBeat.o(28751);
        return 0;
      case 2: 
        localcxn.xKK = locala.CLY.readString();
        AppMethodBeat.o(28751);
        return 0;
      case 3: 
        localcxn.yeV = locala.CLY.eqS();
        AppMethodBeat.o(28751);
        return 0;
      case 4: 
        localcxn.yeW = locala.CLY.eqS();
        AppMethodBeat.o(28751);
        return 0;
      case 5: 
        localcxn.yeX = locala.CLY.readString();
        AppMethodBeat.o(28751);
        return 0;
      }
      localcxn.yeY = locala.CLY.readString();
      AppMethodBeat.o(28751);
      return 0;
    }
    AppMethodBeat.o(28751);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxn
 * JD-Core Version:    0.7.0.1
 */