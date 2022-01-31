package com.tencent.mm.protocal.c;

public final class fs
  extends com.tencent.mm.bv.a
{
  public int qho;
  public String qhp;
  public String qhq;
  public String qhr;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.gB(2, this.qho);
      if (this.qhp != null) {
        paramVarArgs.d(3, this.qhp);
      }
      if (this.qhq != null) {
        paramVarArgs.d(4, this.qhq);
      }
      if (this.qhr != null) {
        paramVarArgs.d(5, this.qhr);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label383;
      }
    }
    label383:
    for (paramInt = d.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + d.a.a.a.gy(2, this.qho);
      paramInt = i;
      if (this.qhp != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.qhp);
      }
      i = paramInt;
      if (this.qhq != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.qhq);
      }
      paramInt = i;
      if (this.qhr != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.qhr);
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
        fs localfs = (fs)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localfs.title = locala.xpH.readString();
          return 0;
        case 2: 
          localfs.qho = locala.xpH.oD();
          return 0;
        case 3: 
          localfs.qhp = locala.xpH.readString();
          return 0;
        case 4: 
          localfs.qhq = locala.xpH.readString();
          return 0;
        }
        localfs.qhr = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.c.fs
 * JD-Core Version:    0.7.0.1
 */