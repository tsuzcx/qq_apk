package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class GetEmotionRewardRequest
  extends com.tencent.mm.bx.a
{
  public int OpCode;
  public String ProductID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104802);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ProductID == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductID");
        AppMethodBeat.o(104802);
        throw paramVarArgs;
      }
      if (this.ProductID != null) {
        paramVarArgs.d(1, this.ProductID);
      }
      paramVarArgs.aR(2, this.OpCode);
      AppMethodBeat.o(104802);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label306;
      }
    }
    label306:
    for (paramInt = f.a.a.b.b.a.e(1, this.ProductID) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.OpCode);
      AppMethodBeat.o(104802);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
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
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        GetEmotionRewardRequest localGetEmotionRewardRequest = (GetEmotionRewardRequest)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104802);
          return -1;
        case 1: 
          localGetEmotionRewardRequest.ProductID = locala.KhF.readString();
          AppMethodBeat.o(104802);
          return 0;
        }
        localGetEmotionRewardRequest.OpCode = locala.KhF.xS();
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