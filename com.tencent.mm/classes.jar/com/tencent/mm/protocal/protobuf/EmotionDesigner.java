package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionDesigner
  extends com.tencent.mm.bv.a
{
  public String BigImgUrl;
  public String Desc;
  public String Motto;
  public String SmallImgUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62539);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.SmallImgUrl != null) {
        paramVarArgs.e(2, this.SmallImgUrl);
      }
      if (this.BigImgUrl != null) {
        paramVarArgs.e(3, this.BigImgUrl);
      }
      if (this.Desc != null) {
        paramVarArgs.e(4, this.Desc);
      }
      if (this.Motto != null) {
        paramVarArgs.e(5, this.Motto);
      }
      AppMethodBeat.o(62539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label454;
      }
    }
    label454:
    for (int i = e.a.a.b.b.a.f(1, this.Title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.SmallImgUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.SmallImgUrl);
      }
      i = paramInt;
      if (this.BigImgUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.BigImgUrl);
      }
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.Desc);
      }
      i = paramInt;
      if (this.Motto != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.Motto);
      }
      AppMethodBeat.o(62539);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62539);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        EmotionDesigner localEmotionDesigner = (EmotionDesigner)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62539);
          return -1;
        case 1: 
          localEmotionDesigner.Title = locala.CLY.readString();
          AppMethodBeat.o(62539);
          return 0;
        case 2: 
          localEmotionDesigner.SmallImgUrl = locala.CLY.readString();
          AppMethodBeat.o(62539);
          return 0;
        case 3: 
          localEmotionDesigner.BigImgUrl = locala.CLY.readString();
          AppMethodBeat.o(62539);
          return 0;
        case 4: 
          localEmotionDesigner.Desc = locala.CLY.readString();
          AppMethodBeat.o(62539);
          return 0;
        }
        localEmotionDesigner.Motto = locala.CLY.readString();
        AppMethodBeat.o(62539);
        return 0;
      }
      AppMethodBeat.o(62539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionDesigner
 * JD-Core Version:    0.7.0.1
 */