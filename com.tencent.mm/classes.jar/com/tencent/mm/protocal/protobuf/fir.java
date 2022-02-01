package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fir
  extends com.tencent.mm.bx.a
{
  public int NID;
  public String VpP;
  public int Ztm;
  public LinkedList<String> abJA;
  public long abJx;
  public boolean abJy;
  public LinkedList<String> abJz;
  
  public fir()
  {
    AppMethodBeat.i(118452);
    this.abJz = new LinkedList();
    this.abJA = new LinkedList();
    AppMethodBeat.o(118452);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118453);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.abJx);
      paramVarArgs.bS(2, this.NID);
      paramVarArgs.bS(3, this.Ztm);
      paramVarArgs.di(4, this.abJy);
      paramVarArgs.e(5, 1, this.abJz);
      paramVarArgs.e(6, 1, this.abJA);
      if (this.VpP != null) {
        paramVarArgs.g(7, this.VpP);
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.abJx) + 0 + i.a.a.b.b.a.cJ(2, this.NID) + i.a.a.b.b.a.cJ(3, this.Ztm) + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.a.c(5, 1, this.abJz) + i.a.a.a.c(6, 1, this.abJA);
      paramInt = i;
      if (this.VpP != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.VpP);
      }
      AppMethodBeat.o(118453);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abJz.clear();
      this.abJA.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(118453);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fir localfir = (fir)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(118453);
        return -1;
      case 1: 
        localfir.abJx = locala.ajGk.aaw();
        AppMethodBeat.o(118453);
        return 0;
      case 2: 
        localfir.NID = locala.ajGk.aar();
        AppMethodBeat.o(118453);
        return 0;
      case 3: 
        localfir.Ztm = locala.ajGk.aar();
        AppMethodBeat.o(118453);
        return 0;
      case 4: 
        localfir.abJy = locala.ajGk.aai();
        AppMethodBeat.o(118453);
        return 0;
      case 5: 
        localfir.abJz.add(locala.ajGk.readString());
        AppMethodBeat.o(118453);
        return 0;
      case 6: 
        localfir.abJA.add(locala.ajGk.readString());
        AppMethodBeat.o(118453);
        return 0;
      }
      localfir.VpP = locala.ajGk.readString();
      AppMethodBeat.o(118453);
      return 0;
    }
    AppMethodBeat.o(118453);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fir
 * JD-Core Version:    0.7.0.1
 */