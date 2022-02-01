package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class dkb
  extends com.tencent.mm.bw.a
{
  public String HRP;
  public String HRQ;
  public String HRR;
  public String HRS;
  public String HRT;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101531);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HRP == null)
      {
        paramVarArgs = new b("Not all required fields were included: videoFileMD5");
        AppMethodBeat.o(101531);
        throw paramVarArgs;
      }
      if (this.HRP != null) {
        paramVarArgs.d(1, this.HRP);
      }
      if (this.HRQ != null) {
        paramVarArgs.d(2, this.HRQ);
      }
      if (this.HRR != null) {
        paramVarArgs.d(3, this.HRR);
      }
      if (this.HRS != null) {
        paramVarArgs.d(4, this.HRS);
      }
      if (this.HRT != null) {
        paramVarArgs.d(5, this.HRT);
      }
      AppMethodBeat.o(101531);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HRP == null) {
        break label502;
      }
    }
    label502:
    for (int i = f.a.a.b.b.a.e(1, this.HRP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HRQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HRQ);
      }
      i = paramInt;
      if (this.HRR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HRR);
      }
      paramInt = i;
      if (this.HRS != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HRS);
      }
      i = paramInt;
      if (this.HRT != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HRT);
      }
      AppMethodBeat.o(101531);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.HRP == null)
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
        dkb localdkb = (dkb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(101531);
          return -1;
        case 1: 
          localdkb.HRP = locala.OmT.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 2: 
          localdkb.HRQ = locala.OmT.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 3: 
          localdkb.HRR = locala.OmT.readString();
          AppMethodBeat.o(101531);
          return 0;
        case 4: 
          localdkb.HRS = locala.OmT.readString();
          AppMethodBeat.o(101531);
          return 0;
        }
        localdkb.HRT = locala.OmT.readString();
        AppMethodBeat.o(101531);
        return 0;
      }
      AppMethodBeat.o(101531);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkb
 * JD-Core Version:    0.7.0.1
 */