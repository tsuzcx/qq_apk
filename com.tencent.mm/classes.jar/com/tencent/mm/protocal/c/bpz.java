package com.tencent.mm.protocal.c;

public final class bpz
  extends com.tencent.mm.bv.a
{
  public String nickname;
  public boolean tHz;
  public String tgf;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.d(1, this.username);
      }
      paramVarArgs.aA(2, this.tHz);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.tgf != null) {
        paramVarArgs.d(4, this.tgf);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label321;
      }
    }
    label321:
    for (paramInt = d.a.a.b.b.a.e(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + (d.a.a.b.b.a.dQ(2) + 1);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.tgf != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.tgf);
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
        bpz localbpz = (bpz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          return -1;
        case 1: 
          localbpz.username = locala.xpH.readString();
          return 0;
        case 2: 
          localbpz.tHz = locala.cUr();
          return 0;
        case 3: 
          localbpz.nickname = locala.xpH.readString();
          return 0;
        }
        localbpz.tgf = locala.xpH.readString();
        return 0;
      }
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.c.bpz
 * JD-Core Version:    0.7.0.1
 */