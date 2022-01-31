package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionBannerImg
  extends com.tencent.mm.bv.a
{
  public int Height;
  public String ImgUrl;
  public String StripUrl;
  public int Width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62533);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.ImgUrl != null) {
        paramVarArgs.e(1, this.ImgUrl);
      }
      paramVarArgs.aO(2, this.Width);
      paramVarArgs.aO(3, this.Height);
      if (this.StripUrl != null) {
        paramVarArgs.e(4, this.StripUrl);
      }
      AppMethodBeat.o(62533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ImgUrl == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = e.a.a.b.b.a.f(1, this.ImgUrl) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.Width) + e.a.a.b.b.a.bl(3, this.Height);
      paramInt = i;
      if (this.StripUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.StripUrl);
      }
      AppMethodBeat.o(62533);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62533);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        EmotionBannerImg localEmotionBannerImg = (EmotionBannerImg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62533);
          return -1;
        case 1: 
          localEmotionBannerImg.ImgUrl = locala.CLY.readString();
          AppMethodBeat.o(62533);
          return 0;
        case 2: 
          localEmotionBannerImg.Width = locala.CLY.sl();
          AppMethodBeat.o(62533);
          return 0;
        case 3: 
          localEmotionBannerImg.Height = locala.CLY.sl();
          AppMethodBeat.o(62533);
          return 0;
        }
        localEmotionBannerImg.StripUrl = locala.CLY.readString();
        AppMethodBeat.o(62533);
        return 0;
      }
      AppMethodBeat.o(62533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBannerImg
 * JD-Core Version:    0.7.0.1
 */