package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtp
  extends com.tencent.mm.bx.a
{
  public int CHC;
  public String DUZ;
  public String EIl;
  public String IconUrl;
  public String fVC;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DUZ != null) {
        paramVarArgs.d(1, this.DUZ);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(2, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(3, this.mBV);
      }
      if (this.fVC != null) {
        paramVarArgs.d(4, this.fVC);
      }
      paramVarArgs.aR(5, this.CHC);
      if (this.EIl != null) {
        paramVarArgs.d(6, this.EIl);
      }
      if (this.IconUrl != null) {
        paramVarArgs.d(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DUZ == null) {
        break label562;
      }
    }
    label562:
    for (int i = f.a.a.b.b.a.e(1, this.DUZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mAQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mAQ);
      }
      i = paramInt;
      if (this.mBV != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mBV);
      }
      paramInt = i;
      if (this.fVC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fVC);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CHC);
      paramInt = i;
      if (this.EIl != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EIl);
      }
      i = paramInt;
      if (this.IconUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.IconUrl);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtp localdtp = (dtp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localdtp.DUZ = locala.KhF.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localdtp.mAQ = locala.KhF.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localdtp.mBV = locala.KhF.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localdtp.fVC = locala.KhF.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localdtp.CHC = locala.KhF.xS();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localdtp.EIl = locala.KhF.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localdtp.IconUrl = locala.KhF.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtp
 * JD-Core Version:    0.7.0.1
 */