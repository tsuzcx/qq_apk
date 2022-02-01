package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cih
  extends ckq
{
  public String Dek;
  public div EdJ;
  public ddj EdK;
  public int fVD;
  public int mBH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56259);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EdJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserPosition");
        AppMethodBeat.o(56259);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Dek != null) {
        paramVarArgs.d(2, this.Dek);
      }
      paramVarArgs.aR(3, this.mBH);
      if (this.EdJ != null)
      {
        paramVarArgs.kX(4, this.EdJ.computeSize());
        this.EdJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.fVD);
      if (this.EdK != null)
      {
        paramVarArgs.kX(6, this.EdK.computeSize());
        this.EdK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56259);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Dek != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Dek);
      }
      i += f.a.a.b.b.a.bA(3, this.mBH);
      paramInt = i;
      if (this.EdJ != null) {
        paramInt = i + f.a.a.a.kW(4, this.EdJ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.fVD);
      paramInt = i;
      if (this.EdK != null) {
        paramInt = i + f.a.a.a.kW(6, this.EdK.computeSize());
      }
      AppMethodBeat.o(56259);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.EdJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserPosition");
          AppMethodBeat.o(56259);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cih localcih = (cih)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56259);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcih.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 2: 
          localcih.Dek = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(56259);
          return 0;
        case 3: 
          localcih.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56259);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new div();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((div)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcih.EdJ = ((div)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56259);
          return 0;
        case 5: 
          localcih.fVD = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(56259);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ddj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcih.EdK = ((ddj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56259);
        return 0;
      }
      AppMethodBeat.o(56259);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cih
 * JD-Core Version:    0.7.0.1
 */