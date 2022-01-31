package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpb
  extends com.tencent.mm.bv.a
{
  public int wQS;
  public String wQr;
  public String wXb;
  public int xDh;
  public int xeq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73750);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.xeq);
      if (this.wXb != null) {
        paramVarArgs.e(2, this.wXb);
      }
      if (this.wQr != null) {
        paramVarArgs.e(3, this.wQr);
      }
      paramVarArgs.aO(4, this.wQS);
      paramVarArgs.aO(5, this.xDh);
      AppMethodBeat.o(73750);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xeq) + 0;
      paramInt = i;
      if (this.wXb != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wXb);
      }
      i = paramInt;
      if (this.wQr != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wQr);
      }
      paramInt = e.a.a.b.b.a.bl(4, this.wQS);
      int j = e.a.a.b.b.a.bl(5, this.xDh);
      AppMethodBeat.o(73750);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73750);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bpb localbpb = (bpb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73750);
        return -1;
      case 1: 
        localbpb.xeq = locala.CLY.sl();
        AppMethodBeat.o(73750);
        return 0;
      case 2: 
        localbpb.wXb = locala.CLY.readString();
        AppMethodBeat.o(73750);
        return 0;
      case 3: 
        localbpb.wQr = locala.CLY.readString();
        AppMethodBeat.o(73750);
        return 0;
      case 4: 
        localbpb.wQS = locala.CLY.sl();
        AppMethodBeat.o(73750);
        return 0;
      }
      localbpb.xDh = locala.CLY.sl();
      AppMethodBeat.o(73750);
      return 0;
    }
    AppMethodBeat.o(73750);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpb
 * JD-Core Version:    0.7.0.1
 */