package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ene
  extends dyy
{
  public eae UpS;
  public int UpT;
  public LinkedList<enc> UpU;
  public int UpV;
  
  public ene()
  {
    AppMethodBeat.i(118436);
    this.UpU = new LinkedList();
    AppMethodBeat.o(118436);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118437);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(118437);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.UpT);
      paramVarArgs.e(3, 8, this.UpU);
      paramVarArgs.aY(4, this.UpV);
      if (this.UpS != null)
      {
        paramVarArgs.oE(5, this.UpS.computeSize());
        this.UpS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(118437);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label672;
      }
    }
    label672:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.UpT) + g.a.a.a.c(3, 8, this.UpU) + g.a.a.b.b.a.bM(4, this.UpV);
      paramInt = i;
      if (this.UpS != null) {
        paramInt = i + g.a.a.a.oD(5, this.UpS.computeSize());
      }
      AppMethodBeat.o(118437);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.UpU.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(118437);
          throw paramVarArgs;
        }
        AppMethodBeat.o(118437);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ene localene = (ene)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118437);
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
            localene.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118437);
          return 0;
        case 2: 
          localene.UpT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118437);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enc)localObject2).parseFrom((byte[])localObject1);
            }
            localene.UpU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(118437);
          return 0;
        case 4: 
          localene.UpV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(118437);
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
          localene.UpS = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(118437);
        return 0;
      }
      AppMethodBeat.o(118437);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ene
 * JD-Core Version:    0.7.0.1
 */