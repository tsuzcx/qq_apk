package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bba
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> ERJ;
  public String aTm;
  public String app_id;
  
  public bba()
  {
    AppMethodBeat.i(152582);
    this.ERJ = new LinkedList();
    AppMethodBeat.o(152582);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152583);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aTm != null) {
        paramVarArgs.d(1, this.aTm);
      }
      if (this.app_id != null) {
        paramVarArgs.d(2, this.app_id);
      }
      paramVarArgs.e(3, 1, this.ERJ);
      AppMethodBeat.o(152583);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aTm == null) {
        break label334;
      }
    }
    label334:
    for (paramInt = f.a.a.b.b.a.e(1, this.aTm) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.app_id != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.app_id);
      }
      paramInt = f.a.a.a.c(3, 1, this.ERJ);
      AppMethodBeat.o(152583);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ERJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152583);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        bba localbba = (bba)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152583);
          return -1;
        case 1: 
          localbba.aTm = locala.LVo.readString();
          AppMethodBeat.o(152583);
          return 0;
        case 2: 
          localbba.app_id = locala.LVo.readString();
          AppMethodBeat.o(152583);
          return 0;
        }
        localbba.ERJ.add(locala.LVo.readString());
        AppMethodBeat.o(152583);
        return 0;
      }
      AppMethodBeat.o(152583);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bba
 * JD-Core Version:    0.7.0.1
 */