package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class csm
  extends com.tencent.mm.bw.a
{
  public String DUB;
  public String Gyu;
  public long HDI;
  public int HDJ;
  public String HDK;
  public String appId;
  public String cardId;
  public String dAU;
  public String data;
  public String kNn;
  public int pos;
  public String title;
  public int weight;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aS(2, this.pos);
      paramVarArgs.aS(3, this.weight);
      paramVarArgs.aZ(4, this.HDI);
      paramVarArgs.aS(5, this.HDJ);
      if (this.kNn != null) {
        paramVarArgs.d(6, this.kNn);
      }
      if (this.cardId != null) {
        paramVarArgs.d(7, this.cardId);
      }
      if (this.data != null) {
        paramVarArgs.d(8, this.data);
      }
      if (this.Gyu != null) {
        paramVarArgs.d(9, this.Gyu);
      }
      if (this.appId != null) {
        paramVarArgs.d(10, this.appId);
      }
      if (this.DUB != null) {
        paramVarArgs.d(11, this.DUB);
      }
      if (this.dAU != null) {
        paramVarArgs.d(12, this.dAU);
      }
      if (this.HDK != null) {
        paramVarArgs.d(13, this.HDK);
      }
      AppMethodBeat.o(188957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.pos) + f.a.a.b.b.a.bz(3, this.weight) + f.a.a.b.b.a.p(4, this.HDI) + f.a.a.b.b.a.bz(5, this.HDJ);
      paramInt = i;
      if (this.kNn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.kNn);
      }
      i = paramInt;
      if (this.cardId != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.cardId);
      }
      paramInt = i;
      if (this.data != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.data);
      }
      i = paramInt;
      if (this.Gyu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gyu);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.appId);
      }
      i = paramInt;
      if (this.DUB != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.DUB);
      }
      paramInt = i;
      if (this.dAU != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.dAU);
      }
      i = paramInt;
      if (this.HDK != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HDK);
      }
      AppMethodBeat.o(188957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(188957);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        csm localcsm = (csm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(188957);
          return -1;
        case 1: 
          localcsm.title = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 2: 
          localcsm.pos = locala.OmT.zc();
          AppMethodBeat.o(188957);
          return 0;
        case 3: 
          localcsm.weight = locala.OmT.zc();
          AppMethodBeat.o(188957);
          return 0;
        case 4: 
          localcsm.HDI = locala.OmT.zd();
          AppMethodBeat.o(188957);
          return 0;
        case 5: 
          localcsm.HDJ = locala.OmT.zc();
          AppMethodBeat.o(188957);
          return 0;
        case 6: 
          localcsm.kNn = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 7: 
          localcsm.cardId = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 8: 
          localcsm.data = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 9: 
          localcsm.Gyu = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 10: 
          localcsm.appId = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 11: 
          localcsm.DUB = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        case 12: 
          localcsm.dAU = locala.OmT.readString();
          AppMethodBeat.o(188957);
          return 0;
        }
        localcsm.HDK = locala.OmT.readString();
        AppMethodBeat.o(188957);
        return 0;
      }
      AppMethodBeat.o(188957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.csm
 * JD-Core Version:    0.7.0.1
 */