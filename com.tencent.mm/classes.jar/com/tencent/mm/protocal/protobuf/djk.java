package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djk
  extends com.tencent.mm.bx.a
{
  public String COu;
  public int GdN;
  public long Hym;
  public boolean Hyn;
  public LinkedList<String> Hyo;
  public LinkedList<String> Hyp;
  public int xyZ;
  
  public djk()
  {
    AppMethodBeat.i(118452);
    this.Hyo = new LinkedList();
    this.Hyp = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.Hym);
      paramVarArgs.aS(2, this.xyZ);
      paramVarArgs.aS(3, this.GdN);
      paramVarArgs.bt(4, this.Hyn);
      paramVarArgs.e(5, 1, this.Hyo);
      paramVarArgs.e(6, 1, this.Hyp);
      if (this.COu != null) {
        paramVarArgs.d(7, this.COu);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.p(1, this.Hym) + 0 + f.a.a.b.b.a.bz(2, this.xyZ) + f.a.a.b.b.a.bz(3, this.GdN) + f.a.a.b.b.a.alV(4) + f.a.a.a.c(5, 1, this.Hyo) + f.a.a.a.c(6, 1, this.Hyp);
      paramInt = i;
      if (this.COu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.COu);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hyo.clear();
      this.Hyp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      djk localdjk = (djk)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localdjk.Hym = locala.NPN.zd();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localdjk.xyZ = locala.NPN.zc();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localdjk.GdN = locala.NPN.zc();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localdjk.Hyn = locala.NPN.grw();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localdjk.Hyo.add(locala.NPN.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localdjk.Hyp.add(locala.NPN.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localdjk.COu = locala.NPN.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djk
 * JD-Core Version:    0.7.0.1
 */