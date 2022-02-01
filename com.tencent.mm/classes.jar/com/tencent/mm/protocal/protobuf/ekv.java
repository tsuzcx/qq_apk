package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ekv
  extends dyy
{
  public int Saq;
  public eae SfI;
  public abv SfL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125815);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.SfL == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.SfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(125815);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.SfL != null)
      {
        paramVarArgs.oE(2, this.SfL.computeSize());
        this.SfL.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.Saq);
      if (this.SfI != null)
      {
        paramVarArgs.oE(4, this.SfI.computeSize());
        this.SfI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125815);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label740;
      }
    }
    label740:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SfL != null) {
        i = paramInt + g.a.a.a.oD(2, this.SfL.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.Saq);
      paramInt = i;
      if (this.SfI != null) {
        paramInt = i + g.a.a.a.oD(4, this.SfI.computeSize());
      }
      AppMethodBeat.o(125815);
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
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        if (this.SfL == null)
        {
          paramVarArgs = new b("Not all required fields were included: CmdList");
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        if (this.SfI == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(125815);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125815);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekv localekv = (ekv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125815);
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
            localekv.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125815);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new abv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((abv)localObject2).parseFrom((byte[])localObject1);
            }
            localekv.SfL = ((abv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(125815);
          return 0;
        case 3: 
          localekv.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(125815);
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
          localekv.SfI = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(125815);
        return 0;
      }
      AppMethodBeat.o(125815);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekv
 * JD-Core Version:    0.7.0.1
 */