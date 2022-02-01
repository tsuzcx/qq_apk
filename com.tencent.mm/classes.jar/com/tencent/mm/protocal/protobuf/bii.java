package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bii
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public String ZQJ;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257413);
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
      paramVarArgs.bv(3, this.object_id);
      paramVarArgs.bv(4, this.mMJ);
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      if (this.object_nonce_id != null) {
        paramVarArgs.g(6, this.object_nonce_id);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(7, this.YIZ);
      }
      paramVarArgs.bS(8, this.scene);
      if (this.ZQJ != null) {
        paramVarArgs.g(9, this.ZQJ);
      }
      AppMethodBeat.o(257413);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.object_id) + i.a.a.b.b.a.q(4, this.mMJ);
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.YJa);
      }
      i = paramInt;
      if (this.object_nonce_id != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.object_nonce_id);
      }
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YIZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.scene);
      paramInt = i;
      if (this.ZQJ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZQJ);
      }
      AppMethodBeat.o(257413);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257413);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bii localbii = (bii)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257413);
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
            localbii.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257413);
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
            localbii.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257413);
          return 0;
        case 3: 
          localbii.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257413);
          return 0;
        case 4: 
          localbii.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257413);
          return 0;
        case 5: 
          localbii.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257413);
          return 0;
        case 6: 
          localbii.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257413);
          return 0;
        case 7: 
          localbii.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257413);
          return 0;
        case 8: 
          localbii.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257413);
          return 0;
        }
        localbii.ZQJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(257413);
        return 0;
      }
      AppMethodBeat.o(257413);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bii
 * JD-Core Version:    0.7.0.1
 */