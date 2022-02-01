package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public class EmotionBannerSet
  extends com.tencent.mm.bw.a
{
  public EmotionBannerImg BannerImg;
  public String Desc;
  public int ID;
  public String IconUrl;
  public String LocateUrl;
  public String ProductID;
  public String SecondUrl;
  public int SetType;
  public String TagUrl;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104770);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BannerImg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104770);
        throw paramVarArgs;
      }
      if (this.BannerImg != null)
      {
        paramVarArgs.lJ(1, this.BannerImg.computeSize());
        this.BannerImg.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      if (this.LocateUrl != null) {
        paramVarArgs.d(3, this.LocateUrl);
      }
      paramVarArgs.aS(4, this.ID);
      if (this.SecondUrl != null) {
        paramVarArgs.d(5, this.SecondUrl);
      }
      paramVarArgs.aS(6, this.SetType);
      if (this.IconUrl != null) {
        paramVarArgs.d(7, this.IconUrl);
      }
      if (this.Desc != null) {
        paramVarArgs.d(8, this.Desc);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(9, this.ProductID);
      }
      if (this.TagUrl != null) {
        paramVarArgs.d(10, this.TagUrl);
      }
      AppMethodBeat.o(104770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BannerImg == null) {
        break label878;
      }
    }
    label878:
    for (int i = f.a.a.a.lI(1, this.BannerImg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = paramInt;
      if (this.LocateUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.LocateUrl);
      }
      i += f.a.a.b.b.a.bz(4, this.ID);
      paramInt = i;
      if (this.SecondUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.SecondUrl);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.SetType);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.IconUrl);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Desc);
      }
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.ProductID);
      }
      i = paramInt;
      if (this.TagUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.TagUrl);
      }
      AppMethodBeat.o(104770);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BannerImg == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(104770);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104770);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104770);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerImg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionBannerImg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localEmotionBannerSet.BannerImg = ((EmotionBannerImg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104770);
          return 0;
        case 2: 
          localEmotionBannerSet.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 3: 
          localEmotionBannerSet.LocateUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 4: 
          localEmotionBannerSet.ID = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104770);
          return 0;
        case 5: 
          localEmotionBannerSet.SecondUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 6: 
          localEmotionBannerSet.SetType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104770);
          return 0;
        case 7: 
          localEmotionBannerSet.IconUrl = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 8: 
          localEmotionBannerSet.Desc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 9: 
          localEmotionBannerSet.ProductID = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(104770);
          return 0;
        }
        localEmotionBannerSet.TagUrl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(104770);
        return 0;
      }
      AppMethodBeat.o(104770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBannerSet
 * JD-Core Version:    0.7.0.1
 */