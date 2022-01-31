package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class un
  extends blm
{
  public String bOL;
  public String bVk;
  public String key;
  public int scene;
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
      if (this.key != null) {
        paramVarArgs.d(2, this.key);
      }
      if (this.bOL != null) {
        paramVarArgs.d(3, this.bOL);
      }
      if (this.bVk != null) {
        paramVarArgs.d(4, this.bVk);
      }
      paramVarArgs.gB(5, this.scene);
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label532;
      }
    }
    label532:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.key != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.key);
      }
      i = paramInt;
      if (this.bOL != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bOL);
      }
      paramInt = i;
      if (this.bVk != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.bVk);
      }
      i = paramInt + d.a.a.a.gy(5, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.url);
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
        un localun = (un)paramVarArgs[1];
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
            localun.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localun.key = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localun.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localun.bVk = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localun.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localun.url = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.un
 * JD-Core Version:    0.7.0.1
 */