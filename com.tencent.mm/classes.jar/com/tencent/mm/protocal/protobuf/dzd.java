package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dzd
  extends com.tencent.mm.bw.a
{
  public int Eeo;
  public String Gfu;
  public String Gfv;
  public String djj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.djj != null) {
        paramVarArgs.d(1, this.djj);
      }
      paramVarArgs.aR(2, this.Eeo);
      if (this.Gfu != null) {
        paramVarArgs.d(3, this.Gfu);
      }
      if (this.Gfv != null) {
        paramVarArgs.d(4, this.Gfv);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.djj == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.djj) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Eeo);
      paramInt = i;
      if (this.Gfu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Gfu);
      }
      i = paramInt;
      if (this.Gfv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Gfv);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dzd localdzd = (dzd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localdzd.djj = locala.LVo.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localdzd.Eeo = locala.LVo.xF();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localdzd.Gfu = locala.LVo.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localdzd.Gfv = locala.LVo.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzd
 * JD-Core Version:    0.7.0.1
 */