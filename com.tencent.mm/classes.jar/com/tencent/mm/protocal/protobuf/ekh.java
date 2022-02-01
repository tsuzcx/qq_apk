package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ekh
  extends esc
{
  public String OcN;
  public String OcO;
  public String abps;
  public int abpt;
  public String abpu;
  public String abpv;
  public String abpw;
  public String abpx;
  public int amount;
  public int hAV;
  public String plR;
  public int state;
  public String wYI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72567);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72567);
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
      paramVarArgs.bS(4, this.state);
      if (this.abps != null) {
        paramVarArgs.g(5, this.abps);
      }
      paramVarArgs.bS(6, this.amount);
      paramVarArgs.bS(7, this.abpt);
      if (this.OcN != null) {
        paramVarArgs.g(8, this.OcN);
      }
      if (this.abpu != null) {
        paramVarArgs.g(9, this.abpu);
      }
      if (this.OcO != null) {
        paramVarArgs.g(10, this.OcO);
      }
      if (this.abpv != null) {
        paramVarArgs.g(11, this.abpv);
      }
      if (this.abpw != null) {
        paramVarArgs.g(12, this.abpw);
      }
      if (this.abpx != null) {
        paramVarArgs.g(14, this.abpx);
      }
      if (this.plR != null) {
        paramVarArgs.g(15, this.plR);
      }
      AppMethodBeat.o(72567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1068;
      }
    }
    label1068:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.hAV);
      paramInt = i;
      if (this.wYI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wYI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.state);
      paramInt = i;
      if (this.abps != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abps);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.amount) + i.a.a.b.b.a.cJ(7, this.abpt);
      paramInt = i;
      if (this.OcN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.OcN);
      }
      i = paramInt;
      if (this.abpu != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abpu);
      }
      paramInt = i;
      if (this.OcO != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.OcO);
      }
      i = paramInt;
      if (this.abpv != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abpv);
      }
      paramInt = i;
      if (this.abpw != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abpw);
      }
      i = paramInt;
      if (this.abpx != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.abpx);
      }
      paramInt = i;
      if (this.plR != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.plR);
      }
      AppMethodBeat.o(72567);
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
          AppMethodBeat.o(72567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ekh localekh = (ekh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 13: 
        default: 
          AppMethodBeat.o(72567);
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
            localekh.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(72567);
          return 0;
        case 2: 
          localekh.hAV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72567);
          return 0;
        case 3: 
          localekh.wYI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 4: 
          localekh.state = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72567);
          return 0;
        case 5: 
          localekh.abps = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 6: 
          localekh.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72567);
          return 0;
        case 7: 
          localekh.abpt = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72567);
          return 0;
        case 8: 
          localekh.OcN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 9: 
          localekh.abpu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 10: 
          localekh.OcO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 11: 
          localekh.abpv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 12: 
          localekh.abpw = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        case 14: 
          localekh.abpx = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72567);
          return 0;
        }
        localekh.plR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(72567);
        return 0;
      }
      AppMethodBeat.o(72567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekh
 * JD-Core Version:    0.7.0.1
 */