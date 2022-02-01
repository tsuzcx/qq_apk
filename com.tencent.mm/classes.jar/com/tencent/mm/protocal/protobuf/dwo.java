package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dwo
  extends com.tencent.mm.bw.a
{
  public String GaH;
  public String IbK;
  public String IbQ;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IbK != null) {
        paramVarArgs.d(1, this.IbK);
      }
      if (this.GaH != null) {
        paramVarArgs.d(2, this.GaH);
      }
      if (this.IbQ != null) {
        paramVarArgs.d(3, this.IbQ);
      }
      paramVarArgs.aS(4, this.scene);
      AppMethodBeat.o(188959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IbK == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.IbK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GaH);
      }
      i = paramInt;
      if (this.IbQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IbQ);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.scene);
      AppMethodBeat.o(188959);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188959);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dwo localdwo = (dwo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188959);
          return -1;
        case 1: 
          localdwo.IbK = locala.OmT.readString();
          AppMethodBeat.o(188959);
          return 0;
        case 2: 
          localdwo.GaH = locala.OmT.readString();
          AppMethodBeat.o(188959);
          return 0;
        case 3: 
          localdwo.IbQ = locala.OmT.readString();
          AppMethodBeat.o(188959);
          return 0;
        }
        localdwo.scene = locala.OmT.zc();
        AppMethodBeat.o(188959);
        return 0;
      }
      AppMethodBeat.o(188959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dwo
 * JD-Core Version:    0.7.0.1
 */