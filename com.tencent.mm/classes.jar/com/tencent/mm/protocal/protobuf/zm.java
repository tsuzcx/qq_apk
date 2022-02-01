package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class zm
  extends dpc
{
  public int KXC;
  public com.tencent.mm.bw.b LkM;
  public com.tencent.mm.bw.b LkN;
  public com.tencent.mm.bw.b LkO;
  public com.tencent.mm.bw.b LkP;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(225288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(225288);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.LkM != null) {
        paramVarArgs.c(2, this.LkM);
      }
      if (this.LkN != null) {
        paramVarArgs.c(3, this.LkN);
      }
      if (this.LkO != null) {
        paramVarArgs.c(4, this.LkO);
      }
      paramVarArgs.aM(5, this.version);
      paramVarArgs.aM(6, this.KXC);
      if (this.LkP != null) {
        paramVarArgs.c(7, this.LkP);
      }
      AppMethodBeat.o(225288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (int i = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LkM != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.LkM);
      }
      i = paramInt;
      if (this.LkN != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LkN);
      }
      paramInt = i;
      if (this.LkO != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.LkO);
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.version) + g.a.a.b.b.a.bu(6, this.KXC);
      paramInt = i;
      if (this.LkP != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.LkP);
      }
      AppMethodBeat.o(225288);
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
          AppMethodBeat.o(225288);
          throw paramVarArgs;
        }
        AppMethodBeat.o(225288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zm localzm = (zm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(225288);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(225288);
          return 0;
        case 2: 
          localzm.LkM = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(225288);
          return 0;
        case 3: 
          localzm.LkN = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(225288);
          return 0;
        case 4: 
          localzm.LkO = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(225288);
          return 0;
        case 5: 
          localzm.version = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(225288);
          return 0;
        case 6: 
          localzm.KXC = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(225288);
          return 0;
        }
        localzm.LkP = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(225288);
        return 0;
      }
      AppMethodBeat.o(225288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zm
 * JD-Core Version:    0.7.0.1
 */