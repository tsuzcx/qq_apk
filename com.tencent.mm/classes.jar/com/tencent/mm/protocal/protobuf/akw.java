package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class akw
  extends dpc
{
  public akz LtF;
  public akt LtG;
  public aku LtH;
  public String LtI;
  public int LtJ;
  public int LtK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32202);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32202);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LtF != null)
      {
        paramVarArgs.ni(2, this.LtF.computeSize());
        this.LtF.writeFields(paramVarArgs);
      }
      if (this.LtG != null)
      {
        paramVarArgs.ni(3, this.LtG.computeSize());
        this.LtG.writeFields(paramVarArgs);
      }
      if (this.LtH != null)
      {
        paramVarArgs.ni(4, this.LtH.computeSize());
        this.LtH.writeFields(paramVarArgs);
      }
      if (this.LtI != null) {
        paramVarArgs.e(5, this.LtI);
      }
      paramVarArgs.aM(6, this.LtJ);
      paramVarArgs.aM(7, this.LtK);
      AppMethodBeat.o(32202);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label991;
      }
    }
    label991:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LtF != null) {
        paramInt = i + g.a.a.a.nh(2, this.LtF.computeSize());
      }
      i = paramInt;
      if (this.LtG != null) {
        i = paramInt + g.a.a.a.nh(3, this.LtG.computeSize());
      }
      paramInt = i;
      if (this.LtH != null) {
        paramInt = i + g.a.a.a.nh(4, this.LtH.computeSize());
      }
      i = paramInt;
      if (this.LtI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LtI);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.LtJ);
      int j = g.a.a.b.b.a.bu(7, this.LtK);
      AppMethodBeat.o(32202);
      return i + paramInt + j;
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
          AppMethodBeat.o(32202);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32202);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        akw localakw = (akw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32202);
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
            localakw.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localakw.LtF = ((akz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localakw.LtG = ((akt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aku();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aku)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localakw.LtH = ((aku)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32202);
          return 0;
        case 5: 
          localakw.LtI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32202);
          return 0;
        case 6: 
          localakw.LtJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32202);
          return 0;
        }
        localakw.LtK = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32202);
        return 0;
      }
      AppMethodBeat.o(32202);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akw
 * JD-Core Version:    0.7.0.1
 */