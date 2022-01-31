package com.tencent.mm.protocal.b.a;

public final class d
  extends com.tencent.mm.bv.a
{
  public int bWN;
  public String desc;
  public String kdm;
  public String thumbPath;
  public String title;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.thumbPath != null) {
        paramVarArgs.d(3, this.thumbPath);
      }
      paramVarArgs.gB(4, this.bWN);
      if (this.kdm != null) {
        paramVarArgs.d(5, this.kdm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label383;
      }
    }
    label383:
    for (int i = d.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.thumbPath != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.thumbPath);
      }
      i += d.a.a.a.gy(4, this.bWN);
      paramInt = i;
      if (this.kdm != null) {
        paramInt = i + d.a.a.b.b.a.e(5, this.kdm);
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
        d locald = (d)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          locald.title = locala.xpH.readString();
          return 0;
        case 2: 
          locald.desc = locala.xpH.readString();
          return 0;
        case 3: 
          locald.thumbPath = locala.xpH.readString();
          return 0;
        case 4: 
          locald.bWN = locala.xpH.oD();
          return 0;
        }
        locald.kdm = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.b.a.d
 * JD-Core Version:    0.7.0.1
 */