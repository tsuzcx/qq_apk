package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bfq
  extends erp
{
  public atz YIY;
  public String YIZ;
  public b YJa;
  public LinkedList<Integer> ZPo;
  public long mMJ;
  public long object_id;
  public int scene;
  
  public bfq()
  {
    AppMethodBeat.i(258372);
    this.ZPo = new LinkedList();
    AppMethodBeat.o(258372);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258378);
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
      if (this.YIZ != null) {
        paramVarArgs.g(3, this.YIZ);
      }
      paramVarArgs.e(4, 2, this.ZPo);
      paramVarArgs.bS(5, this.scene);
      if (this.YJa != null) {
        paramVarArgs.d(6, this.YJa);
      }
      paramVarArgs.bv(7, this.mMJ);
      paramVarArgs.bv(8, this.object_id);
      AppMethodBeat.o(258378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label737;
      }
    }
    label737:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YIY != null) {
        paramInt = i + i.a.a.a.qC(2, this.YIY.computeSize());
      }
      i = paramInt;
      if (this.YIZ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIZ);
      }
      i = i + i.a.a.a.c(4, 2, this.ZPo) + i.a.a.b.b.a.cJ(5, this.scene);
      paramInt = i;
      if (this.YJa != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.YJa);
      }
      i = i.a.a.b.b.a.q(7, this.mMJ);
      int j = i.a.a.b.b.a.q(8, this.object_id);
      AppMethodBeat.o(258378);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZPo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bfq localbfq = (bfq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258378);
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
            localbfq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258378);
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
            localbfq.YIY = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258378);
          return 0;
        case 3: 
          localbfq.YIZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258378);
          return 0;
        case 4: 
          localbfq.ZPo.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(258378);
          return 0;
        case 5: 
          localbfq.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258378);
          return 0;
        case 6: 
          localbfq.YJa = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258378);
          return 0;
        case 7: 
          localbfq.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258378);
          return 0;
        }
        localbfq.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258378);
        return 0;
      }
      AppMethodBeat.o(258378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bfq
 * JD-Core Version:    0.7.0.1
 */