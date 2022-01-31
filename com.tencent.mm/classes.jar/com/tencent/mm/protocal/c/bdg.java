package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class bdg
  extends blm
{
  public String euK;
  public String sBi;
  public String sMg;
  public String sNf;
  public String sNg;
  public String sNh;
  public String sNi;
  
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
      if (this.sNf != null) {
        paramVarArgs.d(3, this.sNf);
      }
      if (this.sBi != null) {
        paramVarArgs.d(4, this.sBi);
      }
      if (this.sNg != null) {
        paramVarArgs.d(5, this.sNg);
      }
      if (this.sNh != null) {
        paramVarArgs.d(6, this.sNh);
      }
      if (this.sNi != null) {
        paramVarArgs.d(7, this.sNi);
      }
      if (this.sMg != null) {
        paramVarArgs.d(8, this.sMg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label662;
      }
    }
    label662:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.euK != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.euK);
      }
      i = paramInt;
      if (this.sNf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.sNf);
      }
      paramInt = i;
      if (this.sBi != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.sBi);
      }
      i = paramInt;
      if (this.sNg != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.sNg);
      }
      paramInt = i;
      if (this.sNh != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sNh);
      }
      i = paramInt;
      if (this.sNi != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sNi);
      }
      paramInt = i;
      if (this.sMg != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sMg);
      }
      return paramInt;
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
        bdg localbdg = (bdg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
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
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new gc();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((gc)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, blm.a((d.a.a.a.a)localObject2))) {}
            localbdg.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbdg.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbdg.sNf = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localbdg.sBi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbdg.sNg = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localbdg.sNh = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localbdg.sNi = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localbdg.sMg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bdg
 * JD-Core Version:    0.7.0.1
 */