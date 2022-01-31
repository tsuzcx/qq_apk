package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class awg
  extends com.tencent.mm.bv.a
{
  public int avS;
  public String bIW;
  public int bLK;
  public String bOL;
  public int ebp;
  public String kRN;
  public String token;
  public int trR;
  public awa tsI;
  public int tsJ;
  public LinkedList<awa> tsK = new LinkedList();
  public int tsL;
  public String tsM;
  public String tsN;
  public String tsO;
  public avn tsP;
  public int tsQ;
  public String tsk;
  public int tsl;
  public int tsm;
  public int tsu;
  public String tsv;
  public String videoPath;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.tsl);
      paramVarArgs.gB(2, this.tsm);
      paramVarArgs.gB(3, this.trR);
      if (this.tsI != null)
      {
        paramVarArgs.gD(4, this.tsI.btq());
        this.tsI.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.tsJ);
      paramVarArgs.d(6, 8, this.tsK);
      paramVarArgs.gB(7, this.ebp);
      paramVarArgs.gB(8, this.tsL);
      if (this.kRN != null) {
        paramVarArgs.d(9, this.kRN);
      }
      if (this.tsM != null) {
        paramVarArgs.d(10, this.tsM);
      }
      if (this.token != null) {
        paramVarArgs.d(11, this.token);
      }
      if (this.tsv != null) {
        paramVarArgs.d(12, this.tsv);
      }
      paramVarArgs.gB(13, this.tsu);
      if (this.videoPath != null) {
        paramVarArgs.d(14, this.videoPath);
      }
      if (this.tsN != null) {
        paramVarArgs.d(15, this.tsN);
      }
      if (this.tsO != null) {
        paramVarArgs.d(16, this.tsO);
      }
      if (this.bIW != null) {
        paramVarArgs.d(17, this.bIW);
      }
      if (this.bOL != null) {
        paramVarArgs.d(18, this.bOL);
      }
      paramVarArgs.gB(19, this.avS);
      paramVarArgs.gB(20, this.bLK);
      if (this.tsk != null) {
        paramVarArgs.d(21, this.tsk);
      }
      if (this.tsP != null)
      {
        paramVarArgs.gD(22, this.tsP.btq());
        this.tsP.a(paramVarArgs);
      }
      paramVarArgs.gB(23, this.tsQ);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.tsl) + 0 + d.a.a.a.gy(2, this.tsm) + d.a.a.a.gy(3, this.trR);
      paramInt = i;
      if (this.tsI != null) {
        paramInt = i + d.a.a.a.gA(4, this.tsI.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.tsJ) + d.a.a.a.c(6, 8, this.tsK) + d.a.a.a.gy(7, this.ebp) + d.a.a.a.gy(8, this.tsL);
      paramInt = i;
      if (this.kRN != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.kRN);
      }
      i = paramInt;
      if (this.tsM != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tsM);
      }
      paramInt = i;
      if (this.token != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.token);
      }
      i = paramInt;
      if (this.tsv != null) {
        i = paramInt + d.a.a.b.b.a.e(12, this.tsv);
      }
      i += d.a.a.a.gy(13, this.tsu);
      paramInt = i;
      if (this.videoPath != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.videoPath);
      }
      i = paramInt;
      if (this.tsN != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tsN);
      }
      paramInt = i;
      if (this.tsO != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.tsO);
      }
      i = paramInt;
      if (this.bIW != null) {
        i = paramInt + d.a.a.b.b.a.e(17, this.bIW);
      }
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(18, this.bOL);
      }
      i = paramInt + d.a.a.a.gy(19, this.avS) + d.a.a.a.gy(20, this.bLK);
      paramInt = i;
      if (this.tsk != null) {
        paramInt = i + d.a.a.b.b.a.e(21, this.tsk);
      }
      i = paramInt;
      if (this.tsP != null) {
        i = paramInt + d.a.a.a.gA(22, this.tsP.btq());
      }
      return i + d.a.a.a.gy(23, this.tsQ);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.tsK.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      awg localawg = (awg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localawg.tsl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localawg.tsm = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localawg.trR = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awa();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawg.tsI = ((awa)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localawg.tsJ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new awa();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((awa)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawg.tsK.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        localawg.ebp = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 8: 
        localawg.tsL = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 9: 
        localawg.kRN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 10: 
        localawg.tsM = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 11: 
        localawg.token = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        localawg.tsv = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 13: 
        localawg.tsu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 14: 
        localawg.videoPath = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        localawg.tsN = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 16: 
        localawg.tsO = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 17: 
        localawg.bIW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 18: 
        localawg.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 19: 
        localawg.avS = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 20: 
        localawg.bLK = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 21: 
        localawg.tsk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 22: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new avn();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((avn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localawg.tsP = ((avn)localObject1);
          paramInt += 1;
        }
        return 0;
      }
      localawg.tsQ = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.awg
 * JD-Core Version:    0.7.0.1
 */