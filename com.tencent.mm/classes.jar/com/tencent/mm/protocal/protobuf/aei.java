package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aei
  extends dyl
{
  public String RUp;
  public bms SqS;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124481);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SqS == null)
      {
        paramVarArgs = new b("Not all required fields were included: full_chat");
        AppMethodBeat.o(124481);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.RUp != null) {
        paramVarArgs.f(2, this.RUp);
      }
      if (this.SqS != null)
      {
        paramVarArgs.oE(3, this.SqS.computeSize());
        this.SqS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label530;
      }
    }
    label530:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.RUp != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RUp);
      }
      i = paramInt;
      if (this.SqS != null) {
        i = paramInt + g.a.a.a.oD(3, this.SqS.computeSize());
      }
      AppMethodBeat.o(124481);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.SqS == null)
        {
          paramVarArgs = new b("Not all required fields were included: full_chat");
          AppMethodBeat.o(124481);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aei localaei = (aei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124481);
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
            localaei.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124481);
          return 0;
        case 2: 
          localaei.RUp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124481);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bms();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bms)localObject2).parseFrom((byte[])localObject1);
          }
          localaei.SqS = ((bms)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124481);
        return 0;
      }
      AppMethodBeat.o(124481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aei
 * JD-Core Version:    0.7.0.1
 */