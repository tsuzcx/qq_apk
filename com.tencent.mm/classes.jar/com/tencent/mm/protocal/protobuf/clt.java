package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class clt
  extends com.tencent.mm.bw.a
{
  public String CRv;
  public String CRw;
  public String CZP;
  public String DfC;
  public String HxM;
  public String dyI;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91620);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyI != null) {
        paramVarArgs.d(1, this.dyI);
      }
      paramVarArgs.aS(2, this.type);
      if (this.DfC != null) {
        paramVarArgs.d(3, this.DfC);
      }
      if (this.CRv != null) {
        paramVarArgs.d(4, this.CRv);
      }
      if (this.CRw != null) {
        paramVarArgs.d(5, this.CRw);
      }
      if (this.HxM != null) {
        paramVarArgs.d(6, this.HxM);
      }
      if (this.CZP != null) {
        paramVarArgs.d(7, this.CZP);
      }
      AppMethodBeat.o(91620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyI == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.b.b.a.e(1, this.dyI) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type);
      paramInt = i;
      if (this.DfC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DfC);
      }
      i = paramInt;
      if (this.CRv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CRv);
      }
      paramInt = i;
      if (this.CRw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CRw);
      }
      i = paramInt;
      if (this.HxM != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.HxM);
      }
      paramInt = i;
      if (this.CZP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CZP);
      }
      AppMethodBeat.o(91620);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91620);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        clt localclt = (clt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91620);
          return -1;
        case 1: 
          localclt.dyI = locala.OmT.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 2: 
          localclt.type = locala.OmT.zc();
          AppMethodBeat.o(91620);
          return 0;
        case 3: 
          localclt.DfC = locala.OmT.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 4: 
          localclt.CRv = locala.OmT.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 5: 
          localclt.CRw = locala.OmT.readString();
          AppMethodBeat.o(91620);
          return 0;
        case 6: 
          localclt.HxM = locala.OmT.readString();
          AppMethodBeat.o(91620);
          return 0;
        }
        localclt.CZP = locala.OmT.readString();
        AppMethodBeat.o(91620);
        return 0;
      }
      AppMethodBeat.o(91620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clt
 * JD-Core Version:    0.7.0.1
 */