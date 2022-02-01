package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cas
  extends com.tencent.mm.bx.a
{
  public long dEb;
  public String doh;
  public int state;
  public String wdN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.wdN != null) {
        paramVarArgs.d(1, this.wdN);
      }
      paramVarArgs.aG(2, this.dEb);
      paramVarArgs.aR(3, this.state);
      if (this.doh != null) {
        paramVarArgs.d(4, this.doh);
      }
      AppMethodBeat.o(91619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wdN == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.wdN) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.dEb) + f.a.a.b.b.a.bA(3, this.state);
      paramInt = i;
      if (this.doh != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.doh);
      }
      AppMethodBeat.o(91619);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91619);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cas localcas = (cas)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91619);
          return -1;
        case 1: 
          localcas.wdN = locala.KhF.readString();
          AppMethodBeat.o(91619);
          return 0;
        case 2: 
          localcas.dEb = locala.KhF.xT();
          AppMethodBeat.o(91619);
          return 0;
        case 3: 
          localcas.state = locala.KhF.xS();
          AppMethodBeat.o(91619);
          return 0;
        }
        localcas.doh = locala.KhF.readString();
        AppMethodBeat.o(91619);
        return 0;
      }
      AppMethodBeat.o(91619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cas
 * JD-Core Version:    0.7.0.1
 */