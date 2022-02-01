package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ccc
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> Fjc;
  public String key;
  public String value;
  public String wKF;
  
  public ccc()
  {
    AppMethodBeat.i(117535);
    this.Fjc = new LinkedList();
    AppMethodBeat.o(117535);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.value == null)
      {
        paramVarArgs = new b("Not all required fields were included: value");
        AppMethodBeat.o(117536);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.d(1, this.key);
      }
      if (this.value != null) {
        paramVarArgs.d(2, this.value);
      }
      if (this.wKF != null) {
        paramVarArgs.d(3, this.wKF);
      }
      paramVarArgs.e(4, 1, this.Fjc);
      AppMethodBeat.o(117536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.b.b.a.e(1, this.key) + 0;; i = 0)
    {
      paramInt = i;
      if (this.value != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.value);
      }
      i = paramInt;
      if (this.wKF != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.wKF);
      }
      paramInt = f.a.a.a.c(4, 1, this.Fjc);
      AppMethodBeat.o(117536);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fjc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        if (this.value == null)
        {
          paramVarArgs = new b("Not all required fields were included: value");
          AppMethodBeat.o(117536);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117536);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ccc localccc = (ccc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117536);
          return -1;
        case 1: 
          localccc.key = locala.LVo.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 2: 
          localccc.value = locala.LVo.readString();
          AppMethodBeat.o(117536);
          return 0;
        case 3: 
          localccc.wKF = locala.LVo.readString();
          AppMethodBeat.o(117536);
          return 0;
        }
        localccc.Fjc.add(locala.LVo.readString());
        AppMethodBeat.o(117536);
        return 0;
      }
      AppMethodBeat.o(117536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccc
 * JD-Core Version:    0.7.0.1
 */