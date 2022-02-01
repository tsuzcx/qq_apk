package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bre
  extends dyl
{
  public String SqC;
  public int Vh;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124508);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SqC == null)
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
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.SqC != null) {
        paramVarArgs.f(2, this.SqC);
      }
      paramVarArgs.aY(3, this.Vh);
      if (this.data != null) {
        paramVarArgs.f(4, this.data);
      }
      AppMethodBeat.o(124508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SqC != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.SqC);
      }
      i += g.a.a.b.b.a.bM(3, this.Vh);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.data);
      }
      AppMethodBeat.o(124508);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber((g.a.a.a.a)localObject1); paramInt > 0; paramInt = dyl.getNextFieldNumber((g.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((g.a.a.a.a)localObject1, this, paramInt)) {
            ((g.a.a.a.a)localObject1).iUs();
          }
        }
        if (this.SqC == null)
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
        Object localObject2 = (g.a.a.a.a)paramVarArgs[0];
        localObject1 = (bre)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124508);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject2).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject2 != null) && (localObject2.length > 0)) {
              localjg.parseFrom((byte[])localObject2);
            }
            ((bre)localObject1).BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(124508);
          return 0;
        case 2: 
          ((bre)localObject1).SqC = ((g.a.a.a.a)localObject2).abFh.readString();
          AppMethodBeat.o(124508);
          return 0;
        case 3: 
          ((bre)localObject1).Vh = ((g.a.a.a.a)localObject2).abFh.AK();
          AppMethodBeat.o(124508);
          return 0;
        }
        ((bre)localObject1).data = ((g.a.a.a.a)localObject2).abFh.readString();
        AppMethodBeat.o(124508);
        return 0;
      }
      AppMethodBeat.o(124508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bre
 * JD-Core Version:    0.7.0.1
 */