package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgs
  extends cpx
{
  public int EOn;
  public int EWh;
  public boolean FuO;
  public String djj;
  public String path;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123636);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.d(2, this.username);
      }
      if (this.djj != null) {
        paramVarArgs.d(3, this.djj);
      }
      paramVarArgs.aR(4, this.EWh);
      if (this.path != null) {
        paramVarArgs.d(5, this.path);
      }
      paramVarArgs.aR(6, this.EOn);
      paramVarArgs.bl(7, this.FuO);
      AppMethodBeat.o(123636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label626;
      }
    }
    label626:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.username);
      }
      i = paramInt;
      if (this.djj != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.djj);
      }
      i += f.a.a.b.b.a.bx(4, this.EWh);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.path);
      }
      i = f.a.a.b.b.a.bx(6, this.EOn);
      int j = f.a.a.b.b.a.fK(7);
      AppMethodBeat.o(123636);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(123636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgs localcgs = (cgs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123636);
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
            localcgs.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123636);
          return 0;
        case 2: 
          localcgs.username = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 3: 
          localcgs.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 4: 
          localcgs.EWh = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123636);
          return 0;
        case 5: 
          localcgs.path = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(123636);
          return 0;
        case 6: 
          localcgs.EOn = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(123636);
          return 0;
        }
        localcgs.FuO = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(123636);
        return 0;
      }
      AppMethodBeat.o(123636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgs
 * JD-Core Version:    0.7.0.1
 */