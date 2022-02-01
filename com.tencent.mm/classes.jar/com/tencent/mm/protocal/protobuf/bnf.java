package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bnf
  extends dpc
{
  public float LVN;
  public String LVO;
  public String LjH;
  public String action_data;
  public int pTZ;
  public String pUa;
  public String person_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104370);
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
      if (this.person_id != null) {
        paramVarArgs.e(4, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.e(5, this.action_data);
      }
      paramVarArgs.E(6, this.LVN);
      if (this.LjH != null) {
        paramVarArgs.e(7, this.LjH);
      }
      if (this.LVO != null) {
        paramVarArgs.e(8, this.LVO);
      }
      AppMethodBeat.o(104370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label753;
      }
    }
    label753:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.pTZ);
      paramInt = i;
      if (this.pUa != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.pUa);
      }
      i = paramInt;
      if (this.person_id != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.person_id);
      }
      paramInt = i;
      if (this.action_data != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.action_data);
      }
      i = paramInt + (g.a.a.b.b.a.fS(6) + 4);
      paramInt = i;
      if (this.LjH != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.LjH);
      }
      i = paramInt;
      if (this.LVO != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.LVO);
      }
      AppMethodBeat.o(104370);
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
          AppMethodBeat.o(104370);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bnf localbnf = (bnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104370);
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
            localbnf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104370);
          return 0;
        case 2: 
          localbnf.pTZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104370);
          return 0;
        case 3: 
          localbnf.pUa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 4: 
          localbnf.person_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 5: 
          localbnf.action_data = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104370);
          return 0;
        case 6: 
          localbnf.LVN = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
          AppMethodBeat.o(104370);
          return 0;
        case 7: 
          localbnf.LjH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104370);
          return 0;
        }
        localbnf.LVO = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(104370);
        return 0;
      }
      AppMethodBeat.o(104370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnf
 * JD-Core Version:    0.7.0.1
 */