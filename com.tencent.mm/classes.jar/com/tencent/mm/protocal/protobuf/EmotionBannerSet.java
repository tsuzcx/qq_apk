package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BannerImg == null)
      {
        paramVarArgs = new b("Not all required fields were included: BannerImg");
        AppMethodBeat.o(104770);
        throw paramVarArgs;
      }
      if (this.BannerImg != null)
      {
        paramVarArgs.ni(1, this.BannerImg.computeSize());
        this.BannerImg.writeFields(paramVarArgs);
      }
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.LocateUrl != null) {
        paramVarArgs.e(3, this.LocateUrl);
      }
      paramVarArgs.aM(4, this.ID);
      if (this.SecondUrl != null) {
        paramVarArgs.e(5, this.SecondUrl);
      }
      paramVarArgs.aM(6, this.SetType);
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
      AppMethodBeat.o(104770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BannerImg == null) {
        break label878;
      }
    }
    label878:
    for (int i = g.a.a.a.nh(1, this.BannerImg.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.LocateUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LocateUrl);
      }
      i += g.a.a.b.b.a.bu(4, this.ID);
      paramInt = i;
      if (this.SecondUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.SecondUrl);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.SetType);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.IconUrl);
      }
      i = paramInt;
      if (this.Desc != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Desc);
      }
      paramInt = i;
      if (this.ProductID != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.ProductID);
      }
      i = paramInt;
      if (this.TagUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.TagUrl);
      }
      AppMethodBeat.o(104770);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        EmotionBannerSet localEmotionBannerSet = (EmotionBannerSet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104770);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new EmotionBannerImg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((EmotionBannerImg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localEmotionBannerSet.BannerImg = ((EmotionBannerImg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104770);
          return 0;
        case 2: 
          localEmotionBannerSet.Title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 3: 
          localEmotionBannerSet.LocateUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 4: 
          localEmotionBannerSet.ID = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104770);
          return 0;
        case 5: 
          localEmotionBannerSet.SecondUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 6: 
          localEmotionBannerSet.SetType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104770);
          return 0;
        case 7: 
          localEmotionBannerSet.IconUrl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 8: 
          localEmotionBannerSet.Desc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        case 9: 
          localEmotionBannerSet.ProductID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104770);
          return 0;
        }
        localEmotionBannerSet.TagUrl = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104770);
        return 0;
      }
      AppMethodBeat.o(104770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionBannerSet
 * JD-Core Version:    0.7.0.1
 */