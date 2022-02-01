package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dpw
  extends dyy
{
  public String OmF;
  public String RDD;
  public String TWK;
  public int TWL;
  public int fOY;
  public ctd fZQ;
  public int tqa;
  public String tqb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91637);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91637);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.tqa);
      if (this.tqb != null) {
        paramVarArgs.f(3, this.tqb);
      }
      if (this.TWK != null) {
        paramVarArgs.f(4, this.TWK);
      }
      if (this.RDD != null) {
        paramVarArgs.f(5, this.RDD);
      }
      paramVarArgs.aY(6, this.fOY);
      paramVarArgs.aY(7, this.TWL);
      if (this.fZQ != null)
      {
        paramVarArgs.oE(99, this.fZQ.computeSize());
        this.fZQ.writeFields(paramVarArgs);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91637);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.tqa);
      paramInt = i;
      if (this.tqb != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.tqb);
      }
      i = paramInt;
      if (this.TWK != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.TWK);
      }
      paramInt = i;
      if (this.RDD != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RDD);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.fOY) + g.a.a.b.b.a.bM(7, this.TWL);
      paramInt = i;
      if (this.fZQ != null) {
        paramInt = i + g.a.a.a.oD(99, this.fZQ.computeSize());
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91637);
      return i;
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
          AppMethodBeat.o(91637);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91637);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dpw localdpw = (dpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91637);
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
            localdpw.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        case 2: 
          localdpw.tqa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91637);
          return 0;
        case 3: 
          localdpw.tqb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 4: 
          localdpw.TWK = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 5: 
          localdpw.RDD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91637);
          return 0;
        case 6: 
          localdpw.fOY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91637);
          return 0;
        case 7: 
          localdpw.TWL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91637);
          return 0;
        case 99: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ctd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ctd)localObject2).parseFrom((byte[])localObject1);
            }
            localdpw.fZQ = ((ctd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91637);
          return 0;
        }
        localdpw.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91637);
        return 0;
      }
      AppMethodBeat.o(91637);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpw
 * JD-Core Version:    0.7.0.1
 */