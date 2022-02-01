package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bls
  extends com.tencent.mm.bx.a
{
  public String ZOX;
  public String ZPd;
  public int ZRL;
  public String ZSV;
  public long begin_time;
  public int status;
  public long wwF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259230);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZOX != null) {
        paramVarArgs.g(1, this.ZOX);
      }
      paramVarArgs.bv(2, this.begin_time);
      paramVarArgs.bv(3, this.wwF);
      paramVarArgs.bS(4, this.ZRL);
      if (this.ZPd != null) {
        paramVarArgs.g(5, this.ZPd);
      }
      if (this.ZSV != null) {
        paramVarArgs.g(6, this.ZSV);
      }
      paramVarArgs.bS(7, this.status);
      AppMethodBeat.o(259230);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZOX == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.b.b.a.h(1, this.ZOX) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.begin_time) + i.a.a.b.b.a.q(3, this.wwF) + i.a.a.b.b.a.cJ(4, this.ZRL);
      paramInt = i;
      if (this.ZPd != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZPd);
      }
      i = paramInt;
      if (this.ZSV != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZSV);
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.status);
      AppMethodBeat.o(259230);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259230);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        bls localbls = (bls)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259230);
          return -1;
        case 1: 
          localbls.ZOX = locala.ajGk.readString();
          AppMethodBeat.o(259230);
          return 0;
        case 2: 
          localbls.begin_time = locala.ajGk.aaw();
          AppMethodBeat.o(259230);
          return 0;
        case 3: 
          localbls.wwF = locala.ajGk.aaw();
          AppMethodBeat.o(259230);
          return 0;
        case 4: 
          localbls.ZRL = locala.ajGk.aar();
          AppMethodBeat.o(259230);
          return 0;
        case 5: 
          localbls.ZPd = locala.ajGk.readString();
          AppMethodBeat.o(259230);
          return 0;
        case 6: 
          localbls.ZSV = locala.ajGk.readString();
          AppMethodBeat.o(259230);
          return 0;
        }
        localbls.status = locala.ajGk.aar();
        AppMethodBeat.o(259230);
        return 0;
      }
      AppMethodBeat.o(259230);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bls
 * JD-Core Version:    0.7.0.1
 */