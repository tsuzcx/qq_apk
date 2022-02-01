package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agj
  extends erp
{
  public String ZpC;
  public String ZpD;
  public String ZpE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124479);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZpC == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.ZpD == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_type");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.ZpE == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_id");
        AppMethodBeat.o(124479);
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
      if (this.ZpD != null) {
        paramVarArgs.g(3, this.ZpD);
      }
      if (this.ZpE != null) {
        paramVarArgs.g(4, this.ZpE);
      }
      AppMethodBeat.o(124479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label608;
      }
    }
    label608:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZpC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZpC);
      }
      i = paramInt;
      if (this.ZpD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZpD);
      }
      paramInt = i;
      if (this.ZpE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZpE);
      }
      AppMethodBeat.o(124479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZpC == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.ZpD == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_type");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.ZpE == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        agj localagj = (agj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124479);
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
            localagj.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(124479);
          return 0;
        case 2: 
          localagj.ZpC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124479);
          return 0;
        case 3: 
          localagj.ZpD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(124479);
          return 0;
        }
        localagj.ZpE = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(124479);
        return 0;
      }
      AppMethodBeat.o(124479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agj
 * JD-Core Version:    0.7.0.1
 */