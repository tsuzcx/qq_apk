package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class am
  extends cvc
{
  public String Frp;
  public String Frq;
  public int Frr;
  public LinkedList<tf> Fru;
  public int dHZ;
  
  public am()
  {
    AppMethodBeat.i(113924);
    this.Fru = new LinkedList();
    AppMethodBeat.o(113924);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113925);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.Fru);
      paramVarArgs.aS(3, this.dHZ);
      if (this.Frp != null) {
        paramVarArgs.d(4, this.Frp);
      }
      if (this.Frq != null) {
        paramVarArgs.d(5, this.Frq);
      }
      paramVarArgs.aS(6, this.Frr);
      AppMethodBeat.o(113925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.Fru) + f.a.a.b.b.a.bz(3, this.dHZ);
      paramInt = i;
      if (this.Frp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Frp);
      }
      i = paramInt;
      if (this.Frq != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Frq);
      }
      paramInt = f.a.a.b.b.a.bz(6, this.Frr);
      AppMethodBeat.o(113925);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Fru.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(113925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        am localam = (am)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113925);
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
            localam.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localam.Fru.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113925);
          return 0;
        case 3: 
          localam.dHZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(113925);
          return 0;
        case 4: 
          localam.Frp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113925);
          return 0;
        case 5: 
          localam.Frq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(113925);
          return 0;
        }
        localam.Frr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(113925);
        return 0;
      }
      AppMethodBeat.o(113925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.am
 * JD-Core Version:    0.7.0.1
 */