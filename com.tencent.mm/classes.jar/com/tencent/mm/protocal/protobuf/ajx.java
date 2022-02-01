package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ajx
  extends com.tencent.mm.bx.a
{
  public long DlN;
  public int dvW;
  public String objectNonceId;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169013);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.DlN);
      paramVarArgs.aR(2, this.scene);
      paramVarArgs.aR(3, this.dvW);
      if (this.objectNonceId != null) {
        paramVarArgs.d(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.DlN) + 0 + f.a.a.b.b.a.bA(2, this.scene) + f.a.a.b.b.a.bA(3, this.dvW);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.objectNonceId);
      }
      AppMethodBeat.o(169013);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(169013);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ajx localajx = (ajx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169013);
        return -1;
      case 1: 
        localajx.DlN = locala.KhF.xT();
        AppMethodBeat.o(169013);
        return 0;
      case 2: 
        localajx.scene = locala.KhF.xS();
        AppMethodBeat.o(169013);
        return 0;
      case 3: 
        localajx.dvW = locala.KhF.xS();
        AppMethodBeat.o(169013);
        return 0;
      }
      localajx.objectNonceId = locala.KhF.readString();
      AppMethodBeat.o(169013);
      return 0;
    }
    AppMethodBeat.o(169013);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajx
 * JD-Core Version:    0.7.0.1
 */