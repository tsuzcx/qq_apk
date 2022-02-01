package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class abh
  extends cvc
{
  public String GaY;
  public String GaZ;
  public String Gba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124479);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GaY == null)
      {
        paramVarArgs = new b("Not all required fields were included: corp_id");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.GaZ == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_type");
        AppMethodBeat.o(124479);
        throw paramVarArgs;
      }
      if (this.Gba == null)
      {
        paramVarArgs = new b("Not all required fields were included: qychat_id");
        AppMethodBeat.o(124479);
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
      if (this.GaZ != null) {
        paramVarArgs.d(3, this.GaZ);
      }
      if (this.Gba != null) {
        paramVarArgs.d(4, this.Gba);
      }
      AppMethodBeat.o(124479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GaY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GaY);
      }
      i = paramInt;
      if (this.GaZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GaZ);
      }
      paramInt = i;
      if (this.Gba != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gba);
      }
      AppMethodBeat.o(124479);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GaY == null)
        {
          paramVarArgs = new b("Not all required fields were included: corp_id");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.GaZ == null)
        {
          paramVarArgs = new b("Not all required fields were included: qychat_type");
          AppMethodBeat.o(124479);
          throw paramVarArgs;
        }
        if (this.Gba == null)
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
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        abh localabh = (abh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124479);
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
            localabh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124479);
          return 0;
        case 2: 
          localabh.GaY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124479);
          return 0;
        case 3: 
          localabh.GaZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124479);
          return 0;
        }
        localabh.Gba = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(124479);
        return 0;
      }
      AppMethodBeat.o(124479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abh
 * JD-Core Version:    0.7.0.1
 */