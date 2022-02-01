package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bs
  extends ckq
{
  public int CwA;
  public br CwB;
  public bu CwC;
  public int CwD;
  public long CwE;
  public long CwF;
  public float CwG;
  public float CwH;
  public float CwI;
  public int CwJ;
  public long CwK;
  public long CwL;
  public int CwM;
  public String Cwd;
  public long Cwe;
  public int Cwg;
  public String Cwi;
  public int Cwj;
  public b Cwk;
  public b Cwl;
  public String Cwn;
  public String Cwo;
  public int Cwq;
  public int Cwr;
  public String bssid;
  public int dep;
  public int scene;
  public String ssid;
  public int type;
  public String wyi;
  public String xZu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125699);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wyi != null) {
        paramVarArgs.d(2, this.wyi);
      }
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.type);
      paramVarArgs.aR(5, this.CwA);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aG(8, this.Cwe);
      if (this.CwB != null)
      {
        paramVarArgs.kX(9, this.CwB.computeSize());
        this.CwB.writeFields(paramVarArgs);
      }
      if (this.CwC != null)
      {
        paramVarArgs.kX(10, this.CwC.computeSize());
        this.CwC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(11, this.Cwg);
      if (this.Cwd != null) {
        paramVarArgs.d(12, this.Cwd);
      }
      paramVarArgs.aR(13, this.dep);
      if (this.Cwi != null) {
        paramVarArgs.d(14, this.Cwi);
      }
      paramVarArgs.aR(15, this.CwD);
      paramVarArgs.aG(16, this.CwE);
      paramVarArgs.aG(17, this.CwF);
      paramVarArgs.aR(18, this.Cwj);
      if (this.Cwk != null) {
        paramVarArgs.c(19, this.Cwk);
      }
      if (this.Cwl != null) {
        paramVarArgs.c(20, this.Cwl);
      }
      if (this.Cwn != null) {
        paramVarArgs.d(21, this.Cwn);
      }
      if (this.xZu != null) {
        paramVarArgs.d(22, this.xZu);
      }
      if (this.Cwo != null) {
        paramVarArgs.d(23, this.Cwo);
      }
      paramVarArgs.x(24, this.CwG);
      paramVarArgs.x(25, this.CwH);
      paramVarArgs.x(26, this.CwI);
      paramVarArgs.aR(27, this.CwJ);
      paramVarArgs.aG(28, this.CwK);
      paramVarArgs.aG(29, this.CwL);
      paramVarArgs.aR(30, this.Cwq);
      paramVarArgs.aR(31, this.Cwr);
      paramVarArgs.aR(32, this.CwM);
      AppMethodBeat.o(125699);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2119;
      }
    }
    label2119:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wyi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wyi);
      }
      i = i + f.a.a.b.b.a.bA(3, this.scene) + f.a.a.b.b.a.bA(4, this.type) + f.a.a.b.b.a.bA(5, this.CwA);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.bssid);
      }
      i += f.a.a.b.b.a.q(8, this.Cwe);
      paramInt = i;
      if (this.CwB != null) {
        paramInt = i + f.a.a.a.kW(9, this.CwB.computeSize());
      }
      i = paramInt;
      if (this.CwC != null) {
        i = paramInt + f.a.a.a.kW(10, this.CwC.computeSize());
      }
      i += f.a.a.b.b.a.bA(11, this.Cwg);
      paramInt = i;
      if (this.Cwd != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Cwd);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.dep);
      paramInt = i;
      if (this.Cwi != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Cwi);
      }
      i = paramInt + f.a.a.b.b.a.bA(15, this.CwD) + f.a.a.b.b.a.q(16, this.CwE) + f.a.a.b.b.a.q(17, this.CwF) + f.a.a.b.b.a.bA(18, this.Cwj);
      paramInt = i;
      if (this.Cwk != null) {
        paramInt = i + f.a.a.b.b.a.b(19, this.Cwk);
      }
      i = paramInt;
      if (this.Cwl != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.Cwl);
      }
      paramInt = i;
      if (this.Cwn != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.Cwn);
      }
      i = paramInt;
      if (this.xZu != null) {
        i = paramInt + f.a.a.b.b.a.e(22, this.xZu);
      }
      paramInt = i;
      if (this.Cwo != null) {
        paramInt = i + f.a.a.b.b.a.e(23, this.Cwo);
      }
      i = f.a.a.b.b.a.fY(24);
      int j = f.a.a.b.b.a.fY(25);
      int k = f.a.a.b.b.a.fY(26);
      int m = f.a.a.b.b.a.bA(27, this.CwJ);
      int n = f.a.a.b.b.a.q(28, this.CwK);
      int i1 = f.a.a.b.b.a.q(29, this.CwL);
      int i2 = f.a.a.b.b.a.bA(30, this.Cwq);
      int i3 = f.a.a.b.b.a.bA(31, this.Cwr);
      int i4 = f.a.a.b.b.a.bA(32, this.CwM);
      AppMethodBeat.o(125699);
      return paramInt + (i + 4) + (j + 4) + (k + 4) + m + n + i1 + i2 + i3 + i4;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125699);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bs localbs = (bs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125699);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbs.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 2: 
          localbs.wyi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 3: 
          localbs.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 4: 
          localbs.type = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 5: 
          localbs.CwA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 6: 
          localbs.ssid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 7: 
          localbs.bssid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 8: 
          localbs.Cwe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125699);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new br();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((br)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbs.CwB = ((br)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbs.CwC = ((bu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125699);
          return 0;
        case 11: 
          localbs.Cwg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 12: 
          localbs.Cwd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 13: 
          localbs.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 14: 
          localbs.Cwi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 15: 
          localbs.CwD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 16: 
          localbs.CwE = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125699);
          return 0;
        case 17: 
          localbs.CwF = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125699);
          return 0;
        case 18: 
          localbs.Cwj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 19: 
          localbs.Cwk = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125699);
          return 0;
        case 20: 
          localbs.Cwl = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125699);
          return 0;
        case 21: 
          localbs.Cwn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 22: 
          localbs.xZu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 23: 
          localbs.Cwo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125699);
          return 0;
        case 24: 
          localbs.CwG = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(125699);
          return 0;
        case 25: 
          localbs.CwH = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(125699);
          return 0;
        case 26: 
          localbs.CwI = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(125699);
          return 0;
        case 27: 
          localbs.CwJ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 28: 
          localbs.CwK = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125699);
          return 0;
        case 29: 
          localbs.CwL = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125699);
          return 0;
        case 30: 
          localbs.Cwq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        case 31: 
          localbs.Cwr = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125699);
          return 0;
        }
        localbs.CwM = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125699);
        return 0;
      }
      AppMethodBeat.o(125699);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bs
 * JD-Core Version:    0.7.0.1
 */