package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayl
  extends cvw
{
  public int EN;
  public String GtF;
  public String data;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GtF == null)
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
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GtF != null) {
        paramVarArgs.d(2, this.GtF);
      }
      paramVarArgs.aS(3, this.EN);
      if (this.data != null) {
        paramVarArgs.d(4, this.data);
      }
      AppMethodBeat.o(124508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label574;
      }
    }
    label574:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GtF != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GtF);
      }
      i += f.a.a.b.b.a.bz(3, this.EN);
      paramInt = i;
      if (this.data != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.data);
      }
      AppMethodBeat.o(124508);
      return paramInt;
      Object localObject1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        localObject1 = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber((f.a.a.a.a)localObject1); paramInt > 0; paramInt = cvw.getNextFieldNumber((f.a.a.a.a)localObject1)) {
          if (!super.populateBuilderWithField((f.a.a.a.a)localObject1, this, paramInt)) {
            ((f.a.a.a.a)localObject1).gCg();
          }
        }
        if (this.GtF == null)
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
        Object localObject2 = (f.a.a.a.a)paramVarArgs[0];
        localObject1 = (ayl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124508);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject2).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject3 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jc();
            localObject3 = new f.a.a.a.a((byte[])localObject3, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject2).populateBuilderWithField((f.a.a.a.a)localObject3, (com.tencent.mm.bw.a)localObject2, cvw.getNextFieldNumber((f.a.a.a.a)localObject3))) {}
            ((ayl)localObject1).BaseRequest = ((jc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124508);
          return 0;
        case 2: 
          ((ayl)localObject1).GtF = ((f.a.a.a.a)localObject2).OmT.readString();
          AppMethodBeat.o(124508);
          return 0;
        case 3: 
          ((ayl)localObject1).EN = ((f.a.a.a.a)localObject2).OmT.zc();
          AppMethodBeat.o(124508);
          return 0;
        }
        ((ayl)localObject1).data = ((f.a.a.a.a)localObject2).OmT.readString();
        AppMethodBeat.o(124508);
        return 0;
      }
      AppMethodBeat.o(124508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayl
 * JD-Core Version:    0.7.0.1
 */