package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dnr
  extends dyl
{
  public int DgI;
  public String OmF;
  public int TUS;
  public int TUT;
  public ip TUU;
  public int TUV;
  public String TUW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TUS);
      paramVarArgs.aY(3, this.TUT);
      if (this.TUU != null)
      {
        paramVarArgs.oE(4, this.TUU.computeSize());
        this.TUU.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(5, this.DgI);
      paramVarArgs.aY(6, this.TUV);
      if (this.TUW != null) {
        paramVarArgs.f(7, this.TUW);
      }
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label746;
      }
    }
    label746:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TUS) + g.a.a.b.b.a.bM(3, this.TUT);
      paramInt = i;
      if (this.TUU != null) {
        paramInt = i + g.a.a.a.oD(4, this.TUU.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.DgI) + g.a.a.b.b.a.bM(6, this.TUV);
      paramInt = i;
      if (this.TUW != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TUW);
      }
      i = paramInt;
      if (this.OmF != null) {
        i = paramInt + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91624);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dnr localdnr = (dnr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91624);
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
            localdnr.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 2: 
          localdnr.TUS = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91624);
          return 0;
        case 3: 
          localdnr.TUT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91624);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ip();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ip)localObject2).parseFrom((byte[])localObject1);
            }
            localdnr.TUU = ((ip)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91624);
          return 0;
        case 5: 
          localdnr.DgI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91624);
          return 0;
        case 6: 
          localdnr.TUV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91624);
          return 0;
        case 7: 
          localdnr.TUW = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91624);
          return 0;
        }
        localdnr.OmF = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(91624);
        return 0;
      }
      AppMethodBeat.o(91624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnr
 * JD-Core Version:    0.7.0.1
 */