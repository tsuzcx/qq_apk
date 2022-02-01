package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class q
  extends esc
{
  public int YAd;
  public int hAV = 268513600;
  public dus ign;
  public int pHo;
  public int pHp;
  public int pHq;
  public long pHr;
  public long pHs;
  public String pHt;
  public String pHu;
  public String wYI = "请求不成功，请稍候再试";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91325);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91325);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.hAV);
      if (this.wYI != null) {
        paramVarArgs.g(3, this.wYI);
      }
      paramVarArgs.bS(4, this.pHo);
      paramVarArgs.bS(5, this.pHp);
      paramVarArgs.bS(6, this.pHq);
      paramVarArgs.bv(7, this.pHr);
      paramVarArgs.bv(8, this.pHs);
      if (this.pHt != null) {
        paramVarArgs.g(9, this.pHt);
      }
      if (this.pHu != null) {
        paramVarArgs.g(10, this.pHu);
      }
      paramVarArgs.bS(11, this.YAd);
      if (this.ign != null)
      {
        paramVarArgs.qD(12, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91325);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.pHo) + i.a.a.b.b.a.cJ(5, this.pHp) + i.a.a.b.b.a.cJ(6, this.pHq) + i.a.a.b.b.a.q(7, this.pHr) + i.a.a.b.b.a.q(8, this.pHs);
      paramInt = i;
      if (this.pHt != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.pHt);
      }
      i = paramInt;
      if (this.pHu != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.pHu);
      }
      i += i.a.a.b.b.a.cJ(11, this.YAd);
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(12, this.ign.computeSize());
      }
      AppMethodBeat.o(91325);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91325);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        q localq = (q)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91325);
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
            localq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91325);
          return 0;
        case 2: 
          localq.hAV = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91325);
          return 0;
        case 3: 
          localq.wYI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 4: 
          localq.pHo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91325);
          return 0;
        case 5: 
          localq.pHp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91325);
          return 0;
        case 6: 
          localq.pHq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91325);
          return 0;
        case 7: 
          localq.pHr = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91325);
          return 0;
        case 8: 
          localq.pHs = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91325);
          return 0;
        case 9: 
          localq.pHt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 10: 
          localq.pHu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91325);
          return 0;
        case 11: 
          localq.YAd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91325);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dus)localObject2).parseFrom((byte[])localObject1);
          }
          localq.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91325);
        return 0;
      }
      AppMethodBeat.o(91325);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.q
 * JD-Core Version:    0.7.0.1
 */