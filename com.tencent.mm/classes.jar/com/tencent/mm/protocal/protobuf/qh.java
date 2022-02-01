package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qh
  extends dop
{
  public String KXi;
  public int KXj;
  public com.tencent.mm.bw.b KXk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212264);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXi == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(212264);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KXi != null) {
        paramVarArgs.e(2, this.KXi);
      }
      paramVarArgs.aM(3, this.KXj);
      if (this.KXk != null) {
        paramVarArgs.c(4, this.KXk);
      }
      AppMethodBeat.o(212264);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KXi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KXi);
      }
      i += g.a.a.b.b.a.bu(3, this.KXj);
      paramInt = i;
      if (this.KXk != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.KXk);
      }
      AppMethodBeat.o(212264);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KXi == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(212264);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212264);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        qh localqh = (qh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212264);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localqh.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212264);
          return 0;
        case 2: 
          localqh.KXi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212264);
          return 0;
        case 3: 
          localqh.KXj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212264);
          return 0;
        }
        localqh.KXk = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(212264);
        return 0;
      }
      AppMethodBeat.o(212264);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qh
 * JD-Core Version:    0.7.0.1
 */