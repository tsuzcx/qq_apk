package com.tencent.mm.protocal.c;

public final class az
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String bVO;
  public String qEu;
  public int qEv;
  public String qhq;
  public String qhr;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.d(1, this.url);
      }
      if (this.bQZ != null) {
        paramVarArgs.d(2, this.bQZ);
      }
      if (this.bVO != null) {
        paramVarArgs.d(3, this.bVO);
      }
      if (this.qEu != null) {
        paramVarArgs.d(4, this.qEu);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.qhq != null) {
        paramVarArgs.d(6, this.qhq);
      }
      if (this.qhr != null) {
        paramVarArgs.d(7, this.qhr);
      }
      paramVarArgs.gB(8, this.qEv);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label552;
      }
    }
    label552:
    for (int i = d.a.a.b.b.a.e(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.bQZ != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.bQZ);
      }
      i = paramInt;
      if (this.bVO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bVO);
      }
      paramInt = i;
      if (this.qEu != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.qEu);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.qhq != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.qhq);
      }
      i = paramInt;
      if (this.qhr != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.qhr);
      }
      return i + d.a.a.a.gy(8, this.qEv);
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
        az localaz = (az)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localaz.url = locala.xpH.readString();
          return 0;
        case 2: 
          localaz.bQZ = locala.xpH.readString();
          return 0;
        case 3: 
          localaz.bVO = locala.xpH.readString();
          return 0;
        case 4: 
          localaz.qEu = locala.xpH.readString();
          return 0;
        case 5: 
          localaz.title = locala.xpH.readString();
          return 0;
        case 6: 
          localaz.qhq = locala.xpH.readString();
          return 0;
        case 7: 
          localaz.qhr = locala.xpH.readString();
          return 0;
        }
        localaz.qEv = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.az
 * JD-Core Version:    0.7.0.1
 */