package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class apw
  extends com.tencent.mm.bx.a
{
  public boolean NFi;
  public boolean NIb;
  public boolean NIc;
  public String NId;
  public String NIe;
  public boolean TVM;
  public LinkedList<Integer> Zxj;
  public boolean Zxk;
  public String Zxl;
  public int Zxm;
  public long duration;
  public int mUU;
  public int oCb;
  
  public apw()
  {
    AppMethodBeat.i(75026);
    this.Zxj = new LinkedList();
    AppMethodBeat.o(75026);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(75027);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.duration);
      paramVarArgs.e(2, 2, this.Zxj);
      paramVarArgs.bS(3, this.oCb);
      paramVarArgs.di(4, this.Zxk);
      paramVarArgs.di(5, this.TVM);
      paramVarArgs.di(6, this.NIb);
      paramVarArgs.di(7, this.NIc);
      if (this.NId != null) {
        paramVarArgs.g(8, this.NId);
      }
      if (this.NIe != null) {
        paramVarArgs.g(9, this.NIe);
      }
      if (this.Zxl != null) {
        paramVarArgs.g(10, this.Zxl);
      }
      paramVarArgs.di(11, this.NFi);
      paramVarArgs.bS(12, this.Zxm);
      paramVarArgs.bS(13, this.mUU);
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.duration) + 0 + i.a.a.a.c(2, 2, this.Zxj) + i.a.a.b.b.a.cJ(3, this.oCb) + (i.a.a.b.b.a.ko(4) + 1) + (i.a.a.b.b.a.ko(5) + 1) + (i.a.a.b.b.a.ko(6) + 1) + (i.a.a.b.b.a.ko(7) + 1);
      paramInt = i;
      if (this.NId != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.NId);
      }
      i = paramInt;
      if (this.NIe != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.NIe);
      }
      paramInt = i;
      if (this.Zxl != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Zxl);
      }
      i = i.a.a.b.b.a.ko(11);
      int j = i.a.a.b.b.a.cJ(12, this.Zxm);
      int k = i.a.a.b.b.a.cJ(13, this.mUU);
      AppMethodBeat.o(75027);
      return paramInt + (i + 1) + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zxj.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(75027);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      apw localapw = (apw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(75027);
        return -1;
      case 1: 
        localapw.duration = locala.ajGk.aaw();
        AppMethodBeat.o(75027);
        return 0;
      case 2: 
        localapw.Zxj.add(Integer.valueOf(locala.ajGk.aar()));
        AppMethodBeat.o(75027);
        return 0;
      case 3: 
        localapw.oCb = locala.ajGk.aar();
        AppMethodBeat.o(75027);
        return 0;
      case 4: 
        localapw.Zxk = locala.ajGk.aai();
        AppMethodBeat.o(75027);
        return 0;
      case 5: 
        localapw.TVM = locala.ajGk.aai();
        AppMethodBeat.o(75027);
        return 0;
      case 6: 
        localapw.NIb = locala.ajGk.aai();
        AppMethodBeat.o(75027);
        return 0;
      case 7: 
        localapw.NIc = locala.ajGk.aai();
        AppMethodBeat.o(75027);
        return 0;
      case 8: 
        localapw.NId = locala.ajGk.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 9: 
        localapw.NIe = locala.ajGk.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 10: 
        localapw.Zxl = locala.ajGk.readString();
        AppMethodBeat.o(75027);
        return 0;
      case 11: 
        localapw.NFi = locala.ajGk.aai();
        AppMethodBeat.o(75027);
        return 0;
      case 12: 
        localapw.Zxm = locala.ajGk.aar();
        AppMethodBeat.o(75027);
        return 0;
      }
      localapw.mUU = locala.ajGk.aar();
      AppMethodBeat.o(75027);
      return 0;
    }
    AppMethodBeat.o(75027);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apw
 * JD-Core Version:    0.7.0.1
 */