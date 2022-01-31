package com.tencent.mm.plugin.o.a;

public final class b
  extends com.tencent.mm.bv.a
{
  public String cCt;
  public int lnP;
  public String lnQ;
  public String lnR;
  public String lnS;
  public String lnT;
  public String lnU;
  public String lnV;
  public String lnW;
  public String lnX;
  public String lnY;
  public String title;
  public String type;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.lnP);
      if (this.type != null) {
        paramVarArgs.d(2, this.type);
      }
      if (this.title != null) {
        paramVarArgs.d(3, this.title);
      }
      if (this.lnQ != null) {
        paramVarArgs.d(4, this.lnQ);
      }
      if (this.lnR != null) {
        paramVarArgs.d(5, this.lnR);
      }
      if (this.lnS != null) {
        paramVarArgs.d(6, this.lnS);
      }
      if (this.lnT != null) {
        paramVarArgs.d(7, this.lnT);
      }
      if (this.lnU != null) {
        paramVarArgs.d(8, this.lnU);
      }
      if (this.lnV != null) {
        paramVarArgs.d(9, this.lnV);
      }
      if (this.lnW != null) {
        paramVarArgs.d(10, this.lnW);
      }
      if (this.cCt != null) {
        paramVarArgs.d(11, this.cCt);
      }
      if (this.lnX != null) {
        paramVarArgs.d(12, this.lnX);
      }
      if (this.lnY != null) {
        paramVarArgs.d(13, this.lnY);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.lnP) + 0;
      paramInt = i;
      if (this.type != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.type);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.title);
      }
      paramInt = i;
      if (this.lnQ != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.lnQ);
      }
      i = paramInt;
      if (this.lnR != null) {
        i = paramInt + d.a.a.b.b.a.e(5, this.lnR);
      }
      paramInt = i;
      if (this.lnS != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.lnS);
      }
      i = paramInt;
      if (this.lnT != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.lnT);
      }
      paramInt = i;
      if (this.lnU != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.lnU);
      }
      i = paramInt;
      if (this.lnV != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.lnV);
      }
      paramInt = i;
      if (this.lnW != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.lnW);
      }
      i = paramInt;
      if (this.cCt != null) {
        i = paramInt + d.a.a.b.b.a.e(11, this.cCt);
      }
      paramInt = i;
      if (this.lnX != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.lnX);
      }
      i = paramInt;
    } while (this.lnY == null);
    return paramInt + d.a.a.b.b.a.e(13, this.lnY);
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
      b localb = (b)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localb.lnP = locala.xpH.oD();
        return 0;
      case 2: 
        localb.type = locala.xpH.readString();
        return 0;
      case 3: 
        localb.title = locala.xpH.readString();
        return 0;
      case 4: 
        localb.lnQ = locala.xpH.readString();
        return 0;
      case 5: 
        localb.lnR = locala.xpH.readString();
        return 0;
      case 6: 
        localb.lnS = locala.xpH.readString();
        return 0;
      case 7: 
        localb.lnT = locala.xpH.readString();
        return 0;
      case 8: 
        localb.lnU = locala.xpH.readString();
        return 0;
      case 9: 
        localb.lnV = locala.xpH.readString();
        return 0;
      case 10: 
        localb.lnW = locala.xpH.readString();
        return 0;
      case 11: 
        localb.cCt = locala.xpH.readString();
        return 0;
      case 12: 
        localb.lnX = locala.xpH.readString();
        return 0;
      }
      localb.lnY = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.o.a.b
 * JD-Core Version:    0.7.0.1
 */