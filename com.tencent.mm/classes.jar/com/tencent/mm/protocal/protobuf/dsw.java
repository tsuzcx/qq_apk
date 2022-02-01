package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsw
  extends dyl
{
  public eae RMd;
  public eae TZm;
  public int qq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32398);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.qq);
      if (this.RMd != null)
      {
        paramVarArgs.oE(3, this.RMd.computeSize());
        this.RMd.writeFields(paramVarArgs);
      }
      if (this.TZm != null)
      {
        paramVarArgs.oE(4, this.TZm.computeSize());
        this.TZm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32398);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.qq);
      paramInt = i;
      if (this.RMd != null) {
        paramInt = i + g.a.a.a.oD(3, this.RMd.computeSize());
      }
      i = paramInt;
      if (this.TZm != null) {
        i = paramInt + g.a.a.a.oD(4, this.TZm.computeSize());
      }
      AppMethodBeat.o(32398);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32398);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dsw localdsw = (dsw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32398);
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
            localdsw.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32398);
          return 0;
        case 2: 
          localdsw.qq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32398);
          return 0;
        case 3: 
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
            localdsw.RMd = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32398);
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
          localdsw.TZm = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32398);
        return 0;
      }
      AppMethodBeat.o(32398);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsw
 * JD-Core Version:    0.7.0.1
 */