package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bls
  extends ckq
{
  public int dvW;
  public String gHO;
  public String pfl;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.pfl == null)
      {
        paramVarArgs = new b("Not all required fields were included: appusername");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.gHO == null)
      {
        paramVarArgs = new b("Not all required fields were included: rankid");
        AppMethodBeat.o(32336);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.pfl != null) {
        paramVarArgs.d(3, this.pfl);
      }
      paramVarArgs.aR(4, this.dvW);
      if (this.gHO != null) {
        paramVarArgs.d(5, this.gHO);
      }
      AppMethodBeat.o(32336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label697;
      }
    }
    label697:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.pfl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.pfl);
      }
      i += f.a.a.b.b.a.bA(4, this.dvW);
      paramInt = i;
      if (this.gHO != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.gHO);
      }
      AppMethodBeat.o(32336);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.pfl == null)
        {
          paramVarArgs = new b("Not all required fields were included: appusername");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        if (this.gHO == null)
        {
          paramVarArgs = new b("Not all required fields were included: rankid");
          AppMethodBeat.o(32336);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bls localbls = (bls)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32336);
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
            localbls.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32336);
          return 0;
        case 2: 
          localbls.username = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 3: 
          localbls.pfl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32336);
          return 0;
        case 4: 
          localbls.dvW = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32336);
          return 0;
        }
        localbls.gHO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32336);
        return 0;
      }
      AppMethodBeat.o(32336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bls
 * JD-Core Version:    0.7.0.1
 */