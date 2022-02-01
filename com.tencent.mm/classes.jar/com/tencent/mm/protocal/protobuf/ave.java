package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ave
  extends com.tencent.mm.bx.a
{
  public int Gtm;
  public int Gtu;
  public String Gtv;
  public String Gtw;
  public String Gtx;
  public String Gty;
  public int Scene;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152546);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Gtu);
      if (this.Gtv != null) {
        paramVarArgs.d(2, this.Gtv);
      }
      if (this.iht != null) {
        paramVarArgs.d(3, this.iht);
      }
      if (this.Gtw != null) {
        paramVarArgs.d(4, this.Gtw);
      }
      if (this.Gtx != null) {
        paramVarArgs.d(5, this.Gtx);
      }
      if (this.Gty != null) {
        paramVarArgs.d(7, this.Gty);
      }
      paramVarArgs.aS(8, this.Gtm);
      paramVarArgs.aS(9, this.Scene);
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.Gtu) + 0;
      paramInt = i;
      if (this.Gtv != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gtv);
      }
      i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.iht);
      }
      paramInt = i;
      if (this.Gtw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gtw);
      }
      i = paramInt;
      if (this.Gtx != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gtx);
      }
      paramInt = i;
      if (this.Gty != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gty);
      }
      i = f.a.a.b.b.a.bz(8, this.Gtm);
      int j = f.a.a.b.b.a.bz(9, this.Scene);
      AppMethodBeat.o(152546);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(152546);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      ave localave = (ave)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      default: 
        AppMethodBeat.o(152546);
        return -1;
      case 1: 
        localave.Gtu = locala.NPN.zc();
        AppMethodBeat.o(152546);
        return 0;
      case 2: 
        localave.Gtv = locala.NPN.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 3: 
        localave.iht = locala.NPN.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 4: 
        localave.Gtw = locala.NPN.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 5: 
        localave.Gtx = locala.NPN.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 7: 
        localave.Gty = locala.NPN.readString();
        AppMethodBeat.o(152546);
        return 0;
      case 8: 
        localave.Gtm = locala.NPN.zc();
        AppMethodBeat.o(152546);
        return 0;
      }
      localave.Scene = locala.NPN.zc();
      AppMethodBeat.o(152546);
      return 0;
    }
    AppMethodBeat.o(152546);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ave
 * JD-Core Version:    0.7.0.1
 */