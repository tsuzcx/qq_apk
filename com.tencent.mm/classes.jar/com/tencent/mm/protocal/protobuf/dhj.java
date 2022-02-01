package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhj
  extends dpc
{
  public String HuS;
  public int MLH;
  public String MLI;
  public String MLJ;
  public caf MLK;
  public ckj efB;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91642);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91642);
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
      paramVarArgs.aM(4, this.MLH);
      if (this.MLI != null) {
        paramVarArgs.e(5, this.MLI);
      }
      if (this.MLJ != null) {
        paramVarArgs.e(6, this.MLJ);
      }
      if (this.MLK != null)
      {
        paramVarArgs.ni(7, this.MLK.computeSize());
        this.MLK.writeFields(paramVarArgs);
      }
      if (this.efB != null)
      {
        paramVarArgs.ni(99, this.efB.computeSize());
        this.efB.writeFields(paramVarArgs);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1034;
      }
    }
    label1034:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.MLH);
      paramInt = i;
      if (this.MLI != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MLI);
      }
      i = paramInt;
      if (this.MLJ != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MLJ);
      }
      paramInt = i;
      if (this.MLK != null) {
        paramInt = i + g.a.a.a.nh(7, this.MLK.computeSize());
      }
      i = paramInt;
      if (this.efB != null) {
        i = paramInt + g.a.a.a.nh(99, this.efB.computeSize());
      }
      paramInt = i;
      if (this.HuS != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91642);
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
          AppMethodBeat.o(91642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhj localdhj = (dhj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91642);
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
            localdhj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        case 2: 
          localdhj.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91642);
          return 0;
        case 3: 
          localdhj.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 4: 
          localdhj.MLH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91642);
          return 0;
        case 5: 
          localdhj.MLI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 6: 
          localdhj.MLJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91642);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new caf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((caf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhj.MLK = ((caf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
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
            localdhj.efB = ((ckj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91642);
          return 0;
        }
        localdhj.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91642);
        return 0;
      }
      AppMethodBeat.o(91642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhj
 * JD-Core Version:    0.7.0.1
 */