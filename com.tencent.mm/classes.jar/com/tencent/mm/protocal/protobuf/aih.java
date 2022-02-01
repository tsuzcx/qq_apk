package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class aih
  extends dyy
{
  public int HlE;
  public long HlH;
  public int HmZ;
  public int Hna;
  public eae Hnc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127171);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127171);
        throw paramVarArgs;
      }
      if (this.Hnc == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(127171);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.HlE);
      paramVarArgs.aY(3, this.HmZ);
      paramVarArgs.aY(4, this.Hna);
      if (this.Hnc != null)
      {
        paramVarArgs.oE(5, this.Hnc.computeSize());
        this.Hnc.writeFields(paramVarArgs);
      }
      paramVarArgs.bm(6, this.HlH);
      AppMethodBeat.o(127171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.HlE) + g.a.a.b.b.a.bM(3, this.HmZ) + g.a.a.b.b.a.bM(4, this.Hna);
      paramInt = i;
      if (this.Hnc != null) {
        paramInt = i + g.a.a.a.oD(5, this.Hnc.computeSize());
      }
      i = g.a.a.b.b.a.p(6, this.HlH);
      AppMethodBeat.o(127171);
      return paramInt + i;
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
          AppMethodBeat.o(127171);
          throw paramVarArgs;
        }
        if (this.Hnc == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(127171);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127171);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aih localaih = (aih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127171);
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
            localaih.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127171);
          return 0;
        case 2: 
          localaih.HlE = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127171);
          return 0;
        case 3: 
          localaih.HmZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127171);
          return 0;
        case 4: 
          localaih.Hna = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(127171);
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
            localaih.Hnc = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(127171);
          return 0;
        }
        localaih.HlH = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(127171);
        return 0;
      }
      AppMethodBeat.o(127171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aih
 * JD-Core Version:    0.7.0.1
 */