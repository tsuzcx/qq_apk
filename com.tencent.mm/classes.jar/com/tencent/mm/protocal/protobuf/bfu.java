package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bfu
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GUB;
  public String app_id;
  public String language;
  
  public bfu()
  {
    AppMethodBeat.i(152582);
    this.GUB = new LinkedList();
    AppMethodBeat.o(152582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152583);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.language != null) {
        paramVarArgs.d(1, this.language);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.e(3, 1, this.GUB);
      AppMethodBeat.o(152583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.language == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = f.a.a.b.b.a.e(1, this.language) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      paramInt = f.a.a.a.c(3, 1, this.GUB);
      AppMethodBeat.o(152583);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GUB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152583);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bfu localbfu = (bfu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152583);
          return -1;
        case 1: 
          localbfu.language = locala.OmT.readString();
          AppMethodBeat.o(152583);
          return 0;
        case 2: 
          localbfu.app_id = locala.OmT.readString();
          AppMethodBeat.o(152583);
          return 0;
        }
        localbfu.GUB.add(locala.OmT.readString());
        AppMethodBeat.o(152583);
        return 0;
      }
      AppMethodBeat.o(152583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfu
 * JD-Core Version:    0.7.0.1
 */