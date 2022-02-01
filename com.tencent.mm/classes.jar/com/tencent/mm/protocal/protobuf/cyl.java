package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyl
  extends com.tencent.mm.bx.a
{
  public int Ddh;
  public boolean EqA;
  public LinkedList<String> EqB;
  public LinkedList<String> EqC;
  public long Eqz;
  public int viz;
  public String zVL;
  
  public cyl()
  {
    AppMethodBeat.i(118452);
    this.EqB = new LinkedList();
    this.EqC = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Eqz);
      paramVarArgs.aR(2, this.viz);
      paramVarArgs.aR(3, this.Ddh);
      paramVarArgs.bg(4, this.EqA);
      paramVarArgs.e(5, 1, this.EqB);
      paramVarArgs.e(6, 1, this.EqC);
      if (this.zVL != null) {
        paramVarArgs.d(7, this.zVL);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.q(1, this.Eqz) + 0 + f.a.a.b.b.a.bA(2, this.viz) + f.a.a.b.b.a.bA(3, this.Ddh) + (f.a.a.b.b.a.fY(4) + 1) + f.a.a.a.c(5, 1, this.EqB) + f.a.a.a.c(6, 1, this.EqC);
      paramInt = i;
      if (this.zVL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.zVL);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EqB.clear();
      this.EqC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cyl localcyl = (cyl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localcyl.Eqz = locala.KhF.xT();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localcyl.viz = locala.KhF.xS();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localcyl.Ddh = locala.KhF.xS();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localcyl.EqA = locala.KhF.fHu();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localcyl.EqB.add(locala.KhF.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localcyl.EqC.add(locala.KhF.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localcyl.zVL = locala.KhF.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyl
 * JD-Core Version:    0.7.0.1
 */