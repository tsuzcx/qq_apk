package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ddt
  extends com.tencent.mm.bw.a
{
  public String FNt;
  public String FNu;
  public String FNv;
  public String FNw;
  public String FNx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNt == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.FNt != null) {
        paramVarArgs.d(1, this.FNt);
      }
      if (this.FNu != null) {
        paramVarArgs.d(2, this.FNu);
      }
      if (this.FNv != null) {
        paramVarArgs.d(3, this.FNv);
      }
      if (this.FNw != null) {
        paramVarArgs.d(4, this.FNw);
      }
      if (this.FNx != null) {
        paramVarArgs.d(5, this.FNx);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FNt == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.FNt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNu != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNu);
      }
      i = paramInt;
      if (this.FNv != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FNv);
      }
      paramInt = i;
      if (this.FNw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FNw);
      }
      i = paramInt;
      if (this.FNx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FNx);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.FNt == null)
        {
          paramVarArgs = new b("Not all required fields were included: videoFileMD5");
          AppMethodBeat.o(101531);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101531);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ddt localddt = (ddt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localddt.FNt = locala.LVo.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localddt.FNu = locala.LVo.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localddt.FNv = locala.LVo.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localddt.FNw = locala.LVo.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localddt.FNx = locala.LVo.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddt
 * JD-Core Version:    0.7.0.1
 */