package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class af
  extends dpc
{
  public String KCB;
  public int KCC;
  public int KCD;
  public String KCE;
  public dyj KCF;
  public dmc KCG;
  public dyj KCH;
  public dho KCI;
  public bfr KCJ;
  public ih KCK;
  public String KCL;
  public String KCM;
  public int KCN;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32097);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32097);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.KCB != null) {
        paramVarArgs.e(2, this.KCB);
      }
      paramVarArgs.aM(3, this.KCC);
      paramVarArgs.aM(4, this.KCD);
      if (this.KCE != null) {
        paramVarArgs.e(5, this.KCE);
      }
      if (this.KCF != null)
      {
        paramVarArgs.ni(6, this.KCF.computeSize());
        this.KCF.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.OpCode);
      if (this.KCG != null)
      {
        paramVarArgs.ni(8, this.KCG.computeSize());
        this.KCG.writeFields(paramVarArgs);
      }
      if (this.KCH != null)
      {
        paramVarArgs.ni(9, this.KCH.computeSize());
        this.KCH.writeFields(paramVarArgs);
      }
      if (this.KCI != null)
      {
        paramVarArgs.ni(10, this.KCI.computeSize());
        this.KCI.writeFields(paramVarArgs);
      }
      if (this.KCJ != null)
      {
        paramVarArgs.ni(11, this.KCJ.computeSize());
        this.KCJ.writeFields(paramVarArgs);
      }
      if (this.KCK != null)
      {
        paramVarArgs.ni(12, this.KCK.computeSize());
        this.KCK.writeFields(paramVarArgs);
      }
      if (this.KCL != null) {
        paramVarArgs.e(13, this.KCL);
      }
      if (this.KCM != null) {
        paramVarArgs.e(14, this.KCM);
      }
      paramVarArgs.aM(15, this.KCN);
      AppMethodBeat.o(32097);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1739;
      }
    }
    label1739:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KCB != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KCB);
      }
      i = i + g.a.a.b.b.a.bu(3, this.KCC) + g.a.a.b.b.a.bu(4, this.KCD);
      paramInt = i;
      if (this.KCE != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KCE);
      }
      i = paramInt;
      if (this.KCF != null) {
        i = paramInt + g.a.a.a.nh(6, this.KCF.computeSize());
      }
      i += g.a.a.b.b.a.bu(7, this.OpCode);
      paramInt = i;
      if (this.KCG != null) {
        paramInt = i + g.a.a.a.nh(8, this.KCG.computeSize());
      }
      i = paramInt;
      if (this.KCH != null) {
        i = paramInt + g.a.a.a.nh(9, this.KCH.computeSize());
      }
      paramInt = i;
      if (this.KCI != null) {
        paramInt = i + g.a.a.a.nh(10, this.KCI.computeSize());
      }
      i = paramInt;
      if (this.KCJ != null) {
        i = paramInt + g.a.a.a.nh(11, this.KCJ.computeSize());
      }
      paramInt = i;
      if (this.KCK != null) {
        paramInt = i + g.a.a.a.nh(12, this.KCK.computeSize());
      }
      i = paramInt;
      if (this.KCL != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.KCL);
      }
      paramInt = i;
      if (this.KCM != null) {
        paramInt = i + g.a.a.b.b.a.f(14, this.KCM);
      }
      i = g.a.a.b.b.a.bu(15, this.KCN);
      AppMethodBeat.o(32097);
      return paramInt + i;
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
          AppMethodBeat.o(32097);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32097);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        af localaf = (af)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32097);
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
            localaf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 2: 
          localaf.KCB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 3: 
          localaf.KCC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32097);
          return 0;
        case 4: 
          localaf.KCD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32097);
          return 0;
        case 5: 
          localaf.KCE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCF = ((dyj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 7: 
          localaf.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32097);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCG = ((dmc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCH = ((dyj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dho();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dho)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCI = ((dho)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCJ = ((bfr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaf.KCK = ((ih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32097);
          return 0;
        case 13: 
          localaf.KCL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32097);
          return 0;
        case 14: 
          localaf.KCM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32097);
          return 0;
        }
        localaf.KCN = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32097);
        return 0;
      }
      AppMethodBeat.o(32097);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.af
 * JD-Core Version:    0.7.0.1
 */