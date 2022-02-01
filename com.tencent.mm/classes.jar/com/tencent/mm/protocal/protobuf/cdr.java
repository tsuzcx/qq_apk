package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cdr
  extends com.tencent.mm.bw.a
{
  public String GaH;
  public String Gfz;
  public String GkI;
  public String HqB;
  public int HqC;
  public String HqD;
  public int HqE;
  public int duration;
  public String hCa;
  public String hGg;
  public int height;
  public String title;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176147);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HqB != null) {
        paramVarArgs.d(1, this.HqB);
      }
      paramVarArgs.aS(2, this.duration);
      if (this.GaH != null) {
        paramVarArgs.d(3, this.GaH);
      }
      if (this.GkI != null) {
        paramVarArgs.d(4, this.GkI);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.hGg != null) {
        paramVarArgs.d(6, this.hGg);
      }
      paramVarArgs.aS(7, this.HqC);
      paramVarArgs.aS(8, this.width);
      paramVarArgs.aS(9, this.height);
      if (this.Gfz != null) {
        paramVarArgs.d(10, this.Gfz);
      }
      if (this.hCa != null) {
        paramVarArgs.d(11, this.hCa);
      }
      if (this.HqD != null) {
        paramVarArgs.d(12, this.HqD);
      }
      paramVarArgs.aS(13, this.HqE);
      AppMethodBeat.o(176147);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HqB == null) {
        break label866;
      }
    }
    label866:
    for (paramInt = f.a.a.b.b.a.e(1, this.HqB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.duration);
      paramInt = i;
      if (this.GaH != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.GaH);
      }
      i = paramInt;
      if (this.GkI != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.GkI);
      }
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.title);
      }
      i = paramInt;
      if (this.hGg != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.hGg);
      }
      i = i + f.a.a.b.b.a.bz(7, this.HqC) + f.a.a.b.b.a.bz(8, this.width) + f.a.a.b.b.a.bz(9, this.height);
      paramInt = i;
      if (this.Gfz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Gfz);
      }
      i = paramInt;
      if (this.hCa != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.hCa);
      }
      paramInt = i;
      if (this.HqD != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HqD);
      }
      i = f.a.a.b.b.a.bz(13, this.HqE);
      AppMethodBeat.o(176147);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(176147);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cdr localcdr = (cdr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(176147);
          return -1;
        case 1: 
          localcdr.HqB = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 2: 
          localcdr.duration = locala.OmT.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 3: 
          localcdr.GaH = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 4: 
          localcdr.GkI = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 5: 
          localcdr.title = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 6: 
          localcdr.hGg = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 7: 
          localcdr.HqC = locala.OmT.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 8: 
          localcdr.width = locala.OmT.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 9: 
          localcdr.height = locala.OmT.zc();
          AppMethodBeat.o(176147);
          return 0;
        case 10: 
          localcdr.Gfz = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 11: 
          localcdr.hCa = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        case 12: 
          localcdr.HqD = locala.OmT.readString();
          AppMethodBeat.o(176147);
          return 0;
        }
        localcdr.HqE = locala.OmT.zc();
        AppMethodBeat.o(176147);
        return 0;
      }
      AppMethodBeat.o(176147);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdr
 * JD-Core Version:    0.7.0.1
 */