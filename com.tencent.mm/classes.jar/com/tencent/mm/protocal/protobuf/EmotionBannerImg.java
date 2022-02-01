package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionBannerImg
  extends com.tencent.mm.bw.a
{
  public int Height;
  public String ImgUrl;
  public String StripUrl;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104769);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ImgUrl != null) {
        paramVarArgs.d(1, this.ImgUrl);
      }
      paramVarArgs.aS(2, this.Width);
      paramVarArgs.aS(3, this.Height);
      if (this.StripUrl != null) {
        paramVarArgs.d(4, this.StripUrl);
      }
      AppMethodBeat.o(104769);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImgUrl == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = f.a.a.b.b.a.e(1, this.ImgUrl) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Width) + f.a.a.b.b.a.bz(3, this.Height);
      paramInt = i;
      if (this.StripUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.StripUrl);
      }
      AppMethodBeat.o(104769);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104769);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        EmotionBannerImg localEmotionBannerImg = (EmotionBannerImg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104769);
          return -1;
        case 1: 
          localEmotionBannerImg.ImgUrl = locala.OmT.readString();
          AppMethodBeat.o(104769);
          return 0;
        case 2: 
          localEmotionBannerImg.Width = locala.OmT.zc();
          AppMethodBeat.o(104769);
          return 0;
        case 3: 
          localEmotionBannerImg.Height = locala.OmT.zc();
          AppMethodBeat.o(104769);
          return 0;
        }
        localEmotionBannerImg.StripUrl = locala.OmT.readString();
        AppMethodBeat.o(104769);
        return 0;
      }
      AppMethodBeat.o(104769);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBannerImg
 * JD-Core Version:    0.7.0.1
 */