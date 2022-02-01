package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public class GetEmotionRewardRequest
  extends com.tencent.mm.bw.a
{
  public int OpCode;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104802);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104802);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      paramVarArgs.aM(2, this.OpCode);
      AppMethodBeat.o(104802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = g.a.a.b.b.a.f(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bu(2, this.OpCode);
      AppMethodBeat.o(104802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.ProductID == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductID");
          AppMethodBeat.o(104802);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104802);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        GetEmotionRewardRequest localGetEmotionRewardRequest = (GetEmotionRewardRequest)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104802);
          return -1;
        case 1: 
          localGetEmotionRewardRequest.ProductID = locala.UbS.readString();
          AppMethodBeat.o(104802);
          return 0;
        }
        localGetEmotionRewardRequest.OpCode = locala.UbS.zi();
        AppMethodBeat.o(104802);
        return 0;
      }
      AppMethodBeat.o(104802);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.GetEmotionRewardRequest
 * JD-Core Version:    0.7.0.1
 */