package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqk
  extends dpc
{
  public LinkedList<ue> LUK;
  public int LUO;
  public un LUQ;
  public String LUR;
  public int LUS;
  public int LUT;
  public uw LUU;
  public un LYc;
  public String LYd;
  public String LYe;
  public LinkedList<ua> Lds;
  public int pTZ;
  public String pUa;
  public int qGg;
  
  public bqk()
  {
    AppMethodBeat.i(201343);
    this.Lds = new LinkedList();
    this.LUK = new LinkedList();
    AppMethodBeat.o(201343);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(201344);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(201344);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.pTZ);
      if (this.pUa != null) {
        paramVarArgs.e(3, this.pUa);
      }
      paramVarArgs.aM(4, this.qGg);
      paramVarArgs.aM(5, this.LUO);
      paramVarArgs.e(6, 8, this.Lds);
      if (this.LUU != null)
      {
        paramVarArgs.ni(7, this.LUU.computeSize());
        this.LUU.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.LUS);
      paramVarArgs.aM(9, this.LUT);
      if (this.LUQ != null)
      {
        paramVarArgs.ni(10, this.LUQ.computeSize());
        this.LUQ.writeFields(paramVarArgs);
      }
      if (this.LUR != null) {
        paramVarArgs.e(11, this.LUR);
      }
      if (this.LYc != null)
      {
        paramVarArgs.ni(12, this.LYc.computeSize());
        this.LYc.writeFields(paramVarArgs);
      }
      if (this.LYd != null) {
        paramVarArgs.e(13, this.LYd);
      }
      if (this.LYe != null) {
        paramVarArgs.e(14, this.LYe);
      }
      paramVarArgs.e(15, 8, this.LUK);
      AppMethodBeat.o(201344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1574;
      }
    }
    label1574:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.qGg) + g.a.a.b.b.a.bu(5, this.LUO) + g.a.a.a.c(6, 8, this.Lds);
      paramInt = i;
      if (this.LUU != null) {
        paramInt = i + g.a.a.a.nh(7, this.LUU.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.LUS) + g.a.a.b.b.a.bu(9, this.LUT);
      paramInt = i;
      if (this.LUQ != null) {
        paramInt = i + g.a.a.a.nh(10, this.LUQ.computeSize());
      }
      i = paramInt;
      if (this.LUR != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.LUR);
      }
      paramInt = i;
      if (this.LYc != null) {
        paramInt = i + g.a.a.a.nh(12, this.LYc.computeSize());
      }
      i = paramInt;
      if (this.LYd != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.LYd);
      }
      paramInt = i;
      if (this.LYe != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.LYe);
      }
      i = g.a.a.a.c(15, 8, this.LUK);
      AppMethodBeat.o(201344);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Lds.clear();
        this.LUK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(201344);
          throw paramVarArgs;
        }
        AppMethodBeat.o(201344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqk localbqk = (bqk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(201344);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201344);
          return 0;
        case 2: 
          localbqk.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201344);
          return 0;
        case 3: 
          localbqk.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201344);
          return 0;
        case 4: 
          localbqk.qGg = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201344);
          return 0;
        case 5: 
          localbqk.LUO = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201344);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ua();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ua)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqk.Lds.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201344);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new uw();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((uw)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqk.LUU = ((uw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201344);
          return 0;
        case 8: 
          localbqk.LUS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201344);
          return 0;
        case 9: 
          localbqk.LUT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(201344);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqk.LUQ = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201344);
          return 0;
        case 11: 
          localbqk.LUR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201344);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new un();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((un)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbqk.LYc = ((un)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(201344);
          return 0;
        case 13: 
          localbqk.LYd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201344);
          return 0;
        case 14: 
          localbqk.LYe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(201344);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ue();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ue)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbqk.LUK.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(201344);
        return 0;
      }
      AppMethodBeat.o(201344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqk
 * JD-Core Version:    0.7.0.1
 */