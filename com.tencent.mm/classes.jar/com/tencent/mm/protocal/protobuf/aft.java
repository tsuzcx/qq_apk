package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class aft
  extends com.tencent.mm.bx.a
{
  public String id;
  public boolean lAr = true;
  public long timestamp;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259736);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id == null)
      {
        paramVarArgs = new b("Not all required fields were included: id");
        AppMethodBeat.o(259736);
        throw paramVarArgs;
      }
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      paramVarArgs.bv(2, this.timestamp);
      paramVarArgs.bS(3, this.type);
      paramVarArgs.di(4, this.lAr);
      AppMethodBeat.o(259736);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label394;
      }
    }
    label394:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.timestamp);
      int j = i.a.a.b.b.a.cJ(3, this.type);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(259736);
      return paramInt + i + j + (k + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.id == null)
        {
          paramVarArgs = new b("Not all required fields were included: id");
          AppMethodBeat.o(259736);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259736);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aft localaft = (aft)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259736);
          return -1;
        case 1: 
          localaft.id = locala.ajGk.readString();
          AppMethodBeat.o(259736);
          return 0;
        case 2: 
          localaft.timestamp = locala.ajGk.aaw();
          AppMethodBeat.o(259736);
          return 0;
        case 3: 
          localaft.type = locala.ajGk.aar();
          AppMethodBeat.o(259736);
          return 0;
        }
        localaft.lAr = locala.ajGk.aai();
        AppMethodBeat.o(259736);
        return 0;
      }
      AppMethodBeat.o(259736);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aft
 * JD-Core Version:    0.7.0.1
 */