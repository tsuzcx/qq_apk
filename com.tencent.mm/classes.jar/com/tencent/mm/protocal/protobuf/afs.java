package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afs
  extends com.tencent.mm.bx.a
{
  public int index;
  public String name;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210582);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.index);
      paramVarArgs.aS(2, this.type);
      if (this.name != null) {
        paramVarArgs.d(3, this.name);
      }
      AppMethodBeat.o(210582);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.index) + 0 + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.name != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.name);
      }
      AppMethodBeat.o(210582);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(210582);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      afs localafs = (afs)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(210582);
        return -1;
      case 1: 
        localafs.index = locala.NPN.zc();
        AppMethodBeat.o(210582);
        return 0;
      case 2: 
        localafs.type = locala.NPN.zc();
        AppMethodBeat.o(210582);
        return 0;
      }
      localafs.name = locala.NPN.readString();
      AppMethodBeat.o(210582);
      return 0;
    }
    AppMethodBeat.o(210582);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afs
 * JD-Core Version:    0.7.0.1
 */