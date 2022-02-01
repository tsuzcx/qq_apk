package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ebh
  extends dyl
{
  public String idV;
  public String mac;
  public String userName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32419);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.mac == null)
      {
        paramVarArgs = new b("Not all required fields were included: mac");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.userName == null)
      {
        paramVarArgs = new b("Not all required fields were included: userName");
        AppMethodBeat.o(32419);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.mac != null) {
        paramVarArgs.f(2, this.mac);
      }
      if (this.userName != null) {
        paramVarArgs.f(3, this.userName);
      }
      if (this.idV != null) {
        paramVarArgs.f(4, this.idV);
      }
      AppMethodBeat.o(32419);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mac != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.mac);
      }
      i = paramInt;
      if (this.userName != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.userName);
      }
      paramInt = i;
      if (this.idV != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.idV);
      }
      AppMethodBeat.o(32419);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.mac == null)
        {
          paramVarArgs = new b("Not all required fields were included: mac");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        if (this.userName == null)
        {
          paramVarArgs = new b("Not all required fields were included: userName");
          AppMethodBeat.o(32419);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32419);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ebh localebh = (ebh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32419);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localebh.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32419);
          return 0;
        case 2: 
          localebh.mac = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32419);
          return 0;
        case 3: 
          localebh.userName = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32419);
          return 0;
        }
        localebh.idV = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(32419);
        return 0;
      }
      AppMethodBeat.o(32419);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebh
 * JD-Core Version:    0.7.0.1
 */