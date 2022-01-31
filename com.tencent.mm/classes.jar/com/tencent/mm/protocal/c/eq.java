package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class eq
  extends com.tencent.mm.bv.a
{
  public int jwX;
  public String stW;
  public uq syg;
  public bmk syh;
  public bmk syi;
  public int syj;
  public bmk syk;
  public chw syl;
  public clq sym;
  public bmk syn;
  public bmk syo;
  public String syp;
  public bmk syq;
  public String syr;
  public bsd sys;
  public String syt;
  public int syu;
  public int syv;
  public int syw;
  public int syx;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.syg == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.syh == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.syi == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      paramVarArgs.gB(1, this.jwX);
      if (this.syg != null)
      {
        paramVarArgs.gD(2, this.syg.btq());
        this.syg.a(paramVarArgs);
      }
      if (this.syh != null)
      {
        paramVarArgs.gD(3, this.syh.btq());
        this.syh.a(paramVarArgs);
      }
      if (this.syi != null)
      {
        paramVarArgs.gD(4, this.syi.btq());
        this.syi.a(paramVarArgs);
      }
      paramVarArgs.gB(5, this.syj);
      if (this.syk != null)
      {
        paramVarArgs.gD(6, this.syk.btq());
        this.syk.a(paramVarArgs);
      }
      if (this.syl != null)
      {
        paramVarArgs.gD(7, this.syl.btq());
        this.syl.a(paramVarArgs);
      }
      if (this.sym != null)
      {
        paramVarArgs.gD(8, this.sym.btq());
        this.sym.a(paramVarArgs);
      }
      if (this.syn != null)
      {
        paramVarArgs.gD(9, this.syn.btq());
        this.syn.a(paramVarArgs);
      }
      if (this.syo != null)
      {
        paramVarArgs.gD(10, this.syo.btq());
        this.syo.a(paramVarArgs);
      }
      if (this.syp != null) {
        paramVarArgs.d(11, this.syp);
      }
      if (this.syq != null)
      {
        paramVarArgs.gD(12, this.syq.btq());
        this.syq.a(paramVarArgs);
      }
      if (this.syr != null) {
        paramVarArgs.d(14, this.syr);
      }
      if (this.sys != null)
      {
        paramVarArgs.gD(15, this.sys.btq());
        this.sys.a(paramVarArgs);
      }
      if (this.syt != null) {
        paramVarArgs.d(16, this.syt);
      }
      paramVarArgs.gB(17, this.syu);
      paramVarArgs.gB(18, this.syv);
      paramVarArgs.gB(19, this.syw);
      if (this.stW != null) {
        paramVarArgs.d(20, this.stW);
      }
      paramVarArgs.gB(21, this.syx);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.jwX) + 0;
      paramInt = i;
      if (this.syg != null) {
        paramInt = i + d.a.a.a.gA(2, this.syg.btq());
      }
      i = paramInt;
      if (this.syh != null) {
        i = paramInt + d.a.a.a.gA(3, this.syh.btq());
      }
      paramInt = i;
      if (this.syi != null) {
        paramInt = i + d.a.a.a.gA(4, this.syi.btq());
      }
      i = paramInt + d.a.a.a.gy(5, this.syj);
      paramInt = i;
      if (this.syk != null) {
        paramInt = i + d.a.a.a.gA(6, this.syk.btq());
      }
      i = paramInt;
      if (this.syl != null) {
        i = paramInt + d.a.a.a.gA(7, this.syl.btq());
      }
      paramInt = i;
      if (this.sym != null) {
        paramInt = i + d.a.a.a.gA(8, this.sym.btq());
      }
      i = paramInt;
      if (this.syn != null) {
        i = paramInt + d.a.a.a.gA(9, this.syn.btq());
      }
      paramInt = i;
      if (this.syo != null) {
        paramInt = i + d.a.a.a.gA(10, this.syo.btq());
      }
      i = paramInt;
      if (this.syp != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.syp);
      }
      paramInt = i;
      if (this.syq != null) {
        paramInt = i + d.a.a.a.gA(12, this.syq.btq());
      }
      i = paramInt;
      if (this.syr != null) {
        i = paramInt + d.a.a.b.b.a.e(14, this.syr);
      }
      paramInt = i;
      if (this.sys != null) {
        paramInt = i + d.a.a.a.gA(15, this.sys.btq());
      }
      i = paramInt;
      if (this.syt != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.syt);
      }
      i = i + d.a.a.a.gy(17, this.syu) + d.a.a.a.gy(18, this.syv) + d.a.a.a.gy(19, this.syw);
      paramInt = i;
      if (this.stW != null) {
        paramInt = i + d.a.a.b.b.a.e(20, this.stW);
      }
      return paramInt + d.a.a.a.gy(21, this.syx);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.syg == null) {
        throw new b("Not all required fields were included: SvrPubECDHKey");
      }
      if (this.syh == null) {
        throw new b("Not all required fields were included: SessionKey");
      }
      if (this.syi == null) {
        throw new b("Not all required fields were included: AutoAuthKey");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      eq localeq = (eq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      case 13: 
      default: 
        return -1;
      case 1: 
        localeq.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new uq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((uq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syg = ((uq)localObject1);
          paramInt += 1;
        }
        return 0;
      case 3: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syh = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syi = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localeq.syj = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 6: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syk = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 7: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new chw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((chw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syl = ((chw)localObject1);
          paramInt += 1;
        }
        return 0;
      case 8: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new clq();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((clq)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.sym = ((clq)localObject1);
          paramInt += 1;
        }
        return 0;
      case 9: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syn = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 10: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syo = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 11: 
        localeq.syp = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 12: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bmk();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bmk)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.syq = ((bmk)localObject1);
          paramInt += 1;
        }
        return 0;
      case 14: 
        localeq.syr = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 15: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bsd();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bsd)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localeq.sys = ((bsd)localObject1);
          paramInt += 1;
        }
        return 0;
      case 16: 
        localeq.syt = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 17: 
        localeq.syu = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 18: 
        localeq.syv = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 19: 
        localeq.syw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 20: 
        localeq.stW = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localeq.syx = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.eq
 * JD-Core Version:    0.7.0.1
 */