package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class tr
  extends com.tencent.mm.bx.a
{
  public String CVA;
  public String CVu;
  public String CVv;
  public String CVw;
  public int CVx;
  public String CVy;
  public String CVz;
  public String mAQ;
  public String mBV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43087);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.mAQ != null) {
        paramVarArgs.d(1, this.mAQ);
      }
      if (this.mBV != null) {
        paramVarArgs.d(2, this.mBV);
      }
      if (this.CVu != null) {
        paramVarArgs.d(3, this.CVu);
      }
      if (this.CVv != null) {
        paramVarArgs.d(4, this.CVv);
      }
      if (this.CVw != null) {
        paramVarArgs.d(5, this.CVw);
      }
      paramVarArgs.aR(6, this.CVx);
      if (this.CVy != null) {
        paramVarArgs.d(7, this.CVy);
      }
      if (this.CVz != null) {
        paramVarArgs.d(10, this.CVz);
      }
      if (this.CVA != null) {
        paramVarArgs.d(11, this.CVA);
      }
      AppMethodBeat.o(43087);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mAQ == null) {
        break label694;
      }
    }
    label694:
    for (int i = f.a.a.b.b.a.e(1, this.mAQ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.mBV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.mBV);
      }
      i = paramInt;
      if (this.CVu != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CVu);
      }
      paramInt = i;
      if (this.CVv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CVv);
      }
      i = paramInt;
      if (this.CVw != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CVw);
      }
      i += f.a.a.b.b.a.bA(6, this.CVx);
      paramInt = i;
      if (this.CVy != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CVy);
      }
      i = paramInt;
      if (this.CVz != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CVz);
      }
      paramInt = i;
      if (this.CVA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.CVA);
      }
      AppMethodBeat.o(43087);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(43087);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        tr localtr = (tr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 8: 
        case 9: 
        default: 
          AppMethodBeat.o(43087);
          return -1;
        case 1: 
          localtr.mAQ = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 2: 
          localtr.mBV = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 3: 
          localtr.CVu = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 4: 
          localtr.CVv = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 5: 
          localtr.CVw = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 6: 
          localtr.CVx = locala.KhF.xS();
          AppMethodBeat.o(43087);
          return 0;
        case 7: 
          localtr.CVy = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        case 10: 
          localtr.CVz = locala.KhF.readString();
          AppMethodBeat.o(43087);
          return 0;
        }
        localtr.CVA = locala.KhF.readString();
        AppMethodBeat.o(43087);
        return 0;
      }
      AppMethodBeat.o(43087);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tr
 * JD-Core Version:    0.7.0.1
 */