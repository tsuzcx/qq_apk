package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class xz
  extends erp
{
  public int Zae = 4;
  public b Zgv;
  public b Zgw;
  public int amount;
  public String wZg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91410);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.amount);
      if (this.Zgv != null) {
        paramVarArgs.d(3, this.Zgv);
      }
      if (this.Zgw != null) {
        paramVarArgs.d(4, this.Zgw);
      }
      if (this.wZg != null) {
        paramVarArgs.g(5, this.wZg);
      }
      paramVarArgs.bS(6, this.Zae);
      AppMethodBeat.o(91410);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label556;
      }
    }
    label556:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.amount);
      paramInt = i;
      if (this.Zgv != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.Zgv);
      }
      i = paramInt;
      if (this.Zgw != null) {
        i = paramInt + i.a.a.b.b.a.c(4, this.Zgw);
      }
      paramInt = i;
      if (this.wZg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.wZg);
      }
      i = i.a.a.b.b.a.cJ(6, this.Zae);
      AppMethodBeat.o(91410);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91410);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        xz localxz = (xz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91410);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localxz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91410);
          return 0;
        case 2: 
          localxz.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91410);
          return 0;
        case 3: 
          localxz.Zgv = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91410);
          return 0;
        case 4: 
          localxz.Zgw = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(91410);
          return 0;
        case 5: 
          localxz.wZg = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91410);
          return 0;
        }
        localxz.Zae = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91410);
        return 0;
      }
      AppMethodBeat.o(91410);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xz
 * JD-Core Version:    0.7.0.1
 */