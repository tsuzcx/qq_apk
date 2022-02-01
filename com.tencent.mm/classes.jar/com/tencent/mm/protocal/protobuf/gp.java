package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gp
  extends dpc
{
  public com.tencent.mm.bw.b KKm;
  public int KKr;
  public int KKs;
  public gu KKt;
  public gq KKu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KKr);
      paramVarArgs.aM(3, this.KKs);
      if (this.KKm != null) {
        paramVarArgs.c(4, this.KKm);
      }
      if (this.KKt != null)
      {
        paramVarArgs.ni(5, this.KKt.computeSize());
        this.KKt.writeFields(paramVarArgs);
      }
      if (this.KKu != null)
      {
        paramVarArgs.ni(6, this.KKu.computeSize());
        this.KKu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KKr) + g.a.a.b.b.a.bu(3, this.KKs);
      paramInt = i;
      if (this.KKm != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.KKm);
      }
      i = paramInt;
      if (this.KKt != null) {
        i = paramInt + g.a.a.a.nh(5, this.KKt.computeSize());
      }
      paramInt = i;
      if (this.KKu != null) {
        paramInt = i + g.a.a.a.nh(6, this.KKu.computeSize());
      }
      AppMethodBeat.o(32119);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gp localgp = (gp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
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
            localgp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localgp.KKr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localgp.KKs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localgp.KKm = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localgp.KKt = ((gu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new gq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((gq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localgp.KKu = ((gq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gp
 * JD-Core Version:    0.7.0.1
 */