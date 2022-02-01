package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class EmotionDetail
  extends com.tencent.mm.bx.a
{
  public String ConsumeProductID;
  public String CoverUrl;
  public EmotionDesigner EmotionDesigner;
  public String IconUrl;
  public String OldRedirectUrl;
  public String PackAuthInfo;
  public String PackCopyright;
  public String PackDesc;
  public int PackExpire;
  public int PackFlag;
  public String PackName;
  public String PackPrice;
  public int PackThumbCnt;
  public LinkedList<cwt> PackThumbList;
  public int PackType;
  public String PanelUrl;
  public PersonalDesigner PersonalDesigner;
  public String PriceNum;
  public String PriceType;
  public String ProductID;
  public String ShareDesc;
  public int ThumbExtCount;
  public LinkedList<PackThumbExt> ThumbExtList;
  public String TimeLimitStr;
  public int Version;
  
  public EmotionDetail()
  {
    AppMethodBeat.i(104776);
    this.PackThumbList = new LinkedList();
    this.ThumbExtList = new LinkedList();
    AppMethodBeat.o(104776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104777);
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
      paramVarArgs.aS(7, this.PackType);
      paramVarArgs.aS(8, this.PackFlag);
      paramVarArgs.aS(9, this.PackThumbCnt);
      paramVarArgs.e(10, 8, this.PackThumbList);
      if (this.CoverUrl != null) {
        paramVarArgs.d(11, this.CoverUrl);
      }
      paramVarArgs.aS(12, this.PackExpire);
      if (this.PackCopyright != null) {
        paramVarArgs.d(13, this.PackCopyright);
      }
      if (this.PriceNum != null) {
        paramVarArgs.d(14, this.PriceNum);
      }
      if (this.PriceType != null) {
        paramVarArgs.d(15, this.PriceType);
      }
      if (this.PanelUrl != null) {
        paramVarArgs.d(16, this.PanelUrl);
      }
      if (this.ConsumeProductID != null) {
        paramVarArgs.d(17, this.ConsumeProductID);
      }
      paramVarArgs.aS(18, this.ThumbExtCount);
      paramVarArgs.e(19, 8, this.ThumbExtList);
      paramVarArgs.aS(20, this.Version);
      if (this.TimeLimitStr != null) {
        paramVarArgs.d(21, this.TimeLimitStr);
      }
      if (this.ShareDesc != null) {
        paramVarArgs.d(22, this.ShareDesc);
      }
      if (this.OldRedirectUrl != null) {
        paramVarArgs.d(23, this.OldRedirectUrl);
      }
      if (this.EmotionDesigner != null)
      {
        paramVarArgs.lC(24, this.EmotionDesigner.computeSize());
        this.EmotionDesigner.writeFields(paramVarArgs);
      }
      if (this.PersonalDesigner != null)
      {
        paramVarArgs.lC(25, this.PersonalDesigner.computeSize());
        this.PersonalDesigner.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(104777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label1938;
      }
    }
    label1938:
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
      i = paramInt + f.a.a.b.b.a.bz(7, this.PackType) + f.a.a.b.b.a.bz(8, this.PackFlag) + f.a.a.b.b.a.bz(9, this.PackThumbCnt) + f.a.a.a.c(10, 8, this.PackThumbList);
      paramInt = i;
      if (this.CoverUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CoverUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(12, this.PackExpire);
      paramInt = i;
      if (this.PackCopyright != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.PackCopyright);
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
      if (this.PanelUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.PanelUrl);
      }
      paramInt = i;
      if (this.ConsumeProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ConsumeProductID);
      }
      i = paramInt + f.a.a.b.b.a.bz(18, this.ThumbExtCount) + f.a.a.a.c(19, 8, this.ThumbExtList) + f.a.a.b.b.a.bz(20, this.Version);
      paramInt = i;
      if (this.TimeLimitStr != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.TimeLimitStr);
      }
      i = paramInt;
      if (this.ShareDesc != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.ShareDesc);
      }
      paramInt = i;
      if (this.OldRedirectUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.OldRedirectUrl);
      }
      i = paramInt;
      if (this.EmotionDesigner != null) {
        i = paramInt + f.a.a.a.lB(24, this.EmotionDesigner.computeSize());
      }
      paramInt = i;
      if (this.PersonalDesigner != null) {
        paramInt = i + f.a.a.a.lB(25, this.PersonalDesigner.computeSize());
      }
      AppMethodBeat.o(104777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.PackThumbList.clear();
        this.ThumbExtList.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        EmotionDetail localEmotionDetail = (EmotionDetail)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104777);
          return -1;
        case 1: 
          localEmotionDetail.ProductID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 2: 
          localEmotionDetail.IconUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 3: 
          localEmotionDetail.PackName = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 4: 
          localEmotionDetail.PackDesc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 5: 
          localEmotionDetail.PackAuthInfo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 6: 
          localEmotionDetail.PackPrice = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 7: 
          localEmotionDetail.PackType = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 8: 
          localEmotionDetail.PackFlag = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 9: 
          localEmotionDetail.PackThumbCnt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localEmotionDetail.PackThumbList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 11: 
          localEmotionDetail.CoverUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 12: 
          localEmotionDetail.PackExpire = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 13: 
          localEmotionDetail.PackCopyright = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 14: 
          localEmotionDetail.PriceNum = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 15: 
          localEmotionDetail.PriceType = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 16: 
          localEmotionDetail.PanelUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 17: 
          localEmotionDetail.ConsumeProductID = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 18: 
          localEmotionDetail.ThumbExtCount = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 19: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PackThumbExt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PackThumbExt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localEmotionDetail.ThumbExtList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 20: 
          localEmotionDetail.Version = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(104777);
          return 0;
        case 21: 
          localEmotionDetail.TimeLimitStr = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 22: 
          localEmotionDetail.ShareDesc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 23: 
          localEmotionDetail.OldRedirectUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 24: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionDesigner();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localEmotionDetail.EmotionDesigner = ((EmotionDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new PersonalDesigner();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localEmotionDetail.PersonalDesigner = ((PersonalDesigner)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      AppMethodBeat.o(104777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionDetail
 * JD-Core Version:    0.7.0.1
 */