package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class crg
  extends com.tencent.mm.bw.a
{
  public String FDX;
  public String FDY;
  public b FDZ;
  public long FEa;
  public String FEb;
  public String Title;
  public String Username;
  public int pAS;
  public String tlT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181512);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FDY != null) {
        paramVarArgs.d(1, this.FDY);
      }
      if (this.Username != null) {
        paramVarArgs.d(2, this.Username);
      }
      if (this.tlT != null) {
        paramVarArgs.d(3, this.tlT);
      }
      paramVarArgs.aR(4, this.pAS);
      if (this.FDZ != null) {
        paramVarArgs.c(5, this.FDZ);
      }
      if (this.Title != null) {
        paramVarArgs.d(6, this.Title);
      }
      if (this.FDX != null) {
        paramVarArgs.d(7, this.FDX);
      }
      paramVarArgs.aO(8, this.FEa);
      if (this.FEb != null) {
        paramVarArgs.d(9, this.FEb);
      }
      AppMethodBeat.o(181512);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FDY == null) {
        break label670;
      }
    }
    label670:
    for (int i = f.a.a.b.b.a.e(1, this.FDY) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Username);
      }
      i = paramInt;
      if (this.tlT != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.tlT);
      }
      i += f.a.a.b.b.a.bx(4, this.pAS);
      paramInt = i;
      if (this.FDZ != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.FDZ);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Title);
      }
      paramInt = i;
      if (this.FDX != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FDX);
      }
      i = paramInt + f.a.a.b.b.a.p(8, this.FEa);
      paramInt = i;
      if (this.FEb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FEb);
      }
      AppMethodBeat.o(181512);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(181512);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        crg localcrg = (crg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(181512);
          return -1;
        case 1: 
          localcrg.FDY = locala.LVo.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 2: 
          localcrg.Username = locala.LVo.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 3: 
          localcrg.tlT = locala.LVo.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 4: 
          localcrg.pAS = locala.LVo.xF();
          AppMethodBeat.o(181512);
          return 0;
        case 5: 
          localcrg.FDZ = locala.LVo.gfk();
          AppMethodBeat.o(181512);
          return 0;
        case 6: 
          localcrg.Title = locala.LVo.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 7: 
          localcrg.FDX = locala.LVo.readString();
          AppMethodBeat.o(181512);
          return 0;
        case 8: 
          localcrg.FEa = locala.LVo.xG();
          AppMethodBeat.o(181512);
          return 0;
        }
        localcrg.FEb = locala.LVo.readString();
        AppMethodBeat.o(181512);
        return 0;
      }
      AppMethodBeat.o(181512);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crg
 * JD-Core Version:    0.7.0.1
 */