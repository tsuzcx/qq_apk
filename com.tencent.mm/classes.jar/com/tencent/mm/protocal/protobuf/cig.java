package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class cig
  extends com.tencent.mm.bx.a
{
  public String Hcd;
  public int Hce;
  public long createTime;
  public String dyU;
  public String hEb;
  public long nxr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(192562);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dyU != null) {
        paramVarArgs.d(1, this.dyU);
      }
      if (this.Hcd != null) {
        paramVarArgs.d(2, this.Hcd);
      }
      if (this.hEb != null) {
        paramVarArgs.d(3, this.hEb);
      }
      paramVarArgs.aY(4, this.createTime);
      paramVarArgs.aS(5, this.Hce);
      paramVarArgs.aY(6, this.nxr);
      AppMethodBeat.o(192562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dyU == null) {
        break label474;
      }
    }
    label474:
    for (int i = f.a.a.b.b.a.e(1, this.dyU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hcd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Hcd);
      }
      i = paramInt;
      if (this.hEb != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hEb);
      }
      paramInt = f.a.a.b.b.a.p(4, this.createTime);
      int j = f.a.a.b.b.a.bz(5, this.Hce);
      int k = f.a.a.b.b.a.p(6, this.nxr);
      AppMethodBeat.o(192562);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(192562);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cig localcig = (cig)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(192562);
          return -1;
        case 1: 
          localcig.dyU = locala.NPN.readString();
          AppMethodBeat.o(192562);
          return 0;
        case 2: 
          localcig.Hcd = locala.NPN.readString();
          AppMethodBeat.o(192562);
          return 0;
        case 3: 
          localcig.hEb = locala.NPN.readString();
          AppMethodBeat.o(192562);
          return 0;
        case 4: 
          localcig.createTime = locala.NPN.zd();
          AppMethodBeat.o(192562);
          return 0;
        case 5: 
          localcig.Hce = locala.NPN.zc();
          AppMethodBeat.o(192562);
          return 0;
        }
        localcig.nxr = locala.NPN.zd();
        AppMethodBeat.o(192562);
        return 0;
      }
      AppMethodBeat.o(192562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cig
 * JD-Core Version:    0.7.0.1
 */