package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class qg
  extends com.tencent.mm.bv.a
{
  public int hQW;
  public int jwX;
  public LinkedList<ass> kTw = new LinkedList();
  public int sAl;
  public String sEc;
  public String sEd;
  public String sEe;
  public String sEf;
  public String sEg;
  public int sNU;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.jwX);
      if (this.sEe != null) {
        paramVarArgs.d(7, this.sEe);
      }
      paramVarArgs.gB(2, this.sAl);
      paramVarArgs.gB(3, this.sNU);
      paramVarArgs.d(4, 8, this.kTw);
      if (this.sEc != null) {
        paramVarArgs.d(5, this.sEc);
      }
      if (this.sEd != null) {
        paramVarArgs.d(6, this.sEd);
      }
      if (this.sEf != null) {
        paramVarArgs.d(8, this.sEf);
      }
      if (this.sEg != null) {
        paramVarArgs.d(9, this.sEg);
      }
      paramVarArgs.gB(10, this.hQW);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.gy(1, this.jwX) + 0;
      paramInt = i;
      if (this.sEe != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sEe);
      }
      i = paramInt + d.a.a.a.gy(2, this.sAl) + d.a.a.a.gy(3, this.sNU) + d.a.a.a.c(4, 8, this.kTw);
      paramInt = i;
      if (this.sEc != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.sEc);
      }
      i = paramInt;
      if (this.sEd != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.sEd);
      }
      paramInt = i;
      if (this.sEf != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sEf);
      }
      i = paramInt;
      if (this.sEg != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sEg);
      }
      return i + d.a.a.a.gy(10, this.hQW);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.kTw.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      qg localqg = (qg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localqg.jwX = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localqg.sEe = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 2: 
        localqg.sAl = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localqg.sNU = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 4: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ass();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ass)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localqg.kTw.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 5: 
        localqg.sEc = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 6: 
        localqg.sEd = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 8: 
        localqg.sEf = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 9: 
        localqg.sEg = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localqg.hQW = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.qg
 * JD-Core Version:    0.7.0.1
 */