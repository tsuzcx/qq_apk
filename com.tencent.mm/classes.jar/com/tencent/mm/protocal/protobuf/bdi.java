package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bdi
  extends cvp
{
  public com.tencent.mm.bx.b GzS;
  public LinkedList<bus> GzU;
  public int GzV;
  public LinkedList<String> GzW;
  public int GzX;
  public boolean GzY;
  public bup GzZ;
  
  public bdi()
  {
    AppMethodBeat.i(211938);
    this.GzU = new LinkedList();
    this.GzW = new LinkedList();
    AppMethodBeat.o(211938);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211939);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(211939);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.GzU);
      if (this.GzS != null) {
        paramVarArgs.c(3, this.GzS);
      }
      paramVarArgs.aS(4, this.GzV);
      paramVarArgs.e(5, 1, this.GzW);
      paramVarArgs.aS(6, this.GzX);
      paramVarArgs.bt(7, this.GzY);
      if (this.GzZ != null)
      {
        paramVarArgs.lC(8, this.GzZ.computeSize());
        this.GzZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(211939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GzU);
      paramInt = i;
      if (this.GzS != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GzS);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GzV) + f.a.a.a.c(5, 1, this.GzW) + f.a.a.b.b.a.bz(6, this.GzX) + f.a.a.b.b.a.alV(7);
      paramInt = i;
      if (this.GzZ != null) {
        paramInt = i + f.a.a.a.lB(8, this.GzZ.computeSize());
      }
      AppMethodBeat.o(211939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GzU.clear();
        this.GzW.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(211939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(211939);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdi localbdi = (bdi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211939);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdi.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211939);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bus();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bus)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdi.GzU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(211939);
          return 0;
        case 3: 
          localbdi.GzS = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(211939);
          return 0;
        case 4: 
          localbdi.GzV = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(211939);
          return 0;
        case 5: 
          localbdi.GzW.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(211939);
          return 0;
        case 6: 
          localbdi.GzX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(211939);
          return 0;
        case 7: 
          localbdi.GzY = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(211939);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bup();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bup)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdi.GzZ = ((bup)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(211939);
        return 0;
      }
      AppMethodBeat.o(211939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdi
 * JD-Core Version:    0.7.0.1
 */