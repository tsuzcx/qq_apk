package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbu
  extends com.tencent.mm.bw.a
{
  public String HKs;
  public String HKt;
  public String duQ;
  public String rfp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122526);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rfp != null) {
        paramVarArgs.d(1, this.rfp);
      }
      if (this.HKs != null) {
        paramVarArgs.d(2, this.HKs);
      }
      if (this.duQ != null) {
        paramVarArgs.d(3, this.duQ);
      }
      if (this.HKt != null) {
        paramVarArgs.d(4, this.HKt);
      }
      AppMethodBeat.o(122526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rfp == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.rfp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HKs != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HKs);
      }
      i = paramInt;
      if (this.duQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.duQ);
      }
      paramInt = i;
      if (this.HKt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HKt);
      }
      AppMethodBeat.o(122526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122526);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dbu localdbu = (dbu)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122526);
          return -1;
        case 1: 
          localdbu.rfp = locala.OmT.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 2: 
          localdbu.HKs = locala.OmT.readString();
          AppMethodBeat.o(122526);
          return 0;
        case 3: 
          localdbu.duQ = locala.OmT.readString();
          AppMethodBeat.o(122526);
          return 0;
        }
        localdbu.HKt = locala.OmT.readString();
        AppMethodBeat.o(122526);
        return 0;
      }
      AppMethodBeat.o(122526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbu
 * JD-Core Version:    0.7.0.1
 */