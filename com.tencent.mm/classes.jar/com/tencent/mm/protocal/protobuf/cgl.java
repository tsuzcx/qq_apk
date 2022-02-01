package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cgl
  extends dyy
{
  public int TnA;
  public int TnB;
  public LinkedList<fls> Tny;
  public String Tnz;
  
  public cgl()
  {
    AppMethodBeat.i(270581);
    this.Tny = new LinkedList();
    AppMethodBeat.o(270581);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(270583);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(270583);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Tny);
      if (this.Tnz != null) {
        paramVarArgs.f(3, this.Tnz);
      }
      paramVarArgs.aY(4, this.TnA);
      paramVarArgs.aY(5, this.TnB);
      AppMethodBeat.o(270583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.Tny);
      paramInt = i;
      if (this.Tnz != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Tnz);
      }
      i = g.a.a.b.b.a.bM(4, this.TnA);
      int j = g.a.a.b.b.a.bM(5, this.TnB);
      AppMethodBeat.o(270583);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Tny.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(270583);
          throw paramVarArgs;
        }
        AppMethodBeat.o(270583);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgl localcgl = (cgl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(270583);
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
            localcgl.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(270583);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fls();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fls)localObject2).parseFrom((byte[])localObject1);
            }
            localcgl.Tny.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(270583);
          return 0;
        case 3: 
          localcgl.Tnz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(270583);
          return 0;
        case 4: 
          localcgl.TnA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(270583);
          return 0;
        }
        localcgl.TnB = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(270583);
        return 0;
      }
      AppMethodBeat.o(270583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgl
 * JD-Core Version:    0.7.0.1
 */