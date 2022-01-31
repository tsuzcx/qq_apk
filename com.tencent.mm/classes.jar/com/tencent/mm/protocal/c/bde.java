package com.tencent.mm.protocal.c;

public final class bde
  extends com.tencent.mm.bv.a
{
  public String bQZ;
  public String bVO;
  public String qEu;
  public String qwq;
  public long qxK;
  public long qxL;
  public long qxM;
  public int qxN;
  public int qxO;
  public long qxP;
  public String qxy;
  public String title;
  public String type;
  public String tyt;
  public String tyu;
  public String tyv;
  public int tyw;
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
      if (this.qxy != null) {
        paramVarArgs.d(5, this.qxy);
      }
      if (this.tyt != null) {
        paramVarArgs.d(6, this.tyt);
      }
      if (this.type != null) {
        paramVarArgs.d(7, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.Y(9, this.qxK);
      paramVarArgs.Y(10, this.qxL);
      if (this.qwq != null) {
        paramVarArgs.d(11, this.qwq);
      }
      paramVarArgs.Y(12, this.qxM);
      paramVarArgs.gB(13, this.qxN);
      paramVarArgs.gB(14, this.qxO);
      if (this.tyu != null) {
        paramVarArgs.d(15, this.tyu);
      }
      if (this.tyv != null) {
        paramVarArgs.d(16, this.tyv);
      }
      paramVarArgs.Y(17, this.qxP);
      paramVarArgs.gB(18, this.tyw);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label1018;
      }
    }
    label1018:
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
      if (this.qxy != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.qxy);
      }
      paramInt = i;
      if (this.tyt != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.tyt);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.type);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + d.a.a.a.X(9, this.qxK) + d.a.a.a.X(10, this.qxL);
      paramInt = i;
      if (this.qwq != null) {
        paramInt = i + d.a.a.b.b.a.e(11, this.qwq);
      }
      i = paramInt + d.a.a.a.X(12, this.qxM) + d.a.a.a.gy(13, this.qxN) + d.a.a.a.gy(14, this.qxO);
      paramInt = i;
      if (this.tyu != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.tyu);
      }
      i = paramInt;
      if (this.tyv != null) {
        i = paramInt + d.a.a.b.b.a.e(16, this.tyv);
      }
      return i + d.a.a.a.X(17, this.qxP) + d.a.a.a.gy(18, this.tyw);
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
        bde localbde = (bde)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbde.url = locala.xpH.readString();
          return 0;
        case 2: 
          localbde.bQZ = locala.xpH.readString();
          return 0;
        case 3: 
          localbde.bVO = locala.xpH.readString();
          return 0;
        case 4: 
          localbde.qEu = locala.xpH.readString();
          return 0;
        case 5: 
          localbde.qxy = locala.xpH.readString();
          return 0;
        case 6: 
          localbde.tyt = locala.xpH.readString();
          return 0;
        case 7: 
          localbde.type = locala.xpH.readString();
          return 0;
        case 8: 
          localbde.title = locala.xpH.readString();
          return 0;
        case 9: 
          localbde.qxK = locala.xpH.oE();
          return 0;
        case 10: 
          localbde.qxL = locala.xpH.oE();
          return 0;
        case 11: 
          localbde.qwq = locala.xpH.readString();
          return 0;
        case 12: 
          localbde.qxM = locala.xpH.oE();
          return 0;
        case 13: 
          localbde.qxN = locala.xpH.oD();
          return 0;
        case 14: 
          localbde.qxO = locala.xpH.oD();
          return 0;
        case 15: 
          localbde.tyu = locala.xpH.readString();
          return 0;
        case 16: 
          localbde.tyv = locala.xpH.readString();
          return 0;
        case 17: 
          localbde.qxP = locala.xpH.oE();
          return 0;
        }
        localbde.tyw = locala.xpH.oD();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bde
 * JD-Core Version:    0.7.0.1
 */