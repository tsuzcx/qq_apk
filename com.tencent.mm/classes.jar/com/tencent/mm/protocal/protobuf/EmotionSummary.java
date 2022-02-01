package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionSummary
  extends com.tencent.mm.bx.a
{
  public String CoverUrl;
  public String ExptDesc;
  public String IconUrl;
  public String Introduce;
  public String PackAuthInfo;
  public String PackCopyright;
  public String PackDesc;
  public int PackExpire;
  public int PackFlag;
  public String PackName;
  public String PackPrice;
  public int PackType;
  public String PanelUrl;
  public String PriceNum;
  public String PriceType;
  public String ProductID;
  public String SendInfo;
  public String TagUri;
  public String TimeLimitStr;
  public int Timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104781);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.d(1, this.ProductID);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(2, this.IconUrl);
      }
      if (this.PackName != null) {
        paramVarArgs.d(3, this.PackName);
      }
      if (this.PackDesc != null) {
        paramVarArgs.d(4, this.PackDesc);
      }
      if (this.PackAuthInfo != null) {
        paramVarArgs.d(5, this.PackAuthInfo);
      }
      if (this.PackPrice != null) {
        paramVarArgs.d(6, this.PackPrice);
      }
      paramVarArgs.aR(7, this.PackType);
      paramVarArgs.aR(8, this.PackFlag);
      if (this.CoverUrl != null) {
        paramVarArgs.d(9, this.CoverUrl);
      }
      paramVarArgs.aR(10, this.PackExpire);
      if (this.PackCopyright != null) {
        paramVarArgs.d(11, this.PackCopyright);
      }
      paramVarArgs.aR(12, this.Timestamp);
      if (this.PanelUrl != null) {
        paramVarArgs.d(13, this.PanelUrl);
      }
      if (this.PriceNum != null) {
        paramVarArgs.d(14, this.PriceNum);
      }
      if (this.PriceType != null) {
        paramVarArgs.d(15, this.PriceType);
      }
      if (this.SendInfo != null) {
        paramVarArgs.d(16, this.SendInfo);
      }
      if (this.TimeLimitStr != null) {
        paramVarArgs.d(17, this.TimeLimitStr);
      }
      if (this.Introduce != null) {
        paramVarArgs.d(18, this.Introduce);
      }
      if (this.TagUri != null) {
        paramVarArgs.d(19, this.TagUri);
      }
      if (this.ExptDesc != null) {
        paramVarArgs.d(20, this.ExptDesc);
      }
      AppMethodBeat.o(104781);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label1318;
      }
    }
    label1318:
    for (int i = f.a.a.b.b.a.e(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IconUrl);
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.PackName);
      }
      paramInt = i;
      if (this.PackDesc != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.PackDesc);
      }
      i = paramInt;
      if (this.PackAuthInfo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.PackAuthInfo);
      }
      paramInt = i;
      if (this.PackPrice != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.PackPrice);
      }
      i = paramInt + f.a.a.b.b.a.bA(7, this.PackType) + f.a.a.b.b.a.bA(8, this.PackFlag);
      paramInt = i;
      if (this.CoverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CoverUrl);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.PackExpire);
      paramInt = i;
      if (this.PackCopyright != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.PackCopyright);
      }
      i = paramInt + f.a.a.b.b.a.bA(12, this.Timestamp);
      paramInt = i;
      if (this.PanelUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.PanelUrl);
      }
      i = paramInt;
      if (this.PriceNum != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.PriceNum);
      }
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.PriceType);
      }
      i = paramInt;
      if (this.SendInfo != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.SendInfo);
      }
      paramInt = i;
      if (this.TimeLimitStr != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.TimeLimitStr);
      }
      i = paramInt;
      if (this.Introduce != null) {
        i = paramInt + f.a.a.b.b.a.e(18, this.Introduce);
      }
      paramInt = i;
      if (this.TagUri != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.TagUri);
      }
      i = paramInt;
      if (this.ExptDesc != null) {
        i = paramInt + f.a.a.b.b.a.e(20, this.ExptDesc);
      }
      AppMethodBeat.o(104781);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104781);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        EmotionSummary localEmotionSummary = (EmotionSummary)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104781);
          return -1;
        case 1: 
          localEmotionSummary.ProductID = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 2: 
          localEmotionSummary.IconUrl = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 3: 
          localEmotionSummary.PackName = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 4: 
          localEmotionSummary.PackDesc = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 5: 
          localEmotionSummary.PackAuthInfo = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 6: 
          localEmotionSummary.PackPrice = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 7: 
          localEmotionSummary.PackType = locala.KhF.xS();
          AppMethodBeat.o(104781);
          return 0;
        case 8: 
          localEmotionSummary.PackFlag = locala.KhF.xS();
          AppMethodBeat.o(104781);
          return 0;
        case 9: 
          localEmotionSummary.CoverUrl = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 10: 
          localEmotionSummary.PackExpire = locala.KhF.xS();
          AppMethodBeat.o(104781);
          return 0;
        case 11: 
          localEmotionSummary.PackCopyright = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 12: 
          localEmotionSummary.Timestamp = locala.KhF.xS();
          AppMethodBeat.o(104781);
          return 0;
        case 13: 
          localEmotionSummary.PanelUrl = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 14: 
          localEmotionSummary.PriceNum = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 15: 
          localEmotionSummary.PriceType = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 16: 
          localEmotionSummary.SendInfo = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 17: 
          localEmotionSummary.TimeLimitStr = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 18: 
          localEmotionSummary.Introduce = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        case 19: 
          localEmotionSummary.TagUri = locala.KhF.readString();
          AppMethodBeat.o(104781);
          return 0;
        }
        localEmotionSummary.ExptDesc = locala.KhF.readString();
        AppMethodBeat.o(104781);
        return 0;
      }
      AppMethodBeat.o(104781);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionSummary
 * JD-Core Version:    0.7.0.1
 */