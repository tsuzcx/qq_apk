package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class byw
  extends com.tencent.mm.bx.a
{
  public String GUa;
  public String GUb;
  public String GUc;
  public int GUd;
  public String dxD;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91538);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dxD == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.type);
      if (this.dxD != null) {
        paramVarArgs.d(2, this.dxD);
      }
      if (this.url != null) {
        paramVarArgs.d(3, this.url);
      }
      if (this.GUa != null) {
        paramVarArgs.d(4, this.GUa);
      }
      if (this.GUb != null) {
        paramVarArgs.d(5, this.GUb);
      }
      if (this.GUc != null) {
        paramVarArgs.d(6, this.GUc);
      }
      paramVarArgs.aS(7, this.GUd);
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.dxD != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dxD);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.url);
      }
      paramInt = i;
      if (this.GUa != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GUa);
      }
      i = paramInt;
      if (this.GUb != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.GUb);
      }
      paramInt = i;
      if (this.GUc != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GUc);
      }
      i = f.a.a.b.b.a.bz(7, this.GUd);
      AppMethodBeat.o(91538);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.dxD == null)
      {
        paramVarArgs = new b("Not all required fields were included: wording");
        AppMethodBeat.o(91538);
        throw paramVarArgs;
      }
      AppMethodBeat.o(91538);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      byw localbyw = (byw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91538);
        return -1;
      case 1: 
        localbyw.type = locala.NPN.zc();
        AppMethodBeat.o(91538);
        return 0;
      case 2: 
        localbyw.dxD = locala.NPN.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 3: 
        localbyw.url = locala.NPN.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 4: 
        localbyw.GUa = locala.NPN.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 5: 
        localbyw.GUb = locala.NPN.readString();
        AppMethodBeat.o(91538);
        return 0;
      case 6: 
        localbyw.GUc = locala.NPN.readString();
        AppMethodBeat.o(91538);
        return 0;
      }
      localbyw.GUd = locala.NPN.zc();
      AppMethodBeat.o(91538);
      return 0;
    }
    AppMethodBeat.o(91538);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byw
 * JD-Core Version:    0.7.0.1
 */