package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class kd
  extends blm
{
  public int bUR;
  public String nickname;
  public int nxO;
  public String nyK;
  public String nzf;
  public String nzg;
  public String nzi;
  public int nzk;
  public String nzl;
  public String nzm;
  public String psl;
  public String psm;
  public String sEM;
  public String sES;
  public String sET;
  public String sEU;
  public int sEV;
  public boolean sEW;
  public boolean sEX;
  public String sEY;
  public int sEZ;
  public int scene;
  public yz swf;
  public String swg;
  public int swh;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sES == null) {
        throw new b("Not all required fields were included: qrcode_id");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.nzl != null) {
        paramVarArgs.d(2, this.nzl);
      }
      if (this.sES != null) {
        paramVarArgs.d(3, this.sES);
      }
      paramVarArgs.gB(4, this.scene);
      if (this.sET != null) {
        paramVarArgs.d(5, this.sET);
      }
      if (this.nzf != null) {
        paramVarArgs.d(6, this.nzf);
      }
      paramVarArgs.gB(7, this.swh);
      paramVarArgs.gB(8, this.bUR);
      if (this.nzm != null) {
        paramVarArgs.d(9, this.nzm);
      }
      if (this.nzg != null) {
        paramVarArgs.d(10, this.nzg);
      }
      if (this.sEU != null) {
        paramVarArgs.d(11, this.sEU);
      }
      paramVarArgs.gB(12, this.sEV);
      paramVarArgs.gB(13, this.nzk);
      if (this.swg != null) {
        paramVarArgs.d(14, this.swg);
      }
      if (this.swf != null)
      {
        paramVarArgs.gD(15, this.swf.btq());
        this.swf.a(paramVarArgs);
      }
      if (this.sEM != null) {
        paramVarArgs.d(16, this.sEM);
      }
      paramVarArgs.gB(17, this.nxO);
      paramVarArgs.aA(18, this.sEW);
      paramVarArgs.aA(19, this.sEX);
      if (this.psl != null) {
        paramVarArgs.d(20, this.psl);
      }
      if (this.psm != null) {
        paramVarArgs.d(21, this.psm);
      }
      if (this.sEY != null) {
        paramVarArgs.d(22, this.sEY);
      }
      if (this.nzi != null) {
        paramVarArgs.d(23, this.nzi);
      }
      if (this.nickname != null) {
        paramVarArgs.d(24, this.nickname);
      }
      if (this.nyK != null) {
        paramVarArgs.d(25, this.nyK);
      }
      paramVarArgs.gB(26, this.sEZ);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1652;
      }
    }
    label1652:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nzl != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nzl);
      }
      i = paramInt;
      if (this.sES != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sES);
      }
      i += d.a.a.a.gy(4, this.scene);
      paramInt = i;
      if (this.sET != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sET);
      }
      i = paramInt;
      if (this.nzf != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.nzf);
      }
      i = i + d.a.a.a.gy(7, this.swh) + d.a.a.a.gy(8, this.bUR);
      paramInt = i;
      if (this.nzm != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.nzm);
      }
      i = paramInt;
      if (this.nzg != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.nzg);
      }
      paramInt = i;
      if (this.sEU != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.sEU);
      }
      i = paramInt + d.a.a.a.gy(12, this.sEV) + d.a.a.a.gy(13, this.nzk);
      paramInt = i;
      if (this.swg != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.swg);
      }
      i = paramInt;
      if (this.swf != null) {
        i = paramInt + d.a.a.a.gA(15, this.swf.btq());
      }
      paramInt = i;
      if (this.sEM != null) {
        paramInt = i + d.a.a.b.b.a.e(16, this.sEM);
      }
      i = paramInt + d.a.a.a.gy(17, this.nxO) + (d.a.a.b.b.a.dQ(18) + 1) + (d.a.a.b.b.a.dQ(19) + 1);
      paramInt = i;
      if (this.psl != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.psl);
      }
      i = paramInt;
      if (this.psm != null) {
        i = paramInt + d.a.a.b.b.a.e(21, this.psm);
      }
      paramInt = i;
      if (this.sEY != null) {
        paramInt = i + d.a.a.b.b.a.e(22, this.sEY);
      }
      i = paramInt;
      if (this.nzi != null) {
        i = paramInt + d.a.a.b.b.a.e(23, this.nzi);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(24, this.nickname);
      }
      i = paramInt;
      if (this.nyK != null) {
        i = paramInt + d.a.a.b.b.a.e(25, this.nyK);
      }
      return i + d.a.a.a.gy(26, this.sEZ);
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = blm.a(paramVarArgs); paramInt > 0; paramInt = blm.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.sES != null) {
          break;
        }
        throw new b("Not all required fields were included: qrcode_id");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        kd localkd = (kd)paramVarArgs[1];
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
            localkd.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localkd.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localkd.sES = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localkd.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localkd.sET = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localkd.nzf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localkd.swh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localkd.bUR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localkd.nzm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localkd.nzg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localkd.sEU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 12: 
          localkd.sEV = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 13: 
          localkd.nzk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 14: 
          localkd.swg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new yz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((yz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localkd.swf = ((yz)localObject1);
            paramInt += 1;
          }
        case 16: 
          localkd.sEM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 17: 
          localkd.nxO = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 18: 
          localkd.sEW = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 19: 
          localkd.sEX = ((d.a.a.a.a)localObject1).cUr();
          return 0;
        case 20: 
          localkd.psl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 21: 
          localkd.psm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 22: 
          localkd.sEY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 23: 
          localkd.nzi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 24: 
          localkd.nickname = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 25: 
          localkd.nyK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localkd.sEZ = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kd
 * JD-Core Version:    0.7.0.1
 */