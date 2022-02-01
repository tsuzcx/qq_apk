package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class ae
  extends erp
{
  public String UserName;
  public z aciX;
  public int acjw;
  public int muC;
  public int vhJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259715);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      if (this.aciX != null)
      {
        paramVarArgs.qD(3, this.aciX.computeSize());
        this.aciX.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(4, this.UserName);
      }
      paramVarArgs.bS(5, this.muC);
      paramVarArgs.bS(6, this.acjw);
      AppMethodBeat.o(259715);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.aciX != null) {
        paramInt = i + i.a.a.a.qC(3, this.aciX.computeSize());
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.UserName);
      }
      paramInt = i.a.a.b.b.a.cJ(5, this.muC);
      int j = i.a.a.b.b.a.cJ(6, this.acjw);
      AppMethodBeat.o(259715);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259715);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259715);
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
            localae.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259715);
          return 0;
        case 2: 
          localae.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259715);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new z();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((z)localObject2).parseFrom((byte[])localObject1);
            }
            localae.aciX = ((z)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259715);
          return 0;
        case 4: 
          localae.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259715);
          return 0;
        case 5: 
          localae.muC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259715);
          return 0;
        }
        localae.acjw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259715);
        return 0;
      }
      AppMethodBeat.o(259715);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.ae
 * JD-Core Version:    0.7.0.1
 */