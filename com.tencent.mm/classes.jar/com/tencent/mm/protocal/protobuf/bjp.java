package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class bjp
  extends com.tencent.mm.cd.a
{
  public String PAf;
  public String STH;
  public int STI;
  public int STJ;
  public boolean STK;
  public int STL;
  public String STM;
  public bjy STN;
  public bjq STO;
  public LinkedList<bjq> STP;
  public bjq STQ;
  public bjq STR;
  public bjq STS;
  public bjq STT;
  public String Stk;
  public long id;
  public LinkedList<FinderObject> object;
  public String sessionBuffer;
  public int xBI;
  public int xBK;
  public String xBL;
  public b xGO;
  public boolean zAC;
  public long zAO;
  
  public bjp()
  {
    AppMethodBeat.i(198183);
    this.object = new LinkedList();
    this.STP = new LinkedList();
    AppMethodBeat.o(198183);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(198202);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bm(1, this.zAO);
      if (this.PAf != null) {
        paramVarArgs.f(2, this.PAf);
      }
      if (this.STH != null) {
        paramVarArgs.f(3, this.STH);
      }
      paramVarArgs.aY(4, this.STI);
      paramVarArgs.e(5, 8, this.object);
      paramVarArgs.aY(6, this.STJ);
      if (this.xGO != null) {
        paramVarArgs.c(7, this.xGO);
      }
      paramVarArgs.aY(8, this.xBI);
      paramVarArgs.co(9, this.STK);
      paramVarArgs.aY(10, this.STL);
      paramVarArgs.co(11, this.zAC);
      if (this.xBL != null) {
        paramVarArgs.f(12, this.xBL);
      }
      paramVarArgs.aY(13, this.xBK);
      if (this.STM != null) {
        paramVarArgs.f(14, this.STM);
      }
      paramVarArgs.bm(15, this.id);
      if (this.sessionBuffer != null) {
        paramVarArgs.f(16, this.sessionBuffer);
      }
      if (this.STN != null)
      {
        paramVarArgs.oE(17, this.STN.computeSize());
        this.STN.writeFields(paramVarArgs);
      }
      if (this.STO != null)
      {
        paramVarArgs.oE(18, this.STO.computeSize());
        this.STO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(19, 8, this.STP);
      if (this.STQ != null)
      {
        paramVarArgs.oE(20, this.STQ.computeSize());
        this.STQ.writeFields(paramVarArgs);
      }
      if (this.STR != null)
      {
        paramVarArgs.oE(21, this.STR.computeSize());
        this.STR.writeFields(paramVarArgs);
      }
      if (this.Stk != null) {
        paramVarArgs.f(22, this.Stk);
      }
      if (this.STS != null)
      {
        paramVarArgs.oE(23, this.STS.computeSize());
        this.STS.writeFields(paramVarArgs);
      }
      if (this.STT != null)
      {
        paramVarArgs.oE(24, this.STT.computeSize());
        this.STT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(198202);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.p(1, this.zAO) + 0;
      paramInt = i;
      if (this.PAf != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.PAf);
      }
      i = paramInt;
      if (this.STH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.STH);
      }
      i = i + g.a.a.b.b.a.bM(4, this.STI) + g.a.a.a.c(5, 8, this.object) + g.a.a.b.b.a.bM(6, this.STJ);
      paramInt = i;
      if (this.xGO != null) {
        paramInt = i + g.a.a.b.b.a.b(7, this.xGO);
      }
      i = paramInt + g.a.a.b.b.a.bM(8, this.xBI) + (g.a.a.b.b.a.gL(9) + 1) + g.a.a.b.b.a.bM(10, this.STL) + (g.a.a.b.b.a.gL(11) + 1);
      paramInt = i;
      if (this.xBL != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.xBL);
      }
      i = paramInt + g.a.a.b.b.a.bM(13, this.xBK);
      paramInt = i;
      if (this.STM != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.STM);
      }
      i = paramInt + g.a.a.b.b.a.p(15, this.id);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.g(16, this.sessionBuffer);
      }
      i = paramInt;
      if (this.STN != null) {
        i = paramInt + g.a.a.a.oD(17, this.STN.computeSize());
      }
      paramInt = i;
      if (this.STO != null) {
        paramInt = i + g.a.a.a.oD(18, this.STO.computeSize());
      }
      i = paramInt + g.a.a.a.c(19, 8, this.STP);
      paramInt = i;
      if (this.STQ != null) {
        paramInt = i + g.a.a.a.oD(20, this.STQ.computeSize());
      }
      i = paramInt;
      if (this.STR != null) {
        i = paramInt + g.a.a.a.oD(21, this.STR.computeSize());
      }
      paramInt = i;
      if (this.Stk != null) {
        paramInt = i + g.a.a.b.b.a.g(22, this.Stk);
      }
      i = paramInt;
      if (this.STS != null) {
        i = paramInt + g.a.a.a.oD(23, this.STS.computeSize());
      }
      paramInt = i;
      if (this.STT != null) {
        paramInt = i + g.a.a.a.oD(24, this.STT.computeSize());
      }
      AppMethodBeat.o(198202);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.object.clear();
      this.STP.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(198202);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bjp localbjp = (bjp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(198202);
        return -1;
      case 1: 
        localbjp.zAO = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(198202);
        return 0;
      case 2: 
        localbjp.PAf = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 3: 
        localbjp.STH = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 4: 
        localbjp.STI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(198202);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderObject();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderObject)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.object.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 6: 
        localbjp.STJ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(198202);
        return 0;
      case 7: 
        localbjp.xGO = ((g.a.a.a.a)localObject1).abFh.iUw();
        AppMethodBeat.o(198202);
        return 0;
      case 8: 
        localbjp.xBI = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(198202);
        return 0;
      case 9: 
        localbjp.STK = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(198202);
        return 0;
      case 10: 
        localbjp.STL = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(198202);
        return 0;
      case 11: 
        localbjp.zAC = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(198202);
        return 0;
      case 12: 
        localbjp.xBL = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 13: 
        localbjp.xBK = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(198202);
        return 0;
      case 14: 
        localbjp.STM = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 15: 
        localbjp.id = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(198202);
        return 0;
      case 16: 
        localbjp.sessionBuffer = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjy)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STN = ((bjy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjq)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STO = ((bjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjq)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STP.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjq)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STQ = ((bjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 21: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjq)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STR = ((bjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      case 22: 
        localbjp.Stk = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(198202);
        return 0;
      case 23: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bjq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bjq)localObject2).parseFrom((byte[])localObject1);
          }
          localbjp.STS = ((bjq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(198202);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new bjq();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((bjq)localObject2).parseFrom((byte[])localObject1);
        }
        localbjp.STT = ((bjq)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(198202);
      return 0;
    }
    AppMethodBeat.o(198202);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjp
 * JD-Core Version:    0.7.0.1
 */