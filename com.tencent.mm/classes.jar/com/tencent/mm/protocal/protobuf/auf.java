package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class auf
  extends com.tencent.mm.bv.a
{
  public int xiY;
  public com.tencent.mm.bv.b xiZ;
  public com.tencent.mm.bv.b xja;
  public com.tencent.mm.bv.b xjb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5216);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xiZ == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(5216);
        throw paramVarArgs;
      }
      if (this.xja == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(5216);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xiY);
      if (this.xiZ != null) {
        paramVarArgs.c(2, this.xiZ);
      }
      if (this.xja != null) {
        paramVarArgs.c(3, this.xja);
      }
      if (this.xjb != null) {
        paramVarArgs.c(4, this.xjb);
      }
      AppMethodBeat.o(5216);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xiY) + 0;
      paramInt = i;
      if (this.xiZ != null) {
        paramInt = i + e.a.a.b.b.a.b(2, this.xiZ);
      }
      i = paramInt;
      if (this.xja != null) {
        i = paramInt + e.a.a.b.b.a.b(3, this.xja);
      }
      paramInt = i;
      if (this.xjb != null) {
        paramInt = i + e.a.a.b.b.a.b(4, this.xjb);
      }
      AppMethodBeat.o(5216);
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
      if (this.xiZ == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: SPSBuf");
        AppMethodBeat.o(5216);
        throw paramVarArgs;
      }
      if (this.xja == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: PPSBuf");
        AppMethodBeat.o(5216);
        throw paramVarArgs;
      }
      AppMethodBeat.o(5216);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      auf localauf = (auf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(5216);
        return -1;
      case 1: 
        localauf.xiY = locala.CLY.sl();
        AppMethodBeat.o(5216);
        return 0;
      case 2: 
        localauf.xiZ = locala.CLY.eqS();
        AppMethodBeat.o(5216);
        return 0;
      case 3: 
        localauf.xja = locala.CLY.eqS();
        AppMethodBeat.o(5216);
        return 0;
      }
      localauf.xjb = locala.CLY.eqS();
      AppMethodBeat.o(5216);
      return 0;
    }
    AppMethodBeat.o(5216);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.auf
 * JD-Core Version:    0.7.0.1
 */