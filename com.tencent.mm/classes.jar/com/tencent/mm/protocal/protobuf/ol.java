package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ol
  extends com.tencent.mm.bw.a
{
  public String Eel;
  public String Eem;
  public String Url;
  public int ndI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152989);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eel != null) {
        paramVarArgs.d(1, this.Eel);
      }
      if (this.Eem != null) {
        paramVarArgs.d(2, this.Eem);
      }
      if (this.Url != null) {
        paramVarArgs.d(3, this.Url);
      }
      paramVarArgs.aR(4, this.ndI);
      AppMethodBeat.o(152989);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eel == null) {
        break label378;
      }
    }
    label378:
    for (int i = f.a.a.b.b.a.e(1, this.Eel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eem != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eem);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Url);
      }
      paramInt = f.a.a.b.b.a.bx(4, this.ndI);
      AppMethodBeat.o(152989);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152989);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ol localol = (ol)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152989);
          return -1;
        case 1: 
          localol.Eel = locala.LVo.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 2: 
          localol.Eem = locala.LVo.readString();
          AppMethodBeat.o(152989);
          return 0;
        case 3: 
          localol.Url = locala.LVo.readString();
          AppMethodBeat.o(152989);
          return 0;
        }
        localol.ndI = locala.LVo.xF();
        AppMethodBeat.o(152989);
        return 0;
      }
      AppMethodBeat.o(152989);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */