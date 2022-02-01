package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dep
  extends com.tencent.mm.bx.a
{
  public long EvY;
  public long EvZ;
  public long Ewa;
  public double Ewb;
  public double Ewc;
  public double Ewd;
  public double Ewe;
  public long Ewf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110914);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.EvY);
      paramVarArgs.aG(2, this.EvZ);
      paramVarArgs.aG(3, this.Ewa);
      paramVarArgs.e(4, this.Ewb);
      paramVarArgs.e(5, this.Ewc);
      paramVarArgs.e(6, this.Ewd);
      paramVarArgs.e(7, this.Ewe);
      paramVarArgs.aG(8, this.Ewf);
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.q(1, this.EvY);
      int i = f.a.a.b.b.a.q(2, this.EvZ);
      int j = f.a.a.b.b.a.q(3, this.Ewa);
      int k = f.a.a.b.b.a.fY(4);
      int m = f.a.a.b.b.a.fY(5);
      int n = f.a.a.b.b.a.fY(6);
      int i1 = f.a.a.b.b.a.fY(7);
      int i2 = f.a.a.b.b.a.q(8, this.Ewf);
      AppMethodBeat.o(110914);
      return paramInt + 0 + i + j + (k + 8) + (m + 8) + (n + 8) + (i1 + 8) + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(110914);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dep localdep = (dep)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(110914);
        return -1;
      case 1: 
        localdep.EvY = locala.KhF.xT();
        AppMethodBeat.o(110914);
        return 0;
      case 2: 
        localdep.EvZ = locala.KhF.xT();
        AppMethodBeat.o(110914);
        return 0;
      case 3: 
        localdep.Ewa = locala.KhF.xT();
        AppMethodBeat.o(110914);
        return 0;
      case 4: 
        localdep.Ewb = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(110914);
        return 0;
      case 5: 
        localdep.Ewc = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(110914);
        return 0;
      case 6: 
        localdep.Ewd = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(110914);
        return 0;
      case 7: 
        localdep.Ewe = Double.longBitsToDouble(locala.KhF.fHy());
        AppMethodBeat.o(110914);
        return 0;
      }
      localdep.Ewf = locala.KhF.xT();
      AppMethodBeat.o(110914);
      return 0;
    }
    AppMethodBeat.o(110914);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dep
 * JD-Core Version:    0.7.0.1
 */