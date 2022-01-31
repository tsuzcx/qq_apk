package com.tencent.mm.protocal.c;

import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class jw
  extends blm
{
  public String nzl;
  public b sEH;
  public String swc;
  public String swd;
  public String swe;
  public int swh;
  
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
      if (this.swc != null) {
        paramVarArgs.d(2, this.swc);
      }
      if (this.swd != null) {
        paramVarArgs.d(3, this.swd);
      }
      if (this.nzl != null) {
        paramVarArgs.d(4, this.nzl);
      }
      paramVarArgs.gB(5, this.swh);
      if (this.sEH != null) {
        paramVarArgs.b(6, this.sEH);
      }
      if (this.swe != null) {
        paramVarArgs.d(7, this.swe);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label588;
      }
    }
    label588:
    for (int i = d.a.a.a.gA(1, this.tEX.btq()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.swc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.swc);
      }
      i = paramInt;
      if (this.swd != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.swd);
      }
      paramInt = i;
      if (this.nzl != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.nzl);
      }
      i = paramInt + d.a.a.a.gy(5, this.swh);
      paramInt = i;
      if (this.sEH != null) {
        paramInt = i + d.a.a.a.a(6, this.sEH);
      }
      i = paramInt;
      if (this.swe != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.swe);
      }
      return i;
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
        jw localjw = (jw)paramVarArgs[1];
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
            localjw.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localjw.swc = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localjw.swd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 4: 
          localjw.nzl = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localjw.swh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localjw.sEH = ((d.a.a.a.a)localObject1).cUs();
          return 0;
        }
        localjw.swe = ((d.a.a.a.a)localObject1).xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.jw
 * JD-Core Version:    0.7.0.1
 */