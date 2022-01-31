package com.tencent.mm.protocal.c;

public final class anv
  extends com.tencent.mm.bv.a
{
  public String hPY;
  public String hRf;
  public String sAZ;
  public int sze;
  public String tac;
  public String tjQ;
  public String tjR;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.sAZ != null) {
        paramVarArgs.d(1, this.sAZ);
      }
      if (this.hPY != null) {
        paramVarArgs.d(2, this.hPY);
      }
      if (this.tjQ != null) {
        paramVarArgs.d(3, this.tjQ);
      }
      if (this.tjR != null) {
        paramVarArgs.d(4, this.tjR);
      }
      paramVarArgs.gB(5, this.sze);
      if (this.hRf != null) {
        paramVarArgs.d(6, this.hRf);
      }
      if (this.tac != null) {
        paramVarArgs.d(7, this.tac);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.sAZ == null) {
        break label497;
      }
    }
    label497:
    for (int i = d.a.a.b.b.a.e(1, this.sAZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hPY != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.hPY);
      }
      i = paramInt;
      if (this.tjQ != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tjQ);
      }
      paramInt = i;
      if (this.tjR != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.tjR);
      }
      i = paramInt + d.a.a.a.gy(5, this.sze);
      paramInt = i;
      if (this.hRf != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.hRf);
      }
      i = paramInt;
      if (this.tac != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.tac);
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.cUt();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
        anv localanv = (anv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localanv.sAZ = locala.xpH.readString();
          return 0;
        case 2: 
          localanv.hPY = locala.xpH.readString();
          return 0;
        case 3: 
          localanv.tjQ = locala.xpH.readString();
          return 0;
        case 4: 
          localanv.tjR = locala.xpH.readString();
          return 0;
        case 5: 
          localanv.sze = locala.xpH.oD();
          return 0;
        case 6: 
          localanv.hRf = locala.xpH.readString();
          return 0;
        }
        localanv.tac = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.c.anv
 * JD-Core Version:    0.7.0.1
 */