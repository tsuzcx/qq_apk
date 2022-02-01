package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class drw
  extends com.tencent.mm.bw.a
{
  public String LVq;
  public String Lsm;
  public String Lsn;
  public String Lso;
  public int MUA;
  public String MUu;
  public int MUv;
  public String MUw;
  public String MUx;
  public String MUy;
  public int MUz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187879);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.MUu != null) {
        paramVarArgs.e(1, this.MUu);
      }
      paramVarArgs.aM(2, this.MUv);
      if (this.MUw != null) {
        paramVarArgs.e(3, this.MUw);
      }
      if (this.MUx != null) {
        paramVarArgs.e(4, this.MUx);
      }
      if (this.MUy != null) {
        paramVarArgs.e(5, this.MUy);
      }
      if (this.LVq != null) {
        paramVarArgs.e(6, this.LVq);
      }
      if (this.Lsm != null) {
        paramVarArgs.e(7, this.Lsm);
      }
      if (this.Lsn != null) {
        paramVarArgs.e(8, this.Lsn);
      }
      if (this.Lso != null) {
        paramVarArgs.e(9, this.Lso);
      }
      paramVarArgs.aM(10, this.MUz);
      paramVarArgs.aM(11, this.MUA);
      AppMethodBeat.o(187879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MUu == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.b.b.a.f(1, this.MUu) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MUv);
      paramInt = i;
      if (this.MUw != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.MUw);
      }
      i = paramInt;
      if (this.MUx != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.MUx);
      }
      paramInt = i;
      if (this.MUy != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.MUy);
      }
      i = paramInt;
      if (this.LVq != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.LVq);
      }
      paramInt = i;
      if (this.Lsm != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Lsm);
      }
      i = paramInt;
      if (this.Lsn != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Lsn);
      }
      paramInt = i;
      if (this.Lso != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.Lso);
      }
      i = g.a.a.b.b.a.bu(10, this.MUz);
      int j = g.a.a.b.b.a.bu(11, this.MUA);
      AppMethodBeat.o(187879);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187879);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        drw localdrw = (drw)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(187879);
          return -1;
        case 1: 
          localdrw.MUu = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 2: 
          localdrw.MUv = locala.UbS.zi();
          AppMethodBeat.o(187879);
          return 0;
        case 3: 
          localdrw.MUw = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 4: 
          localdrw.MUx = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 5: 
          localdrw.MUy = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 6: 
          localdrw.LVq = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 7: 
          localdrw.Lsm = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 8: 
          localdrw.Lsn = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 9: 
          localdrw.Lso = locala.UbS.readString();
          AppMethodBeat.o(187879);
          return 0;
        case 10: 
          localdrw.MUz = locala.UbS.zi();
          AppMethodBeat.o(187879);
          return 0;
        }
        localdrw.MUA = locala.UbS.zi();
        AppMethodBeat.o(187879);
        return 0;
      }
      AppMethodBeat.o(187879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drw
 * JD-Core Version:    0.7.0.1
 */