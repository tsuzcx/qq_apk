package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class biq
  extends dpc
{
  public int KCD;
  public String KCE;
  public dyj KCF;
  public int KCN;
  public int KCz;
  public ih wRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32220);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32220);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KCD);
      paramVarArgs.aM(3, this.KCN);
      if (this.KCE != null) {
        paramVarArgs.e(4, this.KCE);
      }
      if (this.KCF != null)
      {
        paramVarArgs.ni(5, this.KCF.computeSize());
        this.KCF.writeFields(paramVarArgs);
      }
      if (this.wRL != null)
      {
        paramVarArgs.ni(6, this.wRL.computeSize());
        this.wRL.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.KCz);
      AppMethodBeat.o(32220);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label875;
      }
    }
    label875:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KCD) + g.a.a.b.b.a.bu(3, this.KCN);
      paramInt = i;
      if (this.KCE != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KCE);
      }
      i = paramInt;
      if (this.KCF != null) {
        i = paramInt + g.a.a.a.nh(5, this.KCF.computeSize());
      }
      paramInt = i;
      if (this.wRL != null) {
        paramInt = i + g.a.a.a.nh(6, this.wRL.computeSize());
      }
      i = g.a.a.b.b.a.bu(7, this.KCz);
      AppMethodBeat.o(32220);
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
          AppMethodBeat.o(32220);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32220);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        biq localbiq = (biq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32220);
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
            localbiq.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 2: 
          localbiq.KCD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32220);
          return 0;
        case 3: 
          localbiq.KCN = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32220);
          return 0;
        case 4: 
          localbiq.KCE = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32220);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbiq.KCF = ((dyj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ih();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ih)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbiq.wRL = ((ih)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32220);
          return 0;
        }
        localbiq.KCz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32220);
        return 0;
      }
      AppMethodBeat.o(32220);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.biq
 * JD-Core Version:    0.7.0.1
 */