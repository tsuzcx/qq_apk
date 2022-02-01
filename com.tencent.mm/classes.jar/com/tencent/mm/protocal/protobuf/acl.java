package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acl
  extends com.tencent.mm.bw.a
{
  public String hKR;
  public int key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91430);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.key);
      if (this.hKR != null) {
        paramVarArgs.d(2, this.hKR);
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.key) + 0;
      paramInt = i;
      if (this.hKR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hKR);
      }
      AppMethodBeat.o(91430);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91430);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      acl localacl = (acl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91430);
        return -1;
      case 1: 
        localacl.key = locala.OmT.zc();
        AppMethodBeat.o(91430);
        return 0;
      }
      localacl.hKR = locala.OmT.readString();
      AppMethodBeat.o(91430);
      return 0;
    }
    AppMethodBeat.o(91430);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acl
 * JD-Core Version:    0.7.0.1
 */