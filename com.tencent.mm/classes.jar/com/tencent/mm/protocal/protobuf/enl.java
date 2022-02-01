package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class enl
  extends dpc
{
  public int BsF;
  public int BsG;
  public String Lir;
  public String Lis;
  public String Nlm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152718);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152718);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.BsF);
      paramVarArgs.aM(3, this.BsG);
      if (this.Nlm != null) {
        paramVarArgs.e(4, this.Nlm);
      }
      if (this.Lir != null) {
        paramVarArgs.e(5, this.Lir);
      }
      if (this.Lis != null) {
        paramVarArgs.e(6, this.Lis);
      }
      AppMethodBeat.o(152718);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.BsF) + g.a.a.b.b.a.bu(3, this.BsG);
      paramInt = i;
      if (this.Nlm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Nlm);
      }
      i = paramInt;
      if (this.Lir != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lir);
      }
      paramInt = i;
      if (this.Lis != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lis);
      }
      AppMethodBeat.o(152718);
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
          AppMethodBeat.o(152718);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152718);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        enl localenl = (enl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152718);
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
            localenl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152718);
          return 0;
        case 2: 
          localenl.BsF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152718);
          return 0;
        case 3: 
          localenl.BsG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152718);
          return 0;
        case 4: 
          localenl.Nlm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152718);
          return 0;
        case 5: 
          localenl.Lir = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152718);
          return 0;
        }
        localenl.Lis = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152718);
        return 0;
      }
      AppMethodBeat.o(152718);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enl
 * JD-Core Version:    0.7.0.1
 */