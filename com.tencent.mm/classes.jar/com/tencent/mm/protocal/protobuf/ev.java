package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ev
  extends cqk
{
  public LinkedList<mt> DRp;
  public boolean DRq;
  public int DRr;
  public int enabled;
  public int oGs;
  
  public ev()
  {
    AppMethodBeat.i(103190);
    this.DRp = new LinkedList();
    AppMethodBeat.o(103190);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103191);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(103191);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.DRp);
      paramVarArgs.bl(3, this.DRq);
      paramVarArgs.aR(4, this.DRr);
      paramVarArgs.aR(5, this.enabled);
      paramVarArgs.aR(6, this.oGs);
      AppMethodBeat.o(103191);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label682;
      }
    }
    label682:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.DRp);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.bx(4, this.DRr);
      int m = f.a.a.b.b.a.bx(5, this.enabled);
      int n = f.a.a.b.b.a.bx(6, this.oGs);
      AppMethodBeat.o(103191);
      return paramInt + i + (j + 1) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DRp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(103191);
          throw paramVarArgs;
        }
        AppMethodBeat.o(103191);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ev localev = (ev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103191);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localev.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localev.DRp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103191);
          return 0;
        case 3: 
          localev.DRq = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(103191);
          return 0;
        case 4: 
          localev.DRr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103191);
          return 0;
        case 5: 
          localev.enabled = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103191);
          return 0;
        }
        localev.oGs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(103191);
        return 0;
      }
      AppMethodBeat.o(103191);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ev
 * JD-Core Version:    0.7.0.1
 */