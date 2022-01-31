package com.tencent.mm.protocal.c;

public final class azp
  extends com.tencent.mm.bv.a
{
  public String desc;
  public int id;
  public String nickname;
  public String tgf;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.id);
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.tgf != null) {
        paramVarArgs.d(3, this.tgf);
      }
      if (this.desc != null) {
        paramVarArgs.d(4, this.desc);
      }
      paramInt = 0;
    }
    int i;
    do
    {
      return paramInt;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.gy(1, this.id) + 0;
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.tgf != null) {
        i = paramInt + d.a.a.b.b.a.e(3, this.tgf);
      }
      paramInt = i;
    } while (this.desc == null);
    return i + d.a.a.b.b.a.e(4, this.desc);
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
      azp localazp = (azp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localazp.id = locala.xpH.oD();
        return 0;
      case 2: 
        localazp.nickname = locala.xpH.readString();
        return 0;
      case 3: 
        localazp.tgf = locala.xpH.readString();
        return 0;
      }
      localazp.desc = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.c.azp
 * JD-Core Version:    0.7.0.1
 */