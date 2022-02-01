package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yk
  extends com.tencent.mm.bw.a
{
  public String DSl;
  public int DSn;
  public int EbF;
  public int Esa;
  public String Esb;
  public int Esc;
  public int Esd;
  public int Ese;
  public int Esf;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103206);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.d(1, this.content);
      }
      if (this.DSl != null) {
        paramVarArgs.d(3, this.DSl);
      }
      paramVarArgs.aR(4, this.EbF);
      paramVarArgs.aR(5, this.DSn);
      paramVarArgs.aR(6, this.Esa);
      if (this.Esb != null) {
        paramVarArgs.d(7, this.Esb);
      }
      paramVarArgs.aR(8, this.Esc);
      paramVarArgs.aR(9, this.Esd);
      paramVarArgs.aR(10, this.Ese);
      paramVarArgs.aR(11, this.Esf);
      AppMethodBeat.o(103206);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label662;
      }
    }
    label662:
    for (paramInt = f.a.a.b.b.a.e(1, this.content) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DSl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSl);
      }
      i = i + f.a.a.b.b.a.bx(4, this.EbF) + f.a.a.b.b.a.bx(5, this.DSn) + f.a.a.b.b.a.bx(6, this.Esa);
      paramInt = i;
      if (this.Esb != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Esb);
      }
      i = f.a.a.b.b.a.bx(8, this.Esc);
      int j = f.a.a.b.b.a.bx(9, this.Esd);
      int k = f.a.a.b.b.a.bx(10, this.Ese);
      int m = f.a.a.b.b.a.bx(11, this.Esf);
      AppMethodBeat.o(103206);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103206);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        yk localyk = (yk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 2: 
        default: 
          AppMethodBeat.o(103206);
          return -1;
        case 1: 
          localyk.content = locala.LVo.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 3: 
          localyk.DSl = locala.LVo.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 4: 
          localyk.EbF = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        case 5: 
          localyk.DSn = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        case 6: 
          localyk.Esa = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        case 7: 
          localyk.Esb = locala.LVo.readString();
          AppMethodBeat.o(103206);
          return 0;
        case 8: 
          localyk.Esc = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        case 9: 
          localyk.Esd = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        case 10: 
          localyk.Ese = locala.LVo.xF();
          AppMethodBeat.o(103206);
          return 0;
        }
        localyk.Esf = locala.LVo.xF();
        AppMethodBeat.o(103206);
        return 0;
      }
      AppMethodBeat.o(103206);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yk
 * JD-Core Version:    0.7.0.1
 */