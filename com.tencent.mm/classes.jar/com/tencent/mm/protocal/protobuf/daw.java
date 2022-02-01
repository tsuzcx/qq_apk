package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class daw
  extends com.tencent.mm.bw.a
{
  public String DRe;
  public String DRf;
  public String DRg;
  public int yCc;
  public int yCd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125804);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DRe != null) {
        paramVarArgs.d(1, this.DRe);
      }
      if (this.DRf != null) {
        paramVarArgs.d(2, this.DRf);
      }
      if (this.DRg != null) {
        paramVarArgs.d(3, this.DRg);
      }
      paramVarArgs.aR(4, this.yCc);
      paramVarArgs.aR(5, this.yCd);
      AppMethodBeat.o(125804);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DRe == null) {
        break label426;
      }
    }
    label426:
    for (int i = f.a.a.b.b.a.e(1, this.DRe) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DRf != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DRf);
      }
      i = paramInt;
      if (this.DRg != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DRg);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.yCc);
      int j = f.a.a.b.b.a.bx(5, this.yCd);
      AppMethodBeat.o(125804);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(125804);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        daw localdaw = (daw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125804);
          return -1;
        case 1: 
          localdaw.DRe = locala.LVo.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 2: 
          localdaw.DRf = locala.LVo.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 3: 
          localdaw.DRg = locala.LVo.readString();
          AppMethodBeat.o(125804);
          return 0;
        case 4: 
          localdaw.yCc = locala.LVo.xF();
          AppMethodBeat.o(125804);
          return 0;
        }
        localdaw.yCd = locala.LVo.xF();
        AppMethodBeat.o(125804);
        return 0;
      }
      AppMethodBeat.o(125804);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.daw
 * JD-Core Version:    0.7.0.1
 */