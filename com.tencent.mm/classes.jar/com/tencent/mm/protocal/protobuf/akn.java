package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class akn
  extends cpx
{
  public aiu EDu;
  public b lastBuffer;
  public String objectNonceId;
  public long qXP;
  public String rfC;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195068);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.EDu != null)
      {
        paramVarArgs.ln(2, this.EDu.computeSize());
        this.EDu.writeFields(paramVarArgs);
      }
      if (this.rfC != null) {
        paramVarArgs.d(3, this.rfC);
      }
      paramVarArgs.aR(4, this.scene);
      if (this.lastBuffer != null) {
        paramVarArgs.c(5, this.lastBuffer);
      }
      paramVarArgs.aO(6, this.qXP);
      if (this.objectNonceId != null) {
        paramVarArgs.d(7, this.objectNonceId);
      }
      AppMethodBeat.o(195068);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label738;
      }
    }
    label738:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EDu != null) {
        paramInt = i + f.a.a.a.lm(2, this.EDu.computeSize());
      }
      i = paramInt;
      if (this.rfC != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.rfC);
      }
      i += f.a.a.b.b.a.bx(4, this.scene);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.lastBuffer);
      }
      i = paramInt + f.a.a.b.b.a.p(6, this.qXP);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.objectNonceId);
      }
      AppMethodBeat.o(195068);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195068);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        akn localakn = (akn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(195068);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195068);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aiu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aiu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localakn.EDu = ((aiu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(195068);
          return 0;
        case 3: 
          localakn.rfC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(195068);
          return 0;
        case 4: 
          localakn.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(195068);
          return 0;
        case 5: 
          localakn.lastBuffer = ((f.a.a.a.a)localObject1).LVo.gfk();
          AppMethodBeat.o(195068);
          return 0;
        case 6: 
          localakn.qXP = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(195068);
          return 0;
        }
        localakn.objectNonceId = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(195068);
        return 0;
      }
      AppMethodBeat.o(195068);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akn
 * JD-Core Version:    0.7.0.1
 */