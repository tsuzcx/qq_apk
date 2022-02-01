package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ay
  extends com.tencent.mm.cd.a
{
  public int RFA;
  public String RFB;
  public String RFC;
  public int RFD;
  public fqi RFE;
  public fqf RFF;
  public int RFr;
  public String RFs;
  public String RFt;
  public int RFu;
  public int RFv;
  public String RFw;
  public int RFx;
  public String RFy;
  public String RFz;
  public String UserName;
  public String mVD;
  public int rVU;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133142);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.f(1, this.UserName);
      }
      if (this.rWI != null) {
        paramVarArgs.f(2, this.rWI);
      }
      paramVarArgs.aY(3, this.RFr);
      if (this.RFs != null) {
        paramVarArgs.f(4, this.RFs);
      }
      if (this.RFt != null) {
        paramVarArgs.f(5, this.RFt);
      }
      if (this.mVD != null) {
        paramVarArgs.f(6, this.mVD);
      }
      paramVarArgs.aY(8, this.rVU);
      paramVarArgs.aY(9, this.RFu);
      paramVarArgs.aY(10, this.RFv);
      if (this.RFw != null) {
        paramVarArgs.f(11, this.RFw);
      }
      paramVarArgs.aY(12, this.RFx);
      if (this.RFy != null) {
        paramVarArgs.f(13, this.RFy);
      }
      if (this.RFz != null) {
        paramVarArgs.f(14, this.RFz);
      }
      paramVarArgs.aY(15, this.RFA);
      if (this.RFB != null) {
        paramVarArgs.f(16, this.RFB);
      }
      if (this.RFC != null) {
        paramVarArgs.f(17, this.RFC);
      }
      paramVarArgs.aY(18, this.RFD);
      if (this.RFE != null)
      {
        paramVarArgs.oE(19, this.RFE.computeSize());
        this.RFE.writeFields(paramVarArgs);
      }
      if (this.RFF != null)
      {
        paramVarArgs.oE(20, this.RFF.computeSize());
        this.RFF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133142);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1358;
      }
    }
    label1358:
    for (paramInt = g.a.a.b.b.a.g(1, this.UserName) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.rWI != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.rWI);
      }
      i += g.a.a.b.b.a.bM(3, this.RFr);
      paramInt = i;
      if (this.RFs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RFs);
      }
      i = paramInt;
      if (this.RFt != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RFt);
      }
      paramInt = i;
      if (this.mVD != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.mVD);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.rVU) + g.a.a.b.b.a.bM(9, this.RFu) + g.a.a.b.b.a.bM(10, this.RFv);
      paramInt = i;
      if (this.RFw != null) {
        paramInt = i + g.a.a.b.b.a.g(11, this.RFw);
      }
      i = paramInt + g.a.a.b.b.a.bM(12, this.RFx);
      paramInt = i;
      if (this.RFy != null) {
        paramInt = i + g.a.a.b.b.a.g(13, this.RFy);
      }
      i = paramInt;
      if (this.RFz != null) {
        i = paramInt + g.a.a.b.b.a.g(14, this.RFz);
      }
      i += g.a.a.b.b.a.bM(15, this.RFA);
      paramInt = i;
      if (this.RFB != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.RFB);
      }
      i = paramInt;
      if (this.RFC != null) {
        i = paramInt + g.a.a.b.b.a.g(17, this.RFC);
      }
      i += g.a.a.b.b.a.bM(18, this.RFD);
      paramInt = i;
      if (this.RFE != null) {
        paramInt = i + g.a.a.a.oD(19, this.RFE.computeSize());
      }
      i = paramInt;
      if (this.RFF != null) {
        i = paramInt + g.a.a.a.oD(20, this.RFF.computeSize());
      }
      AppMethodBeat.o(133142);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ay localay = (ay)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 7: 
        default: 
          AppMethodBeat.o(133142);
          return -1;
        case 1: 
          localay.UserName = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 2: 
          localay.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 3: 
          localay.RFr = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 4: 
          localay.RFs = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 5: 
          localay.RFt = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 6: 
          localay.mVD = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 8: 
          localay.rVU = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 9: 
          localay.RFu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 10: 
          localay.RFv = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 11: 
          localay.RFw = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 12: 
          localay.RFx = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 13: 
          localay.RFy = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 14: 
          localay.RFz = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 15: 
          localay.RFA = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 16: 
          localay.RFB = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 17: 
          localay.RFC = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(133142);
          return 0;
        case 18: 
          localay.RFD = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(133142);
          return 0;
        case 19: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqi();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqi)localObject2).parseFrom((byte[])localObject1);
            }
            localay.RFE = ((fqi)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133142);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fqf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fqf)localObject2).parseFrom((byte[])localObject1);
          }
          localay.RFF = ((fqf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133142);
        return 0;
      }
      AppMethodBeat.o(133142);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ay
 * JD-Core Version:    0.7.0.1
 */