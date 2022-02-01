package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dhh
  extends dpc
{
  public sx LWE;
  public cbx LWG;
  public String MGq;
  public String MGr;
  public int pTZ;
  public String pUa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72563);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72563);
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
      if (this.LWG != null)
      {
        paramVarArgs.ni(4, this.LWG.computeSize());
        this.LWG.writeFields(paramVarArgs);
      }
      if (this.MGq != null) {
        paramVarArgs.e(5, this.MGq);
      }
      if (this.MGr != null) {
        paramVarArgs.e(6, this.MGr);
      }
      if (this.LWE != null)
      {
        paramVarArgs.ni(7, this.LWE.computeSize());
        this.LWE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.LWG != null) {
        i = paramInt + g.a.a.a.nh(4, this.LWG.computeSize());
      }
      paramInt = i;
      if (this.MGq != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MGq);
      }
      i = paramInt;
      if (this.MGr != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.MGr);
      }
      paramInt = i;
      if (this.LWE != null) {
        paramInt = i + g.a.a.a.nh(7, this.LWE.computeSize());
      }
      AppMethodBeat.o(72563);
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
          AppMethodBeat.o(72563);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dhh localdhh = (dhh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72563);
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
            localdhh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 2: 
          localdhh.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72563);
          return 0;
        case 3: 
          localdhh.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbx();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdhh.LWG = ((cbx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72563);
          return 0;
        case 5: 
          localdhh.MGq = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72563);
          return 0;
        case 6: 
          localdhh.MGr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72563);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sx();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((sx)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdhh.LWE = ((sx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72563);
        return 0;
      }
      AppMethodBeat.o(72563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhh
 * JD-Core Version:    0.7.0.1
 */