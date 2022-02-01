package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class nw
  extends com.tencent.mm.cd.a
{
  public int RUM;
  public int RUN;
  public int RUO;
  public int RUP;
  public long RUQ;
  public long RUR;
  public boolean RUS;
  public int RUT;
  public boolean RUU;
  public ix RUV;
  public boolean RUW;
  public xj RUX;
  public LinkedList<fhh> RUY;
  public boolean RUZ;
  public String RUp;
  public int RUz;
  public LinkedList<String> RVa;
  public String RVb;
  public String RVc;
  
  public nw()
  {
    AppMethodBeat.i(208079);
    this.RUY = new LinkedList();
    this.RVa = new LinkedList();
    AppMethodBeat.o(208079);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124426);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RUp == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(124426);
        throw paramVarArgs;
      }
      if (this.RUp != null) {
        paramVarArgs.f(1, this.RUp);
      }
      paramVarArgs.aY(2, this.RUM);
      paramVarArgs.aY(3, this.RUN);
      paramVarArgs.aY(4, this.RUO);
      paramVarArgs.aY(5, this.RUP);
      paramVarArgs.bm(6, this.RUQ);
      paramVarArgs.bm(7, this.RUR);
      paramVarArgs.aY(8, this.RUz);
      paramVarArgs.co(9, this.RUS);
      paramVarArgs.aY(10, this.RUT);
      paramVarArgs.co(11, this.RUU);
      if (this.RUV != null)
      {
        paramVarArgs.oE(12, this.RUV.computeSize());
        this.RUV.writeFields(paramVarArgs);
      }
      paramVarArgs.co(13, this.RUW);
      if (this.RUX != null)
      {
        paramVarArgs.oE(14, this.RUX.computeSize());
        this.RUX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(15, 8, this.RUY);
      paramVarArgs.co(16, this.RUZ);
      paramVarArgs.e(17, 1, this.RVa);
      if (this.RVb != null) {
        paramVarArgs.f(18, this.RVb);
      }
      if (this.RVc != null) {
        paramVarArgs.f(19, this.RVc);
      }
      AppMethodBeat.o(124426);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RUp == null) {
        break label1352;
      }
    }
    label1352:
    for (paramInt = g.a.a.b.b.a.g(1, this.RUp) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RUM) + g.a.a.b.b.a.bM(3, this.RUN) + g.a.a.b.b.a.bM(4, this.RUO) + g.a.a.b.b.a.bM(5, this.RUP) + g.a.a.b.b.a.p(6, this.RUQ) + g.a.a.b.b.a.p(7, this.RUR) + g.a.a.b.b.a.bM(8, this.RUz) + (g.a.a.b.b.a.gL(9) + 1) + g.a.a.b.b.a.bM(10, this.RUT) + (g.a.a.b.b.a.gL(11) + 1);
      paramInt = i;
      if (this.RUV != null) {
        paramInt = i + g.a.a.a.oD(12, this.RUV.computeSize());
      }
      i = paramInt + (g.a.a.b.b.a.gL(13) + 1);
      paramInt = i;
      if (this.RUX != null) {
        paramInt = i + g.a.a.a.oD(14, this.RUX.computeSize());
      }
      i = paramInt + g.a.a.a.c(15, 8, this.RUY) + (g.a.a.b.b.a.gL(16) + 1) + g.a.a.a.c(17, 1, this.RVa);
      paramInt = i;
      if (this.RVb != null) {
        paramInt = i + g.a.a.b.b.a.g(18, this.RVb);
      }
      i = paramInt;
      if (this.RVc != null) {
        i = paramInt + g.a.a.b.b.a.g(19, this.RVc);
      }
      AppMethodBeat.o(124426);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RUY.clear();
        this.RVa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RUp == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(124426);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124426);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        nw localnw = (nw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124426);
          return -1;
        case 1: 
          localnw.RUp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124426);
          return 0;
        case 2: 
          localnw.RUM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 3: 
          localnw.RUN = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 4: 
          localnw.RUO = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 5: 
          localnw.RUP = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 6: 
          localnw.RUQ = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124426);
          return 0;
        case 7: 
          localnw.RUR = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(124426);
          return 0;
        case 8: 
          localnw.RUz = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 9: 
          localnw.RUS = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124426);
          return 0;
        case 10: 
          localnw.RUT = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(124426);
          return 0;
        case 11: 
          localnw.RUU = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124426);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ix();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ix)localObject2).parseFrom((byte[])localObject1);
            }
            localnw.RUV = ((ix)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 13: 
          localnw.RUW = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124426);
          return 0;
        case 14: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new xj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((xj)localObject2).parseFrom((byte[])localObject1);
            }
            localnw.RUX = ((xj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 15: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fhh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fhh)localObject2).parseFrom((byte[])localObject1);
            }
            localnw.RUY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124426);
          return 0;
        case 16: 
          localnw.RUZ = ((g.a.a.a.a)localObject1).abFh.AB();
          AppMethodBeat.o(124426);
          return 0;
        case 17: 
          localnw.RVa.add(((g.a.a.a.a)localObject1).abFh.readString());
          AppMethodBeat.o(124426);
          return 0;
        case 18: 
          localnw.RVb = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(124426);
          return 0;
        }
        localnw.RVc = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(124426);
        return 0;
      }
      AppMethodBeat.o(124426);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nw
 * JD-Core Version:    0.7.0.1
 */