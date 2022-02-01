package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cxs
  extends cvc
{
  public int GXj;
  public LinkedList<String> GXk;
  public int GbX;
  public String Hpc;
  public String Hpd;
  public b Hpe;
  public String duW;
  public String state;
  
  public cxs()
  {
    AppMethodBeat.i(82470);
    this.GXk = new LinkedList();
    AppMethodBeat.o(82470);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82471);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.GXj);
      paramVarArgs.e(4, 1, this.GXk);
      if (this.duW != null) {
        paramVarArgs.d(5, this.duW);
      }
      if (this.state != null) {
        paramVarArgs.d(6, this.state);
      }
      if (this.Hpc != null) {
        paramVarArgs.d(7, this.Hpc);
      }
      paramVarArgs.aS(8, this.GbX);
      if (this.Hpd != null) {
        paramVarArgs.d(14, this.Hpd);
      }
      if (this.Hpe != null) {
        paramVarArgs.c(15, this.Hpe);
      }
      AppMethodBeat.o(82471);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label790;
      }
    }
    label790:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(3, this.GXj) + f.a.a.a.c(4, 1, this.GXk);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.duW);
      }
      i = paramInt;
      if (this.state != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.state);
      }
      paramInt = i;
      if (this.Hpc != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Hpc);
      }
      i = paramInt + f.a.a.b.b.a.bz(8, this.GbX);
      paramInt = i;
      if (this.Hpd != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Hpd);
      }
      i = paramInt;
      if (this.Hpe != null) {
        i = paramInt + f.a.a.b.b.a.b(15, this.Hpe);
      }
      AppMethodBeat.o(82471);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GXk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82471);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxs localcxs = (cxs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          AppMethodBeat.o(82471);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxs.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82471);
          return 0;
        case 3: 
          localcxs.GXj = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82471);
          return 0;
        case 4: 
          localcxs.GXk.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(82471);
          return 0;
        case 5: 
          localcxs.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 6: 
          localcxs.state = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 7: 
          localcxs.Hpc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82471);
          return 0;
        case 8: 
          localcxs.GbX = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(82471);
          return 0;
        case 14: 
          localcxs.Hpd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82471);
          return 0;
        }
        localcxs.Hpe = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(82471);
        return 0;
      }
      AppMethodBeat.o(82471);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxs
 * JD-Core Version:    0.7.0.1
 */