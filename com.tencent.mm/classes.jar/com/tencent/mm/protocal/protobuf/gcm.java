package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class gcm
  extends com.tencent.mm.bx.a
{
  public String acax;
  public String hzp;
  public String hzq;
  public long timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147800);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hzp != null) {
        paramVarArgs.g(1, this.hzp);
      }
      if (this.hzq != null) {
        paramVarArgs.g(2, this.hzq);
      }
      if (this.acax != null) {
        paramVarArgs.g(3, this.acax);
      }
      paramVarArgs.bv(4, this.timestamp);
      AppMethodBeat.o(147800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hzp == null) {
        break label374;
      }
    }
    label374:
    for (int i = i.a.a.b.b.a.h(1, this.hzp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hzq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hzq);
      }
      i = paramInt;
      if (this.acax != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acax);
      }
      paramInt = i.a.a.b.b.a.q(4, this.timestamp);
      AppMethodBeat.o(147800);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147800);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gcm localgcm = (gcm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(147800);
          return -1;
        case 1: 
          localgcm.hzp = locala.ajGk.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 2: 
          localgcm.hzq = locala.ajGk.readString();
          AppMethodBeat.o(147800);
          return 0;
        case 3: 
          localgcm.acax = locala.ajGk.readString();
          AppMethodBeat.o(147800);
          return 0;
        }
        localgcm.timestamp = locala.ajGk.aaw();
        AppMethodBeat.o(147800);
        return 0;
      }
      AppMethodBeat.o(147800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gcm
 * JD-Core Version:    0.7.0.1
 */