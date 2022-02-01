package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class EmotionDetail
  extends com.tencent.mm.bw.a
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
  public LinkedList<dqi> PackThumbList;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.e(1, this.ProductID);
      }
      if (this.IconUrl != null) {
        paramVarArgs.e(2, this.IconUrl);
      }
      if (this.PackName != null) {
        paramVarArgs.e(3, this.PackName);
      }
      if (this.PackDesc != null) {
        paramVarArgs.e(4, this.PackDesc);
      }
      if (this.PackAuthInfo != null) {
        paramVarArgs.e(5, this.PackAuthInfo);
      }
      if (this.PackPrice != null) {
        paramVarArgs.e(6, this.PackPrice);
      }
      paramVarArgs.aM(7, this.PackType);
      paramVarArgs.aM(8, this.PackFlag);
      paramVarArgs.aM(9, this.PackThumbCnt);
      paramVarArgs.e(10, 8, this.PackThumbList);
      if (this.CoverUrl != null) {
        paramVarArgs.e(11, this.CoverUrl);
      }
      paramVarArgs.aM(12, this.PackExpire);
      if (this.PackCopyright != null) {
        paramVarArgs.e(13, this.PackCopyright);
      }
      if (this.PriceNum != null) {
        paramVarArgs.e(14, this.PriceNum);
      }
      if (this.PriceType != null) {
        paramVarArgs.e(15, this.PriceType);
      }
      if (this.PanelUrl != null) {
        paramVarArgs.e(16, this.PanelUrl);
      }
      if (this.ConsumeProductID != null) {
        paramVarArgs.e(17, this.ConsumeProductID);
      }
      paramVarArgs.aM(18, this.ThumbExtCount);
      paramVarArgs.e(19, 8, this.ThumbExtList);
      paramVarArgs.aM(20, this.Version);
      if (this.TimeLimitStr != null) {
        paramVarArgs.e(21, this.TimeLimitStr);
      }
      if (this.ShareDesc != null) {
        paramVarArgs.e(22, this.ShareDesc);
      }
      if (this.OldRedirectUrl != null) {
        paramVarArgs.e(23, this.OldRedirectUrl);
      }
      if (this.EmotionDesigner != null)
      {
        paramVarArgs.ni(24, this.EmotionDesigner.computeSize());
        this.EmotionDesigner.writeFields(paramVarArgs);
      }
      if (this.PersonalDesigner != null)
      {
        paramVarArgs.ni(25, this.PersonalDesigner.computeSize());
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
    for (int i = g.a.a.b.b.a.f(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.IconUrl);
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.PackName);
      }
      paramInt = i;
      if (this.PackDesc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.PackDesc);
      }
      i = paramInt;
      if (this.PackAuthInfo != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.PackAuthInfo);
      }
      paramInt = i;
      if (this.PackPrice != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.PackPrice);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.PackType) + g.a.a.b.b.a.bu(8, this.PackFlag) + g.a.a.b.b.a.bu(9, this.PackThumbCnt) + g.a.a.a.c(10, 8, this.PackThumbList);
      paramInt = i;
      if (this.CoverUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.CoverUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(12, this.PackExpire);
      paramInt = i;
      if (this.PackCopyright != null) {
        paramInt = i + g.a.a.b.b.a.f(13, this.PackCopyright);
      }
      i = paramInt;
      if (this.PriceNum != null) {
        i = paramInt + g.a.a.b.b.a.f(14, this.PriceNum);
      }
      paramInt = i;
      if (this.PriceType != null) {
        paramInt = i + g.a.a.b.b.a.f(15, this.PriceType);
      }
      i = paramInt;
      if (this.PanelUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(16, this.PanelUrl);
      }
      paramInt = i;
      if (this.ConsumeProductID != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.ConsumeProductID);
      }
      i = paramInt + g.a.a.b.b.a.bu(18, this.ThumbExtCount) + g.a.a.a.c(19, 8, this.ThumbExtList) + g.a.a.b.b.a.bu(20, this.Version);
      paramInt = i;
      if (this.TimeLimitStr != null) {
        paramInt = i + g.a.a.b.b.a.f(21, this.TimeLimitStr);
      }
      i = paramInt;
      if (this.ShareDesc != null) {
        i = paramInt + g.a.a.b.b.a.f(22, this.ShareDesc);
      }
      paramInt = i;
      if (this.OldRedirectUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(23, this.OldRedirectUrl);
      }
      i = paramInt;
      if (this.EmotionDesigner != null) {
        i = paramInt + g.a.a.a.nh(24, this.EmotionDesigner.computeSize());
      }
      paramInt = i;
      if (this.PersonalDesigner != null) {
        paramInt = i + g.a.a.a.nh(25, this.PersonalDesigner.computeSize());
      }
      AppMethodBeat.o(104777);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.PackThumbList.clear();
        this.ThumbExtList.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
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
          localEmotionDetail.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 2: 
          localEmotionDetail.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 3: 
          localEmotionDetail.PackName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 4: 
          localEmotionDetail.PackDesc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 5: 
          localEmotionDetail.PackAuthInfo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 6: 
          localEmotionDetail.PackPrice = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 7: 
          localEmotionDetail.PackType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 8: 
          localEmotionDetail.PackFlag = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 9: 
          localEmotionDetail.PackThumbCnt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dqi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localEmotionDetail.PackThumbList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 11: 
          localEmotionDetail.CoverUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 12: 
          localEmotionDetail.PackExpire = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 13: 
          localEmotionDetail.PackCopyright = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 14: 
          localEmotionDetail.PriceNum = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 15: 
          localEmotionDetail.PriceType = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 16: 
          localEmotionDetail.PanelUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 17: 
          localEmotionDetail.ConsumeProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 18: 
          localEmotionDetail.ThumbExtCount = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new PackThumbExt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((PackThumbExt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localEmotionDetail.ThumbExtList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 20: 
          localEmotionDetail.Version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104777);
          return 0;
        case 21: 
          localEmotionDetail.TimeLimitStr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 22: 
          localEmotionDetail.ShareDesc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 23: 
          localEmotionDetail.OldRedirectUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 24: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionDesigner();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((EmotionDesigner)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localEmotionDetail.EmotionDesigner = ((EmotionDesigner)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new PersonalDesigner();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((PersonalDesigner)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionDetail
 * JD-Core Version:    0.7.0.1
 */