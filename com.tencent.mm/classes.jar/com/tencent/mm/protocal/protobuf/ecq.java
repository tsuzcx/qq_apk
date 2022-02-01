package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ecq
  extends com.tencent.mm.bw.a
{
  public mp NcM;
  public epf NcN;
  public cxr NcO;
  public long NcP;
  public int NcQ;
  public long NcR;
  public long NcS;
  public b NcT;
  public long NcU;
  public String NcV;
  public long NcW;
  public String finderUsername;
  public long hFK;
  public int mediaType;
  public String objectNonceId;
  public String sessionBuffer;
  public int tCE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169091);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.hFK);
      if (this.NcM != null)
      {
        paramVarArgs.ni(2, this.NcM.computeSize());
        this.NcM.writeFields(paramVarArgs);
      }
      if (this.NcN != null)
      {
        paramVarArgs.ni(3, this.NcN.computeSize());
        this.NcN.writeFields(paramVarArgs);
      }
      if (this.NcO != null)
      {
        paramVarArgs.ni(4, this.NcO.computeSize());
        this.NcO.writeFields(paramVarArgs);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.e(5, this.objectNonceId);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(6, this.finderUsername);
      }
      paramVarArgs.bb(7, this.NcP);
      paramVarArgs.aM(8, this.NcQ);
      if (this.sessionBuffer != null) {
        paramVarArgs.e(9, this.sessionBuffer);
      }
      paramVarArgs.bb(10, this.NcR);
      paramVarArgs.aM(11, this.tCE);
      paramVarArgs.bb(12, this.NcS);
      if (this.NcT != null) {
        paramVarArgs.c(13, this.NcT);
      }
      paramVarArgs.aM(14, this.mediaType);
      paramVarArgs.bb(15, this.NcU);
      if (this.NcV != null) {
        paramVarArgs.e(16, this.NcV);
      }
      paramVarArgs.bb(17, this.NcW);
      AppMethodBeat.o(169091);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.hFK) + 0;
      paramInt = i;
      if (this.NcM != null) {
        paramInt = i + g.a.a.a.nh(2, this.NcM.computeSize());
      }
      i = paramInt;
      if (this.NcN != null) {
        i = paramInt + g.a.a.a.nh(3, this.NcN.computeSize());
      }
      paramInt = i;
      if (this.NcO != null) {
        paramInt = i + g.a.a.a.nh(4, this.NcO.computeSize());
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.objectNonceId);
      }
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.finderUsername);
      }
      i = paramInt + g.a.a.b.b.a.r(7, this.NcP) + g.a.a.b.b.a.bu(8, this.NcQ);
      paramInt = i;
      if (this.sessionBuffer != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.sessionBuffer);
      }
      i = paramInt + g.a.a.b.b.a.r(10, this.NcR) + g.a.a.b.b.a.bu(11, this.tCE) + g.a.a.b.b.a.r(12, this.NcS);
      paramInt = i;
      if (this.NcT != null) {
        paramInt = i + g.a.a.b.b.a.b(13, this.NcT);
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.mediaType) + g.a.a.b.b.a.r(15, this.NcU);
      paramInt = i;
      if (this.NcV != null) {
        paramInt = i + g.a.a.b.b.a.f(16, this.NcV);
      }
      i = g.a.a.b.b.a.r(17, this.NcW);
      AppMethodBeat.o(169091);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(169091);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ecq localecq = (ecq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169091);
        return -1;
      case 1: 
        localecq.hFK = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169091);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new mp();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((mp)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecq.NcM = ((mp)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 3: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new epf();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((epf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecq.NcN = ((epf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localecq.NcO = ((cxr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169091);
        return 0;
      case 5: 
        localecq.objectNonceId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 6: 
        localecq.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 7: 
        localecq.NcP = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169091);
        return 0;
      case 8: 
        localecq.NcQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169091);
        return 0;
      case 9: 
        localecq.sessionBuffer = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169091);
        return 0;
      case 10: 
        localecq.NcR = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169091);
        return 0;
      case 11: 
        localecq.tCE = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169091);
        return 0;
      case 12: 
        localecq.NcS = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169091);
        return 0;
      case 13: 
        localecq.NcT = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(169091);
        return 0;
      case 14: 
        localecq.mediaType = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(169091);
        return 0;
      case 15: 
        localecq.NcU = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(169091);
        return 0;
      case 16: 
        localecq.NcV = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169091);
        return 0;
      }
      localecq.NcW = ((g.a.a.a.a)localObject1).UbS.zl();
      AppMethodBeat.o(169091);
      return 0;
    }
    AppMethodBeat.o(169091);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecq
 * JD-Core Version:    0.7.0.1
 */