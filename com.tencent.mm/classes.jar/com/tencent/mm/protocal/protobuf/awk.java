package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class awk
  extends erp
{
  public long AAW;
  public long ABR;
  public int ABS;
  public atz CJv;
  public b ZHg;
  public long refObjectId;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260254);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(2, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bv(4, this.ABR);
      if (this.ZHg != null) {
        paramVarArgs.d(5, this.ZHg);
      }
      paramVarArgs.bv(6, this.refObjectId);
      paramVarArgs.bv(7, this.AAW);
      paramVarArgs.bS(8, this.ABS);
      AppMethodBeat.o(260254);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(2, this.CJv.computeSize());
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.username);
      }
      i += i.a.a.b.b.a.q(4, this.ABR);
      paramInt = i;
      if (this.ZHg != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.ZHg);
      }
      i = i.a.a.b.b.a.q(6, this.refObjectId);
      int j = i.a.a.b.b.a.q(7, this.AAW);
      int k = i.a.a.b.b.a.cJ(8, this.ABS);
      AppMethodBeat.o(260254);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260254);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awk localawk = (awk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260254);
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
            localawk.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260254);
          return 0;
        case 2: 
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
            localawk.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260254);
          return 0;
        case 3: 
          localawk.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260254);
          return 0;
        case 4: 
          localawk.ABR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260254);
          return 0;
        case 5: 
          localawk.ZHg = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260254);
          return 0;
        case 6: 
          localawk.refObjectId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260254);
          return 0;
        case 7: 
          localawk.AAW = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260254);
          return 0;
        }
        localawk.ABS = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260254);
        return 0;
      }
      AppMethodBeat.o(260254);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awk
 * JD-Core Version:    0.7.0.1
 */