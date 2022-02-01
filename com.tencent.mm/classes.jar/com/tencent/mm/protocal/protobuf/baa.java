package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class baa
  extends erp
{
  public atz YIY;
  public b ZEQ;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260197);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YIY != null)
      {
        paramVarArgs.qD(2, this.YIY.computeSize());
        this.YIY.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.mMJ);
      paramVarArgs.bv(4, this.object_id);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(5, this.object_nonce_id);
      }
      if (this.username != null) {
        paramVarArgs.g(6, this.username);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(7, this.ZEQ);
      }
      paramVarArgs.bS(8, this.scene);
      AppMethodBeat.o(260197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.mMJ) + i.a.a.b.b.a.q(4, this.object_id);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.object_nonce_id);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.username);
      }
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.ZEQ);
      }
      i = i.a.a.b.b.a.cJ(8, this.scene);
      AppMethodBeat.o(260197);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        baa localbaa = (baa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260197);
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
            localbaa.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260197);
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
            localbaa.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260197);
          return 0;
        case 3: 
          localbaa.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260197);
          return 0;
        case 4: 
          localbaa.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260197);
          return 0;
        case 5: 
          localbaa.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260197);
          return 0;
        case 6: 
          localbaa.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260197);
          return 0;
        case 7: 
          localbaa.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(260197);
          return 0;
        }
        localbaa.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(260197);
        return 0;
      }
      AppMethodBeat.o(260197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.baa
 * JD-Core Version:    0.7.0.1
 */