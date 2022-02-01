package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bor
  extends dyy
{
  public int RPJ;
  public LinkedList<com.tencent.mm.cd.b> SZK;
  public LinkedList<Integer> SZW;
  public LinkedList<boq> SZX;
  public LinkedList<bol> SZY;
  
  public bor()
  {
    AppMethodBeat.i(152550);
    this.SZW = new LinkedList();
    this.SZX = new LinkedList();
    this.SZY = new LinkedList();
    this.SZK = new LinkedList();
    AppMethodBeat.o(152550);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152551);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RPJ);
      paramVarArgs.e(3, 2, this.SZW);
      paramVarArgs.e(4, 8, this.SZX);
      paramVarArgs.e(5, 8, this.SZY);
      paramVarArgs.e(7, 6, this.SZK);
      AppMethodBeat.o(152551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label751;
      }
    }
    label751:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.bM(2, this.RPJ);
      int j = g.a.a.a.c(3, 2, this.SZW);
      int k = g.a.a.a.c(4, 8, this.SZX);
      int m = g.a.a.a.c(5, 8, this.SZY);
      int n = g.a.a.a.c(7, 6, this.SZK);
      AppMethodBeat.o(152551);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SZW.clear();
        this.SZX.clear();
        this.SZY.clear();
        this.SZK.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bor localbor = (bor)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 6: 
        default: 
          AppMethodBeat.o(152551);
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
            localbor.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 2: 
          localbor.RPJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152551);
          return 0;
        case 3: 
          localbor.SZW.add(Integer.valueOf(((g.a.a.a.a)localObject1).abFh.AK()));
          AppMethodBeat.o(152551);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new boq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((boq)localObject2).parseFrom((byte[])localObject1);
            }
            localbor.SZX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bol)localObject2).parseFrom((byte[])localObject1);
            }
            localbor.SZY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152551);
          return 0;
        }
        localbor.SZK.add(((g.a.a.a.a)localObject1).abFh.iUw());
        AppMethodBeat.o(152551);
        return 0;
      }
      AppMethodBeat.o(152551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bor
 * JD-Core Version:    0.7.0.1
 */