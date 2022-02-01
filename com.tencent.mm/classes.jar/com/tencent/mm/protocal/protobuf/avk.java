package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class avk
  extends ckq
{
  public String CND;
  public String CPg;
  public df DuN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91486);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DuN == null)
      {
        paramVarArgs = new b("Not all required fields were included: Address");
        AppMethodBeat.o(91486);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CND != null) {
        paramVarArgs.d(2, this.CND);
      }
      if (this.CPg != null) {
        paramVarArgs.d(3, this.CPg);
      }
      if (this.DuN != null)
      {
        paramVarArgs.kX(4, this.DuN.computeSize());
        this.DuN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CND != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CND);
      }
      i = paramInt;
      if (this.CPg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CPg);
      }
      paramInt = i;
      if (this.DuN != null) {
        paramInt = i + f.a.a.a.kW(4, this.DuN.computeSize());
      }
      AppMethodBeat.o(91486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DuN == null)
        {
          paramVarArgs = new b("Not all required fields were included: Address");
          AppMethodBeat.o(91486);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        avk localavk = (avk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91486);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localavk.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91486);
          return 0;
        case 2: 
          localavk.CND = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91486);
          return 0;
        case 3: 
          localavk.CPg = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91486);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new df();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((df)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localavk.DuN = ((df)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91486);
        return 0;
      }
      AppMethodBeat.o(91486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.avk
 * JD-Core Version:    0.7.0.1
 */