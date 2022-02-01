package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cok
  extends com.tencent.mm.bw.a
{
  public String EaV;
  public long FBu;
  public int FBv;
  public boolean FBw;
  public boolean FBx;
  public int FBy;
  public boolean FBz;
  public int tlu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EaV != null) {
        paramVarArgs.d(1, this.EaV);
      }
      paramVarArgs.aO(2, this.FBu);
      paramVarArgs.aR(3, this.FBv);
      paramVarArgs.bl(4, this.FBw);
      paramVarArgs.bl(5, this.FBx);
      paramVarArgs.aR(6, this.FBy);
      paramVarArgs.aR(7, this.tlu);
      paramVarArgs.bl(8, this.FBz);
      AppMethodBeat.o(124546);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EaV == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = f.a.a.b.b.a.e(1, this.EaV) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.FBu);
      int j = f.a.a.b.b.a.bx(3, this.FBv);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.bx(6, this.FBy);
      int i1 = f.a.a.b.b.a.bx(7, this.tlu);
      int i2 = f.a.a.b.b.a.fK(8);
      AppMethodBeat.o(124546);
      return paramInt + i + j + (k + 1) + (m + 1) + n + i1 + (i2 + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124546);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cok localcok = (cok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124546);
          return -1;
        case 1: 
          localcok.EaV = locala.LVo.readString();
          AppMethodBeat.o(124546);
          return 0;
        case 2: 
          localcok.FBu = locala.LVo.xG();
          AppMethodBeat.o(124546);
          return 0;
        case 3: 
          localcok.FBv = locala.LVo.xF();
          AppMethodBeat.o(124546);
          return 0;
        case 4: 
          localcok.FBw = locala.LVo.fZX();
          AppMethodBeat.o(124546);
          return 0;
        case 5: 
          localcok.FBx = locala.LVo.fZX();
          AppMethodBeat.o(124546);
          return 0;
        case 6: 
          localcok.FBy = locala.LVo.xF();
          AppMethodBeat.o(124546);
          return 0;
        case 7: 
          localcok.tlu = locala.LVo.xF();
          AppMethodBeat.o(124546);
          return 0;
        }
        localcok.FBz = locala.LVo.fZX();
        AppMethodBeat.o(124546);
        return 0;
      }
      AppMethodBeat.o(124546);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cok
 * JD-Core Version:    0.7.0.1
 */