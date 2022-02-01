package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ano
  extends cvw
{
  public alw GEg;
  public long GFv;
  public int dGO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189333);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.GFv);
      paramVarArgs.aS(3, this.dGO);
      if (this.GEg != null)
      {
        paramVarArgs.lJ(4, this.GEg.computeSize());
        this.GEg.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(189333);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GFv) + f.a.a.b.b.a.bz(3, this.dGO);
      paramInt = i;
      if (this.GEg != null) {
        paramInt = i + f.a.a.a.lI(4, this.GEg.computeSize());
      }
      AppMethodBeat.o(189333);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189333);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ano localano = (ano)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189333);
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
            localano.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189333);
          return 0;
        case 2: 
          localano.GFv = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(189333);
          return 0;
        case 3: 
          localano.dGO = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189333);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localano.GEg = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(189333);
        return 0;
      }
      AppMethodBeat.o(189333);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */