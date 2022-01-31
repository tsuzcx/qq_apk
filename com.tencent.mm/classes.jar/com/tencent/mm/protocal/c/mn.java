package com.tencent.mm.protocal.c;

public class mn
  extends com.tencent.mm.bv.a
{
  public String iQn;
  public String ilq;
  public String ioU;
  public String sIf;
  public String sIg;
  public long sJq;
  public String sJr;
  public String sJs;
  public String title;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.ilq != null) {
        paramVarArgs.d(2, this.ilq);
      }
      if (this.ioU != null) {
        paramVarArgs.d(3, this.ioU);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      paramVarArgs.Y(5, this.sJq);
      if (this.sJr != null) {
        paramVarArgs.d(6, this.sJr);
      }
      if (this.sJs != null) {
        paramVarArgs.d(7, this.sJs);
      }
      if (this.iQn != null) {
        paramVarArgs.d(8, this.iQn);
      }
      if (this.sIf != null) {
        paramVarArgs.d(9, this.sIf);
      }
      if (this.sIg != null) {
        paramVarArgs.d(10, this.sIg);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label666;
      }
    }
    label666:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ilq != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.ilq);
      }
      i = paramInt;
      if (this.ioU != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.ioU);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt + d.a.a.a.X(5, this.sJq);
      paramInt = i;
      if (this.sJr != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.sJr);
      }
      i = paramInt;
      if (this.sJs != null) {
        i = paramInt + d.a.a.b.b.a.e(7, this.sJs);
      }
      paramInt = i;
      if (this.iQn != null) {
        paramInt = i + d.a.a.b.b.a.e(8, this.iQn);
      }
      i = paramInt;
      if (this.sIf != null) {
        i = paramInt + d.a.a.b.b.a.e(9, this.sIf);
      }
      paramInt = i;
      if (this.sIg != null) {
        paramInt = i + d.a.a.b.b.a.e(10, this.sIg);
      }
      return paramInt;
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
        mn localmn = (mn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localmn.title = locala.xpH.readString();
          return 0;
        case 2: 
          localmn.ilq = locala.xpH.readString();
          return 0;
        case 3: 
          localmn.ioU = locala.xpH.readString();
          return 0;
        case 4: 
          localmn.url = locala.xpH.readString();
          return 0;
        case 5: 
          localmn.sJq = locala.xpH.oE();
          return 0;
        case 6: 
          localmn.sJr = locala.xpH.readString();
          return 0;
        case 7: 
          localmn.sJs = locala.xpH.readString();
          return 0;
        case 8: 
          localmn.iQn = locala.xpH.readString();
          return 0;
        case 9: 
          localmn.sIf = locala.xpH.readString();
          return 0;
        }
        localmn.sIg = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.mn
 * JD-Core Version:    0.7.0.1
 */