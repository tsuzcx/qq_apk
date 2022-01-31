package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class acs
  extends blm
{
  public String ivF;
  public String quW;
  public String sEy;
  public String sPM;
  public String signature;
  public String tbv;
  public String tbw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sPM == null) {
        throw new b("Not all required fields were included: corp_id");
      }
      if (this.tbv == null) {
        throw new b("Not all required fields were included: group_id");
      }
      if (this.quW == null) {
        throw new b("Not all required fields were included: time_stamp");
      }
      if (this.ivF == null) {
        throw new b("Not all required fields were included: nonce_str");
      }
      if (this.signature == null) {
        throw new b("Not all required fields were included: signature");
      }
      if (this.sEy == null) {
        throw new b("Not all required fields were included: from_url");
      }
      if (this.tEX != null)
      {
        paramVarArgs.gD(1, this.tEX.btq());
        this.tEX.a(paramVarArgs);
      }
      if (this.sPM != null) {
        paramVarArgs.d(2, this.sPM);
      }
      if (this.tbv != null) {
        paramVarArgs.d(3, this.tbv);
      }
      if (this.quW != null) {
        paramVarArgs.d(4, this.quW);
      }
      if (this.ivF != null) {
        paramVarArgs.d(5, this.ivF);
      }
      if (this.signature != null) {
        paramVarArgs.d(6, this.signature);
      }
      if (this.sEy != null) {
        paramVarArgs.d(7, this.sEy);
      }
      if (this.tbw != null) {
        paramVarArgs.d(8, this.tbw);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label866;
      }
    }
    label866:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sPM != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.sPM);
      }
      i = paramInt;
      if (this.tbv != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tbv);
      }
      paramInt = i;
      if (this.quW != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.quW);
      }
      i = paramInt;
      if (this.ivF != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.ivF);
      }
      paramInt = i;
      if (this.signature != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.signature);
      }
      i = paramInt;
      if (this.sEy != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sEy);
      }
      paramInt = i;
      if (this.tbw != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.tbw);
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
        if (this.sPM == null) {
          throw new b("Not all required fields were included: corp_id");
        }
        if (this.tbv == null) {
          throw new b("Not all required fields were included: group_id");
        }
        if (this.quW == null) {
          throw new b("Not all required fields were included: time_stamp");
        }
        if (this.ivF == null) {
          throw new b("Not all required fields were included: nonce_str");
        }
        if (this.signature == null) {
          throw new b("Not all required fields were included: signature");
        }
        if (this.sEy != null) {
          break;
        }
        throw new b("Not all required fields were included: from_url");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        acs localacs = (acs)paramVarArgs[1];
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
            localacs.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localacs.sPM = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localacs.tbv = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localacs.quW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localacs.ivF = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localacs.signature = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localacs.sEy = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localacs.tbw = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.acs
 * JD-Core Version:    0.7.0.1
 */