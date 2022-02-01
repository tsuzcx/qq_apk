package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eki
  extends dyy
{
  public int UlV;
  public LinkedList<Integer> UlX;
  public int UlY;
  public int UlZ;
  public LinkedList<elo> Uma;
  
  public eki()
  {
    AppMethodBeat.i(125800);
    this.UlX = new LinkedList();
    this.Uma = new LinkedList();
    AppMethodBeat.o(125800);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125801);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125801);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UlV);
      paramVarArgs.f(3, 2, this.UlX);
      paramVarArgs.aY(4, this.UlY);
      paramVarArgs.aY(5, this.UlZ);
      paramVarArgs.e(6, 8, this.Uma);
      AppMethodBeat.o(125801);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label669;
      }
    }
    label669:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.UlV);
      int j = g.a.a.a.d(3, 2, this.UlX);
      int k = g.a.a.b.b.a.bM(4, this.UlY);
      int m = g.a.a.b.b.a.bM(5, this.UlZ);
      int n = g.a.a.a.c(6, 8, this.Uma);
      AppMethodBeat.o(125801);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UlX.clear();
        this.Uma.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125801);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eki localeki = (eki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125801);
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
            localeki.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125801);
          return 0;
        case 2: 
          localeki.UlV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125801);
          return 0;
        case 3: 
          localeki.UlX = new g.a.a.a.a(((g.a.a.a.a)localObject1).abFh.iUw().UH, unknownTagHandler).abFh.iUu();
          AppMethodBeat.o(125801);
          return 0;
        case 4: 
          localeki.UlY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125801);
          return 0;
        case 5: 
          localeki.UlZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125801);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new elo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((elo)localObject2).parseFrom((byte[])localObject1);
          }
          localeki.Uma.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125801);
        return 0;
      }
      AppMethodBeat.o(125801);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eki
 * JD-Core Version:    0.7.0.1
 */