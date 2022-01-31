package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class aqf
  extends com.tencent.mm.bv.a
{
  public int bUV;
  public String tme;
  public String tmi;
  public String tmj;
  public String tmk;
  public bcs tml;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.tme == null) {
        throw new b("Not all required fields were included: session_data");
      }
      paramVarArgs.gB(1, this.bUV);
      if (this.tme != null) {
        paramVarArgs.d(2, this.tme);
      }
      if (this.tmi != null) {
        paramVarArgs.d(3, this.tmi);
      }
      if (this.tmj != null) {
        paramVarArgs.d(4, this.tmj);
      }
      if (this.tmk != null) {
        paramVarArgs.d(5, this.tmk);
      }
      if (this.tml != null)
      {
        paramVarArgs.gD(6, this.tml.btq());
        this.tml.a(paramVarArgs);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.bUV) + 0;
      paramInt = i;
      if (this.tme != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.tme);
      }
      i = paramInt;
      if (this.tmi != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tmi);
      }
      paramInt = i;
      if (this.tmj != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tmj);
      }
      i = paramInt;
      if (this.tmk != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.tmk);
      }
      paramInt = i;
    } while (this.tml == null);
    return i + d.a.a.a.gA(6, this.tml.btq());
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.tme == null) {
        throw new b("Not all required fields were included: session_data");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      aqf localaqf = (aqf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localaqf.bUV = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        localaqf.tme = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 3: 
        localaqf.tmi = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localaqf.tmj = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 5: 
        localaqf.tmk = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bcs();
        localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((bcs)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
        localaqf.tml = ((bcs)localObject1);
        paramInt += 1;
      }
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aqf
 * JD-Core Version:    0.7.0.1
 */