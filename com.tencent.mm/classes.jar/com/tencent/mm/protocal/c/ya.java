package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ya
  extends com.tencent.mm.bv.a
{
  public String appId;
  public String bFn;
  public String bRO;
  public yj bWM;
  public String desc;
  public String sWM;
  public LinkedList<String> sWN = new LinkedList();
  public String title;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.bRO != null) {
        paramVarArgs.d(3, this.bRO);
      }
      if (this.sWM != null) {
        paramVarArgs.d(4, this.sWM);
      }
      if (this.appId != null) {
        paramVarArgs.d(5, this.appId);
      }
      if (this.bFn != null) {
        paramVarArgs.d(6, this.bFn);
      }
      paramVarArgs.d(7, 1, this.sWN);
      paramVarArgs.gB(8, this.type);
      if (this.bWM != null)
      {
        paramVarArgs.gD(9, this.bWM.btq());
        this.bWM.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label701;
      }
    }
    label701:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.bRO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bRO);
      }
      paramInt = i;
      if (this.sWM != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sWM);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.appId);
      }
      paramInt = i;
      if (this.bFn != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bFn);
      }
      i = paramInt + d.a.a.a.c(7, 1, this.sWN) + d.a.a.a.gy(8, this.type);
      paramInt = i;
      if (this.bWM != null) {
        paramInt = i + d.a.a.a.gA(9, this.bWM.btq());
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sWN.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        ya localya = (ya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localya.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localya.desc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localya.bRO = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localya.sWM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localya.appId = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localya.bFn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localya.sWN.add(((d.a.a.a.a)localObject1).xpH.readString());
          return 0;
        case 8: 
          localya.type = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yj();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((yj)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localya.bWM = ((yj)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ya
 * JD-Core Version:    0.7.0.1
 */