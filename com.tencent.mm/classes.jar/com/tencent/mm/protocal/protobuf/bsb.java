package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bsb
  extends com.tencent.mm.bw.a
{
  public int DPI;
  public String Fhh;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124528);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Fhh != null) {
        paramVarArgs.d(1, this.Fhh);
      }
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.aR(3, this.DPI);
      AppMethodBeat.o(124528);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Fhh == null) {
        break label318;
      }
    }
    label318:
    for (paramInt = f.a.a.b.b.a.e(1, this.Fhh) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Title);
      }
      paramInt = f.a.a.b.b.a.bx(3, this.DPI);
      AppMethodBeat.o(124528);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124528);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bsb localbsb = (bsb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(124528);
          return -1;
        case 1: 
          localbsb.Fhh = locala.LVo.readString();
          AppMethodBeat.o(124528);
          return 0;
        case 2: 
          localbsb.Title = locala.LVo.readString();
          AppMethodBeat.o(124528);
          return 0;
        }
        localbsb.DPI = locala.LVo.xF();
        AppMethodBeat.o(124528);
        return 0;
      }
      AppMethodBeat.o(124528);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsb
 * JD-Core Version:    0.7.0.1
 */