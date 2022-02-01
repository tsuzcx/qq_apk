package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class dqb
  extends com.tencent.mm.bw.a
{
  public String MSX;
  public String MSY;
  public b MSZ;
  public long MTa;
  public String MTb;
  public String MTc;
  public String MTd;
  public String Title;
  public String Username;
  public int rBX;
  public String xut;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MSY != null) {
        paramVarArgs.e(1, this.MSY);
      }
      if (this.Username != null) {
        paramVarArgs.e(2, this.Username);
      }
      if (this.xut != null) {
        paramVarArgs.e(3, this.xut);
      }
      paramVarArgs.aM(4, this.rBX);
      if (this.MSZ != null) {
        paramVarArgs.c(5, this.MSZ);
      }
      if (this.Title != null) {
        paramVarArgs.e(6, this.Title);
      }
      if (this.MSX != null) {
        paramVarArgs.e(7, this.MSX);
      }
      paramVarArgs.bb(8, this.MTa);
      if (this.MTb != null) {
        paramVarArgs.e(9, this.MTb);
      }
      if (this.MTc != null) {
        paramVarArgs.e(10, this.MTc);
      }
      if (this.MTd != null) {
        paramVarArgs.e(11, this.MTd);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MSY == null) {
        break label794;
      }
    }
    label794:
    for (int i = g.a.a.b.b.a.f(1, this.MSY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Username);
      }
      i = paramInt;
      if (this.xut != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.xut);
      }
      i += g.a.a.b.b.a.bu(4, this.rBX);
      paramInt = i;
      if (this.MSZ != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.MSZ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Title);
      }
      paramInt = i;
      if (this.MSX != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.MSX);
      }
      i = paramInt + g.a.a.b.b.a.r(8, this.MTa);
      paramInt = i;
      if (this.MTb != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.MTb);
      }
      i = paramInt;
      if (this.MTc != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.MTc);
      }
      paramInt = i;
      if (this.MTd != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.MTd);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        dqb localdqb = (dqb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localdqb.MSY = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localdqb.Username = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localdqb.xut = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localdqb.rBX = locala.UbS.zi();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localdqb.MSZ = locala.UbS.hPo();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localdqb.Title = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localdqb.MSX = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localdqb.MTa = locala.UbS.zl();
          AppMethodBeat.o(181512);
          return 0;
        case 9: 
          localdqb.MTb = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 10: 
          localdqb.MTc = locala.UbS.readString();
          AppMethodBeat.o(181512);
          return 0;
        }
        localdqb.MTd = locala.UbS.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dqb
 * JD-Core Version:    0.7.0.1
 */