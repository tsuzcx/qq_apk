package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fnm
  extends dyl
{
  public LinkedList<fnr> ULS;
  public dwx ULT;
  
  public fnm()
  {
    AppMethodBeat.i(123689);
    this.ULS = new LinkedList();
    AppMethodBeat.o(123689);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123690);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.ULS);
      if (this.ULT != null)
      {
        paramVarArgs.oE(3, this.ULT.computeSize());
        this.ULT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123690);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label540;
      }
    }
    label540:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.ULS);
      paramInt = i;
      if (this.ULT != null) {
        paramInt = i + g.a.a.a.oD(3, this.ULT.computeSize());
      }
      AppMethodBeat.o(123690);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ULS.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123690);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fnm localfnm = (fnm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123690);
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
            localfnm.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123690);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fnr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fnr)localObject2).parseFrom((byte[])localObject1);
            }
            localfnm.ULS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123690);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwx)localObject2).parseFrom((byte[])localObject1);
          }
          localfnm.ULT = ((dwx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123690);
        return 0;
      }
      AppMethodBeat.o(123690);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnm
 * JD-Core Version:    0.7.0.1
 */