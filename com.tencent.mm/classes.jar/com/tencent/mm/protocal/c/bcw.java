package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bcw
  extends blm
{
  public String euK;
  public String kSb;
  public String kVn;
  public aw sHl;
  public String sNf;
  public String sNg;
  public String sNh;
  public String sNi;
  public String sZx;
  public String tyj;
  public String tyk;
  public String tyl;
  public String tym;
  public String tyn;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      if (this.tyj != null) {
        paramVarArgs.d(3, this.tyj);
      }
      if (this.sZx != null) {
        paramVarArgs.d(4, this.sZx);
      }
      if (this.sNf != null) {
        paramVarArgs.d(5, this.sNf);
      }
      if (this.tyk != null) {
        paramVarArgs.d(6, this.tyk);
      }
      if (this.sNg != null) {
        paramVarArgs.d(7, this.sNg);
      }
      if (this.sNh != null) {
        paramVarArgs.d(8, this.sNh);
      }
      if (this.sNi != null) {
        paramVarArgs.d(9, this.sNi);
      }
      if (this.tyl != null) {
        paramVarArgs.d(10, this.tyl);
      }
      if (this.sHl != null)
      {
        paramVarArgs.gD(11, this.sHl.btq());
        this.sHl.a(paramVarArgs);
      }
      if (this.tym != null) {
        paramVarArgs.d(12, this.tym);
      }
      if (this.kSb != null) {
        paramVarArgs.d(13, this.kSb);
      }
      if (this.kVn != null) {
        paramVarArgs.d(14, this.kVn);
      }
      if (this.tyn != null) {
        paramVarArgs.d(15, this.tyn);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label1153;
      }
    }
    label1153:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.tyj != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tyj);
      }
      paramInt = i;
      if (this.sZx != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sZx);
      }
      i = paramInt;
      if (this.sNf != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sNf);
      }
      paramInt = i;
      if (this.tyk != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tyk);
      }
      i = paramInt;
      if (this.sNg != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sNg);
      }
      paramInt = i;
      if (this.sNh != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sNh);
      }
      i = paramInt;
      if (this.sNi != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sNi);
      }
      paramInt = i;
      if (this.tyl != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.tyl);
      }
      i = paramInt;
      if (this.sHl != null) {
        i = paramInt + d.a.a.a.gA(11, this.sHl.btq());
      }
      paramInt = i;
      if (this.tym != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.tym);
      }
      i = paramInt;
      if (this.kSb != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.kSb);
      }
      paramInt = i;
      if (this.kVn != null) {
        paramInt = i + d.a.a.b.b.a.e(14, this.kVn);
      }
      i = paramInt;
      if (this.tyn != null) {
        i = paramInt + d.a.a.b.b.a.e(15, this.tyn);
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
        bcw localbcw = (bcw)paramVarArgs[1];
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
            localbcw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbcw.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbcw.tyj = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbcw.sZx = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbcw.sNf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbcw.tyk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbcw.sNg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbcw.sNh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbcw.sNi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localbcw.tyl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 11: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aw();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbcw.sHl = ((aw)localObject1);
            paramInt += 1;
          }
        case 12: 
          localbcw.tym = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 13: 
          localbcw.kSb = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 14: 
          localbcw.kVn = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbcw.tyn = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bcw
 * JD-Core Version:    0.7.0.1
 */