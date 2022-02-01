package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class aqz
  extends dyl
{
  public aqe RLM;
  public b SEd;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207964);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tab_type);
      if (this.SEd != null) {
        paramVarArgs.c(3, this.SEd);
      }
      if (this.RLM != null)
      {
        paramVarArgs.oE(4, this.RLM.computeSize());
        this.RLM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(207964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tab_type);
      paramInt = i;
      if (this.SEd != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SEd);
      }
      i = paramInt;
      if (this.RLM != null) {
        i = paramInt + g.a.a.a.oD(4, this.RLM.computeSize());
      }
      AppMethodBeat.o(207964);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(207964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqz localaqz = (aqz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207964);
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
            localaqz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(207964);
          return 0;
        case 2: 
          localaqz.tab_type = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(207964);
          return 0;
        case 3: 
          localaqz.SEd = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(207964);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aqe();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aqe)localObject2).parseFrom((byte[])localObject1);
          }
          localaqz.RLM = ((aqe)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(207964);
        return 0;
      }
      AppMethodBeat.o(207964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqz
 * JD-Core Version:    0.7.0.1
 */