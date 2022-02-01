package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class bwy
  extends dyy
{
  public int Saq;
  public String Sas;
  public eae TgD;
  public int TgI;
  public LinkedList<eaf> TgJ;
  public int TgK;
  public LinkedList<cqf> TgL;
  public String TgM;
  public int TgN;
  public int TgO;
  public cqg TgP;
  public String TgQ;
  public String mVA;
  
  public bwy()
  {
    AppMethodBeat.i(32251);
    this.TgJ = new LinkedList();
    this.TgL = new LinkedList();
    AppMethodBeat.o(32251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32252);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.TgD == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(32252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.TgD != null)
      {
        paramVarArgs.oE(2, this.TgD.computeSize());
        this.TgD.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.TgI);
      paramVarArgs.e(4, 8, this.TgJ);
      paramVarArgs.aY(5, this.TgK);
      paramVarArgs.e(6, 8, this.TgL);
      paramVarArgs.aY(7, this.Saq);
      if (this.TgM != null) {
        paramVarArgs.f(8, this.TgM);
      }
      if (this.Sas != null) {
        paramVarArgs.f(9, this.Sas);
      }
      paramVarArgs.aY(10, this.TgN);
      if (this.mVA != null) {
        paramVarArgs.f(11, this.mVA);
      }
      paramVarArgs.aY(12, this.TgO);
      if (this.TgP != null)
      {
        paramVarArgs.oE(13, this.TgP.computeSize());
        this.TgP.writeFields(paramVarArgs);
      }
      if (this.TgQ != null) {
        paramVarArgs.f(14, this.TgQ);
      }
      AppMethodBeat.o(32252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1380;
      }
    }
    label1380:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TgD != null) {
        i = paramInt + g.a.a.a.oD(2, this.TgD.computeSize());
      }
      i = i + g.a.a.b.b.a.bM(3, this.TgI) + g.a.a.a.c(4, 8, this.TgJ) + g.a.a.b.b.a.bM(5, this.TgK) + g.a.a.a.c(6, 8, this.TgL) + g.a.a.b.b.a.bM(7, this.Saq);
      paramInt = i;
      if (this.TgM != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TgM);
      }
      i = paramInt;
      if (this.Sas != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.Sas);
      }
      i += g.a.a.b.b.a.bM(10, this.TgN);
      paramInt = i;
      if (this.mVA != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.mVA);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.TgO);
      paramInt = i;
      if (this.TgP != null) {
        paramInt = i + g.a.a.a.oD(13, this.TgP.computeSize());
      }
      i = paramInt;
      if (this.TgQ != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.TgQ);
      }
      AppMethodBeat.o(32252);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.TgJ.clear();
        this.TgL.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        if (this.TgD == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(32252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bwy localbwy = (bwy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32252);
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
            localbwy.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 2: 
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
            localbwy.TgD = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 3: 
          localbwy.TgI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32252);
          return 0;
        case 4: 
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
            localbwy.TgJ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 5: 
          localbwy.TgK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32252);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqf)localObject2).parseFrom((byte[])localObject1);
            }
            localbwy.TgL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        case 7: 
          localbwy.Saq = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32252);
          return 0;
        case 8: 
          localbwy.TgM = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 9: 
          localbwy.Sas = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 10: 
          localbwy.TgN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32252);
          return 0;
        case 11: 
          localbwy.mVA = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32252);
          return 0;
        case 12: 
          localbwy.TgO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32252);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cqg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cqg)localObject2).parseFrom((byte[])localObject1);
            }
            localbwy.TgP = ((cqg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32252);
          return 0;
        }
        localbwy.TgQ = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32252);
        return 0;
      }
      AppMethodBeat.o(32252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bwy
 * JD-Core Version:    0.7.0.1
 */