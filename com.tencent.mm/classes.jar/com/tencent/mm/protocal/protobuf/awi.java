package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class awi
  extends erp
{
  public atz CJv;
  public String ZHf;
  public long id;
  public String objectNonceId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168950);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.id);
      if (this.ZHf != null) {
        paramVarArgs.g(3, this.ZHf);
      }
      if (this.objectNonceId != null) {
        paramVarArgs.g(4, this.objectNonceId);
      }
      if (this.CJv != null)
      {
        paramVarArgs.qD(5, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168950);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.id);
      paramInt = i;
      if (this.ZHf != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZHf);
      }
      i = paramInt;
      if (this.objectNonceId != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.objectNonceId);
      }
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(5, this.CJv.computeSize());
      }
      AppMethodBeat.o(168950);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        awi localawi = (awi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168950);
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
            localawi.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168950);
          return 0;
        case 2: 
          localawi.id = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(168950);
          return 0;
        case 3: 
          localawi.ZHf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168950);
          return 0;
        case 4: 
          localawi.objectNonceId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(168950);
          return 0;
        }
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
          localawi.CJv = ((atz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(168950);
        return 0;
      }
      AppMethodBeat.o(168950);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awi
 * JD-Core Version:    0.7.0.1
 */