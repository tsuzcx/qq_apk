package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fbq
  extends erp
{
  public int IJG;
  public LinkedList<Integer> YMw;
  public String abBo;
  public int vgN;
  
  public fbq()
  {
    AppMethodBeat.i(127502);
    this.YMw = new LinkedList();
    AppMethodBeat.o(127502);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127503);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.abBo != null) {
        paramVarArgs.g(2, this.abBo);
      }
      paramVarArgs.bS(3, this.IJG);
      paramVarArgs.bS(4, this.vgN);
      paramVarArgs.f(5, 2, this.YMw);
      AppMethodBeat.o(127503);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label511;
      }
    }
    label511:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abBo != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abBo);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.IJG);
      int j = i.a.a.b.b.a.cJ(4, this.vgN);
      int k = i.a.a.a.d(5, 2, this.YMw);
      AppMethodBeat.o(127503);
      return i + paramInt + j + k;
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
        AppMethodBeat.o(127503);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fbq localfbq = (fbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127503);
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
            localfbq.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(127503);
          return 0;
        case 2: 
          localfbq.abBo = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(127503);
          return 0;
        case 3: 
          localfbq.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127503);
          return 0;
        case 4: 
          localfbq.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(127503);
          return 0;
        }
        localfbq.YMw = new i.a.a.a.a(((i.a.a.a.a)localObject).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
        AppMethodBeat.o(127503);
        return 0;
      }
      AppMethodBeat.o(127503);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fbq
 * JD-Core Version:    0.7.0.1
 */