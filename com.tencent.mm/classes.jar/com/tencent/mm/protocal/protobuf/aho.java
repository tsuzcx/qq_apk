package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aho
  extends com.tencent.mm.bw.a
{
  public int DPL;
  public String DPM;
  public String Desc;
  public String Title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(138174);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.d(2, this.Desc);
      }
      paramVarArgs.aR(3, this.DPL);
      if (this.DPM != null) {
        paramVarArgs.d(4, this.DPM);
      }
      AppMethodBeat.o(138174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Desc);
      }
      i += f.a.a.b.b.a.bx(3, this.DPL);
      paramInt = i;
      if (this.DPM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DPM);
      }
      AppMethodBeat.o(138174);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(138174);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aho localaho = (aho)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(138174);
          return -1;
        case 1: 
          localaho.Title = locala.LVo.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 2: 
          localaho.Desc = locala.LVo.readString();
          AppMethodBeat.o(138174);
          return 0;
        case 3: 
          localaho.DPL = locala.LVo.xF();
          AppMethodBeat.o(138174);
          return 0;
        }
        localaho.DPM = locala.LVo.readString();
        AppMethodBeat.o(138174);
        return 0;
      }
      AppMethodBeat.o(138174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aho
 * JD-Core Version:    0.7.0.1
 */