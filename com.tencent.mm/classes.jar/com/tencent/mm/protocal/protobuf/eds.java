package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eds
  extends com.tencent.mm.bw.a
{
  public int BOX;
  public String HIK;
  public int Lsa;
  public long NdZ;
  public boolean Nea;
  public LinkedList<String> Neb;
  public LinkedList<String> Nec;
  
  public eds()
  {
    AppMethodBeat.i(118452);
    this.Neb = new LinkedList();
    this.Nec = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NdZ);
      paramVarArgs.aM(2, this.BOX);
      paramVarArgs.aM(3, this.Lsa);
      paramVarArgs.cc(4, this.Nea);
      paramVarArgs.e(5, 1, this.Neb);
      paramVarArgs.e(6, 1, this.Nec);
      if (this.HIK != null) {
        paramVarArgs.e(7, this.HIK);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.r(1, this.NdZ) + 0 + g.a.a.b.b.a.bu(2, this.BOX) + g.a.a.b.b.a.bu(3, this.Lsa) + (g.a.a.b.b.a.fS(4) + 1) + g.a.a.a.c(5, 1, this.Neb) + g.a.a.a.c(6, 1, this.Nec);
      paramInt = i;
      if (this.HIK != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HIK);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Neb.clear();
      this.Nec.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      eds localeds = (eds)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localeds.NdZ = locala.UbS.zl();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localeds.BOX = locala.UbS.zi();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localeds.Lsa = locala.UbS.zi();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localeds.Nea = locala.UbS.yZ();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localeds.Neb.add(locala.UbS.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localeds.Nec.add(locala.UbS.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localeds.HIK = locala.UbS.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eds
 * JD-Core Version:    0.7.0.1
 */