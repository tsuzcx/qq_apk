package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cvh
  extends dyl
{
  public int COi;
  public String CPs;
  public int ScL;
  public int ScM;
  public String TCS;
  public String TCT;
  public String TCU;
  public int TCV;
  public eae TCW;
  public int TCX;
  public int TCY;
  public int TCZ;
  public int TDa;
  public eae TDb;
  public int TDc;
  public int TDd;
  public int TDe;
  public int TDf;
  public int TDg;
  public String TDh;
  public String TDi;
  public int ThK;
  public String ThumbUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32345);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.TCW == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataBuffer");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.TDb == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbData");
        AppMethodBeat.o(32345);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TCS != null) {
        paramVarArgs.f(2, this.TCS);
      }
      if (this.TCT != null) {
        paramVarArgs.f(3, this.TCT);
      }
      if (this.TCU != null) {
        paramVarArgs.f(4, this.TCU);
      }
      paramVarArgs.aY(5, this.COi);
      paramVarArgs.aY(6, this.TCV);
      if (this.TCW != null)
      {
        paramVarArgs.oE(7, this.TCW.computeSize());
        this.TCW.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(8, this.TCX);
      paramVarArgs.aY(9, this.TCY);
      paramVarArgs.aY(10, this.TCZ);
      paramVarArgs.aY(11, this.TDa);
      if (this.TDb != null)
      {
        paramVarArgs.oE(12, this.TDb.computeSize());
        this.TDb.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(13, this.TDc);
      paramVarArgs.aY(14, this.TDd);
      paramVarArgs.aY(15, this.TDe);
      paramVarArgs.aY(16, this.TDf);
      paramVarArgs.aY(17, this.ThK);
      paramVarArgs.aY(18, this.TDg);
      if (this.CPs != null) {
        paramVarArgs.f(19, this.CPs);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(20, this.ThumbUrl);
      }
      paramVarArgs.aY(21, this.ScM);
      paramVarArgs.aY(22, this.ScL);
      if (this.TDh != null) {
        paramVarArgs.f(23, this.TDh);
      }
      if (this.TDi != null) {
        paramVarArgs.f(24, this.TDi);
      }
      AppMethodBeat.o(32345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1738;
      }
    }
    label1738:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TCS != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TCS);
      }
      i = paramInt;
      if (this.TCT != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TCT);
      }
      paramInt = i;
      if (this.TCU != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TCU);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.COi) + g.a.a.b.b.a.bM(6, this.TCV);
      paramInt = i;
      if (this.TCW != null) {
        paramInt = i + g.a.a.a.oD(7, this.TCW.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.TCX) + g.a.a.b.b.a.bM(9, this.TCY) + g.a.a.b.b.a.bM(10, this.TCZ) + g.a.a.b.b.a.bM(11, this.TDa);
      paramInt = i;
      if (this.TDb != null) {
        paramInt = i + g.a.a.a.oD(12, this.TDb.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.TDc) + g.a.a.b.b.a.bM(14, this.TDd) + g.a.a.b.b.a.bM(15, this.TDe) + g.a.a.b.b.a.bM(16, this.TDf) + g.a.a.b.b.a.bM(17, this.ThK) + g.a.a.b.b.a.bM(18, this.TDg);
      paramInt = i;
      if (this.CPs != null) {
        paramInt = i + g.a.a.b.b.a.g(19, this.CPs);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(20, this.ThumbUrl);
      }
      i = i + g.a.a.b.b.a.bM(21, this.ScM) + g.a.a.b.b.a.bM(22, this.ScL);
      paramInt = i;
      if (this.TDh != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.TDh);
      }
      i = paramInt;
      if (this.TDi != null) {
        i = paramInt + g.a.a.b.b.a.g(24, this.TDi);
      }
      AppMethodBeat.o(32345);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.TCW == null)
        {
          paramVarArgs = new b("Not all required fields were included: DataBuffer");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        if (this.TDb == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbData");
          AppMethodBeat.o(32345);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cvh localcvh = (cvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32345);
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
            localcvh.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 2: 
          localcvh.TCS = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 3: 
          localcvh.TCT = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 4: 
          localcvh.TCU = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 5: 
          localcvh.COi = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 6: 
          localcvh.TCV = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 7: 
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
            localcvh.TCW = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 8: 
          localcvh.TCX = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 9: 
          localcvh.TCY = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 10: 
          localcvh.TCZ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 11: 
          localcvh.TDa = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 12: 
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
            localcvh.TDb = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32345);
          return 0;
        case 13: 
          localcvh.TDc = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 14: 
          localcvh.TDd = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 15: 
          localcvh.TDe = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 16: 
          localcvh.TDf = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 17: 
          localcvh.ThK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 18: 
          localcvh.TDg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 19: 
          localcvh.CPs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 20: 
          localcvh.ThumbUrl = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        case 21: 
          localcvh.ScM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 22: 
          localcvh.ScL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(32345);
          return 0;
        case 23: 
          localcvh.TDh = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(32345);
          return 0;
        }
        localcvh.TDi = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(32345);
        return 0;
      }
      AppMethodBeat.o(32345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvh
 * JD-Core Version:    0.7.0.1
 */