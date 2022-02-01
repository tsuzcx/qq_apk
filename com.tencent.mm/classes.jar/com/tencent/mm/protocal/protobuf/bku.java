package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bku
  extends dpc
{
  public String LTF;
  public vc LTG;
  public int LTH;
  public dtc LTI;
  public String pTY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114023);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114023);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.pTY != null) {
        paramVarArgs.e(2, this.pTY);
      }
      if (this.LTF != null) {
        paramVarArgs.e(3, this.LTF);
      }
      if (this.LTG != null)
      {
        paramVarArgs.ni(4, this.LTG.computeSize());
        this.LTG.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.LTH);
      if (this.LTI != null)
      {
        paramVarArgs.ni(6, this.LTI.computeSize());
        this.LTI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114023);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pTY != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.pTY);
      }
      i = paramInt;
      if (this.LTF != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LTF);
      }
      paramInt = i;
      if (this.LTG != null) {
        paramInt = i + g.a.a.a.nh(4, this.LTG.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.LTH);
      paramInt = i;
      if (this.LTI != null) {
        paramInt = i + g.a.a.a.nh(6, this.LTI.computeSize());
      }
      AppMethodBeat.o(114023);
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
          AppMethodBeat.o(114023);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bku localbku = (bku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114023);
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
            localbku.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 2: 
          localbku.pTY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 3: 
          localbku.LTF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114023);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new vc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((vc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbku.LTG = ((vc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114023);
          return 0;
        case 5: 
          localbku.LTH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114023);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dtc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dtc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbku.LTI = ((dtc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114023);
        return 0;
      }
      AppMethodBeat.o(114023);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bku
 * JD-Core Version:    0.7.0.1
 */