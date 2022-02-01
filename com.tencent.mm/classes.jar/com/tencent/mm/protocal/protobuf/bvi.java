package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvi
  extends cpx
{
  public int DPH;
  public LinkedList<bvk> DXh;
  public int Flg;
  public LinkedList<bvh> Flh;
  public int Fli;
  public String Flj;
  public int Scene;
  
  public bvi()
  {
    AppMethodBeat.i(127498);
    this.Flh = new LinkedList();
    this.DXh = new LinkedList();
    AppMethodBeat.o(127498);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127499);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DPH);
      paramVarArgs.aR(3, this.Flg);
      paramVarArgs.e(4, 8, this.Flh);
      paramVarArgs.aR(5, this.Fli);
      paramVarArgs.e(6, 8, this.DXh);
      if (this.Flj != null) {
        paramVarArgs.d(7, this.Flj);
      }
      paramVarArgs.aR(8, this.Scene);
      AppMethodBeat.o(127499);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label826;
      }
    }
    label826:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DPH) + f.a.a.b.b.a.bx(3, this.Flg) + f.a.a.a.c(4, 8, this.Flh) + f.a.a.b.b.a.bx(5, this.Fli) + f.a.a.a.c(6, 8, this.DXh);
      paramInt = i;
      if (this.Flj != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Flj);
      }
      i = f.a.a.b.b.a.bx(8, this.Scene);
      AppMethodBeat.o(127499);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Flh.clear();
        this.DXh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(127499);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bvi localbvi = (bvi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127499);
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
            localbvi.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 2: 
          localbvi.DPH = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127499);
          return 0;
        case 3: 
          localbvi.Flg = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127499);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvi.Flh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 5: 
          localbvi.Fli = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(127499);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bvk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bvk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbvi.DXh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127499);
          return 0;
        case 7: 
          localbvi.Flj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(127499);
          return 0;
        }
        localbvi.Scene = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127499);
        return 0;
      }
      AppMethodBeat.o(127499);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvi
 * JD-Core Version:    0.7.0.1
 */