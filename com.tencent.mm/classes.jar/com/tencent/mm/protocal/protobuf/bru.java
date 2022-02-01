package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bru
  extends com.tencent.mm.bw.a
{
  public String DZy;
  public int EnO;
  public String Fhd;
  public String Fhe;
  public String type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116340);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fhd != null) {
        paramVarArgs.d(1, this.Fhd);
      }
      if (this.DZy != null) {
        paramVarArgs.d(2, this.DZy);
      }
      if (this.type != null) {
        paramVarArgs.d(3, this.type);
      }
      paramVarArgs.aR(4, this.EnO);
      if (this.Fhe != null) {
        paramVarArgs.d(5, this.Fhe);
      }
      AppMethodBeat.o(116340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fhd == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.Fhd) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DZy);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.type);
      }
      i += f.a.a.b.b.a.bx(4, this.EnO);
      paramInt = i;
      if (this.Fhe != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fhe);
      }
      AppMethodBeat.o(116340);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116340);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bru localbru = (bru)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(116340);
          return -1;
        case 1: 
          localbru.Fhd = locala.LVo.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 2: 
          localbru.DZy = locala.LVo.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 3: 
          localbru.type = locala.LVo.readString();
          AppMethodBeat.o(116340);
          return 0;
        case 4: 
          localbru.EnO = locala.LVo.xF();
          AppMethodBeat.o(116340);
          return 0;
        }
        localbru.Fhe = locala.LVo.readString();
        AppMethodBeat.o(116340);
        return 0;
      }
      AppMethodBeat.o(116340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bru
 * JD-Core Version:    0.7.0.1
 */