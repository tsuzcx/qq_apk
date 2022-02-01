package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cfv
  extends erp
{
  public String ZpC;
  public int bUl;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZpC == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.data == null)
      {
        paramVarArgs = new b("Not all required fields were included: data");
        AppMethodBeat.o(124508);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZpC != null) {
        paramVarArgs.g(2, this.ZpC);
      }
      paramVarArgs.bS(3, this.bUl);
      if (this.data != null) {
        paramVarArgs.g(4, this.data);
      }
      AppMethodBeat.o(124508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZpC != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZpC);
      }
      i += i.a.a.b.b.a.cJ(3, this.bUl);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.data);
      }
      AppMethodBeat.o(124508);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber((i.a.a.a.a)localObject1); paramInt > 0; paramInt = erp.getNextFieldNumber((i.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((i.a.a.a.a)localObject1, this, paramInt)) {
            ((i.a.a.a.a)localObject1).kFT();
          }
        }
        if (this.ZpC == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        if (paramVarArgs == null)
        {
          paramVarArgs = new b("Not all required fields were included: data");
          AppMethodBeat.o(124508);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject2 = (i.a.a.a.a)paramVarArgs[0];
        localObject1 = (cfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124508);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject2).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject2 != null) && (localObject2.length > 0)) {
              localkc.parseFrom((byte[])localObject2);
            }
            ((cfv)localObject1).BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124508);
          return 0;
        case 2: 
          ((cfv)localObject1).ZpC = ((i.a.a.a.a)localObject2).ajGk.readString();
          AppMethodBeat.o(124508);
          return 0;
        case 3: 
          ((cfv)localObject1).bUl = ((i.a.a.a.a)localObject2).ajGk.aar();
          AppMethodBeat.o(124508);
          return 0;
        }
        ((cfv)localObject1).data = ((i.a.a.a.a)localObject2).ajGk.readString();
        AppMethodBeat.o(124508);
        return 0;
      }
      AppMethodBeat.o(124508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfv
 * JD-Core Version:    0.7.0.1
 */