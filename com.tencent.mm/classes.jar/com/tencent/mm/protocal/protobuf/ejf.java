package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ejf
  extends dyy
{
  public ekq TZY;
  public eae Uld;
  public ejd Ulg;
  public eae Ulh;
  public dq Uli;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125767);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125767);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ulg != null)
      {
        paramVarArgs.oE(2, this.Ulg.computeSize());
        this.Ulg.writeFields(paramVarArgs);
      }
      if (this.Uld != null)
      {
        paramVarArgs.oE(3, this.Uld.computeSize());
        this.Uld.writeFields(paramVarArgs);
      }
      if (this.TZY != null)
      {
        paramVarArgs.oE(4, this.TZY.computeSize());
        this.TZY.writeFields(paramVarArgs);
      }
      if (this.Ulh != null)
      {
        paramVarArgs.oE(5, this.Ulh.computeSize());
        this.Ulh.writeFields(paramVarArgs);
      }
      if (this.Uli != null)
      {
        paramVarArgs.oE(6, this.Uli.computeSize());
        this.Uli.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125767);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label998;
      }
    }
    label998:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ulg != null) {
        paramInt = i + g.a.a.a.oD(2, this.Ulg.computeSize());
      }
      i = paramInt;
      if (this.Uld != null) {
        i = paramInt + g.a.a.a.oD(3, this.Uld.computeSize());
      }
      paramInt = i;
      if (this.TZY != null) {
        paramInt = i + g.a.a.a.oD(4, this.TZY.computeSize());
      }
      i = paramInt;
      if (this.Ulh != null) {
        i = paramInt + g.a.a.a.oD(5, this.Ulh.computeSize());
      }
      paramInt = i;
      if (this.Uli != null) {
        paramInt = i + g.a.a.a.oD(6, this.Uli.computeSize());
      }
      AppMethodBeat.o(125767);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125767);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125767);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ejf localejf = (ejf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125767);
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
            localejf.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125767);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ejd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ejd)localObject2).parseFrom((byte[])localObject1);
            }
            localejf.Ulg = ((ejd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125767);
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
            localejf.Uld = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125767);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ekq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ekq)localObject2).parseFrom((byte[])localObject1);
            }
            localejf.TZY = ((ekq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125767);
          return 0;
        case 5: 
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
            localejf.Ulh = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125767);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dq)localObject2).parseFrom((byte[])localObject1);
          }
          localejf.Uli = ((dq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125767);
        return 0;
      }
      AppMethodBeat.o(125767);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejf
 * JD-Core Version:    0.7.0.1
 */