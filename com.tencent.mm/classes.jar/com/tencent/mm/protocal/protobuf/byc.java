package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class byc
  extends cvp
{
  public int oxA;
  public String oxB;
  public String oxz;
  public String ozQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114045);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114045);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.oxz != null) {
        paramVarArgs.d(2, this.oxz);
      }
      paramVarArgs.aS(3, this.oxA);
      if (this.oxB != null) {
        paramVarArgs.d(4, this.oxB);
      }
      if (this.ozQ != null) {
        paramVarArgs.d(5, this.ozQ);
      }
      AppMethodBeat.o(114045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oxz != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oxz);
      }
      i += f.a.a.b.b.a.bz(3, this.oxA);
      paramInt = i;
      if (this.oxB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oxB);
      }
      i = paramInt;
      if (this.ozQ != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ozQ);
      }
      AppMethodBeat.o(114045);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114045);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        byc localbyc = (byc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114045);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbyc.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114045);
          return 0;
        case 2: 
          localbyc.oxz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114045);
          return 0;
        case 3: 
          localbyc.oxA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114045);
          return 0;
        case 4: 
          localbyc.oxB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114045);
          return 0;
        }
        localbyc.ozQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114045);
        return 0;
      }
      AppMethodBeat.o(114045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */