package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dmo
  extends cpx
{
  public String EuR;
  public String hkN;
  public int vTH;
  public int vTI;
  public int vTJ;
  public SKBuiltinBuffer_t vTK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90777);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.vTK == null)
      {
        paramVarArgs = new b("Not all required fields were included: Data");
        AppMethodBeat.o(90777);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hkN != null) {
        paramVarArgs.d(2, this.hkN);
      }
      paramVarArgs.aR(3, this.vTH);
      paramVarArgs.aR(4, this.vTI);
      paramVarArgs.aR(5, this.vTJ);
      if (this.vTK != null)
      {
        paramVarArgs.ln(6, this.vTK.computeSize());
        this.vTK.writeFields(paramVarArgs);
      }
      if (this.EuR != null) {
        paramVarArgs.d(7, this.EuR);
      }
      AppMethodBeat.o(90777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label766;
      }
    }
    label766:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hkN != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hkN);
      }
      i = i + f.a.a.b.b.a.bx(3, this.vTH) + f.a.a.b.b.a.bx(4, this.vTI) + f.a.a.b.b.a.bx(5, this.vTJ);
      paramInt = i;
      if (this.vTK != null) {
        paramInt = i + f.a.a.a.lm(6, this.vTK.computeSize());
      }
      i = paramInt;
      if (this.EuR != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EuR);
      }
      AppMethodBeat.o(90777);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.vTK == null)
        {
          paramVarArgs = new b("Not all required fields were included: Data");
          AppMethodBeat.o(90777);
          throw paramVarArgs;
        }
        AppMethodBeat.o(90777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmo localdmo = (dmo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(90777);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmo.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        case 2: 
          localdmo.hkN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(90777);
          return 0;
        case 3: 
          localdmo.vTH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(90777);
          return 0;
        case 4: 
          localdmo.vTI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(90777);
          return 0;
        case 5: 
          localdmo.vTJ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(90777);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmo.vTK = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(90777);
          return 0;
        }
        localdmo.EuR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(90777);
        return 0;
      }
      AppMethodBeat.o(90777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmo
 * JD-Core Version:    0.7.0.1
 */