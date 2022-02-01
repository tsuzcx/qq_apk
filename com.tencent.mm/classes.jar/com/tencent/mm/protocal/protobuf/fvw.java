package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fvw
  extends erp
{
  public int aaog;
  public dbf aaom;
  public dbg aaon;
  public int hUo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72622);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaog);
      paramVarArgs.bS(3, this.hUo);
      if (this.aaom != null)
      {
        paramVarArgs.qD(4, this.aaom.computeSize());
        this.aaom.writeFields(paramVarArgs);
      }
      if (this.aaon != null)
      {
        paramVarArgs.qD(5, this.aaon.computeSize());
        this.aaon.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72622);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label636;
      }
    }
    label636:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aaog) + i.a.a.b.b.a.cJ(3, this.hUo);
      paramInt = i;
      if (this.aaom != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaom.computeSize());
      }
      i = paramInt;
      if (this.aaon != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaon.computeSize());
      }
      AppMethodBeat.o(72622);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fvw localfvw = (fvw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72622);
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
            localfvw.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        case 2: 
          localfvw.aaog = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72622);
          return 0;
        case 3: 
          localfvw.hUo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72622);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dbf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dbf)localObject2).parseFrom((byte[])localObject1);
            }
            localfvw.aaom = ((dbf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72622);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbg();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbg)localObject2).parseFrom((byte[])localObject1);
          }
          localfvw.aaon = ((dbg)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72622);
        return 0;
      }
      AppMethodBeat.o(72622);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvw
 * JD-Core Version:    0.7.0.1
 */