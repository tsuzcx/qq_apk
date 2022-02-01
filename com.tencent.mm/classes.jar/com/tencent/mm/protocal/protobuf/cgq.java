package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgq
  extends dyl
{
  public int TnD;
  public LinkedList<fmg> TnE;
  public String appid;
  
  public cgq()
  {
    AppMethodBeat.i(123582);
    this.TnE = new LinkedList();
    AppMethodBeat.o(123582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123583);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      paramVarArgs.aY(3, this.TnD);
      paramVarArgs.e(4, 8, this.TnE);
      AppMethodBeat.o(123583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.appid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.appid);
      }
      paramInt = g.a.a.b.b.a.bM(3, this.TnD);
      int j = g.a.a.a.c(4, 8, this.TnE);
      AppMethodBeat.o(123583);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TnE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123583);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cgq localcgq = (cgq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123583);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localcgq.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123583);
          return 0;
        case 2: 
          localcgq.appid = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(123583);
          return 0;
        case 3: 
          localcgq.TnD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(123583);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fmg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fmg)localObject2).parseFrom((byte[])localObject1);
          }
          localcgq.TnE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123583);
        return 0;
      }
      AppMethodBeat.o(123583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgq
 * JD-Core Version:    0.7.0.1
 */