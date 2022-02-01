package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebh
  extends com.tencent.mm.bw.a
{
  public String IgS;
  public String dlc;
  public String dld;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147800);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlc != null) {
        paramVarArgs.d(1, this.dlc);
      }
      if (this.dld != null) {
        paramVarArgs.d(2, this.dld);
      }
      if (this.IgS != null) {
        paramVarArgs.d(3, this.IgS);
      }
      paramVarArgs.aZ(4, this.timestamp);
      AppMethodBeat.o(147800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlc == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.dlc) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dld != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dld);
      }
      i = paramInt;
      if (this.IgS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.IgS);
      }
      paramInt = f.a.a.b.b.a.p(4, this.timestamp);
      AppMethodBeat.o(147800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(147800);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebh localebh = (ebh)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147800);
          return -1;
        case 1: 
          localebh.dlc = locala.OmT.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 2: 
          localebh.dld = locala.OmT.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 3: 
          localebh.IgS = locala.OmT.readString();
          AppMethodBeat.o(147800);
          return 0;
        }
        localebh.timestamp = locala.OmT.zd();
        AppMethodBeat.o(147800);
        return 0;
      }
      AppMethodBeat.o(147800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebh
 * JD-Core Version:    0.7.0.1
 */