package com.tencent.mm.protocal.c;

public final class aog
  extends com.tencent.mm.bv.a
{
  public String lLj;
  public String nickname;
  public long tjV;
  public long tjW;
  public int tjX;
  public String tjY;
  public String username;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    int i;
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.tjV);
      paramVarArgs.Y(2, this.tjW);
      if (this.nickname != null) {
        paramVarArgs.d(3, this.nickname);
      }
      if (this.lLj != null) {
        paramVarArgs.d(4, this.lLj);
      }
      paramVarArgs.gB(5, this.tjX);
      if (this.username != null) {
        paramVarArgs.d(6, this.username);
      }
      if (this.tjY != null) {
        paramVarArgs.d(7, this.tjY);
      }
      i = 0;
    }
    do
    {
      return i;
      if (paramInt != 1) {
        break;
      }
      i = d.a.a.a.X(1, this.tjV) + 0 + d.a.a.a.X(2, this.tjW);
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + d.a.a.b.b.a.e(3, this.nickname);
      }
      i = paramInt;
      if (this.lLj != null) {
        i = paramInt + d.a.a.b.b.a.e(4, this.lLj);
      }
      i += d.a.a.a.gy(5, this.tjX);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + d.a.a.b.b.a.e(6, this.username);
      }
      i = paramInt;
    } while (this.tjY == null);
    return paramInt + d.a.a.b.b.a.e(7, this.tjY);
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
      aog localaog = (aog)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localaog.tjV = locala.xpH.oE();
        return 0;
      case 2: 
        localaog.tjW = locala.xpH.oE();
        return 0;
      case 3: 
        localaog.nickname = locala.xpH.readString();
        return 0;
      case 4: 
        localaog.lLj = locala.xpH.readString();
        return 0;
      case 5: 
        localaog.tjX = locala.xpH.oD();
        return 0;
      case 6: 
        localaog.username = locala.xpH.readString();
        return 0;
      }
      localaog.tjY = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.c.aog
 * JD-Core Version:    0.7.0.1
 */