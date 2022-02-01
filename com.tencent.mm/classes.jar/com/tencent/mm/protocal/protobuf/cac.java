package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cac
  extends esc
{
  public String CAf;
  public String Kmq;
  public String KrL;
  public int KrW;
  public String Ksi;
  public String KuX;
  public boolean aajc = false;
  public int hAV = 0;
  public int ihA;
  public int ihy;
  public int ihz;
  public String wYI = "ok";
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258627);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258627);
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
      if (this.CAf != null) {
        paramVarArgs.g(4, this.CAf);
      }
      if (this.Kmq != null) {
        paramVarArgs.g(5, this.Kmq);
      }
      paramVarArgs.bS(6, this.KrW);
      paramVarArgs.bS(7, this.ihA);
      paramVarArgs.bS(8, this.ihz);
      if (this.KrL != null) {
        paramVarArgs.g(9, this.KrL);
      }
      paramVarArgs.bS(10, this.ihy);
      if (this.Ksi != null) {
        paramVarArgs.g(11, this.Ksi);
      }
      if (this.KuX != null) {
        paramVarArgs.g(12, this.KuX);
      }
      paramVarArgs.di(13, this.aajc);
      AppMethodBeat.o(258627);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label968;
      }
    }
    label968:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt;
      if (this.CAf != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.CAf);
      }
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Kmq);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.KrW) + i.a.a.b.b.a.cJ(7, this.ihA) + i.a.a.b.b.a.cJ(8, this.ihz);
      paramInt = i;
      if (this.KrL != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.KrL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.ihy);
      paramInt = i;
      if (this.Ksi != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.Ksi);
      }
      i = paramInt;
      if (this.KuX != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.KuX);
      }
      paramInt = i.a.a.b.b.a.ko(13);
      AppMethodBeat.o(258627);
      return i + (paramInt + 1);
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
          AppMethodBeat.o(258627);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258627);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cac localcac = (cac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258627);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcac.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(258627);
          return 0;
        case 2: 
          localcac.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258627);
          return 0;
        case 3: 
          localcac.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        case 4: 
          localcac.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        case 5: 
          localcac.Kmq = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        case 6: 
          localcac.KrW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258627);
          return 0;
        case 7: 
          localcac.ihA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258627);
          return 0;
        case 8: 
          localcac.ihz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258627);
          return 0;
        case 9: 
          localcac.KrL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        case 10: 
          localcac.ihy = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258627);
          return 0;
        case 11: 
          localcac.Ksi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        case 12: 
          localcac.KuX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258627);
          return 0;
        }
        localcac.aajc = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(258627);
        return 0;
      }
      AppMethodBeat.o(258627);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cac
 * JD-Core Version:    0.7.0.1
 */