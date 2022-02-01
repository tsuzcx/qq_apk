package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class wy
  extends dop
{
  public String CpJ;
  public String CpP;
  public String CpQ;
  public long CrW;
  public String Lhy;
  public String dNQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72450);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dNQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: req_key");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.CpQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: transfer_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.CpP == null)
      {
        paramVarArgs = new b("Not all required fields were included: transaction_id");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.CpJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_openid");
        AppMethodBeat.o(72450);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNQ != null) {
        paramVarArgs.e(2, this.dNQ);
      }
      if (this.CpQ != null) {
        paramVarArgs.e(3, this.CpQ);
      }
      if (this.CpP != null) {
        paramVarArgs.e(4, this.CpP);
      }
      if (this.CpJ != null) {
        paramVarArgs.e(5, this.CpJ);
      }
      paramVarArgs.bb(6, this.CrW);
      if (this.Lhy != null) {
        paramVarArgs.e(7, this.Lhy);
      }
      AppMethodBeat.o(72450);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label850;
      }
    }
    label850:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNQ != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNQ);
      }
      i = paramInt;
      if (this.CpQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.CpQ);
      }
      paramInt = i;
      if (this.CpP != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.CpP);
      }
      i = paramInt;
      if (this.CpJ != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.CpJ);
      }
      i += g.a.a.b.b.a.r(6, this.CrW);
      paramInt = i;
      if (this.Lhy != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lhy);
      }
      AppMethodBeat.o(72450);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.dNQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: req_key");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.CpQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: transfer_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.CpP == null)
        {
          paramVarArgs = new b("Not all required fields were included: transaction_id");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        if (this.CpJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_openid");
          AppMethodBeat.o(72450);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72450);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        wy localwy = (wy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72450);
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
            localwy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72450);
          return 0;
        case 2: 
          localwy.dNQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 3: 
          localwy.CpQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 4: 
          localwy.CpP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 5: 
          localwy.CpJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72450);
          return 0;
        case 6: 
          localwy.CrW = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(72450);
          return 0;
        }
        localwy.Lhy = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72450);
        return 0;
      }
      AppMethodBeat.o(72450);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wy
 * JD-Core Version:    0.7.0.1
 */