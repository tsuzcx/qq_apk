package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fom
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CPm;
  public boolean YGe;
  public long aaIb;
  public boolean aaId;
  public String aaYz;
  public String abOT;
  public long abOU;
  public boolean abOV;
  public boolean abOW;
  public String name;
  
  public fom()
  {
    AppMethodBeat.i(258111);
    this.CPm = new LinkedList();
    AppMethodBeat.o(258111);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258115);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaIb);
      if (this.name != null) {
        paramVarArgs.g(2, this.name);
      }
      paramVarArgs.e(3, 1, this.CPm);
      if (this.aaYz != null) {
        paramVarArgs.g(4, this.aaYz);
      }
      if (this.abOT != null) {
        paramVarArgs.g(5, this.abOT);
      }
      paramVarArgs.bv(6, this.abOU);
      paramVarArgs.di(7, this.YGe);
      paramVarArgs.di(8, this.aaId);
      paramVarArgs.di(9, this.abOV);
      paramVarArgs.di(10, this.abOW);
      AppMethodBeat.o(258115);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.aaIb) + 0;
      paramInt = i;
      if (this.name != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.name);
      }
      i = paramInt + i.a.a.a.c(3, 1, this.CPm);
      paramInt = i;
      if (this.aaYz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaYz);
      }
      i = paramInt;
      if (this.abOT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abOT);
      }
      paramInt = i.a.a.b.b.a.q(6, this.abOU);
      int j = i.a.a.b.b.a.ko(7);
      int k = i.a.a.b.b.a.ko(8);
      int m = i.a.a.b.b.a.ko(9);
      int n = i.a.a.b.b.a.ko(10);
      AppMethodBeat.o(258115);
      return i + paramInt + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CPm.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258115);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      fom localfom = (fom)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258115);
        return -1;
      case 1: 
        localfom.aaIb = locala.ajGk.aaw();
        AppMethodBeat.o(258115);
        return 0;
      case 2: 
        localfom.name = locala.ajGk.readString();
        AppMethodBeat.o(258115);
        return 0;
      case 3: 
        localfom.CPm.add(locala.ajGk.readString());
        AppMethodBeat.o(258115);
        return 0;
      case 4: 
        localfom.aaYz = locala.ajGk.readString();
        AppMethodBeat.o(258115);
        return 0;
      case 5: 
        localfom.abOT = locala.ajGk.readString();
        AppMethodBeat.o(258115);
        return 0;
      case 6: 
        localfom.abOU = locala.ajGk.aaw();
        AppMethodBeat.o(258115);
        return 0;
      case 7: 
        localfom.YGe = locala.ajGk.aai();
        AppMethodBeat.o(258115);
        return 0;
      case 8: 
        localfom.aaId = locala.ajGk.aai();
        AppMethodBeat.o(258115);
        return 0;
      case 9: 
        localfom.abOV = locala.ajGk.aai();
        AppMethodBeat.o(258115);
        return 0;
      }
      localfom.abOW = locala.ajGk.aai();
      AppMethodBeat.o(258115);
      return 0;
    }
    AppMethodBeat.o(258115);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fom
 * JD-Core Version:    0.7.0.1
 */