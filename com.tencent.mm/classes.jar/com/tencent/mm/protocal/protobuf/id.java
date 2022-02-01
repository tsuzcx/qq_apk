package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class id
  extends dop
{
  public int KCx;
  public String KLL;
  public String KLO;
  public SKBuiltinBuffer_t KLQ;
  public SKBuiltinBuffer_t KMo;
  public String keb;
  public String oTI;
  public String rBH;
  public String rBI;
  public int xMB;
  public String yiZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133150);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KMo == null)
      {
        paramVarArgs = new b("Not all required fields were included: AxTicket");
        AppMethodBeat.o(133150);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.xMB);
      if (this.KMo != null)
      {
        paramVarArgs.ni(3, this.KMo.computeSize());
        this.KMo.writeFields(paramVarArgs);
      }
      if (this.yiZ != null) {
        paramVarArgs.e(4, this.yiZ);
      }
      if (this.KLL != null) {
        paramVarArgs.e(5, this.KLL);
      }
      if (this.keb != null) {
        paramVarArgs.e(6, this.keb);
      }
      if (this.oTI != null) {
        paramVarArgs.e(7, this.oTI);
      }
      if (this.KLO != null) {
        paramVarArgs.e(8, this.KLO);
      }
      if (this.rBI != null) {
        paramVarArgs.e(9, this.rBI);
      }
      if (this.rBH != null) {
        paramVarArgs.e(10, this.rBH);
      }
      paramVarArgs.aM(11, this.KCx);
      if (this.KLQ != null)
      {
        paramVarArgs.ni(12, this.KLQ.computeSize());
        this.KLQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133150);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.xMB);
      paramInt = i;
      if (this.KMo != null) {
        paramInt = i + g.a.a.a.nh(3, this.KMo.computeSize());
      }
      i = paramInt;
      if (this.yiZ != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.yiZ);
      }
      paramInt = i;
      if (this.KLL != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KLL);
      }
      i = paramInt;
      if (this.keb != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.keb);
      }
      paramInt = i;
      if (this.oTI != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.oTI);
      }
      i = paramInt;
      if (this.KLO != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KLO);
      }
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.rBI);
      }
      i = paramInt;
      if (this.rBH != null) {
        i = paramInt + g.a.a.b.b.a.f(10, this.rBH);
      }
      i += g.a.a.b.b.a.bu(11, this.KCx);
      paramInt = i;
      if (this.KLQ != null) {
        paramInt = i + g.a.a.a.nh(12, this.KLQ.computeSize());
      }
      AppMethodBeat.o(133150);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.KMo == null)
        {
          paramVarArgs = new b("Not all required fields were included: AxTicket");
          AppMethodBeat.o(133150);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        id localid = (id)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133150);
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
            localid.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 2: 
          localid.xMB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133150);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localid.KMo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133150);
          return 0;
        case 4: 
          localid.yiZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 5: 
          localid.KLL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 6: 
          localid.keb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 7: 
          localid.oTI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 8: 
          localid.KLO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 9: 
          localid.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 10: 
          localid.rBH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(133150);
          return 0;
        case 11: 
          localid.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133150);
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
          localid.KLQ = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(133150);
        return 0;
      }
      AppMethodBeat.o(133150);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.id
 * JD-Core Version:    0.7.0.1
 */