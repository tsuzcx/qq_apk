package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgc
  extends dpc
{
  public String HuS;
  public String KBM;
  public String MKP;
  public int MKQ;
  public int dVv;
  public ckj efB;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91637);
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
      if (this.MKP != null) {
        paramVarArgs.e(4, this.MKP);
      }
      if (this.KBM != null) {
        paramVarArgs.e(5, this.KBM);
      }
      paramVarArgs.aM(6, this.dVv);
      paramVarArgs.aM(7, this.MKQ);
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.MKP != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MKP);
      }
      paramInt = i;
      if (this.KBM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KBM);
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.dVv) + g.a.a.b.b.a.bu(7, this.MKQ);
      paramInt = i;
      if (this.efB != null) {
        paramInt = i + g.a.a.a.nh(99, this.efB.computeSize());
      }
      i = paramInt;
      if (this.HuS != null) {
        i = paramInt + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91637);
      return i;
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
          AppMethodBeat.o(91637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgc localdgc = (dgc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91637);
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
            localdgc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        case 2: 
          localdgc.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91637);
          return 0;
        case 3: 
          localdgc.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 4: 
          localdgc.MKP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 5: 
          localdgc.KBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 6: 
          localdgc.dVv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91637);
          return 0;
        case 7: 
          localdgc.MKQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91637);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ckj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgc.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        }
        localdgc.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91637);
        return 0;
      }
      AppMethodBeat.o(91637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgc
 * JD-Core Version:    0.7.0.1
 */