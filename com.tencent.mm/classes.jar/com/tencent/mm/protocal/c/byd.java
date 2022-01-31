package com.tencent.mm.protocal.c;

public final class byd
  extends com.tencent.mm.bv.a
{
  public String bVO;
  public String bVP;
  public int cCu;
  public long eCv;
  public int qTU;
  public int qUS;
  public int qUT;
  public int qUU;
  public long tOh;
  public int tOi;
  public long tOj;
  public String text;
  public int type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.bVP != null) {
        paramVarArgs.d(1, this.bVP);
      }
      paramVarArgs.gB(2, this.qUS);
      paramVarArgs.gB(3, this.qUT);
      paramVarArgs.Y(4, this.eCv);
      paramVarArgs.gB(5, this.qTU);
      paramVarArgs.gB(6, this.type);
      if (this.text != null) {
        paramVarArgs.d(7, this.text);
      }
      if (this.bVO != null) {
        paramVarArgs.d(8, this.bVO);
      }
      paramVarArgs.Y(9, this.tOh);
      paramVarArgs.gB(10, this.qUU);
      paramVarArgs.gB(11, this.tOi);
      paramVarArgs.Y(12, this.tOj);
      paramVarArgs.gB(13, this.cCu);
      return 0;
    }
    if (paramInt == 1) {
      if (this.bVP == null) {
        break label675;
      }
    }
    label675:
    for (paramInt = d.a.a.b.b.a.e(1, this.bVP) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.qUS) + d.a.a.a.gy(3, this.qUT) + d.a.a.a.X(4, this.eCv) + d.a.a.a.gy(5, this.qTU) + d.a.a.a.gy(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.text);
      }
      i = paramInt;
      if (this.bVO != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.bVO);
      }
      return i + d.a.a.a.X(9, this.tOh) + d.a.a.a.gy(10, this.qUU) + d.a.a.a.gy(11, this.tOi) + d.a.a.a.X(12, this.tOj) + d.a.a.a.gy(13, this.cCu);
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
        byd localbyd = (byd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbyd.bVP = locala.xpH.readString();
          return 0;
        case 2: 
          localbyd.qUS = locala.xpH.oD();
          return 0;
        case 3: 
          localbyd.qUT = locala.xpH.oD();
          return 0;
        case 4: 
          localbyd.eCv = locala.xpH.oE();
          return 0;
        case 5: 
          localbyd.qTU = locala.xpH.oD();
          return 0;
        case 6: 
          localbyd.type = locala.xpH.oD();
          return 0;
        case 7: 
          localbyd.text = locala.xpH.readString();
          return 0;
        case 8: 
          localbyd.bVO = locala.xpH.readString();
          return 0;
        case 9: 
          localbyd.tOh = locala.xpH.oE();
          return 0;
        case 10: 
          localbyd.qUU = locala.xpH.oD();
          return 0;
        case 11: 
          localbyd.tOi = locala.xpH.oD();
          return 0;
        case 12: 
          localbyd.tOj = locala.xpH.oE();
          return 0;
        }
        localbyd.cCu = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.c.byd
 * JD-Core Version:    0.7.0.1
 */