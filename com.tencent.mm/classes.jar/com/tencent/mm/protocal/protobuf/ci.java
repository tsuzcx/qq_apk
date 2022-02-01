package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ci
  extends erp
{
  public String YEv;
  public LinkedList<ch> YEw;
  public String mdG;
  
  public ci()
  {
    AppMethodBeat.i(259606);
    this.YEw = new LinkedList();
    AppMethodBeat.o(259606);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259612);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YEv != null) {
        paramVarArgs.g(2, this.YEv);
      }
      if (this.mdG != null) {
        paramVarArgs.g(3, this.mdG);
      }
      paramVarArgs.e(4, 8, this.YEw);
      AppMethodBeat.o(259612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YEv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YEv);
      }
      i = paramInt;
      if (this.mdG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.mdG);
      }
      paramInt = i.a.a.a.c(4, 8, this.YEw);
      AppMethodBeat.o(259612);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YEw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ci localci = (ci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259612);
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
            localci.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259612);
          return 0;
        case 2: 
          localci.YEv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259612);
          return 0;
        case 3: 
          localci.mdG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259612);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ch();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ch)localObject2).parseFrom((byte[])localObject1);
          }
          localci.YEw.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259612);
        return 0;
      }
      AppMethodBeat.o(259612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ci
 * JD-Core Version:    0.7.0.1
 */