package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class edw
  extends dyy
{
  public int Sda;
  public int rVx;
  public LinkedList<cxj> rVy;
  
  public edw()
  {
    AppMethodBeat.i(43129);
    this.rVy = new LinkedList();
    AppMethodBeat.o(43129);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43130);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(43130);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.rVx);
      paramVarArgs.e(3, 8, this.rVy);
      paramVarArgs.aY(4, this.Sda);
      AppMethodBeat.o(43130);
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
      int i = g.a.a.b.b.a.bM(2, this.rVx);
      int j = g.a.a.a.c(3, 8, this.rVy);
      int k = g.a.a.b.b.a.bM(4, this.Sda);
      AppMethodBeat.o(43130);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.rVy.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(43130);
          throw paramVarArgs;
        }
        AppMethodBeat.o(43130);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        edw localedw = (edw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43130);
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
            localedw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43130);
          return 0;
        case 2: 
          localedw.rVx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(43130);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cxj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cxj)localObject2).parseFrom((byte[])localObject1);
            }
            localedw.rVy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43130);
          return 0;
        }
        localedw.Sda = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(43130);
        return 0;
      }
      AppMethodBeat.o(43130);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edw
 * JD-Core Version:    0.7.0.1
 */