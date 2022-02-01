package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbw
  extends com.tencent.mm.bw.a
{
  public String HKs;
  public String HKy;
  public String HKz;
  public String duQ;
  public String rfp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122529);
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
      if (this.HKy != null) {
        paramVarArgs.d(4, this.HKy);
      }
      if (this.HKz != null) {
        paramVarArgs.d(5, this.HKz);
      }
      AppMethodBeat.o(122529);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rfp == null) {
        break label454;
      }
    }
    label454:
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
      if (this.HKy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HKy);
      }
      i = paramInt;
      if (this.HKz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.HKz);
      }
      AppMethodBeat.o(122529);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122529);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dbw localdbw = (dbw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(122529);
          return -1;
        case 1: 
          localdbw.rfp = locala.OmT.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 2: 
          localdbw.HKs = locala.OmT.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 3: 
          localdbw.duQ = locala.OmT.readString();
          AppMethodBeat.o(122529);
          return 0;
        case 4: 
          localdbw.HKy = locala.OmT.readString();
          AppMethodBeat.o(122529);
          return 0;
        }
        localdbw.HKz = locala.OmT.readString();
        AppMethodBeat.o(122529);
        return 0;
      }
      AppMethodBeat.o(122529);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbw
 * JD-Core Version:    0.7.0.1
 */