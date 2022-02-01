package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class alt
  extends ckq
{
  public aht Dkw;
  public String Dls;
  public int DmP;
  public String firstPageMD5;
  public b lastBuffer;
  public String username;
  public long wET;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169070);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      paramVarArgs.aG(3, this.wET);
      if (this.firstPageMD5 != null) {
        paramVarArgs.d(4, this.firstPageMD5);
      }
      if (this.Dls != null) {
        paramVarArgs.d(5, this.Dls);
      }
      paramVarArgs.aR(6, this.DmP);
      if (this.Dkw != null)
      {
        paramVarArgs.kX(7, this.Dkw.computeSize());
        this.Dkw.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label798;
      }
    }
    label798:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.username);
      }
      i += f.a.a.b.b.a.q(3, this.wET);
      paramInt = i;
      if (this.firstPageMD5 != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.firstPageMD5);
      }
      i = paramInt;
      if (this.Dls != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Dls);
      }
      i += f.a.a.b.b.a.bA(6, this.DmP);
      paramInt = i;
      if (this.Dkw != null) {
        paramInt = i + f.a.a.a.kW(7, this.Dkw.computeSize());
      }
      i = paramInt;
      if (this.lastBuffer != null) {
        i = paramInt + f.a.a.b.b.a.b(8, this.lastBuffer);
      }
      AppMethodBeat.o(169070);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169070);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        alt localalt = (alt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169070);
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
            localalt.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        case 2: 
          localalt.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 3: 
          localalt.wET = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169070);
          return 0;
        case 4: 
          localalt.firstPageMD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 5: 
          localalt.Dls = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169070);
          return 0;
        case 6: 
          localalt.DmP = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169070);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aht();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aht)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localalt.Dkw = ((aht)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169070);
          return 0;
        }
        localalt.lastBuffer = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(169070);
        return 0;
      }
      AppMethodBeat.o(169070);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alt
 * JD-Core Version:    0.7.0.1
 */