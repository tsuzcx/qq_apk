package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cfk
  extends dyl
{
  public eae RQU;
  public int TmP;
  public String UserName;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32293);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RQU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(32293);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.f(2, this.UserName);
      }
      paramVarArgs.aY(3, this.TmP);
      if (this.RQU != null)
      {
        paramVarArgs.oE(4, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32293);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.UserName);
      }
      i += g.a.a.b.b.a.bM(3, this.TmP);
      paramInt = i;
      if (this.RQU != null) {
        paramInt = i + g.a.a.a.oD(4, this.RQU.computeSize());
      }
      AppMethodBeat.o(32293);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RQU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(32293);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32293);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cfk localcfk = (cfk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32293);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcfk.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32293);
          return 0;
        case 2: 
          localcfk.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32293);
          return 0;
        case 3: 
          localcfk.TmP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32293);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localcfk.RQU = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32293);
        return 0;
      }
      AppMethodBeat.o(32293);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfk
 * JD-Core Version:    0.7.0.1
 */