package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bob
  extends com.tencent.mm.bv.a
{
  public String euK;
  public int ffh;
  public String hPY;
  public String hRf;
  public String sLD;
  public String sLE;
  public String sPp;
  public String sPq;
  public bbe tGH;
  public int tGq;
  public String tac;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.hPY != null) {
        paramVarArgs.d(1, this.hPY);
      }
      if (this.hRf != null) {
        paramVarArgs.d(2, this.hRf);
      }
      if (this.sPp != null) {
        paramVarArgs.d(3, this.sPp);
      }
      if (this.sPq != null) {
        paramVarArgs.d(4, this.sPq);
      }
      paramVarArgs.gB(5, this.ffh);
      if (this.sLD != null) {
        paramVarArgs.d(6, this.sLD);
      }
      if (this.sLE != null) {
        paramVarArgs.d(7, this.sLE);
      }
      if (this.euK != null) {
        paramVarArgs.d(8, this.euK);
      }
      paramVarArgs.gB(9, this.tGq);
      if (this.tGH != null)
      {
        paramVarArgs.gD(10, this.tGH.btq());
        this.tGH.a(paramVarArgs);
      }
      if (this.tac != null) {
        paramVarArgs.d(11, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.hPY == null) {
        break label803;
      }
    }
    label803:
    for (int i = d.a.a.b.b.a.e(1, this.hPY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hRf);
      }
      i = paramInt;
      if (this.sPp != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sPp);
      }
      paramInt = i;
      if (this.sPq != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sPq);
      }
      i = paramInt + d.a.a.a.gy(5, this.ffh);
      paramInt = i;
      if (this.sLD != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sLD);
      }
      i = paramInt;
      if (this.sLE != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sLE);
      }
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.euK);
      }
      i = paramInt + d.a.a.a.gy(9, this.tGq);
      paramInt = i;
      if (this.tGH != null) {
        paramInt = i + d.a.a.a.gA(10, this.tGH.btq());
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.tac);
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
        bob localbob = (bob)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localbob.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localbob.hRf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbob.sPp = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbob.sPq = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbob.ffh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localbob.sLD = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbob.sLE = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localbob.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 9: 
          localbob.tGq = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 10: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbe();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bbe)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localbob.tGH = ((bbe)localObject1);
            paramInt += 1;
          }
        }
        localbob.tac = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bob
 * JD-Core Version:    0.7.0.1
 */