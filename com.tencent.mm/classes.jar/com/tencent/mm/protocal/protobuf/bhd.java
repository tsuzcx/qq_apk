package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class bhd
  extends com.tencent.mm.bw.a
{
  public String LQV;
  public String LQW;
  public b LQX;
  public String UserName;
  public int him;
  public String jfi;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(223886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.xut != null) {
        paramVarArgs.e(1, this.xut);
      }
      if (this.LQV != null) {
        paramVarArgs.e(2, this.LQV);
      }
      if (this.LQW != null) {
        paramVarArgs.e(3, this.LQW);
      }
      paramVarArgs.aM(4, this.him);
      if (this.LQX != null) {
        paramVarArgs.c(5, this.LQX);
      }
      if (this.jfi != null) {
        paramVarArgs.e(6, this.jfi);
      }
      if (this.UserName != null) {
        paramVarArgs.e(7, this.UserName);
      }
      AppMethodBeat.o(223886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xut == null) {
        break label562;
      }
    }
    label562:
    for (int i = g.a.a.b.b.a.f(1, this.xut) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LQV != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LQV);
      }
      i = paramInt;
      if (this.LQW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LQW);
      }
      i += g.a.a.b.b.a.bu(4, this.him);
      paramInt = i;
      if (this.LQX != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.LQX);
      }
      i = paramInt;
      if (this.jfi != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.jfi);
      }
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.UserName);
      }
      AppMethodBeat.o(223886);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(223886);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        bhd localbhd = (bhd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(223886);
          return -1;
        case 1: 
          localbhd.xut = locala.UbS.readString();
          AppMethodBeat.o(223886);
          return 0;
        case 2: 
          localbhd.LQV = locala.UbS.readString();
          AppMethodBeat.o(223886);
          return 0;
        case 3: 
          localbhd.LQW = locala.UbS.readString();
          AppMethodBeat.o(223886);
          return 0;
        case 4: 
          localbhd.him = locala.UbS.zi();
          AppMethodBeat.o(223886);
          return 0;
        case 5: 
          localbhd.LQX = locala.UbS.hPo();
          AppMethodBeat.o(223886);
          return 0;
        case 6: 
          localbhd.jfi = locala.UbS.readString();
          AppMethodBeat.o(223886);
          return 0;
        }
        localbhd.UserName = locala.UbS.readString();
        AppMethodBeat.o(223886);
        return 0;
      }
      AppMethodBeat.o(223886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhd
 * JD-Core Version:    0.7.0.1
 */