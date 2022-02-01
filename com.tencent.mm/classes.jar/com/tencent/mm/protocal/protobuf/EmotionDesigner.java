package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionDesigner
  extends com.tencent.mm.bx.a
{
  public String BigImgUrl;
  public String Desc;
  public String Motto;
  public String SmallImgUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104775);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.d(2, this.SmallImgUrl);
      }
      if (this.BigImgUrl != null) {
        paramVarArgs.d(3, this.BigImgUrl);
      }
      if (this.Desc != null) {
        paramVarArgs.d(4, this.Desc);
      }
      if (this.Motto != null) {
        paramVarArgs.d(5, this.Motto);
      }
      AppMethodBeat.o(104775);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.SmallImgUrl);
      }
      i = paramInt;
      if (this.BigImgUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.BigImgUrl);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Desc);
      }
      i = paramInt;
      if (this.Motto != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Motto);
      }
      AppMethodBeat.o(104775);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104775);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        EmotionDesigner localEmotionDesigner = (EmotionDesigner)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104775);
          return -1;
        case 1: 
          localEmotionDesigner.Title = locala.KhF.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 2: 
          localEmotionDesigner.SmallImgUrl = locala.KhF.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 3: 
          localEmotionDesigner.BigImgUrl = locala.KhF.readString();
          AppMethodBeat.o(104775);
          return 0;
        case 4: 
          localEmotionDesigner.Desc = locala.KhF.readString();
          AppMethodBeat.o(104775);
          return 0;
        }
        localEmotionDesigner.Motto = locala.KhF.readString();
        AppMethodBeat.o(104775);
        return 0;
      }
      AppMethodBeat.o(104775);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionDesigner
 * JD-Core Version:    0.7.0.1
 */