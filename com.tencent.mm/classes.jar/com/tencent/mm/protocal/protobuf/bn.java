package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bn
  extends ckq
{
  public int Cwc;
  public String Cwd;
  public long Cwe;
  public bz Cwf;
  public int Cwg;
  public int Cwh;
  public String Cwi;
  public int Cwj;
  public b Cwk;
  public b Cwl;
  public long Cwm;
  public String Cwn;
  public String Cwo;
  public int Cwp;
  public int Cwq;
  public int Cwr;
  public String bssid;
  public int dep;
  public int scene;
  public String ssid;
  public String wyi;
  public String xZu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125693);
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
      paramVarArgs.aR(3, this.Cwc);
      if (this.Cwd != null) {
        paramVarArgs.d(4, this.Cwd);
      }
      paramVarArgs.aR(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.aG(8, this.Cwe);
      if (this.Cwf != null)
      {
        paramVarArgs.kX(9, this.Cwf.computeSize());
        this.Cwf.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.Cwg);
      paramVarArgs.aR(11, this.Cwh);
      paramVarArgs.aR(12, this.dep);
      if (this.Cwi != null) {
        paramVarArgs.d(13, this.Cwi);
      }
      paramVarArgs.aR(14, this.Cwj);
      if (this.Cwk != null) {
        paramVarArgs.c(15, this.Cwk);
      }
      if (this.Cwl != null) {
        paramVarArgs.c(16, this.Cwl);
      }
      paramVarArgs.aG(17, this.Cwm);
      if (this.Cwn != null) {
        paramVarArgs.d(18, this.Cwn);
      }
      if (this.xZu != null) {
        paramVarArgs.d(19, this.xZu);
      }
      if (this.Cwo != null) {
        paramVarArgs.d(20, this.Cwo);
      }
      paramVarArgs.aR(21, this.Cwp);
      paramVarArgs.aR(22, this.Cwq);
      paramVarArgs.aR(23, this.Cwr);
      AppMethodBeat.o(125693);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1586;
      }
    }
    label1586:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wyi != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.wyi);
      }
      i += f.a.a.b.b.a.bA(3, this.Cwc);
      paramInt = i;
      if (this.Cwd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Cwd);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.scene);
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
      if (this.Cwf != null) {
        paramInt = i + f.a.a.a.kW(9, this.Cwf.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Cwg) + f.a.a.b.b.a.bA(11, this.Cwh) + f.a.a.b.b.a.bA(12, this.dep);
      paramInt = i;
      if (this.Cwi != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Cwi);
      }
      i = paramInt + f.a.a.b.b.a.bA(14, this.Cwj);
      paramInt = i;
      if (this.Cwk != null) {
        paramInt = i + f.a.a.b.b.a.b(15, this.Cwk);
      }
      i = paramInt;
      if (this.Cwl != null) {
        i = paramInt + f.a.a.b.b.a.b(16, this.Cwl);
      }
      i += f.a.a.b.b.a.q(17, this.Cwm);
      paramInt = i;
      if (this.Cwn != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.Cwn);
      }
      i = paramInt;
      if (this.xZu != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.xZu);
      }
      paramInt = i;
      if (this.Cwo != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.Cwo);
      }
      i = f.a.a.b.b.a.bA(21, this.Cwp);
      int j = f.a.a.b.b.a.bA(22, this.Cwq);
      int k = f.a.a.b.b.a.bA(23, this.Cwr);
      AppMethodBeat.o(125693);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(125693);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125693);
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
            localbn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 2: 
          localbn.wyi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 3: 
          localbn.Cwc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 4: 
          localbn.Cwd = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 5: 
          localbn.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 6: 
          localbn.ssid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 7: 
          localbn.bssid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 8: 
          localbn.Cwe = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125693);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbn.Cwf = ((bz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125693);
          return 0;
        case 10: 
          localbn.Cwg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 11: 
          localbn.Cwh = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 12: 
          localbn.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 13: 
          localbn.Cwi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 14: 
          localbn.Cwj = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 15: 
          localbn.Cwk = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125693);
          return 0;
        case 16: 
          localbn.Cwl = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(125693);
          return 0;
        case 17: 
          localbn.Cwm = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(125693);
          return 0;
        case 18: 
          localbn.Cwn = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 19: 
          localbn.xZu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 20: 
          localbn.Cwo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(125693);
          return 0;
        case 21: 
          localbn.Cwp = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        case 22: 
          localbn.Cwq = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(125693);
          return 0;
        }
        localbn.Cwr = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125693);
        return 0;
      }
      AppMethodBeat.o(125693);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bn
 * JD-Core Version:    0.7.0.1
 */