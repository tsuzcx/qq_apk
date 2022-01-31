package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ank
  extends bly
{
  public cls sMk;
  public String tjA;
  public int tjn;
  public LinkedList<cmt> tjt = new LinkedList();
  public cmt tju;
  public String tjv;
  public int tjw;
  public String tjx;
  public String tjy;
  public String tjz;
  
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
      paramVarArgs.d(3, 8, this.tjt);
      if (this.tju != null)
      {
        paramVarArgs.gD(4, this.tju.btq());
        this.tju.a(paramVarArgs);
      }
      if (this.tjv != null) {
        paramVarArgs.d(5, this.tjv);
      }
      paramVarArgs.gB(6, this.tjw);
      if (this.tjx != null) {
        paramVarArgs.d(7, this.tjx);
      }
      if (this.tjy != null) {
        paramVarArgs.d(8, this.tjy);
      }
      if (this.tjz != null) {
        paramVarArgs.d(9, this.tjz);
      }
      if (this.tjA != null) {
        paramVarArgs.d(10, this.tjA);
      }
      paramVarArgs.gB(11, this.tjn);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tFx == null) {
        break label1097;
      }
    }
    label1097:
    for (paramInt = d.a.a.a.gA(1, this.tFx.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sMk != null) {
        i = paramInt + d.a.a.a.gA(2, this.sMk.btq());
      }
      i += d.a.a.a.c(3, 8, this.tjt);
      paramInt = i;
      if (this.tju != null) {
        paramInt = i + d.a.a.a.gA(4, this.tju.btq());
      }
      i = paramInt;
      if (this.tjv != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tjv);
      }
      i += d.a.a.a.gy(6, this.tjw);
      paramInt = i;
      if (this.tjx != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.tjx);
      }
      i = paramInt;
      if (this.tjy != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.tjy);
      }
      paramInt = i;
      if (this.tjz != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.tjz);
      }
      i = paramInt;
      if (this.tjA != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.tjA);
      }
      return i + d.a.a.a.gy(11, this.tjn);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tjt.clear();
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
        ank localank = (ank)paramVarArgs[1];
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
            localank.tFx = ((gd)localObject1);
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
            localank.sMk = ((cls)localObject1);
            paramInt += 1;
          }
        case 3: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localank.tjt.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmt();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmt)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bly.a((d.a.a.a.a)localObject2))) {}
            localank.tju = ((cmt)localObject1);
            paramInt += 1;
          }
        case 5: 
          localank.tjv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localank.tjw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localank.tjx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localank.tjy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localank.tjz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localank.tjA = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localank.tjn = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ank
 * JD-Core Version:    0.7.0.1
 */