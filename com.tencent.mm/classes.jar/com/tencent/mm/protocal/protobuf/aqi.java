package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqi
  extends com.tencent.mm.bx.a
{
  public float Goq;
  public float Gor;
  public int Gos;
  public float dAp;
  public float dyz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(8, this.dAp);
      paramVarArgs.z(9, this.dyz);
      paramVarArgs.z(10, this.Goq);
      paramVarArgs.z(11, this.Gor);
      paramVarArgs.aS(12, this.Gos);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(8);
      int i = f.a.a.b.b.a.alU(9);
      int j = f.a.a.b.b.a.alU(10);
      int k = f.a.a.b.b.a.alU(11);
      int m = f.a.a.b.b.a.bz(12, this.Gos);
      AppMethodBeat.o(169035);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqi localaqi = (aqi)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localaqi.dAp = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localaqi.dyz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localaqi.Goq = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localaqi.Gor = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(169035);
        return 0;
      }
      localaqi.Gos = locala.NPN.zc();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqi
 * JD-Core Version:    0.7.0.1
 */