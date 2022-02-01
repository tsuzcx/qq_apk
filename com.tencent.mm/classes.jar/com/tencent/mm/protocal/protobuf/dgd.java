package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dgd
  extends dop
{
  public SKBuiltinBuffer_t KKZ;
  public SKBuiltinBuffer_t KPW;
  public int KQy;
  public String MrO;
  public String MyQ;
  public String UserName;
  public String oTI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(232380);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KPW == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(232380);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.e(2, this.UserName);
      }
      if (this.MyQ != null) {
        paramVarArgs.e(3, this.MyQ);
      }
      if (this.MrO != null) {
        paramVarArgs.e(4, this.MrO);
      }
      if (this.KPW != null)
      {
        paramVarArgs.ni(5, this.KPW.computeSize());
        this.KPW.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.KQy);
      if (this.oTI != null) {
        paramVarArgs.e(7, this.oTI);
      }
      if (this.KKZ != null)
      {
        paramVarArgs.ni(8, this.KKZ.computeSize());
        this.KKZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(232380);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.UserName);
      }
      i = paramInt;
      if (this.MyQ != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MyQ);
      }
      paramInt = i;
      if (this.MrO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MrO);
      }
      i = paramInt;
      if (this.KPW != null) {
        i = paramInt + g.a.a.a.nh(5, this.KPW.computeSize());
      }
      i += g.a.a.b.b.a.bu(6, this.KQy);
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.oTI);
      }
      i = paramInt;
      if (this.KKZ != null) {
        i = paramInt + g.a.a.a.nh(8, this.KKZ.computeSize());
      }
      AppMethodBeat.o(232380);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KPW == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(232380);
          throw paramVarArgs;
        }
        AppMethodBeat.o(232380);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dgd localdgd = (dgd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(232380);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgd.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232380);
          return 0;
        case 2: 
          localdgd.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232380);
          return 0;
        case 3: 
          localdgd.MyQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232380);
          return 0;
        case 4: 
          localdgd.MrO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232380);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdgd.KPW = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(232380);
          return 0;
        case 6: 
          localdgd.KQy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(232380);
          return 0;
        case 7: 
          localdgd.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(232380);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdgd.KKZ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(232380);
        return 0;
      }
      AppMethodBeat.o(232380);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgd
 * JD-Core Version:    0.7.0.1
 */