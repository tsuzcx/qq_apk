package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class eew
  extends com.tencent.mm.bw.a
{
  public String HGP;
  public int HKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Talker");
        AppMethodBeat.o(32546);
        throw paramVarArgs;
      }
      if (this.HGP != null) {
        paramVarArgs.d(1, this.HGP);
      }
      paramVarArgs.aS(2, this.HKR);
      AppMethodBeat.o(32546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HGP == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.HGP) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HKR);
      AppMethodBeat.o(32546);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HGP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Talker");
          AppMethodBeat.o(32546);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        eew localeew = (eew)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32546);
          return -1;
        case 1: 
          localeew.HGP = locala.OmT.readString();
          AppMethodBeat.o(32546);
          return 0;
        }
        localeew.HKR = locala.OmT.zc();
        AppMethodBeat.o(32546);
        return 0;
      }
      AppMethodBeat.o(32546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eew
 * JD-Core Version:    0.7.0.1
 */