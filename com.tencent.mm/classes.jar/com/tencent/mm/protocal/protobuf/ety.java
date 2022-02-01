package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ety
  extends dyy
{
  public dwg UvI;
  public String UvN;
  public String UvO;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72591);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.UvN != null) {
        paramVarArgs.f(4, this.UvN);
      }
      if (this.UvO != null) {
        paramVarArgs.f(5, this.UvO);
      }
      if (this.UvI != null)
      {
        paramVarArgs.oE(6, this.UvI.computeSize());
        this.UvI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72591);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.UvN != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.UvN);
      }
      paramInt = i;
      if (this.UvO != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.UvO);
      }
      i = paramInt;
      if (this.UvI != null) {
        i = paramInt + g.a.a.a.oD(6, this.UvI.computeSize());
      }
      AppMethodBeat.o(72591);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ety localety = (ety)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72591);
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
            localety.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72591);
          return 0;
        case 2: 
          localety.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(72591);
          return 0;
        case 3: 
          localety.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 4: 
          localety.UvN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72591);
          return 0;
        case 5: 
          localety.UvO = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(72591);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dwg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dwg)localObject2).parseFrom((byte[])localObject1);
          }
          localety.UvI = ((dwg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72591);
        return 0;
      }
      AppMethodBeat.o(72591);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ety
 * JD-Core Version:    0.7.0.1
 */