package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axp
  extends erp
{
  public int ACR;
  public atz CJv;
  public String ZHf;
  public bma ZIR;
  public String finderUsername;
  public int opType;
  public long refObjectId;
  public String refObjectNonceId;
  public String sessionBuffer;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168964);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZHf != null) {
        paramVarArgs.g(2, this.ZHf);
      }
      paramVarArgs.bS(3, this.opType);
      paramVarArgs.bv(4, this.refObjectId);
      if (this.finderUsername != null) {
        paramVarArgs.g(5, this.finderUsername);
      }
      if (this.refObjectNonceId != null) {
        paramVarArgs.g(6, this.refObjectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(7, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.sessionBuffer != null) {
        paramVarArgs.g(8, this.sessionBuffer);
      }
      paramVarArgs.bS(9, this.ACR);
      if (this.ZIR != null)
      {
        paramVarArgs.qD(10, this.ZIR.computeSize());
        this.ZIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168964);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label928;
      }
    }
    label928:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZHf != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZHf);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.opType) + i.a.a.b.b.a.q(4, this.refObjectId);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.finderUsername);
      }
      i = paramInt;
      if (this.refObjectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.refObjectNonceId);
      }
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(7, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.sessionBuffer != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.sessionBuffer);
      }
      i += i.a.a.b.b.a.cJ(9, this.ACR);
      paramInt = i;
      if (this.ZIR != null) {
        paramInt = i + i.a.a.a.qC(10, this.ZIR.computeSize());
      }
      AppMethodBeat.o(168964);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        axp localaxp = (axp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168964);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaxp.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 2: 
          localaxp.ZHf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 3: 
          localaxp.opType = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168964);
          return 0;
        case 4: 
          localaxp.refObjectId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168964);
          return 0;
        case 5: 
          localaxp.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 6: 
          localaxp.refObjectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localaxp.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168964);
          return 0;
        case 8: 
          localaxp.sessionBuffer = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168964);
          return 0;
        case 9: 
          localaxp.ACR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(168964);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bma();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bma)localObject2).parseFrom((byte[])localObject1);
          }
          localaxp.ZIR = ((bma)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168964);
        return 0;
      }
      AppMethodBeat.o(168964);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axp
 * JD-Core Version:    0.7.0.1
 */