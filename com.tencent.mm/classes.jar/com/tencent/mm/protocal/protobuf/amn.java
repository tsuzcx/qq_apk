package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class amn
  extends dyy
{
  public int EvK;
  public String EvL;
  public String EvM;
  public String EvN;
  public int EvO;
  public String EvP;
  public String EvQ;
  public String Ezw;
  public dtj Sih;
  public cmb SwQ;
  public int amount;
  public int fwx;
  public int fyO;
  public int gbp;
  public int gbq;
  public String tVo;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91453);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.fwx);
      if (this.tVo != null) {
        paramVarArgs.f(3, this.tVo);
      }
      paramVarArgs.aY(4, this.fyO);
      if (this.ybP != null) {
        paramVarArgs.f(5, this.ybP);
      }
      paramVarArgs.aY(6, this.gbp);
      paramVarArgs.aY(7, this.gbq);
      if (this.Ezw != null) {
        paramVarArgs.f(8, this.Ezw);
      }
      paramVarArgs.aY(9, this.amount);
      if (this.Sih != null)
      {
        paramVarArgs.oE(10, this.Sih.computeSize());
        this.Sih.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(11, this.EvK);
      if (this.EvL != null) {
        paramVarArgs.f(12, this.EvL);
      }
      if (this.EvM != null) {
        paramVarArgs.f(13, this.EvM);
      }
      if (this.EvN != null) {
        paramVarArgs.f(14, this.EvN);
      }
      paramVarArgs.aY(15, this.EvO);
      if (this.EvP != null) {
        paramVarArgs.f(16, this.EvP);
      }
      if (this.EvQ != null) {
        paramVarArgs.f(17, this.EvQ);
      }
      if (this.SwQ != null)
      {
        paramVarArgs.oE(18, this.SwQ.computeSize());
        this.SwQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1412;
      }
    }
    label1412:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.fwx);
      paramInt = i;
      if (this.tVo != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tVo);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.fyO);
      paramInt = i;
      if (this.ybP != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.ybP);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.gbp) + g.a.a.b.b.a.bM(7, this.gbq);
      paramInt = i;
      if (this.Ezw != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.Ezw);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.amount);
      paramInt = i;
      if (this.Sih != null) {
        paramInt = i + g.a.a.a.oD(10, this.Sih.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.EvK);
      paramInt = i;
      if (this.EvL != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.EvL);
      }
      i = paramInt;
      if (this.EvM != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.EvM);
      }
      paramInt = i;
      if (this.EvN != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.EvN);
      }
      i = paramInt + g.a.a.b.b.a.bM(15, this.EvO);
      paramInt = i;
      if (this.EvP != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.EvP);
      }
      i = paramInt;
      if (this.EvQ != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.EvQ);
      }
      paramInt = i;
      if (this.SwQ != null) {
        paramInt = i + g.a.a.a.oD(18, this.SwQ.computeSize());
      }
      AppMethodBeat.o(91453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91453);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        amn localamn = (amn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localamn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localamn.fwx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localamn.tVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localamn.fyO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localamn.ybP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localamn.gbp = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localamn.gbq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localamn.Ezw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localamn.amount = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtj)localObject2).parseFrom((byte[])localObject1);
            }
            localamn.Sih = ((dtj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localamn.EvK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localamn.EvL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localamn.EvM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localamn.EvN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localamn.EvO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localamn.EvP = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 17: 
          localamn.EvQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cmb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cmb)localObject2).parseFrom((byte[])localObject1);
          }
          localamn.SwQ = ((cmb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91453);
        return 0;
      }
      AppMethodBeat.o(91453);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amn
 * JD-Core Version:    0.7.0.1
 */