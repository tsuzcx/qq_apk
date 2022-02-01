package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dok
  extends cvc
{
  public String HvZ;
  public String Hwa;
  public String Hwb;
  public String dwF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129977);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Hwa != null) {
        paramVarArgs.d(2, this.Hwa);
      }
      if (this.HvZ != null) {
        paramVarArgs.d(3, this.HvZ);
      }
      if (this.Hwb != null) {
        paramVarArgs.d(4, this.Hwb);
      }
      if (this.dwF != null) {
        paramVarArgs.d(5, this.dwF);
      }
      AppMethodBeat.o(129977);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hwa != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hwa);
      }
      i = paramInt;
      if (this.HvZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HvZ);
      }
      paramInt = i;
      if (this.Hwb != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Hwb);
      }
      i = paramInt;
      if (this.dwF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dwF);
      }
      AppMethodBeat.o(129977);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(129977);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dok localdok = (dok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129977);
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
            localdok.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(129977);
          return 0;
        case 2: 
          localdok.Hwa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 3: 
          localdok.HvZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129977);
          return 0;
        case 4: 
          localdok.Hwb = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129977);
          return 0;
        }
        localdok.dwF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(129977);
        return 0;
      }
      AppMethodBeat.o(129977);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dok
 * JD-Core Version:    0.7.0.1
 */