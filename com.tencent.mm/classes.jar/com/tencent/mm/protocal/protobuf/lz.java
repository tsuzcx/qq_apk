package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class lz
  extends dyl
{
  public eae ROR;
  public String RQS;
  public String RQT;
  public String RRg;
  public int RRs;
  public String RRt;
  public String RRu;
  public String RRv;
  public int RRw;
  public eaf RRx;
  public eae RRy;
  public int RRz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RRs);
      if (this.RRg != null) {
        paramVarArgs.f(3, this.RRg);
      }
      if (this.RRt != null) {
        paramVarArgs.f(4, this.RRt);
      }
      if (this.RRu != null) {
        paramVarArgs.f(5, this.RRu);
      }
      if (this.RRv != null) {
        paramVarArgs.f(6, this.RRv);
      }
      paramVarArgs.aY(7, this.RRw);
      if (this.RRx != null)
      {
        paramVarArgs.oE(8, this.RRx.computeSize());
        this.RRx.writeFields(paramVarArgs);
      }
      if (this.RRy != null)
      {
        paramVarArgs.oE(9, this.RRy.computeSize());
        this.RRy.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(10, this.RRz);
      if (this.RQS != null) {
        paramVarArgs.f(11, this.RQS);
      }
      if (this.RQT != null) {
        paramVarArgs.f(12, this.RQT);
      }
      if (this.ROR != null)
      {
        paramVarArgs.oE(13, this.ROR.computeSize());
        this.ROR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1194;
      }
    }
    label1194:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RRs);
      paramInt = i;
      if (this.RRg != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.RRg);
      }
      i = paramInt;
      if (this.RRt != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.RRt);
      }
      paramInt = i;
      if (this.RRu != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RRu);
      }
      i = paramInt;
      if (this.RRv != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RRv);
      }
      i += g.a.a.b.b.a.bM(7, this.RRw);
      paramInt = i;
      if (this.RRx != null) {
        paramInt = i + g.a.a.a.oD(8, this.RRx.computeSize());
      }
      i = paramInt;
      if (this.RRy != null) {
        i = paramInt + g.a.a.a.oD(9, this.RRy.computeSize());
      }
      i += g.a.a.b.b.a.bM(10, this.RRz);
      paramInt = i;
      if (this.RQS != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RQS);
      }
      i = paramInt;
      if (this.RQT != null) {
        i = paramInt + g.a.a.b.b.a.g(12, this.RQT);
      }
      paramInt = i;
      if (this.ROR != null) {
        paramInt = i + g.a.a.a.oD(13, this.ROR.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        lz locallz = (lz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            locallz.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          locallz.RRs = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          locallz.RRg = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          locallz.RRt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          locallz.RRu = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          locallz.RRv = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          locallz.RRw = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaf)localObject2).de((byte[])localObject1);
            }
            locallz.RRx = ((eaf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
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
            locallz.RRy = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          locallz.RRz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          locallz.RQS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          locallz.RQT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(155396);
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
          locallz.ROR = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lz
 * JD-Core Version:    0.7.0.1
 */