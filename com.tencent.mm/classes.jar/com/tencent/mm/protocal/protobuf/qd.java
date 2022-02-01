package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class qd
  extends esc
{
  public int Jfu;
  public int YSK;
  public String YTN;
  public String YUO;
  public long YUP;
  public int YUQ;
  public long YUR;
  public LinkedList<pz> YUS;
  public int YUT;
  public LinkedList<ena> YUU;
  public emz YUV;
  public int YUW;
  public int YUX;
  public int YUY;
  public int eQp;
  public String igg;
  public int video_count;
  
  public qd()
  {
    AppMethodBeat.i(124440);
    this.YUS = new LinkedList();
    this.YUU = new LinkedList();
    AppMethodBeat.o(124440);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124441);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124441);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YUP);
      paramVarArgs.bS(3, this.Jfu);
      paramVarArgs.bS(4, this.YUQ);
      paramVarArgs.bv(5, this.YUR);
      paramVarArgs.bS(6, this.YSK);
      paramVarArgs.e(7, 8, this.YUS);
      paramVarArgs.bS(8, this.YUT);
      if (this.YTN != null) {
        paramVarArgs.g(9, this.YTN);
      }
      paramVarArgs.bS(10, this.video_count);
      paramVarArgs.bS(11, this.eQp);
      paramVarArgs.e(12, 8, this.YUU);
      if (this.igg != null) {
        paramVarArgs.g(14, this.igg);
      }
      if (this.YUV != null)
      {
        paramVarArgs.qD(16, this.YUV.computeSize());
        this.YUV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(17, this.YUW);
      paramVarArgs.bS(18, this.YUX);
      paramVarArgs.bS(19, this.YUY);
      if (this.YUO != null) {
        paramVarArgs.g(21, this.YUO);
      }
      AppMethodBeat.o(124441);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1382;
      }
    }
    label1382:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.YUP) + i.a.a.b.b.a.cJ(3, this.Jfu) + i.a.a.b.b.a.cJ(4, this.YUQ) + i.a.a.b.b.a.q(5, this.YUR) + i.a.a.b.b.a.cJ(6, this.YSK) + i.a.a.a.c(7, 8, this.YUS) + i.a.a.b.b.a.cJ(8, this.YUT);
      paramInt = i;
      if (this.YTN != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YTN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.video_count) + i.a.a.b.b.a.cJ(11, this.eQp) + i.a.a.a.c(12, 8, this.YUU);
      paramInt = i;
      if (this.igg != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.igg);
      }
      i = paramInt;
      if (this.YUV != null) {
        i = paramInt + i.a.a.a.qC(16, this.YUV.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(17, this.YUW) + i.a.a.b.b.a.cJ(18, this.YUX) + i.a.a.b.b.a.cJ(19, this.YUY);
      paramInt = i;
      if (this.YUO != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.YUO);
      }
      AppMethodBeat.o(124441);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YUS.clear();
        this.YUU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124441);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124441);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        qd localqd = (qd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 13: 
        case 15: 
        case 20: 
        default: 
          AppMethodBeat.o(124441);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localqd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 2: 
          localqd.YUP = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124441);
          return 0;
        case 3: 
          localqd.Jfu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 4: 
          localqd.YUQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 5: 
          localqd.YUR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(124441);
          return 0;
        case 6: 
          localqd.YSK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new pz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((pz)localObject2).parseFrom((byte[])localObject1);
            }
            localqd.YUS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 8: 
          localqd.YUT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 9: 
          localqd.YTN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 10: 
          localqd.video_count = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 11: 
          localqd.eQp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ena();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ena)localObject2).parseFrom((byte[])localObject1);
            }
            localqd.YUU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 14: 
          localqd.igg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(124441);
          return 0;
        case 16: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emz)localObject2).parseFrom((byte[])localObject1);
            }
            localqd.YUV = ((emz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124441);
          return 0;
        case 17: 
          localqd.YUW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 18: 
          localqd.YUX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        case 19: 
          localqd.YUY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(124441);
          return 0;
        }
        localqd.YUO = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(124441);
        return 0;
      }
      AppMethodBeat.o(124441);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qd
 * JD-Core Version:    0.7.0.1
 */