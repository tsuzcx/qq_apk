package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bg
  extends blm
{
  public String bssid;
  public String olm;
  public int scene;
  public int source;
  public String ssid;
  public String suC;
  public long suD;
  public int suF;
  public String suH;
  public int suI;
  public b suJ;
  public b suK;
  public int suT;
  public bf suU;
  public bi suV;
  public int suW;
  public int suX;
  public int suY;
  public int type;
  
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
      paramVarArgs.gB(3, this.scene);
      paramVarArgs.gB(4, this.type);
      paramVarArgs.gB(5, this.suT);
      if (this.ssid != null) {
        paramVarArgs.d(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.d(7, this.bssid);
      }
      paramVarArgs.Y(8, this.suD);
      if (this.suU != null)
      {
        paramVarArgs.gD(9, this.suU.btq());
        this.suU.a(paramVarArgs);
      }
      if (this.suV != null)
      {
        paramVarArgs.gD(10, this.suV.btq());
        this.suV.a(paramVarArgs);
      }
      paramVarArgs.gB(11, this.suF);
      if (this.suC != null) {
        paramVarArgs.d(12, this.suC);
      }
      paramVarArgs.gB(13, this.source);
      if (this.suH != null) {
        paramVarArgs.d(14, this.suH);
      }
      paramVarArgs.gB(15, this.suW);
      paramVarArgs.gB(16, this.suX);
      paramVarArgs.gB(17, this.suY);
      paramVarArgs.gB(18, this.suI);
      if (this.suJ != null) {
        paramVarArgs.b(19, this.suJ);
      }
      if (this.suK != null) {
        paramVarArgs.b(20, this.suK);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1356;
      }
    }
    label1356:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.olm != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.olm);
      }
      i = i + d.a.a.a.gy(3, this.scene) + d.a.a.a.gy(4, this.type) + d.a.a.a.gy(5, this.suT);
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
      if (this.suU != null) {
        paramInt = i + d.a.a.a.gA(9, this.suU.btq());
      }
      i = paramInt;
      if (this.suV != null) {
        i = paramInt + d.a.a.a.gA(10, this.suV.btq());
      }
      i += d.a.a.a.gy(11, this.suF);
      paramInt = i;
      if (this.suC != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.suC);
      }
      i = paramInt + d.a.a.a.gy(13, this.source);
      paramInt = i;
      if (this.suH != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.suH);
      }
      i = paramInt + d.a.a.a.gy(15, this.suW) + d.a.a.a.gy(16, this.suX) + d.a.a.a.gy(17, this.suY) + d.a.a.a.gy(18, this.suI);
      paramInt = i;
      if (this.suJ != null) {
        paramInt = i + d.a.a.a.a(19, this.suJ);
      }
      i = paramInt;
      if (this.suK != null) {
        i = paramInt + d.a.a.a.a(20, this.suK);
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
        bg localbg = (bg)paramVarArgs[1];
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
            localbg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbg.olm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbg.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localbg.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localbg.suT = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbg.ssid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbg.bssid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbg.suD = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bf();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bf)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbg.suU = ((bf)localObject1);
            paramInt += 1;
          }
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bi();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bi)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbg.suV = ((bi)localObject1);
            paramInt += 1;
          }
        case 11: 
          localbg.suF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localbg.suC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbg.source = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localbg.suH = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localbg.suW = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 16: 
          localbg.suX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localbg.suY = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localbg.suI = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 19: 
          localbg.suJ = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localbg.suK = ((d.a.a.a.a)localObject1).cUs();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bg
 * JD-Core Version:    0.7.0.1
 */