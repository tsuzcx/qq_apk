package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bvf
  extends erp
{
  public atz ZEc;
  public b ZQg;
  public long aacM;
  public long aacN;
  public String finderUsername;
  public long hKN;
  public long liveId;
  public int liveStatus;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258951);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.liveId);
      if (this.ZQg != null) {
        paramVarArgs.d(4, this.ZQg);
      }
      paramVarArgs.bv(5, this.hKN);
      if (this.finderUsername != null) {
        paramVarArgs.g(6, this.finderUsername);
      }
      paramVarArgs.bS(7, this.liveStatus);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(8, this.object_nonce_id);
      }
      paramVarArgs.bv(9, this.aacM);
      paramVarArgs.bv(10, this.aacN);
      AppMethodBeat.o(258951);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label830;
      }
    }
    label830:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i += i.a.a.b.b.a.q(3, this.liveId);
      paramInt = i;
      if (this.ZQg != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZQg);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.hKN);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.finderUsername);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.liveStatus);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.object_nonce_id);
      }
      i = i.a.a.b.b.a.q(9, this.aacM);
      int j = i.a.a.b.b.a.q(10, this.aacN);
      AppMethodBeat.o(258951);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258951);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bvf localbvf = (bvf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258951);
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
            localbvf.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258951);
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
            localbvf.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258951);
          return 0;
        case 3: 
          localbvf.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258951);
          return 0;
        case 4: 
          localbvf.ZQg = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258951);
          return 0;
        case 5: 
          localbvf.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258951);
          return 0;
        case 6: 
          localbvf.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258951);
          return 0;
        case 7: 
          localbvf.liveStatus = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258951);
          return 0;
        case 8: 
          localbvf.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258951);
          return 0;
        case 9: 
          localbvf.aacM = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258951);
          return 0;
        }
        localbvf.aacN = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258951);
        return 0;
      }
      AppMethodBeat.o(258951);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvf
 * JD-Core Version:    0.7.0.1
 */