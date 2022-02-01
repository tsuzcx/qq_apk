package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class yb
  extends erp
{
  public String Oln;
  public String YGt;
  public String ZgS;
  public String ZgT;
  public int amount;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YGt == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.Oln == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.ZgT == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YGt != null) {
        paramVarArgs.g(2, this.YGt);
      }
      if (this.Oln != null) {
        paramVarArgs.g(3, this.Oln);
      }
      if (this.ZgS != null) {
        paramVarArgs.g(4, this.ZgS);
      }
      if (this.ZgT != null) {
        paramVarArgs.g(5, this.ZgT);
      }
      paramVarArgs.bS(6, this.amount);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label716;
      }
    }
    label716:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YGt != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YGt);
      }
      i = paramInt;
      if (this.Oln != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Oln);
      }
      paramInt = i;
      if (this.ZgS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZgS);
      }
      i = paramInt;
      if (this.ZgT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZgT);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.amount);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YGt == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.Oln == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.ZgT == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yb localyb = (yb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localyb.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localyb.YGt = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localyb.Oln = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localyb.ZgS = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localyb.ZgT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localyb.amount = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yb
 * JD-Core Version:    0.7.0.1
 */