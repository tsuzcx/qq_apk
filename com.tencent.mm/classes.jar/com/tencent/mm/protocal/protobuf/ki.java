package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ki
  extends erp
{
  public LinkedList<Integer> YMw;
  public int vgN;
  
  public ki()
  {
    AppMethodBeat.i(127432);
    this.YMw = new LinkedList();
    AppMethodBeat.o(127432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127433);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgN);
      paramVarArgs.f(3, 2, this.YMw);
      AppMethodBeat.o(127433);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label407;
      }
    }
    label407:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.vgN);
      int j = i.a.a.a.d(3, 2, this.YMw);
      AppMethodBeat.o(127433);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YMw.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(127433);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ki localki = (ki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127433);
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
            localki.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(127433);
          return 0;
        case 2: 
          localki.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127433);
          return 0;
        }
        localki.YMw = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(127433);
        return 0;
      }
      AppMethodBeat.o(127433);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ki
 * JD-Core Version:    0.7.0.1
 */