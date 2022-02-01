package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class amo
  extends cvw
{
  public int GEK;
  public alw GEg;
  public String dvq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GEg != null)
      {
        paramVarArgs.lJ(2, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      if (this.dvq != null) {
        paramVarArgs.d(3, this.dvq);
      }
      paramVarArgs.aS(4, this.GEK);
      AppMethodBeat.o(189319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(2, this.GEg.computeSize());
      }
      i = paramInt;
      if (this.dvq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dvq);
      }
      paramInt = f.a.a.b.b.a.bz(4, this.GEK);
      AppMethodBeat.o(189319);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        amo localamo = (amo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189319);
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
            localamo.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189319);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localamo.GEg = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189319);
          return 0;
        case 3: 
          localamo.dvq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189319);
          return 0;
        }
        localamo.GEK = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189319);
        return 0;
      }
      AppMethodBeat.o(189319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */