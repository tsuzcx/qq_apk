package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class yg
  extends erp
{
  public int ZgV;
  public String ZgW;
  public int ZgX;
  public b Zgu;
  public int amount;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258345);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZgV);
      paramVarArgs.bS(3, this.amount);
      if (this.ZgW != null) {
        paramVarArgs.g(4, this.ZgW);
      }
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      paramVarArgs.bS(6, this.ZgX);
      if (this.Zgu != null) {
        paramVarArgs.d(7, this.Zgu);
      }
      AppMethodBeat.o(258345);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZgV) + i.a.a.b.b.a.cJ(3, this.amount);
      paramInt = i;
      if (this.ZgW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZgW);
      }
      i = paramInt;
      if (this.url != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.url);
      }
      i += i.a.a.b.b.a.cJ(6, this.ZgX);
      paramInt = i;
      if (this.Zgu != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.Zgu);
      }
      AppMethodBeat.o(258345);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258345);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yg localyg = (yg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258345);
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
            localyg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258345);
          return 0;
        case 2: 
          localyg.ZgV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258345);
          return 0;
        case 3: 
          localyg.amount = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258345);
          return 0;
        case 4: 
          localyg.ZgW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258345);
          return 0;
        case 5: 
          localyg.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258345);
          return 0;
        case 6: 
          localyg.ZgX = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258345);
          return 0;
        }
        localyg.Zgu = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(258345);
        return 0;
      }
      AppMethodBeat.o(258345);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yg
 * JD-Core Version:    0.7.0.1
 */