package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class die
  extends com.tencent.mm.bx.a
{
  public String HwV;
  public String HwW;
  public String HwX;
  public String HwY;
  public int ing;
  public int inh;
  public int ini;
  public int inj;
  public int opType;
  public long timeStamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125841);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HwV == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwW == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwX == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.opType);
      paramVarArgs.aS(2, this.inj);
      paramVarArgs.aS(3, this.ing);
      paramVarArgs.aY(4, this.timeStamp);
      paramVarArgs.aS(5, this.inh);
      paramVarArgs.aS(6, this.ini);
      if (this.HwV != null) {
        paramVarArgs.d(7, this.HwV);
      }
      if (this.HwW != null) {
        paramVarArgs.d(8, this.HwW);
      }
      if (this.HwX != null) {
        paramVarArgs.d(9, this.HwX);
      }
      if (this.HwY != null) {
        paramVarArgs.d(10, this.HwY);
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bz(1, this.opType) + 0 + f.a.a.b.b.a.bz(2, this.inj) + f.a.a.b.b.a.bz(3, this.ing) + f.a.a.b.b.a.p(4, this.timeStamp) + f.a.a.b.b.a.bz(5, this.inh) + f.a.a.b.b.a.bz(6, this.ini);
      paramInt = i;
      if (this.HwV != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HwV);
      }
      i = paramInt;
      if (this.HwW != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.HwW);
      }
      paramInt = i;
      if (this.HwX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HwX);
      }
      i = paramInt;
      if (this.HwY != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HwY);
      }
      AppMethodBeat.o(125841);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.HwV == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc1");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwW == null)
      {
        paramVarArgs = new b("Not all required fields were included: StatusDesc2");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwX == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowSourceInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      if (this.HwY == null)
      {
        paramVarArgs = new b("Not all required fields were included: DataFlowResultInfo");
        AppMethodBeat.o(125841);
        throw paramVarArgs;
      }
      AppMethodBeat.o(125841);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      die localdie = (die)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125841);
        return -1;
      case 1: 
        localdie.opType = locala.NPN.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 2: 
        localdie.inj = locala.NPN.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 3: 
        localdie.ing = locala.NPN.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 4: 
        localdie.timeStamp = locala.NPN.zd();
        AppMethodBeat.o(125841);
        return 0;
      case 5: 
        localdie.inh = locala.NPN.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 6: 
        localdie.ini = locala.NPN.zc();
        AppMethodBeat.o(125841);
        return 0;
      case 7: 
        localdie.HwV = locala.NPN.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 8: 
        localdie.HwW = locala.NPN.readString();
        AppMethodBeat.o(125841);
        return 0;
      case 9: 
        localdie.HwX = locala.NPN.readString();
        AppMethodBeat.o(125841);
        return 0;
      }
      localdie.HwY = locala.NPN.readString();
      AppMethodBeat.o(125841);
      return 0;
    }
    AppMethodBeat.o(125841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.die
 * JD-Core Version:    0.7.0.1
 */