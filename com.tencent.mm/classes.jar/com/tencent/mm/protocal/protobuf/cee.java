package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cee
  extends dyy
{
  public int TlK;
  public String TlL;
  public int TlM;
  public String TlN;
  public int TlO;
  public LinkedList<eaf> TlP;
  public String TlQ;
  public int TlR;
  public String TlS;
  public int TlT;
  public eae TlU;
  
  public cee()
  {
    AppMethodBeat.i(152605);
    this.TlP = new LinkedList();
    AppMethodBeat.o(152605);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152606);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(152606);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TlK);
      if (this.TlL != null) {
        paramVarArgs.f(3, this.TlL);
      }
      paramVarArgs.aY(4, this.TlM);
      if (this.TlN != null) {
        paramVarArgs.f(5, this.TlN);
      }
      paramVarArgs.aY(6, this.TlO);
      paramVarArgs.e(7, 8, this.TlP);
      if (this.TlQ != null) {
        paramVarArgs.f(8, this.TlQ);
      }
      paramVarArgs.aY(9, this.TlR);
      if (this.TlS != null) {
        paramVarArgs.f(10, this.TlS);
      }
      paramVarArgs.aY(11, this.TlT);
      if (this.TlU != null)
      {
        paramVarArgs.oE(12, this.TlU.computeSize());
        this.TlU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152606);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1060;
      }
    }
    label1060:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TlK);
      paramInt = i;
      if (this.TlL != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.TlL);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.TlM);
      paramInt = i;
      if (this.TlN != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.TlN);
      }
      i = paramInt + g.a.a.b.b.a.bM(6, this.TlO) + g.a.a.a.c(7, 8, this.TlP);
      paramInt = i;
      if (this.TlQ != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TlQ);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.TlR);
      paramInt = i;
      if (this.TlS != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.TlS);
      }
      i = paramInt + g.a.a.b.b.a.bM(11, this.TlT);
      paramInt = i;
      if (this.TlU != null) {
        paramInt = i + g.a.a.a.oD(12, this.TlU.computeSize());
      }
      AppMethodBeat.o(152606);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TlP.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(152606);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cee localcee = (cee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152606);
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
            localcee.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 2: 
          localcee.TlK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152606);
          return 0;
        case 3: 
          localcee.TlL = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 4: 
          localcee.TlM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152606);
          return 0;
        case 5: 
          localcee.TlN = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 6: 
          localcee.TlO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152606);
          return 0;
        case 7: 
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
            localcee.TlP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152606);
          return 0;
        case 8: 
          localcee.TlQ = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 9: 
          localcee.TlR = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152606);
          return 0;
        case 10: 
          localcee.TlS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(152606);
          return 0;
        case 11: 
          localcee.TlT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(152606);
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
          localcee.TlU = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(152606);
        return 0;
      }
      AppMethodBeat.o(152606);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cee
 * JD-Core Version:    0.7.0.1
 */