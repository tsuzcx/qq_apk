package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cxp
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b wrr;
  public long wsz;
  public int yeZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28753);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wrr == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(28753);
        throw paramVarArgs;
      }
      paramVarArgs.am(1, this.wsz);
      if (this.wrr != null) {
        paramVarArgs.c(2, this.wrr);
      }
      paramVarArgs.aO(3, this.yeZ);
      AppMethodBeat.o(28753);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.p(1, this.wsz) + 0;
      paramInt = i;
      if (this.wrr != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.wrr);
      }
      i = e.a.a.b.b.a.bl(3, this.yeZ);
      AppMethodBeat.o(28753);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wrr == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: VoiceData");
        AppMethodBeat.o(28753);
        throw paramVarArgs;
      }
      AppMethodBeat.o(28753);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      cxp localcxp = (cxp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(28753);
        return -1;
      case 1: 
        localcxp.wsz = locala.CLY.sm();
        AppMethodBeat.o(28753);
        return 0;
      case 2: 
        localcxp.wrr = locala.CLY.eqS();
        AppMethodBeat.o(28753);
        return 0;
      }
      localcxp.yeZ = locala.CLY.sl();
      AppMethodBeat.o(28753);
      return 0;
    }
    AppMethodBeat.o(28753);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxp
 * JD-Core Version:    0.7.0.1
 */