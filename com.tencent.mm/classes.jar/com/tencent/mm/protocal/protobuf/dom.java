package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dom
  extends com.tencent.mm.bx.a
{
  public doi EEP;
  public dny EEQ;
  public String EER;
  public String EES;
  public String EET;
  public int EEU;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147809);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EEP != null)
      {
        paramVarArgs.kX(1, this.EEP.computeSize());
        this.EEP.writeFields(paramVarArgs);
      }
      if (this.EEQ != null)
      {
        paramVarArgs.kX(2, this.EEQ.computeSize());
        this.EEQ.writeFields(paramVarArgs);
      }
      if (this.EER != null) {
        paramVarArgs.d(3, this.EER);
      }
      if (this.EES != null) {
        paramVarArgs.d(4, this.EES);
      }
      if (this.EET != null) {
        paramVarArgs.d(5, this.EET);
      }
      paramVarArgs.aR(6, this.EEU);
      AppMethodBeat.o(147809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EEP == null) {
        break label690;
      }
    }
    label690:
    for (int i = f.a.a.a.kW(1, this.EEP.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EEQ != null) {
        paramInt = i + f.a.a.a.kW(2, this.EEQ.computeSize());
      }
      i = paramInt;
      if (this.EER != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EER);
      }
      paramInt = i;
      if (this.EES != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EES);
      }
      i = paramInt;
      if (this.EET != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EET);
      }
      paramInt = f.a.a.b.b.a.bA(6, this.EEU);
      AppMethodBeat.o(147809);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(147809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dom localdom = (dom)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147809);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new doi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((doi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdom.EEP = ((doi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dny();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdom.EEQ = ((dny)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147809);
          return 0;
        case 3: 
          localdom.EER = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 4: 
          localdom.EES = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147809);
          return 0;
        case 5: 
          localdom.EET = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(147809);
          return 0;
        }
        localdom.EEU = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(147809);
        return 0;
      }
      AppMethodBeat.o(147809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dom
 * JD-Core Version:    0.7.0.1
 */