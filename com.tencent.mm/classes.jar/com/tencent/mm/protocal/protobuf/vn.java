package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vn
  extends cpx
{
  public String EpM;
  public String EpN;
  public String EpO;
  public String EpP;
  public String EpQ;
  public String EpR;
  public int Scene;
  public String Title;
  public String hNS;
  public String hOf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hNS != null) {
        paramVarArgs.d(2, this.hNS);
      }
      if (this.Title != null) {
        paramVarArgs.d(3, this.Title);
      }
      if (this.EpM != null) {
        paramVarArgs.d(4, this.EpM);
      }
      if (this.EpN != null) {
        paramVarArgs.d(5, this.EpN);
      }
      if (this.EpO != null) {
        paramVarArgs.d(6, this.EpO);
      }
      if (this.EpP != null) {
        paramVarArgs.d(7, this.EpP);
      }
      if (this.EpQ != null) {
        paramVarArgs.d(8, this.EpQ);
      }
      if (this.hOf != null) {
        paramVarArgs.d(9, this.hOf);
      }
      paramVarArgs.aR(10, this.Scene);
      if (this.EpR != null) {
        paramVarArgs.d(11, this.EpR);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hNS != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.hNS);
      }
      i = paramInt;
      if (this.Title != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Title);
      }
      paramInt = i;
      if (this.EpM != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EpM);
      }
      i = paramInt;
      if (this.EpN != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EpN);
      }
      paramInt = i;
      if (this.EpO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EpO);
      }
      i = paramInt;
      if (this.EpP != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EpP);
      }
      paramInt = i;
      if (this.EpQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EpQ);
      }
      i = paramInt;
      if (this.hOf != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.hOf);
      }
      i += f.a.a.b.b.a.bx(10, this.Scene);
      paramInt = i;
      if (this.EpR != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EpR);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vn localvn = (vn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
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
            localvn.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localvn.hNS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localvn.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localvn.EpM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localvn.EpN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localvn.EpO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localvn.EpP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localvn.EpQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localvn.hOf = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localvn.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(63271);
          return 0;
        }
        localvn.EpR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vn
 * JD-Core Version:    0.7.0.1
 */