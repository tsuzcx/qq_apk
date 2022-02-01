package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ehh
  extends com.tencent.mm.bw.a
{
  public int IkY;
  public String IkZ;
  public String Ila;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124575);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.IkY);
      if (this.IkZ != null) {
        paramVarArgs.d(2, this.IkZ);
      }
      if (this.Ila != null) {
        paramVarArgs.d(3, this.Ila);
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.IkY) + 0;
      paramInt = i;
      if (this.IkZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IkZ);
      }
      i = paramInt;
      if (this.Ila != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Ila);
      }
      AppMethodBeat.o(124575);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124575);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ehh localehh = (ehh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(124575);
        return -1;
      case 1: 
        localehh.IkY = locala.OmT.zc();
        AppMethodBeat.o(124575);
        return 0;
      case 2: 
        localehh.IkZ = locala.OmT.readString();
        AppMethodBeat.o(124575);
        return 0;
      }
      localehh.Ila = locala.OmT.readString();
      AppMethodBeat.o(124575);
      return 0;
    }
    AppMethodBeat.o(124575);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehh
 * JD-Core Version:    0.7.0.1
 */