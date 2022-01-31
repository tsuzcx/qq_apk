package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class cby
  extends com.tencent.mm.bv.a
{
  public int apptype;
  public String bOL;
  public String dRQ;
  public String ioU;
  public LinkedList<cbz> tRc = new LinkedList();
  public String tRd;
  public int tRe;
  public int tua;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bOL != null) {
        paramVarArgs.d(1, this.bOL);
      }
      if (this.dRQ != null) {
        paramVarArgs.d(2, this.dRQ);
      }
      paramVarArgs.gB(3, this.apptype);
      paramVarArgs.d(4, 8, this.tRc);
      paramVarArgs.gB(5, this.tua);
      if (this.tRd != null) {
        paramVarArgs.d(6, this.tRd);
      }
      if (this.ioU != null) {
        paramVarArgs.d(7, this.ioU);
      }
      paramVarArgs.gB(8, this.tRe);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bOL == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = d.a.a.b.b.a.e(1, this.bOL) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dRQ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.dRQ);
      }
      i = i + d.a.a.a.gy(3, this.apptype) + d.a.a.a.c(4, 8, this.tRc) + d.a.a.a.gy(5, this.tua);
      paramInt = i;
      if (this.tRd != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tRd);
      }
      i = paramInt;
      if (this.ioU != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.ioU);
      }
      return i + d.a.a.a.gy(8, this.tRe);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tRc.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (d.a.a.a.a)paramVarArgs[0];
        cby localcby = (cby)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          localcby.bOL = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 2: 
          localcby.dRQ = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localcby.apptype = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          paramVarArgs = ((d.a.a.a.a)localObject1).KN(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbz();
            localObject2 = new d.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cbz)localObject1).a((d.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.a((d.a.a.a.a)localObject2))) {}
            localcby.tRc.add(localObject1);
            paramInt += 1;
          }
        case 5: 
          localcby.tua = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 6: 
          localcby.tRd = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 7: 
          localcby.ioU = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        }
        localcby.tRe = ((d.a.a.a.a)localObject1).xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.cby
 * JD-Core Version:    0.7.0.1
 */