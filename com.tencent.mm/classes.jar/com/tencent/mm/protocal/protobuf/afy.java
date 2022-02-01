package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afy
  extends com.tencent.mm.bx.a
{
  public LinkedList<ja> FZr;
  public String GdG;
  public int GdH;
  public int GdI;
  public int GdJ;
  public int GdK;
  public int GdL;
  public djg GdM;
  public int GdN;
  public long GdO;
  public LinkedList<String> GdP;
  public com.tencent.mm.bx.b GdQ;
  public int GdR;
  public int GdS;
  public int GdT;
  public int GdU;
  public boolean aXj;
  public long endTime;
  public int hhG;
  public String hml;
  public boolean htP;
  public String musicUrl;
  public long startTime;
  public String thumbPath;
  public long timeStamp;
  public String videoPath;
  public int xyZ;
  public csd xzV;
  public boolean xzc;
  
  public afy()
  {
    AppMethodBeat.i(101528);
    this.FZr = new LinkedList();
    this.GdP = new LinkedList();
    AppMethodBeat.o(101528);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101529);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.videoPath == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: videoPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.thumbPath == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: thumbPath");
        AppMethodBeat.o(101529);
        throw paramVarArgs;
      }
      if (this.videoPath != null) {
        paramVarArgs.d(1, this.videoPath);
      }
      paramVarArgs.aY(2, this.startTime);
      paramVarArgs.aY(3, this.endTime);
      if (this.GdG != null) {
        paramVarArgs.d(4, this.GdG);
      }
      paramVarArgs.aS(5, this.hhG);
      if (this.thumbPath != null) {
        paramVarArgs.d(6, this.thumbPath);
      }
      if (this.hml != null) {
        paramVarArgs.d(7, this.hml);
      }
      paramVarArgs.aS(8, this.xyZ);
      if (this.musicUrl != null) {
        paramVarArgs.d(9, this.musicUrl);
      }
      paramVarArgs.bt(10, this.aXj);
      paramVarArgs.bt(11, this.xzc);
      paramVarArgs.aS(12, this.GdH);
      paramVarArgs.aS(13, this.GdI);
      paramVarArgs.aS(14, this.GdJ);
      paramVarArgs.aS(15, this.GdK);
      paramVarArgs.e(16, 8, this.FZr);
      paramVarArgs.aY(17, this.timeStamp);
      paramVarArgs.aS(18, this.GdL);
      paramVarArgs.bt(19, this.htP);
      if (this.xzV != null)
      {
        paramVarArgs.lC(20, this.xzV.computeSize());
        this.xzV.writeFields(paramVarArgs);
      }
      if (this.GdM != null)
      {
        paramVarArgs.lC(21, this.GdM.computeSize());
        this.GdM.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(22, this.GdN);
      paramVarArgs.aY(23, this.GdO);
      paramVarArgs.e(24, 1, this.GdP);
      if (this.GdQ != null) {
        paramVarArgs.c(25, this.GdQ);
      }
      paramVarArgs.aS(26, this.GdR);
      paramVarArgs.aS(27, this.GdS);
      paramVarArgs.aS(28, this.GdT);
      paramVarArgs.aS(29, this.GdU);
      AppMethodBeat.o(101529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.videoPath == null) {
        break label1974;
      }
    }
    label1974:
    for (paramInt = f.a.a.b.b.a.e(1, this.videoPath) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.startTime) + f.a.a.b.b.a.p(3, this.endTime);
      paramInt = i;
      if (this.GdG != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GdG);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.hhG);
      paramInt = i;
      if (this.thumbPath != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.thumbPath);
      }
      i = paramInt;
      if (this.hml != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hml);
      }
      i += f.a.a.b.b.a.bz(8, this.xyZ);
      paramInt = i;
      if (this.musicUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.musicUrl);
      }
      i = paramInt + f.a.a.b.b.a.alV(10) + f.a.a.b.b.a.alV(11) + f.a.a.b.b.a.bz(12, this.GdH) + f.a.a.b.b.a.bz(13, this.GdI) + f.a.a.b.b.a.bz(14, this.GdJ) + f.a.a.b.b.a.bz(15, this.GdK) + f.a.a.a.c(16, 8, this.FZr) + f.a.a.b.b.a.p(17, this.timeStamp) + f.a.a.b.b.a.bz(18, this.GdL) + f.a.a.b.b.a.alV(19);
      paramInt = i;
      if (this.xzV != null) {
        paramInt = i + f.a.a.a.lB(20, this.xzV.computeSize());
      }
      i = paramInt;
      if (this.GdM != null) {
        i = paramInt + f.a.a.a.lB(21, this.GdM.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(22, this.GdN) + f.a.a.b.b.a.p(23, this.GdO) + f.a.a.a.c(24, 1, this.GdP);
      paramInt = i;
      if (this.GdQ != null) {
        paramInt = i + f.a.a.b.b.a.b(25, this.GdQ);
      }
      i = f.a.a.b.b.a.bz(26, this.GdR);
      int j = f.a.a.b.b.a.bz(27, this.GdS);
      int k = f.a.a.b.b.a.bz(28, this.GdT);
      int m = f.a.a.b.b.a.bz(29, this.GdU);
      AppMethodBeat.o(101529);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FZr.clear();
        this.GdP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.videoPath == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: videoPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        if (this.thumbPath == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: thumbPath");
          AppMethodBeat.o(101529);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101529);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afy localafy = (afy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101529);
          return -1;
        case 1: 
          localafy.videoPath = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 2: 
          localafy.startTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 3: 
          localafy.endTime = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 4: 
          localafy.GdG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 5: 
          localafy.hhG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 6: 
          localafy.thumbPath = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 7: 
          localafy.hml = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 8: 
          localafy.xyZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 9: 
          localafy.musicUrl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101529);
          return 0;
        case 10: 
          localafy.aXj = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(101529);
          return 0;
        case 11: 
          localafy.xzc = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(101529);
          return 0;
        case 12: 
          localafy.GdH = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 13: 
          localafy.GdI = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 14: 
          localafy.GdJ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 15: 
          localafy.GdK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 16: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ja();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ja)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafy.FZr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 17: 
          localafy.timeStamp = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 18: 
          localafy.GdL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 19: 
          localafy.htP = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(101529);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafy.xzV = ((csd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 21: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafy.GdM = ((djg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101529);
          return 0;
        case 22: 
          localafy.GdN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 23: 
          localafy.GdO = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(101529);
          return 0;
        case 24: 
          localafy.GdP.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(101529);
          return 0;
        case 25: 
          localafy.GdQ = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(101529);
          return 0;
        case 26: 
          localafy.GdR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 27: 
          localafy.GdS = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        case 28: 
          localafy.GdT = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101529);
          return 0;
        }
        localafy.GdU = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(101529);
        return 0;
      }
      AppMethodBeat.o(101529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afy
 * JD-Core Version:    0.7.0.1
 */