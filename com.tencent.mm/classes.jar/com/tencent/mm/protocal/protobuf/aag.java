package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aag
  extends com.tencent.mm.bx.a
{
  public LinkedList<Integer> DbE;
  public cmf Dby;
  public int mAK;
  
  public aag()
  {
    AppMethodBeat.i(43092);
    this.DbE = new LinkedList();
    AppMethodBeat.o(43092);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43093);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dby == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(43093);
        throw paramVarArgs;
      }
      if (this.Dby != null)
      {
        paramVarArgs.kX(1, this.Dby.computeSize());
        this.Dby.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.mAK);
      paramVarArgs.f(3, 2, this.DbE);
      AppMethodBeat.o(43093);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dby == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = f.a.a.a.kW(1, this.Dby.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bA(2, this.mAK);
      int j = f.a.a.a.d(3, 2, this.DbE);
      AppMethodBeat.o(43093);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DbE.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Dby == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: UserName");
          AppMethodBeat.o(43093);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43093);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aag localaag = (aag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43093);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaag.Dby = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43093);
          return 0;
        case 2: 
          localaag.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(43093);
          return 0;
        }
        localaag.DbE = new f.a.a.a.a(((f.a.a.a.a)localObject1).KhF.fMu().wA, unknownTagHandler).KhF.fMs();
        AppMethodBeat.o(43093);
        return 0;
      }
      AppMethodBeat.o(43093);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aag
 * JD-Core Version:    0.7.0.1
 */