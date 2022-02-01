package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bho
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public String ZQW;
  public LinkedList<crp> ZQX;
  public long mMJ;
  public long object_id;
  
  public bho()
  {
    AppMethodBeat.i(257713);
    this.ZQX = new LinkedList();
    AppMethodBeat.o(257713);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257716);
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
      if (this.ZQW != null) {
        paramVarArgs.g(3, this.ZQW);
      }
      if (this.YIZ != null) {
        paramVarArgs.g(4, this.YIZ);
      }
      if (this.YJa != null) {
        paramVarArgs.d(5, this.YJa);
      }
      paramVarArgs.bv(6, this.object_id);
      paramVarArgs.bv(7, this.mMJ);
      paramVarArgs.e(8, 8, this.ZQX);
      AppMethodBeat.o(257716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label816;
      }
    }
    label816:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.ZQW != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZQW);
      }
      paramInt = i;
      if (this.YIZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIZ);
      }
      i = paramInt;
      if (this.YJa != null) {
        i = paramInt + i.a.a.b.b.a.c(5, this.YJa);
      }
      paramInt = i.a.a.b.b.a.q(6, this.object_id);
      int j = i.a.a.b.b.a.q(7, this.mMJ);
      int k = i.a.a.a.c(8, 8, this.ZQX);
      AppMethodBeat.o(257716);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZQX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bho localbho = (bho)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257716);
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
            localbho.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257716);
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
            localbho.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257716);
          return 0;
        case 3: 
          localbho.ZQW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257716);
          return 0;
        case 4: 
          localbho.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257716);
          return 0;
        case 5: 
          localbho.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(257716);
          return 0;
        case 6: 
          localbho.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257716);
          return 0;
        case 7: 
          localbho.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257716);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new crp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((crp)localObject2).parseFrom((byte[])localObject1);
          }
          localbho.ZQX.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257716);
        return 0;
      }
      AppMethodBeat.o(257716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bho
 * JD-Core Version:    0.7.0.1
 */