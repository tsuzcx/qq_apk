package com.tencent.mm.protocal.c;

public final class bse
  extends com.tencent.mm.bv.a
{
  public int actionType;
  public String bQZ;
  public String bVO;
  public String id;
  public String imV;
  public long tIP;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      paramVarArgs.Y(3, this.tIP);
      paramVarArgs.gB(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.d(6, this.title);
      }
      if (this.imV != null) {
        paramVarArgs.d(7, this.imV);
      }
      if (this.bVO != null) {
        paramVarArgs.d(8, this.bVO);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label536;
      }
    }
    label536:
    for (paramInt = d.a.a.b.b.a.e(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.bQZ != null) {
        i = paramInt + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = i + d.a.a.a.X(3, this.tIP) + d.a.a.a.gy(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(6, this.title);
      }
      paramInt = i;
      if (this.imV != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.imV);
      }
      i = paramInt;
      if (this.bVO != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.bVO);
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
        bse localbse = (bse)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbse.id = locala.xpH.readString();
          return 0;
        case 2: 
          localbse.bQZ = locala.xpH.readString();
          return 0;
        case 3: 
          localbse.tIP = locala.xpH.oE();
          return 0;
        case 4: 
          localbse.actionType = locala.xpH.oD();
          return 0;
        case 5: 
          localbse.url = locala.xpH.readString();
          return 0;
        case 6: 
          localbse.title = locala.xpH.readString();
          return 0;
        case 7: 
          localbse.imV = locala.xpH.readString();
          return 0;
        }
        localbse.bVO = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bse
 * JD-Core Version:    0.7.0.1
 */