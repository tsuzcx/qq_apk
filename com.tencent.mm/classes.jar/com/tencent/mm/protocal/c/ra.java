package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class ra
  extends com.tencent.mm.bv.a
{
  public String iQn;
  public String ilq;
  public String ilr;
  public String sIf;
  public String sIg;
  public long sJq;
  public String sJr;
  public String sJs;
  public anr sOH;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.ilq != null) {
        paramVarArgs.d(2, this.ilq);
      }
      if (this.ilr != null) {
        paramVarArgs.d(3, this.ilr);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.Y(5, this.sJq);
      if (this.sJr != null) {
        paramVarArgs.d(6, this.sJr);
      }
      if (this.sJs != null) {
        paramVarArgs.d(7, this.sJs);
      }
      if (this.iQn != null) {
        paramVarArgs.d(8, this.iQn);
      }
      if (this.sOH != null)
      {
        paramVarArgs.gD(9, this.sOH.btq());
        this.sOH.a(paramVarArgs);
      }
      if (this.sIf != null) {
        paramVarArgs.d(10, this.sIf);
      }
      if (this.sIg != null) {
        paramVarArgs.d(11, this.sIg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label819;
      }
    }
    label819:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ilq != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ilq);
      }
      i = paramInt;
      if (this.ilr != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ilr);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + d.a.a.a.X(5, this.sJq);
      paramInt = i;
      if (this.sJr != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sJr);
      }
      i = paramInt;
      if (this.sJs != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sJs);
      }
      paramInt = i;
      if (this.iQn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.iQn);
      }
      i = paramInt;
      if (this.sOH != null) {
        i = paramInt + d.a.a.a.gA(9, this.sOH.btq());
      }
      paramInt = i;
      if (this.sIf != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sIf);
      }
      i = paramInt;
      if (this.sIg != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.sIg);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
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
        ra localra = (ra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localra.title = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localra.ilq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localra.ilr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localra.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localra.sJq = ((d.a.a.a.a)localObject1).xpH.oE();
          return 0;
        case 6: 
          localra.sJr = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localra.sJs = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localra.iQn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new anr();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((anr)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localra.sOH = ((anr)localObject1);
            paramInt += 1;
          }
        case 10: 
          localra.sIf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localra.sIg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ra
 * JD-Core Version:    0.7.0.1
 */