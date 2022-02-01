package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bce
  extends cvw
{
  public String FJt;
  public String GRY;
  public String GRZ;
  public qw GSa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114787);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GRY == null)
      {
        paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
        AppMethodBeat.o(114787);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GRY != null) {
        paramVarArgs.d(2, this.GRY);
      }
      if (this.GRZ != null) {
        paramVarArgs.d(3, this.GRZ);
      }
      if (this.FJt != null) {
        paramVarArgs.d(4, this.FJt);
      }
      if (this.GSa != null)
      {
        paramVarArgs.lJ(5, this.GSa.computeSize());
        this.GSa.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114787);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GRY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GRY);
      }
      i = paramInt;
      if (this.GRZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GRZ);
      }
      paramInt = i;
      if (this.FJt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FJt);
      }
      i = paramInt;
      if (this.GSa != null) {
        i = paramInt + f.a.a.a.lI(5, this.GSa.computeSize());
      }
      AppMethodBeat.o(114787);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GRY == null)
        {
          paramVarArgs = new b("Not all required fields were included: FunctionMsgID");
          AppMethodBeat.o(114787);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bce localbce = (bce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114787);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbce.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114787);
          return 0;
        case 2: 
          localbce.GRY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 3: 
          localbce.GRZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114787);
          return 0;
        case 4: 
          localbce.FJt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114787);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbce.GSa = ((qw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114787);
        return 0;
      }
      AppMethodBeat.o(114787);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bce
 * JD-Core Version:    0.7.0.1
 */