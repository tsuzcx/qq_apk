package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqo
  extends com.tencent.mm.bw.a
{
  public String GHq;
  public String GHr;
  public String GHs;
  public String GHt;
  public String GHu;
  public String GHv;
  public String GHw;
  public String GHx;
  public String GHy;
  public String GHz;
  public int objectType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189386);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.objectType);
      if (this.GHq != null) {
        paramVarArgs.d(2, this.GHq);
      }
      if (this.GHr != null) {
        paramVarArgs.d(3, this.GHr);
      }
      if (this.GHs != null) {
        paramVarArgs.d(4, this.GHs);
      }
      if (this.GHt != null) {
        paramVarArgs.d(5, this.GHt);
      }
      if (this.GHu != null) {
        paramVarArgs.d(6, this.GHu);
      }
      if (this.GHv != null) {
        paramVarArgs.d(7, this.GHv);
      }
      if (this.GHw != null) {
        paramVarArgs.d(8, this.GHw);
      }
      if (this.GHx != null) {
        paramVarArgs.d(9, this.GHx);
      }
      if (this.GHy != null) {
        paramVarArgs.d(10, this.GHy);
      }
      if (this.GHz != null) {
        paramVarArgs.d(11, this.GHz);
      }
      AppMethodBeat.o(189386);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.objectType) + 0;
      paramInt = i;
      if (this.GHq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GHq);
      }
      i = paramInt;
      if (this.GHr != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GHr);
      }
      paramInt = i;
      if (this.GHs != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GHs);
      }
      i = paramInt;
      if (this.GHt != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GHt);
      }
      paramInt = i;
      if (this.GHu != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GHu);
      }
      i = paramInt;
      if (this.GHv != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GHv);
      }
      paramInt = i;
      if (this.GHw != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GHw);
      }
      i = paramInt;
      if (this.GHx != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GHx);
      }
      paramInt = i;
      if (this.GHy != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.GHy);
      }
      i = paramInt;
      if (this.GHz != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GHz);
      }
      AppMethodBeat.o(189386);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189386);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqo localaqo = (aqo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189386);
        return -1;
      case 1: 
        localaqo.objectType = locala.OmT.zc();
        AppMethodBeat.o(189386);
        return 0;
      case 2: 
        localaqo.GHq = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 3: 
        localaqo.GHr = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 4: 
        localaqo.GHs = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 5: 
        localaqo.GHt = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 6: 
        localaqo.GHu = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 7: 
        localaqo.GHv = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 8: 
        localaqo.GHw = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 9: 
        localaqo.GHx = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      case 10: 
        localaqo.GHy = locala.OmT.readString();
        AppMethodBeat.o(189386);
        return 0;
      }
      localaqo.GHz = locala.OmT.readString();
      AppMethodBeat.o(189386);
      return 0;
    }
    AppMethodBeat.o(189386);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqo
 * JD-Core Version:    0.7.0.1
 */