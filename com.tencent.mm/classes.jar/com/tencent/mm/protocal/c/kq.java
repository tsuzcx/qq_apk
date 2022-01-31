package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class kq
  extends com.tencent.mm.bv.a
{
  public String bGw;
  public int hQs;
  public LinkedList<kw> kTw = new LinkedList();
  public int sDT;
  public long sFC;
  public int sFD;
  public LinkedList<String> sFE = new LinkedList();
  public String sFF;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sFF == null) {
        throw new b("Not all required fields were included: SearchID");
      }
      paramVarArgs.Y(1, this.sFC);
      paramVarArgs.gB(2, this.sFD);
      if (this.bGw != null) {
        paramVarArgs.d(3, this.bGw);
      }
      paramVarArgs.d(4, 1, this.sFE);
      paramVarArgs.d(5, 8, this.kTw);
      paramVarArgs.gB(6, this.hQs);
      if (this.sFF != null) {
        paramVarArgs.d(7, this.sFF);
      }
      paramVarArgs.gB(8, this.sDT);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = d.a.a.a.X(1, this.sFC) + 0 + d.a.a.a.gy(2, this.sFD);
      paramInt = i;
      if (this.bGw != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.bGw);
      }
      i = paramInt + d.a.a.a.c(4, 1, this.sFE) + d.a.a.a.c(5, 8, this.kTw) + d.a.a.a.gy(6, this.hQs);
      paramInt = i;
      if (this.sFF != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.sFF);
      }
      return paramInt + d.a.a.a.gy(8, this.sDT);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.sFE.clear();
      this.kTw.clear();
      paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      if (this.sFF == null) {
        throw new b("Not all required fields were included: SearchID");
      }
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
      kq localkq = (kq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        return -1;
      case 1: 
        localkq.sFC = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      case 2: 
        localkq.sFD = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 3: 
        localkq.bGw = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      case 4: 
        localkq.sFE.add(((d.a.a.a.a)localObject1).xpH.readString());
        return 0;
      case 5: 
        paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new kw();
          localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((kw)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
          localkq.kTw.add(localObject1);
          paramInt += 1;
        }
        return 0;
      case 6: 
        localkq.hQs = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      case 7: 
        localkq.sFF = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      localkq.sDT = ((d.a.a.a.a)localObject1).xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.kq
 * JD-Core Version:    0.7.0.1
 */