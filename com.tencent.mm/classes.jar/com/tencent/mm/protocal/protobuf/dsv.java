package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dsv
  extends com.tencent.mm.bw.a
{
  public int MUW;
  public int MUX;
  public String MUh;
  public String ThumbUrl;
  public String UserName;
  public String hik;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187886);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.e(1, this.UserName);
      }
      if (this.MUh != null) {
        paramVarArgs.e(2, this.MUh);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      if (this.hik != null) {
        paramVarArgs.e(4, this.hik);
      }
      paramVarArgs.aM(5, this.MUW);
      paramVarArgs.aM(6, this.MUX);
      AppMethodBeat.o(187886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label486;
      }
    }
    label486:
    for (int i = g.a.a.b.b.a.f(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MUh != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MUh);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.hik != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hik);
      }
      i = g.a.a.b.b.a.bu(5, this.MUW);
      int j = g.a.a.b.b.a.bu(6, this.MUX);
      AppMethodBeat.o(187886);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187886);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dsv localdsv = (dsv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187886);
          return -1;
        case 1: 
          localdsv.UserName = locala.UbS.readString();
          AppMethodBeat.o(187886);
          return 0;
        case 2: 
          localdsv.MUh = locala.UbS.readString();
          AppMethodBeat.o(187886);
          return 0;
        case 3: 
          localdsv.ThumbUrl = locala.UbS.readString();
          AppMethodBeat.o(187886);
          return 0;
        case 4: 
          localdsv.hik = locala.UbS.readString();
          AppMethodBeat.o(187886);
          return 0;
        case 5: 
          localdsv.MUW = locala.UbS.zi();
          AppMethodBeat.o(187886);
          return 0;
        }
        localdsv.MUX = locala.UbS.zi();
        AppMethodBeat.o(187886);
        return 0;
      }
      AppMethodBeat.o(187886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsv
 * JD-Core Version:    0.7.0.1
 */