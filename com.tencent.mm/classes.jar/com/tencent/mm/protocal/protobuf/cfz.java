package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfz
  extends cvc
{
  public String CPp;
  public String GZd;
  public String dwF;
  public String signature;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129970);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GZd != null) {
        paramVarArgs.d(2, this.GZd);
      }
      if (this.signature != null) {
        paramVarArgs.d(3, this.signature);
      }
      if (this.CPp != null) {
        paramVarArgs.d(4, this.CPp);
      }
      if (this.dwF != null) {
        paramVarArgs.d(5, this.dwF);
      }
      AppMethodBeat.o(129970);
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
      if (this.GZd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GZd);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.signature);
      }
      paramInt = i;
      if (this.CPp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CPp);
      }
      i = paramInt;
      if (this.dwF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dwF);
      }
      AppMethodBeat.o(129970);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(129970);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(129970);
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
            localcfz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(129970);
          return 0;
        case 2: 
          localcfz.GZd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 3: 
          localcfz.signature = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129970);
          return 0;
        case 4: 
          localcfz.CPp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(129970);
          return 0;
        }
        localcfz.dwF = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(129970);
        return 0;
      }
      AppMethodBeat.o(129970);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */