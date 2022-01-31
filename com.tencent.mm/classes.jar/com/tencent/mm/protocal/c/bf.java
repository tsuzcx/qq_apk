package com.tencent.mm.protocal.c;

public final class bf
  extends com.tencent.mm.bv.a
{
  public long endTime;
  public int okK;
  public int okL;
  public long startTime;
  public float suM;
  public float suN;
  public float suO;
  public long suP;
  public long suQ;
  public long suR;
  public long suS;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.okK);
      paramVarArgs.gB(2, this.okL);
      paramVarArgs.m(3, this.suM);
      paramVarArgs.m(4, this.suN);
      paramVarArgs.m(5, this.suO);
      paramVarArgs.Y(6, this.startTime);
      paramVarArgs.Y(7, this.endTime);
      paramVarArgs.Y(8, this.suP);
      paramVarArgs.Y(9, this.suQ);
      paramVarArgs.Y(10, this.suR);
      paramVarArgs.Y(11, this.suS);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.okK) + 0 + d.a.a.a.gy(2, this.okL) + (d.a.a.b.b.a.dQ(3) + 4) + (d.a.a.b.b.a.dQ(4) + 4) + (d.a.a.b.b.a.dQ(5) + 4) + d.a.a.a.X(6, this.startTime) + d.a.a.a.X(7, this.endTime) + d.a.a.a.X(8, this.suP) + d.a.a.a.X(9, this.suQ) + d.a.a.a.X(10, this.suR) + d.a.a.a.X(11, this.suS);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      bf localbf = (bf)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localbf.okK = locala.xpH.oD();
        return 0;
      case 2: 
        localbf.okL = locala.xpH.oD();
        return 0;
      case 3: 
        localbf.suM = locala.xpH.readFloat();
        return 0;
      case 4: 
        localbf.suN = locala.xpH.readFloat();
        return 0;
      case 5: 
        localbf.suO = locala.xpH.readFloat();
        return 0;
      case 6: 
        localbf.startTime = locala.xpH.oE();
        return 0;
      case 7: 
        localbf.endTime = locala.xpH.oE();
        return 0;
      case 8: 
        localbf.suP = locala.xpH.oE();
        return 0;
      case 9: 
        localbf.suQ = locala.xpH.oE();
        return 0;
      case 10: 
        localbf.suR = locala.xpH.oE();
        return 0;
      }
      localbf.suS = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bf
 * JD-Core Version:    0.7.0.1
 */