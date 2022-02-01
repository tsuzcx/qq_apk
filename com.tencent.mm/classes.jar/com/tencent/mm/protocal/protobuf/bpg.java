package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bpg
  extends com.tencent.mm.bx.a
{
  public int FWG;
  public String ufM;
  public String wMs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32332);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FWG);
      if (this.wMs != null) {
        paramVarArgs.d(2, this.wMs);
      }
      if (this.ufM != null) {
        paramVarArgs.d(3, this.ufM);
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FWG) + 0;
      paramInt = i;
      if (this.wMs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.wMs);
      }
      i = paramInt;
      if (this.ufM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ufM);
      }
      AppMethodBeat.o(32332);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(32332);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      bpg localbpg = (bpg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32332);
        return -1;
      case 1: 
        localbpg.FWG = locala.NPN.zc();
        AppMethodBeat.o(32332);
        return 0;
      case 2: 
        localbpg.wMs = locala.NPN.readString();
        AppMethodBeat.o(32332);
        return 0;
      }
      localbpg.ufM = locala.NPN.readString();
      AppMethodBeat.o(32332);
      return 0;
    }
    AppMethodBeat.o(32332);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpg
 * JD-Core Version:    0.7.0.1
 */