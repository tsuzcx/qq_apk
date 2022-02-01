package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class chv
  extends com.tencent.mm.bw.a
{
  public String DnK;
  public String Hud;
  public String app_id;
  public String oOW;
  public String oOY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.app_id != null) {
        paramVarArgs.d(1, this.app_id);
      }
      if (this.DnK != null) {
        paramVarArgs.d(2, this.DnK);
      }
      if (this.oOY != null) {
        paramVarArgs.d(3, this.oOY);
      }
      if (this.oOW != null) {
        paramVarArgs.d(4, this.oOW);
      }
      if (this.Hud != null) {
        paramVarArgs.d(5, this.Hud);
      }
      AppMethodBeat.o(72540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.app_id == null) {
        break label454;
      }
    }
    label454:
    for (int i = f.a.a.b.b.a.e(1, this.app_id) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DnK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DnK);
      }
      i = paramInt;
      if (this.oOY != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.oOY);
      }
      paramInt = i;
      if (this.oOW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oOW);
      }
      i = paramInt;
      if (this.Hud != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Hud);
      }
      AppMethodBeat.o(72540);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72540);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        chv localchv = (chv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(72540);
          return -1;
        case 1: 
          localchv.app_id = locala.OmT.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 2: 
          localchv.DnK = locala.OmT.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 3: 
          localchv.oOY = locala.OmT.readString();
          AppMethodBeat.o(72540);
          return 0;
        case 4: 
          localchv.oOW = locala.OmT.readString();
          AppMethodBeat.o(72540);
          return 0;
        }
        localchv.Hud = locala.OmT.readString();
        AppMethodBeat.o(72540);
        return 0;
      }
      AppMethodBeat.o(72540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chv
 * JD-Core Version:    0.7.0.1
 */