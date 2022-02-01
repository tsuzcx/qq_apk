package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bsk
  extends cpx
{
  public int Eke;
  public long Fhp;
  public long Fhq;
  public long Fhr;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.Fhp);
      paramVarArgs.aO(3, this.Fhq);
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aR(5, this.offset);
      paramVarArgs.aR(6, this.Eke);
      paramVarArgs.aO(7, this.Fhr);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Fhp) + f.a.a.b.b.a.p(3, this.Fhq);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = f.a.a.b.b.a.bx(5, this.offset);
      int j = f.a.a.b.b.a.bx(6, this.Eke);
      int k = f.a.a.b.b.a.p(7, this.Fhr);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bsk localbsk = (bsk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
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
            localbsk.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localbsk.Fhp = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localbsk.Fhq = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localbsk.query = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localbsk.offset = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localbsk.Eke = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(169915);
          return 0;
        }
        localbsk.Fhr = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bsk
 * JD-Core Version:    0.7.0.1
 */