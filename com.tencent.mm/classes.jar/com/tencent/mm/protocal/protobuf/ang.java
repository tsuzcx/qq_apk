package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ang
  extends dyy
{
  public String HlB;
  public String RIi;
  public LinkedList<anh> RIk;
  public int iWB;
  
  public ang()
  {
    AppMethodBeat.i(32208);
    this.RIk = new LinkedList();
    AppMethodBeat.o(32208);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32209);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32209);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HlB != null) {
        paramVarArgs.f(2, this.HlB);
      }
      paramVarArgs.aY(3, this.iWB);
      paramVarArgs.e(4, 8, this.RIk);
      if (this.RIi != null) {
        paramVarArgs.f(5, this.RIi);
      }
      AppMethodBeat.o(32209);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label629;
      }
    }
    label629:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HlB != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.HlB);
      }
      i = i + g.a.a.b.b.a.bM(3, this.iWB) + g.a.a.a.c(4, 8, this.RIk);
      paramInt = i;
      if (this.RIi != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RIi);
      }
      AppMethodBeat.o(32209);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RIk.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32209);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32209);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ang localang = (ang)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32209);
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
            localang.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        case 2: 
          localang.HlB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32209);
          return 0;
        case 3: 
          localang.iWB = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32209);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anh)localObject2).parseFrom((byte[])localObject1);
            }
            localang.RIk.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32209);
          return 0;
        }
        localang.RIi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32209);
        return 0;
      }
      AppMethodBeat.o(32209);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ang
 * JD-Core Version:    0.7.0.1
 */