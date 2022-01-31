package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bb
  extends blm
{
  public String bssid;
  public String olm;
  public int scene;
  public int source;
  public String ssid;
  public int suB;
  public String suC;
  public long suD;
  public bn suE;
  public int suF;
  public int suG;
  public String suH;
  public int suI;
  public b suJ;
  public b suK;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.olm != null) {
        paramVarArgs.d(2, this.olm);
      }
      paramVarArgs.gB(3, this.suB);
      if (this.suC != null) {
        paramVarArgs.d(4, this.suC);
      }
      paramVarArgs.gB(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.Y(8, this.suD);
      if (this.suE != null)
      {
        paramVarArgs.gD(9, this.suE.btq());
        this.suE.a(paramVarArgs);
      }
      paramVarArgs.gB(10, this.suF);
      paramVarArgs.gB(11, this.suG);
      paramVarArgs.gB(12, this.source);
      if (this.suH != null) {
        paramVarArgs.d(13, this.suH);
      }
      paramVarArgs.gB(14, this.suI);
      if (this.suJ != null) {
        paramVarArgs.b(15, this.suJ);
      }
      if (this.suK != null) {
        paramVarArgs.b(16, this.suK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1090;
      }
    }
    label1090:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.olm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.olm);
      }
      i += d.a.a.a.gy(3, this.suB);
      paramInt = i;
      if (this.suC != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.suC);
      }
      i = paramInt + d.a.a.a.gy(5, this.scene);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.bssid);
      }
      i += d.a.a.a.X(8, this.suD);
      paramInt = i;
      if (this.suE != null) {
        paramInt = i + d.a.a.a.gA(9, this.suE.btq());
      }
      i = paramInt + d.a.a.a.gy(10, this.suF) + d.a.a.a.gy(11, this.suG) + d.a.a.a.gy(12, this.source);
      paramInt = i;
      if (this.suH != null) {
        paramInt = i + d.a.a.b.b.a.e(13, this.suH);
      }
      i = paramInt + d.a.a.a.gy(14, this.suI);
      paramInt = i;
      if (this.suJ != null) {
        paramInt = i + d.a.a.a.a(15, this.suJ);
      }
      i = paramInt;
      if (this.suK != null) {
        i = paramInt + d.a.a.a.a(16, this.suK);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        bb localbb = (bb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbb.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbb.olm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbb.suB = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbb.suC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbb.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbb.ssid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbb.bssid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbb.suD = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bn();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bn)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbb.suE = ((bn)localObject1);
            paramInt += 1;
          }
        case 10: 
          localbb.suF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localbb.suG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbb.source = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localbb.suH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbb.suI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 15: 
          localbb.suJ = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localbb.suK = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bb
 * JD-Core Version:    0.7.0.1
 */