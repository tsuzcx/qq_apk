package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbd
  extends cpx
{
  public String AYl;
  public String DXS;
  public String Fps;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91563);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DXS != null) {
        paramVarArgs.d(2, this.DXS);
      }
      if (this.Fps != null) {
        paramVarArgs.d(3, this.Fps);
      }
      if (this.AYl != null) {
        paramVarArgs.d(100, this.AYl);
      }
      AppMethodBeat.o(91563);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DXS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DXS);
      }
      i = paramInt;
      if (this.Fps != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Fps);
      }
      paramInt = i;
      if (this.AYl != null) {
        paramInt = i + f.a.a.b.b.a.e(100, this.AYl);
      }
      AppMethodBeat.o(91563);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91563);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbd localcbd = (cbd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91563);
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
            localcbd.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91563);
          return 0;
        case 2: 
          localcbd.DXS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91563);
          return 0;
        case 3: 
          localcbd.Fps = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91563);
          return 0;
        }
        localcbd.AYl = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91563);
        return 0;
      }
      AppMethodBeat.o(91563);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbd
 * JD-Core Version:    0.7.0.1
 */