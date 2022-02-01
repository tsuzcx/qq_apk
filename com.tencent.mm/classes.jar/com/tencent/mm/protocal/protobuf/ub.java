package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ub
  extends com.tencent.mm.bw.a
{
  public String Eoe;
  public String Eof;
  public String Eog;
  public int Eoh;
  public String Eoi;
  public String Eoj;
  public String Eok;
  public String ncR;
  public String ndW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ncR != null) {
        paramVarArgs.d(1, this.ncR);
      }
      if (this.ndW != null) {
        paramVarArgs.d(2, this.ndW);
      }
      if (this.Eoe != null) {
        paramVarArgs.d(3, this.Eoe);
      }
      if (this.Eof != null) {
        paramVarArgs.d(4, this.Eof);
      }
      if (this.Eog != null) {
        paramVarArgs.d(5, this.Eog);
      }
      paramVarArgs.aR(6, this.Eoh);
      if (this.Eoi != null) {
        paramVarArgs.d(7, this.Eoi);
      }
      if (this.Eoj != null) {
        paramVarArgs.d(10, this.Eoj);
      }
      if (this.Eok != null) {
        paramVarArgs.d(11, this.Eok);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ncR == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.ncR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ndW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.ndW);
      }
      i = paramInt;
      if (this.Eoe != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Eoe);
      }
      paramInt = i;
      if (this.Eof != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Eof);
      }
      i = paramInt;
      if (this.Eog != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Eog);
      }
      i += f.a.a.b.b.a.bx(6, this.Eoh);
      paramInt = i;
      if (this.Eoi != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Eoi);
      }
      i = paramInt;
      if (this.Eoj != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Eoj);
      }
      paramInt = i;
      if (this.Eok != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Eok);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ub localub = (ub)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localub.ncR = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localub.ndW = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localub.Eoe = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localub.Eof = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localub.Eog = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localub.Eoh = locala.LVo.xF();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localub.Eoi = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localub.Eoj = locala.LVo.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localub.Eok = locala.LVo.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ub
 * JD-Core Version:    0.7.0.1
 */