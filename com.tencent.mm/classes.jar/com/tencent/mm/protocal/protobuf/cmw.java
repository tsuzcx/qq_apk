package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cmw
  extends com.tencent.mm.bw.a
{
  public String DSu;
  public b EQy;
  public b EQz;
  public String Eel;
  public String FAh;
  public b FAi;
  public int Scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104831);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Eel != null) {
        paramVarArgs.d(1, this.Eel);
      }
      if (this.FAh != null) {
        paramVarArgs.d(2, this.FAh);
      }
      if (this.DSu != null) {
        paramVarArgs.d(3, this.DSu);
      }
      if (this.EQz != null) {
        paramVarArgs.c(4, this.EQz);
      }
      if (this.EQy != null) {
        paramVarArgs.c(5, this.EQy);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.FAi != null) {
        paramVarArgs.c(7, this.FAi);
      }
      AppMethodBeat.o(104831);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Eel == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.Eel) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FAh != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FAh);
      }
      i = paramInt;
      if (this.DSu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DSu);
      }
      paramInt = i;
      if (this.EQz != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.EQz);
      }
      i = paramInt;
      if (this.EQy != null) {
        i = paramInt + f.a.a.b.b.a.b(5, this.EQy);
      }
      i += f.a.a.b.b.a.bx(6, this.Scene);
      paramInt = i;
      if (this.FAi != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.FAi);
      }
      AppMethodBeat.o(104831);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104831);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cmw localcmw = (cmw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104831);
          return -1;
        case 1: 
          localcmw.Eel = locala.LVo.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 2: 
          localcmw.FAh = locala.LVo.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 3: 
          localcmw.DSu = locala.LVo.readString();
          AppMethodBeat.o(104831);
          return 0;
        case 4: 
          localcmw.EQz = locala.LVo.gfk();
          AppMethodBeat.o(104831);
          return 0;
        case 5: 
          localcmw.EQy = locala.LVo.gfk();
          AppMethodBeat.o(104831);
          return 0;
        case 6: 
          localcmw.Scene = locala.LVo.xF();
          AppMethodBeat.o(104831);
          return 0;
        }
        localcmw.FAi = locala.LVo.gfk();
        AppMethodBeat.o(104831);
        return 0;
      }
      AppMethodBeat.o(104831);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cmw
 * JD-Core Version:    0.7.0.1
 */