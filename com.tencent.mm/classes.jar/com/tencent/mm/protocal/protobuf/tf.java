package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tf
  extends cpx
{
  public String DQt;
  public String Enm;
  public String Enn;
  public String Enp;
  public String djr;
  public int uiK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.djr != null) {
        paramVarArgs.d(2, this.djr);
      }
      if (this.Enp != null) {
        paramVarArgs.d(3, this.Enp);
      }
      if (this.DQt != null) {
        paramVarArgs.d(4, this.DQt);
      }
      paramVarArgs.aR(5, this.uiK);
      if (this.Enn != null) {
        paramVarArgs.d(6, this.Enn);
      }
      if (this.Enm != null) {
        paramVarArgs.d(7, this.Enm);
      }
      AppMethodBeat.o(72435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label658;
      }
    }
    label658:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.djr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.djr);
      }
      i = paramInt;
      if (this.Enp != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Enp);
      }
      paramInt = i;
      if (this.DQt != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DQt);
      }
      i = paramInt + f.a.a.b.b.a.bx(5, this.uiK);
      paramInt = i;
      if (this.Enn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Enn);
      }
      i = paramInt;
      if (this.Enm != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Enm);
      }
      AppMethodBeat.o(72435);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(72435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tf localtf = (tf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72435);
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
            localtf.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72435);
          return 0;
        case 2: 
          localtf.djr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 3: 
          localtf.Enp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 4: 
          localtf.DQt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72435);
          return 0;
        case 5: 
          localtf.uiK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72435);
          return 0;
        case 6: 
          localtf.Enn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72435);
          return 0;
        }
        localtf.Enm = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(72435);
        return 0;
      }
      AppMethodBeat.o(72435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tf
 * JD-Core Version:    0.7.0.1
 */