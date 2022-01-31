package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class caj
  extends blm
{
  public int aQw;
  public int sEr;
  public int scene;
  public String session_id;
  public int tPF;
  public int tPG;
  public int tPH;
  public String username;
  
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
      paramVarArgs.gB(2, this.scene);
      paramVarArgs.gB(3, this.tPF);
      paramVarArgs.gB(4, this.sEr);
      paramVarArgs.gB(5, this.tPG);
      paramVarArgs.gB(6, this.tPH);
      if (this.username != null) {
        paramVarArgs.d(7, this.username);
      }
      paramVarArgs.gB(8, this.aQw);
      if (this.session_id != null) {
        paramVarArgs.d(9, this.session_id);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label617;
      }
    }
    label617:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.scene) + d.a.a.a.gy(3, this.tPF) + d.a.a.a.gy(4, this.sEr) + d.a.a.a.gy(5, this.tPG) + d.a.a.a.gy(6, this.tPH);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.username);
      }
      i = paramInt + d.a.a.a.gy(8, this.aQw);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.session_id);
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
        caj localcaj = (caj)paramVarArgs[1];
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
            localcaj.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localcaj.scene = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 3: 
          localcaj.tPF = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localcaj.sEr = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 5: 
          localcaj.tPG = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcaj.tPH = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localcaj.username = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 8: 
          localcaj.aQw = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localcaj.session_id = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.caj
 * JD-Core Version:    0.7.0.1
 */