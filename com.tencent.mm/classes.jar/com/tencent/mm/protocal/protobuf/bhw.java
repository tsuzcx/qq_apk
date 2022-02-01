package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bhw
  extends erp
{
  public atz YIY;
  public b ZRc;
  public b ZRd;
  public b ZRe;
  public String jump_id;
  public long mMJ;
  public long object_id;
  public int scene;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257600);
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
      paramVarArgs.bS(5, this.type);
      if (this.jump_id != null) {
        paramVarArgs.g(6, this.jump_id);
      }
      if (this.ZRc != null) {
        paramVarArgs.d(7, this.ZRc);
      }
      if (this.ZRd != null) {
        paramVarArgs.d(101, this.ZRd);
      }
      if (this.ZRe != null) {
        paramVarArgs.d(102, this.ZRe);
      }
      paramVarArgs.bS(103, this.scene);
      AppMethodBeat.o(257600);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label874;
      }
    }
    label874:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YIY != null) {
        i = paramInt + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.object_id) + i.a.a.b.b.a.q(4, this.mMJ) + i.a.a.b.b.a.cJ(5, this.type);
      paramInt = i;
      if (this.jump_id != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.jump_id);
      }
      i = paramInt;
      if (this.ZRc != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.ZRc);
      }
      paramInt = i;
      if (this.ZRd != null) {
        paramInt = i + i.a.a.b.b.a.c(101, this.ZRd);
      }
      i = paramInt;
      if (this.ZRe != null) {
        i = paramInt + i.a.a.b.b.a.c(102, this.ZRe);
      }
      paramInt = i.a.a.b.b.a.cJ(103, this.scene);
      AppMethodBeat.o(257600);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257600);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bhw localbhw = (bhw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257600);
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
            localbhw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257600);
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
            localbhw.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257600);
          return 0;
        case 3: 
          localbhw.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257600);
          return 0;
        case 4: 
          localbhw.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257600);
          return 0;
        case 5: 
          localbhw.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257600);
          return 0;
        case 6: 
          localbhw.jump_id = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257600);
          return 0;
        case 7: 
          localbhw.ZRc = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257600);
          return 0;
        case 101: 
          localbhw.ZRd = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257600);
          return 0;
        case 102: 
          localbhw.ZRe = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257600);
          return 0;
        }
        localbhw.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(257600);
        return 0;
      }
      AppMethodBeat.o(257600);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhw
 * JD-Core Version:    0.7.0.1
 */