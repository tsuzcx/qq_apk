package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bps
  extends cvc
{
  public String GKq;
  public LinkedList<String> GKr;
  public String GaY;
  
  public bps()
  {
    AppMethodBeat.i(124516);
    this.GKr = new LinkedList();
    AppMethodBeat.o(124516);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124517);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GaY == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.GKq == null)
      {
        paramVarArgs = new b("Not all required fields were included: bizchat_name");
        AppMethodBeat.o(124517);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GaY != null) {
        paramVarArgs.d(2, this.GaY);
      }
      if (this.GKq != null) {
        paramVarArgs.d(3, this.GKq);
      }
      paramVarArgs.e(4, 1, this.GKr);
      AppMethodBeat.o(124517);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GaY);
      }
      i = paramInt;
      if (this.GKq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GKq);
      }
      paramInt = f.a.a.a.c(4, 1, this.GKr);
      AppMethodBeat.o(124517);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GKr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GaY == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        if (this.GKq == null)
        {
          paramVarArgs = new b("Not all required fields were included: bizchat_name");
          AppMethodBeat.o(124517);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124517);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bps localbps = (bps)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124517);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbps.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124517);
          return 0;
        case 2: 
          localbps.GaY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124517);
          return 0;
        case 3: 
          localbps.GKq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124517);
          return 0;
        }
        localbps.GKr.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(124517);
        return 0;
      }
      AppMethodBeat.o(124517);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bps
 * JD-Core Version:    0.7.0.1
 */