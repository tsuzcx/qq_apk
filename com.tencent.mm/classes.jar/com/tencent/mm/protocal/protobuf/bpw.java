package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bpw
  extends cvc
{
  public LinkedList<bys> FuN;
  public cwt FuO;
  public boh FuR;
  public int GKA;
  public String GKB;
  public int fLb;
  
  public bpw()
  {
    AppMethodBeat.i(101819);
    this.FuN = new LinkedList();
    AppMethodBeat.o(101819);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101820);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FuO == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101820);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.fLb);
      paramVarArgs.e(3, 8, this.FuN);
      if (this.FuO != null)
      {
        paramVarArgs.lC(4, this.FuO.computeSize());
        this.FuO.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GKA);
      if (this.GKB != null) {
        paramVarArgs.d(6, this.GKB);
      }
      if (this.FuR != null)
      {
        paramVarArgs.lC(7, this.FuR.computeSize());
        this.FuR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101820);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.fLb) + f.a.a.a.c(3, 8, this.FuN);
      paramInt = i;
      if (this.FuO != null) {
        paramInt = i + f.a.a.a.lB(4, this.FuO.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.GKA);
      paramInt = i;
      if (this.GKB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GKB);
      }
      i = paramInt;
      if (this.FuR != null) {
        i = paramInt + f.a.a.a.lB(7, this.FuR.computeSize());
      }
      AppMethodBeat.o(101820);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FuN.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FuO == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101820);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101820);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bpw localbpw = (bpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101820);
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
            localbpw.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 2: 
          localbpw.fLb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101820);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bys();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bys)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpw.FuN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbpw.FuO = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101820);
          return 0;
        case 5: 
          localbpw.GKA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(101820);
          return 0;
        case 6: 
          localbpw.GKB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(101820);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boh();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbpw.FuR = ((boh)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101820);
        return 0;
      }
      AppMethodBeat.o(101820);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bpw
 * JD-Core Version:    0.7.0.1
 */