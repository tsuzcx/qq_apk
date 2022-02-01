package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bul
  extends dyy
{
  public int TeA;
  public long TeB;
  public LinkedList<dkw> Tez;
  
  public bul()
  {
    AppMethodBeat.i(200233);
    this.Tez = new LinkedList();
    AppMethodBeat.o(200233);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200238);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(200238);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tez);
      paramVarArgs.aY(3, this.TeA);
      paramVarArgs.bm(4, this.TeB);
      AppMethodBeat.o(200238);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label546;
      }
    }
    label546:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Tez);
      int j = g.a.a.b.b.a.bM(3, this.TeA);
      int k = g.a.a.b.b.a.p(4, this.TeB);
      AppMethodBeat.o(200238);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tez.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(200238);
          throw paramVarArgs;
        }
        AppMethodBeat.o(200238);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bul localbul = (bul)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200238);
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
            localbul.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200238);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dkw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dkw)localObject2).parseFrom((byte[])localObject1);
            }
            localbul.Tez.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(200238);
          return 0;
        case 3: 
          localbul.TeA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(200238);
          return 0;
        }
        localbul.TeB = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(200238);
        return 0;
      }
      AppMethodBeat.o(200238);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bul
 * JD-Core Version:    0.7.0.1
 */