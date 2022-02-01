package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afh
  extends cvc
{
  public int FIg;
  public int FMu;
  public String FuL;
  public String Fwt;
  public long Gdr;
  public int xbr;
  public long xbt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(148652);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.xbr);
      paramVarArgs.aS(2, this.FMu);
      paramVarArgs.aS(3, this.FIg);
      if (this.Fwt != null) {
        paramVarArgs.d(4, this.Fwt);
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(5, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.xbt);
      if (this.FuL != null) {
        paramVarArgs.d(7, this.FuL);
      }
      paramVarArgs.aY(8, this.Gdr);
      AppMethodBeat.o(148652);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.xbr) + 0 + f.a.a.b.b.a.bz(2, this.FMu) + f.a.a.b.b.a.bz(3, this.FIg);
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Fwt);
      }
      i = paramInt;
      if (this.BaseRequest != null) {
        i = paramInt + f.a.a.a.lB(5, this.BaseRequest.computeSize());
      }
      i += f.a.a.b.b.a.p(6, this.xbt);
      paramInt = i;
      if (this.FuL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FuL);
      }
      i = f.a.a.b.b.a.p(8, this.Gdr);
      AppMethodBeat.o(148652);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(148652);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      afh localafh = (afh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(148652);
        return -1;
      case 1: 
        localafh.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 2: 
        localafh.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 3: 
        localafh.FIg = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(148652);
        return 0;
      case 4: 
        localafh.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(148652);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new jc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localafh.BaseRequest = ((jc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(148652);
        return 0;
      case 6: 
        localafh.xbt = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(148652);
        return 0;
      case 7: 
        localafh.FuL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(148652);
        return 0;
      }
      localafh.Gdr = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(148652);
      return 0;
    }
    AppMethodBeat.o(148652);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afh
 * JD-Core Version:    0.7.0.1
 */