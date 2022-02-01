package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ald
  extends com.tencent.mm.bw.a
{
  public boolean BLF;
  public String BOA;
  public boolean BOx;
  public boolean BOy;
  public String BOz;
  public boolean Gvu;
  public LinkedList<Integer> Luc;
  public boolean Lud;
  public String Lue;
  public int Luf;
  public long duration;
  public int hDa;
  public int iTg;
  
  public ald()
  {
    AppMethodBeat.i(75026);
    this.Luc = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.duration);
      paramVarArgs.e(2, 2, this.Luc);
      paramVarArgs.aM(3, this.iTg);
      paramVarArgs.cc(4, this.Lud);
      paramVarArgs.cc(5, this.Gvu);
      paramVarArgs.cc(6, this.BOx);
      paramVarArgs.cc(7, this.BOy);
      if (this.BOz != null) {
        paramVarArgs.e(8, this.BOz);
      }
      if (this.BOA != null) {
        paramVarArgs.e(9, this.BOA);
      }
      if (this.Lue != null) {
        paramVarArgs.e(10, this.Lue);
      }
      paramVarArgs.cc(11, this.BLF);
      paramVarArgs.aM(12, this.Luf);
      paramVarArgs.aM(13, this.hDa);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.duration) + 0 + g.a.a.a.c(2, 2, this.Luc) + g.a.a.b.b.a.bu(3, this.iTg) + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1) + (g.a.a.b.b.a.fS(6) + 1) + (g.a.a.b.b.a.fS(7) + 1);
      paramInt = i;
      if (this.BOz != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.BOz);
      }
      i = paramInt;
      if (this.BOA != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.BOA);
      }
      paramInt = i;
      if (this.Lue != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.Lue);
      }
      i = g.a.a.b.b.a.fS(11);
      int j = g.a.a.b.b.a.bu(12, this.Luf);
      int k = g.a.a.b.b.a.bu(13, this.hDa);
      AppMethodBeat.o(75027);
      return paramInt + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Luc.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ald localald = (ald)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localald.duration = locala.UbS.zl();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localald.Luc.add(Integer.valueOf(locala.UbS.zi()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localald.iTg = locala.UbS.zi();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localald.Lud = locala.UbS.yZ();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localald.Gvu = locala.UbS.yZ();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localald.BOx = locala.UbS.yZ();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localald.BOy = locala.UbS.yZ();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localald.BOz = locala.UbS.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localald.BOA = locala.UbS.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localald.Lue = locala.UbS.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localald.BLF = locala.UbS.yZ();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localald.Luf = locala.UbS.zi();
        AppMethodBeat.o(75027);
        return 0;
      }
      localald.hDa = locala.UbS.zi();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */