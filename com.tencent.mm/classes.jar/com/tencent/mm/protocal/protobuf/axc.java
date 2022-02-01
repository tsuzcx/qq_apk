package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class axc
  extends cpx
{
  public String EPa;
  public String oGB;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.scene);
      if (this.oGB != null) {
        paramVarArgs.d(3, this.oGB);
      }
      if (this.EPa != null) {
        paramVarArgs.d(4, this.EPa);
      }
      AppMethodBeat.o(104369);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.scene);
      paramInt = i;
      if (this.oGB != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.oGB);
      }
      i = paramInt;
      if (this.EPa != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EPa);
      }
      AppMethodBeat.o(104369);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104369);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        axc localaxc = (axc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104369);
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
            localaxc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104369);
          return 0;
        case 2: 
          localaxc.scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(104369);
          return 0;
        case 3: 
          localaxc.oGB = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(104369);
          return 0;
        }
        localaxc.EPa = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(104369);
        return 0;
      }
      AppMethodBeat.o(104369);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axc
 * JD-Core Version:    0.7.0.1
 */