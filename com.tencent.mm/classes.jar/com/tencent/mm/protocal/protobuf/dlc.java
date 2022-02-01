package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlc
  extends com.tencent.mm.bw.a
{
  public String hET;
  public int hEU;
  public String hEV;
  public String hEW;
  public String hEX;
  public String hEY;
  public String hEZ;
  public String hFa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125846);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.hET != null) {
        paramVarArgs.d(1, this.hET);
      }
      paramVarArgs.aS(2, this.hEU);
      if (this.hEW != null) {
        paramVarArgs.d(3, this.hEW);
      }
      if (this.hEX != null) {
        paramVarArgs.d(4, this.hEX);
      }
      if (this.hEV != null) {
        paramVarArgs.d(5, this.hEV);
      }
      if (this.hEY != null) {
        paramVarArgs.d(6, this.hEY);
      }
      if (this.hEZ != null) {
        paramVarArgs.d(7, this.hEZ);
      }
      if (this.hFa != null) {
        paramVarArgs.d(8, this.hFa);
      }
      AppMethodBeat.o(125846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hET == null) {
        break label626;
      }
    }
    label626:
    for (paramInt = f.a.a.b.b.a.e(1, this.hET) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.hEU);
      paramInt = i;
      if (this.hEW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.hEW);
      }
      i = paramInt;
      if (this.hEX != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.hEX);
      }
      paramInt = i;
      if (this.hEV != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hEV);
      }
      i = paramInt;
      if (this.hEY != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hEY);
      }
      paramInt = i;
      if (this.hEZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.hEZ);
      }
      i = paramInt;
      if (this.hFa != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.hFa);
      }
      AppMethodBeat.o(125846);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125846);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dlc localdlc = (dlc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125846);
          return -1;
        case 1: 
          localdlc.hET = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 2: 
          localdlc.hEU = locala.OmT.zc();
          AppMethodBeat.o(125846);
          return 0;
        case 3: 
          localdlc.hEW = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 4: 
          localdlc.hEX = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 5: 
          localdlc.hEV = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 6: 
          localdlc.hEY = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        case 7: 
          localdlc.hEZ = locala.OmT.readString();
          AppMethodBeat.o(125846);
          return 0;
        }
        localdlc.hFa = locala.OmT.readString();
        AppMethodBeat.o(125846);
        return 0;
      }
      AppMethodBeat.o(125846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlc
 * JD-Core Version:    0.7.0.1
 */