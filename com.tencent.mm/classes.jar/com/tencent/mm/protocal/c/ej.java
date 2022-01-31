package com.tencent.mm.protocal.c;

import d.a.a.b;
import java.util.LinkedList;

public final class ej
  extends com.tencent.mm.bv.a
{
  public String bJY;
  public String ePP;
  public String evK;
  public LinkedList<String> sxW = new LinkedList();
  public long sxX;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.ePP == null) {
        throw new b("Not all required fields were included: roomname");
      }
      if (this.ePP != null) {
        paramVarArgs.d(1, this.ePP);
      }
      if (this.bJY != null) {
        paramVarArgs.d(2, this.bJY);
      }
      if (this.evK != null) {
        paramVarArgs.d(3, this.evK);
      }
      paramVarArgs.d(4, 1, this.sxW);
      paramVarArgs.Y(5, this.sxX);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ePP == null) {
        break label411;
      }
    }
    label411:
    for (int i = d.a.a.b.b.a.e(1, this.ePP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bJY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bJY);
      }
      i = paramInt;
      if (this.evK != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.evK);
      }
      return i + d.a.a.a.c(4, 1, this.sxW) + d.a.a.a.X(5, this.sxX);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.sxW.clear();
        paramVarArgs = new d.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        if (this.ePP != null) {
          break;
        }
        throw new b("Not all required fields were included: roomname");
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        ej localej = (ej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localej.ePP = locala.xpH.readString();
          return 0;
        case 2: 
          localej.bJY = locala.xpH.readString();
          return 0;
        case 3: 
          localej.evK = locala.xpH.readString();
          return 0;
        case 4: 
          localej.sxW.add(locala.xpH.readString());
          return 0;
        }
        localej.sxX = locala.xpH.oE();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.ej
 * JD-Core Version:    0.7.0.1
 */