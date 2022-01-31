package com.tencent.mm.protocal.c;

public final class la
  extends com.tencent.mm.bv.a
{
  public String bVO;
  public String qEu;
  public String qwq;
  public String sGf;
  public String sGg;
  public int sGh;
  public String title;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.type);
      if (this.qEu != null) {
        paramVarArgs.d(2, this.qEu);
      }
      if (this.bVO != null) {
        paramVarArgs.d(3, this.bVO);
      }
      if (this.title != null) {
        paramVarArgs.d(4, this.title);
      }
      if (this.qwq != null) {
        paramVarArgs.d(5, this.qwq);
      }
      if (this.url != null) {
        paramVarArgs.d(6, this.url);
      }
      if (this.sGf != null) {
        paramVarArgs.d(7, this.sGf);
      }
      if (this.sGg != null) {
        paramVarArgs.d(8, this.sGg);
      }
      paramVarArgs.gB(9, this.sGh);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = d.a.a.a.gy(1, this.type) + 0;
      paramInt = i;
      if (this.qEu != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.qEu);
      }
      i = paramInt;
      if (this.bVO != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.bVO);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.title);
      }
      i = paramInt;
      if (this.qwq != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.qwq);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.url);
      }
      i = paramInt;
      if (this.sGf != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sGf);
      }
      paramInt = i;
      if (this.sGg != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.sGg);
      }
      return paramInt + d.a.a.a.gy(9, this.sGh);
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
      la localla = (la)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localla.type = locala.xpH.oD();
        return 0;
      case 2: 
        localla.qEu = locala.xpH.readString();
        return 0;
      case 3: 
        localla.bVO = locala.xpH.readString();
        return 0;
      case 4: 
        localla.title = locala.xpH.readString();
        return 0;
      case 5: 
        localla.qwq = locala.xpH.readString();
        return 0;
      case 6: 
        localla.url = locala.xpH.readString();
        return 0;
      case 7: 
        localla.sGf = locala.xpH.readString();
        return 0;
      case 8: 
        localla.sGg = locala.xpH.readString();
        return 0;
      }
      localla.sGh = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.la
 * JD-Core Version:    0.7.0.1
 */