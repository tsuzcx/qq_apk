package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class sx
  extends dyy
{
  public String ImI;
  public String InU;
  public String InV;
  public String InW;
  public coj Scd;
  public String fHb;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257535);
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
      if (this.Scd != null)
      {
        paramVarArgs.oE(4, this.Scd.computeSize());
        this.Scd.writeFields(paramVarArgs);
      }
      if (this.InU != null) {
        paramVarArgs.f(5, this.InU);
      }
      if (this.fHb != null) {
        paramVarArgs.f(6, this.fHb);
      }
      if (this.InV != null) {
        paramVarArgs.f(7, this.InV);
      }
      if (this.ImI != null) {
        paramVarArgs.f(8, this.ImI);
      }
      if (this.InW != null) {
        paramVarArgs.f(9, this.InW);
      }
      AppMethodBeat.o(257535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.Scd != null) {
        i = paramInt + g.a.a.a.oD(4, this.Scd.computeSize());
      }
      paramInt = i;
      if (this.InU != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.InU);
      }
      i = paramInt;
      if (this.fHb != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.fHb);
      }
      paramInt = i;
      if (this.InV != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.InV);
      }
      i = paramInt;
      if (this.ImI != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.ImI);
      }
      paramInt = i;
      if (this.InW != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.InW);
      }
      AppMethodBeat.o(257535);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(257535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257535);
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
            localsx.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257535);
          return 0;
        case 2: 
          localsx.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(257535);
          return 0;
        case 3: 
          localsx.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257535);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new coj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((coj)localObject2).parseFrom((byte[])localObject1);
            }
            localsx.Scd = ((coj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257535);
          return 0;
        case 5: 
          localsx.InU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257535);
          return 0;
        case 6: 
          localsx.fHb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257535);
          return 0;
        case 7: 
          localsx.InV = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257535);
          return 0;
        case 8: 
          localsx.ImI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(257535);
          return 0;
        }
        localsx.InW = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(257535);
        return 0;
      }
      AppMethodBeat.o(257535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */