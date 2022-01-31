package com.tencent.mm.plugin.wallet.a;

public final class n
  extends com.tencent.mm.bv.a
{
  public String dTJ;
  public String desc;
  public String id;
  public String name;
  public String qkP;
  public String qls;
  public String qlt;
  public String qlu = "0";
  public String qlv = "0";
  public int qlw = 0;
  public int qlx;
  public String qly;
  public int status;
  public int type;
  public String url;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.d(1, this.id);
      }
      if (this.name != null) {
        paramVarArgs.d(2, this.name);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      paramVarArgs.gB(4, this.status);
      if (this.url != null) {
        paramVarArgs.d(5, this.url);
      }
      paramVarArgs.gB(6, this.type);
      if (this.qls != null) {
        paramVarArgs.d(7, this.qls);
      }
      if (this.qlt != null) {
        paramVarArgs.d(8, this.qlt);
      }
      if (this.qlu != null) {
        paramVarArgs.d(9, this.qlu);
      }
      if (this.qlv != null) {
        paramVarArgs.d(10, this.qlv);
      }
      paramVarArgs.gB(11, this.qlw);
      if (this.qkP != null) {
        paramVarArgs.d(12, this.qkP);
      }
      if (this.dTJ != null) {
        paramVarArgs.d(13, this.dTJ);
      }
      paramVarArgs.gB(14, this.qlx);
      if (this.qly != null) {
        paramVarArgs.d(15, this.qly);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label905;
      }
    }
    label905:
    for (int i = d.a.a.b.b.a.e(1, this.id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.name != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.name);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.desc);
      }
      i += d.a.a.a.gy(4, this.status);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.url);
      }
      i = paramInt + d.a.a.a.gy(6, this.type);
      paramInt = i;
      if (this.qls != null) {
        paramInt = i + d.a.a.b.b.a.e(7, this.qls);
      }
      i = paramInt;
      if (this.qlt != null) {
        i = paramInt + d.a.a.b.b.a.e(8, this.qlt);
      }
      paramInt = i;
      if (this.qlu != null) {
        paramInt = i + d.a.a.b.b.a.e(9, this.qlu);
      }
      i = paramInt;
      if (this.qlv != null) {
        i = paramInt + d.a.a.b.b.a.e(10, this.qlv);
      }
      i += d.a.a.a.gy(11, this.qlw);
      paramInt = i;
      if (this.qkP != null) {
        paramInt = i + d.a.a.b.b.a.e(12, this.qkP);
      }
      i = paramInt;
      if (this.dTJ != null) {
        i = paramInt + d.a.a.b.b.a.e(13, this.dTJ);
      }
      i += d.a.a.a.gy(14, this.qlx);
      paramInt = i;
      if (this.qly != null) {
        paramInt = i + d.a.a.b.b.a.e(15, this.qly);
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
        n localn = (n)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localn.id = locala.xpH.readString();
          return 0;
        case 2: 
          localn.name = locala.xpH.readString();
          return 0;
        case 3: 
          localn.desc = locala.xpH.readString();
          return 0;
        case 4: 
          localn.status = locala.xpH.oD();
          return 0;
        case 5: 
          localn.url = locala.xpH.readString();
          return 0;
        case 6: 
          localn.type = locala.xpH.oD();
          return 0;
        case 7: 
          localn.qls = locala.xpH.readString();
          return 0;
        case 8: 
          localn.qlt = locala.xpH.readString();
          return 0;
        case 9: 
          localn.qlu = locala.xpH.readString();
          return 0;
        case 10: 
          localn.qlv = locala.xpH.readString();
          return 0;
        case 11: 
          localn.qlw = locala.xpH.oD();
          return 0;
        case 12: 
          localn.qkP = locala.xpH.readString();
          return 0;
        case 13: 
          localn.dTJ = locala.xpH.readString();
          return 0;
        case 14: 
          localn.qlx = locala.xpH.oD();
          return 0;
        }
        localn.qly = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.n
 * JD-Core Version:    0.7.0.1
 */