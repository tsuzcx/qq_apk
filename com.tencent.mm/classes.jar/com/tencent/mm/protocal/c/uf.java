package com.tencent.mm.protocal.c;

import java.util.LinkedList;

public final class uf
  extends blm
{
  public String euK;
  public String euN;
  public String hPY;
  public int hQR;
  public int ndf;
  public int ndg;
  public int ndh;
  public long ndp;
  public String sQY;
  public int sQZ;
  public int sRa;
  public int swP;
  
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
      if (this.euK != null) {
        paramVarArgs.d(2, this.euK);
      }
      paramVarArgs.gB(3, this.swP);
      if (this.euN != null) {
        paramVarArgs.d(4, this.euN);
      }
      if (this.hPY != null) {
        paramVarArgs.d(5, this.hPY);
      }
      paramVarArgs.gB(6, this.ndf);
      paramVarArgs.gB(7, this.ndg);
      paramVarArgs.gB(8, this.ndh);
      if (this.sQY != null) {
        paramVarArgs.d(9, this.sQY);
      }
      paramVarArgs.gB(10, this.sQZ);
      paramVarArgs.gB(11, this.hQR);
      paramVarArgs.gB(12, this.sRa);
      paramVarArgs.Y(13, this.ndp);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tEX == null) {
        break label809;
      }
    }
    label809:
    for (paramInt = d.a.a.a.gA(1, this.tEX.btq()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.euK != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.euK);
      }
      i += d.a.a.a.gy(3, this.swP);
      paramInt = i;
      if (this.euN != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.euN);
      }
      i = paramInt;
      if (this.hPY != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.hPY);
      }
      i = i + d.a.a.a.gy(6, this.ndf) + d.a.a.a.gy(7, this.ndg) + d.a.a.a.gy(8, this.ndh);
      paramInt = i;
      if (this.sQY != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.sQY);
      }
      return paramInt + d.a.a.a.gy(10, this.sQZ) + d.a.a.a.gy(11, this.hQR) + d.a.a.a.gy(12, this.sRa) + d.a.a.a.X(13, this.ndp);
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
        uf localuf = (uf)paramVarArgs[1];
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
            localuf.tEX = ((gc)localObject1);
            paramInt += 1;
          }
        case 2: 
          localuf.euK = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 3: 
          localuf.swP = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 4: 
          localuf.euN = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 5: 
          localuf.hPY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 6: 
          localuf.ndf = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 7: 
          localuf.ndg = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 8: 
          localuf.ndh = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 9: 
          localuf.sQY = ((d.a.a.a.a)localObject1).xpH.readString();
          return 0;
        case 10: 
          localuf.sQZ = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 11: 
          localuf.hQR = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        case 12: 
          localuf.sRa = ((d.a.a.a.a)localObject1).xpH.oD();
          return 0;
        }
        localuf.ndp = ((d.a.a.a.a)localObject1).xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.uf
 * JD-Core Version:    0.7.0.1
 */