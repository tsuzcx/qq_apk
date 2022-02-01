package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwc
  extends esc
{
  public String IGG;
  public String IHZ;
  public int aaAX;
  public LinkedList<gdh> aaAY;
  public String aaBn;
  public String aaBo;
  public String aaBp;
  public String aaBq;
  public String aaBr;
  public String aaBs;
  public gdn aaBt;
  public String aaBu;
  public String aaBv;
  public String aaBw;
  public String aaBx;
  public String aaBy;
  public String hAP;
  
  public cwc()
  {
    AppMethodBeat.i(32308);
    this.aaAY = new LinkedList();
    AppMethodBeat.o(32308);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32309);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32309);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaBn != null) {
        paramVarArgs.g(2, this.aaBn);
      }
      if (this.IHZ != null) {
        paramVarArgs.g(3, this.IHZ);
      }
      if (this.hAP != null) {
        paramVarArgs.g(4, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(5, this.IGG);
      }
      if (this.aaBo != null) {
        paramVarArgs.g(6, this.aaBo);
      }
      if (this.aaBp != null) {
        paramVarArgs.g(7, this.aaBp);
      }
      if (this.aaBq != null) {
        paramVarArgs.g(8, this.aaBq);
      }
      if (this.aaBr != null) {
        paramVarArgs.g(9, this.aaBr);
      }
      if (this.aaBs != null) {
        paramVarArgs.g(10, this.aaBs);
      }
      if (this.aaBt != null)
      {
        paramVarArgs.qD(11, this.aaBt.computeSize());
        this.aaBt.writeFields(paramVarArgs);
      }
      if (this.aaBu != null) {
        paramVarArgs.g(12, this.aaBu);
      }
      if (this.aaBv != null) {
        paramVarArgs.g(13, this.aaBv);
      }
      if (this.aaBw != null) {
        paramVarArgs.g(14, this.aaBw);
      }
      if (this.aaBx != null) {
        paramVarArgs.g(15, this.aaBx);
      }
      if (this.aaBy != null) {
        paramVarArgs.g(16, this.aaBy);
      }
      paramVarArgs.bS(17, this.aaAX);
      paramVarArgs.e(18, 8, this.aaAY);
      AppMethodBeat.o(32309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1524;
      }
    }
    label1524:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaBn != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaBn);
      }
      i = paramInt;
      if (this.IHZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IHZ);
      }
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.hAP);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGG);
      }
      paramInt = i;
      if (this.aaBo != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaBo);
      }
      i = paramInt;
      if (this.aaBp != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaBp);
      }
      paramInt = i;
      if (this.aaBq != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaBq);
      }
      i = paramInt;
      if (this.aaBr != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aaBr);
      }
      paramInt = i;
      if (this.aaBs != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.aaBs);
      }
      i = paramInt;
      if (this.aaBt != null) {
        i = paramInt + i.a.a.a.qC(11, this.aaBt.computeSize());
      }
      paramInt = i;
      if (this.aaBu != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaBu);
      }
      i = paramInt;
      if (this.aaBv != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaBv);
      }
      paramInt = i;
      if (this.aaBw != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.aaBw);
      }
      i = paramInt;
      if (this.aaBx != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.aaBx);
      }
      paramInt = i;
      if (this.aaBy != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaBy);
      }
      i = i.a.a.b.b.a.cJ(17, this.aaAX);
      int j = i.a.a.a.c(18, 8, this.aaAY);
      AppMethodBeat.o(32309);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaAY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32309);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwc localcwc = (cwc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32309);
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
            localcwc.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 2: 
          localcwc.aaBn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 3: 
          localcwc.IHZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 4: 
          localcwc.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 5: 
          localcwc.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 6: 
          localcwc.aaBo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 7: 
          localcwc.aaBp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 8: 
          localcwc.aaBq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 9: 
          localcwc.aaBr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 10: 
          localcwc.aaBs = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gdn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gdn)localObject2).parseFrom((byte[])localObject1);
            }
            localcwc.aaBt = ((gdn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32309);
          return 0;
        case 12: 
          localcwc.aaBu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 13: 
          localcwc.aaBv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 14: 
          localcwc.aaBw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 15: 
          localcwc.aaBx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 16: 
          localcwc.aaBy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32309);
          return 0;
        case 17: 
          localcwc.aaAX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32309);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gdh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gdh)localObject2).parseFrom((byte[])localObject1);
          }
          localcwc.aaAY.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32309);
        return 0;
      }
      AppMethodBeat.o(32309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwc
 * JD-Core Version:    0.7.0.1
 */