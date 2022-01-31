package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class EmotionBannerSet
  extends com.tencent.mm.bv.a
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
    AppMethodBeat.i(62534);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BannerImg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(62534);
        throw paramVarArgs;
      }
      if (this.BannerImg != null)
      {
        paramVarArgs.iQ(1, this.BannerImg.computeSize());
        this.BannerImg.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.LocateUrl != null) {
        paramVarArgs.e(3, this.LocateUrl);
      }
      paramVarArgs.aO(4, this.ID);
      if (this.SecondUrl != null) {
        paramVarArgs.e(5, this.SecondUrl);
      }
      paramVarArgs.aO(6, this.SetType);
      if (this.IconUrl != null) {
        paramVarArgs.e(7, this.IconUrl);
      }
      if (this.Desc != null) {
        paramVarArgs.e(8, this.Desc);
      }
      if (this.ProductID != null) {
        paramVarArgs.e(9, this.ProductID);
      }
      if (this.TagUrl != null) {
        paramVarArgs.e(10, this.TagUrl);
      }
      AppMethodBeat.o(62534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BannerImg == null) {
        break label878;
      }
    }
    label878:
    for (int i = e.a.a.a.iP(1, this.BannerImg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.LocateUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.LocateUrl);
      }
      i += e.a.a.b.b.a.bl(4, this.ID);
      paramInt = i;
      if (this.SecondUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.SecondUrl);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.SetType);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.IconUrl);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.Desc);
      }
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.ProductID);
      }
      i = paramInt;
      if (this.TagUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.TagUrl);
      }
      AppMethodBeat.o(62534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BannerImg == null)
        {
          paramVarArgs = new b("Not all required fields were included: BannerImg");
          AppMethodBeat.o(62534);
          throw paramVarArgs;
        }
        AppMethodBeat.o(62534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(62534);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerImg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionBannerImg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localEmotionBannerSet.BannerImg = ((EmotionBannerImg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(62534);
          return 0;
        case 2: 
          localEmotionBannerSet.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        case 3: 
          localEmotionBannerSet.LocateUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        case 4: 
          localEmotionBannerSet.ID = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62534);
          return 0;
        case 5: 
          localEmotionBannerSet.SecondUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        case 6: 
          localEmotionBannerSet.SetType = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(62534);
          return 0;
        case 7: 
          localEmotionBannerSet.IconUrl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        case 8: 
          localEmotionBannerSet.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        case 9: 
          localEmotionBannerSet.ProductID = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(62534);
          return 0;
        }
        localEmotionBannerSet.TagUrl = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(62534);
        return 0;
      }
      AppMethodBeat.o(62534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBannerSet
 * JD-Core Version:    0.7.0.1
 */