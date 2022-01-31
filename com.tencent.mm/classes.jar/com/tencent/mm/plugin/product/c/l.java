package com.tencent.mm.plugin.product.c;

import d.a.a.b;
import java.util.LinkedList;

public class l
  extends com.tencent.mm.bv.a
{
  public String mSW;
  public int mSX;
  public LinkedList<e> mSY = new LinkedList();
  public int mSs;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.mSW == null) {
        throw new b("Not all required fields were included: id_info");
      }
      if (this.mSW != null) {
        paramVarArgs.d(1, this.mSW);
      }
      paramVarArgs.gB(2, this.mSX);
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      paramVarArgs.d(4, 8, this.mSY);
      paramVarArgs.gB(5, this.mSs);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mSW == null) {
        break label477;
      }
    }
    label477:
    for (paramInt = d.a.a.b.b.a.e(1, this.mSW) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.mSX);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.url);
      }
      return paramInt + d.a.a.a.c(4, 8, this.mSY) + d.a.a.a.gy(5, this.mSs);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.mSY.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.mSW != null) {
          break;
        }
        throw new b("Not all required fields were included: id_info");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        l locall = (l)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          locall.mSW = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          locall.mSX = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          locall.url = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new e();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((e)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            locall.mSY.add(localObject1);
            paramInt += 1;
          }
        }
        locall.mSs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.c.l
 * JD-Core Version:    0.7.0.1
 */