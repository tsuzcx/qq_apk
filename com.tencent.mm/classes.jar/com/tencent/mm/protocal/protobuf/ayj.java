package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ayj
  extends cvc
{
  public String Frp;
  public String Frq;
  public int Frr;
  public did Frt;
  public String GvU;
  public String dHX;
  public String dHY;
  public int dHZ;
  public String ovl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114010);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dHX == null)
      {
        paramVarArgs = new b("Not all required fields were included: card_id");
        AppMethodBeat.o(114010);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dHX != null) {
        paramVarArgs.d(2, this.dHX);
      }
      paramVarArgs.aS(3, this.dHZ);
      if (this.ovl != null) {
        paramVarArgs.d(4, this.ovl);
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
      if (this.GvU != null) {
        paramVarArgs.d(9, this.GvU);
      }
      if (this.Frt != null)
      {
        paramVarArgs.lC(10, this.Frt.computeSize());
        this.Frt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114010);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dHX != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dHX);
      }
      i += f.a.a.b.b.a.bz(3, this.dHZ);
      paramInt = i;
      if (this.ovl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.ovl);
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
      i += f.a.a.b.b.a.bz(8, this.Frr);
      paramInt = i;
      if (this.GvU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GvU);
      }
      i = paramInt;
      if (this.Frt != null) {
        i = paramInt + f.a.a.a.lB(10, this.Frt.computeSize());
      }
      AppMethodBeat.o(114010);
      return i;
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
          AppMethodBeat.o(114010);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ayj localayj = (ayj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114010);
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
            localayj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114010);
          return 0;
        case 2: 
          localayj.dHX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 3: 
          localayj.dHZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114010);
          return 0;
        case 4: 
          localayj.ovl = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 5: 
          localayj.dHY = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 6: 
          localayj.Frp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 7: 
          localayj.Frq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
          return 0;
        case 8: 
          localayj.Frr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114010);
          return 0;
        case 9: 
          localayj.GvU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114010);
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
          localayj.Frt = ((did)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114010);
        return 0;
      }
      AppMethodBeat.o(114010);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ayj
 * JD-Core Version:    0.7.0.1
 */