package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class EmotionDonor
  extends com.tencent.mm.bw.a
{
  public String HeadUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104778);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HeadUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: HeadUrl");
        AppMethodBeat.o(104778);
        throw paramVarArgs;
      }
      if (this.HeadUrl != null) {
        paramVarArgs.d(1, this.HeadUrl);
      }
      AppMethodBeat.o(104778);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HeadUrl == null) {
        break label261;
      }
    }
    label261:
    for (paramInt = f.a.a.b.b.a.e(1, this.HeadUrl) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(104778);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HeadUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: HeadUrl");
          AppMethodBeat.o(104778);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104778);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        EmotionDonor localEmotionDonor = (EmotionDonor)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104778);
          return -1;
        }
        localEmotionDonor.HeadUrl = locala.OmT.readString();
        AppMethodBeat.o(104778);
        return 0;
      }
      AppMethodBeat.o(104778);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionDonor
 * JD-Core Version:    0.7.0.1
 */