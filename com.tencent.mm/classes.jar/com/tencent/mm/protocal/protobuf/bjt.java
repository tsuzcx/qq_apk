package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bjt
  extends dop
{
  public String HXc;
  public String KXJ;
  public String LTm;
  public String LTn;
  public String Lpg;
  public String qcM;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lpg == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.LTm == null)
      {
        paramVarArgs = new b("Not all required fields were included: group_id");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.HXc == null)
      {
        paramVarArgs = new b("Not all required fields were included: time_stamp");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.qcM == null)
      {
        paramVarArgs = new b("Not all required fields were included: nonce_str");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.signature == null)
      {
        paramVarArgs = new b("Not all required fields were included: signature");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.KXJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: from_url");
        AppMethodBeat.o(124506);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lpg != null) {
        paramVarArgs.e(2, this.Lpg);
      }
      if (this.LTm != null) {
        paramVarArgs.e(3, this.LTm);
      }
      if (this.HXc != null) {
        paramVarArgs.e(4, this.HXc);
      }
      if (this.qcM != null) {
        paramVarArgs.e(5, this.qcM);
      }
      if (this.signature != null) {
        paramVarArgs.e(6, this.signature);
      }
      if (this.KXJ != null) {
        paramVarArgs.e(7, this.KXJ);
      }
      if (this.LTn != null) {
        paramVarArgs.e(8, this.LTn);
      }
      AppMethodBeat.o(124506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1026;
      }
    }
    label1026:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lpg != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lpg);
      }
      i = paramInt;
      if (this.LTm != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LTm);
      }
      paramInt = i;
      if (this.HXc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.HXc);
      }
      i = paramInt;
      if (this.qcM != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.qcM);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.signature);
      }
      i = paramInt;
      if (this.KXJ != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KXJ);
      }
      paramInt = i;
      if (this.LTn != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LTn);
      }
      AppMethodBeat.o(124506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.Lpg == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.LTm == null)
        {
          paramVarArgs = new b("Not all required fields were included: group_id");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.HXc == null)
        {
          paramVarArgs = new b("Not all required fields were included: time_stamp");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.qcM == null)
        {
          paramVarArgs = new b("Not all required fields were included: nonce_str");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.signature == null)
        {
          paramVarArgs = new b("Not all required fields were included: signature");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        if (this.KXJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: from_url");
          AppMethodBeat.o(124506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bjt localbjt = (bjt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124506);
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
            localbjt.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124506);
          return 0;
        case 2: 
          localbjt.Lpg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 3: 
          localbjt.LTm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 4: 
          localbjt.HXc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 5: 
          localbjt.qcM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 6: 
          localbjt.signature = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        case 7: 
          localbjt.KXJ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124506);
          return 0;
        }
        localbjt.LTn = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(124506);
        return 0;
      }
      AppMethodBeat.o(124506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjt
 * JD-Core Version:    0.7.0.1
 */