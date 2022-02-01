package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eib
  extends com.tencent.mm.bx.a
{
  public int FFA;
  public int GXa;
  public String HSw;
  public int HSx;
  public boolean HSy = false;
  public boolean HSz = false;
  public String HjZ;
  public String session_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FFA);
      paramVarArgs.aS(2, this.GXa);
      if (this.session_id != null) {
        paramVarArgs.d(3, this.session_id);
      }
      if (this.HSw != null) {
        paramVarArgs.d(4, this.HSw);
      }
      if (this.HjZ != null) {
        paramVarArgs.d(5, this.HjZ);
      }
      paramVarArgs.aS(6, this.HSx);
      paramVarArgs.bt(7, this.HSy);
      paramVarArgs.bt(8, this.HSz);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.FFA) + 0 + f.a.a.b.b.a.bz(2, this.GXa);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.session_id);
      }
      i = paramInt;
      if (this.HSw != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.HSw);
      }
      paramInt = i;
      if (this.HjZ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.HjZ);
      }
      i = f.a.a.b.b.a.bz(6, this.HSx);
      int j = f.a.a.b.b.a.alV(7);
      int k = f.a.a.b.b.a.alV(8);
      AppMethodBeat.o(117961);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eib localeib = (eib)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localeib.FFA = locala.NPN.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localeib.GXa = locala.NPN.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localeib.session_id = locala.NPN.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localeib.HSw = locala.NPN.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localeib.HjZ = locala.NPN.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localeib.HSx = locala.NPN.zc();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localeib.HSy = locala.NPN.grw();
        AppMethodBeat.o(117961);
        return 0;
      }
      localeib.HSz = locala.NPN.grw();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eib
 * JD-Core Version:    0.7.0.1
 */