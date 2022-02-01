package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class afn
  extends ckq
{
  public String CHp;
  public long Dfu;
  public String Dfv;
  public String Dfw;
  public int Dfx;
  public float Dfy;
  public int Dfz;
  public int dep;
  public String dlB;
  public int pNP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104363);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.aG(3, this.Dfu);
      if (this.CHp != null) {
        paramVarArgs.d(4, this.CHp);
      }
      if (this.Dfv != null) {
        paramVarArgs.d(5, this.Dfv);
      }
      if (this.Dfw != null) {
        paramVarArgs.d(6, this.Dfw);
      }
      paramVarArgs.aR(7, this.dep);
      paramVarArgs.aR(8, this.Dfx);
      paramVarArgs.aR(9, this.pNP);
      paramVarArgs.x(10, this.Dfy);
      paramVarArgs.aR(11, this.Dfz);
      AppMethodBeat.o(104363);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label837;
      }
    }
    label837:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i += f.a.a.b.b.a.q(3, this.Dfu);
      paramInt = i;
      if (this.CHp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CHp);
      }
      i = paramInt;
      if (this.Dfv != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dfv);
      }
      paramInt = i;
      if (this.Dfw != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Dfw);
      }
      i = f.a.a.b.b.a.bA(7, this.dep);
      int j = f.a.a.b.b.a.bA(8, this.Dfx);
      int k = f.a.a.b.b.a.bA(9, this.pNP);
      int m = f.a.a.b.b.a.fY(10);
      int n = f.a.a.b.b.a.bA(11, this.Dfz);
      AppMethodBeat.o(104363);
      return paramInt + i + j + k + (m + 4) + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(104363);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        afn localafn = (afn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104363);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localafn.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104363);
          return 0;
        case 2: 
          localafn.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 3: 
          localafn.Dfu = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(104363);
          return 0;
        case 4: 
          localafn.CHp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 5: 
          localafn.Dfv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 6: 
          localafn.Dfw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104363);
          return 0;
        case 7: 
          localafn.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104363);
          return 0;
        case 8: 
          localafn.Dfx = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104363);
          return 0;
        case 9: 
          localafn.pNP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(104363);
          return 0;
        case 10: 
          localafn.Dfy = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(104363);
          return 0;
        }
        localafn.Dfz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(104363);
        return 0;
      }
      AppMethodBeat.o(104363);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.afn
 * JD-Core Version:    0.7.0.1
 */