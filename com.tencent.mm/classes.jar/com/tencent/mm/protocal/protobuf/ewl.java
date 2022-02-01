package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ewl
  extends dyl
{
  public int CPw;
  public eae RQU;
  public String Uxs;
  public String Uxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(130921);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Uxs != null) {
        paramVarArgs.f(2, this.Uxs);
      }
      if (this.Uxt != null) {
        paramVarArgs.f(3, this.Uxt);
      }
      paramVarArgs.aY(4, this.CPw);
      if (this.RQU != null)
      {
        paramVarArgs.oE(5, this.RQU.computeSize());
        this.RQU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(130921);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Uxs != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Uxs);
      }
      i = paramInt;
      if (this.Uxt != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Uxt);
      }
      i += g.a.a.b.b.a.bM(4, this.CPw);
      paramInt = i;
      if (this.RQU != null) {
        paramInt = i + g.a.a.a.oD(5, this.RQU.computeSize());
      }
      AppMethodBeat.o(130921);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ewl localewl = (ewl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(130921);
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
            localewl.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(130921);
          return 0;
        case 2: 
          localewl.Uxs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 3: 
          localewl.Uxt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(130921);
          return 0;
        case 4: 
          localewl.CPw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(130921);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localewl.RQU = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(130921);
        return 0;
      }
      AppMethodBeat.o(130921);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewl
 * JD-Core Version:    0.7.0.1
 */