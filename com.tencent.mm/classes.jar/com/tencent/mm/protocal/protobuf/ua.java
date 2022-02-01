package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ua
  extends com.tencent.mm.cd.a
{
  public LinkedList<vl> SdA;
  public LinkedList<vl> SdB;
  public LinkedList<String> SdC;
  public int SdD;
  public int SdE;
  public LinkedList<acg> SdF;
  public long SdG;
  public int SdH;
  public String SdI;
  public acg SdJ;
  public LinkedList<be> SdK;
  public acg SdL;
  public acg SdM;
  public acg SdN;
  public ahl SdO;
  public String SdP;
  public acg SdQ;
  public String SdR;
  public acg SdS;
  public boolean SdT;
  public boolean SdU;
  public int Sdx;
  public int Sdy;
  public LinkedList<vl> Sdz;
  public String code;
  public int status;
  
  public ua()
  {
    AppMethodBeat.i(113948);
    this.Sdz = new LinkedList();
    this.SdA = new LinkedList();
    this.SdB = new LinkedList();
    this.SdC = new LinkedList();
    this.SdF = new LinkedList();
    this.SdK = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.status);
      paramVarArgs.aY(2, this.Sdx);
      paramVarArgs.aY(3, this.Sdy);
      paramVarArgs.e(4, 8, this.Sdz);
      paramVarArgs.e(5, 8, this.SdA);
      paramVarArgs.e(6, 8, this.SdB);
      paramVarArgs.e(7, 1, this.SdC);
      paramVarArgs.aY(8, this.SdD);
      if (this.code != null) {
        paramVarArgs.f(9, this.code);
      }
      paramVarArgs.aY(10, this.SdE);
      paramVarArgs.e(11, 8, this.SdF);
      paramVarArgs.bm(12, this.SdG);
      paramVarArgs.aY(13, this.SdH);
      if (this.SdI != null) {
        paramVarArgs.f(14, this.SdI);
      }
      if (this.SdJ != null)
      {
        paramVarArgs.oE(15, this.SdJ.computeSize());
        this.SdJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.SdK);
      if (this.SdL != null)
      {
        paramVarArgs.oE(17, this.SdL.computeSize());
        this.SdL.writeFields(paramVarArgs);
      }
      if (this.SdM != null)
      {
        paramVarArgs.oE(18, this.SdM.computeSize());
        this.SdM.writeFields(paramVarArgs);
      }
      if (this.SdN != null)
      {
        paramVarArgs.oE(19, this.SdN.computeSize());
        this.SdN.writeFields(paramVarArgs);
      }
      if (this.SdO != null)
      {
        paramVarArgs.oE(20, this.SdO.computeSize());
        this.SdO.writeFields(paramVarArgs);
      }
      if (this.SdP != null) {
        paramVarArgs.f(21, this.SdP);
      }
      if (this.SdQ != null)
      {
        paramVarArgs.oE(22, this.SdQ.computeSize());
        this.SdQ.writeFields(paramVarArgs);
      }
      if (this.SdR != null) {
        paramVarArgs.f(23, this.SdR);
      }
      if (this.SdS != null)
      {
        paramVarArgs.oE(24, this.SdS.computeSize());
        this.SdS.writeFields(paramVarArgs);
      }
      paramVarArgs.co(25, this.SdT);
      paramVarArgs.co(26, this.SdU);
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.status) + 0 + g.a.a.b.b.a.bM(2, this.Sdx) + g.a.a.b.b.a.bM(3, this.Sdy) + g.a.a.a.c(4, 8, this.Sdz) + g.a.a.a.c(5, 8, this.SdA) + g.a.a.a.c(6, 8, this.SdB) + g.a.a.a.c(7, 1, this.SdC) + g.a.a.b.b.a.bM(8, this.SdD);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.code);
      }
      i = paramInt + g.a.a.b.b.a.bM(10, this.SdE) + g.a.a.a.c(11, 8, this.SdF) + g.a.a.b.b.a.p(12, this.SdG) + g.a.a.b.b.a.bM(13, this.SdH);
      paramInt = i;
      if (this.SdI != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.SdI);
      }
      i = paramInt;
      if (this.SdJ != null) {
        i = paramInt + g.a.a.a.oD(15, this.SdJ.computeSize());
      }
      i += g.a.a.a.c(16, 8, this.SdK);
      paramInt = i;
      if (this.SdL != null) {
        paramInt = i + g.a.a.a.oD(17, this.SdL.computeSize());
      }
      i = paramInt;
      if (this.SdM != null) {
        i = paramInt + g.a.a.a.oD(18, this.SdM.computeSize());
      }
      paramInt = i;
      if (this.SdN != null) {
        paramInt = i + g.a.a.a.oD(19, this.SdN.computeSize());
      }
      i = paramInt;
      if (this.SdO != null) {
        i = paramInt + g.a.a.a.oD(20, this.SdO.computeSize());
      }
      paramInt = i;
      if (this.SdP != null) {
        paramInt = i + g.a.a.b.b.a.g(21, this.SdP);
      }
      i = paramInt;
      if (this.SdQ != null) {
        i = paramInt + g.a.a.a.oD(22, this.SdQ.computeSize());
      }
      paramInt = i;
      if (this.SdR != null) {
        paramInt = i + g.a.a.b.b.a.g(23, this.SdR);
      }
      i = paramInt;
      if (this.SdS != null) {
        i = paramInt + g.a.a.a.oD(24, this.SdS.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(25);
      int j = g.a.a.b.b.a.gL(26);
      AppMethodBeat.o(113949);
      return i + (paramInt + 1) + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Sdz.clear();
      this.SdA.clear();
      this.SdB.clear();
      this.SdC.clear();
      this.SdF.clear();
      this.SdK.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ua localua = (ua)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localua.status = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localua.Sdx = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localua.Sdy = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vl)localObject2).parseFrom((byte[])localObject1);
          }
          localua.Sdz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vl)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdA.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new vl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((vl)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localua.SdC.add(((g.a.a.a.a)localObject1).abFh.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localua.SdD = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localua.code = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localua.SdE = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdF.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localua.SdG = ((g.a.a.a.a)localObject1).abFh.AN();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localua.SdH = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localua.SdI = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdJ = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new be();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((be)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdK.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdL = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdM = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdN = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ahl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ahl)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdO = ((ahl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localua.SdP = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdQ = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localua.SdR = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acg)localObject2).parseFrom((byte[])localObject1);
          }
          localua.SdS = ((acg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localua.SdT = ((g.a.a.a.a)localObject1).abFh.AB();
        AppMethodBeat.o(113949);
        return 0;
      }
      localua.SdU = ((g.a.a.a.a)localObject1).abFh.AB();
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ua
 * JD-Core Version:    0.7.0.1
 */