package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzy
  extends com.tencent.mm.bx.a
{
  public int IoU;
  public long objectId;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(203887);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.objectId);
      if (this.objectNonceId != null) {
        paramVarArgs.d(2, this.objectNonceId);
      }
      paramVarArgs.aR(3, this.IoU);
      AppMethodBeat.o(203887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.objectId) + 0;
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.objectNonceId);
      }
      i = f.a.a.b.b.a.bA(3, this.IoU);
      AppMethodBeat.o(203887);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(203887);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dzy localdzy = (dzy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(203887);
        return -1;
      case 1: 
        localdzy.objectId = locala.KhF.xT();
        AppMethodBeat.o(203887);
        return 0;
      case 2: 
        localdzy.objectNonceId = locala.KhF.readString();
        AppMethodBeat.o(203887);
        return 0;
      }
      localdzy.IoU = locala.KhF.xS();
      AppMethodBeat.o(203887);
      return 0;
    }
    AppMethodBeat.o(203887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzy
 * JD-Core Version:    0.7.0.1
 */