package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cog
  extends cvw
{
  public int HAf;
  public int HAg;
  public String HAh;
  public String uuW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127282);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HAf);
      paramVarArgs.aS(3, this.HAg);
      if (this.uuW != null) {
        paramVarArgs.d(4, this.uuW);
      }
      if (this.HAh != null) {
        paramVarArgs.d(5, this.HAh);
      }
      AppMethodBeat.o(127282);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HAf) + f.a.a.b.b.a.bz(3, this.HAg);
      paramInt = i;
      if (this.uuW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuW);
      }
      i = paramInt;
      if (this.HAh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HAh);
      }
      AppMethodBeat.o(127282);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(127282);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cog localcog = (cog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127282);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcog.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127282);
          return 0;
        case 2: 
          localcog.HAf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127282);
          return 0;
        case 3: 
          localcog.HAg = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(127282);
          return 0;
        case 4: 
          localcog.uuW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(127282);
          return 0;
        }
        localcog.HAh = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127282);
        return 0;
      }
      AppMethodBeat.o(127282);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cog
 * JD-Core Version:    0.7.0.1
 */