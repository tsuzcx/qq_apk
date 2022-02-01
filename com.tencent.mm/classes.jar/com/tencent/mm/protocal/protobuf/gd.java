package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gd
  extends dyy
{
  public com.tencent.mm.cd.b RLd;
  public int RLj;
  public int RLk;
  public gi RLl;
  public ge RLm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32119);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32119);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLj);
      paramVarArgs.aY(3, this.RLk);
      if (this.RLd != null) {
        paramVarArgs.c(4, this.RLd);
      }
      if (this.RLl != null)
      {
        paramVarArgs.oE(5, this.RLl.computeSize());
        this.RLl.writeFields(paramVarArgs);
      }
      if (this.RLm != null)
      {
        paramVarArgs.oE(6, this.RLm.computeSize());
        this.RLm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32119);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLj) + g.a.a.b.b.a.bM(3, this.RLk);
      paramInt = i;
      if (this.RLd != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.RLd);
      }
      i = paramInt;
      if (this.RLl != null) {
        i = paramInt + g.a.a.a.oD(5, this.RLl.computeSize());
      }
      paramInt = i;
      if (this.RLm != null) {
        paramInt = i + g.a.a.a.oD(6, this.RLm.computeSize());
      }
      AppMethodBeat.o(32119);
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
          paramVarArgs = new g.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32119);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        gd localgd = (gd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32119);
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
            localgd.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        case 2: 
          localgd.RLj = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32119);
          return 0;
        case 3: 
          localgd.RLk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32119);
          return 0;
        case 4: 
          localgd.RLd = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(32119);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gi)localObject2).parseFrom((byte[])localObject1);
            }
            localgd.RLl = ((gi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32119);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ge();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ge)localObject2).parseFrom((byte[])localObject1);
          }
          localgd.RLm = ((ge)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32119);
        return 0;
      }
      AppMethodBeat.o(32119);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gd
 * JD-Core Version:    0.7.0.1
 */