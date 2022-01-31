package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class arj
  extends blm
{
  public String bIK;
  public String bOL;
  public String signature;
  public String tmB;
  public String tmC;
  public b tmD;
  public int tmE;
  public LinkedList<arx> tmI = new LinkedList();
  public String tmz;
  public String url;
  
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
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      if (this.tmz != null) {
        paramVarArgs.d(4, this.tmz);
      }
      if (this.bIK != null) {
        paramVarArgs.d(5, this.bIK);
      }
      if (this.tmB != null) {
        paramVarArgs.d(6, this.tmB);
      }
      if (this.signature != null) {
        paramVarArgs.d(7, this.signature);
      }
      if (this.tmC != null) {
        paramVarArgs.d(8, this.tmC);
      }
      if (this.tmD != null) {
        paramVarArgs.b(9, this.tmD);
      }
      paramVarArgs.gB(10, this.tmE);
      paramVarArgs.d(11, 8, this.tmI);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label890;
      }
    }
    label890:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bOL);
      }
      paramInt = i;
      if (this.tmz != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tmz);
      }
      i = paramInt;
      if (this.bIK != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.bIK);
      }
      paramInt = i;
      if (this.tmB != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tmB);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.signature);
      }
      paramInt = i;
      if (this.tmC != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tmC);
      }
      i = paramInt;
      if (this.tmD != null) {
        i = paramInt + d.a.a.a.a(9, this.tmD);
      }
      return i + d.a.a.a.gy(10, this.tmE) + d.a.a.a.c(11, 8, this.tmI);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tmI.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
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
        arj localarj = (arj)paramVarArgs[1];
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
            localarj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localarj.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localarj.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localarj.tmz = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localarj.bIK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localarj.tmB = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localarj.signature = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localarj.tmC = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localarj.tmD = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 10: 
          localarj.tmE = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arx();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((arx)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
          localarj.tmI.add(localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.arj
 * JD-Core Version:    0.7.0.1
 */