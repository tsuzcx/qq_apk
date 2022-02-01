package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class alm
  extends dpc
{
  public dju LgT;
  public cdh Lus;
  public int dDN;
  public int dGe;
  public int egZ;
  public int eha;
  public String qwn;
  public String yQE;
  public int yRL;
  public int yRN;
  public String yRO;
  public String yRP;
  public String yRQ;
  public int yRR;
  public String yRS;
  public String yRT;
  public String yVy;
  
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
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dDN);
      if (this.qwn != null) {
        paramVarArgs.e(3, this.qwn);
      }
      paramVarArgs.aM(4, this.dGe);
      if (this.yQE != null) {
        paramVarArgs.e(5, this.yQE);
      }
      paramVarArgs.aM(6, this.egZ);
      paramVarArgs.aM(7, this.eha);
      if (this.yVy != null) {
        paramVarArgs.e(8, this.yVy);
      }
      paramVarArgs.aM(9, this.yRL);
      if (this.LgT != null)
      {
        paramVarArgs.ni(10, this.LgT.computeSize());
        this.LgT.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(11, this.yRN);
      if (this.yRO != null) {
        paramVarArgs.e(12, this.yRO);
      }
      if (this.yRP != null) {
        paramVarArgs.e(13, this.yRP);
      }
      if (this.yRQ != null) {
        paramVarArgs.e(14, this.yRQ);
      }
      paramVarArgs.aM(15, this.yRR);
      if (this.yRS != null) {
        paramVarArgs.e(16, this.yRS);
      }
      if (this.yRT != null) {
        paramVarArgs.e(17, this.yRT);
      }
      if (this.Lus != null)
      {
        paramVarArgs.ni(18, this.Lus.computeSize());
        this.Lus.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91453);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1478;
      }
    }
    label1478:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dDN);
      paramInt = i;
      if (this.qwn != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.qwn);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.dGe);
      paramInt = i;
      if (this.yQE != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.yQE);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.egZ) + g.a.a.b.b.a.bu(7, this.eha);
      paramInt = i;
      if (this.yVy != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.yVy);
      }
      i = paramInt + g.a.a.b.b.a.bu(9, this.yRL);
      paramInt = i;
      if (this.LgT != null) {
        paramInt = i + g.a.a.a.nh(10, this.LgT.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.yRN);
      paramInt = i;
      if (this.yRO != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.yRO);
      }
      i = paramInt;
      if (this.yRP != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.yRP);
      }
      paramInt = i;
      if (this.yRQ != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.yRQ);
      }
      i = paramInt + g.a.a.b.b.a.bu(15, this.yRR);
      paramInt = i;
      if (this.yRS != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.yRS);
      }
      i = paramInt;
      if (this.yRT != null) {
        i = paramInt + g.a.a.b.b.a.f(17, this.yRT);
      }
      paramInt = i;
      if (this.Lus != null) {
        paramInt = i + g.a.a.a.nh(18, this.Lus.computeSize());
      }
      AppMethodBeat.o(91453);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
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
        alm localalm = (alm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91453);
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
            localalm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 2: 
          localalm.dDN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 3: 
          localalm.qwn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 4: 
          localalm.dGe = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 5: 
          localalm.yQE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 6: 
          localalm.egZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 7: 
          localalm.eha = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 8: 
          localalm.yVy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 9: 
          localalm.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dju();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dju)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localalm.LgT = ((dju)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91453);
          return 0;
        case 11: 
          localalm.yRN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 12: 
          localalm.yRO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 13: 
          localalm.yRP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 14: 
          localalm.yRQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 15: 
          localalm.yRR = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91453);
          return 0;
        case 16: 
          localalm.yRS = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        case 17: 
          localalm.yRT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91453);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cdh();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cdh)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localalm.Lus = ((cdh)localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alm
 * JD-Core Version:    0.7.0.1
 */