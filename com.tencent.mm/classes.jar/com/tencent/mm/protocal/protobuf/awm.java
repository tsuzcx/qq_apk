package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class awm
  extends com.tencent.mm.bw.a
{
  public String EOw;
  public String Md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104789);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EOw == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActivityId");
        AppMethodBeat.o(104789);
        throw paramVarArgs;
      }
      if (this.EOw != null) {
        paramVarArgs.d(1, this.EOw);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EOw == null) {
        break label322;
      }
    }
    label322:
    for (paramInt = f.a.a.b.b.a.e(1, this.EOw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Md5);
      }
      AppMethodBeat.o(104789);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EOw == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActivityId");
          AppMethodBeat.o(104789);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104789);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        awm localawm = (awm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104789);
          return -1;
        case 1: 
          localawm.EOw = locala.LVo.readString();
          AppMethodBeat.o(104789);
          return 0;
        }
        localawm.Md5 = locala.LVo.readString();
        AppMethodBeat.o(104789);
        return 0;
      }
      AppMethodBeat.o(104789);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awm
 * JD-Core Version:    0.7.0.1
 */