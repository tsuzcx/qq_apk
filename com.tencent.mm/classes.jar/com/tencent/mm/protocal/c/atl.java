package com.tencent.mm.protocal.c;

public final class atl
  extends com.tencent.mm.bv.a
{
  public String ioI;
  public double latitude;
  public double longitude;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.b(1, this.latitude);
      paramVarArgs.b(2, this.longitude);
      if (this.ioI != null) {
        paramVarArgs.d(3, this.ioI);
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
      i = d.a.a.b.b.a.dQ(1) + 8 + 0 + (d.a.a.b.b.a.dQ(2) + 8);
      paramInt = i;
    } while (this.ioI == null);
    return i + d.a.a.b.b.a.e(3, this.ioI);
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
      atl localatl = (atl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localatl.latitude = locala.xpH.readDouble();
        return 0;
      case 2: 
        localatl.longitude = locala.xpH.readDouble();
        return 0;
      }
      localatl.ioI = locala.xpH.readString();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.c.atl
 * JD-Core Version:    0.7.0.1
 */