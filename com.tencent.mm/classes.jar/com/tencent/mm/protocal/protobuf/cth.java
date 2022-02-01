package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cth
  extends com.tencent.mm.bx.a
{
  public String nTQ;
  public String tfH;
  public String tfI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91691);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.tfH != null) {
        paramVarArgs.d(1, this.tfH);
      }
      if (this.tfI != null) {
        paramVarArgs.d(2, this.tfI);
      }
      if (this.nTQ != null) {
        paramVarArgs.d(3, this.nTQ);
      }
      AppMethodBeat.o(91691);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tfH == null) {
        break label334;
      }
    }
    label334:
    for (int i = f.a.a.b.b.a.e(1, this.tfH) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tfI != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tfI);
      }
      i = paramInt;
      if (this.nTQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.nTQ);
      }
      AppMethodBeat.o(91691);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91691);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cth localcth = (cth)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91691);
          return -1;
        case 1: 
          localcth.tfH = locala.KhF.readString();
          AppMethodBeat.o(91691);
          return 0;
        case 2: 
          localcth.tfI = locala.KhF.readString();
          AppMethodBeat.o(91691);
          return 0;
        }
        localcth.nTQ = locala.KhF.readString();
        AppMethodBeat.o(91691);
        return 0;
      }
      AppMethodBeat.o(91691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cth
 * JD-Core Version:    0.7.0.1
 */