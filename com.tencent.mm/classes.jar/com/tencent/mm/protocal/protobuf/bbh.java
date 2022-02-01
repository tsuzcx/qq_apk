package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbh
  extends erp
{
  public LinkedList<String> ABk;
  public atz CJv;
  public LinkedList<String> ZLZ;
  
  public bbh()
  {
    AppMethodBeat.i(168993);
    this.ABk = new LinkedList();
    this.ZLZ = new LinkedList();
    AppMethodBeat.o(168993);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168994);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.ABk);
      if (this.CJv != null)
      {
        paramVarArgs.qD(3, this.CJv.computeSize());
        this.CJv.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 1, this.ZLZ);
      AppMethodBeat.o(168994);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.ABk);
      paramInt = i;
      if (this.CJv != null) {
        paramInt = i + i.a.a.a.qC(3, this.CJv.computeSize());
      }
      i = i.a.a.a.c(4, 1, this.ZLZ);
      AppMethodBeat.o(168994);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ABk.clear();
        this.ZLZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168994);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bbh localbbh = (bbh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168994);
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
            localbbh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168994);
          return 0;
        case 2: 
          localbbh.ABk.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(168994);
          return 0;
        case 3: 
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
            localbbh.CJv = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(168994);
          return 0;
        }
        localbbh.ZLZ.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(168994);
        return 0;
      }
      AppMethodBeat.o(168994);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbh
 * JD-Core Version:    0.7.0.1
 */