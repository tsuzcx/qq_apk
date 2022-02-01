package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bic
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public LinkedList<String> ZRj;
  public long mMJ;
  public long object_id;
  public String object_nonce_id;
  public int scene;
  
  public bic()
  {
    AppMethodBeat.i(257558);
    this.ZRj = new LinkedList();
    AppMethodBeat.o(257558);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257564);
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
      paramVarArgs.e(4, 1, this.ZRj);
      paramVarArgs.bv(5, this.object_id);
      paramVarArgs.bv(6, this.mMJ);
      if (this.object_nonce_id != null) {
        paramVarArgs.g(7, this.object_nonce_id);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(8, this.YIZ);
      }
      paramVarArgs.bS(9, this.scene);
      AppMethodBeat.o(257564);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label794;
      }
    }
    label794:
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
      i = i + i.a.a.a.c(4, 1, this.ZRj) + i.a.a.b.b.a.q(5, this.object_id) + i.a.a.b.b.a.q(6, this.mMJ);
      paramInt = i;
      if (this.object_nonce_id != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.object_nonce_id);
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.YIZ);
      }
      paramInt = i.a.a.b.b.a.cJ(9, this.scene);
      AppMethodBeat.o(257564);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZRj.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257564);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bic localbic = (bic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257564);
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
            localbic.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257564);
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
            localbic.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257564);
          return 0;
        case 3: 
          localbic.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257564);
          return 0;
        case 4: 
          localbic.ZRj.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(257564);
          return 0;
        case 5: 
          localbic.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257564);
          return 0;
        case 6: 
          localbic.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257564);
          return 0;
        case 7: 
          localbic.object_nonce_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257564);
          return 0;
        case 8: 
          localbic.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257564);
          return 0;
        }
        localbic.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257564);
        return 0;
      }
      AppMethodBeat.o(257564);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bic
 * JD-Core Version:    0.7.0.1
 */