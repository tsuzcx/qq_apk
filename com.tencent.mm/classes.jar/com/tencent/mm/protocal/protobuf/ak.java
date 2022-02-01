package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ak
  extends cvc
{
  public String Frp;
  public String Frq;
  public int Frr;
  public int Frs;
  public did Frt;
  public String dHX;
  public String dHY;
  public int dHZ;
  public String ovl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113922);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(113922);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ovl != null) {
        paramVarArgs.d(2, this.ovl);
      }
      paramVarArgs.aS(3, this.dHZ);
      if (this.dHX != null) {
        paramVarArgs.d(4, this.dHX);
      }
      if (this.dHY != null) {
        paramVarArgs.d(5, this.dHY);
      }
      if (this.Frp != null) {
        paramVarArgs.d(6, this.Frp);
      }
      if (this.Frq != null) {
        paramVarArgs.d(7, this.Frq);
      }
      paramVarArgs.aS(8, this.Frr);
      paramVarArgs.aS(9, this.Frs);
      if (this.Frt != null)
      {
        paramVarArgs.lC(10, this.Frt.computeSize());
        this.Frt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113922);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ovl != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ovl);
      }
      i += f.a.a.b.b.a.bz(3, this.dHZ);
      paramInt = i;
      if (this.dHX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.dHX);
      }
      i = paramInt;
      if (this.dHY != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dHY);
      }
      paramInt = i;
      if (this.Frp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Frp);
      }
      i = paramInt;
      if (this.Frq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Frq);
      }
      i = i + f.a.a.b.b.a.bz(8, this.Frr) + f.a.a.b.b.a.bz(9, this.Frs);
      paramInt = i;
      if (this.Frt != null) {
        paramInt = i + f.a.a.a.lB(10, this.Frt.computeSize());
      }
      AppMethodBeat.o(113922);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.dHX == null)
        {
          paramVarArgs = new b("Not all required fields were included: card_id");
          AppMethodBeat.o(113922);
          throw paramVarArgs;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ak localak = (ak)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113922);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localak.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113922);
          return 0;
        case 2: 
          localak.ovl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 3: 
          localak.dHZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113922);
          return 0;
        case 4: 
          localak.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 5: 
          localak.dHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 6: 
          localak.Frp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 7: 
          localak.Frq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113922);
          return 0;
        case 8: 
          localak.Frr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113922);
          return 0;
        case 9: 
          localak.Frs = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113922);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new did();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((did)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localak.Frt = ((did)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(113922);
        return 0;
      }
      AppMethodBeat.o(113922);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ak
 * JD-Core Version:    0.7.0.1
 */