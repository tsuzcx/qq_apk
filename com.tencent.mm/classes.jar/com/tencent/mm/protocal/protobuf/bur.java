package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bur
  extends dyy
{
  public LinkedList<ev> RLp;
  public int TeL;
  public int TeM;
  public LinkedList<Integer> TeN;
  public LinkedList<alo> TeO;
  public int TeQ;
  
  public bur()
  {
    AppMethodBeat.i(122505);
    this.TeN = new LinkedList();
    this.TeO = new LinkedList();
    this.RLp = new LinkedList();
    AppMethodBeat.o(122505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122506);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(122506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TeL);
      paramVarArgs.aY(3, this.TeM);
      paramVarArgs.e(4, 2, this.TeN);
      paramVarArgs.e(5, 8, this.TeO);
      paramVarArgs.aY(6, this.TeQ);
      paramVarArgs.e(7, 8, this.RLp);
      AppMethodBeat.o(122506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label779;
      }
    }
    label779:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.TeL);
      int j = g.a.a.b.b.a.bM(3, this.TeM);
      int k = g.a.a.a.c(4, 2, this.TeN);
      int m = g.a.a.a.c(5, 8, this.TeO);
      int n = g.a.a.b.b.a.bM(6, this.TeQ);
      int i1 = g.a.a.a.c(7, 8, this.RLp);
      AppMethodBeat.o(122506);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TeN.clear();
        this.TeO.clear();
        this.RLp.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(122506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bur localbur = (bur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122506);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localbur.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 2: 
          localbur.TeL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(122506);
          return 0;
        case 3: 
          localbur.TeM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(122506);
          return 0;
        case 4: 
          localbur.TeN.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(122506);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alo)localObject2).parseFrom((byte[])localObject1);
            }
            localbur.TeO.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(122506);
          return 0;
        case 6: 
          localbur.TeQ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(122506);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ev();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ev)localObject2).parseFrom((byte[])localObject1);
          }
          localbur.RLp.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(122506);
        return 0;
      }
      AppMethodBeat.o(122506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bur
 * JD-Core Version:    0.7.0.1
 */