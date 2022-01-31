package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class qo
  extends buy
{
  public int cCy;
  public String kNw;
  public String wIR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(48801);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.kNw == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_url");
        AppMethodBeat.o(48801);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.kNw != null) {
        paramVarArgs.e(2, this.kNw);
      }
      paramVarArgs.aO(3, this.cCy);
      if (this.wIR != null) {
        paramVarArgs.e(4, this.wIR);
      }
      AppMethodBeat.o(48801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.kNw != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.kNw);
      }
      i += e.a.a.b.b.a.bl(3, this.cCy);
      paramInt = i;
      if (this.wIR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wIR);
      }
      AppMethodBeat.o(48801);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.kNw == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_url");
          AppMethodBeat.o(48801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(48801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        qo localqo = (qo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(48801);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localqo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(48801);
          return 0;
        case 2: 
          localqo.kNw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(48801);
          return 0;
        case 3: 
          localqo.cCy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(48801);
          return 0;
        }
        localqo.wIR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(48801);
        return 0;
      }
      AppMethodBeat.o(48801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qo
 * JD-Core Version:    0.7.0.1
 */