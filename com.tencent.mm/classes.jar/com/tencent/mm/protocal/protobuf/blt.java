package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class blt
  extends erp
{
  public atz YIY;
  public b YJa;
  public String ZOX;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259213);
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
      if (this.YJa != null) {
        paramVarArgs.d(3, this.YJa);
      }
      if (this.ZOX != null) {
        paramVarArgs.g(4, this.ZOX);
      }
      paramVarArgs.bv(5, this.object_id);
      paramVarArgs.bv(6, this.mMJ);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(7, this.object_nonce_id);
      }
      AppMethodBeat.o(259213);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YJa);
      }
      paramInt = i;
      if (this.ZOX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZOX);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.object_id) + i.a.a.b.b.a.q(6, this.mMJ);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.object_nonce_id);
      }
      AppMethodBeat.o(259213);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259213);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        blt localblt = (blt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259213);
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
            localblt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259213);
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
            localblt.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259213);
          return 0;
        case 3: 
          localblt.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(259213);
          return 0;
        case 4: 
          localblt.ZOX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259213);
          return 0;
        case 5: 
          localblt.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259213);
          return 0;
        case 6: 
          localblt.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259213);
          return 0;
        }
        localblt.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259213);
        return 0;
      }
      AppMethodBeat.o(259213);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.blt
 * JD-Core Version:    0.7.0.1
 */