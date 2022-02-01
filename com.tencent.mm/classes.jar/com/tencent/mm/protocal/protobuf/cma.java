package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public class cma
  extends com.tencent.mm.bx.a
{
  public String AFz = "";
  public int Hfj;
  public boolean Hfk;
  public boolean Hfl;
  public boolean Hfm;
  public boolean Hfn;
  public boolean Hfo;
  public boolean Hfp;
  public int hzh;
  public int id;
  public int nWh;
  public boolean oiG;
  public int ojt;
  public int ooi;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209606);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(209606);
        throw paramVarArgs;
      }
      if (this.AFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(209606);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.id);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(3, this.hzh);
      paramVarArgs.aS(4, this.ojt);
      paramVarArgs.aS(5, this.nWh);
      paramVarArgs.aS(6, this.ooi);
      paramVarArgs.aS(7, this.Hfj);
      if (this.AFz != null) {
        paramVarArgs.d(8, this.AFz);
      }
      paramVarArgs.bt(9, this.Hfk);
      paramVarArgs.bt(10, this.Hfl);
      paramVarArgs.bt(11, this.Hfm);
      paramVarArgs.bt(12, this.Hfn);
      paramVarArgs.bt(13, this.Hfo);
      paramVarArgs.bt(14, this.oiG);
      paramVarArgs.bt(15, this.Hfp);
      AppMethodBeat.o(209606);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.id) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.hzh) + f.a.a.b.b.a.bz(4, this.ojt) + f.a.a.b.b.a.bz(5, this.nWh) + f.a.a.b.b.a.bz(6, this.ooi) + f.a.a.b.b.a.bz(7, this.Hfj);
      paramInt = i;
      if (this.AFz != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.AFz);
      }
      i = f.a.a.b.b.a.alV(9);
      int j = f.a.a.b.b.a.alV(10);
      int k = f.a.a.b.b.a.alV(11);
      int m = f.a.a.b.b.a.alV(12);
      int n = f.a.a.b.b.a.alV(13);
      int i1 = f.a.a.b.b.a.alV(14);
      int i2 = f.a.a.b.b.a.alV(15);
      AppMethodBeat.o(209606);
      return paramInt + i + j + k + m + n + i1 + i2;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(209606);
        throw paramVarArgs;
      }
      if (this.AFz == null)
      {
        paramVarArgs = new b("Not all required fields were included: uid");
        AppMethodBeat.o(209606);
        throw paramVarArgs;
      }
      AppMethodBeat.o(209606);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cma localcma = (cma)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(209606);
        return -1;
      case 1: 
        localcma.id = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 2: 
        localcma.url = locala.NPN.readString();
        AppMethodBeat.o(209606);
        return 0;
      case 3: 
        localcma.hzh = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 4: 
        localcma.ojt = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 5: 
        localcma.nWh = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 6: 
        localcma.ooi = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 7: 
        localcma.Hfj = locala.NPN.zc();
        AppMethodBeat.o(209606);
        return 0;
      case 8: 
        localcma.AFz = locala.NPN.readString();
        AppMethodBeat.o(209606);
        return 0;
      case 9: 
        localcma.Hfk = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      case 10: 
        localcma.Hfl = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      case 11: 
        localcma.Hfm = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      case 12: 
        localcma.Hfn = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      case 13: 
        localcma.Hfo = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      case 14: 
        localcma.oiG = locala.NPN.grw();
        AppMethodBeat.o(209606);
        return 0;
      }
      localcma.Hfp = locala.NPN.grw();
      AppMethodBeat.o(209606);
      return 0;
    }
    AppMethodBeat.o(209606);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cma
 * JD-Core Version:    0.7.0.1
 */