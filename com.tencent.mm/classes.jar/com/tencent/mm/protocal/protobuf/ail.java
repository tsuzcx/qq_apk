package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ail
  extends ckq
{
  public aht Dkw;
  public int Dld;
  public int Dle;
  public long id;
  public String objectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168960);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.id);
      paramVarArgs.aR(3, this.Dld);
      paramVarArgs.aR(4, this.Dle);
      if (this.objectNonceId != null) {
        paramVarArgs.d(5, this.objectNonceId);
      }
      if (this.Dkw != null)
      {
        paramVarArgs.kX(6, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.d(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.id) + f.a.a.b.b.a.bA(3, this.Dld) + f.a.a.b.b.a.bA(4, this.Dle);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.objectNonceId);
      }
      i = paramInt;
      if (this.Dkw != null) {
        i = paramInt + f.a.a.a.kW(6, this.Dkw.computeSize());
      }
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.sessionBuffer);
      }
      AppMethodBeat.o(168960);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168960);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ail localail = (ail)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168960);
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
            localail.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        case 2: 
          localail.id = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(168960);
          return 0;
        case 3: 
          localail.Dld = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168960);
          return 0;
        case 4: 
          localail.Dle = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168960);
          return 0;
        case 5: 
          localail.objectNonceId = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168960);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localail.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168960);
          return 0;
        }
        localail.sessionBuffer = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(168960);
        return 0;
      }
      AppMethodBeat.o(168960);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ail
 * JD-Core Version:    0.7.0.1
 */