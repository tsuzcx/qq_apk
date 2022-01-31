package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionCDNUrl
  extends com.tencent.mm.bv.a
{
  public String AesKey;
  public int FileSize;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62535);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      paramVarArgs.aO(3, this.FileSize);
      AppMethodBeat.o(62535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = e.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.AesKey);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.FileSize);
      AppMethodBeat.o(62535);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62535);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        EmotionCDNUrl localEmotionCDNUrl = (EmotionCDNUrl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62535);
          return -1;
        case 1: 
          localEmotionCDNUrl.Url = locala.CLY.readString();
          AppMethodBeat.o(62535);
          return 0;
        case 2: 
          localEmotionCDNUrl.AesKey = locala.CLY.readString();
          AppMethodBeat.o(62535);
          return 0;
        }
        localEmotionCDNUrl.FileSize = locala.CLY.sl();
        AppMethodBeat.o(62535);
        return 0;
      }
      AppMethodBeat.o(62535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionCDNUrl
 * JD-Core Version:    0.7.0.1
 */