package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apu
  extends com.tencent.mm.bx.a
{
  public boolean Bvd;
  public long Zxa;
  public String Zxb;
  public long Zxc;
  public long Zxd;
  public String Zxe;
  public String Zxf;
  public int Zxg;
  public String Zxh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259379);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(5, this.Zxa);
      if (this.Zxb != null) {
        paramVarArgs.g(6, this.Zxb);
      }
      paramVarArgs.bv(10, this.Zxc);
      paramVarArgs.bv(11, this.Zxd);
      if (this.Zxe != null) {
        paramVarArgs.g(12, this.Zxe);
      }
      if (this.Zxf != null) {
        paramVarArgs.g(13, this.Zxf);
      }
      paramVarArgs.bS(16, this.Zxg);
      if (this.Zxh != null) {
        paramVarArgs.g(17, this.Zxh);
      }
      paramVarArgs.di(18, this.Bvd);
      AppMethodBeat.o(259379);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(5, this.Zxa) + 0;
      paramInt = i;
      if (this.Zxb != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zxb);
      }
      i = paramInt + i.a.a.b.b.a.q(10, this.Zxc) + i.a.a.b.b.a.q(11, this.Zxd);
      paramInt = i;
      if (this.Zxe != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Zxe);
      }
      i = paramInt;
      if (this.Zxf != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.Zxf);
      }
      i += i.a.a.b.b.a.cJ(16, this.Zxg);
      paramInt = i;
      if (this.Zxh != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.Zxh);
      }
      i = i.a.a.b.b.a.ko(18);
      AppMethodBeat.o(259379);
      return paramInt + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259379);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      apu localapu = (apu)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 7: 
      case 8: 
      case 9: 
      case 14: 
      case 15: 
      default: 
        AppMethodBeat.o(259379);
        return -1;
      case 5: 
        localapu.Zxa = locala.ajGk.aaw();
        AppMethodBeat.o(259379);
        return 0;
      case 6: 
        localapu.Zxb = locala.ajGk.readString();
        AppMethodBeat.o(259379);
        return 0;
      case 10: 
        localapu.Zxc = locala.ajGk.aaw();
        AppMethodBeat.o(259379);
        return 0;
      case 11: 
        localapu.Zxd = locala.ajGk.aaw();
        AppMethodBeat.o(259379);
        return 0;
      case 12: 
        localapu.Zxe = locala.ajGk.readString();
        AppMethodBeat.o(259379);
        return 0;
      case 13: 
        localapu.Zxf = locala.ajGk.readString();
        AppMethodBeat.o(259379);
        return 0;
      case 16: 
        localapu.Zxg = locala.ajGk.aar();
        AppMethodBeat.o(259379);
        return 0;
      case 17: 
        localapu.Zxh = locala.ajGk.readString();
        AppMethodBeat.o(259379);
        return 0;
      }
      localapu.Bvd = locala.ajGk.aai();
      AppMethodBeat.o(259379);
      return 0;
    }
    AppMethodBeat.o(259379);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apu
 * JD-Core Version:    0.7.0.1
 */