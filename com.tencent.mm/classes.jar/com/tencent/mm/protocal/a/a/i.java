package com.tencent.mm.protocal.a.a;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class i
  extends com.tencent.mm.bv.a
{
  public int sqK;
  public int sqM;
  public LinkedList<e> sqN = new LinkedList();
  public b sqO;
  public int sqw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.sqw);
      paramVarArgs.gB(2, this.sqM);
      paramVarArgs.gB(3, this.sqK);
      paramVarArgs.d(4, 8, this.sqN);
      if (this.sqO != null) {
        paramVarArgs.b(5, this.sqO);
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
      i = d.a.a.a.gy(1, this.sqw) + 0 + d.a.a.a.gy(2, this.sqM) + d.a.a.a.gy(3, this.sqK) + d.a.a.a.c(4, 8, this.sqN);
      paramInt = i;
    } while (this.sqO == null);
    return i + d.a.a.a.a(5, this.sqO);
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sqN.clear();
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
      i locali = (i)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        locali.sqw = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 2: 
        locali.sqM = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        locali.sqK = ((d.a.a.a.a)localObject1).xpH.oD();
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
          locali.sqN.add(localObject1);
          paramInt += 1;
        }
        return 0;
      }
      locali.sqO = ((d.a.a.a.a)localObject1).cUs();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.i
 * JD-Core Version:    0.7.0.1
 */