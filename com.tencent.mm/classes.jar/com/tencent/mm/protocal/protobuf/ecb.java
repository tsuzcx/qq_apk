package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ecb
  extends com.tencent.mm.bw.a
{
  public String HyQ;
  public String IhD;
  public String IhE;
  public String urn;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32506);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HyQ != null) {
        paramVarArgs.d(1, this.HyQ);
      }
      if (this.IhD != null) {
        paramVarArgs.d(2, this.IhD);
      }
      if (this.uvG != null) {
        paramVarArgs.d(3, this.uvG);
      }
      if (this.urn != null) {
        paramVarArgs.d(4, this.urn);
      }
      if (this.IhE != null) {
        paramVarArgs.d(5, this.IhE);
      }
      AppMethodBeat.o(32506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HyQ == null) {
        break label465;
      }
    }
    label465:
    for (int i = f.a.a.b.b.a.e(1, this.HyQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IhD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.IhD);
      }
      i = paramInt;
      if (this.uvG != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uvG);
      }
      paramInt = i;
      if (this.urn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.urn);
      }
      i = paramInt;
      if (this.IhE != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.IhE);
      }
      AppMethodBeat.o(32506);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32506);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ecb localecb = (ecb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(32506);
          return -1;
        case 1: 
          localecb.HyQ = locala.OmT.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 2: 
          localecb.IhD = locala.OmT.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 3: 
          localecb.uvG = locala.OmT.readString();
          AppMethodBeat.o(32506);
          return 0;
        case 4: 
          localecb.urn = locala.OmT.readString();
          AppMethodBeat.o(32506);
          return 0;
        }
        localecb.IhE = locala.OmT.readString();
        AppMethodBeat.o(32506);
        return 0;
      }
      AppMethodBeat.o(32506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecb
 * JD-Core Version:    0.7.0.1
 */