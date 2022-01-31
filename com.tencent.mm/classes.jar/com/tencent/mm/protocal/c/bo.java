package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bo
  extends blm
{
  public String bOL;
  public String fileid;
  public String nickname;
  public b svj;
  public int svk;
  
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
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.svj != null) {
        paramVarArgs.b(3, this.svj);
      }
      if (this.fileid != null) {
        paramVarArgs.d(4, this.fileid);
      }
      paramVarArgs.gB(5, this.svk);
      if (this.bOL != null) {
        paramVarArgs.d(6, this.bOL);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label529;
      }
    }
    label529:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.svj != null) {
        i = paramInt + d.a.a.a.a(3, this.svj);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.fileid);
      }
      i = paramInt + d.a.a.a.gy(5, this.svk);
      paramInt = i;
      if (this.bOL != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.bOL);
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
        bo localbo = (bo)paramVarArgs[1];
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
            localbo.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localbo.nickname = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localbo.svj = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        case 4: 
          localbo.fileid = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localbo.svk = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localbo.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bo
 * JD-Core Version:    0.7.0.1
 */