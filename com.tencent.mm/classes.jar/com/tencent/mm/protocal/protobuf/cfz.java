package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cfz
  extends com.tencent.mm.bw.a
{
  public String BhV;
  public String ESm;
  public int EWV;
  public String EvL;
  public String Fuh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ESm != null) {
        paramVarArgs.d(1, this.ESm);
      }
      if (this.Fuh != null) {
        paramVarArgs.d(2, this.Fuh);
      }
      if (this.BhV != null) {
        paramVarArgs.d(3, this.BhV);
      }
      if (this.EvL != null) {
        paramVarArgs.d(4, this.EvL);
      }
      paramVarArgs.aR(5, this.EWV);
      AppMethodBeat.o(72549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ESm == null) {
        break label438;
      }
    }
    label438:
    for (int i = f.a.a.b.b.a.e(1, this.ESm) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fuh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Fuh);
      }
      i = paramInt;
      if (this.BhV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.BhV);
      }
      paramInt = i;
      if (this.EvL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EvL);
      }
      i = f.a.a.b.b.a.bx(5, this.EWV);
      AppMethodBeat.o(72549);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72549);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cfz localcfz = (cfz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72549);
          return -1;
        case 1: 
          localcfz.ESm = locala.LVo.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 2: 
          localcfz.Fuh = locala.LVo.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 3: 
          localcfz.BhV = locala.LVo.readString();
          AppMethodBeat.o(72549);
          return 0;
        case 4: 
          localcfz.EvL = locala.LVo.readString();
          AppMethodBeat.o(72549);
          return 0;
        }
        localcfz.EWV = locala.LVo.xF();
        AppMethodBeat.o(72549);
        return 0;
      }
      AppMethodBeat.o(72549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfz
 * JD-Core Version:    0.7.0.1
 */