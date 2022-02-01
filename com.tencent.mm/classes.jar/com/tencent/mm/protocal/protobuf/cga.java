package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cga
  extends com.tencent.mm.bw.a
{
  public String AZE;
  public String AZF;
  public String BhV;
  public String BnF;
  public String Fuh;
  public String dlQ;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlQ != null) {
        paramVarArgs.d(1, this.dlQ);
      }
      paramVarArgs.aR(2, this.type);
      if (this.BnF != null) {
        paramVarArgs.d(3, this.BnF);
      }
      if (this.AZE != null) {
        paramVarArgs.d(4, this.AZE);
      }
      if (this.AZF != null) {
        paramVarArgs.d(5, this.AZF);
      }
      if (this.Fuh != null) {
        paramVarArgs.d(6, this.Fuh);
      }
      if (this.BhV != null) {
        paramVarArgs.d(7, this.BhV);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlQ == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlQ) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.type);
      paramInt = i;
      if (this.BnF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.BnF);
      }
      i = paramInt;
      if (this.AZE != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.AZE);
      }
      paramInt = i;
      if (this.AZF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.AZF);
      }
      i = paramInt;
      if (this.Fuh != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fuh);
      }
      paramInt = i;
      if (this.BhV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.BhV);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cga localcga = (cga)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localcga.dlQ = locala.LVo.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localcga.type = locala.LVo.xF();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localcga.BnF = locala.LVo.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localcga.AZE = locala.LVo.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localcga.AZF = locala.LVo.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localcga.Fuh = locala.LVo.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localcga.BhV = locala.LVo.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cga
 * JD-Core Version:    0.7.0.1
 */