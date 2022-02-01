package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afl
  extends com.tencent.mm.bx.a
{
  public String ZoA;
  public LinkedList<String> Zow;
  public int Zox;
  public boolean Zoy;
  public int Zoz;
  public String token;
  
  public afl()
  {
    AppMethodBeat.i(259827);
    this.Zow = new LinkedList();
    AppMethodBeat.o(259827);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259831);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.Zow);
      paramVarArgs.bS(2, this.Zox);
      paramVarArgs.di(3, this.Zoy);
      paramVarArgs.bS(4, this.Zoz);
      if (this.ZoA != null) {
        paramVarArgs.g(5, this.ZoA);
      }
      if (this.token != null) {
        paramVarArgs.g(6, this.token);
      }
      AppMethodBeat.o(259831);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.a.c(1, 1, this.Zow) + 0 + i.a.a.b.b.a.cJ(2, this.Zox) + (i.a.a.b.b.a.ko(3) + 1) + i.a.a.b.b.a.cJ(4, this.Zoz);
      paramInt = i;
      if (this.ZoA != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZoA);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.token);
      }
      AppMethodBeat.o(259831);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zow.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259831);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afl localafl = (afl)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259831);
        return -1;
      case 1: 
        localafl.Zow.add(locala.ajGk.readString());
        AppMethodBeat.o(259831);
        return 0;
      case 2: 
        localafl.Zox = locala.ajGk.aar();
        AppMethodBeat.o(259831);
        return 0;
      case 3: 
        localafl.Zoy = locala.ajGk.aai();
        AppMethodBeat.o(259831);
        return 0;
      case 4: 
        localafl.Zoz = locala.ajGk.aar();
        AppMethodBeat.o(259831);
        return 0;
      case 5: 
        localafl.ZoA = locala.ajGk.readString();
        AppMethodBeat.o(259831);
        return 0;
      }
      localafl.token = locala.ajGk.readString();
      AppMethodBeat.o(259831);
      return 0;
    }
    AppMethodBeat.o(259831);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afl
 * JD-Core Version:    0.7.0.1
 */