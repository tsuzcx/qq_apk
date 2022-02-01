package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apb
  extends com.tencent.mm.bx.a
{
  public float GnA;
  public boolean GnB;
  public float Gnw;
  public float Gnx;
  public float Gny;
  public float Gnz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209328);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.z(1, this.Gnw);
      paramVarArgs.z(2, this.Gnx);
      paramVarArgs.z(3, this.Gny);
      paramVarArgs.z(4, this.Gnz);
      paramVarArgs.z(5, this.GnA);
      paramVarArgs.bt(6, this.GnB);
      AppMethodBeat.o(209328);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.alU(1);
      int i = f.a.a.b.b.a.alU(2);
      int j = f.a.a.b.b.a.alU(3);
      int k = f.a.a.b.b.a.alU(4);
      int m = f.a.a.b.b.a.alU(5);
      int n = f.a.a.b.b.a.alV(6);
      AppMethodBeat.o(209328);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(209328);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      apb localapb = (apb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209328);
        return -1;
      case 1: 
        localapb.Gnw = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(209328);
        return 0;
      case 2: 
        localapb.Gnx = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(209328);
        return 0;
      case 3: 
        localapb.Gny = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(209328);
        return 0;
      case 4: 
        localapb.Gnz = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(209328);
        return 0;
      case 5: 
        localapb.GnA = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(209328);
        return 0;
      }
      localapb.GnB = locala.NPN.grw();
      AppMethodBeat.o(209328);
      return 0;
    }
    AppMethodBeat.o(209328);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apb
 * JD-Core Version:    0.7.0.1
 */