package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aqm
  extends cpx
{
  public LinkedList<String> EJq;
  public LinkedList<String> EJw;
  public int EJx;
  public String iKc;
  public String tju;
  
  public aqm()
  {
    AppMethodBeat.i(42638);
    this.EJw = new LinkedList();
    this.EJq = new LinkedList();
    AppMethodBeat.o(42638);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42639);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.EJw);
      paramVarArgs.e(3, 1, this.EJq);
      if (this.tju != null) {
        paramVarArgs.d(4, this.tju);
      }
      if (this.iKc != null) {
        paramVarArgs.d(5, this.iKc);
      }
      paramVarArgs.aR(6, this.EJx);
      AppMethodBeat.o(42639);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 1, this.EJw) + f.a.a.a.c(3, 1, this.EJq);
      paramInt = i;
      if (this.tju != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.tju);
      }
      i = paramInt;
      if (this.iKc != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.iKc);
      }
      paramInt = f.a.a.b.b.a.bx(6, this.EJx);
      AppMethodBeat.o(42639);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EJw.clear();
        this.EJq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(42639);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aqm localaqm = (aqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42639);
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
            localaqm.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42639);
          return 0;
        case 2: 
          localaqm.EJw.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 3: 
          localaqm.EJq.add(((f.a.a.a.a)localObject1).LVo.readString());
          AppMethodBeat.o(42639);
          return 0;
        case 4: 
          localaqm.tju = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42639);
          return 0;
        case 5: 
          localaqm.iKc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(42639);
          return 0;
        }
        localaqm.EJx = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(42639);
        return 0;
      }
      AppMethodBeat.o(42639);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqm
 * JD-Core Version:    0.7.0.1
 */