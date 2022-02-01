package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class efy
  extends dyl
{
  public int TbU;
  public nw TbW;
  public int mask;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124551);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TbW == null)
      {
        paramVarArgs = new b("Not all required fields were included: attr");
        AppMethodBeat.o(124551);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TbU);
      paramVarArgs.aY(3, this.mask);
      if (this.TbW != null)
      {
        paramVarArgs.oE(4, this.TbW.computeSize());
        this.TbW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124551);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label554;
      }
    }
    label554:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TbU) + g.a.a.b.b.a.bM(3, this.mask);
      paramInt = i;
      if (this.TbW != null) {
        paramInt = i + g.a.a.a.oD(4, this.TbW.computeSize());
      }
      AppMethodBeat.o(124551);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TbW == null)
        {
          paramVarArgs = new b("Not all required fields were included: attr");
          AppMethodBeat.o(124551);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        efy localefy = (efy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124551);
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
            localefy.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124551);
          return 0;
        case 2: 
          localefy.TbU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124551);
          return 0;
        case 3: 
          localefy.mask = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124551);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new nw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((nw)localObject2).parseFrom((byte[])localObject1);
          }
          localefy.TbW = ((nw)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124551);
        return 0;
      }
      AppMethodBeat.o(124551);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.efy
 * JD-Core Version:    0.7.0.1
 */