package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ez
  extends cpx
{
  public int DRl;
  public int DRm;
  public int DRn;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103193);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aR(3, this.scene);
      paramVarArgs.aR(4, this.DRn);
      paramVarArgs.aR(5, this.DRm);
      paramVarArgs.aR(6, this.DRl);
      if (this.session_id != null) {
        paramVarArgs.d(7, this.session_id);
      }
      AppMethodBeat.o(103193);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bx(3, this.scene) + f.a.a.b.b.a.bx(4, this.DRn) + f.a.a.b.b.a.bx(5, this.DRm) + f.a.a.b.b.a.bx(6, this.DRl);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.session_id);
      }
      AppMethodBeat.o(103193);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(103193);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ez localez = (ez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103193);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localez.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103193);
          return 0;
        case 2: 
          localez.url = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(103193);
          return 0;
        case 3: 
          localez.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103193);
          return 0;
        case 4: 
          localez.DRn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103193);
          return 0;
        case 5: 
          localez.DRm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103193);
          return 0;
        case 6: 
          localez.DRl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(103193);
          return 0;
        }
        localez.session_id = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(103193);
        return 0;
      }
      AppMethodBeat.o(103193);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ez
 * JD-Core Version:    0.7.0.1
 */