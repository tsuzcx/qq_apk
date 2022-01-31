package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ang
  extends bly
{
  public String bQZ;
  public int hHm;
  public cls sMk;
  public String tjb;
  public String tjd;
  public int tje;
  public LinkedList<ayr> tjf = new LinkedList();
  public int tjg;
  public String tjh;
  public String tji;
  public int tjj;
  public String tjk;
  public String tjl;
  public String tjm;
  public int tjn;
  public int tjo;
  public ayr tjp;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tFx == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (this.tFx != null)
      {
        paramVarArgs.gD(1, this.tFx.btq());
        this.tFx.a(paramVarArgs);
      }
      if (this.sMk != null)
      {
        paramVarArgs.gD(2, this.sMk.btq());
        this.sMk.a(paramVarArgs);
      }
      if (this.tjd != null) {
        paramVarArgs.d(3, this.tjd);
      }
      paramVarArgs.gB(4, this.tje);
      paramVarArgs.gB(5, this.hHm);
      if (this.tjb != null) {
        paramVarArgs.d(6, this.tjb);
      }
      paramVarArgs.d(7, 8, this.tjf);
      paramVarArgs.gB(8, this.tjg);
      if (this.tjh != null) {
        paramVarArgs.d(9, this.tjh);
      }
      if (this.tji != null) {
        paramVarArgs.d(10, this.tji);
      }
      paramVarArgs.gB(11, this.tjj);
      if (this.bQZ != null) {
        paramVarArgs.d(12, this.bQZ);
      }
      if (this.tjk != null) {
        paramVarArgs.d(13, this.tjk);
      }
      if (this.tjl != null) {
        paramVarArgs.d(14, this.tjl);
      }
      if (this.tjm != null) {
        paramVarArgs.d(15, this.tjm);
      }
      paramVarArgs.gB(16, this.tjn);
      paramVarArgs.gB(17, this.tjo);
      if (this.tjp != null)
      {
        paramVarArgs.gD(18, this.tjp.btq());
        this.tjp.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1426;
      }
    }
    label1426:
    for (int i = d.a.a.a.gA(1, this.tFx.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sMk != null) {
        paramInt = i + d.a.a.a.gA(2, this.sMk.btq());
      }
      i = paramInt;
      if (this.tjd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tjd);
      }
      i = i + d.a.a.a.gy(4, this.tje) + d.a.a.a.gy(5, this.hHm);
      paramInt = i;
      if (this.tjb != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tjb);
      }
      i = paramInt + d.a.a.a.c(7, 8, this.tjf) + d.a.a.a.gy(8, this.tjg);
      paramInt = i;
      if (this.tjh != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tjh);
      }
      i = paramInt;
      if (this.tji != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tji);
      }
      i += d.a.a.a.gy(11, this.tjj);
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.bQZ);
      }
      i = paramInt;
      if (this.tjk != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.tjk);
      }
      paramInt = i;
      if (this.tjl != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.tjl);
      }
      i = paramInt;
      if (this.tjm != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tjm);
      }
      i = i + d.a.a.a.gy(16, this.tjn) + d.a.a.a.gy(17, this.tjo);
      paramInt = i;
      if (this.tjp != null) {
        paramInt = i + d.a.a.a.gA(18, this.tjp.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjf.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bly.a(paramVarArgs); paramInt > 0; paramInt = bly.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.tFx != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ang localang = (ang)paramVarArgs[1];
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
            localObject1 = new gd();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((gd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localang.tFx = ((gd)localObject1);
            paramInt += 1;
          }
        case 2: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cls();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cls)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localang.sMk = ((cls)localObject1);
            paramInt += 1;
          }
        case 3: 
          localang.tjd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localang.tje = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localang.hHm = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localang.tjb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ayr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ayr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localang.tjf.add(localObject1);
            paramInt += 1;
          }
        case 8: 
          localang.tjg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localang.tjh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localang.tji = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          localang.tjj = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localang.bQZ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localang.tjk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localang.tjl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 15: 
          localang.tjm = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 16: 
          localang.tjn = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 17: 
          localang.tjo = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ayr();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ayr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
          localang.tjp = ((ayr)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ang
 * JD-Core Version:    0.7.0.1
 */