package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class bsq
  extends com.tencent.mm.cd.a
  implements eip
{
  public int CqV;
  public int SmO;
  public int SmP;
  public int SmQ;
  public LinkedList<eop> SmR;
  public LinkedList<eop> SmS;
  public LinkedList<eop> SmT;
  public int SmU;
  public int SmV;
  public int SmW;
  public cjl SmX;
  public int TcR;
  public int TcS;
  public int TcT;
  public LinkedList<eop> TcU;
  public LinkedList<eop> TcV;
  public LinkedList<eop> TcW;
  
  public bsq()
  {
    AppMethodBeat.i(143974);
    this.SmR = new LinkedList();
    this.SmS = new LinkedList();
    this.SmT = new LinkedList();
    this.TcU = new LinkedList();
    this.TcV = new LinkedList();
    this.TcW = new LinkedList();
    AppMethodBeat.o(143974);
  }
  
  public final int getRet()
  {
    return this.CqV;
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143975);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.CqV);
      paramVarArgs.aY(2, this.SmO);
      paramVarArgs.aY(3, this.SmP);
      paramVarArgs.aY(4, this.SmQ);
      paramVarArgs.e(5, 8, this.SmR);
      paramVarArgs.e(6, 8, this.SmS);
      paramVarArgs.e(7, 8, this.SmT);
      paramVarArgs.aY(8, this.SmU);
      paramVarArgs.aY(9, this.SmV);
      paramVarArgs.aY(10, this.SmW);
      paramVarArgs.aY(11, this.TcR);
      paramVarArgs.aY(12, this.TcS);
      paramVarArgs.aY(13, this.TcT);
      paramVarArgs.e(14, 8, this.TcU);
      paramVarArgs.e(15, 8, this.TcV);
      paramVarArgs.e(16, 8, this.TcW);
      if (this.SmX != null)
      {
        paramVarArgs.oE(17, this.SmX.computeSize());
        this.SmX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.CqV) + 0 + g.a.a.b.b.a.bM(2, this.SmO) + g.a.a.b.b.a.bM(3, this.SmP) + g.a.a.b.b.a.bM(4, this.SmQ) + g.a.a.a.c(5, 8, this.SmR) + g.a.a.a.c(6, 8, this.SmS) + g.a.a.a.c(7, 8, this.SmT) + g.a.a.b.b.a.bM(8, this.SmU) + g.a.a.b.b.a.bM(9, this.SmV) + g.a.a.b.b.a.bM(10, this.SmW) + g.a.a.b.b.a.bM(11, this.TcR) + g.a.a.b.b.a.bM(12, this.TcS) + g.a.a.b.b.a.bM(13, this.TcT) + g.a.a.a.c(14, 8, this.TcU) + g.a.a.a.c(15, 8, this.TcV) + g.a.a.a.c(16, 8, this.TcW);
      paramInt = i;
      if (this.SmX != null) {
        paramInt = i + g.a.a.a.oD(17, this.SmX.computeSize());
      }
      AppMethodBeat.o(143975);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.SmR.clear();
      this.SmS.clear();
      this.SmT.clear();
      this.TcU.clear();
      this.TcV.clear();
      this.TcW.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      bsq localbsq = (bsq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143975);
        return -1;
      case 1: 
        localbsq.CqV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 2: 
        localbsq.SmO = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 3: 
        localbsq.SmP = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 4: 
        localbsq.SmQ = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.SmR.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.SmS.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.SmT.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 8: 
        localbsq.SmU = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 9: 
        localbsq.SmV = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 10: 
        localbsq.SmW = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 11: 
        localbsq.TcR = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 12: 
        localbsq.TcS = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 13: 
        localbsq.TcT = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(143975);
        return 0;
      case 14: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.TcU.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.TcV.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eop();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eop)localObject2).parseFrom((byte[])localObject1);
          }
          localbsq.TcW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(143975);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new cjl();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((cjl)localObject2).parseFrom((byte[])localObject1);
        }
        localbsq.SmX = ((cjl)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(143975);
      return 0;
    }
    AppMethodBeat.o(143975);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsq
 * JD-Core Version:    0.7.0.1
 */