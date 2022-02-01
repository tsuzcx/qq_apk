package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class afo
  extends com.tencent.mm.bx.a
{
  public String YzM;
  public long ZnD;
  public boolean ZoE;
  public String ZoF;
  public int Zox;
  public boolean Zoy;
  public int Zoz;
  public String token;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259889);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.ZnD);
      if (this.YzM != null) {
        paramVarArgs.g(2, this.YzM);
      }
      paramVarArgs.bS(3, this.Zox);
      paramVarArgs.di(4, this.ZoE);
      paramVarArgs.di(5, this.Zoy);
      paramVarArgs.bS(6, this.Zoz);
      if (this.ZoF != null) {
        paramVarArgs.g(7, this.ZoF);
      }
      if (this.token != null) {
        paramVarArgs.g(8, this.token);
      }
      AppMethodBeat.o(259889);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.ZnD) + 0;
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YzM);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Zox) + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1) + i.a.a.b.b.a.cJ(6, this.Zoz);
      paramInt = i;
      if (this.ZoF != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZoF);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.token);
      }
      AppMethodBeat.o(259889);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259889);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      afo localafo = (afo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259889);
        return -1;
      case 1: 
        localafo.ZnD = locala.ajGk.aaw();
        AppMethodBeat.o(259889);
        return 0;
      case 2: 
        localafo.YzM = locala.ajGk.readString();
        AppMethodBeat.o(259889);
        return 0;
      case 3: 
        localafo.Zox = locala.ajGk.aar();
        AppMethodBeat.o(259889);
        return 0;
      case 4: 
        localafo.ZoE = locala.ajGk.aai();
        AppMethodBeat.o(259889);
        return 0;
      case 5: 
        localafo.Zoy = locala.ajGk.aai();
        AppMethodBeat.o(259889);
        return 0;
      case 6: 
        localafo.Zoz = locala.ajGk.aar();
        AppMethodBeat.o(259889);
        return 0;
      case 7: 
        localafo.ZoF = locala.ajGk.readString();
        AppMethodBeat.o(259889);
        return 0;
      }
      localafo.token = locala.ajGk.readString();
      AppMethodBeat.o(259889);
      return 0;
    }
    AppMethodBeat.o(259889);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afo
 * JD-Core Version:    0.7.0.1
 */