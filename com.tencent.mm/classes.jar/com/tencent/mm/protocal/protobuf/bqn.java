package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bqn
  extends dyy
{
  public LinkedList<ckq> TbD;
  public int vht;
  public String vhu;
  
  public bqn()
  {
    AppMethodBeat.i(82404);
    this.TbD = new LinkedList();
    AppMethodBeat.o(82404);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82405);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82405);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.vht);
      if (this.vhu != null) {
        paramVarArgs.f(3, this.vhu);
      }
      paramVarArgs.e(4, 8, this.TbD);
      AppMethodBeat.o(82405);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.vht);
      paramInt = i;
      if (this.vhu != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.vhu);
      }
      i = g.a.a.a.c(4, 8, this.TbD);
      AppMethodBeat.o(82405);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TbD.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82405);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82405);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bqn localbqn = (bqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82405);
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
            localbqn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82405);
          return 0;
        case 2: 
          localbqn.vht = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(82405);
          return 0;
        case 3: 
          localbqn.vhu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(82405);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ckq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ckq)localObject2).parseFrom((byte[])localObject1);
          }
          localbqn.TbD.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82405);
        return 0;
      }
      AppMethodBeat.o(82405);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqn
 * JD-Core Version:    0.7.0.1
 */