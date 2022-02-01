package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class uy
  extends cvc
{
  public String FUv;
  public String FUw;
  public String FvH;
  public String FvI;
  public int vls;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FvH == null)
      {
        paramVarArgs = new b("Not all required fields were included: f2f_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.FvI == null)
      {
        paramVarArgs = new b("Not all required fields were included: trans_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.FUw == null)
      {
        paramVarArgs = new b("Not all required fields were included: receiver_open_id");
        AppMethodBeat.o(91412);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FvH != null) {
        paramVarArgs.d(2, this.FvH);
      }
      if (this.FvI != null) {
        paramVarArgs.d(3, this.FvI);
      }
      if (this.FUv != null) {
        paramVarArgs.d(4, this.FUv);
      }
      if (this.FUw != null) {
        paramVarArgs.d(5, this.FUw);
      }
      paramVarArgs.aS(6, this.vls);
      AppMethodBeat.o(91412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label742;
      }
    }
    label742:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FvH != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FvH);
      }
      i = paramInt;
      if (this.FvI != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FvI);
      }
      paramInt = i;
      if (this.FUv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FUv);
      }
      i = paramInt;
      if (this.FUw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FUw);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.vls);
      AppMethodBeat.o(91412);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FvH == null)
        {
          paramVarArgs = new b("Not all required fields were included: f2f_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.FvI == null)
        {
          paramVarArgs = new b("Not all required fields were included: trans_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        if (this.FUw == null)
        {
          paramVarArgs = new b("Not all required fields were included: receiver_open_id");
          AppMethodBeat.o(91412);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        uy localuy = (uy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91412);
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
            localuy.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91412);
          return 0;
        case 2: 
          localuy.FvH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 3: 
          localuy.FvI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 4: 
          localuy.FUv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91412);
          return 0;
        case 5: 
          localuy.FUw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91412);
          return 0;
        }
        localuy.vls = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(91412);
        return 0;
      }
      AppMethodBeat.o(91412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.uy
 * JD-Core Version:    0.7.0.1
 */