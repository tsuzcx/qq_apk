package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class yg
  extends ckq
{
  public String CBS;
  public String Daj;
  public String Dak;
  public String hnC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32172);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Daj == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.CBS == null)
      {
        paramVarArgs = new b("Not all required fields were included: DeviceType");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.Dak == null)
      {
        paramVarArgs = new b("Not all required fields were included: ClientInfo");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.hnC == null)
      {
        paramVarArgs = new b("Not all required fields were included: AppId");
        AppMethodBeat.o(32172);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Daj != null) {
        paramVarArgs.d(2, this.Daj);
      }
      if (this.CBS != null) {
        paramVarArgs.d(3, this.CBS);
      }
      if (this.Dak != null) {
        paramVarArgs.d(4, this.Dak);
      }
      if (this.hnC != null) {
        paramVarArgs.d(5, this.hnC);
      }
      AppMethodBeat.o(32172);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label761;
      }
    }
    label761:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Daj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Daj);
      }
      i = paramInt;
      if (this.CBS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CBS);
      }
      paramInt = i;
      if (this.Dak != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dak);
      }
      i = paramInt;
      if (this.hnC != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.hnC);
      }
      AppMethodBeat.o(32172);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Daj == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.CBS == null)
        {
          paramVarArgs = new b("Not all required fields were included: DeviceType");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.Dak == null)
        {
          paramVarArgs = new b("Not all required fields were included: ClientInfo");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        if (this.hnC == null)
        {
          paramVarArgs = new b("Not all required fields were included: AppId");
          AppMethodBeat.o(32172);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32172);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yg localyg = (yg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32172);
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
            localyg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32172);
          return 0;
        case 2: 
          localyg.Daj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 3: 
          localyg.CBS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32172);
          return 0;
        case 4: 
          localyg.Dak = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32172);
          return 0;
        }
        localyg.hnC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32172);
        return 0;
      }
      AppMethodBeat.o(32172);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */